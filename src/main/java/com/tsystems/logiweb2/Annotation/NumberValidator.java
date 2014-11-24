package com.tsystems.logiweb2.Annotation;

import com.tsystems.logiweb2.Repository.DriverRepository;
import com.tsystems.logiweb2.Repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by StarKiller on 23.11.2014.
 */
public class NumberValidator implements ConstraintValidator<UniqueNumber, String>{

    @Autowired
    private TruckRepository truckRepository;

    @Override
    public void initialize(UniqueNumber uniqueNumber) {

    }

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(driverRepository == null) {
            return true;
        }
        return truckRepository.findByRegNumber(s) == null;
    }
}
