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
public class Medication implements UserInterface
{
    static ArrayList<Medication> medications =new ArrayList<>();
    
    //____________________________________________________________________________
    
    private int id;
    private String name;
    private  int quantity;

    public Medication( String name, int quantity) {
        this.id = medications.size()+1;
        this.name = name;
        this.quantity = quantity;
    }
    
    //____________________________________________________________________________

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    //____________________________________________________________________________
    
    static void manageMedication()
    {
        Admin.manageMenu("Medication");
        int choice=input.nextInt();
        switch(choice)
        {
            case 1:
                add();
                manageMedication();
                break;
            case 2:
                if(Medication.medications.isEmpty())
                {
                    System.out.println("Not found any Medications");
                }
                else
                {
                    System.out.println("Enter the id");
                    int id=input.nextInt();
                    Medication m=search(id);
                    if(m==null)
                        System.out.println("Not found this Medication");
                    else
                        m.displayInfo();
                }
                manageMedication();
                break;
            case 3:
                remove();
                manageMedication();
                break;
            case 4:
                Veiw_all();
                manageMedication();
                break;
            case 5:
                Update();
                manageMedication();
                break;
            case 6:
                Admin.adminMenu();
                break;
            default:
                System.out.println("Please enter a valid choice 😡");
                manageMedication();
                break;
        }
        
    }
    
    //____________________________________________________________________________
    
    static void add()
    {
        System.out.println("Enter the name");
        String name=input.next();
        System.out.println("Enter the quantity");
        int quantity=input.nextInt();
        medications.add(new Medication(name,quantity));
        System.out.println();
        System.out.println("Medication added successfully ✅");
        System.out.println();
    }
    
    //____________________________________________________________________________
    
    static Medication search(int id)
    {
        for(Medication m:medications)
        {
            if(m.getId()==id)
                return m;
        }
        return null;
    }
    
    //____________________________________________________________________________
    
    static void remove()
    {
        if(medications.isEmpty())
        {
            System.out.println("Not found any Medication 😞");
        }
        else
        {
            System.out.println("Enter the Id");
            int id=input.nextInt();
            Medication m=search(id);
            if(m==null)
                System.out.println("Not found this Medication");
            else
            {
                medications.remove(m);
                System.out.println();
                System.out.println("Medication removed successfully ✅");
                System.out.println();
                for(Medication med :medications)
                {
                    if(med.getId()>id)
                    {
                        med.setId(med.getId()-1);
                    }
                }
            }
        }
    }
    
    //____________________________________________________________________________
    
    static void Veiw_all()
    {
        if(medications.isEmpty())
        {
            System.out.println("Not found any Medication 😞");
        }
        else
        {
            System.out.println("Total : "+medications.size());
            for(Medication m:medications)
            {
                m.displayInfo();
            }
        }
    }
    
    //____________________________________________________________________________
    
    static void Update()
    {
        if(medications.isEmpty())
        {
            System.out.println("Not found any Medications 😞");
        }
        else
        {
            System.out.println("Enter the Medication id");
            int id =input.nextInt();
            Medication m =search(id);
            if(m==null)
            {
                System.out.println("Not found this Medication 👀");
            }
            else
            {
                while(true)
                {
                    try
                    {
                        System.out.println("============== Update Menu ===============");
                        System.out.println("    1- Update the name                    ");
                        System.out.println("    2- Update the quantity                ");
                        System.out.println("    3- Exit                               ");
                        System.out.println();
                        System.out.println("      Enter your choice                   ");
                        System.out.println("==========================================");
                        int ch=input.nextInt();
                        switch(ch)
                        {
                            case 1:
                                System.out.println("Enter the new name");
                                String newName=input.next();
                                m.setName(newName);
                                System.out.println("the name has been changed successfully"); 
                                m.displayInfo();
                                manageMedication();
                                break;

                            case 2:
                                System.out.println("Enter the new quantity ");
                                int new_qu =input.nextInt();
                                m.setQuantity(new_qu);
                                System.out.println("the quantity has been changed successfully"); 
                                m.displayInfo();
                                manageMedication();
                                break;

                            case 3:
                                manageMedication();
                                break;

                            default:
                                System.out.println("Please enter a valid choice 😡");
                                manageMedication();
                                break;
                        }
                    }catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter numbers , not letters .");
                        input.next(); // clear the invalid input
                    }
                }
                
            }
        }
    }
    
    //____________________________________________________________________________
    
    @Override
    public void displayInfo() {
        System.out.println("Medication ID: " + id + " ,  Name: " + name + " ,  Quantity: " + quantity);
    }
    
}
