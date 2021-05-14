import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.text.*;
import java.util.*;

public class AppInsert<user> {
	Connection conn;
	String driver;
	String path;
	String FechaHora="";
	String Estado="";
	/**
	 * 
	 */
	public AppInsert() {
		conn = null;
		driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		path =  getClass().getResource("bd/DATOS.accdb").getFile();
		this.conectar();
	}

	public boolean insertar(String placa, String propietario, String tipovehiculo, String estado) {
		try {
			
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO DATA (PLACA, PROPIETARIO, TIPOVEHICULO, HORAENTRADA, ESTADO) VALUES (?, ?, ?, ?, ?)");
			DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
			Calendar cal= Calendar.getInstance();
			Date date = cal.getTime();
			FechaHora=dateFormat.format(date);
			Estado="Disponible";
			
			pstmt.setString(1, placa);
			pstmt.setString(2, propietario);
			pstmt.setString(3, tipovehiculo);
			pstmt.setString(4, FechaHora);
			pstmt.setString(7, Estado);
			
			pstmt.executeUpdate(); //insert, delete, update
			//System.out.println("Se grabo la transaccion");
			JOptionPane.showMessageDialog(null, "Registro Guardado");
			pstmt.close();
			conn.close();
			}
			 catch(SQLException sqle){
				 //System.out.println("Error sql " + sqle); 
				 JOptionPane.showMessageDialog(null, "Error, sus datos no fueron ingresados\n" + sqle);
				 }

		return false;
	}

	public Connection conectar() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection("jdbc:ucanaccess:/"+path);
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
		AppInsert c = new AppInsert();
		c.conectar();
	}

}