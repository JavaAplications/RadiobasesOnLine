package Ventanas;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;




public class TablaRender extends DefaultTableCellRenderer{

	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	Component componente;
	int va,filas;
	//int row,colum;
	public TablaRender(int va,int filas){
		this.va=va;
		this.filas=filas;
		
		}
	
	public Component getTableCellRendererComponent(JTable arg0, Object arg1,
			boolean FlagBool, boolean arg3, int row, int colum) {
			componente= super.getTableCellRendererComponent(arg0, arg1, FlagBool, arg3, row, colum);
		
		
	
		
		System.out.println("row: "+row+ " col: "+colum);
		
if(row==filas){

			switch (va){
			
			case 1:
				componente.setBackground(Color.red);
				System.out.println("red");
				break;
			case 2:
				componente.setBackground(Color.yellow);
				System.out.println("orange");
				
				break;
			case 3:
				componente.setBackground(Color.orange);
				System.out.println("orange");
				
				break;
			default:
				componente.setBackground(Color.green);
				System.out.println("green");
				break;
			}	
}


		
		return componente;
	}
	
	

	
	}
