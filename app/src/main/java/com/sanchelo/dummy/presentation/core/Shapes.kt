package com.sanchelo.dummy.presentation.core

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

class LoginCardShape(val size: Float) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            Path().apply {

                val cornerShape = 256f

                moveTo(cornerShape / 2, 0f)
                lineTo(size.width - cornerShape, 0f)
                arcTo(
                    rect = Rect(
                        Offset(size.width - cornerShape, 0f),
                        Size(cornerShape, cornerShape)
                    ),
                    startAngleDegrees = 270f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                lineTo(0f, 0f + cornerShape)
                arcTo(
                    rect = Rect(
                        Offset(0f, 0f),
                        Size(cornerShape, cornerShape)
                    ),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 270f,
                    forceMoveTo = false
                )
                close()
            }
        )
    }

}
