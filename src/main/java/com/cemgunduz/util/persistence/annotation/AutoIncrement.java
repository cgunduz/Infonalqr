package com.cemgunduz.util.persistence.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by cgunduz on 3/21/14.
 */

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface AutoIncrement {


}
