package com.eremenko.calculator3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnCliclListener{setTextFields("0")}
        btn_1.setOnCliclListener{setTextFields("1")}
        btn_2.setOnCliclListener{setTextFields("2")}
        btn_3.setOnCliclListener{setTextFields("3")}
        btn_4.setOnCliclListener{setTextFields("4")}
        btn_5.setOnCliclListener{setTextFields("5")}
        btn_6.setOnCliclListener{setTextFields("6")}
        btn_7.setOnCliclListener{setTextFields("7")}
        btn_8.setOnCliclListener{setTextFields("8")}
        btn_9.setOnCliclListener{setTextFields("9")}

        btn_sub.setOnCliclListener{setTextFields("-")}
        btn_add.setOnCliclListener{setTextFields("+")}
        btn_multi.setOnCliclListener{setTextFields("*")}
        btn_div.setOnCliclListener{setTextFields("/")}

        btn_dot.setOnCliclListener{setTextFields(".")}
        btn_breket1.setOnCliclListener{setTextFields("(")}
        btn_breket2.setOnCliclListener{setTextFields(")")}
        btn_ac.setOnCliclListener{
            math_operation.text = ""
            result_text.text = ""

        }
        btn_back.setOnCliclListener {
            val str = math_operation.text.toString()
            if (str.isNotEmpty()) {
                math_operation.text = str.substring(0, str.length - 1)
            }
            result_text.text = ""
        }

        btn_eq.setOnCliclListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()
                val longRes = reuslt.toLong()
                if(resul == longRes.toDouble()) {
                    result_text.text = longRes.toString()
                } else {
                    result_text.text = result.toString()
                }
            }catch (e:Exception){
                Log.d("Error", "${e.message}")


            }
        }


        }


    fun setTextFields(str: String) {
        if (result_text.text != "") {
            math_operation.text = result_text.text
            result.text = ""
        }
        math_operation.append(str)

    }


}