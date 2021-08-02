package com.example.starbucks

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.provider.Settings.Global.putString
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_product_dialog.*
import kotlinx.android.synthetic.main.activity_swipe.*

class ProductDialogActivity(context: Context, ProductDialogInterface: ProductDialogInterface) :
    Dialog(context), View.OnClickListener {

    // 인터페이스 선언
    private var ProductDialogInterface: ProductDialogInterface? = null

    // 인터페이스 연결
    init {
        this.ProductDialogInterface = ProductDialogInterface
    }

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_product_dialog)

        // 투명한 배경
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        btnYES.setOnClickListener(this)
        btnNO.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view) {

            // SAVE 버튼 눌렀을 때
            btnYES -> {
                val TextValue = editText.text.toString()
                Log.d(TAG, "ProductDialog - YES 버튼 클릭됨" + " " + TextValue)
                this.ProductDialogInterface?.onbtnyesCliekd()
            }

            // CANCLE 버튼 눌렀을 때
            btnNO -> {
                dismiss()
                Log.d(TAG, "ProductDialog - NO 버튼 클릭됨")
                this.ProductDialogInterface?.onbtnnoClicked()
            }


        }

    }


}
