package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.OrderDAO;
import com.ecommerce.microcommerce.dao.ProductDAO;
import com.ecommerce.microcommerce.entity.Product;
import com.ecommerce.microcommerce.model.CartInfo;
import com.ecommerce.microcommerce.model.ProductInfo;
import com.ecommerce.microcommerce.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@Transactional
public class StockController {
    @Autowired
    private ProductDAO productDAO;

    // TVA
    @RequestMapping(value = { "/getStock" }, method = RequestMethod.GET)
    public String checkInventoryAddCart(HttpServletRequest request, Model model, //
                         @RequestParam(value = "code", defaultValue = "") String code) {

        Product product = null;
        double amount, tva = 0;
        if (code != null && code.length() > 0) {
            product = productDAO.findProduct(code);
        }
        if (product != null) {
            if(product.getStock() < 1)
                return "redirect:/?error=true#product";
        }

        return "redirect:/addItem?code="+code;
    }
}
