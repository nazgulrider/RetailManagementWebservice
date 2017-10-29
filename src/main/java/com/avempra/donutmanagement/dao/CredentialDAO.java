/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avempra.donutmanagement.dao;

import com.avempra.donutmanagement.embeddables.Credential;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author shres
 */
@RequestScoped
public class CredentialDAO implements ICredentialDAO {
    @PersistenceContext(unitName="com.avempra_DonutManagement_war_1.0-SNAPSHOTPU")
    EntityManager em;
    


    @Override
    public Credential getCredentials(String username) {
        return em.createNamedQuery("SELECT userName, password FROM credentials WHERE userName=username", 
                Credential.class).getSingleResult();
    }
    
}
