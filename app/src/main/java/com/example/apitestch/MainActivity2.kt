package com.example.apitestch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity2 : AppCompatActivity() {
    val vm by lazy { ViewModelProvider(this).get(MyVM::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        vm.getData("Name")
        vm.getContents().observe(this,{
            contents-> contents[0].def[0].dif
            println(contents)
        })
//        val contents=vm.getContents()
//        val i= contents?.value?.get(0)?.def?.get(0)?.dif
//        println(i)

    }
}