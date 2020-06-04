package com.example.foodproject_200524.MENU.special_menu

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodproject_200524.DATA.Type2_adapter
import com.example.foodproject_200524.DATA.Type2_model
import com.example.foodproject_200524.R
import kotlinx.android.synthetic.main.fragment_nuddle.*
import kotlinx.android.synthetic.main.fragment_set.*
import kotlinx.android.synthetic.main.fragment_special2.*

class Special2Fragment : Fragment() {
    val list :MutableList<Type2_model> by lazy {
        mutableListOf<Type2_model>(
            Type2_model("탕수육+팔보채\n쟁반짜장",R.drawable.nuddle,"18000", R.drawable.border, Color.WHITE),
            Type2_model("탕수육+팔보채\n낙지항아리짬뽕",R.drawable.nuddle,"19000", R.drawable.border2, Color.WHITE),
            Type2_model("탕수육+양장피\n쟁반짜장",R.drawable.nuddle,"19000", R.drawable.border, Color.WHITE),
            Type2_model("탕수육+양장피\n낙지항아리짬뽕",R.drawable.nuddle,"20000", R.drawable.border2, Color.WHITE),
            Type2_model("탕수육+유산슬\n쟁반짜장",R.drawable.nuddle,"19000", R.drawable.border, Color.WHITE),
            Type2_model("탕수육+유산슬\n낙지항아리짬뽕",R.drawable.nuddle,"20000", R.drawable.border2, Color.WHITE)
            )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_special2, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()

    }
    fun init() {
        val adapter = Type2_adapter(list,R.layout.sub_type2,requireContext())
        special2View.adapter = adapter
        special2View.hasFixedSize()
        special2View.layoutManager = GridLayoutManager(requireContext(), 2,RecyclerView.VERTICAL,false   )
        adapter.notifyDataSetChanged()

    }
}
