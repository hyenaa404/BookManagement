/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import util.InputUtils;

/**
 *
 * @author LENOVO
 */
public class Menu {
     public static int chooseInputOption(){
            System.out.println("======Book management ======");
            System.out.println("1. Import CSV.");
            System.out.println("2. Add book.");
            System.out.println("3. Search.");
            System.out.println("4. Delete.");
            System.out.println("5. Export CSV. ");
            System.out.println("6. Exit");
        int option = InputUtils.inputOption(1, 6);
        return option;
    }
}
