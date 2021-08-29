package com.ecommerce.microcommerce.controller;

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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Transactional
public class TVAController {

    @Autowired
    private ProductDAO productDAO;

    // TVA
    @RequestMapping(value = { "/gettva" }, method = RequestMethod.GET)
    public String getTVA(HttpServletRequest request, Model model, //
                         @RequestParam(value = "code", defaultValue = "") String code) {

        Product product = null;
        double amount, tva = 0;
        if (code != null && code.length() > 0) {
            product = productDAO.findProduct(code);
        }
        if (product != null) {
            CartInfo cartInfo = Utils.getCartInSession(request);

            ProductInfo productInfo = new ProductInfo(product);
            amount = product.getPrice();

            if(product.getCategory().equals("AUTRE"))
            {
                tva = amount+(amount/100)*21;
            }
            else{
                tva = amount+(amount/100)*6;
            }

            cartInfo.updateTVA(productInfo, tva);
        }

        return "redirect:/shoppingCart";
    }
}
