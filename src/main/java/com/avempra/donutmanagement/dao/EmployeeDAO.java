/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avempra.donutmanagement.dao;

import com.avempra.donutmanagement.entity.Employee;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author shres
 */
@RequestScoped
public class EmployeeDAO implements IEmployeeDAO {
    
    @PersistenceContext(unitName="com.avempra_DonutManagement_war_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    @Override
    public List<Employee> getAllEmployees() throws Exception {
        return em.createNamedQuery("Employee.findAll").getResultList();
    }

    @Override
    public Employee getEmployee(int employeeId) throws Exception {
        return em.find(Employee.class, employeeId);
    }

    @Override
    public void insertEmployee(Employee emp) throws Exception {
        em.persist(emp);
    }

    @Override
    public void updateEmployee(Employee emp) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEmployee(int employeeId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
