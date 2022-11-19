package Ikuspegia;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import Eredua.Konsulta_Erregistro;
import Kontrolatzailea.Bezero;
import Kontrolatzailea.ErabiltzaileaIgo;
import Kontrolatzailea.Metodoak;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */

public class ErregistroLeihoa extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JTextField textNAN;
	private JTextField textLetra;
	private JPasswordField Pasahitza;
	private JLabel lblTxatelaErregistroa = new JLabel("Erregistroa");
	private JLabel lblNan = new JLabel("NAN");
	private JLabel lblLetra = new JLabel("Letra");
	private JLabel lblPasahitza = new JLabel("Pasahitza");
	private JButton Ezeztatu = new JButton("Atzera");
	private JButton Jarraitu = new JButton("Jarraitu");
	private JButton Balidatu = new JButton("Balidatu");
	private JTextField izena = new JTextField();
	private JDateChooser jaiodata = new JDateChooser();
	private JTextField abizenatextfield = new JTextField();
	private JLabel lblIzena = new JLabel("Izena");
	private JLabel lblJaiotzeData = new JLabel("Jaiotze data ");
	private JLabel lblAbizena = new JLabel("Abizena");
	private JLabel lblErabiltzaileDatuak = new JLabel("Erabiltzaile Datuak  ----------------------------------------------------------------------------------------------------------------------------------");
	private JLabel lblDatuPertsonalak = new JLabel("Datu Pertsonalak  ----------------------------------------------------------------------------------------------------------------------------------");
	private SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
	private JLabel lblPostaElektronikoa = new JLabel("Posta Elektronikoa");
	private JTextField textFieldPostaElektronikoa;
	private JButton bueltaErregistrora = new JButton("Atzera");
	private final JTextArea textArea = new JTextArea();


	private String nan="";
	private String nan2="1";
	private String letra="";
	private String letra2="";
	private String zenbakia="";
	private String pasahitza="";
	private String izena2="";
	private String abizena="";
	private String jaio_data;
	private String altaData;
	private String fitxeroa = "src\\Eredua\\baseLegalak.txt";
	String PostaElektronikoa;
	// PostaElektronikoa balidatzeko
	Pattern pattern = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$");
	private final JCheckBox chckbxPasahitzaIkusi = new JCheckBox("Pasahitza Ikusi");


