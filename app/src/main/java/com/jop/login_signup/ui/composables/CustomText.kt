package com.jop.login_signup.ui.composables

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun CustomText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int = 15,
    fontWeight: FontWeight = FontWeight.Normal,
    alignContent: Arrangement.Horizontal = Arrangement.Start,
    textAlign: TextAlign = TextAlign.Start,
    textColor: Color = Color.DarkGray,
    style: TextStyle = TextStyle.Default.copy(
        fontSize = fontSize.sp
    ),
    maxLines: Int = 5
){
    Row (
        modifier = modifier,
        horizontalArrangement = alignContent
    ){
        Text(
            modifier = modifier,
            text = text,
            style = style,
            textAlign = textAlign,
            color = textColor,
            fontWeight = fontWeight,
            maxLines = maxLines
        )
    }
}


@Composable
fun CustomText(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    fontSize: Int = 15,
    fontWeight: FontWeight = FontWeight.Normal,
    alignContent: Arrangement.Horizontal = Arrangement.Start,
    textAlign: TextAlign = TextAlign.Start,
    textColor: Color = Color.DarkGray,
    style: TextStyle = TextStyle.Default.copy(
        fontSize = fontSize.sp
    ),
    maxLines: Int = 5
){
    Row (
        modifier = modifier,
        horizontalArrangement = alignContent
    ){
        Text(
            modifier = modifier,
            text = stringResource(id = text),
            style = style,
            textAlign = textAlign,
            color = textColor,
            fontWeight = fontWeight,
            maxLines = maxLines
        )
    }
}