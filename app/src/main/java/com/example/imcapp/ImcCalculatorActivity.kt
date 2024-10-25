package com.example.imcapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
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
    private lateinit var btnAddWeight:FloatingActionButton
    private lateinit var btnSubtractWeight:FloatingActionButton
    private lateinit var btnAddAge:FloatingActionButton
    private lateinit var btnSubtractAge:FloatingActionButton


    private var weight:Int = 0
    private var age:Int = 0

    private fun initComponents(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        rsHeight = findViewById(R.id.rsHeight)
        tvHeight = findViewById(R.id.tvHeight)
        textEdad = findViewById(R.id.textEdad)
        nEdad = findViewById(R.id.nEdad)
        pesito = findViewById(R.id.pesito)
        nPesito = findViewById(R.id.nPesito)
        btnAddWeight = findViewById(R.id.btnAddWeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnAddAge = findViewById(R.id.btnAddAge)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)

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
        setAge(age)
        setWeight(weight)
    }

    private fun initListeners() {
        viewMale.setOnClickListener() {setGenderColor(true)}
        viewFemale.setOnClickListener() {setGenderColor(false)}
        rsHeight.addOnChangeListener { _, value, _ ->
        tvHeight.text = "%.0f".format(value) + "cm"}
        btnAddAge.setOnClickListener() {
            age++
            setAge(age)
        }
        btnAddWeight.setOnClickListener() {
            weight++
            setWeight(weight)
        }

        btnAddWeight.setOnClickListener() {
            if (weight > 0 && weight < 500)  weight++ // Asegúrate de que no baje de 0
            nPesito.text = weight.toString()
        }

        btnSubtractWeight.setOnClickListener() {
            if (weight > 0) weight-- // Asegúrate de que no baje de 0
            nPesito.text = weight.toString()
        }

        btnSubtractAge.setOnClickListener() {
            if (age > 0) age-- // Asegúrate de que no baje de 0
            setAge(age)
        }

    }

    private fun setWeight(weight: Int) {
        nPesito.text = weight.toString()
    }


    private fun setAge(age: Int) {
        nEdad.text = age.toString()
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