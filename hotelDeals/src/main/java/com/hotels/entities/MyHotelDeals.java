package com.hotels.entities;



public class MyHotelDeals {

	private Offers offers;

	private OfferInfo offerInfo;

	private UserInfo userInfo;

	public Offers getOffers ()
	{
		return offers;
	}

	public void setOffers (Offers offers)
	{
		this.offers = offers;
	}

	public OfferInfo getOfferInfo ()
	{
		return offerInfo;
	}

	public void setOfferInfo (OfferInfo offerInfo)
	{
		this.offerInfo = offerInfo;
	}

	public UserInfo getUserInfo ()
	{
		return userInfo;
	}

	public void setUserInfo (UserInfo userInfo)
	{
		this.userInfo = userInfo;
	}

	@Override
	public String toString()
	{
		return "ClassPojo [offers = "+offers+", offerInfo = "+offerInfo+", userInfo = "+userInfo+"]";
	}
}



