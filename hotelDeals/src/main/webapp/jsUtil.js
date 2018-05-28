/**
 * scripts to load page and show result in page
 */
function initPage(){
	var lastDestVal;
	var lastMinTripStartDate;
	
	getDestinations();
	dest= document.getElementById("destination");
	minStartDate = document.getElementById("minTripStartDate");
	maxStartDate = document.getElementById("maxTripStartDate");
	document.getElementById("errorMessage").value = null;

	var searchBtn = document.getElementById("findBtn");
	searchBtn.onclick = showResult;
}


function showResult(e){
	e.preventDefault();
	document.getElementById("errorMessage").innerHTML = "";
	document.getElementById("result").innerHTML = "";

	if(!validateForm()){
		return false;
	}
	getData();
}

function getData(){
	var destination = document.forms["findHotelForm"]["destination"].value;
	
	var minTripStartDate = document.forms["findHotelForm"]["minTripStartDate"].value;
	var maxTripStartDate = document.forms["findHotelForm"]["maxTripStartDate"].value;
	var minTripEndDate = document.forms["findHotelForm"]["minTripEndDate"].value;
	var maxTripEndDate = document.forms["findHotelForm"]["maxTripEndDate"].value;

	var minPriceRate = document.forms["findHotelForm"]["minPriceRate"].value;
	var maxPriceRate = document.forms["findHotelForm"]["maxPriceRate"].value;
	var minRating = document.forms["findHotelForm"]["minRating"].value;
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 ) {
			if ( this.status == 200) {	
//				console.log(this.responseText);
				var myObj = JSON.parse(this.responseText);
				var txt = "<table border='0' class='resultTable'>";
				var data = myObj.matchingHotels;
				for (x in data) {
					txt += "<tr><td><a href='"+data[x].hotelUrls.hotelInfositeUrl+"'><strong class='hotelName'>" + data[x].hotelInfo.hotelName + "</strong></td>" +
								"<td><img src='"+ data[x].hotelInfo.hotelImageUrl+"'/></td></tr> " +
							"<tr><td> Province: " +data[x].hotelInfo.hotelProvince + ", Street: "+ data[x].hotelInfo.hotelStreetAddress + 
								"<br>"+data[x].hotelInfo.hotelCity + ", "+ data[x].hotelInfo.hotelCountryCode + "</td>"+ 
								"<td><div id='map"+ x+"' class='mapStyle'></div></td></tr>"+
							"<tr><td> Hotel Star Rating: " + data[x].hotelInfo.hotelStarRating +" <img class='starImg' src='star_small1.png'/></td><tr>"+
							"<tr><td>Guests Rating: " + data[x].hotelInfo.hotelGuestReviewRating + " <img class='starImg' src='blueStar.png'/></td><td>" + 
								data[x].hotelInfo.hotelReviewTotal+" total reviews</td></tr>"+			
							"<tr><td class='offerDate''>Travelling Date: " + data[x].offerDateRange.travelStartDate[3] + " - Return date: " + 
								data[x].offerDateRange.travelEndDate[3]+"</td></tr>"+
							"<tr><td>Total Price Value: <span class='totalPrice'>" + data[x].hotelPricingInfo.totalPriceValue+" USD</span><br>Average Price per Night: " + 
								data[x].hotelPricingInfo.averagePriceValue+"</td><td>Original price per Night: " + data[x].hotelPricingInfo.originalPricePerNight + 
								"<br><strong>Percent savings: " + data[x].hotelPricingInfo.percentSavings+"%<strong><br></td></tr></br>";				
				}

				txt += "</table>"  ;
				document.getElementById("result").innerHTML = txt;

				setMaps(data);
			}else if(this.status == 204){
				document.getElementById("errorMessage").innerHTML = "No match found, please try other criteria";
			}
		}
	}
	xhttp.open("POST", "rest/HotelsFinder/doFind?destination=" + destination + "&minTripStartDate=" + minTripStartDate +
			"&maxTripStartDate=" + maxTripStartDate + "&minTripEndDate=" + minTripEndDate + "&maxTripEndDate=" + maxTripEndDate+
			"&minPriceRate=" + minPriceRate + "&maxPriceRate=" + maxPriceRate+"&minRating=" + minRating, false);
	xhttp.send();
}

function setMaps(data){
	for (x in data) {
		var lat=data[x].hotelInfo.hotelLatitude;
		var lng = data[x].hotelInfo.hotelLongitude;
		initMap(lat, lng, "map" + x);
	}
}

function initMap(lat, lng, elementId){
	var myLatlng = new google.maps.LatLng(lat,lng);
	var mapOptions = {
			  zoom: 7,
			  center: myLatlng
			}

	var map = new google.maps.Map(document.getElementById(elementId), mapOptions);
	var marker = new google.maps.Marker({
	    position: myLatlng,
	    title:elementId
	});
	marker.setMap(map);
}
