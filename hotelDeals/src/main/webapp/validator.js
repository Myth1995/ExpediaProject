/**
 * form fields validation functions
 */

function validateForm(){
	var destination = document.forms["findHotelForm"]["destination"].value;

    if (destination == "None") {
        alert("Destination is required");
        return false;
    }
    validateFormDates();
    validatePriceFields();
    
	return true;
}

function isValidDate(date)
{
  // regular expression to match date format
  re = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
  if(!date  || !date.match(re)) {
//	    date.focus();
	    return false;
	  }
  return true;

}
function validateFormDates(){
	var minTripStartDate = document.forms["findHotelForm"]["minTripStartDate"].value;
	var maxTripStartDate = document.forms["findHotelForm"]["maxTripStartDate"].value;
	var minTripEndDate = document.forms["findHotelForm"]["minTripEndDate"].value;
	var maxTripEndDate = document.forms["findHotelForm"]["maxTripEndDate"].value;

	if(minTripStartDate  && !isValidDate(minTripStartDate)){
        alert("Invalid min trip start date");
    	return false;
    }
    if(maxTripStartDate && !isValidDate(maxTripStartDate)){
        alert("Invalid max trip end date");
    	return false;
    }
    if(minTripEndDate && !isValidDate(minTripEndDate)){
        alert("Invalid min trip End date");
    	return false;
    }
    if(maxTripEndDate && !isValidDate(maxTripEndDate)){
        alert("Invalid max trip end date");
    	return false;
    }
}
function validatePriceFields(){
	var minPriceRate = document.forms["findHotelForm"]["minPriceRate"].value;
	var maxPriceRate = document.forms["findHotelForm"]["maxPriceRate"].value;
	
	if(minPriceRate < 0){
	    	alert("Invalid minimum price value");
	    	return false;
	    }
	if(maxPriceRate < 0 ){
	    	alert("Invalid maximum price value");
	    	return false;
	    }
}