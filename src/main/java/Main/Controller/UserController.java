/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Controller;

import Main.BL.Dega;
import Main.BL.Users;
import Main.Dao.KampanjaException;
import Main.Service.DegaService;
import Main.Service.UsersService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author rinor.jashari
 */
@Controller
public class UserController {
    @Autowired
    UsersService usersService;
    @Autowired
    DegaService degaService;
    
    private final Logger LOGGER = Logger.getLogger(UserController.class);
    private String DEFAULT_PASSWORD ="$2a$10$5kCKO/IAcqcrAy0IzrHFK.kEVBeBKVn8j/m4xcN7TTBhb1RJ3GJ7S";//password00;
    private String DISABLE_PASSWORD= "$2a$10$zSsGzxXbMPJPioS.rnlI1.1paqiIHqzwhY852avMghuWK4CnBHKXm";//DisPass123!
    private BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
    
      @GetMapping({"/users"})
        public String getUsers(Users user, Model model, Principal principal){
            user = usersService.findUserByUsername(principal.getName());
            
            if(user.getRole().equals("admin")){
            
            LOGGER.info("Duke shfaqur faqen shfytezuesit.");
            model.addAttribute("user", new Users());
            model.addAttribute("allUsers", usersService.findAll());
           

            return "users";
        }else{
                LOGGER.info("Duke shfaqur formen nuk keni qasje.");
                return "403";
            }
        }
        @GetMapping("/users/remove/{id}")
	public String removeUser(@PathVariable int id, Model model) throws KampanjaException {
		LOGGER.info("Duke fshire userin me id: " + id);
//              
                Users user = usersService.findById(id);
                user.setStatus(false);
                user.setPassword(DISABLE_PASSWORD);
                usersService.edit(user);
                LOGGER.info("Eshte fshire user-i : " + user.getUsername());
		return "redirect:/users";
	}
        @GetMapping("/users/resetPassword/{id}")
	public String resetUserPassword(@PathVariable int id, Model model) throws KampanjaException {
                Users user = usersService.findById(id);
		LOGGER.info("Duke resetuar passwordin per userin me username: " + user.getUsername());
		usersService.resetUserPassword(id);

		return "redirect:/users";
	}
        @GetMapping("/users/add")
        public String addUser(Model model, Dega dega, Users user, Principal principal) throws KampanjaException{
            LOGGER.info("Duke shfaqur formen Shto Shfrytezuesin");
            user = usersService.findUserByUsername(principal.getName());
            if(user.getRole().equals("admin")){
            model.addAttribute("user", new Users());
            model.addAttribute("deget", degaService.findAll());
            
//            
//            user.setRole(roli);
//            System.out.println("Roli i Userit: "+roli);
//            usersService.create(user);
//            
            return "addUser";
            }else{
                LOGGER.info("Duke shfaqur formen nuk keni qasje.");
                return "403";
            }
        }
       @RequestMapping(value = "/users/add", method = RequestMethod.POST)
        public String addUserPost(@ModelAttribute Users user, @RequestParam String roli,@RequestParam String degaOption, Model model) throws KampanjaException{
            LOGGER.info("Duke ruajtur shfrytezuesin: "+user.getUsername());
            
            user.setRole(roli);
            user.setStatus(true);
            user.setDegaID(degaService.findDegaByName(degaOption));
            System.out.println("Roli i Userit: "+roli);
            usersService.create(user);
            
            return "redirect:/users";
                    
        }
         @GetMapping("/users/rikthe")
        public String riktheUser(Model model, Users user, Principal principal) throws KampanjaException{
            LOGGER.info("Duke shfaqur formen rikthe Shfrytezuesin");
            
             user = usersService.findUserByUsername(principal.getName());
        
            if(user.getRole().equals("admin")){
            LOGGER.info("Duke shfaqur faqen shfytezuesit.");

                model.addAttribute("user", new Users());
               
                model.addAttribute("allUsers", usersService.findAll());

                return "riktheUser";
            }else{
                LOGGER.info("Nuk keni casje");
                return "403";
            } 
        
        }
        @RequestMapping(value = "/users/rikthe/{id}", method = RequestMethod.GET)
	public String riktheUserPost(@PathVariable int id, Model model) throws KampanjaException {
                Users user = usersService.findById(id);
                user.setStatus(true);
                user.setPassword(DEFAULT_PASSWORD);
		LOGGER.info("Duke rikthyer shfrytezuesin me username: " + user.getUsername());
		usersService.edit(user);

		return "redirect:/users";
	}
        @GetMapping("/changePassword")
        public String getChangePassword(Model model, Users user,Principal principal){
            LOGGER.info("Duke hapur formen ndrysho fjalekalimin");
            user = usersService.findUserByUsername(principal.getName());
            if(user.getRole().equals("admin")){
            System.out.println("principal:  "+principal.getName());
            System.out.println("Username:  "+user.getUsername());
            model.addAttribute("user",user);
            return "changePassword";
            }else{
                LOGGER.info("Duke shfaqur formen nuk keni qasje.");
                return "403";
            }
            
        }
        @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
        public String postChangePsw(@RequestParam("psw") String newPassword, Users user, Principal principal) throws KampanjaException{
             user = usersService.findUserByUsername(principal.getName());
            LOGGER.info("Duke ndryshuar fjalekalimin per userin: "+user.getUsername());
            user.setPassword(encode.encode(newPassword));
            usersService.edit(user);
            if(user.getRole().equals("admin"))
            return "redirect:/users";
            else{
                return "redirect:/home";
            }
        
        
        }
}
