package org.theoffice.duckish.proc;

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

    public boolean login(String username, String password) {
        System.err.println("Verify login here!");

        // Test code, remove before prod
        boolean accountExists = username.equals("pollo");


        if (accountExists) {
            System.err.println("Accound exists, loggin in");
        } else {
            System.err.println("Accound does not exists, fuck off!");
        }
        return accountExists;
    }
}
