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
public class ErreserbaHasieratuApartamentua extends JFrame{
	
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
	//Date formatutik String-era aldatzeko
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private JTextArea txtAreaDatak = new JTextArea();
	private final JButton button = new JButton("Sartu");

	
	//Bariableak
	private String joan_Data_string="";
	private String sartu_Data_string="";
	private Boolean jarraituBotoia=false;
	private double PrezioEtxeaFinal=0;
	private boolean oierbike;
	private String jaiGustiak = null;
	private String promoKodea;
	private int promoPortzentaia = 0;
	private int zenbatJaiEgun = 0;
	private Jaiegunak j1 = new Jaiegunak(null, null);
	private final JLabel label = new JLabel("Jai-egunak");
	private JTextField textField;
	private double PrezioApartamentuaEgunekin=0.00;
	private double PrezioApartamentuaEgunekinMasJaiegunak =0.00;
	private double PrezioApartamentuFinal=0.00;
	
	//variables de que recogen de los spinners para que se puedan utilizar fuera del boton
	/**
	 * 
	 * @param apartamentuak
	 * @param PrezioApartamentua
	 */
	public ErreserbaHasieratuApartamentua(String apartamentuak, double PrezioApartamentua) {
		
		this.setBounds(275,100,700,600);
		this.setBackground(SystemColor.control);
		getContentPane().setLayout(null);
		
		aukeratutakoOstatua = new JLabel(apartamentuak);
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
		
		txtAreaDatak.setBounds(397, 122, 247, 100);
		txtAreaDatak.setEditable(false);
		getContentPane().add(txtAreaDatak);
		
		getContentPane().add(btnEzeztatu);
		btnAtzera.setBounds(176, 490, 105, 43);
		//String nan = Hotel.getDni();
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Metodoak.etxeakaukeratuleihora();
				
			}
		});
		
		btnAtzeraErreserba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Metodoak.apartamentuakAukeratuleihora();
				
			}
		});
		
		btnHurrengoa.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnHurrengoa.setBounds(484, 490, 157, 46);
		getContentPane().add(btnHurrengoa);
		btnHurrengoa.setEnabled(false);
		btnHurrengoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Solo Apartamentu : "+PrezioApartamentua);
				PrezioApartamentuaEgunekin = Metodoak.prezioaEgunekinEtxea(PrezioApartamentua, joan_Data, sartu_Data, promoPortzentaia);
				System.out.println("Prezio Egunekin : "+PrezioApartamentuaEgunekin);
				PrezioApartamentuaEgunekinMasJaiegunak = PrezioApartamentuaEgunekin +(zenbatJaiEgun * 20);//Cada dia festivo +20 euros
				System.out.println("PrezioEgunakin mas Jaiegunak : "+PrezioApartamentuaEgunekinMasJaiegunak+" Jaiegunak : "+zenbatJaiEgun);
				try {
					PrezioApartamentuFinal = Metodoak.PrezioaTemporadekinKalkulatu(sartu_Data,joan_Data, PrezioApartamentuaEgunekinMasJaiegunak);
					System.out.println("Prezio Final : "+PrezioApartamentuFinal);
				} catch (ParseException e1) {
					System.out.println(e1.getMessage());
				}
				dispose();
				oierbike = false;
				Metodoak.RedondearDosDecimales(PrezioApartamentuFinal);
				Metodoak.ordainduleihoraetxea(apartamentuak, PrezioApartamentuFinal, sartu_Data, joan_Data, oierbike);
			}
		});
		
		
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
		
		btnDatakEgiaztatu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDatakEgiaztatu.setBounds(125, 160, 132, 23);
		getContentPane().add(btnDatakEgiaztatu);
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(398, 83, 107, 28);
		
		getContentPane().add(label);
		//lblOheSipleBat.g
		
		btnDatakEgiaztatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Hoteletik joateko data balidatzeko
				try {
					joan_Data= dateJoan.getDate();
					joan_Data_string=dateFormat.format(joan_Data);
				}catch (Exception e1) {
					btnHurrengoa.setEnabled(false);
					jarraituBotoia=false;
					JOptionPane.showMessageDialog(null, "Sartzeko data hutsik dago. Mesedez, aukeratu bat");
				}
				//Hotelera sartzeko data balidatzeko
				try {
					sartu_Data= dateSartu.getDate();
					sartu_Data_string=dateFormat.format(sartu_Data);
				}catch (Exception e1) {
					btnHurrengoa.setEnabled(false);
					jarraituBotoia=false;
					JOptionPane.showMessageDialog(null, "Joateko data hutsik dago. Mesedez, aukeratu bat");
				}
				
				sartu_Data = (Date) dateSartu.getDate();
				joan_Data = (Date) dateJoan.getDate();
				
				if(sartu_Data != null && joan_Data != null) {
					btnHurrengoa.setEnabled(true);
					button.setEnabled(true);
				}
				
				j1 = Eredua.Konsulta_jaiegunak.JaiegunakAtera();
				zenbatJaiEgun = Metodoak.DataFestiboak(sartu_Data, joan_Data, j1);	
				jaiGustiak = Metodoak.printJaiegunak1(null, 999);
				System.out.println(jaiGustiak);
				txtAreaDatak.setText(jaiGustiak);
				
			}
		});
		
		j1 = Eredua.Konsulta_jaiegunak.JaiegunakAtera();
		button.setFont(new Font("Arial", Font.PLAIN, 18));
		button.setBounds(525, 439, 89, 22);
		button.setEnabled(false);
		getContentPane().add(button);
		
		textField = new JTextField();
		textField.setToolTipText("promo kodea");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(437, 441, 86, 20);
		getContentPane().add(textField);

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

