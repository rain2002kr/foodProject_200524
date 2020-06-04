package com.example.foodproject_200524.MENU.nuddle_menu

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodproject_200524.App
import com.example.foodproject_200524.DATA.Type1_adapter
import com.example.foodproject_200524.DATA.Type1_model
import com.example.foodproject_200524.MainActivity
import com.example.foodproject_200524.R
import kotlinx.android.synthetic.main.fragment_nuddle.*


class NuddleFragment : Fragment() {
    val list :MutableList<Type1_model> by lazy {
        mutableListOf<Type1_model>(
            Type1_model("짜장면",R.drawable.nuddle,"5,500","6,500(곱)", R.drawable.border,Color.WHITE),
            Type1_model("짬뽕",R.drawable.nuddle,"7,500","8,500(곱)",R.drawable.border2,Color.WHITE),
            Type1_model("차돌짬뽕",R.drawable.nuddle,"8,000","9,000(곱)",R.drawable.border2,Color.WHITE),
            Type1_model("해물짜장면",R.drawable.nuddle,"8,000","9,000(곱)",R.drawable.border,Color.WHITE),
            Type1_model("낙지짬뽕",R.drawable.nuddle,"8,500","9,500(곱)",R.drawable.border2,Color.WHITE),
            Type1_model("낙지차돌짬뽕",R.drawable.nuddle,"9,000","10,000(곱)",R.drawable.border2,Color.WHITE)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_nuddle, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //TODO tableNO
        var tableNO = App.prefs.getV("tableNO")
        //txt_tableNo.setText(tableNO)
        init()

    }
    fun init() {
        val adapter = Type1_adapter(list,R.layout.sub_type1,requireContext())
        nuddleView.adapter = adapter
        nuddleView.hasFixedSize()
        nuddleView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL,false   )
        adapter.notifyDataSetChanged()

    }





}
