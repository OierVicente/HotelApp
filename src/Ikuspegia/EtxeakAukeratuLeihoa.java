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

import Kontrolatzailea.Etxea;
import Kontrolatzailea.Hotel;
import Kontrolatzailea.Metodoak;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class EtxeakAukeratuLeihoa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblEtxeak = new JLabel("Etxeak");
	private JComboBox<String> comboBoxNombreHoteles = new JComboBox<String>();
	private JComboBox<String> comboBoxOheMota = new JComboBox<String>();
	private JButton btnHurrengoa = new JButton("Hurrengoa");
	private JLabel lblHelbideak = new JLabel("Helbideak");
	private JComboBox<String> comboBoxHelbideak = new JComboBox();
	private ArrayList<Etxea>HotelCombobox = new ArrayList<Etxea>();
	private JButton btnEzeztatu = new JButton("Ezeztatu");
	private JButton btnAtzera = new JButton("Atzera");




	public Double PrezioEtxea;
	public static double PrezioSoloEtxea=0;
	/**
	 * 
	 * @param Etxeak
	 * @param Helbideak
	 */
	public EtxeakAukeratuLeihoa(ArrayList <Etxea> Etxeak,ArrayList<String> Helbideak) {
		

		this.setBounds(275,100,700,600);
		this.setBackground(SystemColor.control);
		getContentPane().setLayout(null);

		lblEtxeak.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEtxeak.setBounds(58, 176, 121, 59);
		getContentPane().add(lblEtxeak);
		
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
				HotelCombobox=Eredua.Kontsulta_Etxeak.EtxeakHelbidearekinAtera(helbideakSelected);
				for (int i = 0; i < HotelCombobox.size(); i++) {
					comboBoxNombreHoteles.addItem(HotelCombobox.get(i).comboboxIzena());
					
				}
				
			}
			//oierbike
			
		});
	
		

		comboBoxNombreHoteles.setToolTipText("Aukeratu hotel bat");
		comboBoxNombreHoteles.setBounds(40, 246, 542, 29);
		getContentPane().add(comboBoxNombreHoteles);

		comboBoxNombreHoteles.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				System.out.println(PrezioEtxea);
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
				
				String etxeak = (String) comboBoxNombreHoteles.getSelectedItem();
				int PosicionSelected = comboBoxNombreHoteles.getSelectedIndex();
				if (etxeak==(null)) {
					btnHurrengoa.setEnabled(false);
					JOptionPane.showMessageDialog(null,"Ez duzu etxerik aukeratu. Mezedez, Hotel bat aukeratu.");
				}
				else if(!(etxeak==(null))) {
					System.out.println(PrezioEtxea);
					dispose();
					PrezioEtxea = HotelCombobox.get(PosicionSelected).getPrezioEtxea();
					OstauMotaAukeratu.idOstatu = HotelCombobox.get(PosicionSelected).getId_Ostatu();
					PrezioSoloEtxea = HotelCombobox.get(PosicionSelected).getPrezioEtxea();

					Metodoak.erreserbahasieratuetxea(etxeak, PrezioEtxea);

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

}