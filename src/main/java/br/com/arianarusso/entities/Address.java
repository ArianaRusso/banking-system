package br.com.arianarusso.entities;

public class Address {

    private String postalCode;
    private String street;
    private int number;
    private String complemento;
    private String city;
    private String state;
    private String country;

    public Address(String postalCode, String street, int number, String complemento, String city, String state, String country) {
        this.postalCode = postalCode;
        this.street = street;
        this.number = number;
        this.complemento = complemento;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
