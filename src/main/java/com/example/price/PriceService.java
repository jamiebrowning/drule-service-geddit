package com.example.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceService {

    @Autowired
    RuleService ruleService;

    Product getPrice(String name) {
        final Product product = new Product.ProductBuilder().name(name).price(10).build();
        return ruleService.fireAllRules(product);
    }
}
