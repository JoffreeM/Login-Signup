package com.jop.login_signup.ui.screens.authentication.composable

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.jop.login_signup.R
import com.jop.login_signup.ui.composables.CustomDivider
import com.jop.login_signup.ui.composables.CustomSpace
import com.jop.login_signup.ui.composables.CustomText

@Composable
fun TitleAuth(
    @StringRes title: Int
){
    CustomText(
        text = title,
        textColor = MaterialTheme.colorScheme.primary,
        fontSize = 25,
    )
    CustomSpace(height = 7)
    CustomDivider(width = 50, height = 2)
    CustomSpace(height = 30)
}