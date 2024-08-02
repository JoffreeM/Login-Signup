package com.jop.login_signup.ui.screens.authentication.login.view.model

import android.app.Application
import androidx.annotation.StringRes
import com.jop.login_signup.R
import com.jop.login_signup.ui.screens.authentication.login.view.event.LoginViewEvent
import com.jop.login_signup.ui.screens.authentication.login.view.state.LoginViewState
import com.jop.login_signup.ui.utils.isEmail
import com.jop.login_signup.ui.utils.passwordValid
import com.jop.login_signup.ui.utils.snackbar.IcoSnackbar
import com.jop.login_signup.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application
): BaseViewModel(application) {

    init {
        initViewState(LoginViewState())
    }

    fun onEvent(event: LoginViewEvent){
        when(event){
            is LoginViewEvent.OnEmail -> updateEmail(event.value)
            is LoginViewEvent.OnPassword -> updatePassword(event.value)
            is LoginViewEvent.OnRemember -> updateRemember(event.value)
            is LoginViewEvent.ForgotPassword -> forgotPassword()
            is LoginViewEvent.Login -> login()
        }
    }
    private fun login(){
        if (formValid()){
            val state: LoginViewState = currentViewState()
            showSnackbar(IcoSnackbar.CORRECT, getString(R.string.presset_btn_login))
        } else {
            showSnackbar(IcoSnackbar.ERROR, getString(R.string.presset_btn_login))
        }
    }
    private fun formValid(): Boolean{
        var isValid =  true
        val state: LoginViewState = currentViewState()
        @StringRes var emailError: Int? = null
        @StringRes var passwordError: Int? = null

        if (state.email.trim().isEmpty()) {
            isValid = false
            emailError = R.string.email_invalid
        }else {
            if (state.email.isEmail()) {
                emailError = null
            } else {
                isValid = false
                emailError = R.string.email_invalid
            }
        }
        if (state.password.trim().isEmpty()) {
            isValid = false
            passwordError = R.string.password_invalid
        } else {
            if (state.password.trim().passwordValid()){
                passwordError = null
            }else{
                isValid = false
                passwordError = R.string.password_invalid
            }
        }
        updateViewState(
            state.copy(
                emailError = emailError,
                passwordError = passwordError
            )
        )
        return isValid
    }
    private fun forgotPassword(){
        showSnackbar(IcoSnackbar.CORRECT, getString(R.string.send_reset_password))
    }
    private fun updateEmail(value: String){
        val state: LoginViewState = currentViewState()
        updateViewState(state.copy(email = value))
    }
    private fun updatePassword(value: String){
        val state: LoginViewState = currentViewState()
        updateViewState(state.copy(password = value))
    }
    private fun updateRemember(value: Boolean){
        val state: LoginViewState = currentViewState()
        showSnackbar(IcoSnackbar.CORRECT, getString(if (value) R.string.remember_active else R.string.remember_not_active))
        updateViewState(state.copy(remember = value))
    }
}