package com.hotels.entities;



public class OfferInfo
{
    private String siteID;

    private String userSelectedCurrency;

    private String language;

    private String currency;

    public String getSiteID ()
    {
        return siteID;
    }

    public void setSiteID (String siteID)
    {
        this.siteID = siteID;
    }

    public String getUserSelectedCurrency ()
    {
        return userSelectedCurrency;
    }

    public void setUserSelectedCurrency (String userSelectedCurrency)
    {
        this.userSelectedCurrency = userSelectedCurrency;
    }

    public String getLanguage ()
    {
        return language;
    }

    public void setLanguage (String language)
    {
        this.language = language;
    }

    public String getCurrency ()
    {
        return currency;
    }

    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [siteID = "+siteID+", userSelectedCurrency = "+userSelectedCurrency+", language = "+language+", currency = "+currency+"]";
    }
}
