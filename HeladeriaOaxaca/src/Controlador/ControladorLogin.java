package Controlador;

import Modelo.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ControladorLogin {

    String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=Heladeria;TrustServerCertificate=True";
    String usuario = "";
    String contrasena = "";

    public Usuario getUsuario(String nombreUsuario, String contrasenaUsuario) {
        Usuario user = null;
        try (Connection cnn = DriverManager.getConnection(connectionString, usuario, contrasena);
             PreparedStatement ps = cnn.prepareStatement("SELECT * from Usuarios where usuario = ? and contraseña = ?")) {
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasenaUsuario);
            ResultSet rs = ps.executeQuery();

            rs.next();
            int id_usuario = rs.getInt(1);
            String nombreCompleto = rs.getString(2);
            String nUsuario = rs.getString(3);
            String cUsuario = rs.getString(4);
            int estado = rs.getInt(5);
            String privilegio = rs.getString(6);
            user = new Usuario(id_usuario, nombreCompleto, nUsuario, cUsuario, estado, privilegio);

        } catch (SQLException ex) {

            System.out.println(ex);
        }

        return user;
    }
}
