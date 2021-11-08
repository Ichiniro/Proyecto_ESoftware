package org.theoffice.duckish.proc;

import org.theoffice.duckish.obj.Employee;

public class Login {
    public boolean checkLogin() {
        /*
         * Previous logins must be saved (a key) in a file that will be read
         * here. If it exists we're gonna autolog
         */

        // Verify if there are logins saved here!

        // TODO: Provisional false, remove later after implementation.
        return false;
    }

    public void login(Employee e) {
        System.out.println(e.getFirstName() + " has logged in.");
    }
}
