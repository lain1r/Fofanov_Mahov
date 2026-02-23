package org.example.fitness;

public class Person {
    String firstName;
    String lastName;
    int yearOfBirth;

    public Person(String firstName, String lastName, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + yearOfBirth + " г.р.)";
    }
}