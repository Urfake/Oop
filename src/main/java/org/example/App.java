package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new
                        AnnotationConfigApplicationContext(MyConfig.class);
        Auditing
                auditing=context.getBean("auditing",Auditing.class);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = in.next();
        System.out.println("Введите пароль");
        String password = in.next();
        String log = "Aidar";

        String pass = "Aidar2002";

        if (login.equals(log) && password.equals(pass))
        {
            auditing.validate("Optima bank", "Asanbai");
        }
        else
            System.out.println("Invalid values");

        context.close();
    }
}
