/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputOutput;

import java.util.Scanner;

/**
 *
 * @author sebcandau
 */
public class Input {

    /**
     * allows you to transform the string entered by the player into an integer.
     * 
     * @param scan
     * @return
     */
    public static int readIn(Scanner scan) {
        String input = scan.nextLine();
        int result = -1;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return result;
        }
        return result;
    }

}
