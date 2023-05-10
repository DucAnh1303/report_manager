package MyProject.webapp.validate.constraint;


import MyProject.webapp.validate.UserValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//@Constraint(validatedBy = UserValidator.class)
//@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
//@Retention(RetentionPolicy.RUNTIME)
public @interface UserConstraint {
    String message() default "user name is exits";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
