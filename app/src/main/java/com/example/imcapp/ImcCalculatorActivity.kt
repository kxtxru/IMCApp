package com.example.imcapp

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.slider.Slider

class ImcCalculatorActivity : AppCompatActivity() {

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var rsHeight:Slider
    private lateinit var tvHeight:TextView
    private lateinit var textEdad:TextView
    private lateinit var nEdad:TextView
    private lateinit var pesito:TextView
    private lateinit var nPesito:TextView


    private fun initComponents(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        rsHeight = findViewById(R.id.rsHeight)
        tvHeight = findViewById(R.id.tvHeight)
        textEdad = findViewById(R.id.textEdad)
        nEdad = findViewById(R.id.nEdad)
        pesito = findViewById(R.id.pesito)
        nPesito = findViewById(R.id.nPesito)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()


    }

    private fun initUI() {
        setGenderColor(false)
    }

    private fun initListeners() {
        viewMale.setOnClickListener() {setGenderColor(true)}
        viewFemale.setOnClickListener() {setGenderColor(false)}
        rsHeight.addOnChangeListener { _, value, _ ->
        tvHeight.text = "%.0f".format(value)
}
        
    }

    private fun setGenderColor(isMaleSelected:Boolean){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(!isMaleSelected))
    }

    private fun getBackgroundColor(isMaleSelected: Boolean): Int{
        val colorReference = if(isMaleSelected) {
        R.color.bg_comp_sel
        } else {
        R.color.bg_comp
        }
        return ContextCompat.getColor(this,colorReference)
    }



}