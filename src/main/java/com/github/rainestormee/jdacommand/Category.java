package com.github.rainestormee.jdacommand;

import java.lang.annotation.*;

/**
 * This represents a generic category.
 *
 * @author AdrianTodt
 * @since 1.1.2
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.PACKAGE})
public @interface Category
{
    String value();
}
