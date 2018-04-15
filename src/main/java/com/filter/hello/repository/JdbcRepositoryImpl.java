package com.filter.hello.repository;

import com.filter.hello.entity.Contact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;


@Repository
public class JdbcRepositoryImpl implements JdbcRepository {

    private final int FETCH_SIZE = 1000;
    private final String GET_ALL = "SELECT * FROM hello_schema.contacts";

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public JdbcRepositoryImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Contact> getByJdbc(Pattern pattern) {
        List<Contact> contacts = new LinkedList<>();

        ResultSet resultSet = null;

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {

            connection.setAutoCommit(false);

            resultSet = statement.executeQuery(GET_ALL);
            resultSet.setFetchSize(FETCH_SIZE);

            contacts = resultExtractor(pattern, resultSet);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (resultSet != null && !resultSet.isClosed()) resultSet.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }


        return contacts;
    }


    public List<Contact> getByJdbcTemplate(Pattern pattern) {
        List<Contact> contacts = new LinkedList<>();

        jdbcTemplate.setFetchSize(FETCH_SIZE);

        jdbcTemplate.query(GET_ALL, resultSet -> {
            contacts.addAll(resultExtractor(pattern, resultSet));
        });

        return contacts;
    }


    private List<Contact> resultExtractor(Pattern pattern, ResultSet resultSet) throws SQLException {
        List<Contact> contacts = new ArrayList<>();

        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int id = resultSet.getInt("id");

            if (!pattern.matcher(name).find()) {
                contacts.add(new Contact(id, name));
            }
        }

        return contacts;
    }
}
