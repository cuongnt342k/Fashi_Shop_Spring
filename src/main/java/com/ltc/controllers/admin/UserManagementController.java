package com.ltc.controllers.admin;

import com.ltc.dto.UserDTO;
import com.ltc.services.UserService;
import com.ltc.utils.SecurityUtils;
import com.ltc.validator.UserDTOValidator;
import com.ltc.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/user-management")
public class UserManagementController {

    @Autowired
    UserService userService;

    @Autowired
    private UserDTOValidator userDTOValidator;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView userManagementPage() throws Exception {
        List<UserDTO> userDTOS = userService.findAll(false);
        ModelAndView mav = new ModelAndView("admin/user-management");
        mav.addObject("listUser",userDTOS);
        mav.addObject("User",new UserDTO());
        return mav;
    }
}
