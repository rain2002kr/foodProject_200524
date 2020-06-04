package com.example.foodproject_200524.MENU.rice_menu

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
import kotlinx.android.synthetic.main.fragment_nuddle.*
import kotlinx.android.synthetic.main.fragment_rice.*

class RiceFragment : Fragment() {
    val list :MutableList<Type1_model> by lazy {
        mutableListOf<Type1_model>(
            Type1_model("짜장밥",R.drawable.nuddle,"5,500","6,500(곱)", R.drawable.border, Color.WHITE),
            Type1_model("짬뽕밥",R.drawable.nuddle,"7,500","8,500(곱)",R.drawable.border2, Color.WHITE),
            Type1_model("잡채밥",R.drawable.nuddle,"7,500","8,500(곱)",R.drawable.border2, Color.WHITE),
            Type1_model("볶음밥",R.drawable.nuddle,"6,500","7,500(곱)",R.drawable.border, Color.WHITE),
            Type1_model("낙지짬뽕밥",R.drawable.nuddle,"8,500","9,500(곱)",R.drawable.border2, Color.WHITE)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rice, container, false)
        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()

    }

    fun init() {
        val adapter = Type1_adapter(list,R.layout.sub_type1,requireContext())
        riceView.adapter = adapter
        riceView.hasFixedSize()
        riceView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false   )
        adapter.notifyDataSetChanged()

    }
}
