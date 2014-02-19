import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.io.IOException;
import java.net.SocketException;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import WaxDevices.*;


public class ControlPanel extends JFrame {

	private JPanel contentPane;
	
	private AccReceiver recive;
	
	private JTextField portField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField fileField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	private AccSensor wax1;
	private AccSensor wax2;
	private AccSensor wax3;
	private AccSensor wax4;
	private AccSensor wax5;
	private AccSensor wax6;
	private JTextField comField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlPanel frame = new ControlPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public ControlPanel() throws IOException {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JButton btnRecord = new JButton("Record");
		
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wax1 = new AccSensor("/wax/1", textField.getText());
			    wax1.startRecord();
			    recive.addSensor(wax1);
			    try {
					wax1.startRecordFile(fileField.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    btnRecord.setEnabled(false);
			    textField.setEditable(false);
			    
			   
			}
		});
		
		btnRecord.setBounds(321, 51, 89, 23);
		contentPane.add(btnRecord);
		
		textField = new JTextField();
		textField.setBounds(129, 52, 143, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		final JButton btnRecord_1 = new JButton("Record");
		btnRecord_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wax2 = new AccSensor("/wax/2", textField_1.getText());
			    wax2.startRecord();
			    recive.addSensor(wax2);
			    try {
					wax2.startRecordFile(fileField.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    btnRecord_1.setEnabled(false);
			    textField_1.setEditable(false);
			}
		});
		btnRecord_1.setBounds(321, 85, 89, 23);
		contentPane.add(btnRecord_1);
		
		JLabel lblWax = new JLabel("WAX1");
		lblWax.setBounds(32, 60, 46, 14);
		contentPane.add(lblWax);
		
		JLabel lblWax_1 = new JLabel("WAX2");
		lblWax_1.setBounds(32, 90, 46, 14);
		contentPane.add(lblWax_1);
		
