package com.example.foodproject_200524.ORDER

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodproject_200524.G
import com.example.foodproject_200524.R
import com.google.firebase.database.*
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.order_fragment.*

data class orderList(val tableNo: String, val food1: String, val orderTime: String)
data class OrderNumber(val orderNumber:String)

class orderFragment : Fragment() {

    var gson = GsonBuilder().create()
    // 저장 타입 지정
    var orderNumberType : TypeToken<MutableList<String>> = object : TypeToken<MutableList<String>>() {}

    private lateinit var mPostReference: DatabaseReference //firebase db ref.
    var mutData :MutableMap<String,Any> = mutableMapOf<String,Any>() //MutableMap
    //GenericTypeIndicator 선언
    var t: GenericTypeIndicator<MutableMap<String, Any>?> = object : GenericTypeIndicator<MutableMap<String,Any>?>() {}


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.order_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val time = "2020-06-04"
        val flist = listOf("짜장면","짬뽕","볶음밥","탕수육")


        //TODO 오더넘버 가져오기 없으면 0 SET
        val fb = Firebase()
        fb.Get().orderNumber()
        if(txt_orderListing.text.isNullOrEmpty()){
            val value = "0"
            fb.Send().orderNumber(value)
        }


        var orderNumber  = 0
        //TODO 메뉴 전송시 GSON TO JSON 타입으로 전송
        bt_etc.setOnClickListener{
            val order ="order"
            val list ="짜장면"
            postFirebaseDatabase(order, list)
        }

        //TODO 전송
        bt_send.setOnClickListener{
            //val key = "orderNumberServer"
            //postFirebaseDatabase(key, value)
            val value = ed_orderList.text.toString()
            fb.Send().orderNumber(value)

            val key = value
            val menu =flist.random().toString() //"짜장면"
            fb.Send().orderMenu(time,key,menu)

        }
        //TODO 읽어오기
        bt_read.setOnClickListener{
            //val key = "orderNumberServer"
            //getFirebaseDatabase(key)
            fb.Get().orderNumber()


        }
        //TODO 데이터 0 SET 매일 저녁 12시 리셋 (
        bt_ResetNumber.setOnClickListener{
            val value = "0"
            fb.Send().orderNumber(value)

        }
        //TODO 데이터 카운트업
        bt_countUp.setOnClickListener{
            if(txt_orderListing.text.isEmpty()) {
                fb.Get().orderNumber()
            }else{
                val getV = txt_orderListing.text.toString()
                orderNumber = getV.toInt() + 1
                ed_orderList.setText(orderNumber.toString())
            }
            //val getV = txt_orderListing.text.toString()
            //orderNumber = getV.toInt() + 1
            //ed_orderList.setText(orderNumber.toString())
        }

        //TODO 조리완료 리스트 가져오기
        bt_cooked1.setOnClickListener {
            val key = txt_orderListing.text.toString()
            fb.Get().cookingFinish(time, key)

        }
        //TODO 조리완료 리스트 삭제 및 추가
        bt_cookedfinish.setOnClickListener{
            val key = ed_cookedFinish.text.toString()
            val value = txt_cooked.text.toString()
            fb.Send().cookingFinish(time,key,value)

        }
        //TODO 계산대기 완료 리스트 가져오기
        bt_paid1.setOnClickListener {
            val key = ed_paidFinish.text.toString()
            fb.Get().paidFinish(time, key)

        }
        //TODO 계산대기 삭제 및 계산완료추가
        bt_paid_finish.setOnClickListener{
            val key = ed_paidFinish.text.toString()
            val value = txt_paid.text.toString()
            fb.Send().paidFinish(time,key,value)
        }


    }

    inner class Firebase {
        inner class Send{
            fun orderNumber(value:String){
                val key = "orderNumberServer"
                mPostReference = FirebaseDatabase.getInstance().reference
                mPostReference.child(key).setValue(value)
            }
            fun orderMenu(time:String ,key:String,value: String){
                mPostReference = FirebaseDatabase.getInstance().reference
                mPostReference.child(time).child("조리중").child(key).setValue(value)
            }
            fun cookingFinish(time:String ,key:String,value: String){
                mPostReference = FirebaseDatabase.getInstance().reference
                mPostReference.child(time).child("조리중").child(key).removeValue()
                mPostReference.child(time).child("계산대기").child(key).setValue(value)

            }
            fun paidFinish(time:String ,key:String,value: String){
                mPostReference = FirebaseDatabase.getInstance().reference
                mPostReference.child(time).child("계산대기").child(key).removeValue()
                mPostReference.child(time).child("계산완료").child(key).setValue(value)

            }
        }
        inner class Get{
            fun orderNumber(){
                val key = "orderNumberServer"
                mPostReference = FirebaseDatabase.getInstance().reference
                mPostReference.addValueEventListener(object : ValueEventListener{
                    override fun onDataChange(db: DataSnapshot) {
                        var ts = db.child(key).getValue().toString()
                        txt_orderListing.setText(ts)

                 }
                    override fun onCancelled(db: DatabaseError) {       }
                    })
                }
            //TODO 조리완료
            fun cookingFinish(time:String ,key:String){
                mPostReference = FirebaseDatabase.getInstance().reference
                mPostReference.addValueEventListener(object : ValueEventListener{
                    override fun onDataChange(db: DataSnapshot) {
                        var ts = db.child(time).child("조리중").child(key).getValue().toString()
                        txt_cooked.setText(ts)

                    }
                    override fun onCancelled(db: DatabaseError) {       }
                })
            }
            //TODO 계산완료
            fun paidFinish(time:String, key: String){
                mPostReference = FirebaseDatabase.getInstance().reference
                mPostReference.addValueEventListener(object : ValueEventListener{
                    override fun onDataChange(db: DataSnapshot) {
                        var ts = db.child(time).child("계산대기").child(key).getValue().toString()
                        txt_paid.setText(ts)

                    }
                    override fun onCancelled(db: DatabaseError) {       }
                })
            }

            }

            }







    fun postFirebaseDatabase(key:String,value:String)
    {
        mPostReference = FirebaseDatabase.getInstance().reference
        mutData.put(key,value)
        mPostReference.child(key).setValue(value)

        //mPostReference.child(dbIndex).updateChildren(mutData);
        //mPostReference.child(dbIndex).setValue(mutData)

    }
    fun getFirebaseDatabase(key: String)
    {
        mPostReference = FirebaseDatabase.getInstance().reference
        mPostReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(db: DataSnapshot) {
                //검색한 key 값에 해당하는 value 값 보여주기

                var ts = db.child(key).getValue().toString()
                txt_orderListing.setText(ts)
                /*
                var ts:MutableMap<String,Any>? =  db.child(key).getValue(t)
                ts?.forEach({
                    //if(it.key.toString() == serch){
                    txt_orderListing.setText(it.value.toString())
                })
                 */

            }
            override fun onCancelled(db: DatabaseError) {       }
        })
    }

}
