package com.hotels.entities;

public class HotelInfo
{
    private String hotelStreetAddress;

    private String hotelImageUrl;

    private String localizedHotelName;

    private String hotelStarRating;

    private String vipAccess;

    private String hotelDestination;

    private String hotelLatitude;

    private String isOfficialRating;

    private String hotelProvince;

    private String hotelDestinationRegionID;

    private String hotelId;

    private String hotelCity;

    private String hotelLongitude;

    private String hotelReviewTotal;

    private String hotelName;

    private String hotelGuestReviewRating;

    private String hotelCountryCode;

    private String hotelLongDestination;

    public String getHotelStreetAddress ()
    {
        return hotelStreetAddress;
    }

    public void setHotelStreetAddress (String hotelStreetAddress)
    {
        this.hotelStreetAddress = hotelStreetAddress;
    }

    public String getHotelImageUrl ()
    {
        return hotelImageUrl;
    }

    public void setHotelImageUrl (String hotelImageUrl)
    {
        this.hotelImageUrl = hotelImageUrl;
    }

    public String getLocalizedHotelName ()
    {
        return localizedHotelName;
    }

    public void setLocalizedHotelName (String localizedHotelName)
    {
        this.localizedHotelName = localizedHotelName;
    }

    public String getHotelStarRating ()
    {
        return hotelStarRating;
    }

    public void setHotelStarRating (String hotelStarRating)
    {
        this.hotelStarRating = hotelStarRating;
    }

    public String getVipAccess ()
    {
        return vipAccess;
    }

    public void setVipAccess (String vipAccess)
    {
        this.vipAccess = vipAccess;
    }

    public String getHotelDestination ()
    {
        return hotelDestination;
    }

    public void setHotelDestination (String hotelDestination)
    {
        this.hotelDestination = hotelDestination;
    }

    public String getHotelLatitude ()
    {
        return hotelLatitude;
    }

    public void setHotelLatitude (String hotelLatitude)
    {
        this.hotelLatitude = hotelLatitude;
    }

    public String getIsOfficialRating ()
    {
        return isOfficialRating;
    }

    public void setIsOfficialRating (String isOfficialRating)
    {
        this.isOfficialRating = isOfficialRating;
    }

    public String getHotelProvince ()
    {
        return hotelProvince;
    }

    public void setHotelProvince (String hotelProvince)
    {
        this.hotelProvince = hotelProvince;
    }

    public String getHotelDestinationRegionID ()
    {
        return hotelDestinationRegionID;
    }

    public void setHotelDestinationRegionID (String hotelDestinationRegionID)
    {
        this.hotelDestinationRegionID = hotelDestinationRegionID;
    }

    public String getHotelId ()
    {
        return hotelId;
    }

    public void setHotelId (String hotelId)
    {
        this.hotelId = hotelId;
    }

    public String getHotelCity ()
    {
        return hotelCity;
    }

    public void setHotelCity (String hotelCity)
    {
        this.hotelCity = hotelCity;
    }

    public String getHotelLongitude ()
    {
        return hotelLongitude;
    }

    public void setHotelLongitude (String hotelLongitude)
    {
        this.hotelLongitude = hotelLongitude;
    }

    public String getHotelReviewTotal ()
    {
        return hotelReviewTotal;
    }

    public void setHotelReviewTotal (String hotelReviewTotal)
    {
        this.hotelReviewTotal = hotelReviewTotal;
    }

    public String getHotelName ()
    {
        return hotelName;
    }

    public void setHotelName (String hotelName)
    {
        this.hotelName = hotelName;
    }

    public String getHotelGuestReviewRating ()
    {
        return hotelGuestReviewRating;
    }

    public void setHotelGuestReviewRating (String hotelGuestReviewRating)
    {
        this.hotelGuestReviewRating = hotelGuestReviewRating;
    }

    public String getHotelCountryCode ()
    {
        return hotelCountryCode;
    }

    public void setHotelCountryCode (String hotelCountryCode)
    {
        this.hotelCountryCode = hotelCountryCode;
    }

    public String getHotelLongDestination ()
    {
        return hotelLongDestination;
    }

    public void setHotelLongDestination (String hotelLongDestination)
    {
        this.hotelLongDestination = hotelLongDestination;
    }
    
    public float getHotelGuestReviewRatingFloat() {
    	return Float.parseFloat(hotelGuestReviewRating);
    }
    public int getHotelStarRatingInt() {
    	return Integer.parseInt(hotelStarRating);
    }

    @Override
    public String toString()
    {
        return "ClassPojo [hotelStreetAddress = "+hotelStreetAddress+", hotelImageUrl = "+hotelImageUrl+", localizedHotelName = "+localizedHotelName+", hotelStarRating = "+hotelStarRating+", vipAccess = "+vipAccess+", hotelDestination = "+hotelDestination+", hotelLatitude = "+hotelLatitude+", isOfficialRating = "+isOfficialRating+", hotelProvince = "+hotelProvince+", hotelDestinationRegionID = "+hotelDestinationRegionID+", hotelId = "+hotelId+", hotelCity = "+hotelCity+", hotelLongitude = "+hotelLongitude+", hotelReviewTotal = "+hotelReviewTotal+", hotelName = "+hotelName+", hotelGuestReviewRating = "+hotelGuestReviewRating+", hotelCountryCode = "+hotelCountryCode+", hotelLongDestination = "+hotelLongDestination+"]";
    }
}