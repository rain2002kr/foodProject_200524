package com.example.foodproject_200524.DATA

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodproject_200524.R
import kotlinx.android.extensions.LayoutContainer


class Type2_model ( val txtType2_foodName:String,
              var imgType2_food:Int ,
              val txtType2_foodPrice1_text:String,
              val backColor:Int,
              val textColor:Int
){ }

class Type2_ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView) ,
    LayoutContainer
{
    val txtType2_foodName  = containerView.findViewById(R.id.txtType2_foodName) as TextView
    val imgType2_food  = containerView.findViewById(R.id.imgType2_food) as ImageView
    val txtType2_foodPrice1  = containerView.findViewById(R.id.txtType2_foodPrice1) as TextView
    val btType2_foodAdd1  = containerView.findViewById(R.id.btType2_foodAdd1) as Button
    val btType2_foodSub1  = containerView.findViewById(R.id.btType2_foodSub1) as Button
    val btType2_foodCount1  = containerView.findViewById(R.id.btType2_foodCount1) as TextView

}


class Type2_adapter(val list: MutableList<Type2_model>,val layout:Int,val context: Context) : RecyclerView.Adapter<Type2_ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Type2_ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sub_type2,parent,false)
       return Type2_ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: Type2_ViewHolder, position: Int) {
        holder.txtType2_foodName.setText(list[position].txtType2_foodName)
        holder.imgType2_food.setImageResource(list[position].imgType2_food)
        holder.txtType2_foodPrice1.setText(list[position].txtType2_foodPrice1_text)


        //<!-- 컬러 코드 -->
        //배경 색상
        holder.txtType2_foodName.setBackgroundResource(list[position].backColor)
        holder.btType2_foodAdd1.setBackgroundResource(list[position].backColor)
        holder.btType2_foodSub1.setBackgroundResource(list[position].backColor)

        //텍스트 색상
        holder.txtType2_foodName.setTextColor(list[position].textColor)

        var cnt1 = 0

        holder.btType2_foodAdd1.setOnClickListener{
            cnt1 += 1
            holder.btType2_foodCount1.setText(cnt1.toString())
        }
        holder.btType2_foodSub1.setOnClickListener{
            cnt1 -= 1
            if(cnt1 < 0) cnt1 = 0
            holder.btType2_foodCount1.setText(cnt1.toString())
        }

    }

}