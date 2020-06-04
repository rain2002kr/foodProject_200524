package com.example.foodproject_200524.MENU.side_menu

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
import kotlinx.android.synthetic.main.fragment_side.*

class SideFragment : Fragment() {
    val list :MutableList<Type2_model> by lazy {
        mutableListOf<Type2_model>(
            Type2_model("해물쟁반\n짜장2인",R.drawable.nuddle,"18000", R.drawable.border, Color.WHITE),
            Type2_model("해물쟁반\n짜장2인",R.drawable.nuddle,"21000", R.drawable.border2, Color.WHITE),
            Type2_model("군만두",R.drawable.nuddle,"5000", R.drawable.border, Color.WHITE),
            Type2_model("꽃빵 6개",R.drawable.nuddle,"5000", R.drawable.border, Color.WHITE),
            Type2_model("꽃빵 4개",R.drawable.nuddle,"4000", R.drawable.border, Color.WHITE)
            )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_side, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()

    }
    fun init() {
        val adapter = Type2_adapter(list,R.layout.sub_type2,requireContext())
        sideView.adapter = adapter
        sideView.hasFixedSize()
        sideView.layoutManager = GridLayoutManager(requireContext(), 2,RecyclerView.VERTICAL,false   )
        adapter.notifyDataSetChanged()

    }
}
