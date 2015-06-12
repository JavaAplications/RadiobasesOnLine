package Ventanas;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;








import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

import BBDD.Conexion;
import Hilos.ThreadRadiosOnline;

import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;




public class ventana_Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ThreadRadiosOnline HiloRadioOnLine;
	public JButton btn_On;
public 	JButton btn_Off;
 public JButton botonRadiobase;
	public JLabel lbl_Prueba;
	private JPanel panel_1;
	public Thread timer;
	private JScrollPane scrollPane_Radiobases;
	public JPanel panel_Radiobases;
	Conexion con;
	ResultSet rs=null;
	//Thread t ;

	/**
	 * Create the frame.
	 */
	public ventana_Principal() {
		setTitle("Radiobases Online");
	
		Inicializacion();
	
		
   
	}

	private void Inicializacion() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel_1 = new JPanel();
		//panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBackground(SystemColor.activeCaption);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(null);
		
		btn_On = new JButton("ON");
		btn_On.setBounds(28, 11, 117, 23);
		panel_1.add(btn_On);
		
		btn_Off = new JButton("OFF");
		btn_Off.setBounds(28, 45, 117, 23);
		panel_1.add(btn_Off);
	//	 DefaultCaret caret = (DefaultCaret)textAreaConsolaDeKeeps.getCaret();
	//	 caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

	
		
		
		
		
		
		
		btn_Off.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btn_On.setEnabled(true);
				btn_Off.setEnabled(false);
			
				
			}
		});
		btn_On.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				btn_Off.setEnabled(true);
				btn_On.setEnabled(false);
				
				timer=new Timersito();
				timer.start();
				
			}
		});
		contentPane.setLayout(gl_contentPane);
		
		
		
		btn_Off.setEnabled(false);
		
		scrollPane_Radiobases = new JScrollPane();
		scrollPane_Radiobases.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_Radiobases.setBounds(10, 101, 536, 549);
		panel_1.add(scrollPane_Radiobases);
		
		panel_Radiobases = new JPanel();
		scrollPane_Radiobases.setViewportView(panel_Radiobases);
		panel_Radiobases.setLayout(new GridLayout(30, 10,5, 5));
		Online pepe=new Online();
		pepe.start();
		
	}

	public class Online extends Thread{
		
		public void run(){
			
			try {
				con= new Conexion();
				rs=con.ConsultarRadiosOnline();
		
				int NumRadiobases= con.CantidadRadiobases();
				System.out.println("NumRadiobases:"+NumRadiobases);
				
				
				while(rs.next()){
					
					String IdRadio=rs.getString("IdRadios");
					String Nombre=con.ConsultarNombre(Integer.parseInt(IdRadio));
					System.out.println("IdRadio:"+IdRadio);
					System.out.println("Nombre:"+Nombre);
					
					panel_Radiobases.add(botonRadiobase=new JButton(Nombre));
					int cantidad=Integer.parseInt(rs.getString("Cantidad"));
					
					if (cantidad>2){
						botonRadiobase.setBackground(Color.GREEN);}else{botonRadiobase.setBackground(Color.RED);}
					
				}
				
					
					
							
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
	
	public  class Timersito extends Thread{

		
		boolean flag=true;
		
		public Timersito(){
			
			
		}
		
	public void detener(){
			
			flag=false;
			
		}
		
		
	public void run() {
		
		while(flag){
		try {
			

			HiloRadioOnLine=new ThreadRadiosOnline(panel_Radiobases);
			HiloRadioOnLine.start();
			Thread.sleep(5000);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}
	 
	 
	 
	 
	 
	 
 }



}

 
	   


