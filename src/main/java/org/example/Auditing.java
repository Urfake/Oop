package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("auditing")
public class Auditing {
    @Value("Optima Bank")
    private String bank;
    @Value("Doneck")
    private String address;
    @Value("2015")
    private int year;
    public String getBank() {
        return bank;
    }

    public String getAddress() {
        return address;
    }
    public int getYear() {
        return year;
    }

    // До перевода средств
    public void validate(String bank, String address){
        this.bank = bank;
        this.address = address;
        System.out.println("банк проверяет ваши учетные данные до перевода средств");
    }
    // До перевода средств
    public void transferInstantiate(){
        System.out.println("банк создает экземпляр сервиса перевода средств");
    }
    // После перевода средств
    public void success(){
        System.out.println("банк успешно выполнил перевод средств");
    }
    // После неудачного перевода средств
    public void rollback() {
        System.out.println("банк откатил операцию перевода средств");
    }

}
