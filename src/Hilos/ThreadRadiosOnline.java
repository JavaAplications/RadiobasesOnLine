package Hilos;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BBDD.Conexion;

public class ThreadRadiosOnline extends Thread{
	  boolean continuar = true;
	  //Conexion con;
	  JTable JTable1;
	  
	  ResultSet rs=null;
	public ThreadRadiosOnline( JTable JTable1){
		
		this.JTable1=JTable1;
		
		
	}
	
	public void desconectar(){
		
		 continuar = false;
		
	}
	
	
	public void run() {
		 DefaultTableModel dfm = new DefaultTableModel();
			JTable1.setModel(dfm);
			dfm.setColumnIdentifiers(new Object[]{"IdRadios","Cantidad"});
		while(continuar){
		
		try {
			Thread.sleep(5000);
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
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	}
	

}
