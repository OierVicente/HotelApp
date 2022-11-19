package Ikuspegia;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import com.toedter.calendar.JCalendar;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import Eredua.Kontsulta_Erreserba;
import Eredua.Kontsulta_Hoteles;
import Kontrolatzailea.Hotel;
import Kontrolatzailea.Jaiegunak;
import Kontrolatzailea.Metodoak;
import Kontrolatzailea.OheMotak;
import Kontrolatzailea.PromoKodea;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class ErreserbaHasieratu extends JFrame{
	
	private JButton btnHurrengoa = new JButton("Hurrengoa");
	private JLabel aukeratutakoOstatua;
	private JLabel lblSartzeData = new JLabel("Sartze data");
	private JLabel lblJoateData = new JLabel("Joate data");
	private JDateChooser dateJoan = new JDateChooser();
	private JDateChooser dateSartu = new JDateChooser();
	private Date joan_Data = new Date();
	private Date sartu_Data = new Date();
	private Date gaur = new Date();
	private Date urtea = new Date();
	private JButton btnAtzera = new JButton("Atzera");
	private JButton btnEzeztatu = new JButton("Ezeztatu");
	private JButton btnAtzeraErreserba = new JButton("Atzera");;
	private JButton btnEzeztatuErreserba = new JButton("Ezeztatu");
	private JButton btnDatakEgiaztatu = new JButton("Datak egiaztatu");
	private JButton btnBalidatu = new JButton("Balidatu");
	private JLabel lblLogelaMotak = new JLabel("Logela motak:");
	private JLabel lblOheSipleBat = new JLabel("Ohe sinple bat:");
	private JLabel lblOheSinpleBi = new JLabel("Ohe sinple 2:");
	private JLabel lblOheBikoitzBat = new JLabel("Ohe bikoitz bat:");
	private JLabel lblOheBikoitzBatEtaSinpleBat = new JLabel("Ohe bikoitz bat eta ohe Simple bat :");
	private JLabel lblSehaska = new JLabel("Sehaska :");
	private JLabel lblLogelaLibre = new JLabel("Logela libre:");
	private JTextArea txtAreaDatak = new JTextArea();
	private final JButton button = new JButton("Sartu");

//	private SpinnerNumberModel oheakSpinner = new SpinnerNumberModel(0, 0, 2, 1);
//	private SpinnerNumberModel sehaskaSpinner = new SpinnerNumberModel(0, 0, 4, 1);
	//Spinnerrak
	private JSpinner spinner_OheSimpleBat = new JSpinner();
	private JSpinner spinner_OheSimpleBi = new JSpinner();
	private JSpinner spinner_OheBikoitzBat = new JSpinner();
	private JSpinner spinner_OheBikoitzBatEtaOheSimpleBat = new JSpinner();
	private JSpinner spinner_Sehaska = new JSpinner();
	//Date formatutik String-era aldatzeko
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	
	//Bariableak
	private String joan_Data_string="";
	private String sartu_Data_string="";
	private Boolean jarraituBotoia=false;
	//LogelaTotala es la suma de todos los spinner que pone el usuario
	private int LogelaTotalaSpinner=0;
	//logelatotalaBD es la suma de la columna de logelaKopuru de la tabla erreserbak
	private int logelatotalaBDerreserban=0;
	//logelatotalPosibleHotel es el numero total posible que entran en un hotel y se saca de la tabla hotel
	private int logelatotalPosibleHotel=0;
	
	//variables de que recogen de los spinners para que se puedan utilizar fuera del boton
	private int OheSimpleBat=0;
	private int OheSimpleBi=0;
	private int OheBikoitzBat=0;
	private int OheBikoitzBatEtaOheSimpleBat=0;
	private int Sehaska=0;
	private double PrezioHotelFinal=0.00;
	private String promoKodea;
	private int promoPortzentaia = 0;
	private JTextField lblOheSipleBatKant;
	private JTextField lblOheSinpleBiKant;
	private JTextField lblOheBikoitzBatKant;
	private JTextField lblOheBikoitzBatEtaSinpleBatKant;
	private JTextField textField;
	
	private int zenbatJaiEgun = 0;
	/**
	 * 
	 * @param hotelak
	 * @param PrezioHotel
	 */
	public ErreserbaHasieratu(String hotelak, double PrezioHotel) {
		
		this.setBounds(275,100,700,600);
		this.setBackground(SystemColor.control);
		getContentPane().setLayout(null);
		
		aukeratutakoOstatua = new JLabel(hotelak);
		aukeratutakoOstatua.setFont(new Font("Tahoma", Font.PLAIN, 16));
		aukeratutakoOstatua.setBounds(10, 25, 664, 29);
		getContentPane().add(aukeratutakoOstatua);
		
		lblSartzeData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSartzeData.setBounds(40, 83, 107, 28);
		getContentPane().add(lblSartzeData);
		
		urtea = Metodoak.gehituUrtea(sartu_Data, 1); 
		
		dateJoan = new JDateChooser();
		dateJoan.setBounds(217, 122, 118, 20);
		dateJoan.setEnabled(false);
		getContentPane().add(dateJoan);
		((JTextField) this.dateJoan.getDateEditor()).setEditable(false); 

		
		dateJoan.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				sartu_Data = (Date) dateSartu.getDate();
				
				if(sartu_Data == null) {
					JOptionPane.showMessageDialog(null,"Lehenengo sartze data bat aukeratu, mesedez.");
					dateJoan.setEnabled(false);
				} else { 
					dateJoan.setMinSelectableDate(Metodoak.gehituEguna(sartu_Data, 1));
					dateJoan.setMaxSelectableDate(Metodoak.gehituEguna(urtea, 1));
				}
				
			}
		});
		
		lblJoateData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJoateData.setBounds(232, 83, 107, 28);
		getContentPane().add(lblJoateData);
		
		dateSartu = new JDateChooser();
		dateSartu.setBounds(29, 122, 118, 20);
		getContentPane().add(dateSartu);
		((JTextField) this.dateSartu.getDateEditor()).setEditable(false); 

		//hola
		
		dateSartu.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				dateSartu.setMinSelectableDate(gaur);
				dateSartu.setMaxSelectableDate(urtea);
				dateJoan.setEnabled(true);
				dateJoan.setCalendar(null);
				
			}
		});
		
		getContentPane().add(btnEzeztatu);
		btnAtzera.setBounds(176, 490, 105, 43);
		//String nan = Hotel.getDni();
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Metodoak.hotelakaukeratuleihora();
				
			}
		});
		
		btnAtzeraErreserba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Metodoak.hotelakaukeratuleihora();
				
			}
		});
		
		btnHurrengoa.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnHurrengoa.setBounds(484, 490, 157, 46);
		getContentPane().add(btnHurrengoa);
		btnHurrengoa.setEnabled(false);
		
		
		btnAtzeraErreserba.setFont(new Font("Arial", Font.PLAIN, 18));
		btnAtzeraErreserba.setBounds(65, 496, 105, 43);
		getContentPane().add(btnAtzeraErreserba);
		
		btnEzeztatuErreserba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Metodoak.ongietorrileihora();
			}
		});
		
	
		
		btnEzeztatuErreserba.setFont(new Font("Arial", Font.PLAIN, 18));
		btnEzeztatuErreserba.setBounds(275, 494, 112, 41);
		getContentPane().add(btnEzeztatuErreserba);
		
		lblLogelaMotak.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogelaMotak.setBounds(40, 219, 157, 29);
		getContentPane().add(lblLogelaMotak);
		
		lblOheSipleBat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOheSipleBat.setBounds(65, 259, 132, 28);
		getContentPane().add(lblOheSipleBat);
		
		lblOheSinpleBi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOheSinpleBi.setBounds(65, 298, 118, 29);
		getContentPane().add(lblOheSinpleBi);
		
		lblOheBikoitzBat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOheBikoitzBat.setBounds(65, 338, 123, 25);
		getContentPane().add(lblOheBikoitzBat);
		
		lblOheBikoitzBatEtaSinpleBat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOheBikoitzBatEtaSinpleBat.setBounds(65, 374, 264, 34);
		getContentPane().add(lblOheBikoitzBatEtaSinpleBat);
		
		lblSehaska.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSehaska.setBounds(65, 435, 80, 20);
		getContentPane().add(lblSehaska);
				
		btnDatakEgiaztatu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDatakEgiaztatu.setBounds(125, 160, 132, 23);
		getContentPane().add(btnDatakEgiaztatu);
		
		
		btnBalidatu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnBalidatu.setBounds(498, 259, 132, 43);
		getContentPane().add(btnBalidatu);
		btnBalidatu.setEnabled(false);
		
		lblOheSipleBatKant = new JTextField();
		lblOheSipleBatKant.setBounds(268, 265, 86, 20);
		getContentPane().add(lblOheSipleBatKant);
		lblOheSipleBatKant.setColumns(10);
		lblOheSipleBatKant.setEditable(false);
		
		
		lblOheSinpleBiKant = new JTextField();
		lblOheSinpleBiKant.setColumns(10);
		lblOheSinpleBiKant.setBounds(267, 304, 86, 20);
		getContentPane().add(lblOheSinpleBiKant);
		lblOheSinpleBiKant.setEditable(false);
		
		lblOheBikoitzBatKant = new JTextField();
		lblOheBikoitzBatKant.setColumns(10);
		lblOheBikoitzBatKant.setBounds(267, 342, 86, 20);
		getContentPane().add(lblOheBikoitzBatKant);
		lblOheBikoitzBatKant.setEditable(false);
		
		lblOheBikoitzBatEtaSinpleBatKant = new JTextField();
		lblOheBikoitzBatEtaSinpleBatKant.setColumns(10);
		lblOheBikoitzBatEtaSinpleBatKant.setBounds(397, 383, 86, 20);
		getContentPane().add(lblOheBikoitzBatEtaSinpleBatKant);
		lblOheBikoitzBatEtaSinpleBatKant.setEditable(false);

		
		int[] gelaLibre =new int[4];
		


			txtAreaDatak.setBounds(397, 122, 247, 100);
			txtAreaDatak.setEditable(false);
			getContentPane().add(txtAreaDatak);
		
		
		
		btnDatakEgiaztatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBalidatu.setEnabled(true);
				//Hoteletik joateko data balidatzeko
				try {
					joan_Data= dateJoan.getDate();
					joan_Data_string=dateFormat.format(joan_Data);
				}catch (Exception e1) {
					btnBalidatu.setEnabled(true);
					btnHurrengoa.setEnabled(false);
					jarraituBotoia=false;
					JOptionPane.showMessageDialog(null, "Sartzeko data hutsik dago. Mesedez osotu");
				}
				//Hotelera sartzeko data balidatzeko
				try {
					sartu_Data= dateSartu.getDate();
					sartu_Data_string=dateFormat.format(sartu_Data);
				}catch (Exception e1) {
					btnBalidatu.setEnabled(true);
					btnHurrengoa.setEnabled(false);
					jarraituBotoia=false;
					JOptionPane.showMessageDialog(null, "Sartzeko data hutsik dago. Mesedez osotu");
				}

				if(sartu_Data!=null && joan_Data!=null) {
					button.setEnabled(true);
				}
				
				//Diegate1
				int[] gelaLibre =new int[4];
				
				int i = 0;
				boolean libre;
				
				
				Jaiegunak j1 = new Jaiegunak(null, null);
				
				String[] oheMotak =new String[4];
				oheMotak[0]= "1sinp";
				oheMotak[1]= "2sinp";
				oheMotak[2]= "1bik";
				oheMotak[3]= "1sinp1bik";
				
				int[] oheMotakZbk =new int[4];
				oheMotakZbk[0]= OheSimpleBat;
				oheMotakZbk[1]= OheSimpleBi;
				oheMotakZbk[2]= OheBikoitzBat;
				oheMotakZbk[3]= OheBikoitzBatEtaOheSimpleBat;
				
				String jaiGustiak = null;
							
				OheMotak o1 = Kontsulta_Hoteles.logelaKopurua();
					j1 = Eredua.Konsulta_jaiegunak.JaiegunakAtera();
				do {
				ArrayList<java.sql.Date> dataJoan = new ArrayList<java.sql.Date>();
				ArrayList<java.sql.Date> dataEtorri = new ArrayList<java.sql.Date>();
				ArrayList<java.sql.Date>[] dataArray = new ArrayList[2]; 
				
				zenbatJaiEgun = Metodoak.DataFestiboak(sartu_Data, joan_Data, j1);

				dataArray = Kontsulta_Hoteles.dataJoan(oheMotak[i]);
				
				dataJoan = dataArray[0];
				dataEtorri = dataArray[1];
				
				
				libre = Metodoak.DataKalkulatu(sartu_Data, joan_Data, dataJoan, dataEtorri, oheMotakZbk[i],oheMotak[i],i, o1);
				
				gelaLibre[i]= Metodoak.getlogelaKant(999);
				
				System.out.println(gelaLibre[0]);
				spinner_OheSimpleBat.setModel(new SpinnerNumberModel(0, 0, gelaLibre[0], 1));
				spinner_OheSimpleBi.setModel(new SpinnerNumberModel(0, 0, gelaLibre[1], 1));
				spinner_OheBikoitzBat.setModel(new SpinnerNumberModel(0, 0, gelaLibre[2], 1));
				spinner_OheBikoitzBatEtaOheSimpleBat.setModel(new SpinnerNumberModel(0, 0, gelaLibre[3], 1));
				
				String[] strgelaLibre =new String[4];
				if(gelaLibre[0] < 0) {
					strgelaLibre[0] = "0";
				}else {
					strgelaLibre[0] = String.valueOf(gelaLibre[0]);
				}if(gelaLibre[1] < 0) {
					strgelaLibre[1] = "0";
				}else {
					strgelaLibre[1] = String.valueOf(gelaLibre[1]);
				}if(gelaLibre[2] < 0) {
					strgelaLibre[2] = "0";
				}else {
					strgelaLibre[2] = String.valueOf(gelaLibre[2]);
				}if(gelaLibre[3] < 0) {
					strgelaLibre[3] = "0";
				}else {
					strgelaLibre[3] = String.valueOf(gelaLibre[3]);
				}
				
				
				
				if(i==0) {
					lblOheSipleBatKant.setText(strgelaLibre[i]);
				}else if(i==1) {
					lblOheSinpleBiKant.setText(strgelaLibre[i]);
				}else if(i==2) {
					lblOheBikoitzBatKant.setText(strgelaLibre[i]);
				}else if(i==3) {
					lblOheBikoitzBatEtaSinpleBatKant.setText(strgelaLibre[i]);
				}
				
			
				
				//hemen impimitu behar da .........................................................
				jaiGustiak = Metodoak.printJaiegunak1(null, 999);
				System.out.println(jaiGustiak);
				txtAreaDatak.setText(jaiGustiak);
				
				
				
				++i;
				}while(i!=4);
			
				
				
			}
		});
	
		
		spinner_OheSimpleBat = new JSpinner();
		spinner_OheSimpleBat.setModel(new SpinnerNumberModel(0, 0, gelaLibre[0], 1));
		spinner_OheSimpleBat.setBounds(217, 265, 40, 20);
		getContentPane().add(spinner_OheSimpleBat);
		
		spinner_OheSimpleBi = new JSpinner();
		spinner_OheSimpleBi.setModel(new SpinnerNumberModel(0, 0, gelaLibre[1], 1));
		spinner_OheSimpleBi.setBounds(217, 304, 40, 20);
		getContentPane().add(spinner_OheSimpleBi);
		
		spinner_OheBikoitzBat = new JSpinner();
		spinner_OheBikoitzBat.setModel(new SpinnerNumberModel(0, 0, gelaLibre[2], 1));
		spinner_OheBikoitzBat.setBounds(217, 342, 40, 20);
		getContentPane().add(spinner_OheBikoitzBat);
		
		spinner_OheBikoitzBatEtaOheSimpleBat = new JSpinner();
		spinner_OheBikoitzBatEtaOheSimpleBat.setModel(new SpinnerNumberModel(0, 0, gelaLibre[3], 1));
		spinner_OheBikoitzBatEtaOheSimpleBat.setBounds(339, 383, 48, 20);
		getContentPane().add(spinner_OheBikoitzBatEtaOheSimpleBat);
		
		spinner_Sehaska = new JSpinner();
		spinner_Sehaska.setModel(new SpinnerNumberModel(0, 0, 4, 1));
		spinner_Sehaska.setBounds(154, 437, 43, 20);
		getContentPane().add(spinner_Sehaska);
		lblLogelaLibre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogelaLibre.setBounds(268, 223, 99, 20);
		
		getContentPane().add(lblLogelaLibre);
		
		JLabel lblJaiEgunak = new JLabel("Jai-egunak");
		lblJaiEgunak.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJaiEgunak.setBounds(397, 83, 107, 28);
		getContentPane().add(lblJaiEgunak);
		
		btnBalidatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OheSimpleBat = (int) spinner_OheSimpleBat.getValue();
				OheSimpleBi = (int) spinner_OheSimpleBi.getValue();
				OheBikoitzBat = (int) spinner_OheBikoitzBat.getValue();
				OheBikoitzBatEtaOheSimpleBat = (int) spinner_OheBikoitzBatEtaOheSimpleBat.getValue();
				Sehaska = (int) spinner_Sehaska.getValue();
				LogelaTotalaSpinner=OheSimpleBat+OheSimpleBi+OheBikoitzBat+OheBikoitzBatEtaOheSimpleBat;
				
				jarraituBotoia=true;
				//Hoteletik joateko data balidatzeko
				try {
					joan_Data= dateJoan.getDate();
					joan_Data_string=dateFormat.format(joan_Data);
				}catch (Exception e1) {
					btnBalidatu.setEnabled(true);
					btnHurrengoa.setEnabled(false);
					jarraituBotoia=false;
					JOptionPane.showMessageDialog(null, "Sartzeko data hutsik dago. Mesedez osotu");
				}
				//Hotelera sartzeko data balidatzeko
				try {
					sartu_Data= dateSartu.getDate();
					sartu_Data_string=dateFormat.format(sartu_Data);
				}catch (Exception e1) {
					btnBalidatu.setEnabled(true);
					btnHurrengoa.setEnabled(false);
					jarraituBotoia=false;
					JOptionPane.showMessageDialog(null, "Sartzeko data hutsik dago. Mesedez osotu");
				}
				if ( (int) spinner_OheSimpleBat.getValue()==0 && (int) spinner_OheSimpleBi.getValue()==0 && (int) spinner_OheBikoitzBat.getValue()==0 && (int) spinner_OheBikoitzBatEtaOheSimpleBat.getValue()==0) {
					btnBalidatu.setEnabled(true);
					btnHurrengoa.setEnabled(false);
					jarraituBotoia=false;
					JOptionPane.showMessageDialog(null, "Logelaren bat aukeratu behar duzu. Sehaskarik ez nahi baduzu ez da derrigorrezkoa");
				}
				
				//Data haietan lekurik ez badago
				
				
				//Diegate1
				int i = 0;
				boolean libre;
				String[] oheMotak =new String[4];
				oheMotak[0]= "1sinp";
				oheMotak[1]= "2sinp";
				oheMotak[2]= "1bik";
				oheMotak[3]= "1sinp1bik";

				
				int[] oheMotakZbk =new int[4];
				oheMotakZbk[0]= OheSimpleBat;
				oheMotakZbk[1]= OheSimpleBi;
				oheMotakZbk[2]= OheBikoitzBat;
				oheMotakZbk[3]= OheBikoitzBatEtaOheSimpleBat;
				
				OheMotak o1 = Kontsulta_Hoteles.logelaKopurua();
				
				do {
					ArrayList<java.sql.Date> dataJoan = new ArrayList<java.sql.Date>();
					ArrayList<java.sql.Date> dataEtorri = new ArrayList<java.sql.Date>();
					ArrayList<java.sql.Date>[] dataArray = new ArrayList[i]; 

					dataArray = Kontsulta_Hoteles.dataJoan(oheMotak[i]);
					
					dataJoan = dataArray[0];
					dataEtorri = dataArray[1];
				
				
				libre = Metodoak.DataKalkulatu(sartu_Data, joan_Data, dataJoan, dataEtorri, oheMotakZbk[i],oheMotak[i], i, o1);
				if (libre== false) {
					break;
				}
				++i;
				}while(i!=4);
				
				if(libre==false) {

					btnBalidatu.setEnabled(true);
					btnHurrengoa.setEnabled(false);
					jarraituBotoia=false;
					JOptionPane.showMessageDialog(null, "Hotelan ez dago lekurik");
					
				}
				
		
				
				if (jarraituBotoia==true) {
					btnBalidatu.setEnabled(false);
					btnHurrengoa.setEnabled(true);
					
					//JDateChooserrak desaktibatu
					dateJoan.getCalendarButton().setEnabled(false);
					dateSartu.getCalendarButton().setEnabled(false);
					
					//Spinnerrak desaktibatu
					spinner_OheSimpleBat.setEnabled(false);
					spinner_OheSimpleBi.setEnabled(false);
					spinner_OheBikoitzBat.setEnabled(false);
					spinner_OheBikoitzBatEtaOheSimpleBat.setEnabled(false);
					spinner_Sehaska.setEnabled(false);
					
				}
				
				
				
				
			}
		});
		
		btnHurrengoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				OheMotak o1 = new OheMotak(OheSimpleBat, OheSimpleBi, OheBikoitzBat, OheBikoitzBatEtaOheSimpleBat, Sehaska);

				

				
				joan_Data = (Date) dateJoan.getDate();
				sartu_Data = (Date) dateSartu.getDate();
				
				if(dateSartu != null && dateJoan != null) {
					PrezioHotelFinal = Metodoak.prezioaEgunekin(PrezioHotel, joan_Data, sartu_Data, o1, OstauMotaAukeratu.idOstatu, zenbatJaiEgun, promoPortzentaia);
					try {
						PrezioHotelFinal = Metodoak.PrezioaTemporadekinKalkulatu(sartu_Data,joan_Data, PrezioHotelFinal);
					} catch (ParseException e1) {
						System.out.println(e1.getMessage());
					}
					Metodoak.RedondearDosDecimales(PrezioHotelFinal);
					Metodoak.ordainduleihora(hotelak, PrezioHotelFinal, sartu_Data, joan_Data, o1,LogelaTotalaSpinner);
					dispose();
				}
				
			}
		});
		
		
		textField = new JTextField();
		textField.setToolTipText("promo kodea");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(437, 441, 86, 20);
		getContentPane().add(textField);
		
		button.setFont(new Font("Arial", Font.PLAIN, 18));
		button.setBounds(524, 436, 89, 22);
		button.setEnabled(false);
		getContentPane().add(button);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				promoKodea = textField.getText();
				System.out.print(textField.getText());
				
				boolean promoTrue = false;
				ArrayList<PromoKodea> bdPromoKodeaArray = Metodoak.promoKodeaBalidatu(promoKodea);
				
				for ( int i = 0; i < bdPromoKodeaArray.size(); i ++ ) {
					if(promoKodea.equals(bdPromoKodeaArray.get(i).getPromozioKodeaIzen())) {
						promoPortzentaia = bdPromoKodeaArray.get(i).getPromozioaZbk();
						promoTrue = true;
					}
				}
				
				if(promoTrue == true) {
					JOptionPane.showMessageDialog(null, "Kodia Sartuta!!!");
					button.setEnabled(false);
				}else {
					JOptionPane.showMessageDialog(null, "Ez da kode balidoa...");
				}
				
				
			}
		});
	}
}