package com.example.foodproject_200524.MENU.set_menu

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

class SetFragment : Fragment() {
    val list :MutableList<Type2_model> by lazy {
        mutableListOf<Type2_model>(
            Type2_model("탕수육\n짜장+짜장",R.drawable.nuddle,"18000", R.drawable.border, Color.WHITE),
            Type2_model("사천탕수육\n짜장+짜장",R.drawable.nuddle,"19000", R.drawable.border, Color.WHITE),
            Type2_model("탕수육\n짜장+짬뽕",R.drawable.nuddle,"19000", R.drawable.border, Color.WHITE),
            Type2_model("사천탕수육\n짜장+짬뽕",R.drawable.nuddle,"20000", R.drawable.border, Color.WHITE),
            Type2_model("탕수육\n짬뽕+짬뽕",R.drawable.nuddle,"19000", R.drawable.border2, Color.WHITE),
            Type2_model("사천탕수육\n짬뽕+짬뽕",R.drawable.nuddle,"20000", R.drawable.border2, Color.WHITE),
            Type2_model("탕수육\n낙지짬뽕 2개",R.drawable.nuddle,"22000", R.drawable.border2, Color.WHITE),
            Type2_model("사천탕수육\n낙지짬뽕 2개",R.drawable.nuddle,"23000", R.drawable.border2, Color.WHITE),
            Type2_model("탕수육\n해물쟁반짜장2인",R.drawable.nuddle,"24000", R.drawable.border, Color.WHITE),
            Type2_model("사천탕수육\n해물쟁반짜장2인",R.drawable.nuddle,"25000", R.drawable.border, Color.WHITE),
            Type2_model("탕수육\n낙지항아리짬뽕2인",R.drawable.nuddle,"27000", R.drawable.border2, Color.WHITE),
            Type2_model("사천탕수육\n낙지항아리짬뽕2인",R.drawable.nuddle,"28000", R.drawable.border2, Color.WHITE)
            )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_set, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()

    }
    fun init() {
        val adapter = Type2_adapter(list,R.layout.sub_type2,requireContext())
        setView.adapter = adapter
        setView.hasFixedSize()
        setView.layoutManager = GridLayoutManager(requireContext(), 2,RecyclerView.VERTICAL,false   )
        adapter.notifyDataSetChanged()

    }
}
