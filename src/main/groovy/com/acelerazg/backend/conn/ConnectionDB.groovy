package com.acelerazg.backend.conn

import java.sql.Connection
import java.sql.DriverManager

class ConnectionDB {

    private final String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/linketinder"
    private final String USER = "acelerazg"
    private final String PASSWORD = "acelerazg@"
    private Connection connection

    Connection connection() {

        try {

            Properties props = new Properties()
            props.setProperty("user", USER)
            props.setProperty("password", PASSWORD)
            props.setProperty("ssl", "false")

            return this.connection = DriverManager.getConnection(URL_SERVIDOR, props)

        } catch (Exception e) {
            e.printStackTrace()
            return null
        }
    }
}
