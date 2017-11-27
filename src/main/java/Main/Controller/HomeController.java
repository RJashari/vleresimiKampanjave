/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Controller;

import Main.BL.Klienti;

import Main.BL.Users;
import Main.Dao.KampanjaException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import Main.Service.KlientiService;
import Main.Service.UsersService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
    
    private final Logger LOGGER = Logger.getLogger(HomeController.class);
    
    @GetMapping("/login")
	public String getLogin() {
            LOGGER.info("Duke shfaqur faqen e Login-it.");
            
            return "login";
	}
        
    @GetMapping({"/", "/home"})
    public String getHome(@ModelAttribute Klienti klienti, Model model) {
        LOGGER.info("Duke shfaqur pyetesorin.");
        klienti = new Klienti();
        model.addAttribute("klienti", klienti);


        return "home";
    }
        
    @PostMapping("/home")
    public String shtoPytesorin(@ModelAttribute Klienti klienti, Model model) throws KampanjaException
    {
        LOGGER.info("Është ruajtur pytësori.");
//        Date dateNow = new Date();
//        klienti.setData(dateNow);
//        klienti.setEmri("Rinor");
//        klienti.setMbiemri("Jashari");
//        klienti.setNrPersonal(100112);
//        klienti.setNrTelefonit("044979761");
//        
//        klienti.setPytja1TV("1");
//        klienti.setPytja1Radio("1");
//        klienti.setPytja1RrjetetSociale("1");
//        klienti.setPytja1Billboards("1");
//        klienti.setPytja1Gazete("1");
//        klienti.setPytja1Portale("1");
//        klienti.setPytja1Referuar("1");
//        klienti.setPytja1PromovimetDirekte("0");
//        klienti.setPytja1Sms("0");
//        klienti.setPytja1Tjeter("tjeter");
//        
//        klienti.setPytja2TV("1");
//        klienti.setPytja2Radio("0");
//        klienti.setPytja2RrjeteSociale("0");
//        klienti.setPytja2Billboards("1");
//        klienti.setPytja2Gazete("0");
//        klienti.setPytja2Portale("1");
//        klienti.setPytja2Referuar("0");
//        klienti.setPytja2PromovimetDirekte("1");
//        klienti.setPytja2Sms("0");
//        klienti.setPytja2Tjeter("ETJ");
//        
//        klienti.setPytja3("p");
//        klienti.setPytja4("neutral");
//        klienti.setPytja5("p");
//        
//        klienti.setKomenti("komenti1");
        
        
        klientiService.create(klienti);
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
