/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avempra.donutmanagement.entity;

import com.avempra.donutmanagement.embeddables.TransactionItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author shres
 */
@Entity
@Table(name="TRANSACTIONS")
@XmlRootElement
@NamedQuery(name="findAllTransactions",
           query="SELECT t FROM Transaction t"
        )
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="TRANSACTION_DATE")
    private Date dateOfTransaction;
    
    @Column(name="SUB_TOTAL")
    private double subTotal;
    
    @Column(name="TAX_RATE")
    private double taxRate;
    
    @Column(name="TOTAL")
    private double total; 
    
    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name="TRANSACTION_ITEMS", joinColumns = @JoinColumn(name="TRANSACTION_ID"))
    private List<TransactionItem> transactionItemList=new ArrayList<TransactionItem>();   
    
    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(Date dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<TransactionItem> getTransactionItemList() {
        return transactionItemList;
    }

    public void setTransactionItemList(List<TransactionItem> transactionItemList) {
        this.transactionItemList = transactionItemList;
    }

    

    
 
    
}
