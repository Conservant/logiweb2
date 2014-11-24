package com.tsystems.logiweb2.Annotation;

/**
 * Created by StarKiller on 23.11.2014.
 */

@java.lang.annotation.Target({java.lang.annotation.ElementType.FIELD})
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@javax.validation.Constraint(validatedBy = {LicenseValidaror.class})
public @interface UniqueLicense {

    String message();

    Class<?>[] groups() default {};

    Class<? extends javax.validation.Payload>[] payload() default {};

}
