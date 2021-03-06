package com.portfolio.tellmewhenapp.shoppingList.controller;

import com.portfolio.tellmewhenapp.mapper.ShoppingProductMapper;
import com.portfolio.tellmewhenapp.shoppingList.dto.ShoppingProductDto;
import com.portfolio.tellmewhenapp.shoppingList.service.ShoppingProductServiceImpl;
import com.portfolio.tellmewhenapp.storageProduct.service.StorageProductServiceImpl;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@Controller
@RequestMapping("/shoppingList")
public class ShoppingListProductController {

    public static final Logger LOGGER = LogManager.getLogger(ShoppingListProductController.class);

    ShoppingProductServiceImpl shoppingProductService;
    StorageProductServiceImpl storageProductService;
    ShoppingProductMapper productMapper;

    @GetMapping("/newProduct")
    public String newPurchase(@ModelAttribute("productDto") ShoppingProductDto shoppingProductDto, Model model) {
        LOGGER.info("New purchase model added to the view");
        return "addNewProductToShoppingList";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("productDto") @Valid ShoppingProductDto shoppingProductDto, BindingResult result, Model model) {
        if (result.hasFieldErrors()) {
            LOGGER.warn("Errors in the fields");
            return "addNewProductToShoppingList";
        } else {
            shoppingProductService.add(shoppingProductDto);
            LOGGER.info("Saved new purchase to the shopping list successfully");
        }
        return "shoppingListProductSaveSuccess";
    }

    @GetMapping("/addToStorage")
    public String editProduct(@RequestParam("id") Integer id, Model model) {

        ShoppingProductDto productToBeAdded = shoppingProductService.findOne(id);
        storageProductService.add(productMapper.mapShoppingDtoToStorageProductDto(productToBeAdded));
        shoppingProductService.delete(productToBeAdded.id());

        model.addAttribute("productToBeAdded", productToBeAdded);

        LOGGER.info("Edited product model added to the view");
        return "redirect:/shoppingList";
    }
}
