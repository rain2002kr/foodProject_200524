package com.example.foodproject_200524.MENU.season_menu

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
import kotlinx.android.synthetic.main.fragment_season.*
import kotlinx.android.synthetic.main.fragment_set.*
import kotlinx.android.synthetic.main.fragment_side.*

class SeasonFragment : Fragment() {
    val list :MutableList<Type2_model> by lazy {
        mutableListOf<Type2_model>(
            Type2_model("콩국수",R.drawable.nuddle,"18000", R.drawable.border3, Color.WHITE),
            Type2_model("냉짬뽕",R.drawable.nuddle,"5000", R.drawable.border2, Color.WHITE),
            Type2_model("굴짬뽕",R.drawable.nuddle,"5000", R.drawable.border, Color.WHITE),
            Type2_model("홍굴짬뽕",R.drawable.nuddle,"4000", R.drawable.border2, Color.WHITE)
            )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_season, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()

    }
    fun init() {
        val adapter = Type2_adapter(list,R.layout.sub_type2,requireContext())
        seasonView.adapter = adapter
        seasonView.hasFixedSize()
        seasonView.layoutManager = GridLayoutManager(requireContext(), 2,RecyclerView.VERTICAL,false   )
        adapter.notifyDataSetChanged()

    }
}
