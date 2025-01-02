package com.example.libreriaarboldefuegodemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.libreriaarboldefuegodemo.Fragments.CatalogoFragment
import com.example.libreriaarboldefuegodemo.Fragments.HomeFragment
import com.example.libreriaarboldefuegodemo.Fragments.SearchFragment
import com.example.libreriaarboldefuegodemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}