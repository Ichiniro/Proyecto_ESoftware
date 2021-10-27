package org.theoffice.duckish.proc;

import org.theoffice.duckish.ui.StartUI;

public class Start {
    public Start() {
        // Comprobar que no haya logins
        if ( new Login().checkLogin() ) {
            // Login automatically & show the main interface?
            System.err.println("Logs found!");
        } else {
            System.err.println("No logs found!");
            new StartUI();
        }
    }
}
