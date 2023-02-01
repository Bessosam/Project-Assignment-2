package se.jensenyh.javacourse.saltmerch.backend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

import java.util.List;


@Service
public class CartService
{
    @Autowired
    CartRepository cartRepository;
    public List<CartItem> selectAllItems(){ return cartRepository.selectAllItems();}

    public int insertOrIncrementItem(CartItem item){return cartRepository.insertOrIncrementItem(item);}

    public void deleteAllItems(boolean restock){  cartRepository.deleteAllItems(true);}


}
