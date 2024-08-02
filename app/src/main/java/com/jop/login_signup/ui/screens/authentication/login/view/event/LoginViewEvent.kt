package com.jop.login_signup.ui.screens.authentication.login.view.event

interface LoginViewEvent {
    data class OnEmail(val value: String): LoginViewEvent
    data class OnPassword(val value: String): LoginViewEvent
    data class OnRemember(val value: Boolean): LoginViewEvent
    object ForgotPassword: LoginViewEvent
    object Login: LoginViewEvent
}