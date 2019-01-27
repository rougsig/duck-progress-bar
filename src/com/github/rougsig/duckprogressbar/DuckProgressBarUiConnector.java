package com.github.rougsig.duckprogressbar;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class DuckProgressBarUiConnector extends BasicProgressBarUI {
    @SuppressWarnings({"MethodOverridesStaticMethodOfSuperclass", "UnusedDeclaration"})
    public static ComponentUI createUI(JComponent c) {
        return new DuckProgressBarUi();
    }
}
