package br.com.arianarusso.infra.mappers;

import br.com.arianarusso.entities.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AddressRowMapper implements EntityMapper<Address> {

    @Override
    public List<String> getColumnNames() {
        return Arrays.asList
                ("id", "postal_code ", "street", "number", "complement", "city", "state", "country");
    }

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

        statement.setObject(1, entity.getId());
        statement.setString(2, entity.getPostalCode());
        statement.setString(3, entity.getStreet());
        statement.setInt(4, entity.getNumber());
        statement.setString(5, entity.getComplement());
        statement.setString(6, entity.getCity());
        statement.setString(7, entity.getState());
        statement.setString(8, entity.getCountry());
    }
}



