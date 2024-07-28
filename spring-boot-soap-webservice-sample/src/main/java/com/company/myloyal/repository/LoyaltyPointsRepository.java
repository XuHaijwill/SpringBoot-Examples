package com.company.myloyal.repository;

import com.company.myloyal.domain.LoyaltyPoints;
import com.company.myloyal.exception.NotFoundException;
import com.company.myloyal.util.LoyaltyPointsUtil;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * test
 */
@Repository
public class LoyaltyPointsRepository {

    @Autowired
    private LoyaltyPointsUtil loyaltyPointsUtil;

    private static final List<LoyaltyPoints> loyaltyPoints = new ArrayList<LoyaltyPoints>();

    @PostConstruct
    public void initData() {
        loyaltyPoints.addAll(loyaltyPointsUtil.get());
    }

    public List<LoyaltyPoints> findLoyaltyPoints(String customerId) throws NotFoundException {

        if(!customerId.equals("1")) {
            throw new NotFoundException("404", "Customer does not exist");
        }

        return loyaltyPoints;
    }

}
