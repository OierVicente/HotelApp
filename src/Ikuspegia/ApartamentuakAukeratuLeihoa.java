package Ikuspegia;

import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;

import Eredua.Kontsulta_Apartamentua;
import Kontrolatzailea.Apartamentua;
import Kontrolatzailea.Metodoak;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class ApartamentuakAukeratuLeihoa extends JFrame {
	private static final long serialVersionUID = 1L;
	JLabel lblHelbideak = new JLabel("Helbideak:");
	JComboBox comboBoxHelbideakApartamentuak = new JComboBox();
	JLabel lblApartamentuak = new JLabel("Apartamentuak:");
	JComboBox comboBoxApartamentuakAukeratu = new JComboBox();
	JButton btnHurrengoaApartamentua = new JButton("Hurrengoa");
	JButton btnEzeztatuApartamentua = new JButton("Ezeztatu");
	JButton btnAtzeraApartamentua = new JButton("Atzera");

	//Bariableak
	ArrayList<Apartamentua> ApartamentuakComboBox = new ArrayList<Apartamentua>();
	
	public Double PrezioApartamentua;
	public static double PrezioSoloApartamentua=0;

	/**
	 * 
	 * @param Helbideak
	 */
	public ApartamentuakAukeratuLeihoa(ArrayList<String> Helbideak) {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.setBounds(275,100,700,600);
		this.setBackground(SystemColor.control);
		getContentPane().setLayout(null);
		
		lblHelbideak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHelbideak.setBounds(51, 31, 105, 41);
		getContentPane().add(lblHelbideak);
		
		comboBoxHelbideakApartamentuak.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxHelbideakApartamentuak.setBounds(51, 95, 180, 30);
		getContentPane().add(comboBoxHelbideakApartamentuak);
		comboBoxHelbideakApartamentuak.addItem("");
		for (int i=0;i<Helbideak.size();i++) {
			comboBoxHelbideakApartamentuak.addItem(Helbideak.get(i));
		}
		
		lblApartamentuak.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblApartamentuak.setBounds(69, 210, 162, 30);
		getContentPane().add(lblApartamentuak);
		
		comboBoxApartamentuakAukeratu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxApartamentuakAukeratu.setBounds(49, 277, 598, 30);
		getContentPane().add(comboBoxApartamentuakAukeratu);
		comboBoxHelbideakApartamentuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxApartamentuakAukeratu.removeAllItems();
				String helbideakSelected = (String) comboBoxHelbideakApartamentuak.getSelectedItem();
				ApartamentuakComboBox=Kontsulta_Apartamentua.ApartamentuakHelbidearekinAtera(helbideakSelected);
				for (int i = 0; i < ApartamentuakComboBox.size(); i++) {
					comboBoxApartamentuakAukeratu.addItem(ApartamentuakComboBox.get(i).comboboxIzena());
					
				}
				
			}

			
		});
		
		
		btnHurrengoaApartamentua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHurrengoaApartamentua.setBounds(520, 497, 140, 41);
		getContentPane().add(btnHurrengoaApartamentua);
		
		btnHurrengoaApartamentua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				
				String apartamentuak = (String) comboBoxApartamentuakAukeratu.getSelectedItem();
				int PosicionSelected = comboBoxApartamentuakAukeratu.getSelectedIndex();
				if (apartamentuak==(null)) {
					btnHurrengoaApartamentua.setEnabled(false);
					JOptionPane.showMessageDialog(null,"Ez duzu etxerik aukeratu. Mezedez, Hotel bat aukeratu.");
				}
				else if(!(apartamentuak==(null))) {
					dispose();
					PrezioApartamentua= ApartamentuakComboBox.get(PosicionSelected).getPrezioApartementua();
					OstauMotaAukeratu.idOstatu = ApartamentuakComboBox.get(PosicionSelected).getId_Ostatu();
					PrezioSoloApartamentua = ApartamentuakComboBox.get(PosicionSelected).getPrezioApartementua();
					Metodoak.erreserbahasieratuapartamentua(apartamentuak, PrezioApartamentua);

				}
				
			}
		});
		
		btnEzeztatuApartamentua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEzeztatuApartamentua.setBounds(262, 497, 115, 41);
		getContentPane().add(btnEzeztatuApartamentua);
		btnEzeztatuApartamentua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Metodoak.ongietorrileihora();
			}
		});
		
		btnAtzeraApartamentua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAtzeraApartamentua.setBounds(22, 497, 105, 41);
		getContentPane().add(btnAtzeraApartamentua);
		btnAtzeraApartamentua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Metodoak.ostatumotaaukeratuleihora();
			}
		});


	}
}
