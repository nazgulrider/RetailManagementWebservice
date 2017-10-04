/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avempra.donutmanagement.initialize;

import com.avempra.donutmanagement.embeddables.Address;
import com.avempra.donutmanagement.embeddables.Credential;
import com.avempra.donutmanagement.embeddables.PhoneNumber;
import com.avempra.donutmanagement.entity.Employee;
import com.avempra.donutmanagement.resources.EmployeeResource;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author shres
 */
@Singleton
@Startup
public class DataInitialization {
    
    @EJB
    private EmployeeResource er;

    // Adds initial data to the database to work with
    @PostConstruct
    public void insertPersonnel(){
        
        Credential user=new Credential();
        user.setUserName("harold101");
        user.setPassword("kumar");
        PhoneNumber number=new PhoneNumber();
        number.setPhoneNumber("9199892233");
        Address address =new Address();
        address.setStreetAddress("550 Clifton Rd");
        address.setCity("Fortworth");
        address.setState("TX");
        address.setZipcode(87654);
        
        
        Employee em=new Employee();
        em.setFirstName("Harry");
        em.setLastName("Potter");
        em.setCredentials(user);
        em.getAddresses().add(address);
        em.getPhoneNumbers().add(number);
        
        Employee em1=new Employee();
        em1.setFirstName("Ronald");
        em1.setLastName("Weasley");
        em1.setCredentials(user);
        em1.getAddresses().add(address);
        em1.getPhoneNumbers().add(number);
        
        
        er.addEmployee(em);
        er.addEmployee(em1);
    }
}
