
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
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
			String sql = "SELECT * FROM USUARIOS WHERE USERNAME = ? AND PASS = ? LIMIT 1";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				conn.close();
				pstmt.close();
				return true;
			} else {
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
			String horaEntrada = dateFormat.format(Calendar.getInstance().getTime());
			String estado = "DISPONIBLE";

			pstmt.setString(1, placa);
			pstmt.setString(2, propietario);
			pstmt.setString(3, tipovehiculo);
			pstmt.setString(4, horaEntrada);
			pstmt.setString(5, comentario);
			pstmt.setString(6, estado);

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



	public void updateRetiro(String horaSalida, Double valor, String placa) {
		try {
			// Preparamamos el Update
			String sql = "UPDATE DATA SET HORASALIDA=?, ESTADO='NO DISPONIBLE', VALORPAGADO=? WHERE PLACA=? AND ESTADO='DISPONIBLE'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, horaSalida);
			pstmt.setDouble(2, valor);
			pstmt.setString(3, placa);

			// Ejecutamos el Query
			int i = pstmt.executeUpdate(); // insert, delete, update
			if (i > 0) {
				System.out.println("SQL OK");
			} else {
				System.out.println("SQL FALLIDO");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean retirarVehiculo(String placa) {
		Double valorPagar = 0.0;
		Date date = Calendar.getInstance().getTime();
		String horaSalida = dateFormat.format(date);

		try {
			// Preparamamos el primer Query

			String sql1 = "SELECT HORAENTRADA, TIPOVEHICULO FROM DATA WHERE PLACA=? AND ESTADO='DISPONIBLE'";
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, placa);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				Date horaEntrada = dateFormat.parse(rs.getString("HORAENTRADA"));
				int minuntosCobrar = (int) (date.getTime() - horaEntrada.getTime()) / 60000;

				// calculamos el valor
				if (rs.getString("TIPOVEHICULO").equals("AUTOMOVIL")) {
					valorPagar = minuntosCobrar * 0.03;
				} else if (rs.getString(2).equals("MOTOCICLETA")) {
					valorPagar = minuntosCobrar * 0.02;
				}

				updateRetiro(horaSalida, valorPagar, placa);
				JOptionPane.showMessageDialog(null, "El valor a pagar es de:" + valorPagar);
				return true;
			} else {
				System.out.println("Obtained ResultSet object is empty");
				conn.close();
				pstmt.close();
				return false;
			}

		} catch (Exception e) {
			System.out.println("error en la modificacion: " + e.toString());
		}
		return false;
	}

	// Devuelve todo el Resulset para poder actualizar el JTable
	public ResultSet getAll() {
		try {
			String query = "SELECT * FROM DATA WHERE 1=?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "1");
			ResultSet rs = pstmt.executeQuery();

			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// Devuelve solo lo que cumple con los Filtros al Resulset para poder actualizar el JTable
		public ResultSet getSearch(String Placa, String Propietario, String Fecha, String TipoVehiculo, String Estado) {
			try {
			
				String query = "SELECT *  FROM DATA WHERE PLACA LIKE ?";//  AND PROPIETARIO LIKE ? AND TIPOVEHICULO LIKE ? AND ESTADO=?  AND HORAENTRADA LIKE ? ";
				PreparedStatement pstmt = conn.prepareStatement(query);		
				
				pstmt.setString(1,"AK0697");
				//pstmt.setString(1, "%" + Placa + "%");
				/*pstmt.setString(2, "%" + Propietario + "%");
				pstmt.setString(3, "%" + Fecha + "%");
				pstmt.setString(4,  TipoVehiculo );
				pstmt.setString(5, "%" + Estado + "%");	*/	
				
				ResultSet rs = pstmt.executeQuery();

				return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	
	//Codigo de Gustavo que puede ser usado para las busquedas
	public String[] listar(String estado, String tipovehiculo, String placa, String propietario, String fecha) {

		try {
			// String query = "SELECT * FROM DATA WHERE ESTADO=? AND TIPOVEHICULO LIKE ? AND
			// PLACA LIKE ? AND PROPIETARIO LIKE ? AND HORAENTRADA LIKE ? ";
			String query = "SELECT * FROM DATA";

			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, estado);
			pstmt.setString(2, "%" + tipovehiculo + "%");
			pstmt.setString(3, "%" + placa + "%");
			pstmt.setString(4, "%" + propietario + "%");
			pstmt.setString(5, "%" + fecha + "%");

			ResultSet rs = pstmt.executeQuery(query);

			rs.first();

			do {
				String horasalida = rs.getString("HORASALIDA");
				String pago = rs.getString("VALORPAGADO");
				if (horasalida == null) {
					horasalida = "No ha salido";
					pago = "0";
				} else {
					horasalida = rs.getString("HORASALIDA").substring(10).substring(0, 6);
					pago = rs.getString("VALORPAGADO");
				}
				String[] fila = { rs.getString("Id"), rs.getString("PLACA"), rs.getString("PROPIETARIO"),
						rs.getString("TIPOVEHICULO"), rs.getString("HORAENTRADA").substring(10).substring(0, 6),
						horasalida, "$" + pago };

				return fila;
			} while (rs.next());

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
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
	 * @throws SQLException
	 */
	public static void main(String[] args) throws SQLException {
		//AppConection c = new AppConection();
		// c.insertar("AK0697", "Daniel2", "UV", "GARAGE", "TEST");
		//c.getAll();
	}

}
