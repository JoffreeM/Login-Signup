package com.jop.login_signup.ui.composables

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomDivider(
    modifier: Modifier = Modifier,
    height:Int = 1,
    width:Int = 1,
    color: Color = MaterialTheme.colorScheme.secondary,
    thickness: Int = 1
){
    Divider(
        modifier = modifier
        .width(width.dp)
        .height(height.dp),
        color = color,
        thickness = thickness.dp)
}

@Composable
fun CustomDivider(
    modifier: Modifier = Modifier,
    size:Int = 1,
    color: Color = MaterialTheme.colorScheme.secondary,
    thickness: Int = 1
){
    Divider(
        modifier = modifier
            .size(size.dp),
        color = color,
        thickness = thickness.dp)
}