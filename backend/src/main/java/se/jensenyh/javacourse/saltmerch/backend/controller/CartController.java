package se.jensenyh.javacourse.saltmerch.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.service.CartService;

import java.util.List;

@CrossOrigin("http//:localhost:3010")
@RequestMapping("/api/v1")
@RestController
public class CartController {
    @Autowired
    CartService cartService;


    @GetMapping("/carts")
    public ResponseEntity<List<CartItem>> getselectAllItems() {
        return new ResponseEntity<>(cartService.selectAllItems(), HttpStatus.OK);
    }
    @GetMapping("/carts/{id}")
    public ResponseEntity<List<CartItem>> getselectAllItems(@PathVariable("id") String id) {
        return new ResponseEntity<>(cartService.selectAllItems(), HttpStatus.OK);
    }

    @PatchMapping("/carts/{id}")
    public ResponseEntity<?> getInsertOrIncrementItem(@RequestBody CartItem item, @PathVariable("id") String id) {
        return new ResponseEntity<>(cartService.insertOrIncrementItem(item), HttpStatus.OK);
    }

    @DeleteMapping("/carts/{id}")
    public ResponseEntity<Void> deleteAllItems(@PathVariable ("id") boolean restock) {

        try {
            this.cartService.deleteAllItems(restock);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }
}


