/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mati
 */
public class Flight {
    private Plane plane;
    private String departure;
    private String destination;
    
    public Flight(Plane plane, String departure, String destination){
        this.plane = plane;
        this.departure = departure;
        this.destination = destination;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }
    
    public void printFlight(){
        this.plane.planeInfo();
    }

    @Override
    public String toString() {
        return this.getDeparture() + this.getDestination() + ")";
        
    }

    
    
    
}
