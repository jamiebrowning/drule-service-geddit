package com.example.rule;

import com.example.rule.controller.RuleController;
import com.example.rule.domain.external.Product;
import com.example.rule.domain.RuleData;
import com.example.rule.service.RuleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RuleController.class)
class RuleControllerTest {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RuleService ruleService;

    @Test
    void fireAllRules_WhenValidInput_ShouldReturn200() throws Exception {
        final Product product = Product.builder().name("test").price(10).build();
        final RuleData<Product> productRuleData = new RuleData<>(product);

        when(this.ruleService.fireAllRules(any(RuleData.class))).thenReturn(productRuleData);

        this.mvc.perform(
                post("/fireAllRules")
                        .content(mapper.writeValueAsString(Product.builder().build()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.context.@class").value("com.example.rule.domain.external.Product"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.context.name").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.context.price").value(10));
    }
}