/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avempra.donutmanagement.resources;

import com.avempra.donutmanagement.dao.IEmployeeDAO;
import com.avempra.donutmanagement.entity.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author shres
 */
@Path("/employees")
@Stateless
public class EmployeeResource {
    @Inject
    private IEmployeeDAO employeeDAO;
    
    
    
   /**
    * gets all employees and 
    * @return returns list of Employees
    * @throws Exception in case of any problems with fetching employee data
    */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> findAllEmployees() throws Exception{
       
        return employeeDAO.getAllEmployees();        
    }
    
    /**
     *
     * @param Id id of the employee that we are trying to access
     * @return returns all available employees in the database
     * @throws java.lang.Exception
     */
    
    @GET
    @Path("/{employeeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee findEmployee(@PathParam("employeeId")int Id) throws Exception{
        
        return employeeDAO.getEmployee(Id);
        
    }

    /**
     *
     * @param employee object to be added to the database
     * @throws java.lang.Exception
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addEmployee(Employee employee) throws Exception{
        employeeDAO.insertEmployee(employee);
        
    }

    
}
