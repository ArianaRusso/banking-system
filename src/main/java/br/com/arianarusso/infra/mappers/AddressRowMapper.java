package br.com.arianarusso.infra.mappers;

import br.com.arianarusso.entities.Address;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AddressRowMapper implements EntityMapper<Address> {

    public static final String POSTAL_CODE = "postal_code";
    public static final String STREET = "street";
    public static final String NUMBER = "number";
    public static final String COMPLEMENT = "complement";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String COUNTRY = "country";

    @Override
    public List<String> getColumnNames() {
        return Arrays.asList
                (POSTAL_CODE, STREET, NUMBER, COMPLEMENT, CITY, STATE, COUNTRY);
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
            Address address = new Address(
                    resultSet.getString(POSTAL_CODE),
                    resultSet.getString(STREET),
                    resultSet.getInt(NUMBER),
                    resultSet.getString(COMPLEMENT),
                    resultSet.getString(CITY),
                    resultSet.getString(STATE),
                    resultSet.getString(COUNTRY));

        return address;
    }

    @Override
    public void entityToPreparedStatement(PreparedStatement statement, Address entity) throws SQLException {
        statement.setString(1, entity.getPostalCode());
        statement.setString(2, entity.getStreet());
        statement.setInt(3, entity.getNumber());
        statement.setString(4, entity.getComplement());
        statement.setString(5, entity.getCity());
        statement.setString(6, entity.getState());
        statement.setString(7, entity.getCountry());
    }
}



