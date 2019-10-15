package com.dandan.other.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/**
 * Created by dandan On 九月 09 2019
 * @author dandan
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Audit {
    String actionType();
    String actionCategoryCode();
    String actionCategoryName();
    boolean stringList() default true;

}
