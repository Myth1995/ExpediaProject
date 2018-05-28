package com.hotels.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class OfferDateRange
{
    private String[] travelEndDate;

    private String lengthOfStay;

    private String[] travelStartDate;

    public String[] getTravelEndDate ()
    {
        return travelEndDate;
    }

    public void setTravelEndDate (String[] travelEndDate)
    {
        this.travelEndDate = travelEndDate;
    }

    public String getLengthOfStay ()
    {
        return lengthOfStay;
    }

    public void setLengthOfStay (String lengthOfStay)
    {
        this.lengthOfStay = lengthOfStay;
    }

    public String[] getTravelStartDate ()
    {
        return travelStartDate;
    }

    public void setTravelStartDate (String[] travelStartDate)
    {
        this.travelStartDate = travelStartDate;
    }

    /**
     * Date format in json: yyyy,MM,dd e.g 2018,6,28
     * @return
     * @throws ParseException
     */
    public Date getTravelStartDate_DateType() throws ParseException {
    	if(travelStartDate != null && travelStartDate.length > 0) {
    		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    		Date date = formatter.parse(travelStartDate[0]+StringUtils.leftPad(travelStartDate[1],2,"0")+StringUtils.leftPad(travelStartDate[2],2,"0"));

    		return date;
    	}
    	return null;
    }

    public Date getTravelEndDate_DateType() throws ParseException {
    	if(travelEndDate != null && travelEndDate.length > 0) {
    		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    		Date date = formatter.parse(travelEndDate[0] + StringUtils.leftPad(travelEndDate[1], 2, "0")+StringUtils.leftPad(travelEndDate[2], 2, "0"));

    		return date;
    	}
    	return null;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [travelEndDate = "+travelEndDate+", lengthOfStay = "+lengthOfStay+", travelStartDate = "+travelStartDate+"]";
    }
}