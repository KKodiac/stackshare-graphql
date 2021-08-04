package com.example.stacklounge.login

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.SpannableString
import android.text.TextPaint
import android.text.style.URLSpan
import android.text.util.Linkify
import android.widget.TextView
import android.widget.Toast
import com.example.stacklounge.MainActivity
import com.example.stacklounge.R
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //github 로그인
        btnLogin.setOnClickListener {
            doLogin()
        }

        //github 회원가입
        signup.setOnClickListener {
            doSignup()
        }

    }

    //github 로그인 함수
    private fun doLogin(){
        
        var mAuth = FirebaseAuth.getInstance()

        val provider = OAuthProvider.newBuilder("github.com")

        provider.addCustomParameter("login", "")

        val scopes: ArrayList<String?> = object : ArrayList<String?>() {
            init {
                add("user:email")
            }
        }
        provider.scopes = scopes

        val pendingResultTask: Task<AuthResult>? = mAuth.getPendingAuthResult()
        if (pendingResultTask != null) {
            // There's something already here! Finish the sign-in for your user.
            pendingResultTask
                .addOnSuccessListener(
                    OnSuccessListener<AuthResult?> {
                        // User is signed in.
                        // IdP data available in
                        // authResult.getAdditionalUserInfo().getProfile().
                        // The OAuth access token can also be retrieved:
                        // authResult.getCredential().getAccessToken().

                        val user = Firebase.auth.currentUser

                        //var confirmedEmail = user?.email // 로그인 확인된 이메일 저장

                        // 로그인 성공 시 MainActivity로 이동
                        githubLoginClear()

                    })
                .addOnFailureListener(
                    OnFailureListener {
                        // Handle failure.
                        // 로그인 실패
                        Toast.makeText(applicationContext,"Login failure", Toast.LENGTH_SHORT).show()
                    })
        } else {
            mAuth
                .startActivityForSignInWithProvider( /* activity= */this, provider.build())
                .addOnSuccessListener(
                    OnSuccessListener<AuthResult?> {
                        // User is signed in.
                        // IdP data available in
                        // authResult.getAdditionalUserInfo().getProfile().
                        // The OAuth access token can also be retrieved:
                        // authResult.getCredential().getAccessToken().

                        // 로그인 성공 시 MainActivity로 이동
                        githubLoginClear()
                    })
                .addOnFailureListener(
                    OnFailureListener {
                        // Handle failure.
                        // 로그인 실패
                        Toast.makeText(applicationContext,"Login failure", Toast.LENGTH_SHORT).show()
                    })
        }

    }

    //로그인 정보 확인되면 MainActivity로 이동
    private fun githubLoginClear() {
        startActivity(
            Intent(this, MainActivity::class.java)
        )
        finish()
    }

    //github 회원가입
    private fun doSignup(){
        var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/signup?ref_cta=Sign+up&ref_loc=header+logged+out&ref_page=%2F&source=header-home"))
        startActivity(intent)
    }

}