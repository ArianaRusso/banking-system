//package br.com.arianarusso.accountaccess.infra.mappers;
//
//import br.com.arianarusso.accountaccess.entities.Account;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.UUID;
//
//public class AccountRowMapper implements EntityMapper<Account> {
//    public static final String ID = "id";
//    public static final String NUMBER = "number";
//    public static final String BALANCE = "balance";
//    public static final String CUSTOMERID = "customer_id";
//
//    @Override
//    public List<String> getColumnNames() {
//        return Arrays.asList
//                (BALANCE, CUSTOMERID);
//    }
//
//    @Override
//    public List<Account> resultSetToEntityList(ResultSet resultSet) throws SQLException {
//        List<Account> accounts = new ArrayList<>();
//
//        while (resultSet.next()) {
//            Account account = resultSetToEntity(resultSet);
//            accounts.add(account);
//        }
//        return accounts;
//    }
//
//    @Override
//    public Account resultSetToEntity(ResultSet resultSet) throws SQLException {
//
//        return new Account(
//                UUID.fromString(resultSet.getString(ID)),
//                resultSet.getInt(NUMBER),
//                resultSet.getBigDecimal(BALANCE),
//                UUID.fromString(resultSet.getString(CUSTOMERID)));
//
//
//    }
//
//    @Override
//    public void entityToPreparedStatement(PreparedStatement statement, Account entity) throws SQLException {
//        statement.setBigDecimal(1, entity.getBalance());
//        statement.setObject(2, entity.getCustomerId());
//    }
//}
