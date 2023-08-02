package jakarta.validation;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

public @interface Constraint {

    Class<CPFValidator> validatedBy();

}
