package tech.marcusvieira.student.client;

import java.util.ServiceLoader;

public class Client {
    public static void main(String[] args) {

        ServiceLoader<Service> service = ServiceLoader.load(Service.class);
        for (Service s: service) {
            String result = s.concatFullName("Avgustina", "Shevchuk");
            System.out.println(result);
        }
    }
}