package com.hotels.entities;
import java.util.List;

public class Offers
{	
	public List<Hotel> Hotel;
	
	public List<Hotel> getHotel() {
		return Hotel;
	}

	public void setHotel(List<Hotel> hotel) {
		Hotel = hotel;
	}
	
    @Override
    public String toString()
    {
        return "ClassPojo [Hotel = "+Hotel+"]";
    }
}
