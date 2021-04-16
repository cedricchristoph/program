/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.util.LinkedList;

/**
 *
 * @author Inf2
 */
public class setup {

    private static User loggedUser;
    public User getLoggedUser() {
        return loggedUser;
    }
    
    public static void main(String[] args) {
        while(true) {
            loggedUser = null;
            login l = new login();
            l.setVisible(true);
            
        }
    }
    
}
