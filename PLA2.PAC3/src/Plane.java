/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mati
 */
public class Plane {
    private String id;
    private int capacity;
    
    public Plane(String id, int capacity){
        this.id = id;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public String planeInfo(){
        return this.toString();
    }

    @Override
    public String toString() {
        return this.id + " (" + this.capacity + " ppl)";
    }
    
    
}
