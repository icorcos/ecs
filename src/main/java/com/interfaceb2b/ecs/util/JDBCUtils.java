package com.interfaceb2b.ecs.util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class JDBCUtils {

    public static void safeClose(final Connection cnt, final Statement stmt, final ResultSet rs) {
        safeClose(cnt);
        safeClose(stmt);
        safeClose(rs);
    }

    public static void safeClose(final AutoCloseable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                // not much to do with that exception
            }
        }
    }

}