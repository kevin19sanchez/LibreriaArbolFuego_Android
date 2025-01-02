package com.example.libreriaarboldefuegodemo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.libreriaarboldefuegodemo.Fragments.HomeFragment.RetrofitInstance
import com.example.libreriaarboldefuegodemo.Interface.BookService
import com.example.libreriaarboldefuegodemo.R
import com.example.libreriaarboldefuegodemo.databinding.FragmentCatalogoBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CatalogoFragment : Fragment() {

    private lateinit var binding: FragmentCatalogoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentCatalogoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    object RetrofitInstance{
        private const val BASE_URL = ""

        val api: BookService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BookService::class.java)
        }
    }

}