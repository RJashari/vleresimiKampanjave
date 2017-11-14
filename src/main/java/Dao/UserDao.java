/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BL.Users;
import java.util.Set;

/**
 *
 * @author rinor.jashari
 */
public interface UserDao {
    
    void save(Users user);
    
    void removeUser(Users user);
    
    Set <Users> getAllUsers();
    
    Users findUserByUsername(String username);
    
    boolean comparePassword(String password, String confirmPassword);
    
    
    
}
