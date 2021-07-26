package com.example.starbucks

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.starbucks.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private val id = "belle" // 로그인 가능한 유일한 ID
    private val pw = "a123" // 로그인 가능한 유일한 PW

    //이거에 해당하는 클래스를 안드로이드에서 자동적으로 생성(기존 이름에 Binding 붙여주기)
    private lateinit var binding: ActivityLoginBinding


    // 함수 시작
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //클래스 자체로 있으면 의미가 없기 때문에 클래스를 인스턴스화 메모리에 올려주는 과정이 필요
        //.inflate라는 것 자체가 메모리에 올려준다는 뜻

        binding = ActivityLoginBinding.inflate(layoutInflater)
        //바인딩 클래스에 있는 루트를 뷰에 올려줌 -> 화면이 메모리상에 올라감
        setContentView(binding.root)

        binding.btnMove.setOnClickListener {
            val inputlogin = binding.userid.text.trim().toString() // 로그인할 때 id 값
            val inputpw = binding.userpw.text.trim().toString() // 로그인할 때 pw 값

            //1.edittext / MySharedPrefereneces의 id(belle), pw(a123) 값이 일치하면 로그인 성공
            if (inputlogin == id && inputpw == pw) { // 내가 지정한 id, pw와 로그인할 때 id, pw가 같다면

                var intent = Intent(this, HomeActivity::class.java) // 로그인이 성공하면 Home 화면으로 넘김
                intent.putExtra("data", binding.userid.text.toString())
                Toast.makeText(this, "${inputlogin}님 환영합니다", Toast.LENGTH_SHORT).show()

                startActivity(intent) //시작
            }

            //2. 아닌 경우 toast 메시지로 재입력 요구
            else {
                if (inputlogin.isNullOrEmpty() && inputpw.isNullOrEmpty()) {
                    Toast.makeText(this, "아이디와 비밀번호가 입력되지 않았습니다", Toast.LENGTH_SHORT).show()
                } else if (inputlogin != id) {
                    Toast.makeText(this, "존재하지 않는 아이디입니다", Toast.LENGTH_SHORT).show()
                } else if (inputpw != pw) {
                    Toast.makeText(this, "비밀번호가 틀렸습니다", Toast.LENGTH_SHORT).show()
                }
            }
        }

        Toast.makeText(this, "아이디와 패스워드를 입력해주세요", Toast.LENGTH_LONG).show()
    }

    override fun onStart() { //데이터 불러오기
        super.onStart()
        val sharedPreferences = getSharedPreferences("share", 0)
        val usertakeid = sharedPreferences.getString("id", "")
        val usertakepw = sharedPreferences.getString("pw", "")

        binding.userid.setText(usertakeid)
        binding.userpw.setText(usertakepw)
    }

/*    override fun onResume() {
        super.onResume()

        val inputlogin = binding.userid.text.trim().toString() // 로그인할 때 id 값
        val inputpw = binding.userpw.text.trim().toString() // 로그인할 때 pw 값

        if (inputlogin == id && inputpw == pw) { // 내가 지정한 id, pw와 로그인할 때 id, pw가 같다면
            Toast.makeText(this, "${inputlogin}님 자동 로그인 완료됐습니다", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, HomeActivity::class.java) // 로그인이 성공하면 Home 화면으로 넘김
            startActivity(intent) //시작
        }
    } */

    override fun onStop() { // 데이터 저장
        super.onStop()
        //3. sharedpreference
        // 데이터를 기록하기 위해 sharedPreferences.Editor 인스턴스를 얻어야 함
        val sharedPreference = getSharedPreferences("share", 0) //mode_private = 0
        val editor = sharedPreference.edit() //sharedPreference 객체를 edit()해서 val editor에 매핑
        // putString()을 호출해 key에 문자열, value에 text.toString()을 통해 가져온 문자열 삽입
        val userid = binding.userid.text.toString()
        val userpw = binding.userpw.text.toString()
        editor.putString("id", userid) // userid에 입력하겠다는 의미
        editor.putString("pw", userpw)
        editor.apply() // shared 변동사항 저장

        Log.d(TAG, "ID in Shared = " + sharedPreference.getString("id", ""))
        Log.d(TAG, "PW in Shared = " + sharedPreference.getString("pw", ""))
    }
}