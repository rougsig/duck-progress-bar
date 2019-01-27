package com.github.rougsig.duckprogressbar

import com.intellij.ide.ui.LafManager
import com.intellij.openapi.components.BaseComponent
import javax.swing.UIManager
import com.intellij.openapi.application.ApplicationManager

class DuckApp : BaseComponent {
  init {
    LafManager.getInstance().addLafManagerListener {
      updateProgressBarUi()
    }
  }

  companion object {
    fun getInstance(): DuckApp {
      return ApplicationManager.getApplication().getComponent(DuckApp::class.java)
    }
  }

  override fun initComponent() {
    updateProgressBarUi()
  }

  private fun updateProgressBarUi() {
    UIManager.put("ProgressBarUI", DuckProgressBarUiConnector::class.java.name)
    UIManager.getDefaults()[DuckProgressBarUiConnector::class.java.name] = DuckProgressBarUiConnector::class.java
  }

  override fun getComponentName(): String = "DuckLafUpdater"
}