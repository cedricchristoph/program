/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql_test;

import javax.sql.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Inf2
 */
public class prueba {

    protected static TableConstructor tc = new TableConstructor();
    
    public static void main(String[] args) {
        tc.setCustomSizes(10, 20, 20);
        tc.setCustomOrientations("left", "left", "left");
        tc.showSectionSeparator(false);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/jardineria?serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(url, "root", "");
            
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM clientes;";
            ResultSet rs = st.executeQuery(sql);
            tc.printHeader("Codigo", "Nombre", "Apellidos");
            
            while (rs.next()) {
                tc.printRow(rs.getInt("CodigoCliente") + "", rs.getString("NombreContacto"), rs.getString("ApellidoContacto"));
            }
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
    
    public static String getUserQuery(String msg) {
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

}
