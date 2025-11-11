/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;
import java.sql.*;

public class JavaDatabase {
    private static final String URL = "jdbc:postgresql://localhost:5432/JavaDatabase";
    private static final String USER = "postgres";
    private static final String PASSWORD = "agralucu";

    // Koneksi
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Koneksi ke PostgreSQL berhasil!");
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
        return conn;
    }
    }
//
//    // CREATE (Insert)
//    public static void insert(Mahasiswa m) {
//        String sql = "INSERT INTO mahasiswa (nim, nama, tahunmasuk) VALUES (?, ?, ?)";
//        try (Connection con = getConnection();
//             PreparedStatement ps = con.prepareStatement(sql)) {
//
//            ps.setString(1, m.nim);
//            ps.setString(2, m.nama);
//            ps.setInt(3, m.tahunmasuk);
//            ps.executeUpdate();
//            System.out.println("Data berhasil ditambahkan!");
//        } catch (SQLException ex) {
//            System.out.println("Error insert: " + ex.getMessage());
//        }
//    
//
//    // READ
//    public static List<mahasiswa> getAll() {
//        List<Mahasiswa> list = new ArrayList<>();
//        String sql = "SELECT * FROM mahasiswa ORDER BY id";
//        try (Connection conn = getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            while (rs.next()) {
//                mahasiswa m = new mahasiswa(
//                    rs.getString("nim"),
//                    rs.getString("nama"),
//                    rs.getInt("tahunmasuk")
//                );
//                list.add(m);
//            }
//        } catch (SQLException e) {
//            System.out.println("Error read: " + e.getMessage());
//        }
//        return list;
//    }
//
//    // UPDATE
//    public static void update(Mahasiswa m) {
//        String sql = "UPDATE mahasiswa SET nama = ?, tahunmasuk = ? WHERE nim = ?";
//        try (Connection conn = getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setString(1, m.nama);
//            stmt.setInt(2, m.tahunmasuk);
//            stmt.setString(3, m.nim);
//            stmt.executeUpdate();
//            System.out.println("Data berhasil diperbarui!");
//        } catch (SQLException e) {
//            System.out.println("Error update: " + e.getMessage());
//        }
//    }
//
//    // DELETE
//    public static void delete(String nim) {
//        String sql = "DELETE FROM mahasiswa WHERE nim = ?";
//        try (Connection conn = DBConnection ();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//
//            stmt.setString(1, nim);
//            stmt.executeUpdate();
//            System.out.println("Data berhasil dihapus!");
//        } catch (SQLException e) {
//            System.out.println("Error delete: " + e.getMessage());
//        }
//    }

