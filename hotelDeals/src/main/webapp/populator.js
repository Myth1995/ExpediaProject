/**
 * Scripts for populating data in screen fields
 */

function getDestinations(){
	var destVal = document.getElementById("destinationField").innerHTML; 
	if(!destVal){
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
//				console.log(this.responseText)
				var myObj = JSON.parse(this.responseText);
				var txt = "<select name=\"destination\"><option value=\"None\" selected=\"Selected\">Select destination</option>"

				var data = myObj.Destinations;
				for (x in data) {
					txt += "<option value=\""+ data[x].id +"\">" +data[x].city + ", " +data[x].country+ "</option>";
				}
				txt += "</select>"  
					document.getElementById("destinationField").innerHTML = txt;
			} 
			else if(this.readyState == 4 && this.status == 202) {
				alert("Error contacting server, please try again later");
				document.getElementById("erroMessage").innerHTML = "Error contacting server, please try again later";
			}
		};
		
		xhttp.open("GET", "rest/HotelsFinder/HDestinations", true);
		xhttp.send();
	}
}
