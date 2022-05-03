package com.portfolio.TellMeWhenApp.Controller;

import com.portfolio.TellMeWhenApp.Product.Service.ProductServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    public static final Logger LOGGER = LogManager.getLogger(MainController.class);

    ProductServiceImpl productService;

    public MainController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }



}
