package com.example.apitestch

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apitestch.API.APIClient
import com.example.apitestch.API.APIInterface
import com.example.apitestch.JSON.DICDetails
import com.example.apitestch.JSON.DICDetailsItem
import com.example.apitestch.JSON.Def
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var RVAdapter:RVAdapter

    val vm by lazy { ViewModelProvider(this).get(MyVM::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn=findViewById<Button>(R.id.searchBtn)
        var search=findViewById<EditText>(R.id.searchWord)
        var rv=findViewById<RecyclerView>(R.id.rv)

        checkInternet()



vm.getContents().observe(this,{
    contents->  RVAdapter = RVAdapter( this,contents)
    rv.adapter = RVAdapter
    rv.layoutManager = LinearLayoutManager(this)
})
        btn.setOnClickListener {

             vm.getData(search.text.toString())

        }
    }


    private fun checkInternet(){
        if(!connectedToInternet()){
            AlertDialog.Builder(this@MainActivity)
                .setTitle("Internet Connection Not Found")
                .setPositiveButton("RETRY"){_, _ -> checkInternet()}
                .show()
        }
    }

    private fun connectedToInternet(): Boolean{
        val cm = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }

}