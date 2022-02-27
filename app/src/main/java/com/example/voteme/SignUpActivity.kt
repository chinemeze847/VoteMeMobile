package com.example.voteme

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.voteme.databinding.SignUpFormBinding

class SignUpActivity : AppCompatActivity()
{
    private lateinit var binding : SignUpFormBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = SignUpFormBinding.inflate(layoutInflater)
        val view = binding.root
        val actionBar = this.supportActionBar

        if (actionBar != null) {

            // Customize the back button
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow)

            // showing the back button in action bar
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        setContentView(view)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }


}