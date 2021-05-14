
/**
 * 
 */

/**
 * @author javier
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class AppConection<user> {
	Connection conn;
	String driver;
	String path;

	/**
	 * 
	 */
	public AppConection() {
		conn = null;
		driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		path = System.getProperty("user.dir") + "/bd/DATOS.accdb";
		this.conectar();
	}

	public boolean logearse(String user, String pass) {
		try {

			PreparedStatement pstmt = conn
					.prepareStatement("SELECT * FROM USUARIOS WHERE USERNAME = ? AND PASS = ? LIMIT 1");
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.print("id: " + rs.getInt("id") + ", ");
				System.out.print("Username: " + rs.getString("USERNAME") + ", ");
				System.out.print("Pass: " + rs.getString("PASS") + ", ");
				conn.close();
				pstmt.close();
				return true;
			} else {
				System.out.println("Obtained ResultSet object is empty");
				conn.close();
				pstmt.close();
				return false;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	// Insertar

	void insertar(String placa, String propietario, String tipovehiculo,  String comentario, String estado) {
		try {

			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO DATA (PLACA, PROPIETARIO, TIPOVEHICULO, HORAENTRADA, COMENTARIO, ESTADO) VALUES (?, ?, ?, ?, ?, ?)");
			DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			String FechaHora = dateFormat.format(date);
			String Estado = "Disponible";

			pstmt.setString(1, placa);
			pstmt.setString(2, propietario);
			pstmt.setString(3, tipovehiculo);
			pstmt.setString(4, FechaHora);
			pstmt.setString(5, comentario);
			pstmt.setString(6, Estado);

			pstmt.executeUpdate(); // insert, delete, update
			JOptionPane.showMessageDialog(null, "Registro Guardado");
			pstmt.close();
			conn.close();
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error, sus datos no fueron ingresados\n" + sqle);
		}

		// return false;
	}

	// Conectar

	public Connection conectar() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection("jdbc:ucanaccess://" + path);
			if (conn == null) {
				System.out.println("Connection cannot be established");
			}
			System.out.println("Se realizo la conexion de la base de datos");
			return conn;

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return conn;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AppConection c = new AppConection();
		c.conectar();
		c.insertar("AK0697", "Daniel", "UV", "GARAGE", "TEST");
	}

}
