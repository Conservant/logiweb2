package com.tsystems.logiweb2.Annotation;

/**
 * Created by StarKiller on 23.11.2014.
 */

@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@javax.validation.Constraint(validatedBy = {NumberValidator.class})
public @interface UniqueNumber {

    java.lang.String message();

    java.lang.Class<?>[] groups() default {};

    java.lang.Class<? extends javax.validation.Payload>[] payload() default {};

}
