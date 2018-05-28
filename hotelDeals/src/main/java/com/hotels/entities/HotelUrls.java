package com.hotels.entities;

public class HotelUrls
{
    private String hotelSearchResultUrl;

    private String hotelInfositeUrl;

    public String getHotelSearchResultUrl ()
    {
        return hotelSearchResultUrl;
    }

    public void setHotelSearchResultUrl (String hotelSearchResultUrl)
    {
        this.hotelSearchResultUrl = hotelSearchResultUrl;
    }

    public String getHotelInfositeUrl ()
    {
        return hotelInfositeUrl;
    }

    public void setHotelInfositeUrl (String hotelInfositeUrl)
    {
        this.hotelInfositeUrl = hotelInfositeUrl;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [hotelSearchResultUrl = "+hotelSearchResultUrl+", hotelInfositeUrl = "+hotelInfositeUrl+"]";
    }
}