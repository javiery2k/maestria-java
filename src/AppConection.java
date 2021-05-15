
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
	String FechaHora = "";
	String Estado = "";

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

	void insertar(String placa, String propietario, String tipovehiculo, String estado) {
		try {

			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO DATA (PLACA, PROPIETARIO, TIPOVEHICULO, HORAENTRADA, ESTADO) VALUES (?, ?, ?, ?, ?)");
			DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			Date date = cal.getTime();
			FechaHora = dateFormat.format(date);
			Estado = "Disponible";

			pstmt.setString(1, placa);
			pstmt.setString(2, propietario);
			pstmt.setString(3, tipovehiculo);
			pstmt.setString(4, FechaHora);
			pstmt.setString(7, Estado);

			pstmt.executeUpdate(); // insert, delete, update
			JOptionPane.showMessageDialog(null, "Registro Guardado");
			pstmt.close();
			conn.close();
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error, sus datos no fueron ingresados\n" + sqle);
		}

<<<<<<< HEAD
	public boolean retirarVehiculo (String placa){
		Double valorAPagar=0.0;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal  = Calendar.getInstance();
        Date date = cal.getTime();
        String fechaHora = dateFormat.format(date); 
		try{
			 
			 String query;
			 query = ("SELECT HORAENTRADA, TIPOVEHICULO FROM DATA WHERE PLACA=? AND ESTADO='Disponible'");
			 PreparedStatement pstmt = conn.prepareStatement(query);
			 ResultSet rs = pstmt.executeQuery();
			 rs.first();
			 String horaSalida = rs.getString(1);
	         Date horasalida = dateFormat.parse(horaSalida);
	         int minuntosACobrar = (int) (date.getTime()-horasalida.getTime())/60000;
	            
	         //System.out.println(minuntosACobrar);
	            
	            if(rs.getString(2).equals("Automovil")){
	                valorAPagar=minuntosACobrar*1.0;
	            }else if(rs.getString(2).equals("Motocicleta")){
	                 valorAPagar=minuntosACobrar*0.50;
	            }
			 
	            //System.out.println("Valos a pagar por "+rs.getString(2)+"= "+valorAPagar);
	            //int respuesta = JOptionPane.showConfirmDialog(null,"Valor a pagar:  $"+valorAPagar+"'\nDesea Imprimir Recibo","Salida de vehiculo",JOptionPane.YES_NO_OPTION);
			 
			 PreparedStatement pstmt1 = conn.prepareStatement("UPDATE DATA SET HORASALIDA='"+fechaHora+"', ESTADO='No Disponible', ValorPagado='"+valorAPagar+"' WHERE PLACA=? AND ESTADO='Disponible'");
			 int i=pstmt1.executeUpdate();
		     
			 pstmt.close();
		     conn.close();
		 if (i > 0) {
				System.out.println("SQL OK");
				return true;
			} else {
				System.out.println("SQL FALLIDO");
				return false;
			}
		 }
		catch (Exception e){
		 System.out.println ("error en la modificacion: " +e.toString());
		 }
		return false;
		 }
=======
		// return false;
	}
>>>>>>> parent of 64fe5d3 (Merge branch 'develop' of https://github.com/javiery2k/maestria-java into develop)

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
	}

}
