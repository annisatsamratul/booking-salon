package com.booking.models;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reservation {
    private String reservationId;
    private Customer customer;
    private Employee employee;
    private List<Service> services;
    private double reservationPrice;
    private String workstage;
    //   workStage (In Process, Finish, Canceled)

    public Reservation(String reservationId, Customer customer, Employee employee, List<Service> services,
            String workstage) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.employee = employee;
        this.services = services;
        this.reservationPrice = calculateReservationPrice(services);
        this.workstage = workstage;
    };

    private double calculateReservationPrice(List<Service> services){
    	double res = 0;
    	for(Service data : services) {
    		if(customer.getMember().getMembershipName().equalsIgnoreCase("none")) {
        		res += data.getPrice();
        	}else if(customer.getMember().getMembershipName().equalsIgnoreCase("Silver")) {
        		double potongan = 0.05;
        		res += data.getPrice() - (data.getPrice() * potongan);
        	}else if(customer.getMember().getMembershipName().equalsIgnoreCase("Gold")) {
        		double potongan = 0.1;
        		res += data.getPrice() - (data.getPrice() * potongan);
        	}
    	}
    	
        return res;
    }
}
