package com.hotels.entities;



public class Hotel
{
    private OfferDateRange offerDateRange;

    private HotelUrls hotelUrls;

    private HotelInfo hotelInfo;

    private HotelPricingInfo hotelPricingInfo;

    private Destination destination;

    public OfferDateRange getOfferDateRange ()
    {
        return offerDateRange;
    }

    public void setOfferDateRange (OfferDateRange offerDateRange)
    {
        this.offerDateRange = offerDateRange;
    }

    public HotelUrls getHotelUrls ()
    {
        return hotelUrls;
    }

    public void setHotelUrls (HotelUrls hotelUrls)
    {
        this.hotelUrls = hotelUrls;
    }

    public HotelInfo getHotelInfo ()
    {
        return hotelInfo;
    }

    public void setHotelInfo (HotelInfo hotelInfo)
    {
        this.hotelInfo = hotelInfo;
    }

    public HotelPricingInfo getHotelPricingInfo ()
    {
        return hotelPricingInfo;
    }

    public void setHotelPricingInfo (HotelPricingInfo hotelPricingInfo)
    {
        this.hotelPricingInfo = hotelPricingInfo;
    }

    public Destination getDestination ()
    {
        return destination;
    }

    public void setDestination (Destination destination)
    {
        this.destination = destination;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [offerDateRange = "+offerDateRange+", hotelUrls = "+hotelUrls+", hotelInfo = "+hotelInfo+", hotelPricingInfo = "+hotelPricingInfo+", destination = "+destination+"]";
    }
}
	