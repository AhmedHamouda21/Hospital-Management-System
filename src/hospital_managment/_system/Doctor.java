/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_managment._system;

import static hospital_managment._system.Admin.adminAuthontication;
import static hospital_managment._system.Admin.adminMenu;
import static hospital_managment._system.Admin.admins;
import static hospital_managment._system.Admin.getEmailAdmin;
import static hospital_managment._system.Admin.manageMenu;
import static hospital_managment._system.Hospital_Managment_System.input;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author Dell
 */
public class Doctor extends User  implements UserInterface
{
    static ArrayList<Doctor> doctors=new ArrayList<>();
    
    //____________________________________________________________________________
    
    private  String specialization;
    private  int start_work;
    private  int end_work;
    
    public Doctor(String name, String pass,int id) {
        super(name, pass,id);
    }
    
    public Doctor(String name, String pass) {
        super(name, pass);
    }

    public Doctor(String name, String pass,String specialization, int start_work, int end_work ) 
    {
        
        super(name, pass);
        this.setId(doctors.size()+1);
        this.specialization = specialization;
        this.start_work = start_work;
        this.end_work = end_work;
    }
    
    //____________________________________________________________________________
    
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getStart_work() {
        return start_work;
    }

    public void setStart_work(int start_work) {
        this.start_work = start_work;
    }

    public  int getEnd_work() {
        return end_work;
    }

    public void setEnd_work(int end_work) {
        this.end_work = end_work;
    }
    
    //____________________________________________________________________________
    
    static void add()
    {
        System.out.println("Enter the name");
        String name=input.next();
        System.out.println("Enter the specialization");
        String major=input.next();
        System.out.println("Enter the Password");
        String pass=input.next();
        System.out.println("Enter the Start time for work");
        int stwo=input.nextInt();
        System.out.println("Enter the end time for work");
        int endwo=input.nextInt();
        doctors.add(new Doctor(name,pass,major,stwo,endwo));
        System.out.println();
        System.out.println("Doctor added successfully ✅");
        System.out.println();
    }
    
    //____________________________________________________________________________
    
    static Doctor search(int id)
    {
        for(Doctor d:doctors)
        {
            if(d.getId()==id)
                return d;
        }
        return null;
    }
    
    //____________________________________________________________________________
    
    static Doctor searchByName()
    {
        System.out.println("Enter the name");
        String name =input.next();
        for(Doctor d:doctors)
        {
            if(d.getName().equals(name))
                return d;
        }
        return null;
    }
    
    //____________________________________________________________________________
    
    static void search_By_specialization_Name()
    {
        System.out.println("Enter the name");
        String name =input.next();
        for(Doctor d:doctors)
        {
            if(d.getSpecialization().equals(name))
                d.displayInfo();
        }
    }
    
    //____________________________________________________________________________
    
    @Override
    public void displayInfo()
    {
        
        System.out.println("ID : "+this.getId()+" ,  Name : "+this.getName()+" ,  specialization : "+this.getSpecialization()+" ,  worked from "+this.getStart_work()+" to "+this.getEnd_work());
    }
    
    //__________________________________________________________________________
    
    static void remove()
    {
        if(doctors.isEmpty())
        {
            System.out.println("Not found any doctor 😞");
            
        }
        else
        {
            System.out.println("Enter the Id");
            int id=input.nextInt();
            Doctor d=Doctor.search(id);
            if(d==null)
                System.out.println("Not found this doctor");
            else
            {
                doctors.remove(d);
                System.out.println();
                System.out.println("Doctor removed successfully ✅");
                System.out.println();
                for(Doctor doc :doctors)
                {
                    if(doc.getId()>id)
                    {
                        doc.setId(doc.getId()-1);
                    }
                }
            }
        }
    }
    
    //____________________________________________________________________________
    
    static void Veiw_all()
    {
        if(doctors.isEmpty())
        {
            System.out.println("Not found any doctor 😞");
        }
        else
        {
            System.out.println("Total : "+doctors.size());
            for(Doctor d:doctors)
            {
                d.displayInfo();
            }
        }
    }
    
    //____________________________________________________________________________
    
