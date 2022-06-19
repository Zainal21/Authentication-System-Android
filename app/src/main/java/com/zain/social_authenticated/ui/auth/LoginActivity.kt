package com.zain.social_authenticated.ui.auth

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.zain.social_authenticated.R
import com.zain.social_authenticated.base.BaseActivity
import com.zain.social_authenticated.model.request.LoginRequest
import com.zain.social_authenticated.model.response.LoginResponse
import com.zain.social_authenticated.ui.dashboard.DashboardActivity


class LoginActivity : BaseActivity() , LoginView.View{

    var doubleBackToExitPressedOnce = false
    private lateinit var presenter: LoginPresenter
    private lateinit var BtnSignIn: Button
    private lateinit var UsernameEditText: EditText
    private lateinit var PasswordEditText: EditText
    private lateinit var LoginRequest: LoginRequest

    override fun getLayoutResource(): Int  = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginPresenter(this)
        LoginRequest = LoginRequest()
        setContentView(R.layout.activity_login)
        initComponents()
        initEventListener()
    }

    private fun initEventListener(){
//        LoginRequest.username = UsernameEditText.text.toString()
//        LoginRequest.password = PasswordEditText.text.toString()
        BtnSignIn.setOnClickListener {
            if(UsernameEditText.text.toString() == "" || PasswordEditText.text.toString() == ""){
                Toast.makeText(this, "Username/Password belum diisikan", Toast.LENGTH_SHORT).show();
            }else{
                LoginRequest.username = UsernameEditText.text.toString()
                LoginRequest.password = PasswordEditText.text.toString()
                presenter.sendAuthentication(LoginRequest)
            }
        }
    }

    private fun initComponents(){
        UsernameEditText = findViewById(R.id.username)
        PasswordEditText = findViewById(R.id.password)
        BtnSignIn = findViewById(R.id.btn_sign_in)
    }

    override fun onSuccessLogin(response: LoginResponse) {
        if(response.status == true){
            val _intent = Intent(this@LoginActivity, DashboardActivity::class.java)
            startActivity(_intent)
            finish()
        }else{
            Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRejectLogin(message: String) {
    }

    override fun showLoading() {
    }

    override fun HideLoading() {
    }

    override fun onBackPressed() {
        if(doubleBackToExitPressedOnce){
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Tekan Kembali Sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }

}
