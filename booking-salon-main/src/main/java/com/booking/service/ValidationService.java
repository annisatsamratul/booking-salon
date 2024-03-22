package com.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;

public class ValidationService {
    // Buatlah function sesuai dengan kebutuhan
    public static void validateInput(){

    }

    public static String validateCustomerId(Scanner input, String customerId, List<Person> listPerson){
    	boolean isValid = false;
    	while(isValid == false) {
    		System.out.println("Silahkan Masukkan Customer Id: ");
        	customerId = input.nextLine();
        	for(Person data : listPerson) {
        		if(data instanceof Customer) {
        			if(customerId.equalsIgnoreCase(data.getId())) {
        				isValid = true;
        				break;
        			}else {
        				isValid = false;
        			}
        		}
        	}
        	
        	if(isValid == false) {
        		System.out.println("Customer yang dicari tidak ditemukan!");
        	}
    	}
    	return customerId;
    }
    
    public static String validateEmployeeId(Scanner input, String employeeId, List<Person> listPerson){
    	boolean isValid = false;
    	while(isValid == false) {
    		System.out.println("Silahkan Masukkan Employee Id: ");
    		employeeId = input.nextLine();
        	for(Person data : listPerson) {
        		if(data instanceof Employee) {
        			if(employeeId.equalsIgnoreCase(data.getId())) {
        				isValid = true;
        				break;
        			}else {
        				isValid = false;
        			}
        		}
        	}
        	
        	if(isValid == false) {
        		System.out.println("Employee yang dicari tidak ditemukan!");
        	}
    	}
    	return employeeId;
    }
    
    public static String validateService(Scanner input, String serviceId, List<Service> serviceList){
    	boolean isValid = false;
    	while(isValid == false) {
    		System.out.println("Silahkan Masukkan Service Id: ");
    		serviceId =  input.nextLine();
    		for(Service data : serviceList) {
        		if(serviceId.equalsIgnoreCase(data.getServiceId())) {
                	isValid = true;
                	break;
        		}else {
        			isValid = false;
        		}
        	}
    		
        	if(isValid == false) {
        		System.out.println("Service yang dicari tidak ditemukan!");
        	}
    	}
    	return serviceId;
    }
    
    public static String validateReservationId(Scanner input, String reservationId, List<Reservation> reservationList){
    	boolean isValid = false;
    	while(isValid == false) {
    		System.out.println("Silahkan Masukkan Reservation Id: ");
    		reservationId = input.nextLine();
        	for(Reservation data : reservationList) {
        		if(reservationId.equalsIgnoreCase(data.getReservationId())) {
        			isValid = true;
        			break;
        		}else {
        			isValid = false;
        		}
        	}
        	
        	if(isValid == false) {
        		System.out.println("Reservation yang dicari tidak ditemukan!");
        	}
    	}
    	return reservationId;
    }
    
    public static String stageReservation(Scanner input, String stage){
    	boolean isValid = false;
    	while(isValid == false) {
    		System.out.println("Selesaikan Reservasi: ");
        	stage = input.nextLine();
        	if(stage.equalsIgnoreCase("Finish") || stage.equalsIgnoreCase("Cancel")) {
        		isValid = true;
        		break;
        	}else {
        		isValid = false;
        	}
        	
        	if(isValid == false) {
        		System.out.println("Workstage Salah!");
        	}
    	}
    	return stage;
    }
    
}
