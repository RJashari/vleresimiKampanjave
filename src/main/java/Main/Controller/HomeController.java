/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Controller;

import Main.BL.Klienti;
import Main.BL.Klienti_;
import Main.BL.Pytesori;
import Main.BL.Users;
import Main.Dao.KampanjaException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import Main.Service.KlientiService;
import Main.Service.PytesoriService;
import Main.Service.UsersService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.validation.ConstraintViolationException;
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
    UsersService usersService;
    @Autowired
    PytesoriService pytesoriService;
    
    private final Logger LOGGER = Logger.getLogger(HomeController.class);
    
    @GetMapping("/login")
	public String getLogin() {
            LOGGER.info("Duke shfaqur faqen e Login-it.");
            
            return "login";
	}
        
   @GetMapping({"/", "/home"})
    public String getHome(Model model) {
        LOGGER.info("Duke shfaqur faqen pytesori.");
        
       
        Klienti k = new Klienti();   
        Pytesori p = new Pytesori();
        model.addAttribute("klienti", k);
       
        model.addAttribute("pytesori", p);
       
        return "home";
    }
        
    @PostMapping("/home")
    public String shtoPytesorin(@ModelAttribute Klienti klienti,@ModelAttribute Pytesori pytesori,Model model) throws KampanjaException
    {
        LOGGER.info("Duke ruajtur faqen pytesori.");        
       klientiService.create(klienti);
        //Pytesori p=new Pytesori();
        pytesori.setPytesoriID(128484);
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
