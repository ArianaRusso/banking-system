package br.com.arianarusso.infra.repositories;

import br.com.arianarusso.infra.PostgreSQLConnection;
import br.com.arianarusso.infra.mappers.EntityMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GenericRepositoryImpl<T> implements GenericRepository<T>{

    private PostgreSQLConnection connection;
    private EntityMapper<T> entityMapper;
    private String table;
    private String insertSQL;

    public GenericRepositoryImpl(PostgreSQLConnection connection, EntityMapper<T> entityMapper, String table) {
        this.connection = connection;
        this.entityMapper = entityMapper;
        this.table = table;
    }

    protected void setStatementValues (PreparedStatement statement, Object object) throws SQLException{}
    protected void setInsertSQL(String sql){
        this.insertSQL = sql;
    }

    //falta terminar e desacoplar
    @Override
    public void save(T t) {
        String sql= String.format
                ("INSERT INTO %s (id, postal_code, street, number, complement, city, state, contry)" +
                        "VALUES (?, ?, ?, ?, ?, ?, ?,?", this.table);
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

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return entityMapper.resultSetToEntity(resultSet);
                }
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
        return null;
    }

//    @Override
//    public T update(String sql, T t, UUID id) {
//        try (Connection conn = connection.getConnection();
//             PreparedStatement statement = conn.prepareStatement(sql)) {
//            // Configure os parâmetros do PreparedStatement com base no objeto T
//            statement.setString(1, novoValorColuna1);
//            statement.setString(2, novoValorColuna2);
//            statement.setObject(3, id);
//
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return findById(sql,id); // Retorna o objeto atualizado (ou null se não encontrado)
//    }
}
