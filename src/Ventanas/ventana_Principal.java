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
import java.awt.SystemColor;

import javax.swing.JTable;

import Hilos.ThreadRadiosOnline;

import javax.swing.JLabel;




public class ventana_Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ThreadRadiosOnline HiloRadioOnLine;
	public JButton btn_On;
public 	JButton btn_Off;
	public JLabel lbl_Prueba;
	private JPanel panel_1;
	private JScrollPane scrollPane_1;
	private JTable table;
	public Thread timer;

	//Thread t ;

	/**
	 * Create the frame.
	 */
	public ventana_Principal() {
		setTitle("Radiobases Online");
		setResizable(false);
	
		Inicializacion();
		
		btn_Off.setEnabled(false);
		
		JLabel lbl_Prueba = new JLabel("New label");
		lbl_Prueba.setBounds(221, 28, 46, 14);
		panel_1.add(lbl_Prueba);
	
	
	}

	private void Inicializacion() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 400);
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
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(28, 79, 320, 225);
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
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
			

			HiloRadioOnLine=new ThreadRadiosOnline(table);
			HiloRadioOnLine.start();
			Thread.sleep(5000);
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}
	 
	 
	 
	 
	 
	 
 }



}

 
	   


