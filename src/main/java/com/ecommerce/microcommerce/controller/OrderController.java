package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.OrderDAO;
import com.ecommerce.microcommerce.model.CartInfo;
import com.ecommerce.microcommerce.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Transactional
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @RequestMapping("/shoppingCartConfirmation")
    public String createOrder(HttpServletRequest request, Model model) {
        CartInfo cartInfo = Utils.getCartInSession(request);

        if (cartInfo.isEmpty()) {

            return "redirect:/shoppingCart";
        }

        try {
            orderDAO.saveOrder(cartInfo);
        } catch (Exception e) {

            return "shoppingCartConfirmation";
        }

        // Remove Cart from Session.
        Utils.removeCartInSession(request);

        // Store last cart.
        Utils.storeLastOrderedCartInSession(request, cartInfo);

        return "redirect:/shoppingCartFinalize";
    }

    @RequestMapping("/shoppingCartFinalize")
    public String shoppingCartFinalize(HttpServletRequest request, Model model) {
        return "shoppingCartFinalize";
    }
}
