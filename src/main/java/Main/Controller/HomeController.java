/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import Main.Service.KlientiService;
import Main.Service.PytesoriService;
import Main.Service.UsersService;
import org.springframework.ui.Model;

/**
 *
 * @author rinor.jashari
 */
@Controller
public class HomeController {
    
    @Autowired
    KlientiService klientiService;
    @Autowired
    PytesoriService pytesoriService;
    @Autowired 
    UsersService usersService;
    
    private final Logger LOGGER = Logger.getLogger(HomeController.class);
    
    @GetMapping("/login")
	public String getLogin() {
		
		return "login";
	}
        
    @GetMapping({"/", "/home"})
	public String getHome(Model model) {
		
		
		return "index";
	}
    
}
