package com.hotels.entities;



public class HotelPricingInfo
{
    private String totalPriceValue;

    private String averagePriceValue;

    private String originalPricePerNight;

    private String drr;

    private String percentSavings;

    private String currency;

    private String crossOutPriceValue;

    public String getTotalPriceValue ()
    {
        return totalPriceValue;
    }

    public void setTotalPriceValue (String totalPriceValue)
    {
        this.totalPriceValue = totalPriceValue;
    }

    public String getAveragePriceValue ()
    {
        return averagePriceValue;
    }

    public void setAveragePriceValue (String averagePriceValue)
    {
        this.averagePriceValue = averagePriceValue;
    }

    public String getOriginalPricePerNight ()
    {
        return originalPricePerNight;
    }

    public void setOriginalPricePerNight (String originalPricePerNight)
    {
        this.originalPricePerNight = originalPricePerNight;
    }

    public String getDrr ()
    {
        return drr;
    }

    public void setDrr (String drr)
    {
        this.drr = drr;
    }

    public String getPercentSavings ()
    {
        return percentSavings;
    }

    public void setPercentSavings (String percentSavings)
    {
        this.percentSavings = percentSavings;
    }

    public String getCurrency ()
    {
        return currency;
    }

    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    public String getCrossOutPriceValue ()
    {
        return crossOutPriceValue;
    }

    public void setCrossOutPriceValue (String crossOutPriceValue)
    {
        this.crossOutPriceValue = crossOutPriceValue;
    }

    public Double getAveragePriceValue_Double()
    {
        return Double.parseDouble(averagePriceValue);
    }
    
    @Override
    public String toString()
    {
        return "ClassPojo [totalPriceValue = "+totalPriceValue+", averagePriceValue = "+averagePriceValue+", originalPricePerNight = "+originalPricePerNight+", drr = "+drr+", percentSavings = "+percentSavings+", currency = "+currency+", crossOutPriceValue = "+crossOutPriceValue+"]";
    }
}
			
			