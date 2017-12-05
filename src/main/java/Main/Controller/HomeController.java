/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Controller;

import Main.BL.Klienti;
import Main.BL.Klienti_;
import Main.BL.Pytesori;
import Main.BL.Pytesori_;
import Main.BL.Users;
import Main.Dao.KampanjaException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import Main.Service.KlientiService;
import Main.Service.PytesoriService;
import Main.Service.UsersService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.validation.ConstraintViolationException;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.ServletWebRequest;

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
    
     SimpleDateFormat f = new SimpleDateFormat();
    private final Logger LOGGER = Logger.getLogger(HomeController.class);
    
    @GetMapping("/login")
	public String getLogin() {
            LOGGER.info("Duke shfaqur faqen e Login-it.");
            
            return "login";
	}
        
   @GetMapping({"/", "/home"})
    public String getHome(Model model) {
        LOGGER.info("Duke shfaqur faqen pytesori.");
        
    
        model.addAttribute("klienti", new Klienti());
     
        model.addAttribute("pytesori", new Pytesori());
       
        return "home";
    }
    
//   / @PostMapping("/home")
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String shtoPytesorin(@ModelAttribute Klienti klienti, Pytesori pytesori, @RequestParam String pytja3,@RequestParam String pytja4,@RequestParam String pytja5, Model model) throws KampanjaException
    {
        
        LOGGER.info("Duke ruajtur faqen pytesori." + pytesori.getPytja1TV());        
        Date dnow = new Date();
       
        
        pytesori.setData(dnow);
        pytesori.setPytja3(pytja3);
        pytesori.setPytja4(pytja4);
        pytesori.setPytja5(pytja5);

        LOGGER.info("getPytja3 : " + pytesori.getPytja3());
        LOGGER.info("getPytja4 : " + pytesori.getPytja4());
        LOGGER.info("getPytja5 : " + pytesori.getPytja5());
        
        LOGGER.info("Pytja1TV : " + pytesori.getPytja1TV());
        //Pytesori p=new Pytesori();
        //p.setPytja1TV(true);
        klientiService.create(klienti);
        
        pytesori.setKlientID(klientiService.findById(klienti.getNrPersonal()));
        pytesoriService.create(pytesori);
        
        
        
        //klienti.setPytesoriID(pytesoriService.findById(p.getPytesoriID()));
        //LOGGER.info(klienti.getPytesoriID());
//        /klientiService.create(klienti);
        //Pytesori p=new Pytesori();
        //pytesoriService.create(pytesori);
        return "redirect:/home";
    }
    
    @GetMapping({"/statistikat"})
        public String getStatistikat(Model model){
             LOGGER.info("Duke shfaqur faqen statistikat.");
            
            return "statistikat";
        }
}
