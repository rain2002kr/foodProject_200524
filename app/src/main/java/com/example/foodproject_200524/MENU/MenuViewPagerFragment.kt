package com.example.foodproject_200524.MENU

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodproject_200524.DATA.Pager1Adapter
import com.example.foodproject_200524.G
import com.example.foodproject_200524.MENU.berverage_menu.BeverageFragment
import com.example.foodproject_200524.MENU.nuddle_menu.NuddleFragment
import com.example.foodproject_200524.MENU.rice_menu.RiceFragment
import com.example.foodproject_200524.MENU.season_menu.SeasonFragment
import com.example.foodproject_200524.MENU.set_menu.SetFragment
import com.example.foodproject_200524.MENU.side_menu.SideFragment
import com.example.foodproject_200524.MENU.special_menu.Special1Fragment
import com.example.foodproject_200524.MENU.special_menu.Special2Fragment
import com.example.foodproject_200524.MainActivity
import com.example.foodproject_200524.R
import kotlinx.android.synthetic.main.menu_viewpager.*


class MenuViewPagerFragment : Fragment() {
    val listName = mutableListOf<String>(
        "면","밥","세트","음료/주류","스페셜1","스페셜2","사이드","시즌"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.menu_viewpager , container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init(G.menuScreenNumber)
        setOrder()
    }

    fun init(startFragment :Int) {
        pager.setOffscreenPageLimit(10)

        val adapter = Pager1Adapter((activity as MainActivity).supportFragmentManager, listName)

        //TODO 추가 메뉴 구성해야함.
        val listFrag = listOf<Fragment>(
            NuddleFragment(),
            RiceFragment(),
            SetFragment(),
            BeverageFragment(),
            Special1Fragment(),
            Special2Fragment(),
            SideFragment(),
            SeasonFragment()
        )

        listFrag.forEach {
            adapter.addItem(it)
        }

        tab_layout.setupWithViewPager(pager)
        pager.adapter = adapter

        //start fragment

        pager.setCurrentItem(startFragment)


    }
    fun setOrder(){
        bt_setOrder.setOnClickListener{

        }
    }

}