package com.multi.db.multi_db_sb.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MultiDbService {

    private final JdbcTemplate postgres;
    private final JdbcTemplate oracle;
    private final JdbcTemplate h2;

    public MultiDbService(
            @Qualifier("postgresJdbcTemplate") JdbcTemplate postgres,
            @Qualifier("oracleJdbcTemplate") JdbcTemplate oracle,
            @Qualifier("h2JdbcTemplate") JdbcTemplate h2) {

        this.postgres = postgres;
        this.oracle = oracle;
        this.h2 = h2;
    }

    public void createTables() {

        postgres.execute("""
            CREATE TABLE IF NOT EXISTS customers (
                id INTEGER PRIMARY KEY,
                name VARCHAR(100),
                email VARCHAR(150)
            )
        """);

        Integer count = oracle.queryForObject("""
            SELECT COUNT(*)
            FROM USER_TABLES
            WHERE TABLE_NAME = 'CUSTOMERS'
        """, Integer.class);

        if (count != null && count == 0) {
            oracle.execute("""
                CREATE TABLE customers (
                    id NUMBER PRIMARY KEY,
                    name VARCHAR2(100),
                    email VARCHAR2(150)
                )
            """);
        }

        h2.execute("""
            CREATE TABLE IF NOT EXISTS customers (
                id INTEGER PRIMARY KEY,
                name VARCHAR(100),
                email VARCHAR(150)
            )
        """);
    }

    public void insertData() {

        postgres.update("""
            INSERT INTO customers (id, name, email)
            VALUES (1, 'Rahul', 'rahul@gmail.com')
            ON CONFLICT (id) DO NOTHING
        """);

        oracle.update("""
            MERGE INTO customers c
            USING (
                SELECT 2 AS id,
                       'Priya' AS name,
                       'priya@gmail.com' AS email
                FROM dual
            ) src
            ON (c.id = src.id)
            WHEN NOT MATCHED THEN
                INSERT (id, name, email)
                VALUES (src.id, src.name, src.email)
        """);

        h2.update("""
            MERGE INTO customers (id, name, email)
            KEY(id)
            VALUES (3, 'Arjun', 'arjun@gmail.com')
        """);
    }

    public Map<String, List<Map<String, Object>>> fetchData() {

        Map<String, List<Map<String, Object>>> result =
                new LinkedHashMap<>();

        result.put("PostgreSQL",
                postgres.queryForList(
                        "SELECT * FROM customers"));

        result.put("Oracle",
                oracle.queryForList(
                        "SELECT * FROM customers"));

        result.put("H2",
                h2.queryForList(
                        "SELECT * FROM customers"));

        return result;
    }
}