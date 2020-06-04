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


class Type1_model ( val txtType1_foodName:String,
              var imgType1_food:Int ,
              val txtType1_foodPrice1_text:String,
              val txtType1_foodPrice2_text:String,
              val backColor:Int,
              val textColor:Int
){ }

class Type1_ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView) ,
    LayoutContainer
{
    val txtType1_foodName  = containerView.findViewById(R.id.txtType1_foodName) as TextView
    val imgType1_food  = containerView.findViewById(R.id.imgType1_food) as ImageView
    val txtType1_foodPrice1  = containerView.findViewById(R.id.txtType1_foodPrice1) as TextView
    val txtType1_foodPrice2  = containerView.findViewById(R.id.txtType1_foodPrice2) as TextView
    val btType1_foodAdd1  = containerView.findViewById(R.id.btType1_foodAdd1) as Button
    val btType1_foodAdd2  = containerView.findViewById(R.id.btType1_foodAdd2) as Button
    val btType1_foodSub1  = containerView.findViewById(R.id.btType1_foodSub1) as Button
    val btType1_foodSub2  = containerView.findViewById(R.id.btType1_foodSub2) as Button
    val btType1_foodCount1  = containerView.findViewById(R.id.btType1_foodCount1) as TextView
    val btType1_foodCount2  = containerView.findViewById(R.id.btType1_foodCount2) as TextView
}


class Type1_adapter(val list: MutableList<Type1_model>,val layout:Int,val context: Context) : RecyclerView.Adapter<Type1_ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Type1_ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sub_type1,parent,false)
       return Type1_ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: Type1_ViewHolder, position: Int) {
        holder.txtType1_foodName.setText(list[position].txtType1_foodName)
        holder.imgType1_food.setImageResource(list[position].imgType1_food)
        holder.txtType1_foodPrice1.setText(list[position].txtType1_foodPrice1_text)
        holder.txtType1_foodPrice2.setText(list[position].txtType1_foodPrice2_text)

        //<!-- 컬러 코드 -->
        //배경 색상
        holder.txtType1_foodName.setBackgroundResource(list[position].backColor)
        holder.btType1_foodAdd1.setBackgroundResource(list[position].backColor)
        holder.btType1_foodAdd2.setBackgroundResource(list[position].backColor)
        holder.btType1_foodSub1.setBackgroundResource(list[position].backColor)
        holder.btType1_foodSub2.setBackgroundResource(list[position].backColor)
        //텍스트 색상
        holder.txtType1_foodName.setTextColor(list[position].textColor)

        var cnt1 = 0
        var cnt2 = 0

        holder.btType1_foodAdd1.setOnClickListener{
            cnt1 += 1
            holder.btType1_foodCount1.setText(cnt1.toString())
        }
        holder.btType1_foodSub1.setOnClickListener{
            cnt1 -= 1
            if(cnt1 < 0) cnt1 = 0
            holder.btType1_foodCount1.setText(cnt1.toString())
        }
        holder.btType1_foodAdd2.setOnClickListener{
            cnt2 += 1
            holder.btType1_foodCount2.setText(cnt2.toString())
        }
        holder.btType1_foodSub2.setOnClickListener{
            cnt2 -= 1
            if(cnt2 < 0) cnt2 = 0
            holder.btType1_foodCount2.setText(cnt2.toString())
        }


    }

}