package dao.entities;

public class Person {

    String name;
    String email;
    String phone;
    String address;

    public Person(final String name, final String email, final String phone, final String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
