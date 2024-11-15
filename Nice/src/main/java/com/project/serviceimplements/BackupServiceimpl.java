package com.project.serviceimplements;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.models.Backup;
import com.project.models.Customer_Model;
import com.project.models.Hotel_Model;
import com.project.repository.BackupRepository;
import com.project.service.BackupService;

@Service
public class BackupServiceimpl implements BackupService {
	
	@Autowired
	private BackupRepository backupRepository;
	
	@Override
	public Backup createBackup(Customer_Model customer, Hotel_Model hotel) {
		Backup backup = new Backup();
		//ASSIGNING CUSTOMER DETAILS
		backup.setCustomerId(customer.getCid());
		backup.setCustomerName(customer.getCname());
		backup.setCnumber(customer.getCnumber());
		backup.setCadharno(customer.getCadharno());
		
		//ASSIGNING HOTEL DETAILS
		
		backup.setHotelId(hotel.getHotelid());
		backup.setHotelName(hotel.getHotelname());
		backup.setHotelAddress(hotel.getHotelAddress());
		backup.setRoomBill(hotel.getRoomBill());
		backup.setFoodBill(hotel.getFoodBil());
		backup.setBackupDate(LocalDateTime.now());
		
		
		return backupRepository.save(backup);
	}
}
