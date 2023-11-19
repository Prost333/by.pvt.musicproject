package by.pvt.musicproject.aop.verification;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControlSessionUserBySubscription {
    String message() default "Подписка не активна";
}
