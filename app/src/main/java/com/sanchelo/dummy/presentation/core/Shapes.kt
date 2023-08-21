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

                val cornerShape = 48f
                moveTo(cornerShape, 0f)
                lineTo(size.width - cornerShape, 0f)
                arcTo(
                    rect = Rect(
                        Offset(size.width - cornerShape, 0f),
                        Size(48f, 48f)
                    ),
                    startAngleDegrees = 270f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )
                lineTo(size.width, size.height)
                lineTo(0f, size.height)
                lineTo(0f, 0f)

//                lineTo(0f, size.height)
//                lineTo(size.width, size.height)
//
//                lineTo(size.width, 0f)

//                arcTo(
//                    rect = Rect(
//                        Offset(0f, 0f),
//                        Size(size.width, size.height)
//                    ),
//                    startAngleDegrees = 0f,
//                    sweepAngleDegrees = 90f,
//                    forceMoveTo = false
//                )

//                lineTo(0f, 0f)
                close()
            }
        )
    }

}

class Polygon(val sides: Int, val rotation: Float = 0f) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            Path().apply {
                val radius = if (size.width > size.height) size.width / 2f else size.height / 2f
                val angle = 2.0 * Math.PI / sides
                val cx = size.width / 2f
                val cy = size.height / 2f
                val r = rotation * (Math.PI / 180)
                moveTo(
                    cx + (radius * cos(0.0 + r).toFloat()),
                    cy + (radius * sin(0.0 + r).toFloat())
                )
                for (i in 1 until sides) {
                    lineTo(
                        cx + (radius * cos(angle * i + r).toFloat()),
                        cy + (radius * sin(angle * i + r).toFloat())
                    )
                }
                close()
            })
    }
}