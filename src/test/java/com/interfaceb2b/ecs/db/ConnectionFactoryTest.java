package com.interfaceb2b.ecs.db;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import com.interfaceb2b.ecs.util.JDBCUtils;

public class ConnectionFactoryTest {

    @Test
    public void getConnectionSuccess() {

        Connection cnt = null;
        try {
            cnt = ConnectionFactory.getConnection();
            assertNotNull(cnt);
        } finally {
            JDBCUtils.safeClose(cnt);
        }

    }

}
