package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoginAspect {
    @Before("org.example.MyPointcuts.allAddMethods()")
    public void beforeGetAuditAdvice() {
        System.out.println("Попытка получить аудитинг");
    }
    @Before("org.example.MyPointcuts.allAddMethods()" )
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature)
                joinPoint.getSignature();
        System.out.println("methodSignature: " + methodSignature);
        System.out.println("methodSignature.getMethod(): " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType(): " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName(): " + methodSignature.getName());
        if (methodSignature.getName().equals("validate")) {
            Object[] arg = joinPoint.getArgs();
            for (Object obj : arg) {
                if (obj instanceof Auditing) {
                    Auditing auditing = (Auditing) obj;
                    System.out.println("Information about of book: name of book -" + auditing.getBank() + ", author of book- " + auditing.getAddress() + ", year of publication of book- " + auditing.getYear());
                }
                else if (obj instanceof String)
                    System.out.println("Bank add by -" +
                            obj);
            }
        }
        System.out.println("beforeAddLoggingAdvice: логгирование попытки получить книгу/журнал");
                System.out.println("----------------------------");
    }
}
