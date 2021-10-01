package com.example.rule;

import com.example.rule.domain.external.Product;
import com.example.rule.domain.RuleData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class RuleDataProductJsonTests {

    @Autowired
    JacksonTester<RuleData<Product>> json;

    @Test
    void serialize() throws Exception {
        final RuleData<Product> data = new RuleData<>(Product.builder().name("test").build());
        JsonContent<RuleData<Product>> result = json.write(data);
        assertThat(result).hasJsonPathValue(".@class");
        assertThat(result).extractingJsonPathArrayValue(".@class").contains(Product.class.getName());
    }

    @Test
    void deserialize() throws Exception {
        String content = "{\"context\":{\"@class\":\"com.example.rule.domain.external.Product\",\"name\":\"test\",\"price\":10}}";
        assertThat(json.parse(content)).isEqualTo(
                new RuleData<>(Product.builder().name("test").price(10).build()));
        assertThat(json.parseObject(content).getContext().getName()).isEqualTo("test");
        assertThat(json.parseObject(content).getContext().getPrice()).isEqualTo(10);
    }
}
