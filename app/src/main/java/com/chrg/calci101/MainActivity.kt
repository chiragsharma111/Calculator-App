package com.chrg.calci101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNumberEvent( view:View) {
        if(isNewOp) {
            showNumber.setText("")
        }
        isNewOp = false

        val buSelected = view as Button
        var buClickValue:String = showNumber.text.toString()
        when(buSelected.id) {
            bu0.id->{
                buClickValue+= "0"
            }
            bu1.id->{
                buClickValue+="1"
            }
            bu2.id->{
                buClickValue+= "2"
            }
            bu3.id->{
                buClickValue+="3"
            }
            bu4.id->{
                buClickValue+= "4"
            }
            bu5.id->{
                buClickValue+="5"
            }
            bu6.id->{
                buClickValue+= "6"
            }
            bu7.id->{
                buClickValue+="7"
            }
            bu8.id->{
                buClickValue+= "8"
            }
            bu9.id->{
                buClickValue+="9"
            }
            buDot.id->{
//                TODO: Prevent adding more than one Dot
                buClickValue+= "."
            }
            buPlusMinus.id->{
                buClickValue= "-"+buClickValue
            }
        }
            showNumber.setText(buClickValue)
    }

var op = "+"
var oldNumber = ""
var isNewOp = true

    fun buOpEvent(view:View) {


        val buSelect = view as Button
        when(buSelect.id) {

            buMul.id->{
                op="*"
            }
            buDiv.id->{
                op="/"
            }
            buSub.id->{
                op="-"
            }
            buAdd.id->{
                op="+"
            }

        }
        oldNumber = showNumber.text.toString()
        isNewOp = true
    }

    fun buEqualEvent(view:View) {
        var newNumber = showNumber.text.toString()
        var result:Double?=null
        when(op) {
            "+"-> result = oldNumber.toDouble() + newNumber.toDouble()
            "-"-> result = oldNumber.toDouble() - newNumber.toDouble()
            "*"-> result = oldNumber.toDouble() * newNumber.toDouble()
            "/"-> result = oldNumber.toDouble() / newNumber.toDouble()
        }
        showNumber.setText(result.toString())
        isNewOp=true

    }

    fun buPercent(view:View) {
        val number:Double = showNumber.text.toString().toDouble()/100
        showNumber.setText(number.toString())
        isNewOp=true
    }

    fun buClickClean(view:View) {
        showNumber.setText("0")
        isNewOp=true
    }
}
