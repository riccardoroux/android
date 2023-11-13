package com.example.riccardo_roux_cinefacts.views

// LoginActivity.kt
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.riccardo_roux_cinefacts.R

class LoginActivity : AppCompatActivity() {

    // Credenziali consentite
    private val allowedUsername = "schemaponzi777"
    private val allowedPassword = "test1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText: EditText = findViewById(R.id.editTextUsername)
        val passwordEditText: EditText = findViewById(R.id.editTextPassword)
        val loginButton: Button = findViewById(R.id.buttonLogin)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (isValidCredentials(username, password)) {
                // Login avvenuto con successo, passa alla schermata successiva
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish() // Chiudi la schermata di login per evitare il ritorno indietro
            } else {
                // Credenziali non valide, mostra un messaggio di errore
                showToast("Username e/o Password non validi")
            }
        }
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        // Verifica se le credenziali sono corrette
        return username == allowedUsername && password == allowedPassword
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
