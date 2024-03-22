package com.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;
import com.booking.repositories.PersonRepository;
import com.booking.repositories.ServiceRepository;

public class MenuService {
    private static List<Person> listPerson = PersonRepository.getAllPerson();
    private static List<Service> serviceList = ServiceRepository.getAllService();
    private static List<Reservation> reservationList = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void mainMenu() {
        String[] mainMenuArr = {"Show Data", "Create Reservation", "Complete/cancel reservation", "Exit"};
        String[] subMenuArr = {"Recent Reservation", "Show Customer", "Show Available Employee", "Show Reservation History", "Back to main menu"};
    
        int optionMainMenu;
        int optionSubMenu;

		boolean backToMainMenu = false;
        boolean backToSubMenu = false;
        do {
            PrintService.printMenu("Main Menu", mainMenuArr);
            optionMainMenu = Integer.valueOf(input.nextLine());
            switch (optionMainMenu) {
                case 1:
                    do {
                        PrintService.printMenu("Show Data", subMenuArr);
                        optionSubMenu = Integer.valueOf(input.nextLine());
                        // Sub menu - menu 1
                        switch (optionSubMenu) {
                            case 1:
                                // panggil fitur tampilkan recent reservation
                            	PrintService.showRecentReservation(reservationList);
                                break;
                            case 2:
                                // panggil fitur tampilkan semua customer
                            	PrintService.showAllCustomer(listPerson);
                                break;
                            case 3:
                                // panggil fitur tampilkan semua employee
                            	PrintService.showAllEmployee(listPerson);
                                break;
                            case 4:
                                // panggil fitur tampilkan history reservation + total keuntungan
                            	PrintService.showHistoryReservation(reservationList);
                                break;
                            case 0:
                                backToSubMenu = false;
                        }
                    } while (backToSubMenu);
                    break;
                case 2:
                    // panggil fitur menambahkan reservation
//                	PrintService.showAllCustomer(listPerson);
//                	String customerId = "";
//                	customerId = ValidationService.validateCustomerId(input, customerId, listPerson);
//                	
//                	PrintService.showAllEmployee(listPerson);
//                	String employeeId = "";
//                	employeeId = ValidationService.validateEmployeeId(input, employeeId, listPerson);
//                	
//                	PrintService.showAllServices(serviceList);
//                	String serviceId = "";
//                	serviceId = ValidationService.getService(input, serviceId, serviceList);
                		
                	ReservationService.createReservation(listPerson, input, serviceList, reservationList);
                	
                    break;
                case 3:
                    // panggil fitur mengubah workstage menjadi finish/cancel
                	PrintService.showStageReservation(reservationList);
                	String reservationId = "";
                	reservationId = ValidationService.validateReservationId(input, reservationId, reservationList);
                	String stage = "";
                	stage = ValidationService.stageReservation(input, stage);
                	
                	ReservationService.editReservationWorkstage(reservationId, stage, reservationList);
                	
                    break;
                case 0:
                    backToMainMenu = false;
                    break;
            }
        } while (!backToMainMenu);
		
	}
}
