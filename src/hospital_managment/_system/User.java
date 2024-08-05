/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital_managment._system;

/**
 *
 * @author Dell
 */
public class User 
{
    private  String name;
    private  String pass;
    private  int id;

    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public User(String name, String pass, int id) {
        this.name = name;
        this.pass = pass;
        this.id = id;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public  int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
