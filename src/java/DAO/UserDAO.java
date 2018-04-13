/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Util.DBConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private static UserDAO instance;

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    private UserDAO() {
    }

    public boolean userExists(String name) throws SQLException {

        Connection con = new DBConnection().getConnection();
        Statement instr = con.createStatement();
        String sql = "SELECT * FROM users.usernames";
        ResultSet rs = instr.executeQuery(sql);

        if (rs == null) {
            return false;
        }
        while (rs.next()) {
            if (name.equals(rs.getString(1))) {
                return true;
            }
        }
        return false;
    }

    public void insertUser(String uname, String pass, String email, String gender, String telephone, String country) throws SQLException {

        Connection con = new DBConnection().getConnection();
        Statement instr = con.createStatement();

        String sql = "INSERT INTO usernames (username, password,email,gender,telephone,country) VALUES ('" + uname + "',PASSWORD('" + pass + "'),'" + email + "','" + gender + "','" + telephone + "', '" + country + "');";
        instr.executeUpdate(sql);
    }

    public boolean login(String name, String pass) throws SQLException {

        Connection con = new DBConnection().getConnection();
        Statement instr = con.createStatement();
        String sql = "SELECT username, password FROM users.usernames WHERE password=PASSWORD('" + pass + "')";
        ResultSet rs = instr.executeQuery(sql);

        if (rs == null) {
            return false;
        }
        while (rs.next()) {
            if (name.equals(rs.getString(1))) {
                return true;
            }
        }
        return false;
    }

}
