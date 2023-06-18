package com.example.test_pizza


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil

import com.example.test_pizza.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initUI()



        binding.bNav.selectedItemId = R.id.item1


        binding.bNav.setOnItemSelectedListener{

            when(it.itemId){
                R.id.item1 -> {
                    Toast.makeText(this, "item 1", Toast.LENGTH_SHORT).show()
                }
                R.id.item2 -> {
                    Toast.makeText(this, "item 2", Toast.LENGTH_SHORT).show()
                }
                R.id.item3 -> {
                    Toast.makeText(this, "item 3", Toast.LENGTH_SHORT).show()
                }
            }

            true
        }


    }
         private fun initUI(){
             binding.toolBar1.ivBack.setOnClickListener {

        Toast.makeText(this, "Back Button Clicked",Toast.LENGTH_SHORT).show()
}
            binding.toolBar1.ivCity.setOnClickListener {

                Toast.makeText(this, "City Button Clicked",Toast.LENGTH_SHORT).show()
            }
             binding.toolBar1.ivArrowDown.setOnClickListener {

                 Toast.makeText(this, "Arrow_down Button Clicked",Toast.LENGTH_SHORT).show()
             }
             binding.toolBar1.ivQr.setOnClickListener {

                 Toast.makeText(this, "Qr_code Button Clicked",Toast.LENGTH_SHORT).show()
             }
    }
}