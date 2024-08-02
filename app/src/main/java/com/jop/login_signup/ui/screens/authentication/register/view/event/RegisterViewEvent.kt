package com.jop.login_signup.ui.screens.authentication.register.view.event

interface RegisterViewEvent {
    data class OnEmail(val value: String): RegisterViewEvent
    data class OnPhone(val value: String): RegisterViewEvent
    data class OnPassword(val value: String): RegisterViewEvent
    data class OnPasswordConfirmation(val value: String): RegisterViewEvent
    object Register: RegisterViewEvent
}