package io.health.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.health.config.StatusCodeConfig;
import io.health.exceptions.AadharInvalidException;
import io.health.exceptions.GeneralException;

@Component
public class Utility {
	
@Autowired(required = true)
private StatusCodeConfig config;

	
	public  void isValidAadharValidation(String str) throws AadharInvalidException, GeneralException {
        // Regex to check valid Aadhaar number.
        String regex
            = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
 
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
 
        // If the string is empty
        // return false
        if (str == null) {
            throw new GeneralException(config.genericExcpection, "aadhar number can not be null");
        }
 
        // Pattern class contains matcher() method
        // to find matching between given string
        // and regular expression.
        Matcher m = p.matcher(str);

        // Return if the string
        // matched the ReGex
         if(m.matches()) {
         return; 
         }
        
        throw new AadharInvalidException(config.invalidAadhar,"invalid aadhar number");

    }


}
