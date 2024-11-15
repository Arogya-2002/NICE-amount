package com.project.models;

import java.time.LocalDateTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "backup")
public class Backup {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Customer information
    private Long customerId;
    private String customerName;
    private String cnumber;
    private String cadharno;
    
    // Hotel information
    private Long hotelId;
    private String hotelName;
    private String hotelAddress;
    private Double roomBill;
    
    private Double foodBill;
    // Food types and charges
//    @ElementCollection
//    @CollectionTable(name = "food_items", joinColumns = @JoinColumn(name = "backup_id"))
//    @MapKeyColumn(name = "food_type")
//    @Column(name = "charge")
   // private Map<String, Double> foodItems; // Stores food type and its charge

    // Additional details like date/time of backup
    private LocalDateTime backupDate;
    
    @SuppressWarnings("unused")
	private boolean amountPaid=false;

    

    
    

	public Backup() {
		super();
		// TODO Auto-generated constructor stub
	}







	public Backup(Long id, Long customerId, String customerName, String cnumber, String cadharno, Long hotelId,
			String hotelName, String hotelAddress, Double roomBill, Double foodBill,
			LocalDateTime backupDate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.customerName = customerName;
		this.setCnumber(cnumber);
		this.setCadharno(cadharno);
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.setHotelAddress(hotelAddress);
		this.roomBill = roomBill;
		this.foodBill = foodBill;
		this.backupDate = backupDate;
	}







	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getCustomerId() {
		return customerId;
	}



	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public Long getHotelId() {
		return hotelId;
	}



	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}



	public String getHotelName() {
		return hotelName;
	}



	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}





	public LocalDateTime getBackupDate() {
		return backupDate;
	}



	public void setBackupDate(LocalDateTime backupDate) {
		this.backupDate = backupDate;
	}



	public Double getRoomBill() {
		return roomBill;
	}



	public void setRoomBill(Double roomBill) {
		this.roomBill = roomBill;
	}



	public Double getFoodBill() {
		return foodBill;
	}



	public void setFoodBill(Double foodBill) {
		this.foodBill = foodBill;
	}







	public String getHotelAddress() {
		return hotelAddress;
	}







	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}







	public String getCnumber() {
		return cnumber;
	}







	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}







	public String getCadharno() {
		return cadharno;
	}







	public void setCadharno(String cadharno) {
		this.cadharno = cadharno;
	}
    
    
    

}