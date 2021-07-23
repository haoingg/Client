package com.example.starbucks

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.starbucks.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    //이거에 해당하는 클래스를 안드로이드에서 자동적으로 생성(기존 이름에 Binding 붙여주기)
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //클래스 자체로 있으면 의미가 없기 때문에 클래스를 인스턴스화 메모리에 올려주는 과정이 필요
        //.inflate라는 것 자체가 메모리에 올려준다는 뜻
        binding = ActivityLoginBinding.inflate(layoutInflater)
        //바인딩 클래스에 있는 루트를 뷰에 올려줌 -> 화면이 메모리상에 올라감
        setContentView(binding.root)

        //클릭을 할 때 동작하는 메서드 = setOnClickListener
        binding.btnMove.setOnClickListener {
            //명시적 인텐트
            var intent = Intent(this, HomeActivity::class.java)
            // 인텐트를 데이터에 담을 때 key=value로 저장. key값은 data.
            intent.putExtra("data", binding.editId.text.toString())
            //startActivity를 하면 다음 Activity로 넘어가면서 아까 담았던 데이터를 가지고 다음 Activity로 넘어감
            startActivity(intent)
        }
            Toast.makeText(this, "아이디와 패스워드를 입력해주세요.", Toast.LENGTH_LONG).show()

//        var id: EditText? = null
//        var pwd: EditText? = null
//        var btn: Button? = null
//        var loginId: String? = null
//        var loginPwd: String? = null
//
//            val auto = getSharedPreferences("auto", MODE_PRIVATE)
//            loginId = auto.getString("inputId", null)
//            loginPwd = auto.getString("inputPwd", null)
//            if (loginId != null && loginPwd != null) {
//                if (loginId == "부르곰" && loginPwd == "네이버") {
//                    Toast.makeText(this, loginId + "님 자동로그인 입니다.", Toast.LENGTH_SHORT)
//                        .show()
//                    val intent = Intent(this, HomeActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                }
//            } else if (loginId == null && loginPwd == null) {
//                btn!!.setOnClickListener {
//                    if (id!!.text.toString() == "부르곰" && pwd!!.text.toString() == "네이버") {
//                        val auto = getSharedPreferences("auto", MODE_PRIVATE)
//                        val autoLogin = auto.edit()
//                        autoLogin.putString("inputId", id!!.text.toString())
//                        autoLogin.putString("inputPwd", pwd!!.text.toString())
//                        autoLogin.commit()
//                        Toast.makeText(
//                            this,
//                            id!!.text.toString() + "님 환영합니다.",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                        val intent = Intent(this, HomeActivity::class.java)
//                        startActivity(intent)
//                        finish()
//                    }
//                }
//            }
//        }
//    }


        //shared preference의 개념
//        writeSharedPreference("edit_id", "belle")

        val value = readSharedPreference("edit_id")
        Log.d("프리퍼런스", "edit_id=$value")
    }

    val SP_NAME = "UserRepository"

    //sp = Shared Preference의 약어로 지칭
    fun writeSharedPreference(key: String, value: String) {
        // 앞 = 이름(유일한 저장소 이름), 뒤엔 거의 mode private가 쓰임
        val sp = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        val editor = sp.edit()
        editor.putString(key, value).apply() // 필요에 따라 string 값 다르게 가능
        editor.putString("edit_id", "belle").apply() //함수에 파라미터로 받은 key와 value를 sharedpreference에 넣어줄 수 있음

    }

    fun readSharedPreference(key: String): String {
        val sp = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
        return sp.getString("edit_id", "") ?: "" // 필요에 따라 string 값 말고 다르게 추출 가능
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "[onDestroy] 완전한 앱 종료", Toast.LENGTH_SHORT).show()
    }


//    }
    }


//** activity 생명주기 메소드 예시

//    override fun onStart() {
//        super.onStart()
//        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
//    }
//    override fun onDestroy() {
//        super.onDestroy()
//        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
//    }




