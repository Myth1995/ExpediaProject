package com.hotels.entities;


public class Destination
{
    private String province;

    private String longName;

    private String nonLocalizedCity;

    private String tla;

    private String shortName;

    private String associatedMultiCityRegionId;

    private String regionID;

    private String city;

    private String country;

    public String getProvince ()
    {
        return province;
    }

    public void setProvince (String province)
    {
        this.province = province;
    }

    public String getLongName ()
    {
        return longName;
    }

    public void setLongName (String longName)
    {
        this.longName = longName;
    }

    public String getNonLocalizedCity ()
    {
        return nonLocalizedCity;
    }

    public void setNonLocalizedCity (String nonLocalizedCity)
    {
        this.nonLocalizedCity = nonLocalizedCity;
    }

    public String getTla ()
    {
        return tla;
    }

    public void setTla (String tla)
    {
        this.tla = tla;
    }

    public String getShortName ()
    {
        return shortName;
    }

    public void setShortName (String shortName)
    {
        this.shortName = shortName;
    }

    public String getAssociatedMultiCityRegionId ()
    {
        return associatedMultiCityRegionId;
    }

    public void setAssociatedMultiCityRegionId (String associatedMultiCityRegionId)
    {
        this.associatedMultiCityRegionId = associatedMultiCityRegionId;
    }

    public String getRegionID ()
    {
        return regionID;
    }

    public void setRegionID (String regionID)
    {
        this.regionID = regionID;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    public String getCountry ()
    {
        return country;
    }

    public void setCountry (String country)
    {
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [province = "+province+", longName = "+longName+", nonLocalizedCity = "+nonLocalizedCity+", tla = "+tla+", shortName = "+shortName+", associatedMultiCityRegionId = "+associatedMultiCityRegionId+", regionID = "+regionID+", city = "+city+", country = "+country+"]";
    }
}