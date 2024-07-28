----------

Build and run SOAP webservice:

1.- mvn clean install
2.- java -jar target/my-loyal-api-service-1.0.0.jar

----------

Endpoint to download SOAP webservice contract:

http://localhost:8080/ws/myloyal.wsdl

Also available in ./schemas folder

----------

To send request to the SOAP service, go inside the ./mocks folder and run:

Get customer:
curl --header "content-type: text/xml" -d @requestGetCustomer.xml http://localhost:8080/ws

Get customer bookings:
curl --header "content-type: text/xml" -d @requestRetrieveCustomerBookings.xml http://localhost:8080/ws

Search customer bookings:
curl --header "content-type: text/xml" -d @requestSearchCustomerBookings.xml http://localhost:8080/ws

Get customer Loyalty points:
curl --header "content-type: text/xml" -d @requestRetrieveCustomerLoyaltyPoints.xml http://localhost:8080/ws

--------------------
git clone https://github.com/jmbataller/spring-boot-soap-webservice-sample.git
