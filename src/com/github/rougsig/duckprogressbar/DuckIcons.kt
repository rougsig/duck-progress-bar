package com.github.rougsig.duckprogressbar

import com.intellij.openapi.util.IconLoader
import com.intellij.util.ui.JBUI
import java.awt.Color

val DUCK_ICON by lazy(LazyThreadSafetyMode.NONE) { IconLoader.getIcon("/duck.png") }
val RDUCK_ICON by lazy(LazyThreadSafetyMode.NONE) { IconLoader.getIcon("/rduck.png") }

val DUCK_WIDTH by lazy(LazyThreadSafetyMode.NONE) { JBUI.scale(32) }

val DUCK_COLOR by lazy(LazyThreadSafetyMode.NONE) { Color(0xFFF176) }