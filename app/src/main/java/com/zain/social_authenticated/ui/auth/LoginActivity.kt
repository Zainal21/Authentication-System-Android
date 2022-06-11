package com.zain.social_authenticated.ui.auth

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.zain.social_authenticated.R
import com.zain.social_authenticated.base.BaseActivity
import com.zain.social_authenticated.model.request.LoginRequest
import com.zain.social_authenticated.model.response.LoginResponse


class LoginActivity : BaseActivity() , LoginView.View{

    var doubleBackToExitPressedOnce = false
    private lateinit var presenter: LoginPresenter
    private lateinit var BtnSIgnIn: Button
    private lateinit var UsernameEditText: EditText
    private lateinit var PasswordEditText: EditText
    private lateinit var LoginRequest: LoginRequest

    override fun getLayoutResource(): Int  = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginPresenter(this)
        LoginRequest = LoginRequest()
        initComponents()
        initEventListener()
        setContentView(R.layout.activity_login)
    }

    private fun initEventListener(){
        LoginRequest.username = UsernameEditText.text.toString()
        LoginRequest.password = UsernameEditText.text.toString()
        BtnSIgnIn.setOnClickListener {
            presenter.sendAuthentication(LoginRequest)
        }
    }

    private fun initComponents(){
        UsernameEditText = findViewById(R.id.username)
        PasswordEditText = findViewById(R.id.password)
        BtnSIgnIn = findViewById(R.id.btn_sign_in)
    }

    override fun onSuccessLogin(response: LoginResponse) {
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
