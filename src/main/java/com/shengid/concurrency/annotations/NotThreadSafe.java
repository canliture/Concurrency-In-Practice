package com.shengid.concurrency.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 注解作用的目标：给一个类加上注解
@Retention(RetentionPolicy.SOURCE)  // 注解存在的范围：只存在于源代码中
public @interface NotThreadSafe {
    String value() default "";
}
