/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_managment._system;

import static hospital_managment._system.Hospital_Managment_System.input;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class Treatment implements UserInterface
{
    static ArrayList<Treatment> treatments =new ArrayList<>();
    
    //____________________________________________________________________________
    
    private  int id;
    private  int id_doctor;
    private  int id_patient;
    private  int id_medication;
    
    public Treatment( int id_doctor, int id_patient,int id_medication)
    {
        this.id = treatments.size()+1;
        this.id_doctor = id_doctor;
        this.id_patient = id_patient;
        this.id_medication=id_medication;
    }

    public  int getId() {
        return id;
    }

    public  int getId_doctor() {
        return id_doctor;
    }

    public  int getId_patient() {
        return id_patient;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    //____________________________________________________________________________    
    
    static void add()
    {
        System.out.println("Enter your Id ");
        int id_doc=input.nextInt();
        System.out.println("Enter the Id for patient");
        int id_pat=input.nextInt();
        System.out.println("Enter the Id for medication");
        int id_medc=input.nextInt();
        
        Doctor doc=Doctor.search(id_doc);
        Patient p=Patient.search(id_pat);
        Medication med=Medication.search(id_medc);
        int q=med.getQuantity();
        
        if(doc==null||p==null||med==null||q==0)
        {
            System.out.println("Invalid process . Please check for the presence of the doctor, patient, or medication " );
            System.out.println("or verify the quantity of the medication you have.");
            Doctor.doctorMenu();
        }
        else
        {
            treatments.add(new Treatment(id_doc,id_pat,id_medc));
            System.out.println();
            System.out.println("Treatment added successfully ✅");
            System.out.println();
            med.setQuantity(q-1);
            new Treatment(id_doc,id_pat,id_medc).displayInfo();
        }
        
    }
    
    //____________________________________________________________________________
    
    static void remove()
    {
        if(treatments.isEmpty())
        {
            System.out.println("Not found any treatment");
            Doctor.doctorMenu();
        }
        else
        {
            System.out.println("Enter the treatment Id ");
            int id_treatment=input.nextInt();
            for(Treatment t:treatments)
            {
                if(t.getId()==id_treatment)
                {
                    treatments.remove(t);
                    System.out.println("Treatment removed successfully ✅");
                    System.out.println();
                    for(Treatment tr :treatments)
                    {
                        if(tr.getId()>id_treatment)
                        {
                            tr.setId(tr.getId()-1);
                        }
                    }
                }
            }
        }
    }
    
    //____________________________________________________________________________
    
    static void view_doc()
    {
        if(treatments.isEmpty())
        {
            System.out.println("Not found any treatment");
            Doctor.doctorMenu();
        }
        else
        {
            System.out.println("Enter the doctor Id ");
            int id_doc=input.nextInt();
            Doctor doc=Doctor.search(id_doc);
            if(doc==null)
            {
                System.out.println("Not found this doctor");
            }
            else
            {
                for(Treatment t:treatments)
                {
                    if(t.getId_doctor()==id_doc)
                    {
                        t.displayInfo();
                    }
                }
            }
        }
    }
    
    //____________________________________________________________________________
    
    @Override
     public void displayInfo()
    {
        Doctor doc=Doctor.search(id_doctor);
        Patient pat=Patient.search(id_patient);
        Medication med=Medication.search(id_medication);
        System.out.println();
        System.out.println("================================================================");
        System.out.println(                    "Teratment Id : "+id);
                                                doc.displayInfo();
                                                pat.displayInfo();;
                                                med.displayInfo();
        System.out.println("================================================================");
        System.out.println();
    }
}
