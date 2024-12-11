package com.example.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view.Movies
import com.google.android.material.imageview.ShapeableImageView



    class MyAdapter (private val movielist : ArrayList<Movies>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
            return MyViewHolder(itemView)
        }

        override fun getItemCount(): Int {
            return movielist.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val currentitem = movielist[position]
            holder.imageview.setImageResource(currentitem.image)
            holder.rate.text=currentitem.rate
            holder.des.text=currentitem.descriptiond
            holder.title.text=currentitem.title

        }
        class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val imageview : ShapeableImageView = itemView.findViewById(R.id.moviepic)
            val des : TextView = itemView.findViewById(R.id.descriptionv)
            val rate : TextView = itemView.findViewById(R.id.rate)
            val title: TextView = itemView.findViewById(R.id.title)

        }

    }




