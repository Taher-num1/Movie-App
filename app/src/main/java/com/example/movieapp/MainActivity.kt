package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
        lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.button2.setOnClickListener {
            val userName = binding.userNameText.text
            val passWord = binding.passWordText.text
            val intent = Intent(applicationContext,BestTen::class.java)
            intent.putExtra("US",userName.toString())
            if(userName != null && passWord.length>7){
                Toast.makeText(this,"Log in successfully",Toast.LENGTH_LONG).show()
                startActivity(intent)
                finish()

            }
            else
                Toast.makeText(this,"Log in failed",Toast.LENGTH_LONG).show()
        }
    }

}