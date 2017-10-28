/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avempra.donutmanagement.entity;

import com.avempra.donutmanagement.embeddables.Address;
import com.avempra.donutmanagement.embeddables.Credential;
import com.avempra.donutmanagement.embeddables.PhoneNumber;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 *
 * @author shres
 */
@Entity
@Table(name = "EMPLOYEES")
@SecondaryTable(name = "CREDENTIALS",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "Employee_ID"))
@XmlRootElement
@NamedQueries({
    @NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e"),
    @NamedQuery(name="Employee.findById", query="SELECT e FROM Employee e WHERE e.id = :Id")
})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "JOB_TITLE")
    private String jobTitle;

    @Column(name = "HOURLY_PAY")
    private double hourlyPay;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Address> addresses = new HashSet<Address>();

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>();
    
    @Embedded 
    @AttributeOverrides({
        @AttributeOverride(name = "userName", column = @Column(table = "CREDENTIALS")),
        @AttributeOverride(name = "password", column = @Column(table = "CREDENTIALS"))
        
    })
    private Credential credentials;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }


    public Credential getCredentials() {
        return credentials;
    }

    public void setCredentials(Credential credentials) {
        this.credentials = credentials;
    }

}
