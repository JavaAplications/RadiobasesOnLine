package BBDD;

public class ClaseWriteTablaKA {
	Conexion con;
	int Radiobase,Alarma;
	
	public ClaseWriteTablaKA(int Radiobase) {
		
		
		this.Radiobase=Radiobase;
		
	
	}



	public void escribir(){
		
	    con=new Conexion();
		  con.Conectar();
		  con.InsertarKeepAlive(Radiobase);
		
		
		
	}
}
