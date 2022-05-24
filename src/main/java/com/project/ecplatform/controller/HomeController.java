package com.project.ecplatform.controller;

import com.project.ecplatform.model.entity.Cart;
import com.project.ecplatform.model.entity.CartItem;
import com.project.ecplatform.model.entity.Item;
import com.project.ecplatform.repository.CartRepository;
import com.project.ecplatform.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id){

        Cart cart = this.cartRepository.findById("My Cart")
                .orElseGet(() -> new Cart("My Cart"));

        cart.getCartItems().stream()
                .filter(cartItem -> cartItem.getItem().getId().equals(id))
                .findAny()
                .map(cartItem -> {
                    cartItem.increment();
                    return cart;

                })
                .orElseGet(() -> { 5
                    Item item = this.itemRepository.findById(id)
                            .orElseThrow(() -> new IllegalStateException("Can't seem to find Item type " + id));
                    cart.getCartItems().add(new CartItem(item, cart));
                    return cart; });



    }

}
