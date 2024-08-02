package com.jop.login_signup.ui.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import com.jop.login_signup.ui.theme.Primary
import com.jop.login_signup.ui.theme.Secondary


@Composable
fun BackgroundDesign() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(0f, height * 0.3f)
            cubicTo(
                width * 0.25f, height * 0.15f,
                width * 0.75f, height * 0.45f,
                width, height * 0.3f
            )
            lineTo(width, 0f)
            lineTo(0f, 0f)
            close()
        }
        clipPath(path) {
            drawRect(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Primary,
                        Secondary
                    ),
                    startY = 0f,
                    endY = height
                )
            )
        }
        drawIntoCanvas { canvas ->
            val paint = Paint().apply {
                color = Primary
                asFrameworkPaint().apply {
                    isAntiAlias = true
                    setShadowLayer(20f, 0f, 10f, Secondary.toArgb())
                }
            }
            canvas.drawPath(path, paint)
        }
    }
}