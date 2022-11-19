package Ikuspegia;

import java.awt.Font; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Eredua.Kontsulta_Erreserba;
import Kontrolatzailea.Kontagailua;
import Kontrolatzailea.Erreserba;
import Kontrolatzailea.Hotel;
import Kontrolatzailea.Metodoak;
import Kontrolatzailea.OheMotak;

import javax.swing.JScrollBar;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class OrdainduLeihoa extends JFrame {


	private static final long serialVersionUID = 1L;
	private JLabel lblOrdainketa = new JLabel("Ordainketa :");
	private JLabel lblSartuDirua = new JLabel("Sartu Dirua :");
	private JLabel lblItzuliak = new JLabel("Itzuliak :");
	private JButton btnAmaitu = new JButton("Amaitu");
	private JTextField dirua= new JTextField();
	private JButton btnEzeztatu = new JButton("Ezeztatu");
	private JButton btnAtzera = new JButton("Atzera");
	private JButton btnOrdaindu = new JButton("Ordaindu");
	private JTextArea Itzuliak = new JTextArea();
	private JLabel lblOrdaintzeko = new JLabel("");
	private JLabel lblOrdainketa_Tituloa = new JLabel("ORDAINKETA");
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private DecimalFormat dosDecimales = new DecimalFormat("#.00");

	
	private double preziototala=0;
	private ArrayList<Double> preziotot = new ArrayList<Double>();
	//private double prezioa;
	private double prezio2 = 0;
	private int idErreserba;

	/**
	 * 
	 * @param hotelak
	 * @param prezioHotelFinal
	 * @param sartuData
	 * @param joanData
	 * @param o1
	 * @param logelaKopurua
	 */
	public OrdainduLeihoa(String hotelak, double prezioHotelFinal, Date sartuData, Date joanData,OheMotak o1,int logelaKopurua) {
		//prezioa=prezioHotel;
		//prezioa=0.0;
		this.setResizable(false);
		this.setBounds(275,100,700,600);
		getContentPane().setLayout(null);
		lblOrdainketa.setBounds(90, 106, 162, 34);

		//LABEL ORDAINKETA
		lblOrdainketa.setFont(new Font("Arial", Font.BOLD, 25));
		getContentPane().add(lblOrdainketa);
		lblSartuDirua.setBounds(90, 151, 162, 37);

		//LABEL SARTU DIRUA
		lblSartuDirua.setFont(new Font("Arial", Font.BOLD, 24));
		getContentPane().add(lblSartuDirua);
		lblItzuliak.setBounds(135, 199, 105, 34);


		//LABEL ITZULIAK
		lblItzuliak.setFont(new Font("Arial", Font.BOLD, 24));
		getContentPane().add(lblItzuliak);
		btnAmaitu.setEnabled(false);
		btnAmaitu.setBounds(514, 490, 97, 43);

		//BOTOIA AMAITU
		btnAmaitu.setFont(new Font("Arial", Font.PLAIN, 18));
		btnAmaitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				int idOstatu=OstauMotaAukeratu.idOstatu;
				String idBezero=LoginLeihoa.nan;
				//String idBezero="12345678Z";
				String Eskatutakodata=Metodoak.dataAtera();
				String EskatutakoOrdua=Metodoak.orduaAtera();
				String dataJoan=dateFormat.format(sartuData);
				String dataEtorri=dateFormat.format(joanData);
				int sinp= o1.getOheSimpleBat();
				int bisinp= o1.getOheSimpleBi();
				int bik= o1.getOheBikoitzBat();
				int sinpbik= o1.getOheBikoitzBatEtaOheSimpleBat();
				int sehaska= o1.getSehaska();
				
				double precio= prezioHotelFinal;
				Erreserba IgotzekoErreserba = new Erreserba(idOstatu, idBezero, dataJoan, dataEtorri, precio, sinp, bisinp, bik, sinpbik, sehaska, Eskatutakodata, EskatutakoOrdua,logelaKopurua);
				Metodoak.ErreserbaIgo(IgotzekoErreserba);
				
				idErreserba=Kontsulta_Erreserba.idErreserbaAtera(OstauMotaAukeratu.idOstatu);
				Erreserba ImprimatzekoErreserba = new Erreserba(idErreserba,idOstatu, idBezero, dataJoan, dataEtorri, precio, sinp, bisinp, bik, sinpbik, sehaska, Eskatutakodata, EskatutakoOrdua);

				Metodoak.imprimatuTiketa(ImprimatzekoErreserba);
				Kontagailua contador = new Kontagailua();
				contador.start();
			}
		});
		getContentPane().add(btnAmaitu);

		//TEXTUA SARTZEKO DIRUA
		dirua = new JTextField();
		dirua.setBounds(262, 161, 136, 26);
		dirua.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				if(dirua.getText().length()>=10) {
					evt.consume();	

				}
				char validar =evt.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					evt.consume();	

				}
			}
		});
		getContentPane().add(dirua);
		dirua.setColumns(10);
		btnEzeztatu.setBounds(340, 491, 112, 41);

		btnEzeztatu.setFont(new Font("Arial", Font.PLAIN, 18));
		btnEzeztatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Metodoak.ongietorrileihora();
				
			}
		});
		getContentPane().add(btnEzeztatu);
		btnAtzera.setBounds(176, 490, 105, 43);
		//String nan = Hotel.getDni();
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

				Metodoak.erreserbahasieratu(hotelak, HotelakAukeratuLeihoa.PrezioSoloHotel);
				
			}
		});
		btnAtzera.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(btnAtzera);
		btnOrdaindu.setBounds(470, 151, 141, 37);
		//Arraylistari prezioa sartu
		preziotot.add(prezioHotelFinal);
		//ORDAINDU BOTOIA
		btnOrdaindu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Prezioa Arraylistean sartzen da


				String ordaindu=(String) dirua.getText();//Sartutako diru kantitatea testu moduan gordeko da

				//KONPROBATU LETRA
				boolean letra=Metodoak.konprobatuLetra(ordaindu);
				String mezua="";

				if (letra==false) {
					double zbk= Double.parseDouble(ordaindu);//Zenbaki formatura pasatzen da


					//KONPROBATU ZENBAKI NEGATIBOA
					boolean zenbakia=Metodoak.konprobatuNegatibo(zbk);
					if (zenbakia==true){ 
						System.out.println(preziotot.get(preziotot.size()-1));

						prezio2 = preziotot.get(preziotot.size()-1);
						preziototala = (double)prezio2-zbk;
						boolean diru_falta=Metodoak.diruFalta(zbk, prezio2);
						//KONPROBATU DIRU FALTA
						if (diru_falta==true){
							preziotot.add(preziototala);
							mezua=(preziotot.get(preziotot.size()-1)+" € falta zaizkizu");
							Itzuliak.setText(mezua);	
							btnAtzera.setEnabled(false);
							btnAmaitu.setEnabled(false);

						}else {
							if (preziototala<0) {

								preziototala=preziototala*(-1);
								String kanbioak=Metodoak.bueltakMetodoa(preziototala);
								Itzuliak.setText(kanbioak);
								btnAmaitu.setEnabled(true);
								btnEzeztatu.setEnabled(false);
								btnAtzera.setEnabled(false);
								btnOrdaindu.setEnabled(false);
								dirua.setEditable(false);
							}else if(preziototala==0) {
								mezua="Eskerrik asko erosteagatik";
								Itzuliak.setText(mezua);
								btnAmaitu.setEnabled(true);
								btnEzeztatu.setEnabled(false);
								btnAtzera.setEnabled(false);
								btnOrdaindu.setEnabled(false);
								dirua.setEditable(false);
							}
						}
					}

				}
				dirua.setText("");	
			}
		});
		btnOrdaindu.setFont(new Font("Arial", Font.PLAIN, 20));

		getContentPane().add(btnOrdaindu);
		Itzuliak.setFont(new Font("Arial", Font.PLAIN, 18));
		
		Itzuliak.setBounds(241, 225, 380, 254);
		getContentPane().add(Itzuliak);
		Itzuliak.setEditable(false);
		//String ordaintzeko = String.valueOf(hoteles.getPrecioHotel());
		String ordaintzeko = String.valueOf(prezioHotelFinal);
		//String ordaintzeko="0";
		lblOrdaintzeko.setHorizontalAlignment(SwingConstants.LEFT);
		
		//Para que en el label de Ordaindu salgan 2 decimales lo pasamos a double 
		//y luego decimal format y hacemos el setText
		double ordaintzekoLabelDosDecimales = Double.parseDouble(ordaintzeko);
		dosDecimales.format(ordaintzekoLabelDosDecimales);
		lblOrdaintzeko.setText(ordaintzekoLabelDosDecimales+"");
		lblOrdaintzeko.setFont(new Font("Arial", Font.PLAIN, 18));
		lblOrdaintzeko.setBounds(263, 111, 135, 30);
		getContentPane().add(lblOrdaintzeko);
		
		lblOrdainketa_Tituloa.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrdainketa_Tituloa.setFont(new Font("Arial", Font.BOLD, 37));
		lblOrdainketa_Tituloa.setBounds(223, 41, 273, 43);
		getContentPane().add(lblOrdainketa_Tituloa);

	}
}