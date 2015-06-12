package Hilos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import Ventanas.TablaRender;
import Ventanas.ventana_Principal;
import BBDD.Conexion;

public class ThreadRadiosOnline extends Thread{
	 
	  Conexion con;
	  JPanel Jpanelito;
	  int cantidad;
	boolean continuar=true;
	JButton botonRadiobase;
	  ResultSet rs=null;
	public ThreadRadiosOnline(  JPanel Jpanelito){
		
		this.Jpanelito=Jpanelito;
		
		
	}
	
	public void detener(){
		
		continuar=false;
		
		
	}
	
	public void run() {
	
		
			System.out.println("Consulta");
			
			
				
					
					
			//		Jpanelito = new JPanel();
				//	scrollPane_Radiobases.setViewportView(panel_Radiobases);
				//	Jpanelito.setLayout(new GridLayout(30, 10,5, 5));
			
				int c=1;
				try {
					con= new Conexion();
					rs=con.ConsultarRadiosOnline();
			
					int NumRadiobases= con.CantidadRadiobases();
					System.out.println("NumRadiobases:"+NumRadiobases);
					
					
					while(rs.next()){
						System.out.println("c: "+c);
						
						String IdRadio=rs.getString("IdRadios");
						String Nombre=con.ConsultarNombre(Integer.parseInt(IdRadio));
						System.out.println("IdRadio:"+IdRadio);
						System.out.println("Nombre:"+Nombre);
						
						Jpanelito.add(botonRadiobase=new JButton(Nombre));
						cantidad=Integer.parseInt(rs.getString("Cantidad"));
						
						if (cantidad>2){
							Jpanelito.setBackground(Color.GREEN);}else{Jpanelito.setBackground(Color.RED);}
						c++;
					}
					
						
						
								
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	
	}
	

}
