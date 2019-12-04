package com.interfaceb2b.ecs.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static final String URL = "jdbc:sqlite:/Users/frederic/Src/ecs-src/ecs.sqlite3";

	public static Connection getConnection() {

		try {

			Class.forName("org.sqlite.JDBC");
			return DriverManager.getConnection(URL);

		} catch (Exception ex) {
			throw new RuntimeException("Error connecting to the database", ex);
		}

	}

}