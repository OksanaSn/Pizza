package com.example.test_pizza


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.test_pizza.databinding.ActivityMainBinding
import org.json.JSONArray
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var arr = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initUI()
        init()
//        read_json()


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
    private var adapter = PizzaAdapter()
    private val nameList = listOf(
        R.drawable.pizza1,
        R.drawable.pizza2,
        R.drawable.pizza3,
        R.drawable.pizza4)
    private fun init(){

     binding.apply {

        rcView.layoutManager = LinearLayoutManager(this@MainActivity)
         rcView.adapter = adapter
         //adapter.addPizza()
    }}
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



    /*fun read_json(){
        var json : String ? = null

        try {
            val inputStream : InputStream = assets.open("pizza_data.json")
            json = inputStream.bufferedReader().use {it.readText()}
            var jsonarr = JSONArray(json)

            for (i in 0..jsonarr.length()-1)
            {
                var jsonobj = jsonarr.getJSONObject(i)
                arr.add(jsonobj.getString("name"))

            }

            //var adpt
            //id = json
        }
        catch (e: IOException){}
    }*/
}


