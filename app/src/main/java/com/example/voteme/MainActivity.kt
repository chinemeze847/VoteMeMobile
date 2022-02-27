package com.example.voteme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.voteme.databinding.LoginFormBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity()
{
    private lateinit var binding : LoginFormBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = LoginFormBinding.inflate(layoutInflater)
        val view = binding.root

        binding.signUp.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.loginbtn.setOnClickListener{
            val intent = Intent(this, Candidate::class.java)
            startActivity(intent)
        }

        setContentView(view)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean
    {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        val constraintLayout = binding.constraintLayout
        when(item.itemId){
            R.id.favorite ->Snackbar.make(constraintLayout, "You clicked on favorites", Snackbar.LENGTH_SHORT)
                .show()
            R.id.setting -> Snackbar.make(constraintLayout, "You clicked on settings", Snackbar.LENGTH_SHORT)
                .show()
            else -> Snackbar.make(constraintLayout, "You clicked on others", Snackbar.LENGTH_SHORT)
                .show()
        }
        return true
    }
}