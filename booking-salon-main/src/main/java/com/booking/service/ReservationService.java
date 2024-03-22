package com.booking.service;

import java.util.ArrayList;
import java.util.List;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;

public class ReservationService {
    public static void createReservation(String customerId, String employeeId, List<Person> listPerson, List<Reservation> reservationList, String serviceId, List<Service> serviceList){
    	Customer customer = getCustomerByCustomerId(customerId, listPerson);
    	Employee employee = getEmployeeByEmployeeId(employeeId, listPerson);
    	List<Service> services = getServiceByServiceId(serviceId, serviceList);
    	
//    	List<Service> addservice = new ArrayList<>();
//    	addservice.add(services);
    	
    	Reservation reservations = new Reservation(generateReservationId(reservationList), customer, employee, services, "In Process");
    	reservations.getReservationPrice();
    	reservationList.add(reservations);
    	
    	
    	
    }

    public static Customer getCustomerByCustomerId(String customerId, List<Person> listPerson){
    	Customer customer = null;
    	
    	for(Person data : listPerson) {
    		if(data instanceof Customer) {
    			if(customerId.equalsIgnoreCase(data.getId())) {
    				customer = (Customer) data;
    			}
    		}
    	}
    	
    	return customer;
    }
    
    public static Employee getEmployeeByEmployeeId(String employeeId, List<Person> listPerson){
    	Employee employee = null;
    	
    	for(Person data : listPerson) {
    		if(data instanceof Employee) {
    			if(employeeId.equalsIgnoreCase(data.getId())) {
    				employee = (Employee) data;
    			}
    		}
    	}
    	
    	return employee;
    }
    
    public static List<Service> getServiceByServiceId(String serviceId, List<Service> serviceList){
    	Service services = null;
//    	List<Service> addservice = new ArrayList<>();
    	for(Service data : serviceList) {
    		if(serviceId.equalsIgnoreCase(data.getServiceId())) {
    			services = data;
//    			addservice.add(services);
    		}
    	}
    	
    	List<Service> addservice = new ArrayList<>();
    	addservice.add(services);
    	return addservice;
    }
    
    public static String generateReservationId(List<Reservation> reservationList) {
    	String id = "";
    	for(int i = 0; i <= reservationList.size() + 1; i++) {
    		id = "Rsv-0" + i;
    	}
    	
    	return id;
    }
    
    public static double getTotalBiaya(List<Reservation> reservationList){
    	double result = 0;
        for (Reservation service : reservationList) {
            result += service.getReservationPrice();
        }
        return result;
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
					System.out.println("Reservasi dengan id " + id + " sudah Finish");
				}else {
					data.setWorkstage("Cancel");
					System.out.println("Reservasi dengan id " + id + " sudah Cancel");
				}
				
			}
		}
    }
    
    public static double getTotalBooking(List<Reservation> reservationList){
    	double result = 0;
        for (Reservation service : reservationList) {
            result += service.getReservationPrice();
        }
        return result;
    }

    // Silahkan tambahkan function lain, dan ubah function diatas sesuai kebutuhan
}
