package com.jop.login_signup.ui.screens.authentication.register.view.state

import androidx.annotation.StringRes
import com.jop.login_signup.ui.viewstate.ViewState

data class RegisterViewState(
    val isSuccess: Boolean = false,
    val isLoading: Boolean = false,
    val email: String = "",
    val phone: String = "",
    val password: String = "",
    val passwordConfirmation: String = "",

    @StringRes val emailError: Int? = null,
    @StringRes val phoneError: Int? = null,
    @StringRes val passwordError: Int? = null,
    @StringRes val passwordConfirmationError: Int? = null
): ViewState()
