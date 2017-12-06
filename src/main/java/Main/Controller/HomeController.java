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
        
        LOGGER.info("Duke ruajtur faqen pytesori.");        
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
            int pytja1Tv = pytesoriService.countPytja1TV();
            int pytja1Radio = pytesoriService.countPytja1Radio();
            System.out.println("pytja1Tv : "+pytja1Tv);
            System.out.println("pytja1Radio : "+pytja1Radio);
            int pytja1RrjeteSociale = pytesoriService.countPytja1RrjeteSociale();
            int pytja1Billboards = pytesoriService.countPytja1Billboards();
            int pytja1Gazete = pytesoriService.countPytja1Gazete();
            int pytja1Portale = pytesoriService.countPytja1Portale();
            int pytja1Referuar = pytesoriService.countPytja1Referuar();
            int pytja1PromovimetDirekte = pytesoriService.countPytja1PromovimetDirekte();
            int pytja1SMS = pytesoriService.countPytja1SMS();
            
            int totalPytja1 = pytja1Tv+pytja1Radio+pytja1RrjeteSociale+pytja1Billboards
                    +pytja1Gazete+pytja1Portale+pytja1Referuar+pytja1PromovimetDirekte+pytja1SMS;
            
            System.out.println("TOTALI Pytja1 = "+totalPytja1);
            
            int pytja2Tv = pytesoriService.countPytja2TV();
            int pytja2Radio = pytesoriService.countPytja2Radio();
            int pytja2RrjeteSociale = pytesoriService.countPytja2RrjeteSociale();
            int pytja2Billboards = pytesoriService.countPytja2Billboards();
            int pytja2Gazete = pytesoriService.countPytja2Gazete();
            int pytja2Portale = pytesoriService.countPytja2Portale();
            int pytja2Referuar = pytesoriService.countPytja2Referuar();
            int pytja2PromovimetDirekte = pytesoriService.countPytja2PromovimetDirekte();
            int pytja2SMS = pytesoriService.countPytja2SMS();
            
            int totalPytja2 = pytja2Tv+pytja2Radio+pytja2RrjeteSociale+pytja2Billboards
                    +pytja2Gazete+pytja2Portale+pytja2Referuar+pytja2PromovimetDirekte+pytja2SMS;
           
            System.out.println("TOTALI Pytja2 = "+totalPytja2);
            
            int pytja3Po = pytesoriService.countPytja3Po();
            int pytja3Jo = pytesoriService.countPytja3Jo();
            
            int totalPytja3 = pytja3Jo+pytja3Po;
            
             System.out.println("TOTALI Pytja3 = "+totalPytja3);
            
            int pytja4Neutral = pytesoriService.countPytja4Neutral();
            int pytja4Pozitiv = pytesoriService.countPytja4Pozitiv();
            int pytja4Negativ = pytesoriService.countPytja4Negativ();
            
            int totalPytja4 = pytja4Neutral+pytja4Pozitiv+pytja4Negativ;
            System.out.println("TOTALI Pytja4 = "+totalPytja4);
            
            int pytja5Po = pytesoriService.countPytja5Po();
            int pytja5Jo = pytesoriService.countPytja5Jo();
            
            int totalPytja5 = pytja5Jo+pytja5Po;
            System.out.println("Pytja5Po = "+pytja5Po);
            System.out.println("Pytja5Jo = "+pytja5Jo);
            System.out.println("TOTALI Pytja5 = "+totalPytja5);
            System.out.println("Perqindja Pytja5Po = "+ (float)((pytja5Po/totalPytja5)*100)+"%");
            System.out.println("Perqindja Pytja5Jo = "+(float)(pytja5Jo/totalPytja5*100)+"%");
             
            model.addAttribute("pytja1Tv", pytja1Tv/totalPytja1*100);//perqindja e checkbox-it TV ne total te pytjes 1
            model.addAttribute("pytja1Radio", pytja1Radio/totalPytja1*100);
            model.addAttribute("pytja1RrjeteSociale", pytja1RrjeteSociale/totalPytja1*100);
            model.addAttribute("pytja1Billboards", pytja1Billboards/totalPytja1*100);
            model.addAttribute("pytja1Gazete", pytja1Gazete/totalPytja1*100);
            model.addAttribute("pytja1Portale", pytja1Portale/totalPytja1*100);
            model.addAttribute("pytja1Referuar", pytja1Referuar/totalPytja1*100);
            model.addAttribute("pytja1PromovimetDirekte", pytja1PromovimetDirekte/totalPytja1*100);
            model.addAttribute("pytja1SMS", pytja1SMS/totalPytja1*100);
            model.addAttribute("pytja2Tv", pytja2Tv/totalPytja2*100);
            model.addAttribute("pytja2Radio", pytja2Radio/totalPytja2*100);
            model.addAttribute("pytja2RrjeteSociale", pytja2RrjeteSociale/totalPytja2*100);
            model.addAttribute("pytja2Billboards", pytja2Billboards/totalPytja2*100);
            model.addAttribute("pytja2Gazete", pytja2Gazete/totalPytja2*100);
            model.addAttribute("pytja2Portale", pytja2Portale/totalPytja2*100);
            model.addAttribute("pytja2Referuar", pytja2Referuar/totalPytja2*100);
            model.addAttribute("pytja2PromovimetDirekte", pytja2PromovimetDirekte/totalPytja2*100);
            model.addAttribute("pytja2SMS", pytja2SMS/totalPytja2*100);
            model.addAttribute("pytja3Po", pytja3Po/totalPytja3*100);
            model.addAttribute("pytja3Jo", pytja3Jo/totalPytja3*100);
            model.addAttribute("pytja4Neutral", pytja4Neutral/totalPytja4*100);
            model.addAttribute("pytja4Pozitiv", pytja4Pozitiv/totalPytja4*100);
            model.addAttribute("pytja4Negativ", pytja4Negativ/totalPytja4*100);
            model.addAttribute("pytja5Po", pytja5Po/totalPytja5*100);
            model.addAttribute("pytja5Jo", pytja5Jo/totalPytja5*100);
            

            return "statistikat";
        }
}
