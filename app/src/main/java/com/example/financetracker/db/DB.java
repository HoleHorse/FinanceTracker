package com.example.financetracker.db;

import com.example.financetracker.R;
import com.example.financetracker.data.Datasource;
import com.example.financetracker.model.Action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class DB {

    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://satao.db.elephant.com:5432/jyfvcpii", "jyfvcpii", "VxiQGEUXc5z0PHPaXub6v5EQn_49a1hI");
            if (con != null) {
                return con;
            }
            assert false;
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addNew(Action action) throws SQLException {
        Connection con = DB.getConnection();
        if (con == null) {
            return;
        }
        String query = "INSERT INTO actions(category, amount, status, date) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(query);
        try {
            pst.setString(1, action.getCategory());
            pst.setInt(2, action.getAmount());
            if (action.getImg() == R.drawable.arrow_up_circle_svgrepo_com) {
                pst.setString(3, "up");
            } else {
                pst.setString(3, "down");
            }
            pst.setString(4, action.getDate().toString());
            pst.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getData() {
        Connection con = DB.getConnection();
        if (con == null) {
            return;
        }
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM devices;");
            ArrayList<Action> actions = new ArrayList<>();
            while (rs.next()) {
                String category = rs.getString("category");
                int amount = rs.getInt("amount");
                String status = rs.getString("status");
                String date = rs.getString("date");
                int img = 0;
                if (Objects.equals(status, "up")) {
                    img = R.drawable.arrow_up_circle_svgrepo_com;
                } else {
                    img = R.drawable.arrow_down_circle_svgrepo_com;
                }
                actions.add(new Action(category, amount, img, LocalDate.parse(date)));
                Datasource.Companion.setActions(actions);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
