package com.example.learningcontractapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate

object ThemeManager {
    private const val PREFS_NAME = "theme_prefs"
    private const val KEY_THEME_MODE = "theme_mode"
    
    // Theme modes
    const val THEME_LIGHT = AppCompatDelegate.MODE_NIGHT_NO
    const val THEME_DARK = AppCompatDelegate.MODE_NIGHT_YES
    const val THEME_SYSTEM = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
    
    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
    
    /**
     * Save the theme mode to SharedPreferences
     */
    fun saveThemeMode(context: Context, themeMode: Int) {
        getPreferences(context).edit()
            .putInt(KEY_THEME_MODE, themeMode)
            .apply()
    }
    
    /**
     * Get the saved theme mode from SharedPreferences
     */
    fun getSavedThemeMode(context: Context): Int {
        return getPreferences(context).getInt(KEY_THEME_MODE, THEME_SYSTEM)
    }
    
    /**
     * Apply the saved theme mode
     */
    fun applySavedTheme(context: Context) {
        val savedTheme = getSavedThemeMode(context)
        AppCompatDelegate.setDefaultNightMode(savedTheme)
    }
    
    /**
     * Toggle between light and dark theme
     */
    fun toggleTheme(context: Context) {
        val currentTheme = getSavedThemeMode(context)
        val newTheme = when (currentTheme) {
            THEME_LIGHT -> THEME_DARK
            THEME_DARK -> THEME_LIGHT
            THEME_SYSTEM -> {
                // If system theme, check current night mode and toggle opposite
                val currentNightMode = AppCompatDelegate.getDefaultNightMode()
                if (currentNightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                    THEME_LIGHT
                } else {
                    THEME_DARK
                }
            }
            else -> THEME_LIGHT
        }
        
        saveThemeMode(context, newTheme)
        AppCompatDelegate.setDefaultNightMode(newTheme)
    }
    
    /**
     * Check if current theme is dark
     */
    fun isDarkTheme(context: Context): Boolean {
        return when (getSavedThemeMode(context)) {
            THEME_DARK -> true
            THEME_LIGHT -> false
            THEME_SYSTEM -> {
                val currentNightMode = context.resources.configuration.uiMode and 
                    android.content.res.Configuration.UI_MODE_NIGHT_MASK
                currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES
            }
            else -> false
        }
    }
}
