package com.ltc.controllers.admin.restapi;

import com.ltc.dto.UserDTO;
import com.ltc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/user")
public class UserManagementRest {

    @Autowired
    UserService userService;

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> find (@PathVariable("id") Long id){
        try {
            return new ResponseEntity<UserDTO>(userService.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
        }
    }
}
