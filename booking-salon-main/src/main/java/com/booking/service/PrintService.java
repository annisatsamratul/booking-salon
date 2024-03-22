package com.booking.service;

import java.util.List;

import com.booking.models.Customer;
import com.booking.models.Employee;
import com.booking.models.Person;
import com.booking.models.Reservation;
import com.booking.models.Service;

public class PrintService {
    public static void printMenu(String title, String[] menuArr){
        int num = 1;
        System.out.println(title);
        for (int i = 0; i < menuArr.length; i++) {
            if (i == (menuArr.length - 1)) {   
                num = 0;
            }
            System.out.println(num + ". " + menuArr[i]);   
            num++;
        }
    }

    public static String printServices(List<Service> addservice){
        String result = "";
        for (Service service : addservice) {
        	if(addservice.size() <= 1) {
        		result = service.getServiceName();
        	}else {
        		result += service.getServiceName() + ", ";
        	}
        }
        return result;
    }

    // Function yang dibuat hanya sebgai contoh bisa disesuaikan kembali
    public static void showRecentReservation(List<Reservation> reservationList){
        int num = 1;
        System.out.println("+================================================================================================+");
        System.out.printf("| %-4s | %-4s | %-11s | %-15s | %-15s | %-15s | %-10s |\n",
                "No.", "ID", "Nama Customer", "Service", "Biaya Service", "Pegawai", "Workstage");
        System.out.println("+================================================================================================+");
        for (Reservation reservation : reservationList) {
            if (reservation.getWorkstage().equalsIgnoreCase("Waiting") || reservation.getWorkstage().equalsIgnoreCase("In process")) {
                System.out.printf("| %-4s | %-4s | %-11s | %-15s | %,15.2f | %-15s | %-10s |\n",
                num, reservation.getReservationId(), reservation.getCustomer().getName(), printServices(reservation.getServices()), reservation.getReservationPrice(), reservation.getEmployee().getName(), reservation.getWorkstage());
                num++;
            }
        }
        System.out.println("+================================================================================================+");
    }

    public static void showAllCustomer(List<Person> listPerson){
    	int num = 1;
    	 System.out.println("+=========================================================================================+");
        System.out.printf("| %-4s | %-10s | %-15s | %-15s | %-13s | %-15s |\n",
                "No.", "ID", "Nama Customer", "Alamat", "Membership", "Uang");
        System.out.println("+=========================================================================================+");
        for (Person data : listPerson) {
            if (data instanceof Customer) {
                System.out.printf("| %-4s | %-10s | %-15s | %-15s | %-13s | %,15.2f |\n",
                num, data.getId(), data.getName(), data.getAddress(), ((Customer)data).getMember().getMembershipName(), ((Customer)data).getWallet());
                num++;
            }
        }
        System.out.println("+=========================================================================================+");
    }

    public static void showAllEmployee(List<Person> listPerson){
    	int num = 1;
        System.out.println("+=======================================================================+");
        System.out.printf("| %-4s | %-10s | %-15s | %-15s | %-13s |\n",
                "No.", "ID", "Nama Employee", "Alamat", "Pengalaman");
        System.out.println("+=======================================================================+");
        for (Person data : listPerson) {
            if (data instanceof Employee) {
                System.out.printf("| %-4s | %-10s | %-15s | %-15s | %-13s |\n",
                num, data.getId(), data.getName(), data.getAddress(), ((Employee)data).getExperience());
                num++;
            }
        }
        System.out.println("+=======================================================================+");
    }

    public static void showHistoryReservation(List<Reservation> reservationList){
    	int num = 1;
        System.out.println("+======================================================================================+");
        System.out.printf("| %-4s | %-10s | %-15s | %-15s | %-15s | %-10s |\n",
                "No.", "ID", "Nama Customer", "Service", "Total Biaya", "Workstage");
        System.out.println("+======================================================================================+");
        for (Reservation data : reservationList) {
            System.out.printf("| %-4s | %-10s | %-15s | %-15s | %,15.2f | %-10s |\n",
            num, data.getReservationId(), data.getCustomer().getName(),  printServices(data.getServices()), ReservationService.getTotalBiaya(reservationList), data.getWorkstage());
            num++;
        }
        System.out.println("+======================================================================================+");
        System.out.printf ("| Total Keuntungan                                      | %,28.2f |\n", 
        		ReservationService.getTotalKeuntungan(reservationList));
        System.out.println("+======================================================================================+");
    }
    
    public static void showAllServices(List<Service> serviceList){
    	int num = 1;
        System.out.println("+============================================================+");
        System.out.printf("| %-4s | %-10s | %-20s | %-15s |\n",
                "No.", "ID", "Nama Service", "Harga");
        System.out.println("+============================================================+");
        for (Service data : serviceList) {
           System.out.printf("| %-4s | %-10s | %-20s | %,15.2f |\n",
           num, data.getServiceId(), data.getServiceName(), data.getPrice());
           num++;
        }
        System.out.println("+============================================================+");
    }
    
    public static void showStageReservation(List<Reservation> reservationList){
    	int num = 1;
        System.out.println("+===================================================================+");
        System.out.printf("| %-4s | %-10s | %-15s | %-15s | %-10s |\n",
                "No.", "ID", "Nama Customer", "Service",  "Workstage");
        System.out.println("+===================================================================+");
        for (Reservation data : reservationList) {
            System.out.printf("| %-4s | %-10s | %-15s | %-15s | %-10s |\n",
            num, data.getReservationId(), data.getCustomer().getName(),  printServices(data.getServices()), data.getWorkstage());
            num++;
        }
        System.out.println("+===================================================================+");
    }
}
