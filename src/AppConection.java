
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
		path =  getClass().getResource("bd/DATOS.accdb").getFile();
		this.conectar();
	}

	public boolean logearse(String user, String pass) {
		try {

			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM USUARIOS WHERE USERNAME = ? AND PASS = ? LIMIT 1");
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
		AppConection c = new AppConection();
		c.conectar();
	}

}
