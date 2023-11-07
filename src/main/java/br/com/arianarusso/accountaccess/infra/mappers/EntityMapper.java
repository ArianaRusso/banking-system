package br.com.arianarusso.accountaccess.infra.mappers;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface EntityMapper<T> {
    List<String> getColumnNames();
    List<T> resultSetToEntityList(ResultSet resultSet) throws SQLException;
    T resultSetToEntity(ResultSet resultSet) throws SQLException;
    void entityToPreparedStatement(PreparedStatement statement, T entity) throws SQLException;
}
