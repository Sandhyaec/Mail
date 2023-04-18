package com.example.sendemail2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etTo :EditText =findViewById(R.id.etTo)
        val etSubject :EditText =findViewById(R.id.etSubject)
        val etMessage :EditText =findViewById(R.id.etMessage)
        val btSend : Button =findViewById(R.id.btSend)

        btSend.setOnClickListener {
            var email =etTo.text.toString()
            var subject =etSubject.text.toString()
            var message =etMessage.text.toString()

            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL,arrayOf(email))
            intent.putExtra(Intent.EXTRA_SUBJECT,subject)
            intent.putExtra(Intent.EXTRA_TEXT,message)

            intent.type="message/rfc822"
            startActivity(Intent.createChooser(intent,"kindly choose a client"))
        }
    }
}