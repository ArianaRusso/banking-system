package br.com.arianarusso.infra.mappers;

import br.com.arianarusso.entities.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AddressRowMapper implements EntityMapper<Address> {

    @Override
    public List<Address> resultSetToEntityList(ResultSet resultSet) throws SQLException {
        List<Address> addresses = new ArrayList<>();

        while (resultSet.next()) {
            Address address = resultSetToEntity(resultSet);
            addresses.add(address);
        }
        return addresses;
    }

    @Override
    public Address resultSetToEntity(ResultSet resultSet) throws SQLException {

            Address address = new Address();
            address.setId(UUID.fromString(resultSet.getString("id")));
            address.setPostalCode(resultSet.getString("postal_code"));
            address.setStreet(resultSet.getString("street"));
            address.setNumber(resultSet.getInt("number"));
            address.setComplement(resultSet.getString("complement"));
            address.setCity(resultSet.getString("city"));
            address.setState(resultSet.getString("state"));
            address.setCountry(resultSet.getString("country"));

        return address;
    }

    @Override
    public void entityToPreparedStatement(PreparedStatement statement, Address entity) throws SQLException {
        Address address = new Address();
        statement.setString(1, address.getPostalCode());
        statement.setString(2, address.getStreet());
        statement.setInt(3, address.getNumber());
        statement.setString(4, address.getComplement());
        statement.setString(5, address.getCity());
        statement.setString(6, address.getState());
        statement.setString(7, address.getCountry());
    }
}



