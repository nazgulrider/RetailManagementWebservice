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
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shres
 */
@Entity
@XmlRootElement
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name="FIRST_NAME")
    private String firstName;
    
    @Column(name="LAST_NAME")
    private String lastName;
    
    @ElementCollection (fetch = FetchType.EAGER)
    private Set<Address> addresses=new HashSet<Address>();
    
    @ElementCollection (fetch = FetchType.EAGER)
    private Set<PhoneNumber> phoneNumbers=new HashSet<PhoneNumber>();
    
    @Embedded
    @Transient
    Credential credentials;

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

    public Credential getCredentials() {
        return credentials;
    }

    public void setCredentials(Credential credentials) {
        this.credentials = credentials;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.addresses, other.addresses)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumbers, other.phoneNumbers)) {
            return false;
        }
        if (!Objects.equals(this.credentials, other.credentials)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", addresses=" + addresses + ", phoneNumbers=" + phoneNumbers + ", credentials=" + credentials + '}';
    }

    
    
   
    
}
