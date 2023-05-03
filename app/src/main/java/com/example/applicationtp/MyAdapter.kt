package com.example.applicationtp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationtp.databinding.FragmentAboutUsBinding

class MyAdapter (val maListe :List<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val ItemView = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return MyViewHolder(ItemView)
    }

    override fun getItemCount(): Int {
        return maListe.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        for(item in maListe){
            holder.textView.text= "${maListe[position]}"
        }
    }
}