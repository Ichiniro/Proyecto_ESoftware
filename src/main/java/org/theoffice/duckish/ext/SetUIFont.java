package org.theoffice.duckish.ext;

import javax.swing.*;
import java.util.Enumeration;

public class SetUIFont {
    public SetUIFont(javax.swing.plaf.FontUIResource f){
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put (key, f);
        }
    }
}
