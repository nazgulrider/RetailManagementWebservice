/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avempra.donutmanagement.dao;

import com.avempra.donutmanagement.entity.Employee;
import java.util.List;

/**
 *accesses the database and fetches all the employee objects with different requirements
 * @author Prashanta Shrestha
 */
public interface IEmployeeDAO {
    /**
     * 
     * @return returns all the employee objects in the database
     * @throws Exception for error reporting if there is any problem fetching data
     */
    public List<Employee> getAllEmployees() throws Exception;
    /**
     * 
     * @param employeeId id of the employee that is being fetched
     * @return returns the employee that matches the id provided
     * @throws Exception throws exception if there is any problem fetching the data from the database
     */
    public Employee getEmployee(int employeeId) throws Exception;
    /**
     * 
     * @param emp the employee that needs to be persisted
     * @throws Exception 
     */
    public void insertEmployee(Employee emp) throws Exception;
    /**
     * 
     * @param emp
     * @throws Exception 
     */
    public void updateEmployee(Employee emp) throws Exception;
    /**
     * 
     * @param employeeId
     * @throws Exception 
     */
    public void deleteEmployee(int employeeId) throws Exception;     
}
