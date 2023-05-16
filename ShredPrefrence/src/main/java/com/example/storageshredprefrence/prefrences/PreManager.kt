package com.example.storageshredprefrence.prefrences

import android.content.Context

class PreManager(context: Context) {

    private val FILE_NAME = "User"
    private val KEY_NAME = "name"
    private val KEY_EMAIL = "email"
    private val KEY_PASS = "password"
    private val KEY_ISLOGIN = "login"

    private val preference = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    private val editor = preference.edit()

    fun registerUser(name: String, email: String, password: String) {
        editor.putString(KEY_NAME, name)
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_PASS, password)
        editor.commit()
    }

    fun getEmail(): String? {
        return preference.getString(KEY_EMAIL, null)
    }

    fun getPassword(): String? {
        return preference.getString(KEY_PASS, null)
    }

    fun updateLoginStatus(status: Boolean){
        editor.putBoolean(KEY_ISLOGIN, status)
        editor.commit()
    }

    fun getLoginStatus(): Boolean {
        return preference.getBoolean(KEY_ISLOGIN, false)
    }

    fun logout(){
        editor.remove(KEY_ISLOGIN)
        editor.commit()
    }
}