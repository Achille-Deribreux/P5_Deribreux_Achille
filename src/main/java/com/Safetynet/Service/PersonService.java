package com.Safetynet.Service;

import com.Safetynet.Model.Person;
import com.Safetynet.Repository.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonDAO personDAO;

}
