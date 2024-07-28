package com.company;

import com.company.myloyal.*;
import com.company.myloyal.Error;
import com.company.myloyal.exception.MyLoyalException;
import com.company.myloyal.exception.NotFoundException;
import com.company.myloyal.repository.BookingRepository;
import com.company.myloyal.repository.CustomerRepository;
import com.company.myloyal.repository.LoyaltyPointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * test
 */
@Endpoint
public class MyLocalEndpoint {

    private static final String NAMESPACE_URI = "http://company.com/myloyal";

    private CustomerRepository customerRepository;
    private BookingRepository bookingRepository;
    private LoyaltyPointsRepository loyaltyPointsRepository;

    @Autowired
    public MyLocalEndpoint(CustomerRepository customerRepository, BookingRepository bookingRepository, LoyaltyPointsRepository loyaltyPointsRepository) {
        this.customerRepository = customerRepository;
        this.bookingRepository = bookingRepository;
        this.loyaltyPointsRepository = loyaltyPointsRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerProfileData")
    @ResponsePayload
    public GetCustomerProfileDataResponse getCustomerProfileData(@RequestPayload GetCustomerProfileData request) {
        GetCustomerProfileDataResponse response = new GetCustomerProfileDataResponse();
        try {
            response.setCustomerProfile(customerRepository.findCustomer(request.getCin()));
        }
        catch(NotFoundException ex) {
            response.setError(createError(ex));
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "retrieveCustomerBookings")
    @ResponsePayload
    public RetrieveCustomerBookingsResponse retrieveCustomerBookings(@RequestPayload RetrieveCustomerBookings request) {
        RetrieveCustomerBookingsResponse response = new RetrieveCustomerBookingsResponse();
        BookingList bookings = new BookingList();
        try {
            bookings.getBooking().addAll(bookingRepository.findBookings(request.getCin()));
        }
        catch(NotFoundException ex) {
            response.setError(createError(ex));
        }
        response.setBookingList(bookings);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchCustomerBookings")
    @ResponsePayload
    public SearchCustomerBookingsResponse retrieveCustomerBookings(@RequestPayload SearchCustomerBookings request) {
        SearchCustomerBookingsResponse response = new SearchCustomerBookingsResponse();
        BookingList bookings = new BookingList();
        try {
            bookings.getBooking().addAll(bookingRepository.findBookings(request.getCin(), request.getFromDate(), request.getToDate()));
        }
        catch(MyLoyalException ex) {
            response.setError(createError(ex));
        }
        response.setBookingList(bookings);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "retrieveCustomerLoyaltyPoints")
    @ResponsePayload
    public RetrieveCustomerLoyaltyPointsResponse retrieveCustomerBookings(@RequestPayload RetrieveCustomerLoyaltyPoints request) {
        RetrieveCustomerLoyaltyPointsResponse response = new RetrieveCustomerLoyaltyPointsResponse();
        LoyaltyPointsList loyaltyPointsList = new LoyaltyPointsList();
        try {
            loyaltyPointsList.getLoyaltyPoints().addAll(loyaltyPointsRepository.findLoyaltyPoints(request.getCin()));
        }
        catch(NotFoundException ex) {
            response.setError(createError(ex));
        }
        response.setLoyaltyPointsList(loyaltyPointsList);
        return response;
    }

    private Error createError(MyLoyalException ex) {
        Error err = new Error();
        err.setCode(ex.getCode());
        err.setMessage(ex.getMessage());
        return err;
    }

}
