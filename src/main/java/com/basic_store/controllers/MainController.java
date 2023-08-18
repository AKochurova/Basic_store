package com.basic_store.controllers;

import com.basic_store.models.OrderedItem;
import com.basic_store.models.SellProduct;
import com.basic_store.models.User;
import com.basic_store.models.UserOrder;
import com.basic_store.repos.ItemRepo;
import com.basic_store.repos.OrderRepo;
import com.basic_store.repos.ProductRepo;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    OrderRepo orderRepo;


    @GetMapping("/orders")
    public String main(Map<String, Object> model, Map<String, Object> total,
                       @AuthenticationPrincipal User currentUser) {
        Iterable<OrderedItem> items = itemRepo.findByBuyer(currentUser);

        Long totalPrice = 0L;
        for (OrderedItem i:items) {
            totalPrice+=i.getPrice();

        }

        model.put("messages", items);
        total.put("total", totalPrice);

        return "orders";
    }

    @PostMapping("/home/{id}/{price}")
    public String add(@PathVariable("id") String id,
                      @PathVariable("price") String price,
                      @AuthenticationPrincipal User currentUser) {



        OrderedItem orderedItem = new OrderedItem(id, currentUser, Long.valueOf(price));

        itemRepo.save(orderedItem);


        return "redirect:/home";
    }

    @PostMapping("orders/{id}")
    public String delete(@PathVariable("id") String id) {


        itemRepo.deleteById(Long.valueOf(id));


        return "redirect:/orders";
    }

    @GetMapping("/home")
    public String main2(Map<String, Object> model) {
        Iterable<SellProduct> products = productRepo.findAll();

        model.put("products", products);

        return "home";
    }

    @PostMapping("orders/send/{total}")
    public String order(@PathVariable("total") String total, @AuthenticationPrincipal User currentUser) {

        UserOrder orderedItem = new UserOrder(Long.valueOf(total), currentUser);
        orderRepo.save(orderedItem);

        return "redirect:/orders";
    }

}
