package com.ltc.controllers.admin.restapi;

import com.ltc.dto.ProductDTO;
import com.ltc.dto.UserDTO;
import com.ltc.model.Product;
import com.ltc.services.ProductServices;
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
@RequestMapping(value = "api/product")
public class ProductManagementRest {

    @Autowired
    ProductServices productServices;

    @RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> find (@PathVariable("id") Long id){
        try {
            return new ResponseEntity<Product>(productServices.findProductById(id), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
    }
}
