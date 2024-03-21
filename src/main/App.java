/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author APRIE
 */
public class App {
    public static void main(String[] args) {
        KalkulatorForm kf = new KalkulatorForm();
        kf.setLocationRelativeTo(null);
        kf.setVisible(true);
        
    }
        public static Double Hitung(Double angka1, Double angka2, String operator) {
        Double hasil = null;
        
        if (operator.equals("+")) {
            hasil = Penjumlahan(angka1, angka2);
        } else if (operator.equals("-")) {
            hasil = angka1 - angka2;
        } else if (operator.equals("*")) {
            hasil = angka1 * angka2;
        } else if (operator.equals(":")) {
            hasil = angka1 / angka2;
        }
        
        return hasil;
    }
    
    public static Double Penjumlahan(double angka1, double angka2){
        Double hasil = angka1 + angka2;
        return hasil;
    }
    
    public static Double Pengurangan(double angka1, double angka2){
        Double hasil = angka1 - angka2;
        return hasil;
    }
    
    public static Double Perkalian(double angka1, double angka2){
        Double hasil = angka1 * angka2;
        return hasil;
    }
    
    public static Double Pembagian(double angka1, double angka2){
        Double hasil = angka1 / angka2;
        return hasil;
    }
    
    public static void insertHitung(Double angka1, Double angka2, String operator, Double hasil){
        Connection connect;
        PreparedStatement pst;
        
        String url = "jdbc:mysql://localhost:3360/kalkulator";
        String username = "root";
        String password = "";
        String query = "INSERT INTO hitung (angka1, angka2, operator, hasil)" + "values(?,?,?,?)";
        
        try {
        connect = DriverManager.getConnection(url, username, password);
        pst = connect.prepareStatement(query);
        pst.setDouble(1, angka1);
        pst.setDouble(2, angka2);
        pst.setString(3, operator);
        pst.setDouble(4, hasil);
        pst.executeUpdate();
        pst.close();
    } catch (SQLException ex){
        System.out.println("Insert gaga: " + ex);
    }
    }
}
