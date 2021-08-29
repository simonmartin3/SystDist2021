package com.ecommerce.microcommerce.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.microcommerce.dao.AccountDAO;
import com.ecommerce.microcommerce.dao.OrderDAO;
import com.ecommerce.microcommerce.dao.ProductDAO;
import com.ecommerce.microcommerce.entity.Account;
import com.ecommerce.microcommerce.entity.Product;
import com.ecommerce.microcommerce.form.CustomerForm;
import com.ecommerce.microcommerce.model.CartInfo;
import com.ecommerce.microcommerce.model.CustomerInfo;
import com.ecommerce.microcommerce.model.ProductInfo;
import com.ecommerce.microcommerce.pagination.PaginationResult;
import com.ecommerce.microcommerce.utils.Utils;
import com.ecommerce.microcommerce.validator.CustomerFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Transactional
public class MainController {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private CustomerFormValidator customerFormValidator;

    @InitBinder
    public void myInitBinder(WebDataBinder dataBinder) {
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);

        // Case update quantity in cart
        // (@ModelAttribute("cartForm") @Validated CartInfo cartForm)
        if (target.getClass() == CartInfo.class) {

        }

        // Case save customer information.
        // (@ModelAttribute @Validated CustomerInfo customerForm)
        else if (target.getClass() == CustomerForm.class) {
            dataBinder.setValidator(customerFormValidator);
        }

    }

    @RequestMapping("/403")
    public String accessDenied() {
        return "/403";
    }

    @RequestMapping("/")
    public String home(Model model, //
                       @RequestParam(value = "name", defaultValue = "") String likeName,
                       @RequestParam(value = "page", defaultValue = "1") int page) {
        final int maxResult = 8;
        final int maxNavigationPage = 10;

        PaginationResult<ProductInfo> result = productDAO.queryProducts(page, //
                maxResult, maxNavigationPage, likeName);

        model.addAttribute("paginationProducts", result);
        return "index";
    }

    @RequestMapping(value = { "/productImage" }, method = RequestMethod.GET)
    public void productImage(HttpServletRequest request, HttpServletResponse response, Model model,
                             @RequestParam("code") String code) throws IOException {
        Product product = null;
        if (code != null) {
            product = this.productDAO.findProduct(code);
        }
        if (product != null && product.getImage() != null) {
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(product.getImage());
        }
        response.getOutputStream().close();
    }

}
