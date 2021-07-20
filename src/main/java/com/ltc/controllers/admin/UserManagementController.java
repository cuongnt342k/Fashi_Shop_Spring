package com.ltc.controllers.admin;

import com.ltc.dto.UserDTO;
import com.ltc.services.UserService;
import com.ltc.utils.SecurityUtils;
import com.ltc.validator.UserDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String addUserPage(HttpServletRequest request, @Valid @ModelAttribute("User") UserDTO userDTO, BindingResult bindingResult, Model mav) throws Exception {
        List<UserDTO> userDTOS = userService.findAll(false);
        userDTOValidator.validate(userDTO, bindingResult);
        mav.addAttribute("listUser",userDTOS);
        if (bindingResult.hasErrors()) {
            return "admin/user-management";
        }
        String roleName = request.getParameter("role");
        userService.saveOrUpdate(userDTO, SecurityUtils.getPrincipal().getUsername(),roleName);
        userDTOS = userService.findAll(false);
        mav.addAttribute("listUser",userDTOS);
        return "redirect:/admin/user-management";
    }

    @RequestMapping(value = "/delete-user", method = RequestMethod.POST)
    public String deleteUserPage(HttpServletRequest request, Model mav) throws Exception {
        Long id = Long.valueOf(request.getParameter("id"));
        userService.deleteUser(id, SecurityUtils.getPrincipal().getUsername());
        List<UserDTO> userDTOS = userService.findAll(false);
        mav.addAttribute("listUser",userDTOS);
        return "redirect:/admin/user-management";
    }

}
