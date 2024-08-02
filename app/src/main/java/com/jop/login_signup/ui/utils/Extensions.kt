package com.jop.login_signup.ui.utils


import java.util.regex.Pattern

fun String.isEmail(): Boolean {
    val regex = Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})")
    return regex.matches(this)
}

fun String.passwordValid(): Boolean {
    val passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{6,}$")
    val matcher = passwordPattern.matcher(this)
    return matcher.matches()
}

fun String.isPhoneNumberValid(code: String = "591"): Boolean {
    val phonePattern = Pattern.compile("^\\+$code ?\\d{8}$")
    val matcher = phonePattern.matcher(this)
    return matcher.matches()
}