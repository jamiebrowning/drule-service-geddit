package com.example.rule.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.beans.ConstructorProperties;

/**
 * A generic class that provides a thin wrapper around a context.
 *
 * @param <T> the context upon which any rule may operate.
 */
@Data
public class RuleData<T> {

    /**
     * Default constructor.
     *
     * @param context the context
     */
    @ConstructorProperties({"context"})
    public RuleData(T context) {
        this.context = context;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,  property = "@class")
    private final T context;
}
