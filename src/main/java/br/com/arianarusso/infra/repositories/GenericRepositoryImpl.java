
package br.com.arianarusso.infra.repositories;

import br.com.arianarusso.infra.SQLConnection;
import br.com.arianarusso.infra.mappers.EntityMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class GenericRepositoryImpl<T> implements GenericRepository<T>{

    private SQLConnection connection;
    private EntityMapper<T> entityMapper;
    private String table;
    private String insertSQL;
    private String updateSQL;

    public GenericRepositoryImpl(SQLConnection connection, EntityMapper<T> entityMapper, String table) {
        this.connection = connection;
        this.entityMapper = entityMapper;
        this.table = table;
        setUpdateSQL();
        setInsertSQL();
    }

    private void setInsertSQL(){
        List<String> columns = entityMapper.getColumnNames();
        StringBuilder sqlBuilder = new StringBuilder("INSERT INTO ");
        sqlBuilder.append(table).append(" (");

        for (String column : columns) {
            sqlBuilder.append(column).append(", ");
        }

        sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length());

        sqlBuilder.append(") VALUES (");

        for (int i = 0; i < columns.size(); i++) {
            sqlBuilder.append("?, ");
        }

        sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length());

        sqlBuilder.append(")");
        insertSQL = sqlBuilder.toString();
    }

    private void setUpdateSQL(){
        List<String> columns = entityMapper.getColumnNames();
        StringBuilder sqlBuilder = new StringBuilder("UPDATE ");
        sqlBuilder.append(table).append(" SET ");

        for (String column : columns) {
            sqlBuilder.append(column).append(" = ?, ");
        }
        sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length());
        sqlBuilder.append(" WHERE id = ?");
        updateSQL = sqlBuilder.toString();

    }

    @Override
    public void save(T t) {
        System.out.println("Insert do save"+insertSQL);
        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(this.insertSQL)) {
            entityMapper.entityToPreparedStatement(statement, t);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T findById(UUID id) {
        String sql = String.format("SELECT * FROM %s WHERE id = ?", this.table);

        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setObject(1, id);
            ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return entityMapper.resultSetToEntity(resultSet);
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> listAll() {
        String sql = String.format("SELECT * FROM %s", this.table);
        List<T> resultList = new ArrayList<>();

        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            resultList = entityMapper.resultSetToEntityList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public void deleteById(UUID id) {
        String sql = String.format("DELETE FROM %s WHERE id =?", this.table);
        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setObject(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public T update(T t, UUID id) {
        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(this.updateSQL)) {
            entityMapper.entityToPreparedStatement(statement, t);
            statement.setObject(entityMapper.getColumnNames().size() + 1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return findById(id);
    }

    @Override
    public T findByNumber(int number) {
        String sql = String.format("SELECT * FROM %s WHERE number = ?", this.table);

        try (Connection conn = connection.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setObject(1, number);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return entityMapper.resultSetToEntity(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
