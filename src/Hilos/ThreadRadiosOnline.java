package Hilos;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BBDD.Conexion;

public class ThreadRadiosOnline extends Thread{
	 
	  Conexion con;
	  JTable JTable1;
	 
	boolean continuar=true;
	 DefaultTableModel dfm;
	  ResultSet rs=null;
	public ThreadRadiosOnline( JTable JTable1){
		
		this.JTable1=JTable1;
		
	}
	
	public void detener(){
		
		continuar=false;
		
		
	}
	
	public void run() {
	
		
			dfm = new DefaultTableModel();
			
			JTable1.setModel(dfm);
			
			
			dfm.setColumnIdentifiers(new Object[]{"IdRadios","Cantidad"});
		
		
			System.out.println("Consulta");
			
			
				Conexion con= new Conexion();
				rs=con.ConsultarRadiosOnline();
				try {
					while(rs.next()){
						dfm.addRow(new Object[]{rs.getString("IdRadios"),rs.getString("Cantidad")});
							
								
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	
	}
	

}
