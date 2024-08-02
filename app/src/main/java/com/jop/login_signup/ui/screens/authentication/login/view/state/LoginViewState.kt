package com.jop.login_signup.ui.screens.authentication.login.view.state

import androidx.annotation.StringRes
import com.jop.login_signup.ui.viewstate.ViewState

data class LoginViewState(
    val isSuccess: Boolean = false,
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
    val remember: Boolean = false,

    @StringRes val emailError: Int? = null,
    @StringRes val passwordError: Int? = null
): ViewState()
