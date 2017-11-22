/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Controller;

import Main.BL.Pytesori;
import Main.Dao.KampanjaException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import Main.Service.KlientiService;
import Main.Service.PytesoriService;
import Main.Service.UsersService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
            LOGGER.info("Duke shfaqur faqen e Login-it.");
            
            return "login";
	}
        
    @GetMapping({"/", "/home"})
	public String getHome(Model model) {
            LOGGER.info("Duke shfaqur faqen pytesori.");
            model.addAttribute("pytesori",new Pytesori());
            
		
            return "home";
	}
        
    @PostMapping({"/home"})
    public String shtoPytesorin(@ModelAttribute Pytesori pytesori, Model model) throws KampanjaException
    {
        pytesoriService.create(pytesori);
        return "redirect:/home";
    }
    
    @GetMapping({"/users"})
        public String getUsers(Model model){
            LOGGER.info("Duke shfaqur faqen shfytezuesit.");
            
            return "users";
        }
    @GetMapping({"/statistikat"})
        public String getStatistikat(Model model){
             LOGGER.info("Duke shfaqur faqen statistikat.");
            
            return "statistikat";
        }
}
