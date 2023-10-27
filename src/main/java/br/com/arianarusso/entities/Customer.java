package br.com.arianarusso.entities;

import java.util.List;
import java.util.UUID;


public class Customer {

    private UUID id;
    private String firstName;
    private String lastName;
    private String document;
    private UUID addressId;
    private List<UUID> accountIds;


}
