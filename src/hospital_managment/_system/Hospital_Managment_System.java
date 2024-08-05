/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospital_managment._system;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Hospital_Managment_System
{
    static Scanner input=new Scanner(System.in);
    
    //____________________________________________________________________________

    static void mainMenu()
    {
        while(true)
        {
            try
            {
                System.out.println("=============== Main Menu ===============");
                System.out.println("    1- Admin                             ");
                System.out.println("    2- Doctor                            ");
                System.out.println("    3- Patient                           ");
                System.out.println("    4- Exit                              ");
                System.out.println();
                System.out.println("      Enter your choice                  ");
                System.out.println("=========================================");
                int ch=input.nextInt();
                switch(ch)
                {
                    case 1:
                        Admin.adminAuthontication();
                        break;
                    case 2:
                        Doctor.doctorMenu();
                        break;
                    case 3:
                        Patient.patientMenu();
                        break;
                    case 4:
                        return ;
                    default:
                        System.out.println("Please enter a valid choice 😡 ");
                        mainMenu();
                        break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers , not letters .");
                input.next(); // clear the invalid input
            }

        }
        
    }
    
    //____________________________________________________________________________

    
    public static void main(String[] args)
    {
        try 
        {
            mainMenu();
        } catch (Exception e) 
        {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
    
}
