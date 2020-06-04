package com.example.foodproject_200524.start_main_menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.foodproject_200524.App
import com.example.foodproject_200524.MainActivity
import com.example.foodproject_200524.R
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {
    private var currentTableNo = ""
    val tableNoArray = arrayOf("선택 안됨","1","2","3","4","5","6","7","8","9","10","11","12","13","13-1","14","14-1","15","16","16-1","17","18","19","20","21","22","배달1","배달2","배달3")
    lateinit var adapter : ArrayAdapter<String>

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //TODO USER FUNCTION CONTROL CODE START
        val uc = UC()
        uc.screenControl()
        uc.tableSelectControl()

    }

    //TODO UC 코드 집합
    inner class UC {
        //TODO-1 풀스크린 제어, 앱바 숨기기
        fun screenControl(){
            val manager = (activity as MainActivity).UCScreenContolManager()
            manager.fullScreenMode(true)
            manager.appBarHide(true)

        }
        //TODO-2 테이블 선택 및 이동
        fun tableSelectControl(){
            //TODO-2-1 테이블 선택 코드
            adapter = ArrayAdapter(requireContext(),R.layout.support_simple_spinner_dropdown_item, tableNoArray )
            sp_tableNo.adapter = adapter
            sp_tableNo.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    txt_tableNumber.setText("테이블 번호를 선택하세요.")
                }

                override fun onItemSelected( parent: AdapterView<*>?, view: View?, position: Int, id: Long ) {
                    txt_tableNumber.setText("${tableNoArray[position]}번 테이블을 선택하였습니다.")
                    if(tableNoArray[position].contains("배달"))
                        txt_tableNumber.setText("${tableNoArray[position]}을 선택 하였습니다.")
                    if(tableNoArray[position].contains("선택 안됨"))
                        txt_tableNumber.setText("테이블 번호를 선택하세요.")

                    currentTableNo = tableNoArray[position]
                }
            }

            //TODO-2-2 테이블 선택 및 메뉴 화면 이동
            bt_tableNoEnter.setOnClickListener{

                if(currentTableNo.contains("선택 안됨")){
                    Toast.makeText(activity?.baseContext,"테이블 번호를 선택 하세요.", Toast.LENGTH_LONG).show()
                } else {
                    App.prefs.setV("tableNO",currentTableNo)
                    Toast.makeText(
                        activity?.baseContext,"${currentTableNo} 번 테이블이 입력 되었습니다.",Toast.LENGTH_LONG).show()
                    //StartMainFragment 로 이동 메뉴선택화면
                    val manager = (activity as MainActivity).UCFragmentManager()
                    manager.changeFragment(StartMainFragment())

                }
            }
        }
    }
}


