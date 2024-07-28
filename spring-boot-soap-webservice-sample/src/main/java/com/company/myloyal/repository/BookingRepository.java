package com.company.myloyal.repository;

import com.company.myloyal.domain.Booking;
import com.company.myloyal.exception.DateFormatException;
import com.company.myloyal.exception.NotFoundException;
import com.company.myloyal.util.BookingUtil;
import com.company.myloyal.util.DateUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * test
 */
@Repository
public class BookingRepository {

    @Autowired
    private BookingUtil bookingUtil;

    private static final List<Booking> bookings = new ArrayList<Booking>();

    @PostConstruct
    public void initData() {
        bookings.addAll(bookingUtil.getList());
    }

    public List<Booking> findBookings(String customerId) throws NotFoundException {

        if(!customerId.equals("1")) {
            throw new NotFoundException("404", "Customer does not exist");
        }

        return bookings;
    }

    public List<Booking> findBookings(String customerId, String fromDate, String toDate) throws NotFoundException, DateFormatException {

        List<Booking> bookingList = bookingUtil.getList();

        if(!customerId.equals("1")) {
            throw new NotFoundException("404", "Customer does not exist");
        }

        Date from = DateUtil.toDate(fromDate);
        Date to = DateUtil.toDate(toDate);

        for(Iterator<Booking> iterator = bookingList.iterator(); iterator.hasNext(); ) {
            Booking booking = iterator.next();
            Date deptTime = DateUtil.toDatetime(booking.getJourney().get(0).getDepartureTime());
            Date arrTime = DateUtil.toDatetime(booking.getJourney().get(booking.getJourney().size() - 1).getArrivalTime());
            if(from.after(deptTime)
            || to.before(arrTime)) {
                iterator.remove();
            }
        }

        return bookingList;
    }

}
