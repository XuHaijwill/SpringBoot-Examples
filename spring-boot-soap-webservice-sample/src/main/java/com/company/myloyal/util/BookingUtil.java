package com.company.myloyal.util;

import com.company.myloyal.domain.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * test
 */
@Component
public class BookingUtil {

    public Booking createBooking() {
        Booking booking = new Booking();
        booking.setBookingRef("12345");
        booking.setCustomerId("1");
        booking.getJourney().add(createJourneyOut());
        booking.getJourney().add(createJourneyIn());
        booking.getPassenger().add(createPassenger1());
        booking.getPassenger().add(createPassenger2());
        booking.getExtra().add(createExtra());
        booking.setCostSummary(createCostSummary());
        booking.setLoyaltyPoints(createLoyaltyPoints());
        return booking;
    }

    public Booking get() {
        return createBooking();
    }

    public List<Booking> getList() {
        Booking booking1 = createBooking();
        Booking booking2 = createBooking();
        booking2.setBookingRef("34567");
        booking2.getLoyaltyPoints().setBookingRef("34567");
        booking2.getJourney().get(0).setDepartureTime("2015-01-15T09:05:00Z");
        booking2.getJourney().get(0).setDepartureTime("2015-01-15T11:20:00Z");
        booking2.getJourney().get(1).setDepartureTime("2015-01-16T09:05:00Z");
        booking2.getJourney().get(1).setDepartureTime("2015-01-16T11:20:00Z");
        List<Booking> bookings = new ArrayList<Booking>();
        bookings.add(booking1);
        bookings.add(booking2);
        return bookings;
    }

    private Booking.Journey createJourneyOut() {
        Booking.Journey journey = new Booking.Journey();
        journey.setId("X34JK");
        journey.setName("London -> Paris");
        journey.setOrigin(createLondonStation());
        journey.setDestination(createParisStation());
        journey.getLeg().add(createLeg1());
        journey.getLeg().add(createLeg2());
        journey.setDirection(Direction.OUTBOUND);
        journey.setCarrier(createCarrier());
        journey.setPlatform("7");
        journey.getSeat().add("G7");
        journey.getSeat().add("G8");
        journey.setDepartureTime("2014-12-24T12:05:00Z");
        journey.setArrivalTime("2014-12-24T14:20:00Z");
        return journey;
    }

    private Booking.Journey createJourneyIn() {
        Booking.Journey journey = new Booking.Journey();
        journey.setId("Z34JK");
        journey.setName("Paris -> London");
        journey.setOrigin(createParisStation());
        journey.setDestination(createLondonStation());
        journey.getLeg().add(createLeg2());
        journey.getLeg().add(createLeg1());
        journey.setDirection(Direction.INBOUND);
        journey.setCarrier(createCarrier());
        journey.setPlatform("D");
        journey.getSeat().add("E7");
        journey.getSeat().add("E8");
        journey.setDepartureTime("2015-01-05T12:05:00Z");
        journey.setArrivalTime("2015-01-05T14:20:00Z");
        return journey;
    }

    private Station createLondonStation() {
        Station station = new Station();
        station.setId("D1234J");
        station.setName("Kings Cross St Pancrass - London");
        return station;
    }

    private Station createParisStation() {
        Station station = new Station();
        station.setId("G12004J");
        station.setName("Gare du Nord - Paris");
        return station;
    }

    private Booking.Journey.Leg createLeg1() {
        Booking.Journey.Leg leg = new Booking.Journey.Leg();
        leg.setId("675");
        leg.setStation(createLondonStation());
        leg.setOrder(1);
        return leg;
    }

    private Booking.Journey.Leg createLeg2() {
        Booking.Journey.Leg leg = new Booking.Journey.Leg();
        leg.setId("105");
        leg.setStation(createParisStation());
        leg.setOrder(2);
        return leg;
    }

    private Booking.Journey.Carrier createCarrier() {
        Booking.Journey.Carrier carrier = new Booking.Journey.Carrier();
        carrier.setId("968");
        carrier.setName("Eucompanyink");
        return carrier;
    }

    private Booking.Passenger createPassenger1() {
        Booking.Passenger pax = new Booking.Passenger();
        pax.setTitle(Title.MR);
        pax.setId("1");
        pax.setName("John");
        pax.setSurname("Smith");
        pax.setType(PassengerType.ADULT);
        pax.setDateOfBirth("1970-12-20");
        return pax;
    }

    private Booking.Passenger createPassenger2() {
        Booking.Passenger pax = new Booking.Passenger();
        pax.setTitle(Title.MISS);
        pax.setId("1");
        pax.setName("Amelie");
        pax.setSurname("Smith");
        pax.setType(PassengerType.ADULT);
        pax.setDateOfBirth("1970-12-20");
        return pax;
    }

    private Booking.Extra createExtra() {
        Booking.Extra extra = new Booking.Extra();
        extra.setId("1");
        extra.setName("Business Class");
        extra.setDescription("Business Class.");
        return extra;
    }

    private Booking.CostSummary createCostSummary() {
        Booking.CostSummary costSummary = new Booking.CostSummary();
        Booking.CostSummary.CostingItem costItem1 = new Booking.CostSummary.CostingItem();
        costItem1.setId("1");
        costItem1.setName("2 x ADULT");
        costItem1.setDescription("2 Adults - London->Paris");
        costItem1.setQuantity(2);
        costItem1.setUnitAmount(BigDecimal.valueOf(50.00));
        costItem1.setTotalAmount(BigDecimal.valueOf(100.00));
        costSummary.getCostingItem().add(costItem1);

        Booking.CostSummary.CostingItem costItem2 = new Booking.CostSummary.CostingItem();
        costItem2.setId("2");
        costItem2.setName("2 x ADULT");
        costItem2.setDescription("2 Adults - Paris->London");
        costItem2.setQuantity(2);
        costItem2.setUnitAmount(BigDecimal.valueOf(70.00));
        costItem2.setTotalAmount(BigDecimal.valueOf(140.00));
        costSummary.getCostingItem().add(costItem2);

        Booking.CostSummary.CostingItem costItem3 = new Booking.CostSummary.CostingItem();
        costItem3.setId("3");
        costItem3.setName("2 x ADULT");
        costItem3.setDescription("2 Adults - Business extra London->Paris");
        costItem3.setQuantity(2);
        costItem3.setUnitAmount(BigDecimal.valueOf(10.00));
        costItem3.setTotalAmount(BigDecimal.valueOf(20.00));
        costSummary.getCostingItem().add(costItem3);

        Booking.CostSummary.CostingItem costItem4 = new Booking.CostSummary.CostingItem();
        costItem4.setId("4");
        costItem4.setName("2 x ADULT");
        costItem4.setDescription("2 Adults - Business extra Paris->London");
        costItem4.setQuantity(2);
        costItem4.setUnitAmount(BigDecimal.valueOf(10.00));
        costItem4.setTotalAmount(BigDecimal.valueOf(20.00));
        costSummary.getCostingItem().add(costItem4);

        costSummary.setGrossAmount(BigDecimal.valueOf(220.00));
        costSummary.setTaxesAmount(BigDecimal.valueOf(40.00));
        costSummary.setDiscountAmount(BigDecimal.valueOf(100.00));
        return costSummary;
    }

    private LoyaltyPoints createLoyaltyPoints() {
        LoyaltyPoints points = new LoyaltyPoints();
        points.setId("1");
        points.setBookingRef("12345");
        points.setName("EuroStar loyalty points");
        points.setNumPoints(20);
        return points;
    }
}
