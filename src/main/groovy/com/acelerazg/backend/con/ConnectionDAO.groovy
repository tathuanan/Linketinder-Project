package com.acelerazg.backend.con

import java.sql.Connection
import java.sql.DriverManager

class ConnectionDAO {

    Connection connection

    Connection connection() {

        try {

            Properties props = new Properties()
            props.setProperty("user", "acelerazg")
            props.setProperty("password", "acelerazg@")
            props.setProperty("ssl", "false")
            String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/linketinder"

        } catch (Exception e) {
            e.printStackTrace()

        }
        return this.connection = DriverManager.getConnection(URL_SERVIDOR, props)
    }

}
