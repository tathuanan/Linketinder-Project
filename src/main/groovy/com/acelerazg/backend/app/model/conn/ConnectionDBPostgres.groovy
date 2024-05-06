package com.acelerazg.backend.app.model.conn

import java.sql.Connection
import java.sql.DriverManager

class ConnectionDBPostgres implements IConnectionDB {

    private String URL_SERVIDOR = "jdbc:postgresql://localhost:5432/linketinder"
    private String USER = "acelerazg"
    private String PASSWORD = "acelerazg@"
    private Connection connection

    private static ConnectionDBPostgres connectionDBPostgre = new ConnectionDBPostgres()

    private ConnectionDBPostgres(){
    }

    static ConnectionDBPostgres getInstance(){
        return connectionDBPostgre
    }

    @Override
    Connection connection() {

        try{
            Properties props = new Properties()
            props.setProperty("user", USER)
            props.setProperty("password", PASSWORD)
            props.setProperty("ssl", "false")
            Class.forName("org.postgresql.Driver")
            return this.connection = DriverManager.getConnection(URL_SERVIDOR, props)
        } catch (Exception e){
            e.printStackTrace()
            return null
        }
    }
}
