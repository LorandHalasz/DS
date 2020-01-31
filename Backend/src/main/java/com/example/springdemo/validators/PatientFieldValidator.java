package com.example.springdemo.validators;

import com.example.springdemo.dto.PatientDTO;
import com.example.springdemo.errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class PatientFieldValidator {
    private static final Log LOGGER = LogFactory.getLog(PatientFieldValidator.class);

    public static void validateInsertOrUpdate(PatientDTO patientDTO){

        List<String> errors = new ArrayList<>();

        if(patientDTO == null) {
            errors.add("patientDTO is null");
        }

        if (patientDTO.getUsername() == null && patientDTO.getCaregiverName() == null) {
            errors.add("patientDTO doesn't has all the fields completed");
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(PatientFieldValidator.class.getSimpleName(), errors);
        }
    }
}
