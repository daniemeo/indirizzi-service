
package it.sogei.svildep.indirizziservice.validation.validator;

import it.sogei.svildep.indirizziservice.validation.XORFields;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class XORFieldsValidator implements ConstraintValidator<XORFields, Object> {

    private String field;
    private String fieldMatch;

    @Override
    public void initialize(XORFields constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        Object fieldValue = new BeanWrapperImpl(o).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(o).getPropertyValue(fieldMatch);
        return fieldValue != null ^ fieldMatchValue != null;
    }
}
