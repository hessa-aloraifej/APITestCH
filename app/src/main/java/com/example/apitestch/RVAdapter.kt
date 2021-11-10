package com.example.apitestch

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RVAdapter( var activity:Context ,var list: List<MyDic>):  RecyclerView.Adapter<RVAdapter.ItemViewHolder>(){



    class ItemViewHolder (itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var data = list[position]
       // var list1=list[position].meanings[0].definitions[0].definition

        //  var l=list[position].byline.person[position]

        holder.itemView.apply {

            textView.text = "${data.word}"
            textView2.text=data.def[0].dif

            lmain.setOnClickListener {
                val intent= Intent (activity, MainActivity2::class.java)

                activity.startActivity(intent)

            }
         // textView2.text = list.toString()



        }
    }

    override fun getItemCount() = list.size

    fun update(list: List<MyDic>){
       this.list = list
        notifyDataSetChanged()
    }





}