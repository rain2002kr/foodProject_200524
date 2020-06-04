package com.example.foodproject_200524.MENU.special_menu

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodproject_200524.DATA.Type1_adapter
import com.example.foodproject_200524.DATA.Type1_model
import com.example.foodproject_200524.R
import kotlinx.android.synthetic.main.fragment_special1.*

class Special1Fragment : Fragment() {
    val list :MutableList<Type1_model> by lazy {
        mutableListOf<Type1_model>(
            Type1_model("탕수육",R.drawable.nuddle,"15000(소)","18000(중)", R.drawable.border, Color.WHITE),
            Type1_model("사천탕수육",R.drawable.nuddle,"7500","8500(곱)",R.drawable.border2, Color.WHITE),
            Type1_model("양장피",R.drawable.nuddle,"500","500(곱)",R.drawable.border2, Color.WHITE),
            Type1_model("고추잡채",R.drawable.nuddle,"500","500(곱)",R.drawable.border2, Color.WHITE),
            Type1_model("유산슬",R.drawable.nuddle,"500","500(곱)",R.drawable.border2, Color.WHITE),
            Type1_model("팔보채",R.drawable.nuddle,"500","500(곱)",R.drawable.border, Color.WHITE),
            Type1_model("깐풍기",R.drawable.nuddle,"500","500(곱)",R.drawable.border, Color.WHITE),
            Type1_model("깐쇼새우",R.drawable.nuddle,"500","500(곱)",R.drawable.border, Color.WHITE),
            Type1_model("깐풍새우",R.drawable.nuddle,"500","500(곱)",R.drawable.border, Color.WHITE),
            Type1_model("깐쇼중새우",R.drawable.nuddle,"500","500(곱)",R.drawable.border, Color.WHITE),
            Type1_model("깐풍중새우",R.drawable.nuddle,"500","500(곱)",R.drawable.border, Color.WHITE),
            Type1_model("육해공짬뽕전골",R.drawable.nuddle,"8,500","9,500(곱)",R.drawable.border2, Color.WHITE)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_special1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()

    }
    fun init() {
        val adapter = Type1_adapter(list,R.layout.sub_type1,requireContext())
        special1View.adapter = adapter
        special1View.hasFixedSize()
        special1View.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false   )
        adapter.notifyDataSetChanged()

    }
}
