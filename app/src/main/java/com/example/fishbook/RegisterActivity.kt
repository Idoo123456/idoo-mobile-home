package com.example.fishbook

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fishbook.databinding.ActivityRegisterBinding
import java.util.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDatePicker()
        setupAgamaDropdown()

        binding.btnRegister.setOnClickListener {
            validateAndRegister()
        }

        binding.tvBackToLogin.setOnClickListener {
            finish()
        }
    }

    private fun setupDatePicker() {
        val calendar = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            val myFormat = "dd/MM/yyyy"
            val sdf = java.text.SimpleDateFormat(myFormat, Locale.US)
            binding.etRegTanggalLahir.setText(sdf.format(calendar.time))
            binding.tilRegTanggalLahir.error = null
        }

        binding.etRegTanggalLahir.setOnClickListener {
            DatePickerDialog(
                this,
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun setupAgamaDropdown() {
        val agamaList = arrayOf("Islam", "Kristen Protestan", "Katolik", "Hindu", "Buddha", "Khonghucu")
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, agamaList)
        binding.actvAgama.setAdapter(adapter)
        binding.actvAgama.setOnItemClickListener { _, _, _, _ ->
            binding.tilRegAgama.error = null
        }
    }

    private fun validateAndRegister() {
        val nama = binding.etRegNama.text.toString().trim()
        val tanggalLahir = binding.etRegTanggalLahir.text.toString().trim()
        val username = binding.etRegUsername.text.toString().trim()
        val password = binding.etRegPassword.text.toString().trim()
        val confirmPassword = binding.etRegConfirmPassword.text.toString().trim()
        val agama = binding.actvAgama.text.toString().trim()
        val selectedGenderId = binding.rgGender.checkedRadioButtonId

        var isValid = true

        // Reset Errors
        binding.tilRegNama.error = null
        binding.tilRegTanggalLahir.error = null
        binding.tilRegAgama.error = null
        binding.tilRegUsername.error = null
        binding.tilRegPassword.error = null
        binding.tilRegConfirmPassword.error = null

        // Cek Input Kosong dan Value
        if (nama.isEmpty()) {
            binding.tilRegNama.error = "Nama tidak boleh kosong"
            isValid = false
        } else if (nama.length < 3) {
            binding.tilRegNama.error = "Nama terlalu pendek"
            isValid = false
        }

        if (tanggalLahir.isEmpty()) {
            binding.tilRegTanggalLahir.error = "Tanggal lahir belum dipilih"
            isValid = false
        }

        if (selectedGenderId == -1) {
            Toast.makeText(this, "Pilih jenis kelamin", Toast.LENGTH_SHORT).show()
            isValid = false
        }

        if (agama.isEmpty()) {
            binding.tilRegAgama.error = "Pilih agama"
            isValid = false
        }

        if (username.isEmpty()) {
            binding.tilRegUsername.error = "Username tidak boleh kosong"
            isValid = false
        } else if (username.length < 4) {
            binding.tilRegUsername.error = "Username minimal 4 karakter"
            isValid = false
        }

        if (password.isEmpty()) {
            binding.tilRegPassword.error = "Password tidak boleh kosong"
            isValid = false
        } else if (password.length < 6) {
            binding.tilRegPassword.error = "Password minimal 6 karakter"
            isValid = false
        }

        if (confirmPassword.isEmpty()) {
            binding.tilRegConfirmPassword.error = "Konfirmasi password tidak boleh kosong"
            isValid = false
        } else if (password != confirmPassword) {
            binding.tilRegConfirmPassword.error = "Password tidak cocok"
            isValid = false
        }

        if (isValid) {
            val gender = findViewById<RadioButton>(selectedGenderId).text.toString()
            
            // Simpan ke SharedPreferences
            val sharedPref = getSharedPreferences("BinaDesaPref", Context.MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("REG_NAMA", nama)
                putString("REG_TANGGAL", tanggalLahir)
                putString("REG_GENDER", gender)
                putString("REG_AGAMA", agama)
                putString("REG_USERNAME", username)
                putString("REG_PASSWORD", password)
                apply()
            }

            Toast.makeText(this, "Registrasi Berhasil! Silakan Login", Toast.LENGTH_LONG).show()
            finish()
        }
    }
}