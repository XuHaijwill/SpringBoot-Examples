package com.company.myloyal.util;

import com.company.myloyal.domain.LoyaltyPoints;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * test
 */
@Component
public class LoyaltyPointsUtil {

    public List<LoyaltyPoints> get() {
        List<LoyaltyPoints> points = new ArrayList<LoyaltyPoints>();
        points.add(createLoyaltyPoints1());
        points.add(createLoyaltyPoints2());
        return points;
    }

    private LoyaltyPoints createLoyaltyPoints1() {
        LoyaltyPoints loyaltyPoints = new LoyaltyPoints();
        loyaltyPoints.setId("1");
        loyaltyPoints.setBookingRef("12345");
        loyaltyPoints.setName("Loyalty points");
        loyaltyPoints.setNumPoints(20);
        return loyaltyPoints;
    }

    private LoyaltyPoints createLoyaltyPoints2() {
        LoyaltyPoints loyaltyPoints = new LoyaltyPoints();
        loyaltyPoints.setId("2");
        loyaltyPoints.setBookingRef("34567");
        loyaltyPoints.setName("Loyalty points");
        loyaltyPoints.setNumPoints(20);
        return loyaltyPoints;
    }

}
