package com.example.foodproject_200524.MENU.berverage_menu


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
import kotlinx.android.synthetic.main.fragment_beverage.*
import kotlinx.android.synthetic.main.fragment_nuddle.*
import kotlinx.android.synthetic.main.fragment_set.*
import kotlinx.android.synthetic.main.fragment_side.*

class BeverageFragment : Fragment() {
    val list :MutableList<Type2_model> by lazy {
        mutableListOf<Type2_model>(
            Type2_model("콜라",R.drawable.nuddle,"18000", R.drawable.border, Color.WHITE),
            Type2_model("사이다",R.drawable.nuddle,"19000", R.drawable.border3, Color.WHITE),
            Type2_model("소주",R.drawable.nuddle,"19000", R.drawable.border3, Color.WHITE),
            Type2_model("맥주",R.drawable.nuddle,"20000", R.drawable.border, Color.WHITE),
            Type2_model("이과두주",R.drawable.nuddle,"19000", R.drawable.border2, Color.WHITE),
            Type2_model("칭따오맥주(대)",R.drawable.nuddle,"20000", R.drawable.border3, Color.WHITE),
            Type2_model("고량주",R.drawable.nuddle,"22000", R.drawable.border2, Color.WHITE),
            Type2_model("죽엽청주",R.drawable.nuddle,"23000", R.drawable.border3, Color.WHITE),
            Type2_model("공부가주",R.drawable.nuddle,"24000", R.drawable.border3, Color.WHITE),
            Type2_model("연태주(소)",R.drawable.nuddle,"25000", R.drawable.border2, Color.WHITE),
            Type2_model("연태주(중)",R.drawable.nuddle,"27000", R.drawable.border2, Color.WHITE),
            Type2_model("연태주(대)",R.drawable.nuddle,"28000", R.drawable.border2, Color.WHITE)

        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_beverage, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()

    }
    fun init() {
        val adapter = Type2_adapter(list,R.layout.sub_type2,requireContext())
        beverageView.adapter = adapter
        beverageView.hasFixedSize()
        beverageView.layoutManager = GridLayoutManager(requireContext(), 2,RecyclerView.VERTICAL,false   )
        adapter.notifyDataSetChanged()

    }
}
