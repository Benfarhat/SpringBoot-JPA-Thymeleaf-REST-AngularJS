package org.benfarhat.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// @Table(name = "booking")
public class HotelBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String hotelName;
	private double pricePerNight;
	private int nbOfNights;
	
	public HotelBooking(String hotelName, double pricePerNight, int nbOfNights) {
		super();
		this.hotelName = hotelName;
		this.pricePerNight = pricePerNight;
		this.nbOfNights = nbOfNights;
	}
	public HotelBooking() {
		super();
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(double privePerNight) {
		this.pricePerNight = privePerNight;
	}
	public int getNbOfNights() {
		return nbOfNights;
	}
	public void setNbOfNights(int nbOfNights) {
		this.nbOfNights = nbOfNights;
	}
	@Override
	public String toString() {
		return "HotelBooking [hotelName=" + hotelName + ", pricePerNight=" + pricePerNight + ", nbOfNights="
				+ nbOfNights + "]";
	}
	public double getTotalPrice() {
		return pricePerNight * nbOfNights;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
