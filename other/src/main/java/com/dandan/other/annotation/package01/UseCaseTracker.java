package com.dandan.other.annotation.package01;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description UserCase注解处理器
 * @Author dandan
 * @Date 2019-10-15
 */
public class UseCaseTracker {

    public static void trackUseCase(List<Integer> useCases, Class<?> c1){

        for (Method declaredMethod : c1.getDeclaredMethods()) {
            UseCase useCase = declaredMethod.getAnnotation(UseCase.class);
            if(useCase != null){
                System.out.println("Found UseCase :" + useCase.id() + " " + useCase.description());
                useCases.remove(new Integer(useCase.id()));
            }
        }
        useCases.forEach(uc -> System.out.println(uc));
    }


    public static void main(String[] args){
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases,44,45,46,47,48,49,50);
        trackUseCase(useCases,PasswordUtils.class);
    }

}
