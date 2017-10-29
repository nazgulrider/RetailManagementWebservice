/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avempra.donutmanagement.service;

/**
 *
 * @author shres
 */
public interface IAuthService {

    boolean authenticate(String username, String password);
    
}
