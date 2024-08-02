package com.jop.login_signup.ui.screens.authentication.composable

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jop.login_signup.R
import com.jop.login_signup.ui.composables.CustomSpace
import com.jop.login_signup.ui.composables.CustomText
import com.jop.login_signup.ui.navigation.Screens

@Composable
fun TitleButtom(
    @StringRes text: Int,
    @StringRes textClick: Int,
    onClick: () -> Unit
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp),
        horizontalArrangement = Arrangement.End
    ){
        CustomText(
            text = text,
            fontWeight = FontWeight.Bold
        )
        CustomSpace(width = 5)
        CustomText(
            modifier = Modifier.clickable { onClick() },
            text = textClick,
            textColor = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Bold,
        )
    }
}