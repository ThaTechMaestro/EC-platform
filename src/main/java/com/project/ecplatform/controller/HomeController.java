package com.project.ecplatform.controller;

import com.project.ecplatform.model.entity.Cart;
import com.project.ecplatform.repository.CartRepository;
import com.project.ecplatform.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private ItemRepository itemRepository;
    private CartRepository cartRepository;

    public HomeController(ItemRepository itemRepository,
                          CartRepository cartRepository){

        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
    }

    @GetMapping()
    public String Home(Model model){
        model.addAttribute("items", this.itemRepository.findAll());
        model.addAttribute("cart", this.cartRepository.findById("My Cart")
                .orElseGet(() -> new Cart("My Cart")));
        return "Home";
    }
}
