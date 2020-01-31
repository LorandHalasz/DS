package com.example.springdemo.validators;

import com.example.springdemo.dto.MedicationDTO;
import com.example.springdemo.dto.MedicationPlanDTO;
import com.example.springdemo.errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;


public class MedicationPlanFieldValidator {

    private static final Log LOGGER = LogFactory.getLog(MedicationFieldValidator.class);

    public static void validateInsertOrUpdate(MedicationPlanDTO medicationPlanDTO){

        List<String> errors = new ArrayList<>();

        if(medicationPlanDTO == null) {
            errors.add("medicationPlanDTO is null");
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(MedicationFieldValidator.class.getSimpleName(), errors);
        }
    }
}
