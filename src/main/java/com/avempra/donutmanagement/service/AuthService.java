/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avempra.donutmanagement.service;

import com.avempra.donutmanagement.dao.ICredentialDAO;
import com.avempra.donutmanagement.embeddables.Credential;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author shres
 */
@RequestScoped
public class AuthService implements Serializable, IAuthService {
    @Inject
    private ICredentialDAO credentialDAO;
    
    @Override
    public boolean authenticate(String username,String password){
        Credential cred=credentialDAO.getCredentials(username);
        boolean authenticated=true;
        
        if(username.equals(cred.getUserName()) && password.equals(cred.getPassword())){
           return authenticated; 
        }else{
            return !authenticated;
        }           
                   
    }
}
