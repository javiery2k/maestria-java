
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

public class AppConection {
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
		// System.out.println(path);
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

	public boolean insertar(String placa, String propietario, String tipovehiculo, String comentario) {
		try {
			String sql = "INSERT INTO DATA (PLACA, PROPIETARIO, TIPOVEHICULO, HORAENTRADA, COMENTARIO, ESTADO) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
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

			int i = pstmt.executeUpdate(); // insert, delete, update
			pstmt.close();
			conn.close();
			if (i > 0) {
				System.out.println("SQL OK");
				return true;
			} else {
				System.out.println("SQL FALLIDO");
				return false;
			}

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error, sus datos no fueron ingresados\n" + sqle);
		}
		return false;
	}

	// Retirar Vehiculo

	public double retirarVehiculo(String placa) {
		Double valorAPagar = 0.0;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		String fechaHora = dateFormat.format(date);
		try {
			// Preparamamos el primer Query
			
			String sql1 = "SELECT HORAENTRADA, TIPOVEHICULO FROM DATA WHERE PLACA=? AND ESTADO='Disponible'";
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, placa);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {				
				String horaSalida = rs.getString("HORAENTRADA");
				Date horasalida = dateFormat.parse(horaSalida);
				int minuntosACobrar = (int) (date.getTime() - horasalida.getTime()) / 60000;

				// calculamos el valor
				if (rs.getString("TIPOVEHICULO").equals("AUTOMOVIL")) {
					valorAPagar = minuntosACobrar * 0.03;
				} else if (rs.getString(2).equals("MOTOCICLETA")) {
					valorAPagar = minuntosACobrar * 0.02;
				}
				
				// Preparamamos el Update
				String sql = "UPDATE DATA SET HORASALIDA=?, ESTADO='No Disponible', ValorPagado=? WHERE PLACA=? AND ESTADO='Disponible'";
				PreparedStatement pstmt1 = conn.prepareStatement(sql);
				pstmt1.setString(1, fechaHora);
				pstmt1.setDouble(2, valorAPagar);
				pstmt1.setString(3, placa);
								
				// Ejecutamos el Query
				int i = pstmt1.executeUpdate(); // insert, delete, update
				if (i > 0) {
					System.out.println("SQL OK");			
				} else {
					System.out.println("SQL FALLIDO");
				}		
				pstmt.close();
				conn.close();
				return valorAPagar;
			} else {
				JOptionPane.showMessageDialog(null, "La placa no fue encontrada en el sistema.");
			}

		} catch (Exception e) {
			System.out.println("error en la modificacion: " + e.toString());
		}
		return valorAPagar;
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
		// c.insertar("AK0697", "Daniel2", "UV", "GARAGE", "TEST");
		c.retirarVehiculo("AG4617");
	}

}
