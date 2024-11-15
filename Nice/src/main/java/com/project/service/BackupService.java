package com.project.service;

import com.project.models.Backup;
import com.project.models.Customer_Model;
import com.project.models.Hotel_Model;

public interface BackupService {

	public Backup createBackup(Customer_Model customer, Hotel_Model hotel);
	
}
