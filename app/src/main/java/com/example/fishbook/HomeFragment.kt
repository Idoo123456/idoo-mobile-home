package com.example.fishbook

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fishbook.databinding.FragmentHomeBinding
import com.example.fishbook.pertemuan_4.FourthActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil data nama dari SharedPreferences
        val sharedPref = requireActivity().getSharedPreferences("BinaDesaPref", Context.MODE_PRIVATE)
        val userName = sharedPref.getString("USER_NAME", "User")
        binding.tvUserGreeting.text = "Halo, $userName!"

        // Set Image Resource
        binding.ivPromoImage.setImageResource(R.drawable.logo_sipawa)

        // Klik ke Web View
        binding.btnWebView.setOnClickListener {
            val intent = Intent(requireContext(), WebViewActivity::class.java)
            startActivity(intent)
        }

        // Klik Card Dashboard (Data Bus)
        binding.cardDashboard.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