    static void Update()
    {
        if(doctors.isEmpty())
        {
            System.out.println("Not found any doctor 😞");
        }
        else
        {
            System.out.println("Enter the doctor id");
            int id =input.nextInt();
            Doctor d =search(id);
            if(d==null)
            {
                System.out.println("Not found this doctor 👀");
            }
            else
            {
                while(true)
                {
                    try
                    {
                        System.out.println("============== Update Menu ===============");
                        System.out.println("    1- Update the name                    ");
                        System.out.println("    2- Update the start work              ");
                        System.out.println("    3- Update the end work                ");
                        System.out.println("    4- Update the specialization          ");
                        System.out.println("    5- Exit                               ");
                        System.out.println();
                        System.out.println("      Enter your choice                   ");
                        System.out.println("==========================================");
                        int ch=input.nextInt();
                        switch(ch)
                        {
                            case 1:
                                System.out.println("Enter the new name");
                                String newName=input.next();
                                d.setName(newName);
                                System.out.println("the name has been changed successfully"); 
                                d.displayInfo();
                                manageDoctor();
                                break;

                            case 2:
                                System.out.println("Enter the new time for start");
                                int newst=input.nextInt();
                                d.setStart_work(newst);
                                System.out.println("the time for start has been changed successfully"); 
                                d.displayInfo();
                                manageDoctor();
                                break;

                            case 3:
                                System.out.println("Enter the new time for end");
                                int newend=input.nextInt();
                                d.setEnd_work(newend);
                                System.out.println("the time for end has been changed successfully"); 
                                d.displayInfo();
                                manageDoctor();
                                break;

                            case 4:
                                System.out.println("Enter the new specialization");
                                String new_specialization=input.next();
                                d.specialization=new_specialization;
                                System.out.println("the specialization has been changed successfully"); 
                                d.displayInfo();
                                manageDoctor();
                                break;

                            case 5:
                                manageDoctor();
                                break;

                            default:
                                System.out.println("Please enter a valid choice 😡");
                                Update();
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
    
    static void manageDoctor()
    {
        Admin.manageMenu("Doctor");
        int choice=input.nextInt();
        switch(choice)
        {
            case 1:
                Doctor.add();
                manageDoctor();
                break;
            case 2:
                if(Doctor.doctors.isEmpty())
                {
                    System.out.println("Not found any doctor 😞");
                }
                else
                {
                    System.out.println("Enter the id");
                    int id=input.nextInt();
                    Doctor d=Doctor.search(id);
                    if(d==null)
                        System.out.println("Not found this doctor");
                    else
                        d.displayInfo();
                }
                manageDoctor();
                break;
            case 3:
                Doctor.remove();
                manageDoctor();
                break;
            case 4:
                Doctor.Veiw_all();
                manageDoctor();
                break;
            case 5:
                Doctor.Update();
                manageDoctor();
                break;
            case 6:
                Admin.adminMenu();
                break;
            default:
                System.out.println("Please enter a valid choice 😡");
                manageDoctor();
                break;
        }
        
    }
    
    //____________________________________________________________________________
    
    static Doctor getEmailAdmin(String name,String pass)
    {
        for(Doctor d:doctors)
        {
            if(d.getName().equals(name)&&d.getPass().equals(pass))
            {
                return d;
            }   
        }
        return null;
    }  
    
    //____________________________________________________________________________
    
    static void doctorMenu()
    {
        while(true)
        {
            try
            {
                System.out.println("============== Doctor Menu ==============");
                System.out.println("    1- Add Treatment                     ");
                System.out.println("    2- Delet Treatment                   ");
                System.out.println("    3- View my Treatment                 ");
                System.out.println("    4- View my appointements             ");
                System.out.println("    5- Exit                              ");
                System.out.println();
                System.out.println("      Enter your choice                  ");
                System.out.println("=========================================");
                int ch=input.nextInt();
                switch(ch)
                {
                    case 1:
                        Treatment.add();
                        doctorMenu();
                        break;
                    case 2:
                        Treatment.remove();
                        doctorMenu();
                        break;
                    case 3:
                        Treatment.view_doc();
                        doctorMenu();
                        break;
                    case 4:
                        Appointment.searchByDoc();
                        doctorMenu();
                        break;
                    case 5:
                        Hospital_Managment_System.mainMenu();
                        break;
                    default:
                        System.out.println("Please enter a valid choice 😡");
                        doctorMenu();
                        break;
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers , not letters .");
                input.next(); // clear the invalid input
            }
        }
    }
}
