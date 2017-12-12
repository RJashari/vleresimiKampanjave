/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Dao;

import Main.BL.Users;
import java.util.List;

/**
 *
 * @author Rinor Jashari
 */
public interface UsersInterface {
    void create(Users users) throws KampanjaException;
    void edit (Users users) throws KampanjaException;
    void remove(Users users) throws KampanjaException;
    void removeByUsername(String username) throws KampanjaException;
    List<Users> findAll();
    Users findById(int id);
    Users findUsersByUsername(String username);
    void resetUserPassword(int id) throws KampanjaException;
}
