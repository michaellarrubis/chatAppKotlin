package com.example.testchatapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin.setOnClickListener{
            performLogin()
        }

        goToRegisterActivity.setOnClickListener {
            finish()
        }
    }

    private fun performLogin() {
        val email = emailLogin.text.toString()
        val password = passwordLogin.text.toString()

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
    }

}