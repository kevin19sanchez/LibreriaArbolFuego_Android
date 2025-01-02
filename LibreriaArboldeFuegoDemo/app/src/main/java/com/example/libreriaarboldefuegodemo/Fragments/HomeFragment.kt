package com.example.libreriaarboldefuegodemo.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libreriaarboldefuegodemo.Adapter.HomeFragmentAdapter
import com.example.libreriaarboldefuegodemo.Interface.BookService
import com.example.libreriaarboldefuegodemo.Model.Book
import com.example.libreriaarboldefuegodemo.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeFragment : Fragment() {

    private lateinit var recycler: RecyclerView
    private  lateinit var binding: FragmentHomeBinding

    ////// para crear vista
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Infla el layout del fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    /////// Funcion para los componentes de la vista
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler = binding.recyclerHome
        recycler.layoutManager = LinearLayoutManager(this.activity)


        obtenerLibros()
        //testConection()
    }

    private fun testConection() {
        RetrofitInstance.api.getBooks().enqueue(object : Callback<List<Book>>{

            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                Log.d("API_STATUS", "Codigo de Respuesta: ${response.code()}")
                Log.d("API_STATUS", "Mensaje de Respuesta: ${response.message()}")

                if (response.isSuccessful) {
                    val libros = response.body()
                    Log.e("API_STATUS", "Libros Recibidos: ${libros?.size}")
                    libros?.forEach{libro ->
                        Log.e("API_STATUS", "Libro: ${libro.title}")
                    }
                } else {
                    val errorBody = response.errorBody()?.string()
                    Log.e("API_STATUS", "Error body: ${errorBody}")
                }
            }

            override fun onFailure(p0: Call<List<Book>>, p1: Throwable) {
                Log.e("API_STATUS", "No se pudo conectar al servidor: ${p1.message}")
            }
        })
    }

    private fun obtenerLibros(){
        RetrofitInstance.api.getBooks().enqueue(object : Callback<List<Book>>{
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                if (response.isSuccessful) {
                    val books = response.body() ?: emptyList()
                    recycler.adapter = HomeFragmentAdapter(requireContext(), books)
                    binding.txtPrueba.text = "Conexion Hecha"
                } else {
                    Toast.makeText(context, "Error al cargar datos del libro", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    object RetrofitInstance {
            private const val BASE_URL = "http://192.168.0.130:8000/"


        val api: BookService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BookService::class.java)
        }
    }

}

//"192.168.0.130"
//172.16.7.173