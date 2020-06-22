package com.github.rougsig.duckprogressbar

import com.intellij.util.ui.JBUI
import javax.swing.*
import javax.swing.plaf.basic.BasicProgressBarUI
import java.awt.*
import java.awt.Graphics2D
import java.awt.geom.RoundRectangle2D

class DuckProgressBarUi : BasicProgressBarUI() {
  override fun getPreferredSize(c: JComponent?): Dimension {
    return Dimension(super.getPreferredSize(c).width, JBUI.scale(20))
  }

  private var duckX = 0
  private var velocity = 1

  private fun updateX(maxX: Int) {
    duckX += velocity
    if (duckX <= 0) {
      duckX = 0
      velocity = 1
    } else if (duckX >= maxX - DUCK_WIDTH) {
      duckX = maxX - DUCK_WIDTH
      velocity = -1
    }
  }

  private fun drawIcon(g2d: Graphics2D, c: JComponent) {
    val scaledIcon = if (velocity > 0) DUCK_ICON else RDUCK_ICON
    scaledIcon.paintIcon(c, g2d, duckX, -JBUI.scale(6))
  }

  private fun drawBackground(g2d: Graphics2D, c: JComponent) {
    val r = Rectangle(progressBar.size)
    g2d.paint = DUCK_COLOR
    g2d.fill(RoundRectangle2D.Float(0f, 0f, r.width.toFloat(), r.height.toFloat(), 0f, 0f))
  }

  override fun paint(g: Graphics, c: JComponent) {
    val g2d = g.create() as Graphics2D
    updateX(c.width)
    drawBackground(g2d, c)
    drawIcon(g2d, c)
  }
}