/**
 * 
 * @param bezero
 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ErregistroLeihoa(ArrayList<Bezero> bezero) {
		this.setBounds(275,100,700,600);
		getContentPane().setLayout(null);

		//LABEL TXARTEL ERREGISTROA
		lblTxatelaErregistroa.setFont(new Font("Arial", Font.BOLD, 37));
		lblTxatelaErregistroa.setBounds(181, 44, 351, 37);
		getContentPane().add(lblTxatelaErregistroa);

		//LABEL NAN
		lblNan.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNan.setBounds(108, 321, 47, 28);
		getContentPane().add(lblNan);

		//TEXT NAN
		textNAN = new JTextField();
		textNAN.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textNAN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				if(textNAN.getText().length()>=8) {
					evt.consume();	

				}
				char validar =evt.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					evt.consume();	

				}
			}
		});
		zenbakia=textNAN.getText();
		textNAN.setBounds(192, 323, 109, 28);
		getContentPane().add(textNAN);
		textNAN.setColumns(10);

		//TEXT LETRA
		textLetra = new JTextField();
		textLetra.setHorizontalAlignment(SwingConstants.CENTER);
		textLetra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textLetra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				if(textLetra.getText().length()>=1) {
					evt.consume();	
				}
				char validar =evt.getKeyChar();
				char c=evt.getKeyChar();
				if(Character.isDigit(validar) ) {
					getToolkit().beep();
					evt.consume();	

				}
				if(Character.isLowerCase(c)) {
					String cad=(""+c).toUpperCase();
					c=cad.charAt(0);
					evt.setKeyChar(c);
				}

			}
		});
		letra=textLetra.getText();
		textLetra.setColumns(10);
		textLetra.setBounds(440, 323, 32, 28);
		getContentPane().add(textLetra);

		//LETRA LABEL
		lblLetra.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblLetra.setBounds(359, 321, 52, 28);
		getContentPane().add(lblLetra);

		//LABEL PASAHITZA
		lblPasahitza.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblPasahitza.setBounds(63, 378, 92, 28);
		getContentPane().add(lblPasahitza);

		//PASAHITZA TEXTUA
		Pasahitza = new JPasswordField();
		Pasahitza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Pasahitza.setBounds(192, 380, 170, 28);
		getContentPane().add(Pasahitza);

		//Balidatu botoia
		Balidatu.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		Balidatu.setBounds(337, 452, 115, 44);
		getContentPane().add(Balidatu);

		//LABEL IZENA
		lblIzena.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblIzena.setBounds(92, 151, 63, 28);
		getContentPane().add(lblIzena);
		izena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				char validar =evt.getKeyChar();
				
				if(Character.isDigit(validar) ) {
					getToolkit().beep();
					evt.consume();	

				}

			}
		});

		//TEXT IZENA
		izena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		izena.setColumns(10);
		izena.setBounds(192, 153, 109, 28);
		getContentPane().add(izena);

		//LABEL ABIZENA
		lblAbizena.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblAbizena.setBounds(80, 214, 92, 28);
		getContentPane().add(lblAbizena);

		//LABEL TEXT
		abizenatextfield = new JTextField();
		abizenatextfield.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				char validar =evt.getKeyChar();
				if(Character.isDigit(validar) ) {
					getToolkit().beep();
					evt.consume();	

				}

			}
		});
		abizenatextfield.setFont(new Font("Tahoma", Font.PLAIN, 16));
		abizenatextfield.setColumns(10);
		abizenatextfield.setBounds(192, 216, 109, 28);
		getContentPane().add(abizenatextfield);

		//LABEL JAIOTZE DATA
		lblJaiotzeData.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblJaiotzeData.setBounds(327, 151, 133, 28);
		getContentPane().add(lblJaiotzeData);
		
		//LABEL POSTAElektronikoa
		lblPostaElektronikoa.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblPostaElektronikoa.setBounds(327, 216, 145, 28);
		getContentPane().add(lblPostaElektronikoa);
		
		//Textfield POSTA Elektronikoa 
		textFieldPostaElektronikoa = new JTextField();
		textFieldPostaElektronikoa.setBounds(492, 221, 122, 22);
		getContentPane().add(textFieldPostaElektronikoa);
		textFieldPostaElektronikoa.setColumns(10);

		//DATA JCALENDAR
		jaiodata.setBounds(470, 151, 122, 28);
		jaiodata.setVerifyInputWhenFocusTarget(false);
		jaiodata.setDateFormatString("yyyy-MM-dd");	
		getContentPane().add(jaiodata);
		jaiodata.getDate();
		jaiodata.cleanup();
		jaiodata.setMaxSelectableDate(new Date());
		((JTextField) this.jaiodata.getDateEditor()).setEditable(false); 
		
		//LABEL DATU PERSTSONALAK
		lblDatuPertsonalak.setBounds(22, 118, 632, 22);
		getContentPane().add(lblDatuPertsonalak);

		//LABEL ERABILTZAILE DATUAK
		lblErabiltzaileDatuak.setBounds(22, 288, 632, 22);
		getContentPane().add(lblErabiltzaileDatuak);


		//EZEZTATU BOTOIA
		Ezeztatu.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		Ezeztatu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Metodoak.loginleihora();


			}
		});
		Ezeztatu.setBounds(192, 452, 109, 44);
		getContentPane().add(Ezeztatu);
		//DNI ETA PASAHITZA BALIDATZEKO BOTOIA

		Balidatu.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				//BALIDAZIORAKO BARIABLEAK
				try {
					zenbakia=textNAN.getText();
					int zbk= Integer.parseInt(zenbakia);
					letra=textLetra.getText();
					nan=zenbakia+letra;
					
					
					letra2=Metodoak.KalkulatuLetra(zbk);
					nan2=zenbakia+letra2;
					System.out.println("Sartutako nan: "+nan);
					System.out.println("Izan behar den nan: "+nan2);
				}catch (Exception e) {

				}

				if (nan.equals(nan2) && !izena.getText().equals("") && !abizenatextfield.getText().equals("") && !Pasahitza.getText().equals("") && zenbakia.length()==8) {
					Jarraitu.setVisible(true);
					Jarraitu.setEnabled(true);
					textNAN.setVisible(false);
					textLetra.setVisible(false);
					Pasahitza.setVisible(false);
					lblTxatelaErregistroa.setVisible(false);
					lblNan.setVisible(false);
					lblLetra.setVisible(false);
					lblPasahitza.setVisible(false);
					izena.setVisible(false);
					jaiodata.setVisible(false);
					abizenatextfield.setVisible(false);
					lblIzena.setVisible(false);
					lblJaiotzeData.setVisible(false);
					lblAbizena.setVisible(false);
					lblErabiltzaileDatuak.setVisible(false);
					lblDatuPertsonalak.setVisible(false);
					lblPostaElektronikoa.setVisible(false);
					textFieldPostaElektronikoa.setVisible(false);
					Balidatu.setVisible(false);
					chckbxPasahitzaIkusi.setVisible(false);
					Ezeztatu.setVisible(false);
					bueltaErregistrora.setVisible(true);
					textArea.setVisible(true);
					
				}else if(izena.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Izena hutsik dago. Mesedez ostu");

				}
				else if(abizenatextfield.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Abizena hutsik dago. Mesedez osotu");
				}
				else if(Pasahitza.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Pasahitza hutsik dago. Mesedez osotu");
				}
				else if(zenbakia.length()<8) {
					JOptionPane.showMessageDialog(null, "Nan zenbakia txarto dago");
				}
				else {
					JOptionPane.showMessageDialog(null, "Nan letra txarto dago");
				}

				for (int i=0;i<bezero.size();i++) {
					if (bezero.get(i).getIdBezeroNan().equals(nan)) {
						
						Jarraitu.setEnabled(false);
						Balidatu.setEnabled(true);
						JOptionPane.showMessageDialog(null, "Nan hau erregistratuta dago");
					}
				}
				
				izena2=izena.getText();
				abizena=abizenatextfield.getText();

				PostaElektronikoa=textFieldPostaElektronikoa.getText();
				
				//Validar gmail
				Matcher matcher = pattern.matcher(PostaElektronikoa);
				   if (!(matcher.matches())) {
					   Jarraitu.setEnabled(false);
					   Balidatu.setEnabled(true);
					JOptionPane.showMessageDialog(null, "Posta Elektronikoa txarto dago. Mesedez osotu");
					   
				   }
				
				pasahitza=Pasahitza.getText();
				pasahitza=Metodoak.ateraMD5(pasahitza);
				try {
					Date jaio_data2= jaiodata.getDate();
					jaio_data= sm.format(jaio_data2);
				}catch (Exception e) {
					Jarraitu.setEnabled(false);
					Balidatu.setEnabled(true);
					JOptionPane.showMessageDialog(null, "Data hutsik dago. Mesedez osotu");
				}
			}
		});

		//Ezeztatu Botoia

		Ezeztatu.setBounds(165, 452, 109, 44);
		getContentPane().add(Ezeztatu);
		
		//JARRAITU BOTOIA
		
		//De momento lo ponemos en true para pasar de pantalla
		Jarraitu.setVisible(false);
		Jarraitu.setEnabled(true);
		//Jarraitu Botoiak egiten duena
		Jarraitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				altaData = Metodoak.dataAtera();
				//nan = Metodoak.ateraMD5(nan);
//				izena2 = Metodoak.ateraMD5(izena2);
//				abizena = Metodoak.ateraMD5(abizena);
//				PostaElektronikoa = Metodoak.ateraMD5(PostaElektronikoa);
				
				ErabiltzaileaIgo e1 = new ErabiltzaileaIgo(nan, izena2, abizena, pasahitza, jaio_data, PostaElektronikoa, altaData);
//				BezeroIgo BeIgo = new BezeroIgo(nan, izena2, abizena, jaio_data, sexua, pasahitza);
//				Metodoak.bezeroaIgo(cliente);
				Metodoak.Erregistratu(e1);
				Metodoak.loginleihora();
			}
		});
		//Jarraitu Botoiaren egitura
		Jarraitu.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		Jarraitu.setBounds(512, 452, 115, 44);
		getContentPane().add(Jarraitu);
		chckbxPasahitzaIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxPasahitzaIkusi.isSelected()) {
					Pasahitza.setEchoChar((char)0);
				}
				else {
					Pasahitza.setEchoChar('*');
				}
				
			}
		});
		chckbxPasahitzaIkusi.setBounds(204, 415, 158, 23);
		
		getContentPane().add(chckbxPasahitzaIkusi);
		

		
		bueltaErregistrora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jarraitu.setVisible(false);
				textNAN.setVisible(true);
				textLetra.setVisible(true);
				Pasahitza.setVisible(true);
				lblTxatelaErregistroa.setVisible(true);
				lblNan.setVisible(true);
				lblLetra.setVisible(true);
				lblPasahitza.setVisible(true);
				izena.setVisible(true);
				jaiodata.setVisible(true);
				abizenatextfield.setVisible(true);
				lblIzena.setVisible(true);
				lblJaiotzeData.setVisible(true);
				lblAbizena.setVisible(true);
				lblErabiltzaileDatuak.setVisible(true);
				lblDatuPertsonalak.setVisible(true);
				lblPostaElektronikoa.setVisible(true);
				textFieldPostaElektronikoa.setVisible(true);
				Balidatu.setVisible(true);
				chckbxPasahitzaIkusi.setVisible(true);
				Ezeztatu.setVisible(true);
				bueltaErregistrora.setVisible(false);
				textArea.setVisible(false);
			}
		});
		bueltaErregistrora.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		bueltaErregistrora.setBounds(46, 452, 109, 44);
		bueltaErregistrora.setVisible(false);
		getContentPane().add(bueltaErregistrora);
		
		textArea.setEditable(false);
		textArea.setVisible(false);
		textArea.setBounds(63, 81, 551, 345);
		textArea.setText("Honen bidez gure programaren base eta eredu legalak\r\n" + 
				"onartzen hari zara. Hauek dira gure eskaera edo legeak:\r\n" + 
				"	- ZERBAIT\r\n" + 
				"	- ZERBAIT\r\n" + 
				"	- ZERBAIT\r\n" + 
				"	- ZERBAIT\r\n" + 
				"	- ZERBAIT\r\n" + 
				"	- ZERBAIT\r\n" + 
				"	- ZERBAIT\r\n" + 
				"	- ZERBAIT");
		getContentPane().add(textArea);
		
	}
}