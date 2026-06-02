package com.example.fishbook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fishbook.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val settingsItems = arrayOf("Privacy Policy", "Terms of Service", "About Apps", "Rate Us", "Contact Support")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, settingsItems)
        
        binding.lvSettings.adapter = adapter

        binding.lvSettings.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = settingsItems[position]
            Toast.makeText(requireContext(), "Membuka $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}