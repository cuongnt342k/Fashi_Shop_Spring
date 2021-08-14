package com.ltc.controllers.admin;

import com.ltc.dto.ProductDTO;
import com.ltc.dto.UserDTO;
import com.ltc.model.Product;
import com.ltc.services.ProductServices;
import com.ltc.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping(value = "/admin/product-management")
public class ProductManagementController {
    @Autowired
    ProductServices productServices;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView productManagement(Pageable pageable) throws Exception {
        Page<Product> pages = productServices.getAllProduct(pageable, false);
        ModelAndView mav = new ModelAndView("admin/product-management");
        mav.addObject("Product", new ProductDTO());
        mav.addObject("products", pages.getContent());
        return mav;
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public String addUserPage(HttpServletRequest request, @Valid @ModelAttribute("Product") ProductDTO productDTO,
                              BindingResult bindingResult, Model mav,
                              Pageable pageable, @RequestParam(value = "image") MultipartFile img) throws Exception {
        Page<Product> pages = productServices.getAllProduct(pageable, false);
        mav.addAttribute("products", pages.getContent());
        if (bindingResult.hasErrors() || img.isEmpty()) {
            if (img.isEmpty()) {
                mav.addAttribute("errorMessage", "may not be empty");
            }
            return "admin/product-management";
        }
        productDTO.setImg(saveFile2(img, request));
        Long category = Long.valueOf(request.getParameter("category"));
        productServices.saveOrUpdate(productDTO, SecurityUtils.getPrincipal().getUsername(), category);

        pages = productServices.getAllProduct(pageable, false);
        mav.addAttribute("listUser", pages.getContent());
        return "redirect:/admin/product-management";
    }

    @RequestMapping(value = "/update-product", method = RequestMethod.POST)
    public String updateProductPage(HttpServletRequest request, @Valid @ModelAttribute("Product") ProductDTO productDTO,
                                    BindingResult bindingResult, Pageable pageable, Model mav,
                                    @RequestParam(value = "image") MultipartFile img) throws Exception {
        Long id = Long.valueOf(request.getParameter("idUpdate"));
        productDTO.setId(id);
        Page<Product> pages = productServices.getAllProduct(pageable, false);
        mav.addAttribute("products", pages.getContent());
        if (bindingResult.hasErrors()) {

            return "admin/product-management";
        }
        if (!img.isEmpty()) {
            productDTO.setImg(saveFile2(img, request));
        }
        Long category = Long.valueOf(request.getParameter("category"));
        productServices.saveOrUpdate(productDTO, SecurityUtils.getPrincipal().getUsername(), category);

        pages = productServices.getAllProduct(pageable, false);
        mav.addAttribute("listUser", pages.getContent());
        return "redirect:/admin/product-management";
    }

    @RequestMapping(value = "/delete-product", method = RequestMethod.POST)
    public String deleteUserPage(HttpServletRequest request, Model mav, Pageable pageable) throws Exception {
        Long id = Long.valueOf(request.getParameter("idDelete"));
        productServices.deleteProduct(id, SecurityUtils.getPrincipal().getUsername());
        Page<Product> pages = productServices.getAllProduct(pageable, false);
        mav.addAttribute("listUser", pages.getContent());
        return "redirect:/admin/product-management";
    }

    private String saveFile(MultipartFile file, HttpServletRequest request) {
        if (file != null && !file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                //cho nay luu vao mot thu muc trong server (tạm thời máy em là server rồi) D://shopxx/images/
                String uploadRootPath = request.getServletContext().getRealPath("/") + "template" + File.separator + "img" + File.separator + "products";
                System.out.println(uploadRootPath);
                File dir = new File(uploadRootPath);
                String imgName = StringUtils.cleanPath(file.getOriginalFilename());
                File serverFile = new File(dir.getAbsoluteFile() + File.separator + imgName);
                System.out.println(serverFile.getPath());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream((serverFile)));
                stream.write(bytes);
                stream.close();
                return imgName;
            } catch (IOException e) {
                System.out.println(e);
                e.printStackTrace();
            }
        }
        return null;
    }

    private static final String UPLOAD_DIRECTORY = "/template/img/products";

    private String saveFile2(MultipartFile file, HttpServletRequest request) throws IOException {
        if (file != null && !file.isEmpty()) {
            ServletContext context = request.getServletContext();
            String path = context.getRealPath(UPLOAD_DIRECTORY);
            String filename = file.getOriginalFilename();
            System.out.println(path + " " + filename);
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
                    new File(path + File.separator + filename)));
            stream.write(bytes);
            stream.flush();
            stream.close();
            return filename;
        }
        return null;
    }
}
