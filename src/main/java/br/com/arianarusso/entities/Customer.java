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

    public Customer(UUID id, String firstName, String lastName, String document, UUID addressId, List<UUID> accountIds) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.addressId = addressId;
        this.accountIds = accountIds;
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

    public List<UUID> getAccountIds() {
        return accountIds;
    }

    private void setAccountIds(List<UUID> accountIds) {
        this.accountIds = accountIds;
    }

    public void addAccount(UUID newIdAccount){
        if(!this.accountIds.isEmpty() && !this.accountIds.contains(newIdAccount)){
            this.accountIds.add(newIdAccount);
        }
    }

    public void removeAccount (UUID idAccount) {
        if (!this.accountIds.isEmpty() && this.accountIds.contains(idAccount)) {
            this.accountIds.remove(idAccount);
        }
    }
}
