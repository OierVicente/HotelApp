package Kontrolatzailea;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Oier Vicente,Diego,Erlantz,Aintzane
 *
 */
class JUnitTest {

@Test
	
	public void konprobatuMD5() {
		String pasahitza="abracadabra";
		assertEquals(Metodoak.ateraMD5(pasahitza),("ec5287c45f0e70ec22d52e8bcbeeb640"));
	}

	@Test
	public void konprobatuNegatibo() {
		assertEquals(Metodoak.konprobatuNegatibo(2),(true));
	}
	@Test
	public void kanbioMetodoa() {
		assertEquals(Metodoak.bueltakMetodoa(388.88),Metodoak.bueltakMetodoa(388.88));
	}
	@Test
	public void konprobatuLetra() {
		
		assertEquals(Metodoak.konprobatuLetra("dfsdfs"),(true));
	}
	@Test
	public void diruFalta() {
		double zbk=5;
		double prezioa=10;
		assertEquals(Metodoak.diruFalta(zbk, prezioa), true);
	}
	@Test
	public void orduaAtera() {
		assertEquals(Metodoak.orduaAtera(), Metodoak.orduaAtera());
	}
	@Test
	public void dataAtera() {
		assertEquals(Metodoak.dataAtera(), Metodoak.dataAtera());
		
	}
	@Test
	public void Redondear() {
		double numero=10.99999;
		assertEquals(Metodoak.RedondearDosDecimales(numero), 11);
	}
	@Test
	public void KalkulatuLetra() {
		int dni=12345678;
		assertEquals(Metodoak.KalkulatuLetra(dni), "Z");
	}

}
