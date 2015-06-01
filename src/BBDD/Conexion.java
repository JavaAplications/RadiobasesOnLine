package BBDD;

import java.sql.*;


public class Conexion {
	Connection con=null;
public Conexion() {
		
	}



public  Connection Conectar(){
	

	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost/bdradiobases","root","");	
		
	} catch (Exception e) {
		System.out.println("No se pudo conectar");
	}
	return con;
	
}
	


public ResultSet ConsultarRadiosOnline()
{
	con=Conectar();
	Statement st;
	ResultSet rs=null;
	try {
		st=con.createStatement();
		rs=st.executeQuery("SELECT `IdRadios`,COUNT(*) as 'Cantidad' FROM keepalive WHERE `TimeKA` > DATE_ADD(now(),INTERVAL -60 SECOND) GROUP BY `IdRadios`");
					
			
	
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	return rs;
}




}
