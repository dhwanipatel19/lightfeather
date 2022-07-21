package io.lightfeather.managementstyle.persons;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class Person {
    @NotEmpty(message = "First name can not be empty") 
    private String firstName;
    
    @NotEmpty(message = "Last name can not be empty") 
    private String lastName;
   
    @NotEmpty(message = "Supervisor name can not be empty") 
    private String supervisor;
        
    @Email(message = "Invalid email address")
    private String email;
    
    private String phoneNumber;
}
