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

/**
 *
 * @author agrahizbullah
 */
public class KoneksiDB {

    private static final String URL = "jdbc:postgresql://localhost:5432/Mahasiswa";
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

    //DATA ACCESS OBJECT ////
    //Insert
    // Method insert(Mahasiswa m) yang baru
    public static void insert(Mahasiswa m) {
        // Pastikan query mencakup semua kolom baru: jenisMahasiswa dan sks
        String sql = "INSERT INTO mahasiswa (nim, nama, tahunmasuk, jenis_mahasiswa, sks) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, m.nim);
            ps.setString(2, m.nama);
            ps.setInt(3, m.tahunmasuk);

            // Tambahkan binding untuk kolom baru
            ps.setString(4, m.jenisMahasiswa); // Menggunakan field dari Mahasiswa
            ps.setInt(5, m.sks);               // Menggunakan field dari Mahasiswa

            ps.executeUpdate();
            System.out.println("Data berhasil dimasukkan!");
        } catch (SQLException e) {
            System.out.println("Gagal insert: " + e.getMessage());
            e.printStackTrace();
        }
    }
    //Select
    // Method getAll() yang baru

    public static List<Mahasiswa> getAll() {
        List<Mahasiswa> list = new ArrayList<>();
        // Perbarui query untuk mengambil semua kolom, termasuk ID (jika ID digunakan sebagai primary key)
        String sql = "SELECT id, nim, nama, tahunmasuk, jenis_mahasiswa, sks FROM mahasiswa ORDER BY id";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                // Gunakan constructor yang sesuai dengan 6 parameter di Mahasiswa.java (Termasuk ID)
                Mahasiswa m = new Mahasiswa(
                        rs.getInt("id"), // Ambil ID
                        rs.getString("nim"),
                        rs.getString("nama"),
                        rs.getInt("tahunmasuk"),
                        rs.getString("jenis_mahasiswa"), // Ambil data baru
                        rs.getInt("sks") // Ambil data baru
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
    // Method update(Mahasiswa m) yang baru

    public static void update(Mahasiswa m) {
        // Perbarui SQL untuk mencakup kolom baru
        String sql = "UPDATE mahasiswa SET nama = ?, tahunmasuk = ?, jenis_mahasiswa = ?, sks = ? WHERE nim = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, m.nama);
            stmt.setInt(2, m.tahunmasuk);

            // Tambahkan binding untuk kolom baru
            stmt.setString(3, m.jenisMahasiswa);
            stmt.setInt(4, m.sks);

            stmt.setString(5, m.nim); // WHERE nim
            stmt.executeUpdate();
            System.out.println("Data berhasil diperbarui.");
        } catch (SQLException e) {
            System.out.println("Error update: " + e.getMessage());
        }
    }

    //Delete
    public static void delete(String nim) {
        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nim);
            stmt.executeUpdate();
            System.out.println("Data berhasil dihapus.");
        } catch (SQLException e) {
            System.out.println("Error delete: " + e.getMessage());
        }
    }
}
