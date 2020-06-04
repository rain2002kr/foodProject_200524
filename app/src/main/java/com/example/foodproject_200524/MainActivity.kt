package com.example.foodproject_200524

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.foodproject_200524.MENU.MenuViewPagerFragment
import com.example.foodproject_200524.MENU.nuddle_menu.NuddleFragment
import com.example.foodproject_200524.MENU.rice_menu.RiceFragment
import com.example.foodproject_200524.MENU.special_menu.Special1Fragment
import com.example.foodproject_200524.ORDER.orderFragment
import com.example.foodproject_200524.start_main_menu.HomeFragment
import com.example.foodproject_200524.start_main_menu.StartMainFragment

class MainActivity : AppCompatActivity() {
    //TODO menuScreen
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val curId = item.itemId
        val manager = UCFragmentManager()

        when(curId){
            R.id.menu_menu -> manager.changeFragment(StartMainFragment())
            R.id.menu_order -> manager.changeFragment(orderFragment())
            //R.id.menu_bill  -> manager.changeFragment(Fragment())
            //R.id.menu_basket  -> changeFragment(G.Companion.Scr.BASKET_FG.number)
        }
        return super.onOptionsItemSelected(item)

    }
    //TODO onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO 풀스크린 & 앱바 숨기기
        val screenContol = UCScreenContolManager()
        screenContol.fullScreenMode(true)
        screenContol.appBarHide(true)

        //TODO 홈 화면 띄우기
        val frag_manager = UCFragmentManager()
        frag_manager.changeFragment(HomeFragment())
    }



    //TODO 개인 펑션 모음.
    inner class UCFragmentManager {
        val ft = supportFragmentManager.beginTransaction()
        fun changeFragment(fragment : Fragment){

            ft.replace(R.id.fragment, fragment).commit()
        }
        //뷰페이저 화면 지정 이동
        fun setFragmentNumber(fragment: Int) {
            G.menuScreenNumber = fragment
            ft.replace(R.id.fragment, MenuViewPagerFragment()).commit()
        }
    }

    inner class UCScreenContolManager{
        fun appBarHide(switch : Boolean){
            if(switch){
                supportActionBar?.hide()
            }else {
                supportActionBar?.show()
            }
        }
        fun fullScreenMode(switch : Boolean){
            var uiOption = window.decorView.systemUiVisibility

            if(switch){
                uiOption =  View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

            }else {
                uiOption =  View.SYSTEM_UI_LAYOUT_FLAGS
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            }
            window.decorView.setSystemUiVisibility(uiOption)
        }
        fun setItem(editText : EditText){
            editText.addTextChangedListener(object: TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    fullScreenMode(true)
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                    fullScreenMode(true)
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    fullScreenMode(true)
                }
            })
        }
        fun setItem(spinner : Spinner){


        }
    }
    //TODO 삭제예정 코드
    fun changeFragment(frag : Int) {
        val ft = supportFragmentManager.beginTransaction()
        when (frag) {
            G.Companion.Scr.HOME_FG.number -> {
                ft.replace(R.id.fragment, HomeFragment()).commit()
            }
            G.Companion.Scr.MENU_FG.number -> {
                ft.replace(R.id.fragment, StartMainFragment()).commit()
            }
            G.Companion.Scr.ORDER_FG.number -> {
                ft.replace(R.id.fragment, orderFragment()).commit()
            }
            G.Companion.Menu.MENU_PAGER_FG.number -> {
                ft.replace(R.id.fragment, MenuViewPagerFragment()).commit()
            }

            G.Companion.Menu.NUDDLE_FG.number -> {
                ft.replace(R.id.fragment, NuddleFragment()).commit()
            }
            G.Companion.Menu.RICE_FG.number -> {
                ft.replace(R.id.fragment, RiceFragment()).commit()
            }
            G.Companion.Menu.SET_FG.number -> {
                ft.replace(R.id.fragment, NuddleFragment()).commit()
            }
            G.Companion.Menu.SIDE_FG.number -> {
                ft.replace(R.id.fragment, NuddleFragment()).commit()
            }
            G.Companion.Menu.SPECIAL_FG.number -> {
                ft.replace(R.id.fragment, Special1Fragment()).commit()
            }
            G.Companion.Menu.SPECIAL2_FG.number -> {
                ft.replace(R.id.fragment, NuddleFragment()).commit()
            }

        }
    }



}






