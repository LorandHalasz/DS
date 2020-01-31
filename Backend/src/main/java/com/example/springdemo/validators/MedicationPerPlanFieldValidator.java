package com.example.springdemo.validators;

import com.example.springdemo.dto.MedicationPerPlanDTO;
import com.example.springdemo.errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class MedicationPerPlanFieldValidator {

    private static final Log LOGGER = LogFactory.getLog(MedicationFieldValidator.class);

    public static void validateInsertOrUpdate(MedicationPerPlanDTO medicationPerPlanDTO){

        List<String> errors = new ArrayList<>();

        if(medicationPerPlanDTO == null) {
            errors.add("medicationPerPlanDTO is null");
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(MedicationFieldValidator.class.getSimpleName(), errors);
        }
    }
}
