/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Controller;



import Main.BL.Klienti;
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
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.validation.ConstraintViolationException;
import org.springframework.security.core.userdetails.UserDetails;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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
 * mvn install:install-file -Dfile=sqljdbc4.jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4 -Dversion=4.0 -Dpackaging=jar

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
    public String getHome(Model model, Principal principal) {
        LOGGER.info("Duke shfaqur faqen pytesori.");
        UserDetails userDetails = usersService.loadUserByUsername(principal.getName());
        LOGGER.info(userDetails.getUsername());
    
        model.addAttribute("klienti", new Klienti());
     
        model.addAttribute("pytesori", new Pytesori());
       
        return "home";
    }
    
//   / @PostMapping("/home")
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String shtoPytesorin(@ModelAttribute Klienti klienti, Pytesori pytesori, @RequestParam String pytja3,@RequestParam String pytja4,@RequestParam String pytja5, Model model, Users user, Principal principal) throws KampanjaException
    {
        
        LOGGER.info("Duke ruajtur faqen pytesori.");        
        Date dnow = new Date();
       user = usersService.findUserByUsername(principal.getName());
        
        
        
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
        System.out.println("---------"+klienti.getKlientInfo());
        klienti.setUserId(user);
        System.out.println("user-------"+user);
        klientiService.create(klienti);
         System.out.println("KLIENTI ESHTE INSERTUAR");
        pytesori.setKlientID(klientiService.findById(klienti.getNrPersonal()));
        System.out.println("testtestteste--------------");
        pytesoriService.create(pytesori);
        
        
        
        //klienti.setPytesoriID(pytesoriService.findById(p.getPytesoriID()));
        //LOGGER.info(klienti.getPytesoriID());
//        /klientiService.create(klienti);
        //Pytesori p=new Pytesori();
        //pytesoriService.create(pytesori);        
        return "redirect:/home";
    }
    
    @GetMapping({"/statistikat"})
        public String getStatistikat(Model model, Users user, Principal principal){
            user = usersService.findUserByUsername(principal.getName());
            
            if(user.getRole().equals("admin")){
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
            String totalPytja1Perqindja = totalPytja1+"";
            
            String pytja1TvPerqindje = ((float)pytja1Tv/totalPytja1*100+"%");
            String pytja1RadioPerqindje = ((float)pytja1Radio/totalPytja1*100+"%");
            String pytja1RrjeteSocialePerqindje = ((float)pytja1RrjeteSociale/totalPytja1*100+"%");
            String pytja1BillboardsPerqindje = ((float)pytja1Billboards/totalPytja1*100+"%");
            String pytja1GazetePerqindje = ((float)pytja1Gazete/totalPytja1*100+"%");
            String pytja1PortalePerqindje = ((float)pytja1Portale/totalPytja1*100+"%");
            String pytja1ReferuarPerqindje = ((float)pytja1Referuar/totalPytja1*100+"%");
            String pytja1PromovimetDirektePerqindje = ((float)pytja1PromovimetDirekte/totalPytja1*100+"%");
            String pytja1SMSPerqindje = ((float)pytja1SMS/totalPytja1*100+"%");
           
            System.out.println("tv1%:   "+pytja1TvPerqindje);
            System.out.println("radio1%:   "+pytja1RadioPerqindje);
            System.out.println("rrjeta1:   "+pytja1RrjeteSocialePerqindje);
            System.out.println("billboards1:   "+pytja1BillboardsPerqindje);
            System.out.println("Gazet1:   "+pytja1GazetePerqindje);
            System.out.println("Portale1:   "+pytja1PortalePerqindje);
            System.out.println("Referuar1:   "+pytja1ReferuarPerqindje);
            System.out.println("Promovime1:   "+pytja1PromovimetDirektePerqindje);
            System.out.println("sms1:   "+pytja1SMSPerqindje);
            

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
            
            String totalPytja2Perqindja = totalPytja2+"";
            
            String pytja2TvPerqindje = ((float)pytja2Tv/totalPytja2*100+"%");
            String pytja2RadioPerqindje = ((float)pytja2Radio/totalPytja2*100)+"%";
            String pytja2RrjeteSocialePerqindje = ((float)pytja2RrjeteSociale/totalPytja2*100)+"%";
            String pytja2BillboardsPerqindje =((float)pytja2Billboards/totalPytja2*100)+"%";
            String pytja2GazetePerqindje = ((float)pytja2Gazete/totalPytja2*100)+"%";
            String pytja2PortalePerqindje = ((float)pytja2Portale/totalPytja2*100)+"%";
            String pytja2ReferuarPerqindje = ((float)pytja2Referuar/totalPytja2*100)+"%";
            String pytja2PromovimetDirektePerqindje = ((float)pytja2PromovimetDirekte/totalPytja2*100)+"%";
            String pytja2SMSPerqindje = ((float)pytja2SMS/totalPytja2*100)+"%";
            
            System.out.println("tv2%:   "+pytja2TvPerqindje);
            System.out.println("radio2%:   "+pytja2RadioPerqindje);
            System.out.println("rrjeta2:   "+pytja2RrjeteSocialePerqindje);
            System.out.println("billboards2:   "+pytja2BillboardsPerqindje);
            System.out.println("Gazet2:   "+pytja2GazetePerqindje);
            System.out.println("Portale2:   "+pytja2PortalePerqindje);
            System.out.println("Referuar2:   "+pytja2ReferuarPerqindje);
            System.out.println("Promovime2:   "+pytja2PromovimetDirektePerqindje);
            System.out.println("sms2:   "+pytja2SMSPerqindje);
            
            int pytja3Po = pytesoriService.countPytja3Po();
            int pytja3Jo = pytesoriService.countPytja3Jo();
            
            int totalPytja3 = pytja3Jo+pytja3Po;
            
            String pytja3PoPerqindje = ((float)pytja3Po/totalPytja3*100)+"%";
            String pytja3JoPerqindje = ((float)pytja3Jo/totalPytja3*100)+"%";
            System.out.println("p3p%:   "+pytja3PoPerqindje);
            System.out.println("p3j%:   "+pytja3JoPerqindje);
            
             System.out.println("TOTALI Pytja3 = "+totalPytja3);
             
            
            int pytja4Neutral = pytesoriService.countPytja4Neutral();
            int pytja4Pozitiv = pytesoriService.countPytja4Pozitiv();
            int pytja4Negativ = pytesoriService.countPytja4Negativ();
            
            int totalPytja4 = pytja4Neutral+pytja4Pozitiv+pytja4Negativ;
            System.out.println("TOTALI Pytja4 = "+totalPytja4);
            String pytja4NeutralPerqindje = ((float)pytja4Neutral/totalPytja4*100+"%");
            String pytja4NegativPerqindje = ((float)pytja4Negativ/totalPytja4*100+"%");
            String pytja4PozitivPerqindje = ((float)pytja4Pozitiv/totalPytja4*100+"%");
            System.out.println("p4n%:   "+pytja4NeutralPerqindje);
            System.out.println("p4ng%:   "+pytja4NegativPerqindje);
            System.out.println("p4p:   "+pytja4PozitivPerqindje);
          
            
            
            
            
            int pytja5Po = pytesoriService.countPytja5Po();
            int pytja5Jo = pytesoriService.countPytja5Jo();
            
            int totalPytja5 = pytja5Jo+pytja5Po;
            String pytja5PoPerqindje = ((float)pytja5Po/totalPytja5*100+"%");
            String pytja5JoPerqindje = ((float)pytja5Jo/totalPytja5*100+"%");
            System.out.println("p5p%:   "+pytja5PoPerqindje);
            System.out.println("p5j%:   "+pytja5JoPerqindje);
            
            System.out.println();
            
        
             
            model.addAttribute("pytja1Tv",pytja1TvPerqindje);//perqindja e checkbox-it TV ne total te pytjes 1
            model.addAttribute("pytja1Radio", pytja1RadioPerqindje);
            model.addAttribute("pytja1RrjeteSociale", pytja1RrjeteSocialePerqindje);
            model.addAttribute("pytja1Billboards", pytja1BillboardsPerqindje);
            model.addAttribute("pytja1Gazete", pytja1GazetePerqindje);
            model.addAttribute("pytja1Portale", pytja1PortalePerqindje);
            model.addAttribute("pytja1Referuar", pytja1ReferuarPerqindje);
            model.addAttribute("pytja1PromovimetDirekte", pytja1PromovimetDirektePerqindje);
            model.addAttribute("pytja1SMS", pytja1SMSPerqindje);
            model.addAttribute("totalPytja1", totalPytja1);
            model.addAttribute("pytja2Tv",pytja2TvPerqindje);//perqindja e checkbox-it TV ne total te pytjes 2
            model.addAttribute("pytja2Radio", pytja2RadioPerqindje);
            model.addAttribute("pytja2RrjeteSociale", pytja2RrjeteSocialePerqindje);
            model.addAttribute("pytja2Billboards", pytja2BillboardsPerqindje);
            model.addAttribute("pytja2Gazete", pytja2GazetePerqindje);
            model.addAttribute("pytja2Portale", pytja2PortalePerqindje);
            model.addAttribute("pytja2Referuar", pytja2ReferuarPerqindje);
            model.addAttribute("pytja2PromovimetDirekte", pytja2PromovimetDirektePerqindje);
            model.addAttribute("pytja2SMS", pytja2SMSPerqindje);
            model.addAttribute("totalPytja2", totalPytja2);
            model.addAttribute("pytja3Po", pytja3PoPerqindje);
            model.addAttribute("pytja3Jo", pytja3JoPerqindje);
            model.addAttribute("totalPytja3", totalPytja3);
            model.addAttribute("pytja4Neutral", pytja4NeutralPerqindje);
            model.addAttribute("pytja4Pozitiv", pytja4PozitivPerqindje);
            model.addAttribute("pytja4Negativ", pytja4NegativPerqindje);
             model.addAttribute("totalPytja4", totalPytja4);
            model.addAttribute("pytja5Po", pytja5PoPerqindje);
            model.addAttribute("pytja5Jo", pytja5JoPerqindje);
             model.addAttribute("totalPytja5", totalPytja5);
            

            return "statistikat";
        }else{
                LOGGER.info("Duke shfaqur formen nuk keni qasje (statistika)");
                return "403";
            }
        }
//        @GetMapping({"/statistikat/data"})
//        public String getStatistikatByData(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate,Model model, Users user, Principal principal){
//            user = usersService.findUserByUsername(principal.getName());
//            
//            if(user.getRole().equals("admin")){
//                
//            }else{
//                
//            }
//            return null;
//    }
}
