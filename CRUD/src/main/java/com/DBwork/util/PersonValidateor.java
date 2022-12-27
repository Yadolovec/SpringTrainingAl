package com.DBwork.util;

import com.DBwork.dao.PersonDAO;
import com.DBwork.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidateor implements Validator {
    private final PersonDAO personDAO;

    @Autowired
    public PersonValidateor(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person) o;

        if (personDAO.show(person.getEmail()).isPresent()){
            errors.rejectValue("email","","This email is already taken");
        }
    }
}
