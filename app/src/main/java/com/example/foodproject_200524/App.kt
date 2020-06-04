package com.example.foodproject_200524


import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken

class App : Application() {
    companion object {
        lateinit var prefs : MySharedPreferences
    }

    override fun onCreate() {
        prefs = MySharedPreferences(applicationContext)
        super.onCreate()

    }
}


class MySharedPreferences(context: Context) {
    var gson : Gson = GsonBuilder().create()
    var js :String = ""

    val PREFS_FILENAME = "prefs"
    val PREF_KEY_MY_EDITTEXT = "myEditText"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)


    /* 파일 이름과 EditText 를 저장할 Key 값을 만들고 prefs 인스턴스 초기화 */
    fun setV(key:String, value:String?){
        prefs.edit().putString(key,value).apply()
    }
    fun getV(key:String):String?{
        return prefs.getString(key,"")
    }

    fun setIndex(key:String, value:Int){
        prefs.edit().putInt(key,value).apply()
    }

    fun getIndex(key: String):Int{
        return prefs.getInt(key,0)
    }

    fun deleteAt(key: String){
        prefs.edit().remove("key").apply()
    }
    fun deleteAll(){
        prefs.edit().clear().apply()
    }


    var myEditText: String?
        get() = prefs.getString(PREF_KEY_MY_EDITTEXT, "")
        set(value) = prefs.edit().putString(PREF_KEY_MY_EDITTEXT, value).apply()
    /* get/set 함수 임의 설정. get 실행 시 저장된 값을 반환하며 default 값은 ""
     * set(value) 실행 시 value로 값을 대체한 후 저장 */

}