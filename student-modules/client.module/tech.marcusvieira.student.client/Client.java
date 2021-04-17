package tech.marcusvieira.student.client;

import tech.marcusvieira.student.service.Service;

public class Client {
    public static void main(String[] args) {
        String result = Service.concatFullName("Marcus", "Vieira");
        System.out.println(result);
    }
}