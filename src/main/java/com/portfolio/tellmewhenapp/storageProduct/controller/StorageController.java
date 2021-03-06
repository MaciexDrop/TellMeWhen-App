package com.portfolio.tellmewhenapp.storageProduct.controller;

import com.portfolio.tellmewhenapp.storageProduct.service.StorageProductServiceImpl;
import com.portfolio.tellmewhenapp.storageProduct.dto.StorageProductDto;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class StorageController {

    public static final Logger LOGGER = LogManager.getLogger(StorageController.class);

    StorageProductServiceImpl productService;

    @GetMapping("/storage")
    public String showAllProducts(Model model) {

        List<StorageProductDto> listOfStorageProductDto = productService.getAll();
        model.addAttribute("listOfStorageProductDto", listOfStorageProductDto);

        LOGGER.info("Successfully loaded all products");
        return "storage";
    }

}
