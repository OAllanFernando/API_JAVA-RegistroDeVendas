package com.dev.backend.exception.model;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import java.lang.annotation.*;
import javax.validation.Payload;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@jakarta.validation.Constraint(validatedBy = CPFValidator.class)
@Documented
public @interface ErroValidacaoObjeto { // VALIDA SE O CPF É VALIDO
    String message() default "CPF inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
