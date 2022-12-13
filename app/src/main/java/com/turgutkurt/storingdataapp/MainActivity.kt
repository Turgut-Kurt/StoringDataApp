package com.turgutkurt.storingdataapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.turgutkurt.storingdataapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences :SharedPreferences
    var age : Int? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //SharedPreferences initialize
        sharedPreferences = this.getSharedPreferences("com.turgutkurt.storingdataapp",
            Context.MODE_PRIVATE)

        age=sharedPreferences.getInt("age",-1)
        if (age==-1){
            binding.textView.text="Your Age : "
        }else{
            binding.textView.text="Your Age : ${age}"
        }
    }
    //handle save function
    fun handleSave(view:View){
        val myAge = binding.editText.text.toString().toIntOrNull()
        if (myAge!=null){
            binding.textView.text="Your Age : ${myAge}"
            sharedPreferences.edit().putInt("age",myAge).apply()
        }
    }
    fun handleDelete(view:View){
        age=sharedPreferences.getInt("age",-1)
        if (age!=-1){
            sharedPreferences.edit().remove("age").apply()
            binding.textView.text="Your Age : "
        }
    }
}