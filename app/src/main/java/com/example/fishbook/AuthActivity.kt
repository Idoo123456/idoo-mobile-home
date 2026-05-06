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
            val usernameInput = binding.etUsername.text.toString().trim()
            val passwordInput = binding.etPassword.text.toString().trim()

            if (usernameInput.isEmpty()) {
                binding.tilUsername.error = "Username tidak boleh kosong"
                return@setOnClickListener
            } else {
                binding.tilUsername.error = null
            }

            if (passwordInput.isEmpty()) {
                binding.tilPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            } else {
                binding.tilPassword.error = null
            }

            // Ambil data dari SharedPreferences yang disimpan saat registrasi
            val sharedPref = getSharedPreferences("BinaDesaPref", Context.MODE_PRIVATE)
            val storedUsername = sharedPref.getString("REG_USERNAME", null)
            val storedPassword = sharedPref.getString("REG_PASSWORD", null)

            // Logika 2 Aturan Login
            val isRulePassEqualsUser = (usernameInput == passwordInput)
            val isRuleMatchesSP = (usernameInput == storedUsername && passwordInput == storedPassword)

            if (isRulePassEqualsUser || isRuleMatchesSP) {
                // Simpan status login
                with(sharedPref.edit()) {
                    putBoolean("isLogin", true)
                    putString("USER_NAME", usernameInput)
                    apply()
                }

                Toast.makeText(this, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Gagal Masuk")
                    .setMessage("Username atau Password salah. Gunakan password yang sama dengan username atau daftar akun baru.")
                    .setPositiveButton("Coba Lagi", null)
                    .show()
            }
        }

        binding.tvGoToRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}