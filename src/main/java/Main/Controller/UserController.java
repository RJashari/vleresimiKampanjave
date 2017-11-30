/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Controller;

import Main.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.apache.log4j.Logger;
/**
 *
 * @author rinor.jashari
 */
public class UserController {
    @Autowired
    UsersService usersService;
    
    private final Logger LOGGER = Logger.getLogger(UserController.class);
    
    
      @GetMapping({"/users"})
        public String getUsers(Model model){
            LOGGER.info("Duke shfaqur faqen shfytezuesit.");
            
            return "users";
        }
}

