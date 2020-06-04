package com.example.foodproject_200524.start_main_menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodproject_200524.App
import com.example.foodproject_200524.G
import com.example.foodproject_200524.MENU.MenuViewPagerFragment
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
import kotlinx.android.synthetic.main.start_main_fragment.*

class StartMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.start_main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //TODO USER FUNCTION CONTROL CODE START
        val uc = UC()
        uc.screenControl()
        uc.screenMove()
        uc.tableNumberControl()

        //screenChange()

    }



    fun screenChange(){
        bt_nuddle_scr.setOnClickListener{
            (activity as MainActivity).changeFragment(G.Companion.Menu.MENU_PAGER_FG.number)
            G.menuScreenNumber = 0
        }
        bt_rice_scr.setOnClickListener{
            (activity as MainActivity).changeFragment(G.Companion.Menu.MENU_PAGER_FG.number)
            G.menuScreenNumber = 1
        }
        bt_set_scr.setOnClickListener{
            (activity as MainActivity).changeFragment(G.Companion.Menu.MENU_PAGER_FG.number)
            G.menuScreenNumber = 2
        }
        //3 음료
        bt_beverage_scr.setOnClickListener{
            (activity as MainActivity).changeFragment(G.Companion.Menu.MENU_PAGER_FG.number)
            G.menuScreenNumber = 3
        }
        bt_special_scr.setOnClickListener{
            (activity as MainActivity).changeFragment(G.Companion.Menu.MENU_PAGER_FG.number)
            G.menuScreenNumber = 4
        }
        bt_special2_scr.setOnClickListener{
            (activity as MainActivity).changeFragment(G.Companion.Menu.MENU_PAGER_FG.number)
            G.menuScreenNumber = 5
        }

        bt_side_scr.setOnClickListener{
            (activity as MainActivity).changeFragment(G.Companion.Menu.MENU_PAGER_FG.number)
            G.menuScreenNumber = 6
        }
        bt_season_scr.setOnClickListener{
            (activity as MainActivity).changeFragment(G.Companion.Menu.MENU_PAGER_FG.number)
            G.menuScreenNumber = 7
        }

        //Home 테이블 번호 변경화면 이동
        touch_tableHomeScreen.setOnClickListener{
            (activity as MainActivity).changeFragment(G.Companion.Scr.HOME_FG.number)
        }

    }
    //TODO UC 코드 집합
    inner class UC {
        //TODO-1 풀스크린 제어, 앱바 숨기기
        fun screenControl() {
            val manager = (activity as MainActivity).UCScreenContolManager()
            manager.fullScreenMode(true)
            manager.appBarHide(false)
        }
        //TODO-2 화면 이동
        fun screenMove() {
            val manager = (activity as MainActivity).UCFragmentManager()

            bt_nuddle_scr.setOnClickListener{
                G.menuScreenNumber = 0
                manager.changeFragment(MenuViewPagerFragment())
            }
            bt_rice_scr.setOnClickListener{
                G.menuScreenNumber = 1
                manager.changeFragment(MenuViewPagerFragment())
            }
            bt_set_scr.setOnClickListener{
                G.menuScreenNumber = 2
                manager.changeFragment(MenuViewPagerFragment())
            }
            //3 음료
            bt_beverage_scr.setOnClickListener{
                G.menuScreenNumber = 3
                manager.changeFragment(MenuViewPagerFragment())
            }
            bt_special_scr.setOnClickListener{
                G.menuScreenNumber = 4
                manager.changeFragment(MenuViewPagerFragment())
            }
            bt_special2_scr.setOnClickListener{
                G.menuScreenNumber = 5
                manager.changeFragment(MenuViewPagerFragment())
            }

            bt_side_scr.setOnClickListener{
                G.menuScreenNumber = 6
                manager.changeFragment(MenuViewPagerFragment())
            }
            bt_season_scr.setOnClickListener{
                G.menuScreenNumber = 7
                manager.changeFragment(MenuViewPagerFragment())
            }

            //Home 테이블 번호 변경화면 이동
            touch_tableHomeScreen.setOnClickListener{
                manager.changeFragment(HomeFragment())
            }
        }
        //TODO-3 테이블 번호획득
        fun tableNumberControl(){
            //TODO tableNO
            var tableNO = App.prefs.getV("tableNO")
            txtTableNo_show.setText(tableNO)
        }

    }

}
