/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
public class DBConnection {
     private static final String URL = "jdbc:postgresql://localhost:5432/JavaDatabase";
    private static final String USER = "postgres";
    private static final String PASSWORD = "agralucu";

    // --- Koneksi ke database ---
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi berhasil!");
        } catch (SQLException e) {
            System.out.println("Gagal koneksi ke database!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver PostgreSQL tidak ditemukan!");
            e.printStackTrace();
        }
        return conn;
    }

    //Insert
    public static void insert(Mahasiswa m) {
        try (Connection conn = getConnection()) {
            String sqls = "INSERT INTO \"mahasiswa\" (nim, nama, \"tahunmasuk\") VALUES('" 
                + m.nim + "','" + m.nama + "'," + m.tahunmasuk + ")";
            System.out.println(sqls);
            Statement s = conn.createStatement();
            s.executeUpdate(sqls);
            System.out.println("Data berhasil dimasukkan!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Select
    public static List<Mahasiswa> getAll() {
        List<Mahasiswa> list = new ArrayList<>();
        String sql = "SELECT * FROM \"mahasiswa\"";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Mahasiswa m = new Mahasiswa(
                    rs.getString("nim"),
                    rs.getString("nama"),
                    rs.getInt("tahunmasuk")
                );
                list.add(m);
            }
        } catch (SQLException e) {
            System.out.println("Error read: " + e.getMessage());
        }
        return list;
    }
    //main fungsi
    //Update
    public static void update(Mahasiswa m) {
        String sql = "UPDATE mahasiswa SET nama = ?, tahunmasuk = ? WHERE nim = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.nama);
            stmt.setInt(2, m.tahunmasuk);
            stmt.setString(3, m.nim);
            stmt.executeUpdate();
            System.out.println("Data berhasil diperbarui.");
        } catch (SQLException e) {
            System.out.println("Error update: " + e.getMessage());
        }
    }
    //Delete
    public static void delete(String nim) {
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nim);
            stmt.executeUpdate();
            System.out.println("Data berhasil dihapus.");
        } catch (SQLException e) {
            System.out.println("Error delete: " + e.getMessage());
        }
    }
}
