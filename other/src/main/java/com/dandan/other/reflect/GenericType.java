package com.dandan.other.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.TypeVariable;

/**
 * Created by dandan On 八月 29 2019
 */
public class GenericType<T> implements GenericDeclaration{

    public TypeVariable<?>[] getTypeParameters() {
        return (TypeVariable<Class<T>>[])new TypeVariable<?>[0];
    }

    public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        return null;
    }

    public Annotation[] getAnnotations() {
        return new Annotation[0];
    }

    public Annotation[] getDeclaredAnnotations() {
        return new Annotation[0];
    }

}
