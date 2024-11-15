package com.project.serviceimplements;


import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.exception.Mycustomexception;
import com.project.models.Customer_Model;
import com.project.models.Hotel_Model;
import com.project.repository.Admin_Repository;
import com.project.repository.Hotel_Repository;
import com.project.service.Admin_Service;
import com.project.service.BackupService;
@Service
public class AdminServiceImpl implements Admin_Service{

	@SuppressWarnings("unused")
	@Autowired
	private Admin_Repository admin_Repository;
	
	@Autowired
	private Hotel_Repository hotel_Repository;
	
	@Autowired
	private BackupService backService;
	
	@Autowired
	private Customer_Model customer_Model;
	
	@Autowired
	private Hotel_Model hotel_Model;
	
	@Override
	public String getRoomBill(Long cid) {
	    // Check if the customer exists using findById
	    Optional<Hotel_Model> optionalHotelModel = hotel_Repository.findById(cid);

	    if (optionalHotelModel.isPresent()) {
	        Hotel_Model hotelModel = optionalHotelModel.get();
	      //  return hotelModel.getRoomBill() != null ? hotelModel.getRoomBill(): 0.0;
	        //WE NEED TO SET THE TYPE HERE
	        return "Room Bill:\n Type:"+"\n cost:"+hotelModel.getRoomBill();
	    } else {
	        throw new Mycustomexception("Customer with ID " + cid + " not found",HttpStatus.NOT_FOUND);
	    }
	}
@Override
public String getFoodBill(Long cid) {
    // Check if the customer exists using findById
    Optional<Hotel_Model> optionalHotelModel = hotel_Repository.findById(cid);

    if (optionalHotelModel.isPresent()) {
        Hotel_Model hotelModel = optionalHotelModel.get();
        // Safely return the room bill or 0.0 if it's null
        //return hotelModel.getRoomBill() != null ? hotelModel.getFoodBil(): 0.0;
        return "Food Bill:\n"+" cost:"+hotelModel.getFoodBil();
    } else {
        throw new Mycustomexception("Customer with ID " + cid + " not found",HttpStatus.NOT_FOUND);
    }
}

@Override
public Double getTotalBill(Long cid) {
	Optional<Hotel_Model> optionalHotelModel = hotel_Repository.findById(cid);

    if (optionalHotelModel.isPresent()) {
        Hotel_Model hotelModel = optionalHotelModel.get();
        // Safely return the room bill or 0.0 if it's null
        return hotelModel.getRoomBill() != null ? hotelModel.getRoomBill()+hotelModel.getFoodBil(): 0.0;
    } else {
        throw new Mycustomexception("Customer with ID " + cid + " not found",HttpStatus.NOT_FOUND);
    }


}

public String AmountPaid(Long cid) {
	
	Optional<Hotel_Model> optionalHotelModel = hotel_Repository.findById(cid);
	 if (optionalHotelModel.isPresent()) {
	        BackupService.createBackup(customer_Model, hotel_Model);
	        return "paid";
       }
	 else {
		 throw new Mycustomexception("Payment failed",HttpStatus.BAD_REQUEST);
	 }

}
}


 

