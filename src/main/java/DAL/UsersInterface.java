/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.Users;
import java.util.List;

/**
 *
 * @author Rinor Jashari
 */
interface UsersInterface {
    void create(Users users) throws KampanjaException;
    void edit (Users users) throws KampanjaException;
    void remove(Users users) throws KampanjaException;
    List<Users> findAll();
    Users findById(long id) throws KampanjaException;
}
