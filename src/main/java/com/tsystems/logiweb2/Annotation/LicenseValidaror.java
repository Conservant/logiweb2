package com.tsystems.logiweb2.Annotation;

import com.tsystems.logiweb2.Repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by StarKiller on 23.11.2014.
 */
public class LicenseValidaror implements ConstraintValidator<UniqueLicense, String> {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public void initialize(UniqueLicense uniqueLicense) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (driverRepository == null) {
            return true;
        }
        return driverRepository.findByLicNumber(s) == null;
    }
}
