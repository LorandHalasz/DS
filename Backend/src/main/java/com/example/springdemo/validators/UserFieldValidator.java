package com.example.springdemo.validators;

import com.example.springdemo.dto.UserDTO;
import com.example.springdemo.dto.UserViewDTO;
import com.example.springdemo.entities.Patient;
import com.example.springdemo.errorhandler.IncorrectParameterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class UserFieldValidator {

    private static final Log LOGGER = LogFactory.getLog(UserFieldValidator.class);
    private static final EmailFieldValidator EMAIL_VALIDATOR = new EmailFieldValidator() ;

    public static void validateUsername(String username) {
        List<String> errors = new ArrayList<>();
        if (username == null) {
            errors.add("Username is null");
            throw new IncorrectParameterException(UserDTO.class.getSimpleName(), errors);
        }
    }

    public static void validateInsertOrUpdate(UserDTO userDTO) {

        List<String> errors = new ArrayList<>();
        if (userDTO == null) {
            errors.add("userDTO is null");
            throw new IncorrectParameterException(UserDTO.class.getSimpleName(), errors);
        }

        if (userDTO.getEmail() == null || !EMAIL_VALIDATOR.validate(userDTO.getEmail())) {
            errors.add("User email has invalid format");
        }

        if (!errors.isEmpty()) {
            LOGGER.error(errors);
            throw new IncorrectParameterException(UserFieldValidator.class.getSimpleName(), errors);
        }
    }

    public static void validateDelete(String username) {

        List<String> errors = new ArrayList<>();

        if (username.isEmpty()) {
            errors.add("Username field is empty");
            throw new IncorrectParameterException(UserFieldValidator.class.getSimpleName(), errors);
        }
    }
}
