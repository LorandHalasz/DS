package com.example.springdemo.validators;

import com.example.springdemo.dto.MedicationDTO;
import com.example.springdemo.dto.UserDTO;
import com.example.springdemo.errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class MedicationFieldValidator {

    private static final Log LOGGER = LogFactory.getLog(MedicationFieldValidator.class);

    public static void validateName(String name) {
        List<String> errors = new ArrayList<>();
        if (name == null) {
            errors.add("Medication is null");
            throw new IncorrectParameterException(UserDTO.class.getSimpleName(), errors);
        }
    }

    public static void validateInsertOrUpdate(MedicationDTO medicationDTO){

        List<String> errors = new ArrayList<>();

        if(medicationDTO == null) {
            errors.add("medicationDTO is null");
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(MedicationFieldValidator.class.getSimpleName(), errors);
        }
    }
}
