/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2; // This is the package to which the abstract class Manager belongs

/**
 *
 * @author Mikel
 */
public abstract class Manager { // This abstract class called Manager, and can't be instantiated directly

    //Now I created two private and final instance variables for id and name, those variables are declared sing
//final for dont be changed once they are set
    private final String id;
    private final String name;
    
    protected Manager(String id, String name){ //This part the constructor was declared as a protected for a manager object
//      and this constructor can only be called within the same package or by subclass
        this.id = id;
        this.name = name;
    }
//  This method to get the value of id
    public String getId(){
        return id;
    }
//   this method to get the value of name
    public String getName(){
        return name;
    }
    @Override// overrides the default toString() method to return a string representation of the Manager object
    public String toString(){
//      The returned string will include id and name
        return "Manager{id='" + id + "', name='" + name + "'}";
    }
}
