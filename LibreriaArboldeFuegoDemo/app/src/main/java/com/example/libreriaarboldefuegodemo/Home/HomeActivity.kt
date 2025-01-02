package com.example.libreriaarboldefuegodemo.Home
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.libreriaarboldefuegodemo.Fragments.CatalogoFragment
import com.example.libreriaarboldefuegodemo.Fragments.HomeFragment
import com.example.libreriaarboldefuegodemo.Fragments.SearchFragment
import com.example.libreriaarboldefuegodemo.R // R del proyecto
import com.example.libreriaarboldefuegodemo.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val  view = binding.root
        setContentView(view)

        val firstFragment = HomeFragment()
        val secondFragment = CatalogoFragment()
        val threeFragment = SearchFragment()

        setCurrentFragment(firstFragment)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->setCurrentFragment(firstFragment)
                R.id.catalogo->setCurrentFragment(secondFragment)
                R.id.search->setCurrentFragment(threeFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
}