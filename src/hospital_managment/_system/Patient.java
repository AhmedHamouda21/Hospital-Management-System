/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_managment._system;

import static hospital_managment._system.Doctor.doctors;
import static hospital_managment._system.Hospital_Managment_System.input;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author Dell
 */
public class Patient extends User implements UserInterface
{
    static ArrayList<Patient> patients =new ArrayList<>();

    public Patient(String name, String pass)
    {
        super(name, pass);
        int id=patients.size()+1;
        this.setId(id);
    }
    
    //____________________________________________________________________________
    
    static Patient getEmailAdmin(String name,String pass)
    {
        for(Patient p:patients)
        {
            if(p.getName().equals(name)&&p.getPass().equals(pass))
            {
                return p;
            }   
        }
        return null;
    }  
    
    //____________________________________________________________________________
    
    static void add()
    {
        System.out.println("Enter the name");
        String name=input.next();
        System.out.println("Enter the Password");
        String pass=input.next();
        patients.add(new Patient(name,pass));
        System.out.println();
        System.out.println("Patient added successfully 🎉");
        System.out.println();
    }
    
    //____________________________________________________________________________
    
    static void patientMenu()
    {
        while(true)
        {
            try
            {
                System.out.println("============== Patient Menu ==============");
                System.out.println("    1- search for a doctor                ");
                System.out.println("    2- Add new Appointment                ");
                System.out.println("    3- Delet Appointment                  ");
                System.out.println("    4- view all my Appointments           ");
                System.out.println("    5- Exit                               ");
                System.out.println();
                System.out.println("      Enter your choice                   ");
                System.out.println("==========================================");
                int ch=input.nextInt();
                switch(ch)
                {
                    case 1:
                        if(Doctor.doctors.isEmpty())
                        {
                            System.out.println("Not found any Doctor");
                            patientMenu();
                        }
                        else
                        {
                            System.out.println("================= Search Menu ===============================");
                            System.out.println("    1- Search by doctor name                                 ");
                            System.out.println("    2- Search by Doctor Specialty                            ");
                            System.out.println("    3- Exit                                                  ");
                            System.out.println();
                            System.out.println("      Enter your choice                                      ");
                            System.out.println("=============================================================");
                            int choice=input.nextInt();
                            switch(choice)
                            {
                                case 1:
                                    Doctor doc=Doctor.searchByName();
                                    if(doc==null)
                                        System.out.println("Not found this doctor");
                                    else
                                        doc.displayInfo();
                                    patientMenu();
                                    break;
                                case 2:
                                    Doctor.search_By_specialization_Name();
                                    patientMenu();
                                    break;
                                case 3:
                                    patientMenu();
                                    break;
                                default:
                                    System.out.println("Please enter a valid choice 😡");
                                    patientMenu();
                                    break;
                            }
                        }
                        break;
                    case 2:
                        Appointment.add();
                        patientMenu();
                        break;
                    case 3:
                        Appointment.remove();
                        patientMenu();
                        break;
                    case 4:
                        Appointment.searchByPatient();
                        patientMenu();
                        break;        
                    case 5:
                        Hospital_Managment_System.mainMenu();
                        break;
                    default:
                        System.out.println("Please enter a valid choice 😡");
                        patientMenu();
                        break; 
                } 
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers , not letters .");
                input.next(); // clear the invalid input
            }
        }
    }
    
    //____________________________________________________________________________
        
    static void managePatient()
    {
        Admin.manageMenu2("Patient");
        int choice=input.nextInt();
        switch(choice)
        {
            case 1:
                searchMenu();
                managePatient();
                break;
            case 2:
                add();
                managePatient();
                break;
            case 3:
                remove();
                managePatient();
                break;
            case 4:
                Veiw_all();
                managePatient();
                break;
            case 5:
               Admin.adminMenu();
                break;
            default:
                System.out.println("Please enter a valid choice 😡");
                managePatient();
                break;
        }
    }
    
    //____________________________________________________________________________
    
    static Patient search(int id)
    {
        System.out.println("Enter the id");
        for(Patient p:patients)
        {
            if(p.getId()==id)
                return p;
        }
        return null;
    }
    
    //____________________________________________________________________________
    
    static void remove()
    {
        if(patients.isEmpty())
        {
            System.out.println("Not found any Patient 😞");
            
        }
        else
        {
            System.out.println("Enter the Id");
            int id=input.nextInt();
            Patient p=Patient.search(id);
            if(p==null)
                System.out.println("Not found this Patient");
            else
            {
                patients.remove(p);
                System.out.println();
                System.out.println("Patient removed successfully ✅");
                System.out.println();
                for(Patient pa :patients)
                {
                    if(pa.getId()>id)
                    {
                        pa.setId(pa.getId()-1);
                    }
                }
            }
        }
    }
    
    //____________________________________________________________________________
    
    @Override
    public  void displayInfo()
    {
        System.out.println("ID : "+this.getId()+"   Name : "+this.getName());
    }
    
    //____________________________________________________________________________
    
    static void Veiw_all()
    {
        if(patients.isEmpty())
        {
            System.out.println("Not found any patient 😞");
        }
        else
        {
            System.out.println("Total : "+patients.size());
            for(Patient p:patients)
            {
                p.displayInfo();
            }
        }
    }
    
    //____________________________________________________________________________
    
    static Patient searchByName()
    {
        System.out.println("Enter the name");
        String name =input.next();
        for(Patient p:patients)
        {
            if(p.getName().equals(name))
                return p;
        }
        return null;
    }
    
    //____________________________________________________________________________
    
    static Patient search()
    {
        System.out.println("Enter the id");
        int id=input.nextInt();
        for(Patient p:patients)
        {
            if(p.getId()==id)
                return p;
        }
        return null;
    }
    
    //____________________________________________________________________________
    
    static void searchMenu()
    {
        if(patients.isEmpty())
        {
            System.out.println("Not found any patient 😞 ");
        }
        else
        {
            while(true)
            {
                try
                {
                    System.out.println("================= Search Menu =============");
                    System.out.println("    1- Search by name                      ");
                    System.out.println("    2- Search by ID                        ");
                    System.out.println("    3- Exit                                ");
                    System.out.println();
                    System.out.println("      Enter your choice                    ");
                    System.out.println("===========================================");
                    int ch=input.nextInt();
                    switch(ch)
                    {
                        case 1:
                            Patient p =searchByName();
                            if(p==null)
                                System.out.println("Not found this patient 👀");
                            else
                                p.displayInfo();
                            searchMenu();
                            break;

                        case 2:
                            Patient pid =search();
                            if(pid==null)
                                System.out.println("Not found this patient 👀");
                            else
                                pid.displayInfo();
                            searchMenu();
                            break;

                        case 3:
                            managePatient();
                            break;
                        default:
                            System.out.println("Please enter a valid choice 😡");
                             searchMenu();
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
    
    

