package br.com.arianarusso.accountaccess.dtos;

public record AccountOpeningData(
        String firstName,
        String lastName,
        String document,
        String postalCode,
        String street,
        int number,
        String complement,
        String city,
        String state,
        String country
) {
}
