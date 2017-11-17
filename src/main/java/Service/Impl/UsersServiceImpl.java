/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Impl;

import BL.Users;
import BL.Users;
import Dao.KampanjaException;
import Dao.UsersInterface;
import Service.UsersService;
import Service.UsersService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

   @Autowired
    UsersInterface usersDao;

    @Override
    public void create(Users users) {
         try {
            usersDao.create(users);
        } catch (KampanjaException ex) {
            Logger.getLogger(UsersServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void edit(Users users) {
        try {
            usersDao.edit(users);
        } catch (KampanjaException ex) {
            Logger.getLogger(UsersServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remove(Users users) {
        try {
            usersDao.remove(users);
        } catch (KampanjaException ex) {
            Logger.getLogger(UsersServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Users> findAll() {
      return usersDao.findAll();
    }

    @Override
    public Users findById(long id)  {
        return usersDao.findById(id);
    }
    
}
