package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.AccountDAO;
import com.ecommerce.microcommerce.dao.ProductDAO;
import com.ecommerce.microcommerce.entity.Account;
import com.ecommerce.microcommerce.entity.Product;
import com.ecommerce.microcommerce.form.CustomerForm;
import com.ecommerce.microcommerce.model.CartInfo;
import com.ecommerce.microcommerce.model.CustomerInfo;
import com.ecommerce.microcommerce.model.ProductInfo;
import com.ecommerce.microcommerce.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@Transactional
public class CheckoutController {

    @Autowired
    private AccountDAO accountDAO;

    // GET: Show cart and cart info
    @RequestMapping(value = { "/checkout" }, method = RequestMethod.GET)
    public String doCheckout(HttpServletRequest request, Model model) {

        CartInfo cartInfo = Utils.getCartInSession(request);

        if (cartInfo.isEmpty()) {

            return "redirect:/shoppingCart";
        }

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Account account = accountDAO.findAccount(userDetails.getUsername());

        CustomerInfo customerInfo = new CustomerInfo(account);
        customerInfo.setValid(true);
        cartInfo.setCustomerInfo(customerInfo);

        model.addAttribute("customerInfo", customerInfo);
        model.addAttribute("cartInfo", cartInfo);

        return "checkout";
    }
}
