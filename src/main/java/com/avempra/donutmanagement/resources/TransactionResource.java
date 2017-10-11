/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avempra.donutmanagement.resources;

import com.avempra.donutmanagement.entity.Transaction;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author shres
 */
@Path("/transactions")
@Stateless
public class TransactionResource {

    @PersistenceContext(unitName = "com.avempra_DonutManagement_war_1.0-SNAPSHOTPU")
    private EntityManager em;
   

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transaction> getTransactions(){
       
       return em.createNamedQuery("findAllTransactions").getResultList();
    }
    
    @GET
    @Path("/{transactionID}")    
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction getTransaction(@PathParam("tansactionID")long id){
        return em.find(Transaction.class, id);
    }

   
}
