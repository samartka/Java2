package boot.controller;

import java.util.Collection;
import java.util.HashMap;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import boot.entity.AppUser;
import boot.entity.AppUserJoined;
import boot.service.AppUserService;

@RestController
@CrossOrigin
public class SimpleController {
    @Autowired
    private AppUserService appUserService;

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello World!";
    } 
    @RequestMapping("/api/simpleApi")
    @ResponseBody
    String simpleApi() {
        return "{\"status\" : \"success\"}";
    } 
    @RequestMapping("/api/getUser/{username}")
    @ResponseBody
    AppUser getUser(@PathVariable("username") String username) {
        AppUser userInfo = appUserService.findByUserName(username);
        return userInfo;
    } 
    @RequestMapping("/api/getUserById/{user_id}")
    @ResponseBody
    AppUser getUserById(@PathVariable("user_id") Long userId) {
        try {
            AppUser userInfo = appUserService.findById(userId); 
            return userInfo;
        } catch (java.util.NoSuchElementException exception) {
            return null;
        }
        
    } 
    @RequestMapping(value = "/api/getUserAll", method = RequestMethod.GET)
    @ResponseBody
    Iterable<AppUser> getUserAll() {
        Iterable<AppUser> allUser = appUserService.findAll();
        
        return allUser;
    } 

    @RequestMapping(value = "/api/getByGender/{gender}", method = RequestMethod.GET)
    @ResponseBody
    Collection<AppUser> getByGender(@PathVariable("gender") String gender) {
        Collection<AppUser> allUser = appUserService.findByGender(gender);
        
        return allUser;
    } 

    @RequestMapping(value = "/api/getByMyId/{user_id}", method = RequestMethod.GET)
    @ResponseBody
    AppUser getByMyId(@PathVariable("user_id") Long userId) {
        AppUser allUser = appUserService.findByMyId(userId);
        return allUser;
    } 

    @RequestMapping(value = "/api/getByFullName/{firstname}/{lastname}", method = RequestMethod.GET)
    @ResponseBody
    AppUser getByFullName(@PathVariable("firstname") String firstName, @PathVariable("lastname") String lastName) {
        AppUser allUser = appUserService.findByFullName(firstName, lastName);
        return allUser;
    } 

    @RequestMapping(value = "/api/getUserAllData/{user_id}", method = RequestMethod.GET)
    @ResponseBody
    Collection<AppUserJoined> getUserAllData(@PathVariable("user_id") Long userId) {
        return appUserService.findByUserIdAll(userId);
    }

    @RequestMapping(value = "/api/updateProfile", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<String> updateProfile (@RequestParam("user_id") Long userId, 
                    @RequestParam("firstname") String firstname,
                    @RequestParam("lastname") String lastname,
                    @RequestParam("email") String email,
                    @RequestParam("gender") String gender) {
        int updatedRow;
        try {
            updatedRow = appUserService.updateProfile(userId, firstname, lastname, email, gender);
        } catch(Exception ex) {
            return new ResponseEntity<>("{\"status\" : \"fail\"}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("{\"status\" : \"success\", \"updated_row\" : "+ updatedRow +"}", HttpStatus.OK);
    }
}