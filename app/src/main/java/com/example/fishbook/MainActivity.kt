package com.example.fishbook

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.fishbook.pertemuan_4.FourthActivity
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup Toolbar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Inisialisasi View
        val ivPromoImage = findViewById<ImageView>(R.id.ivPromoImage)
        val btnWebView = findViewById<MaterialCardView>(R.id.btnWebView)
        val cardDashboard = findViewById<MaterialCardView>(R.id.cardDashboard)
        val tvUserGreeting = findViewById<TextView>(R.id.tvUserGreeting)

        // Ambil data nama dari SharedPreferences
        val sharedPref = getSharedPreferences("BinaDesaPref", Context.MODE_PRIVATE)
        val userName = sharedPref.getString("USER_NAME", "User")
        tvUserGreeting.text = "Halo, $userName!"

        // Gunakan logo lokal yang ada di drawable (logo_sipawa)
        ivPromoImage.setImageResource(R.drawable.logo_sipawa)

        // Klik ke Web View
        btnWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }

        // Klik Card Dashboard
        cardDashboard.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_profile -> {
                showProfileDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showProfileDialog() {
        val sharedPref = getSharedPreferences("BinaDesaPref", Context.MODE_PRIVATE)
        val userName = sharedPref.getString("USER_NAME", "User")
        
        AlertDialog.Builder(this)
            .setTitle("Profil Pengguna")
            .setMessage("Nama: $userName\nSistem Pengaduan SIPAWA")
            .setPositiveButton("OK", null)
            .setNegativeButton("Logout") { _, _ ->
                with(sharedPref.edit()) {
                    putBoolean("isLogin", false)
                    apply()
                }
                val intent = Intent(this, AuthActivity::class.java)
                startActivity(intent)
                finish()
            }
            .show()
    }
}