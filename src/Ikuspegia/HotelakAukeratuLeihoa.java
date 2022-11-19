package Ikuspegia;

import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Kontrolatzailea.Hotel;
import Kontrolatzailea.Metodoak;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class HotelakAukeratuLeihoa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblHotelak = new JLabel("Hotelak");
	private JComboBox<String> comboBoxNombreHoteles = new JComboBox<String>();
	private JComboBox<String> comboBoxOheMota = new JComboBox<String>();
	private JButton btnHurrengoa = new JButton("Hurrengoa");
	private JLabel lblHelbideak = new JLabel("Helbideak");
	private JComboBox comboBoxHelbideak = new JComboBox();
	private ArrayList<Hotel>HotelCombobox = new ArrayList<Hotel>();
	private JButton btnEzeztatu = new JButton("Ezeztatu");
	private JButton btnAtzera = new JButton("Atzera");




	public Double PrezioHotel;
	public static double PrezioSoloHotel=0;
	/**
	 * 
	 * @param Hoteles
	 * @param Helbideak
	 */
	public HotelakAukeratuLeihoa(ArrayList <Hotel> Hoteles,ArrayList<String> Helbideak) {
		

		this.setBounds(275,100,700,600);
		this.setBackground(SystemColor.control);
		getContentPane().setLayout(null);

		lblHotelak.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblHotelak.setBounds(58, 176, 121, 59);
		getContentPane().add(lblHotelak);
		
		comboBoxHelbideak.setBounds(58, 107, 196, 39);
		getContentPane().add(comboBoxHelbideak);
		comboBoxHelbideak.addItem("");
		comboBoxHelbideak.setSelectedIndex(0);
		for (int i=0;i<Helbideak.size();i++) {
			System.out.println(Helbideak);
			comboBoxHelbideak.addItem(Helbideak.get(i));
		}
		comboBoxHelbideak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxNombreHoteles.removeAllItems();
				String helbideakSelected = (String) comboBoxHelbideak.getSelectedItem();
				HotelCombobox=Eredua.Kontsulta_Hoteles.HotelakHelbidearekinAtera(helbideakSelected);
				for (int i = 0; i < HotelCombobox.size(); i++) {
					comboBoxNombreHoteles.addItem(HotelCombobox.get(i).comboboxIzena());
					
				}
				
			}

			
		});
	
		

		comboBoxNombreHoteles.setToolTipText("Aukeratu hotel bat");
		comboBoxNombreHoteles.setBounds(40, 246, 542, 29);
		getContentPane().add(comboBoxNombreHoteles);

		comboBoxNombreHoteles.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				System.out.println(PrezioHotel);
				btnHurrengoa.setEnabled(true);
				System.out.println("_____________________________________________________");
				comboBoxOheMota.removeAllItems();
			}
		});
		btnHurrengoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				String logelKant = textFieldKant.getText();
//				int logelaKant = Integer.parseInt(logelKant);// pasar de String a int		
//				System.out.println(logelaKant);
				
				String hotelak = (String) comboBoxNombreHoteles.getSelectedItem();
				int PosicionSelected = comboBoxNombreHoteles.getSelectedIndex();
				if (hotelak==(null)) {
					btnHurrengoa.setEnabled(false);
					JOptionPane.showMessageDialog(null,"Ez duzu hotelik aukeratu. Mezedez, Hotel bat aukeratu.");
				}
				else if(!(hotelak==(null))) {
					System.out.println(PrezioHotel);
					dispose();
					PrezioHotel = HotelCombobox.get(PosicionSelected).getPrezioHotel();
					OstauMotaAukeratu.idOstatu = HotelCombobox.get(PosicionSelected).getId_Ostatu();
					PrezioSoloHotel = HotelCombobox.get(PosicionSelected).getPrezioHotel();
					Metodoak.erreserbahasieratu(hotelak, PrezioHotel);

				}
				
			}
		});
		
		
	
		
		
		btnHurrengoa.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnHurrengoa.setBounds(473, 497, 167, 39);
		getContentPane().add(btnHurrengoa);
		
		lblHelbideak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHelbideak.setBounds(74, 36, 105, 39);
		getContentPane().add(lblHelbideak);
		
		btnEzeztatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Metodoak.ongietorrileihora();
				
			}
			
		});
		btnEzeztatu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEzeztatu.setBounds(252, 498, 128, 41);
		getContentPane().add(btnEzeztatu);
		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Metodoak.ostatumotaaukeratuleihora();				
			}
		});
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAtzera.setBounds(40, 499, 121, 39);
		getContentPane().add(btnAtzera);
		

	}
	public static int idHotelArtu(){
		int idhotel = OstauMotaAukeratu.idOstatu;
		return idhotel;
	}
}