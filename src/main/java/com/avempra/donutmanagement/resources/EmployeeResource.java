/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avempra.donutmanagement.resources;

import com.avempra.donutmanagement.entity.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    @PersistenceContext(unitName = "com.avempra_DonutManagement_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    /**
     *
     * @return returns all available employees in the database
     */
    
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> findAllEmployees(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> empl=cq.from(Employee.class);
        cq.select(empl);
        TypedQuery<Employee> q = em.createQuery(cq);
        List<Employee> allEmployees = q.getResultList();
        
        return allEmployees;
        
    }
    
    @GET
    @Path("/{employeeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee findEmployee(@PathParam("employeeId")int Id){
        
        return em.find(Employee.class, Id);
        
    }

    /**
     *
     * @param employee object to be added to the database
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addEmployee(Employee employee){
        em.persist(employee);
        
    }

    
}
