package com.example.testchatapp.registerLogin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testchatapp.R
import com.example.testchatapp.messages.LatestMessageActivity
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

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText( this, "Kinahanglanon jud ang Email og Password!", Toast.LENGTH_SHORT).show()
            return
        }

        buttonLogin.text = "Paghuwat Sa Ha..."
        buttonLogin.isClickable = false

        val ref = FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)

        ref.addOnSuccessListener {
                val intent = Intent(this, LatestMessageActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                Toast.makeText( this, "Paglipay kay nakasulod naka!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener{
                buttonLogin.text = "Pasudla ko!"
                buttonLogin.isClickable = true
                Toast.makeText( this, it.message, Toast.LENGTH_SHORT).show()
            }
    }

}