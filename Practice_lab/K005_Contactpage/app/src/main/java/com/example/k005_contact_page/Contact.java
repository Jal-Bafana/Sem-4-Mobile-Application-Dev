package com.example.k005_contact_page;

public class Contact {
    private int image;
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(int image, String name, String phoneNumber, String email) {
        this.image = image;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
