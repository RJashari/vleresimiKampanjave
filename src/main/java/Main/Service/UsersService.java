/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Service;

import Main.BL.Users;
import Main.Dao.KampanjaException;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author rinor.jashari
 */
public interface UsersService extends UserDetailsService{
    
    void create(Users users) throws KampanjaException;
    void edit (Users users) throws KampanjaException;
    void remove(Users users) throws KampanjaException;
    List<Users> findAll();
    Users findById(long id);
}
