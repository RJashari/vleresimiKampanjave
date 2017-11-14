/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import BL.Users;
import Dao.BaseDao;
import Dao.UserDao;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rinor.jashari
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {
 private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    @Override
	public Users findUserByUsername(String username) {
		List<Users> users = this.session
				.createQuery("from " + Users.class.getName() + " WHERE username=?")
				.setParameter(0, username).list();
		if (users.size() == 1) {
			return users.get(0);
		}
		return null;
	}
   
    @Override
    public void save(Users user) {
        
        Transaction tx = session.beginTransaction();
        try{
                LOGGER.info("Saving user: " + user.getUsername());
		session.save(user);
		tx.commit();
        }
        catch(Exception e){
            LOGGER.error("Some error occured: " + e);
            tx.rollback();
        }
       
    }

    @Override
    public Set<Users> getAllUsers() {
       StringBuilder sb = new StringBuilder("from users");
		Query query = session.createQuery(sb.toString());
		return new HashSet<Users>(query.list());


    }



   @Override
	public boolean comparePassword(String password, String confirmPassword) {
            LOGGER.info("Changing users password");
 
		if(password.equals(confirmPassword)) {
			return true;
		}
		return false;
            }
           
   

    @Override
    public void removeUser(Users user) {
        LOGGER.info("Removing user: " + user.getUsername());
		Transaction transaction = session.beginTransaction();
		try {
			user = this.findUserByUsername(user.getUsername());
			session.remove(user);
			transaction.commit();
		} catch (Exception e) {
			LOGGER.error("Some error occured: " + e);
			transaction.rollback();
    }
}
}