import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;

public class ConexionBD {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Clinica";
    private static final String USUARIO = "user";
    private static final String CONTRASENA = "";

    public void agendarCita(int idMascota, String rutDueno, String nombreMascota, Time hora, Date fecha) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String sql = "INSERT INTO agenda (idMascota, rutDueño, nombreMascota, hora, fecha) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idMascota);
                statement.setString(2, rutDueno);
                statement.setString(3, nombreMascota);
                statement.setTime(4, hora);
                statement.setDate(5, fecha);

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
}

