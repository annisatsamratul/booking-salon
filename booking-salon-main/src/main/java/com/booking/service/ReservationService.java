package com.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;

public class ReservationService {
	public static void createReservation(List<Person> listPerson, Scanner input, List<Service> serviceList, List<Reservation> reservationList){
    	Customer customer = null;
    	Employee employee = null;
    	List<Service> addService = new ArrayList<>();
    	
    	PrintService.showAllCustomer(listPerson);
    	boolean isCustomer = false;
    	while(isCustomer == false) {
    		System.out.println("Silahkan Masukkan Customer Id: ");
        	String customerId = input.nextLine();
        	for(Person data : listPerson) {
        		if(customerId.equalsIgnoreCase(data.getId())) {
            		customer = (Customer)data;
            		isCustomer = true; break;
            	}else {
            		isCustomer = false;
            	}
        	}
        	if(isCustomer == false) {
        		System.out.println("Customer yang dicari tidak ditemukan!");
        	}
    	}
    	
    	PrintService.showAllEmployee(listPerson);
    	boolean isEmployee = false;
    	while(isEmployee == false) {
    		System.out.println("Silahkan Masukkan Employee Id: ");
        	String employeeId = input.nextLine();
        	for(Person data : listPerson) {
        		if(employeeId.equalsIgnoreCase(data.getId())) {
            		employee = (Employee) data;
            		isEmployee = true; break;
            	}else {
            		isEmployee = false;
            	}
        	}
        	if(isEmployee == false) {
        		System.out.println("Employee yang dicari tidak ditemukan!");
        	}
    	}
    	
    	PrintService.showAllServices(serviceList);
    	boolean isService = false;
    	while(isService == false) {
    		System.out.println("Silahkan Masukkan Service Id: ");
        	String serviceId = input.nextLine();
        	for(Service data : serviceList) {
        		if(serviceId.equalsIgnoreCase(data.getServiceId())) {
        			addService.add(data);
            		isService = true; 
            		System.out.println("Ingin pilih service yang lain (Y/T) ?");
                	String answer = input.nextLine();
                	if(answer.equalsIgnoreCase("Y")) {
                		isService = false;
                	}else {
                		break;
                	}
            		
            		break;
            	}else {
            		isService = false;
            	}
        	}
        	if(isService == false) {
        		System.out.println("Service yang dicari tidak ditemukan!");
        	}
    	}
    	
    	Reservation reservations = new Reservation(generateReservationId(reservationList), customer, employee, addService, "In Process");
    	reservationList.add(reservations);
    	
    	System.out.println("Booking Berhasil!");
    	System.out.print("Total Booking: Rp. ");
    	System.out.printf("%,.2f%n",reservations.getReservationPrice());
    
    }

    public static String generateReservationId(List<Reservation> reservationList) {
    	String id = "";
    	for(int i = 0; i <= reservationList.size() + 1; i++) {
    		id = "Rsv-0" + i;
    	}
    	
    	return id;
    }
    
    public static double getTotalKeuntungan(List<Reservation> reservationList){
    	double result = 0;
        for (Reservation service : reservationList) {
        	if(service.getWorkstage().equalsIgnoreCase("Finish"))
            result += service.getReservationPrice();
        }
        return result;
    }

    public static void editReservationWorkstage(String id, String stage, List<Reservation> reservationList){
    	for(Reservation data : reservationList) {
			if(id.equalsIgnoreCase(data.getReservationId())) {
				if(stage.equalsIgnoreCase("Finish")) {
					data.setWorkstage("Finish");
					data.getCustomer().setWallet(data.getCustomer().getWallet() - data.getReservationPrice());
					System.out.println("Reservasi dengan id " + id + " sudah Finish");
				}else {
					data.setWorkstage("Cancel");
					System.out.println("Reservasi dengan id " + id + " sudah Cancel");
				}
				
			}
		}
    }
    
}
