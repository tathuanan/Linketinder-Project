package com.acelerazg.backend.conn

class ConnectionDBFactory {

    static IConnectionDB getConnection(String database) {
        switch (database) {
            case "postgres":
                return ConnectionDBPostgres.getInstance()
                break
            default:
                throw new Exception().printStackTrace()
        }

    }
}
