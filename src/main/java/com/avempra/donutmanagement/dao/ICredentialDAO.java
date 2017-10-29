/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avempra.donutmanagement.dao;

import com.avempra.donutmanagement.embeddables.Credential;

/**
 *
 * @author shres
 */
public interface ICredentialDAO {
    public Credential getCredentials(String username);
}
