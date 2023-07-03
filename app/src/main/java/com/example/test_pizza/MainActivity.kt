package com.example.test_pizza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test_pizza.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private var layoutManager : RecyclerView.LayoutManager? = null
    private var adapter : RecyclerView.Adapter<HelperAdapter.PizzaHolder>? = null
    private fun initUI(){
        binding.toolBar1.ivBack.setOnClickListener {
            Toast.makeText(this, "Back Button Clicked",Toast.LENGTH_SHORT).show() }
        binding.toolBar1.ivCity.setOnClickListener {
            Toast.makeText(this, "City Button Clicked",Toast.LENGTH_SHORT).show() }
        binding.toolBar1.ivArrowDown.setOnClickListener {
            Toast.makeText(this, "Arrow_down Button Clicked",Toast.LENGTH_SHORT).show() }
        binding.toolBar1.ivQr.setOnClickListener {
            Toast.makeText(this, "Qr_code Button Clicked",Toast.LENGTH_SHORT).show() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initUI()

        layoutManager = LinearLayoutManager(this)
        binding.rcView.layoutManager = layoutManager

        adapter = HelperAdapter()
        binding.rcView.adapter=adapter



        val tv = findViewById<TextView>(R.id.tv)
        val b = findViewById<Button>(R.id.button5)

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com").client(client)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val pizzaApi = retrofit.create(CheckApiInterface::class.java)

        b.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val pizza = pizzaApi.getPizzaById(1)
                runOnUiThread{
                    tv.text = pizza.title
                }
            }
        }


        binding.bNav.selectedItemId = R.id.item1
        binding.bNav.setOnItemSelectedListener{

            when(it.itemId){
                R.id.item1 -> {
                    Toast.makeText(this, "item 1", Toast.LENGTH_SHORT).show() }
                R.id.item2 -> {
                    Toast.makeText(this, "item 2", Toast.LENGTH_SHORT).show() }
                R.id.item3 -> {
                    Toast.makeText(this, "item 3", Toast.LENGTH_SHORT).show() }
            }
            true
        }
    }

}


