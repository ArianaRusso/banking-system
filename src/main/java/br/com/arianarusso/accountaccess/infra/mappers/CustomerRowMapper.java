//package br.com.arianarusso.accountaccess.infra.mappers;
//import br.com.arianarusso.accountaccess.entities.Customer;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.UUID;
//
//public class CustomerRowMapper implements EntityMapper<Customer> {
//
//    public static final String ID = "id";
//    public static final String FIRSTNAME = "first_name";
//    public static final String LASTNAME = "last_name";
//    public static final String DOCUMENT = "document";
//    public static final String ADDRESSID = "address_id";
//
//
//    @Override
//    public List<String> getColumnNames() {
//        return Arrays.asList
//                (FIRSTNAME, LASTNAME, DOCUMENT, ADDRESSID);
//    }
//
//    @Override
//    public List<Customer> resultSetToEntityList(ResultSet resultSet) throws SQLException {
//        List<Customer> customers = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Customer customer = resultSetToEntity(resultSet);
//            customers.add(customer);
//        }
//        return customers;
//    }
//
//    @Override
//    public Customer resultSetToEntity(ResultSet resultSet) throws SQLException {
//
//        return new Customer(
//                UUID.fromString(resultSet.getString(ID)),
//                resultSet.getString(FIRSTNAME),
//                resultSet.getString(LASTNAME),
//                resultSet.getString(DOCUMENT),
//                UUID.fromString(resultSet.getString(ADDRESSID)));
//
//    }
//
//    @Override
//    public void entityToPreparedStatement(PreparedStatement statement, Customer entity) throws SQLException {
//        statement.setString(1, entity.getFirstName());
//        statement.setString(2, entity.getLastName());
//        statement.setString(3, entity.getDocument());
//        statement.setObject(4, entity.getAddressId());
//
//    }
//}
