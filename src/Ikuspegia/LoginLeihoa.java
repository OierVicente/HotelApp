package Ikuspegia;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Kontrolatzailea.*;
import javax.swing.JCheckBox;

/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class LoginLeihoa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textNAN;
	private JTextField textLetra;
	private JPasswordField Pasahitza;
	private JLabel lblTxatelaErregistroa = new JLabel("Logina");
	private JLabel lblNan = new JLabel("NAN");
	private JLabel lblLetra = new JLabel("Letra");
	private JLabel lblPasahitza = new JLabel("Pasahitza");
	JLabel lblEzDaukazuKonturik = new JLabel("Ez daukazu Konturik ?");
	JCheckBox chckbxShowPassword = new JCheckBox("Pasahitza Ikusi");

	
	private JButton Atzera = new JButton("Atzera");
	private JButton Jarraitu = new JButton("Jarraitu");
	private JButton Balidatu = new JButton("Balidatu");
	private JButton btnKontuBerria = new JButton("Erregistratu");
	public static int idBezero=0;
	public static String nan="";
	private String letra="";
	private String zenbakia="";
	private String pasahitza="";

	/**
	 * 
	 * @param bezero
	 */
	public LoginLeihoa(ArrayList<Bezero> bezero) {
		this.setBounds(275,100,700,600);
		getContentPane().setLayout(null);

		//LABEL TXARTEL ERREGISTROA
		lblTxatelaErregistroa.setFont(new Font("Arial", Font.BOLD, 37));
		lblTxatelaErregistroa.setBounds(222, 46, 133, 37);
		getContentPane().add(lblTxatelaErregistroa);

		//LABEL NAN
		lblNan.setFont(new Font("Arial", Font.BOLD, 20));
		lblNan.setBounds(85, 127, 47, 28);
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
		textNAN.setBounds(158, 128, 109, 28);
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
		textLetra.setBounds(373, 128, 32, 28);
		getContentPane().add(textLetra);



		//LETRA LABEL
		lblLetra.setFont(new Font("Arial", Font.BOLD, 20));
		lblLetra.setBounds(297, 127, 52, 28);
		getContentPane().add(lblLetra);

		//LABEL PASAHITZA
		lblPasahitza.setFont(new Font("Arial", Font.BOLD, 20));
		lblPasahitza.setBounds(85, 212, 92, 28);
		getContentPane().add(lblPasahitza);

		//EZEZTATU BOTOIA
		Atzera.setFont(new Font("Arial", Font.PLAIN, 18));
		Atzera.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Metodoak.ongietorrileihora();

			}
		});
		Atzera.setBounds(97, 372, 115, 55);
		getContentPane().add(Atzera);

		//JARRAITU BOTOIA
		Jarraitu.setEnabled(false);
		Jarraitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Metodoak.ostatumotaaukeratuleihora();
			}
		});
		Jarraitu.setFont(new Font("Arial", Font.PLAIN, 18));
		Jarraitu.setBounds(488, 372, 115, 55);
		getContentPane().add(Jarraitu);

		

		//PASAHITZA TEXTUA
		Pasahitza = new JPasswordField();
		Pasahitza.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Pasahitza.setBounds(200, 213, 170, 28);
		getContentPane().add(Pasahitza);

		//DNI ETA PASAHITZA BALIDATZEKO BOTOIA
		
				
				
				Balidatu.addActionListener(new ActionListener() {
					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent arg0) {
						//BALIDAZIORAKO BARIABLEAK
						zenbakia=textNAN.getText();
						letra=textLetra.getText();
						nan=zenbakia+letra;
						pasahitza=Pasahitza.getText();
						
						boolean balidatu=true;
						for (int i=0;i<bezero.size();i++) {
							if (bezero.get(i).getIdBezeroNan().equals(nan)) {
								if (bezero.get(i).getPasahitzaBezero().equals(Metodoak.ateraMD5(pasahitza))) {
									Jarraitu.setEnabled(true);
									Balidatu.setEnabled(false);
									btnKontuBerria.setEnabled(false);									
									break;
								}else {
									balidatu=false;
									Pasahitza.setText("");
									JOptionPane.showMessageDialog(null,"Pasahitza gaizki dago. Mesedez sartu berriro.");
									}
								
							}else {
								if(i==bezero.size()-1 && balidatu==true) {
								textNAN.setText("");
								textLetra.setText("");
								JOptionPane.showMessageDialog(null,"NAN-a gaizki dago. Mesedez sartu berriro.");
								}
							}
						}
						
					}
				});
				Balidatu.setFont(new Font("Arial", Font.PLAIN, 18));
				Balidatu.setBounds(297, 372, 115, 55);
				getContentPane().add(Balidatu);
				
				btnKontuBerria.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						Metodoak.erregistroleihora();
					}
				});
				btnKontuBerria.setFont(new Font("Arial", Font.PLAIN, 20));
				btnKontuBerria.setBounds(464, 204, 170, 44);
				getContentPane().add(btnKontuBerria);
				
				lblEzDaukazuKonturik.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				lblEzDaukazuKonturik.setBounds(464, 140, 189, 35);
				getContentPane().add(lblEzDaukazuKonturik);
				
				chckbxShowPassword.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (chckbxShowPassword.isSelected()) {
							Pasahitza.setEchoChar((char)0);
						}
						else {
							Pasahitza.setEchoChar('*');
						}
						
					}
				});
				chckbxShowPassword.setBounds(207, 258, 163, 23);
				getContentPane().add(chckbxShowPassword);
	}
}