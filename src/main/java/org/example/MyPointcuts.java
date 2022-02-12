package org.example;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(* *(..))" )
    public void allAddMethods(){}
}
