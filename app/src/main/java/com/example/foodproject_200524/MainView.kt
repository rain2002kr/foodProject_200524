package com.example.foodproject_200524

class MainViewModel (val id:String, val tableNO:String )

class foodModel (val menuName:String, price:Int)
class orderModel (val foodModel: foodModel,val count:Int)
class orderListModel (val id:String, val tableNO: String,
                      val orderModels: MutableList<orderModel>, totalPrice:Int, status:Int,
                      val startOrderTime: String,
                      val cookedTime: String,
                      val paidTime: String
                      )



class G {
    companion object {
        var orderNumber = 0
        class foodModel (var menuName:String, var price : Int)
        class orderModel (val menuName: String,val count:Int, val totalPrice:Int)
        class orderListModel (val id:String="" , val tableNO: String="",
                              val orderModels: MutableList<orderModel> = mutableListOf<orderModel>(),
                              val totalPrice:Int=0,
                              var status: Int = 0,
                              var startOrderTime: String ="",
                              var cookedTime: String="",
                              var paidTime: String=""
        )
        //TODO 유저 리스트
        var memberProfile = mutableMapOf<String,String>(
            Pair("이경민","123"),
            Pair("김가현","123"),
            Pair("이봉희","123"),
            Pair("이경훈","123"),
            Pair("1","1")
        )
        //TODO 임시 G
        var menuScreenNumber = 0

        //TODO 단품 메뉴 가격 <면류>
        var nuddleList = mutableListOf<foodModel>(
                    foodModel("짜장면", 5500),
                    foodModel("짬뽕", 7500),
                    foodModel("차돌짬뽕", 8000),
                    foodModel("낙지짬뽕", 8500),
                    foodModel("낙지차돌짬뽕", 10000),
                    foodModel("해물짜장면", 8000)
        )
        var nuddleList2 = mutableListOf<foodModel>()

        enum class Scr(val number:Int){
            MENU_FG(1),
            ORDER_FG(2),
            BILL_FG(3),
            BASKET_FG(4),
            HOME_FG(0)
        }
        enum class Menu(val number:Int){
            NUDDLE_FG(10),
            RICE_FG(11),
            SET_FG(12),
            SIDE_FG(13),
            SPECIAL_FG(14),
            SPECIAL2_FG(15),
            MENU_PAGER_FG(19)
        }
        enum class Nuddle(val number:Int){
            BLACK(5500),
            RED(6500),
            PORK_RED(8000),
            OCTO_RED(8500),
            OCTO_PORK_RED(10000),
            SEA_BLACK(8000)
        }
        enum class NuddleDouble(val number:Int){
            BLACK(6500),
            RED(7500),
            PORK_RED(9000),
            OCTO_RED(9500),
            OCTO_PORK_RED(11000),
            SEA_BLACK(9000)
        }

    }
}

