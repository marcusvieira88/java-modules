package tech.marcusvieira.student.service;

import tech.marcusvieira.student.client.Service;

public class ServiceImpl implements Service {

    public String concatFullName(String firstName, String lastName) {
        return firstName + " "+ lastName;
    }
}
