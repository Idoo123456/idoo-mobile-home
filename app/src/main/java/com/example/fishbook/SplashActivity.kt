package com.example.fishbook

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val webView = findViewById<WebView>(R.id.splashWebView)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        
        // Memuat HTML animasi SIPAWA Bina Desa
        val htmlData = """
        <!DOCTYPE html>
        <html lang="id"><head>
        <meta charset="utf-8"/>
        <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
        <script src="https://cdn.tailwindcss.com?plugins=forms,container-queries"></script>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&amp;display=swap" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:wght,FILL@100..700,0..1&amp;display=swap" rel="stylesheet"/>
        <script id="tailwind-config">
                tailwind.config = {
                    darkMode: "class",
                    theme: {
                        extend: {
                            "colors": {
                                "primary-fixed-dim": "#c0c1ff",
                                "background": "#f8f9ff",
                                "on-secondary": "#ffffff",
                                "on-primary-container": "#fffbff",
                                "outline": "#767586",
                                "primary-container": "#6063ee",
                                "secondary-fixed": "#e0e0ff",
                                "error": "#ba1a1a",
                                "secondary-fixed-dim": "#bdc2ff",
                                "surface-container-high": "#dce9ff",
                                "surface-container-lowest": "#ffffff",
                                "on-error": "#ffffff",
                                "primary": "#4648d4",
                                "surface-container": "#e5eeff",
                                "inverse-on-surface": "#eaf1ff",
                                "on-tertiary-fixed": "#181c1f",
                                "on-primary": "#ffffff",
                                "tertiary-fixed": "#e0e3e7",
                                "surface-dim": "#cbdbf5",
                                "outline-variant": "#c7c4d7",
                                "surface-container-highest": "#d3e4fe",
                                "inverse-surface": "#213145",
                                "surface-tint": "#494bd6",
                                "on-secondary-fixed": "#000767",
                                "surface-bright": "#f8f9ff",
                                "inverse-primary": "#c0c1ff",
                                "on-secondary-fixed-variant": "#2f3aa3",
                                "on-background": "#0b1c30",
                                "tertiary-container": "#717579",
                                "on-primary-fixed": "#07006c",
                                "on-secondary-container": "#17228f",
                                "primary-fixed": "#e1e0ff",
                                "on-error-container": "#93000a",
                                "on-surface": "#0b1c30",
                                "surface": "#f8f9ff",
                                "surface-container-low": "#eff4ff",
                                "error-container": "#ffdad6",
                                "on-tertiary-fixed-variant": "#43474b",
                                "tertiary-fixed-dim": "#c3c7cb",
                                "secondary": "#4953bc",
                                "on-tertiary": "#ffffff",
                                "surface-variant": "#d3e4fe",
                                "on-surface-variant": "#464554",
                                "on-tertiary-container": "#fcfcff",
                                "secondary-container": "#8792fe",
                                "on-primary-fixed-variant": "#2f2ebe",
                                "tertiary": "#585c60"
                            },
                            "borderRadius": {
                                "DEFAULT": "0.25rem",
                                "lg": "0.5rem",
                                "xl": "0.75rem",
                                "full": "9999px"
                            },
                            "spacing": {
                                "base": "8px",
                                "lg": "48px",
                                "sm": "12px",
                                "margin": "32px",
                                "xl": "80px",
                                "xs": "4px",
                                "gutter": "24px",
                                "md": "24px"
                            },
                            "fontFamily": {
                                "label-md": ["Inter"],
                                "h1": ["Inter"],
                                "body-lg": ["Inter"],
                                "h2": ["Inter"],
                                "h3": ["Inter"],
                                "caption": ["Inter"],
                                "body-md": ["Inter"]
                            },
                            "fontSize": {
                                "label-md": ["14px", {"lineHeight": "1.2", "letterSpacing": "0.05em", "fontWeight": "500"}],
                                "h1": ["48px", {"lineHeight": "1.2", "letterSpacing": "-0.02em", "fontWeight": "700"}],
                                "body-lg": ["18px", {"lineHeight": "1.6", "fontWeight": "400"}],
                                "h2": ["32px", {"lineHeight": "1.3", "letterSpacing": "-0.01em", "fontWeight": "600"}],
                                "h3": ["24px", {"lineHeight": "1.4", "fontWeight": "600"}],
                                "caption": ["12px", {"lineHeight": "1.4", "fontWeight": "400"}],
                                "body-md": ["16px", {"lineHeight": "1.6", "fontWeight": "400"}]
                            }
                        },
                    },
                }
            </script>
        <style>
                .material-symbols-outlined {
                    font-variation-settings: 'FILL' 0, 'wght' 400, 'GRAD' 0, 'opsz' 48;
                }
                .splash-gradient {
                    background: radial-gradient(circle at 50% 50%, #f8f9ff 0%, #eef2ff 100%);
                }
                .pattern-overlay {
                    background-image: url("data:image/svg+xml,%3Csvg width='60' height='60' viewBox='0 0 60 60' xmlns='http://www.w3.org/2000/svg'%3E%3Cg fill='none' fill-rule='evenodd'%3E%3Cg fill='%236366f1' fill-opacity='0.03'%3E%3Cpath d='M36 34v-4h-2v4h-4v2h4v4h2v-4h4v-2h-4zm0-30V0h-2v4h-4v2h4v4h2V6h4V4h-4zM6 34v-4H4v4H0v2h4v4h2v-4h4v-2H6zM6 4V0H4v4H0v2h4v4h2V6h4V4H6z'/%3E%3C/g%3E%3C/g%3E%3C/svg%3E");
                }
            </style>
        <style>
            body {
              min-height: max(884px, 100dvh);
              margin: 0;
            }
          
            @keyframes progress-slide {
              0% { transform: translateX(-100%); }
              100% { transform: translateX(300%); }
            }
            .animate-progress-slide {
              animation: progress-slide 1.5s infinite ease-in-out;
            }
          </style>
        </head>
        <body class="bg-background text-on-background font-body-md splash-gradient overflow-hidden">
        <!-- Main Content Canvas -->
        <main class="relative min-h-screen flex flex-col items-center justify-between pattern-overlay">
        <!-- Decoration Elements -->
        <div class="absolute top-[-10%] right-[-10%] w-80 h-80 bg-primary/5 rounded-full blur-3xl"></div>
        <div class="absolute bottom-[-5%] left-[-5%] w-64 h-64 bg-secondary/5 rounded-full blur-3xl"></div>
        <!-- Center Content -->
        <div class="flex-1 flex flex-col items-center justify-center px-margin text-center">
        <!-- Logo Section -->
        <div class="relative mb-8">
        <div class="w-32 h-32 bg-white rounded-3xl shadow-[0_8px_30px_rgb(99,102,241,0.12)] flex items-center justify-center relative overflow-hidden border border-white">
        <!-- Geometric Logo Inspired by Hands/People -->
        <div class="relative flex items-center justify-center"><div class="absolute w-16 h-16 bg-primary/10 rounded-full animate-pulse"></div><img alt="SIPAWA Logo" class="relative z-10 w-24 h-24 object-contain" src="https://lh3.googleusercontent.com/aida/ADBb0uh2LuKetKgCz8Wx6Dy_vRmefzfS1TEdT3V6z1TqEwwi28EnIN6b5ZH0xQeaCJjNGYVWfCdxFI0huM4zKt3I-QReWbg_0k5lkMCjtdtjHHSK77oNO-ZCmCxuK6p_88NmzhjUgMxPHrsD3AZKZwJgLdKFHHJTHiwaVAjts5PvSjTc-zXROVvgiFRbWDZlveaiYODxbkPhy3YtWSZtvhgXWBt6IU_fg_8xXAbLPyAR75QwTVy6B-ZkhHYNtzMIITruvSCm-O9-bKlLVA"/></div>
        </div>
        <!-- Subtle indicator dot -->
        <div class="absolute -bottom-2 -right-2 w-6 h-6 bg-primary border-4 border-white rounded-full"></div>
        </div>
        <!-- Branding Text -->
        <div class="space-y-4">
        <h1 class="font-h1 text-primary tracking-tight" style="font-size: 48px; font-weight: 700;">SIPAWA</h1>
        <div class="flex flex-col items-center">
        <div class="h-[2px] w-12 bg-primary-fixed-dim rounded-full mb-4"></div>
        <p class="font-label-md text-on-surface-variant max-w-xs leading-relaxed uppercase tracking-[0.1em]">
                                Sistem Pengaduan Warga<br/>
        <span class="text-primary font-bold">Bina Desa</span>
        </p>
        </div>
        </div>
        <!-- Modern Progress Loader -->
        <div class="mt-16 w-48 h-1.5 bg-surface-container rounded-full overflow-hidden relative">
        <div class="absolute top-0 left-0 h-full w-1/3 bg-primary rounded-full animate-progress-slide"></div>
        </div>
        </div>
        <!-- Footer Branding -->
        <footer class="pb-xl flex flex-col items-center space-y-4" style="padding-bottom: 80px;">
        <div class="flex items-center space-y-2 flex-col">
        <p class="font-caption text-outline-variant">Brought to you by</p>
        <div class="flex items-center space-x-3 grayscale opacity-60">
        <div class="flex items-center space-x-2">
        <span class="material-symbols-outlined text-[20px] text-tertiary">account_balance</span>
        <span class="font-label-md text-tertiary font-bold">Bina Desa Project</span>
        </div>
        </div>
        </div>
        <!-- Safe Area Bottom Inset -->
        <div class="h-4"></div>
        </footer>
        </main>
        </body></html>
        """.trimIndent()

        webView.loadDataWithBaseURL(null, htmlData, "text/html", "UTF-8", null)

        // Pindah setelah 5 detik agar animasi terlihat
        Handler(Looper.getMainLooper()).postDelayed({
            checkLoginStatus()
        }, 5000)
    }

    private fun checkLoginStatus() {
        val sharedPref = getSharedPreferences("BinaDesaPref", Context.MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLogin", false)

        if (isLogin) {
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            startActivity(Intent(this, AuthActivity::class.java))
        }
        finish()
    }
}