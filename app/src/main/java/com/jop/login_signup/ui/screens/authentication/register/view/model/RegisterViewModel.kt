package com.jop.login_signup.ui.screens.authentication.register.view.model

import android.app.Application
import androidx.annotation.StringRes
import com.jop.login_signup.R
import com.jop.login_signup.ui.screens.authentication.login.view.state.LoginViewState
import com.jop.login_signup.ui.screens.authentication.register.view.event.RegisterViewEvent
import com.jop.login_signup.ui.screens.authentication.register.view.state.RegisterViewState
import com.jop.login_signup.ui.utils.isEmail
import com.jop.login_signup.ui.utils.isPhoneNumberValid
import com.jop.login_signup.ui.utils.passwordValid
import com.jop.login_signup.ui.utils.snackbar.IcoSnackbar
import com.jop.login_signup.ui.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    application: Application
): BaseViewModel(application){

    init {
        initViewState(RegisterViewState())
    }

    fun onEvent(event: RegisterViewEvent){
        when(event){
            is RegisterViewEvent.OnEmail -> updateEmail(event.value)
            is RegisterViewEvent.OnPhone -> updatePhone(event.value)
            is RegisterViewEvent.OnPassword -> updatePassword(event.value)
            is RegisterViewEvent.OnPasswordConfirmation -> updatePasswordConfirmation(event.value)
            is RegisterViewEvent.Register -> register()
        }
    }
    fun updateSuccessClean(){
        val state: LoginViewState = currentViewState()
        updateViewState(LoginViewState())
        //updateViewState(state.copy(isSuccess = false))
    }
    private fun register(){
        if (formValid()){
            val state: RegisterViewState = currentViewState()
            showSnackbar(IcoSnackbar.CORRECT, getString(R.string.pressed_btn_create_account))
            updateViewState(state.copy(isSuccess = true))
        }else{
            showSnackbar(IcoSnackbar.ERROR, getString(R.string.pressed_btn_create_account))
        }
    }
    private fun formValid(): Boolean{
        var isValid = true
        val state: RegisterViewState = currentViewState()
        @StringRes var emailError: Int? = null
        @StringRes var phoneError: Int? = null
        @StringRes var passwordError: Int? = null
        @StringRes var passwordConfirmationError: Int? = null

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
        if (state.phone.trim().isEmpty()) {
            isValid = false
            phoneError = R.string.number_invalid
        }else{
            if (state.phone.trim().isPhoneNumberValid()) {
                phoneError = null
            }else{
                isValid = false
                phoneError = R.string.number_invalid
            }
        }
        if (state.password.trim().isEmpty()) {
            isValid = false
            passwordError = R.string.enter_password_invalid
        } else {
            if (state.password.trim().passwordValid()){
                passwordError = null
            }else{
                isValid = false
                passwordError = R.string.password_invalid
            }
        }
        if (state.passwordConfirmation.trim().isEmpty()) {
            isValid = false
            passwordConfirmationError = R.string.enter_password_invalid
        } else {
            if (state.passwordConfirmation.trim().passwordValid()){
                if (state.password.trim() == state.passwordConfirmation.trim()){
                    passwordConfirmationError = null
                }else{
                    isValid = false
                    passwordConfirmationError = R.string.password_not_equal
                }
            }else{
                isValid = false
                passwordConfirmationError = R.string.password_invalid
            }
        }
        updateViewState(
            state.copy(
                emailError = emailError,
                phoneError = phoneError,
                passwordError = passwordError,
                passwordConfirmationError = passwordConfirmationError,
            )
        )

        return isValid
    }
    private fun updateEmail(value: String){
        val state: RegisterViewState = currentViewState()
        updateViewState(state.copy(email = value))
    }
    private fun updatePhone(value: String){
        val state: RegisterViewState = currentViewState()
        updateViewState(state.copy(phone = value))
    }
    private fun updatePassword(value: String){
        val state: RegisterViewState = currentViewState()
        updateViewState(state.copy(password = value))
    }
    private fun updatePasswordConfirmation(value: String){
        val state: RegisterViewState = currentViewState()
        updateViewState(state.copy(passwordConfirmation = value))
    }
}