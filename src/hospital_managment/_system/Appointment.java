/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_managment._system;

import static hospital_managment._system.Doctor.doctors;
import static hospital_managment._system.Hospital_Managment_System.input;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author Dell
 */
public class Appointment implements UserInterface
{
    static ArrayList<Appointment> appointments =new ArrayList<>();
    
    //____________________________________________________________________________
    
    private  int id;
    private  int patientId;
    private  int doctorId;
    private static String date;

    public Appointment(int patientId, int doctorId, String date)
    {
        this.id=appointments.size()+1;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
    }
    
    //____________________________________________________________________________

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    //____________________________________________________________________________
    
    static void add()
    {
        System.out.println("Enter Your Id");
        int pid=input.nextInt();
        System.out.println("Enter Doctor Id");
        int did=input.nextInt();
        Doctor doc=Doctor.search(did);
        Patient p=Patient.search(pid);
        
        if(doc==null||p==null)
        {
            System.out.println("Invalid process . Please check for the presence of the doctor, patient ");
            Patient.patientMenu();
        }
        else
        {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date=now.format(dateFormatter);
            Appointment ap=new Appointment(pid,did,date);
            appointments.add(ap);
            System.out.println("Appointment added successfully ✅ ");
        }
    }
    
    //____________________________________________________________________________
    
    static void Veiw_all()
    {
        if(appointments.isEmpty())
        {
            System.out.println("Not found any appointments 😞");
        }
        else
        {
            System.out.println("Total : "+appointments.size());
            for(Appointment app:appointments)
            {
                app.displayInfo();
            }
        }
    }
    
    //____________________________________________________________________________
    
    
    static void manageAppointment()
    {
        Admin.manageMenu2("Appointment");
        int choice=input.nextInt();
        switch(choice)
        {
            case 1:
                searchMenu();
                manageAppointment();
                break;
            case 3:
                remove();
                manageAppointment();
                break;
            case 4:
                Veiw_all();
                manageAppointment();
                break;
            case 5:
               Admin.adminMenu();
                break;
            default:
                System.out.println("Please enter a valid choice 😡");
                manageAppointment();
                break;
        }
    }
    
    //____________________________________________________________________________
    
    static void searchByDoc()
    {
        if(appointments.isEmpty())
        {
            System.out.println("Not found any appointments 😞");
        }
        else
        {
            System.out.println("Enter the id");
            int id=input.nextInt();
            Doctor d=Doctor.search(id);
            if(d==null)
            {
                System.out.println("Not found this doctor");
            }
            else
            {
                for(Appointment ap:appointments)
                {
                    if(ap.getDoctorId()==id)
                        ap.displayInfo();
                }
            }
        }
    }
      
    //____________________________________________________________________________
    
    static void searchByPatient()
    {
        if(appointments.isEmpty())
        {
            System.out.println("Not found any appointments 😞");
        }
        else
        {
            System.out.println("Enter the id");
            int id=input.nextInt();
            Patient p=Patient.search(id);
            if(p==null)
            {
                System.out.println("Not found this patient");
            }
            else
            {
                for(Appointment ap:appointments)
                {
                    if(ap.getPatientId()==id)
                        ap.displayInfo();
                }
            }
        }
    }
    
    //____________________________________________________________________________
    
    static void searchMenu()
    {
        if(appointments.isEmpty())
        {
            System.out.println("Not found any appointments 😞 ");
        }
        else
        {
            while(true)
            {
                try
                {
                    System.out.println("================= Search Menu =============");
                    System.out.println("    1- Search by doctor id                 ");
                    System.out.println("    2- Search by patient id                ");
                    System.out.println("    3- Exit                                ");
                    System.out.println();
                    System.out.println("      Enter your choice                    ");
                    System.out.println("===========================================");
                    int ch=input.nextInt();
                    switch(ch)
                    {
                        case 1:
                            searchByDoc();
                            searchMenu();
                            break;

                        case 2:
                            searchByPatient();
                            searchMenu();
                            break;

                        case 3:
                            manageAppointment();
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
    
    //____________________________________________________________________________
    
    static Appointment search(int id)
    {
        System.out.println("Enter the id");
        for(Appointment ap:appointments)
        {
            if(ap.getId()==id)
                return ap;
        }
        return null;
    }
    
    //____________________________________________________________________________
    
    static void remove()
    {
        if(appointments.isEmpty())
        {
            System.out.println("Not found any appointments 😞");
            
        }
        else
        {
            System.out.println("Enter the Appointment Id");
            int id=input.nextInt();
            Appointment ap=search(id);
            if(ap==null)
                System.out.println("Not found this appointment");
            else
            {
                appointments.remove(ap);
                System.out.println();
                System.out.println("Appintment removed successfully ✅");
                System.out.println();
                for(Appointment a :appointments)
                {
                    if(a.getId()>id)
                    {
                        a.setId(a.getId()-1);
                    }
                }
            }
        }
    }
    
    //____________________________________________________________________________
    
    @Override
    public void displayInfo()
    {
        Doctor doc=Doctor.search(doctorId);
        Patient pat=Patient.search(patientId);
        System.out.println();
        System.out.println("================================================================");
        System.out.println(                    "Appointment Id : "+id+"  ,  Date : "+date);
        System.out.print  (  "  Doctor  " );         doc.displayInfo();
        System.out.println(    "  Patient Id : "+patientId+"  ,  Patient name : "+pat.getName());
        System.out.println("================================================================");
        System.out.println();
    }
}