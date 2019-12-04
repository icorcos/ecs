package com.interfaceb2b.ecs.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import com.interfaceb2b.ecs.db.ConnectionFactory;
import com.interfaceb2b.ecs.db.DAO;
import com.interfaceb2b.ecs.util.JDBCUtils;

public class UserDAO implements DAO<User> {

    public UserDAO() {
    }

    @Override
    public Optional<User> find(String username) {
        Connection conn = ConnectionFactory.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            stmt = conn.createStatement();
            String query = "SELECT username, pwdkey, salt, first_name, organization FROM user WHERE username = '"
                    + username + "'";
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPasswordKey(rs.getString("pwdkey"));
                user.setSalt(rs.getString("salt"));
                user.setFirstName(rs.getString("first_name"));
                user.setOrganization(rs.getString("organization"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.safeClose(conn, stmt, rs);
        }

        return Optional.ofNullable(user);
    }

    /*
     * @Override public List<User> getAll() { return users; }
     * 
     * @Override public void save(User user) { users.add(user); }
     * 
     * @Override public void update(User user, String[] params) {
     * user.setName(Objects.requireNonNull(params[0], "Name cannot be null"));
     * user.setEmail(Objects.requireNonNull(params[1], "Email cannot be null"));
     * 
     * users.add(user); }
     * 
     * @Override public void delete(User user) { users.remove(user); }
     */
}
