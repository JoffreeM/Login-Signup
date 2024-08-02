package com.jop.login_signup.ui.composables

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CustomButton(
    modifier: Modifier,
    isEnabled: Boolean = true,
    fontSize: Int = 18,
    text: String,
    colorText: Color = Color.White,
    fontWeight: FontWeight = FontWeight.Bold,
    @DrawableRes icon: Int? = null,
    colorButtonSolid: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit
){
    Button(
        modifier = modifier,
        enabled = isEnabled,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(colorButtonSolid),
        shape = RoundedCornerShape(12.dp)
    ) {
        CustomText(
            text = text,
            fontSize = fontSize,
            textColor = colorText,
            fontWeight = fontWeight
        )
    }
}

@Composable
fun CustomButton(
    modifier: Modifier,
    isEnabled: Boolean = true,
    fontSize: Int = 18,
    @StringRes text: Int,
    colorText: Color = Color.White,
    fontWeight: FontWeight = FontWeight.Bold,
    @DrawableRes icon: Int? = null,
    colorButtonSolid: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit
){
    Button(
        modifier = modifier,
        enabled = isEnabled,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(colorButtonSolid),
        shape = RoundedCornerShape(12.dp)
    ) {
        CustomText(
            text = text,
            fontSize = fontSize,
            textColor = colorText,
            fontWeight = fontWeight
        )
    }
}