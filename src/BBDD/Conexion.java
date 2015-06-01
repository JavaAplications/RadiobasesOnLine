package BBDD;

import java.sql.*;


public class Conexion {
	
public Conexion() {
		
	}



public  Connection Conectar(){
	
	Connection con=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con= DriverManager.getConnection("jdbc:mysql://localhost/bdradiobases","root","");	
		
	} catch (Exception e) {
		System.out.println("No se pudo conectar");
	}
	return con;
	
}
	


public void InsertarEventos(int IdRadio,int IdAlarma){
	
	Connection con=Conectar();
	
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("INSERT INTO eventos (IdRadios,IdAlarmas) VALUES (?,?)");
		
			pst.setInt(1,IdRadio);
			pst.setInt(2,IdAlarma);
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	

}




public void InsertarKeepAlive(int IdRadio){
	
	Connection con=Conectar();
	
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("INSERT INTO keepalive (IdRadios) VALUES (?)");
		
			pst.setInt(1,IdRadio);
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}

public void InsertarRadiobases(String NomRadio,String TelRadio,String LatRadio,String LongRadio,
		String LocRadio,String ProvRadio,String ContacRadio){
	
	Connection con=Conectar();
	
		PreparedStatement pst;
		try {
			pst = con.prepareStatement("INSERT INTO Radiobases (NomRadio,TelRadio,LatRadio,LongRadio,"
					+ "LocRadio, ProvRadio, ContacRadio) "
					+ "VALUES (?,?,?,?,?,?,?)");
		
			pst.setString(1,NomRadio);
			pst.setString(2,TelRadio);
			pst.setString(3,LatRadio);
			pst.setString(4,LongRadio);
			pst.setString(5,LocRadio);
			pst.setString(6,ProvRadio);
			pst.setString(7,ContacRadio);
			
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	

}

	
	

}
