package org.theoffice.duckish.ext;

import javax.swing.*;

public class SetUI {
    public SetUI() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String property = System.getProperty("os.name");
        if ("Linux".equals(property)) {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("com.sun.java.swing.plaf.gtk.GTKLookAndFeel".equals(info.getClassName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } else if ("Windows 10".equals(property)) {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("com.sun.java.swing.plaf.windows.WindowsLookAndFeel".equals(info.getClassName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
    }
}