		JLabel lblWax_2 = new JLabel("WAX3");
		lblWax_2.setBounds(32, 120, 46, 14);
		contentPane.add(lblWax_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(129, 83, 143, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(129, 114, 143, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		final JButton btnRecord_2 = new JButton("Record");
		btnRecord_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wax3 = new AccSensor("/wax/3", textField_2.getText());
			    wax3.startRecord();
			    recive.addSensor(wax3);
			    try {
					wax3.startRecordFile(fileField.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			    btnRecord_2.setEnabled(false);
			    textField_2.setEditable(false);
			}
		});
		btnRecord_2.setBounds(321, 119, 89, 23);
		contentPane.add(btnRecord_2);
		
		JLabel lblSensor = new JLabel("Sensor");
		lblSensor.setBounds(32, 23, 46, 14);
		contentPane.add(lblSensor);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(129, 23, 89, 14);
		contentPane.add(lblDescription);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnRecord.setEnabled(true);
				textField.setEditable(true);
				try {
					wax1.stopRecordFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnStop.setBounds(420, 51, 89, 23);
		contentPane.add(btnStop);
		
		JButton btnStop_1 = new JButton("Stop");
		btnStop_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRecord_1.setEnabled(true);
				textField_1.setEditable(true);
				try {
					wax2.stopRecordFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnStop_1.setBounds(420, 85, 89, 23);
		contentPane.add(btnStop_1);
		
		JButton btnStop_2 = new JButton("Stop");
		btnStop_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRecord_2.setEnabled(true);
				textField_2.setEditable(true);
				try {
					wax3.stopRecordFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnStop_2.setBounds(420, 121, 89, 23);
		contentPane.add(btnStop_2);
		
		JLabel lblPath = new JLabel("Path:");
		lblPath.setBounds(32, 286, 46, 14);
		contentPane.add(lblPath);
		
		fileField = new JTextField();
		fileField.setBounds(129, 280, 380, 20);
		contentPane.add(fileField);
		fileField.setColumns(10);
		fileField.setText(".\\");
		
		JLabel lblReciverport = new JLabel("ReciverPort");
		lblReciverport.setBounds(32, 311, 66, 14);
		contentPane.add(lblReciverport);
		
		portField = new JTextField();
		portField.setText("9876");
		portField.setBounds(129, 311, 86, 20);
		contentPane.add(portField);
		portField.setColumns(10);
		
		JButton btnStartRecive = new JButton("Start Recive");
		btnStartRecive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					initReciver( Integer.parseInt(portField.getText()),Integer.parseInt(comField.getText()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnStartRecive.setBounds(392, 311, 105, 23);
		contentPane.add(btnStartRecive);
		
		JLabel lblWax_3 = new JLabel("WAX4");
		lblWax_3.setBounds(32, 151, 46, 14);
		contentPane.add(lblWax_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(129, 145, 143, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblWax_4 = new JLabel("WAX5");
		lblWax_4.setBounds(32, 179, 46, 14);
		contentPane.add(lblWax_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(129, 176, 143, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblWax_5 = new JLabel("WAX6");
		lblWax_5.setBounds(32, 214, 46, 14);
		contentPane.add(lblWax_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(129, 211, 143, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		final JButton btnRecord_3 = new JButton("Record");
		btnRecord_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wax4 = new AccSensor("/wax/4", textField_4.getText());
			    wax4.startRecord();
			    recive.addSensor(wax4);
			    try {
					wax4.startRecordFile(fileField.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			    btnRecord_3.setEnabled(false);
			    textField_4.setEditable(false);
			}
		});
		btnRecord_3.setBounds(321, 147, 89, 23);
		contentPane.add(btnRecord_3);
		
		final JButton btnRecord_4 = new JButton("Record");
		btnRecord_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wax5 = new AccSensor("/wax/5", textField_5.getText());
			    wax5.startRecord();
			    recive.addSensor(wax5);
			    try {
					wax5.startRecordFile(fileField.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			    btnRecord_4.setEnabled(false);
			    textField_5.setEditable(false);
			}
		});
		btnRecord_4.setBounds(321, 175, 89, 23);
		contentPane.add(btnRecord_4);
		
		final JButton btnRecord_5 = new JButton("Record");
		btnRecord_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wax6 = new AccSensor("/wax/6", textField_6.getText());
			    wax6.startRecord();
			    recive.addSensor(wax6);
			    try {
					wax6.startRecordFile(fileField.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			    btnRecord_5.setEnabled(false);
			    textField_6.setEditable(false);
			}
		});
		btnRecord_5.setBounds(321, 210, 89, 23);
		contentPane.add(btnRecord_5);
		
		JButton btnStop_3 = new JButton("Stop");
		btnStop_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRecord_3.setEnabled(true);
				textField_4.setEditable(true);
				try {
					wax4.stopRecordFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnStop_3.setBounds(420, 147, 89, 23);
		contentPane.add(btnStop_3);
		
		JButton btnStop_4 = new JButton("Stop");
		btnStop_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRecord_4.setEnabled(true);
				textField_5.setEditable(true);
				try {
					wax5.stopRecordFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnStop_4.setBounds(420, 175, 89, 23);
		contentPane.add(btnStop_4);
		
		JButton btnStop_5 = new JButton("Stop");
		btnStop_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRecord_5.setEnabled(true);
				textField_6.setEditable(true);
				try {
					wax6.stopRecordFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnStop_5.setBounds(420, 210, 89, 23);
		contentPane.add(btnStop_5);
		
		JLabel lblCom = new JLabel("COM");
		lblCom.setBounds(235, 314, 46, 14);
		contentPane.add(lblCom);
		
		comField = new JTextField();
		comField.setText("3");
		comField.setBounds(278, 311, 86, 20);
		contentPane.add(comField);
		comField.setColumns(10);
	}
	
	
	public void initReciver(int port, int com) throws IOException{
		 recive = new AccReceiver(port,com);
		 recive.startRecive();
	}
}
