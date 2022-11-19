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
public class OstauMotaAukeratu extends JFrame {


	private JButton btnAtzera = new JButton("Atzera");
	public static int idOstatu;





	public OstauMotaAukeratu() {
		

		this.setBounds(275,100,700,600);
		this.setBackground(SystemColor.control);
		getContentPane().setLayout(null);

		
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Metodoak.loginleihora();
				
			}
		});
		btnAtzera.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAtzera.setBounds(279, 511, 131, 39);
		getContentPane().add(btnAtzera);
		
		JLabel lblMesedezAukeratuOstatu = new JLabel("Mesedez, aukeratu ostatu mota bat");
		lblMesedezAukeratuOstatu.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMesedezAukeratuOstatu.setBounds(168, 28, 395, 39);
		getContentPane().add(lblMesedezAukeratuOstatu);
		
		JButton btnHotelak = new JButton("Hotelak");
		btnHotelak.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnHotelak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Metodoak.hotelakaukeratuleihora();
				dispose();
			}
		});
		btnHotelak.setBounds(25, 120, 175, 316);
		getContentPane().add(btnHotelak);
		
		JButton btnEtxeak = new JButton("Etxeak");
		btnEtxeak.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnEtxeak.setBounds(257, 120, 175, 316);
		getContentPane().add(btnEtxeak);
		btnEtxeak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Metodoak.etxeakaukeratuleihora();
				dispose();
			}
		});
		
		JButton btnApartamentuak = new JButton("Apartamentuak");
		btnApartamentuak.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnApartamentuak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Metodoak.apartamentuakAukeratuleihora();
			}
		});
		btnApartamentuak.setBounds(470, 120, 204, 316);
		getContentPane().add(btnApartamentuak);
		

	}

}