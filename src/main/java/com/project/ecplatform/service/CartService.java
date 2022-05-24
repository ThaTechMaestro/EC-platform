package com.project.ecplatform.service;

import com.project.ecplatform.model.entity.Cart;
import com.project.ecplatform.model.entity.CartItem;
import com.project.ecplatform.model.entity.Item;
import com.project.ecplatform.repository.CartRepository;
import com.project.ecplatform.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final ItemRepository itemRepository;
    private final CartRepository cartRepository;


    public CartService(ItemRepository itemRepository, CartRepository cartRepository) {
        this.itemRepository = itemRepository;
        this.cartRepository = cartRepository;
    }

    Cart addToCart(String cartId, Integer itemId){

        Cart cart = this.cartRepository.findById(cartId) //
                .orElseGet(() -> new Cart(cartId));

        cart.getCartItems().stream() //
                .filter(cartItem -> cartItem.getItem().getId().equals(itemId)) // .findAny() //
                .map(cartItem -> {
                    cartItem.increment();
                    return cart; }) //
                .orElseGet(() -> {
                    Item item = this.itemRepository.findById(itemId) //
                            .orElseThrow(() -> new IllegalStateException("Can't seem to find Item type " + itemId));
                    cart.getCartItems().add(new CartItem(item, cart)); 4 return cart;

    }
}
