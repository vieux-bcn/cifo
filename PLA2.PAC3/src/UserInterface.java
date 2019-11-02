
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mati
 */
public class UserInterface {
    private Scanner reader;
    private ArrayList<Plane> planes;
    private ArrayList<Flight> flights;
    
    public UserInterface(Scanner reader){
        this.reader = reader;
        this.planes = new ArrayList<Plane>();
        this.flights = new ArrayList<Flight>();
    }
    
    public void start(){
        
        while (true) {  
            
            System.out.println("Airport panel");
            System.out.println("--------------------");
            System.out.println("");
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            System.out.println(">");
        
        String reader1 = readString();
        
            if (reader1.equals("1")) {
                addAireplane();
            } else if(reader1.equals("2")) {
                addFlight();
            } else if(reader1.equals("x")){
                flightService();
                break;
            } else {
                System.out.println("Invalid command");
            }
        }
        
    }
    
    public String readString(){
        return this.reader.nextLine();
    }
    
    public int readInteger(){
        return Integer.parseInt(this.reader.nextLine());
    }
    
    public void flightService(){
        while (true) {
            
            System.out.println("Flight service");
            System.out.println("------------");
            System.out.println("");
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quitt");
            System.out.println(">");
        
            String reader2 = readString();
            
            if (reader2.equals("1")) {
                printPlanes();
            } else if(reader2.equals("2")) {
                printFlights();
            } else if(reader2.equals("3")){
                printPlaneInfo();
            } else if(reader2.equals("x")){
                break;
            }
        }
        
    }
    
    private boolean existPlane(Plane plane){
        if (this.planes.isEmpty()) {
            return false;
        } else {
            for (Plane plane1 : planes) {
                if (plane1.getId().equals(plane.getId())) {
                    return true;
                }
                
            }
           return false; 
        }
    }
    
    private boolean existPlaneID(String id){
        if (this.planes.isEmpty()) {
            return false;
        } else {
            for (Plane plane1 : planes) {
                if (plane1.getId().equals(id)) {
                    return true;
                }
                
            }
           return false; 
        }
    }
    
    private boolean existFlight(Flight flight){
        if (this.flights.isEmpty()) {
            return false;
        } else {
            for (Flight flight1 : flights) {
                if ((flight1.getPlane().getId().equals(flight.getPlane())) && (flight1.getDeparture().equals(flight.getDeparture())) && flight1.getDestination().equals(flight.getDestination()) ) {
                    return true;
                }
            }
           return false; 
        }
    }
    
    private void addAireplane(){
        System.out.println("Give plane ID: ");
        String readerID = readString();
        
               
        if (!existPlaneID(readerID)) {
            System.out.println("Give plane capacity: ");
            int readerCapacity = readInteger();
            Plane plane = new Plane(readerID, readerCapacity);
            this.planes.add(plane);
        } else {
            System.out.println("This plane is already in the list.");
        }
        
    }
    
    private int getCapacity(String name){
        for (Plane plane : planes) {
            if (plane.getId().equals(name)) {
                return plane.getCapacity();
            }
            
        }
        return -1;
    }
    
    private void addFlight(){
        System.out.println("Give plane ID: ");
        String readerID = readString();
        
        if (existPlaneID(readerID)) {
            System.out.println("Give departure airport code: ");
            String readerDeparture = readString();
        
            System.out.println("Give destination airport code: ");
            String readerDestination = readString();
        
            Plane plane = new Plane(readerID, this.getCapacity(readerID));
        
            Flight flight = new Flight(plane, readerDeparture, readerDestination);
            this.flights.add(flight);
        } else {
            System.out.println("This plane Id cannot be found in planes list.");
        }
        
        
    }
    
    private void printPlanes(){
        for (Plane plane : planes) {
            System.out.println(plane);
        }
    }
    
    private void printFlights(){
        for (Flight flight : flights) {
            System.out.println(flight.getPlane().getId() +" (" + flight.getPlane().getCapacity() + " ppl)" + " (" + flight.getDeparture() +"-" + flight.getDestination() + ")");
            
        }
    }
    
    private void printPlaneInfo(){
        System.out.println("Give plane ID: ");
        String name = readString();
        if (existPlaneID(name)) {
            Plane plane = new Plane(name, getCapacity(name));
            System.out.println(plane);
        } else {
            System.out.println("Plane id not found in the list.");
        }
        
        
        
    }
    
}
