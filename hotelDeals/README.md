Document the instructions for setting the site up in a local sandbox in your README.md file. Also document any assumptions you've made about the API or the runtime environment. And document any known issues with your example, 
I used eclipse to create my project
To set up the project:
- I used Apache Tomcat 9 Server
- run: mvn clean install
- deploy the application on tomcat server
- once server starts, in browser hit: localhost:8080/HotelDeals/hotels.html (or any port you set in servers.txt file)

To run through command line:
- in Tomcat's tomcat-users.xml file add:
<role rolename="manager-script"/>
<user username="abc" password="123" roles="manager-script"/>
- mvn clean install
- mvn tomcat:run-war
- in browser hit: localhost:8080/HotelDeals/hotels.html

I was unable to run it on heroku. It built successfully but failed with Hroku's error code H10