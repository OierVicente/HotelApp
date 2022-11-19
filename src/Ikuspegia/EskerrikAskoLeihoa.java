package Ikuspegia;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
public class EskerrikAskoLeihoa extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JLabel lblEskerrikAsko = new JLabel("Eskerrik asko erosteagatik ");
	private JLabel lblZureTxartelaOrain = new JLabel("Zure erreserba orain aterako da");
	private JLabel icono = new JLabel();
	
	public EskerrikAskoLeihoa() {
		
		
		this.setBounds(275,100,700,600);
		getContentPane().setLayout(null);
		
		//LABEL ESKERRIK ASKO
		lblEskerrikAsko.setFont(new Font("Arial", Font.PLAIN, 46));
		lblEskerrikAsko.setBounds(70, 95, 565, 78);
		getContentPane().add(lblEskerrikAsko);
		
		//LABEL ZURE ERRESERBA ORAIN
		lblZureTxartelaOrain.setFont(new Font("Arial", Font.PLAIN, 41));
		lblZureTxartelaOrain.setBounds(70, 198, 581, 45);
		getContentPane().add(lblZureTxartelaOrain);
		
		
	}
}