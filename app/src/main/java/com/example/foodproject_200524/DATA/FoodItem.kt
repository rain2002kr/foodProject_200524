package com.example.foodproject_200524.DATA


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