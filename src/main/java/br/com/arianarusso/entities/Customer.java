package br.com.arianarusso.entities;

import java.util.UUID;


public class Customer {

    private UUID id;
    private String firstName;
    private String lastName;
    private String document;
    private UUID addressId;


    public Customer
            (String firstName, String lastName, String document, UUID addressId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.addressId = addressId;

    }

    public Customer
            (UUID id, String firstName, String lastName, String document, UUID addressId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.addressId = addressId;
    }

    public Customer() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public UUID getAddressId() {
        return addressId;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", document='" + document + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}
