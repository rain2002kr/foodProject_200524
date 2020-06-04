package com.example.foodproject_200524

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.foodproject_200524.G.Companion.memberProfile
import com.example.foodproject_200524.G.Companion.nuddleList
import com.example.foodproject_200524.G.Companion.nuddleList2
import kotlinx.android.synthetic.main.activity_intro.*


class IntroActivity : AppCompatActivity() {
    var handler : Handler? = null
    var runnable : Runnable? = null
    private val multiplePermissionsCode = 100
    private var id = ""
    private var passwd = ""
    //private var memberProfile = mutableMapOf<String,String>()

    private val TAG = "introActivity"
    //TODO User 함수 : 권한 요청 함수
    private fun checkPermissions() {

    }

    fun moveMainActvity(){
        runnable = Runnable {
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        handler = Handler()
        handler?.run {
            postDelayed(runnable, 1000)
        }
    }


    //TODO onPause()
    override fun onPause() {
        super.onPause()
        handler?.removeCallbacks(runnable)//Acitivity 가 Pause 상태일 때는 runnable 도 중단 하도록 함.
    }


    private fun menuCreateFunction(){
        G.nuddleList.forEach {
            Log.d(TAG,it.menuName +":"+ it.price)
            nuddleList2.add(G.Companion.foodModel(it.menuName,it.price))
        }

        G.nuddleList2.forEach{
            it.let{
                it.price = it.price + 1000
                it.menuName = it.menuName + "곱빼기"
            }
            Log.d(TAG,it.menuName +":"+ it.price)
        }

    }


    //TODO onCreate()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        fullScreenMode(true, window)
        appBarHide(true, supportActionBar)
        focusTouchFullscreenStable(ed_id,window)
        focusTouchFullscreenStable(ed_passwd,window)
        menuCreateFunction()

        //sign up
        bt_signup.setOnClickListener {
            id  = ed_id.text.toString().trim()
            passwd = ed_passwd.text.toString().trim()

            G.memberProfile.let{
                if(it.containsKey(id)){
                    Toast.makeText(this, "${id} 계정이 존재합니다. ", Toast.LENGTH_LONG).show()
                } else {
                    G.memberProfile.put(id , passwd)
                    Toast.makeText(this, "${id} 계정을 생성했습니다.", Toast.LENGTH_LONG).show()
                }
            }
        }

        //log in
        bt_login.setOnClickListener {
            id  = ed_id.text.toString().trim()
            passwd = ed_passwd.text.toString().trim()
            G.memberProfile.let{
                if(it.containsKey(id)){
                    if(it.containsValue(passwd)){
                        App.prefs.setV("id",id)
                        Toast.makeText(this, "로그인 되었습니다.", Toast.LENGTH_LONG).show()
                        moveMainActvity()
                    }else {
                        Toast.makeText(this, "패스워드가 틀렸습니다.", Toast.LENGTH_LONG).show()
                    }
                } else{
                    Toast.makeText(this, "${id} 계정이 없습니다. 계정을 생성하세요.", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}

private fun fullScreenMode(switch : Boolean,window: Window){
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

private fun appBarHide(switch : Boolean,actionBar :  ActionBar?){
    if(switch){
        actionBar?.hide()
    }else {
        actionBar?.show()
    }
}

private fun focusTouchFullscreenStable(ed : EditText,window:Window){
    ed.addTextChangedListener(object:TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            fullScreenMode(true,window)
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            fullScreenMode(true,window)
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            fullScreenMode(true,window)
        }
    })
}
