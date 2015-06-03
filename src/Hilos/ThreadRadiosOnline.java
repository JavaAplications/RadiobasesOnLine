package Hilos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Ventanas.TablaRender;
import BBDD.Conexion;

public class ThreadRadiosOnline extends Thread{
	 
	  Conexion con;
	  JTable JTable1;
	  int cantidad;
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
			
			dfm.setColumnIdentifiers(new Object[]{"IdRadios","RadioBase","Cantidad"});
		
		
			System.out.println("Consulta");
			
			
				Conexion con= new Conexion();
				rs=con.ConsultarRadiosOnline();
		
				
				int c=1;
				try {
					while(rs.next()){
						System.out.println("c: "+c);
						
						dfm.addRow(new Object[]{rs.getString("IdRadios"),con.ConsultarNombre(Integer.parseInt(rs.getString("IdRadios"))),rs.getString("Cantidad")});
						cantidad=Integer.parseInt(rs.getString("Cantidad"));
						
						JTable1.setDefaultRenderer(Object.class, new TablaRender(cantidad,c));
						c++;
						
								
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	
	}
	

}
