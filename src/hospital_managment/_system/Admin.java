/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_managment._system;

import static hospital_managment._system.Hospital_Managment_System.input;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author Dell
 */
public class Admin extends User 
{
    static ArrayList<Admin> admins =new ArrayList<>();
    
    //____________________________________________________________________________

    
    public Admin(String name, String pass, int id)
    {
        super(name, pass, id);
    }
    
    public Admin(String name, String pass) 
    {
        super(name, pass);
    }
    //__________________________________________________________________________
    
    static Admin getEmailAdmin(String name,String pass)
    {
        for(Admin i:admins)
        {
            if(i.getName().equals(name) && i.getPass().equals(pass))
            {
                return i;
            }   
        }
        return null;
    }  
    
    //__________________________________________________________________________
    
    static void createAccount()
    {
        System.out.println("Enter your name: ");
        String nam = input.next();
        System.out.println("Enter your password: ");
        String pass = input.next();
        
        //Admin newAdmin = new Admin(nam, pass);
        admins.add(new Admin(nam, pass));
        System.out.println();
        System.out.println("Account created successfully 🎉");
        System.out.println();
         
    }
    
    //__________________________________________________________________________
    
    static void login()
    {
        System.out.println("Enter your name: ");
        String nam = input.next();
        System.out.println("Enter your password: ");
        String pass = input.next();
        
        Admin admin=getEmailAdmin(nam,pass);
        if(admin==null)
        {
            System.out.println();
            System.out.println("Account not found 🔍 ");
            System.out.println();
            adminAuthontication();
        }
        else
        {
            adminMenu();
        }
    }
    
    //__________________________________________________________________________
    
    static void adminAuthontication() 
    {
        while(true)
        {
            try
            {
                System.out.println("======== Admin Authontication Menu =======");
                System.out.println("    1- Sign up                            ");
                System.out.println("    2- Log in                             ");
                System.out.println("    3- Exit                               ");
                System.out.println();
                System.out.println("      Enter your choice                    ");
                System.out.println("==========================================");
                int ch=input.nextInt();
                switch (ch)
                {
                    case 1:
                        createAccount();
                        adminAuthontication();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                        Hospital_Managment_System.mainMenu();;
                        break;
                    default:
                        System.out.println("Please enter a valid choice 😡 ");
                        adminAuthontication();
                        break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers , not letters .");
                input.next(); // clear the invalid input
            }
        }
    }
        
    //__________________________________________________________________________
    
    static void adminMenu()
    {
        while(true)
        {
            try
            {
                System.out.println("=============== Admin Menu ===============");
                System.out.println("    1- Doctor Management                  ");
                System.out.println("    2- Patient Management                 ");
                System.out.println("    3- Medication Management              ");
                System.out.println("    4- Appointment Management             ");
                System.out.println("    5- Exit                               ");
                System.out.println();
                System.out.println("      Enter your choice                   ");
                System.out.println("==========================================");
                int ch=input.nextInt();
                switch(ch)
                {
                    case 1:
                        Doctor.manageDoctor();
                        break;
                    case 2:
                        Patient.managePatient();
                        break;
                    case 3:
                        Medication.manageMedication();
                        break;
                    case 4:
                        Appointment.manageAppointment();
                        break;
                    case 5:
                        adminAuthontication();
                        break;
                    default:
                        System.out.println("Please enter a valid choice 😡");
                        adminMenu();
                        break;

                }
            }catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter numbers , not letters .");
                        input.next(); // clear the invalid input
                    }
        }
        
    }
    
    //__________________________________________________________________________
    
    static void manageMenu(String title)
    {
        System.out.println("=============== Management Menu ===============");
        System.out.println("    1- Add "+   title                             );
        System.out.println("    2- Search for a"+   title                     );
        System.out.println("    3- Delet "+   title                           );
        System.out.println("    4- Veiw all "+   title+" s"                   );
        System.out.println("    5- Update "+   title                          );
        System.out.println("    6- Exit                                    ");
        System.out.println();
        System.out.println("      Enter your choice                        ");
        System.out.println("===============================================");       
    }
    
    static void manageMenu2(String title)
    {
        System.out.println("=============== Management Menu ===============");
        System.out.println("    1- Search for a "+   title                     );
        System.out.println("    2- Add "+   title                           );
        System.out.println("    3- Delet "+   title                           );
        System.out.println("    4- Veiw all "+   title+" s"                   );
        System.out.println("    5- Exit                                      ");
        System.out.println();
        System.out.println("      Enter your choice                        ");
        System.out.println("===============================================");       
    }
    
    
}