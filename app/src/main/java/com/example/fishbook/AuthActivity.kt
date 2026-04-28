package com.example.fishbook

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.fishbook.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (username == password) {
                // Simpan status login ke SharedPreferences
                val sharedPref = getSharedPreferences("BinaDesaPref", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putBoolean("isLogin", true)
                    putString("USER_NAME", username)
                    apply()
                }

                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Gagal Masuk")
                    .setMessage("Silahkan coba lagi.\n(Pastikan Username dan Password SAMA)")
                    .setPositiveButton("Coba Lagi", null)
                    .show()
            }
        }
    }
}