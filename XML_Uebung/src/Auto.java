

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

public class Auto {

	private String marke;
	private String hersteller;
	private String farbe;
	private int baujahr;
	
	public String getMarke(){
		return marke;
	}
	public void setMarke(String marke){
		this.marke= marke;
	}
	public String getHersteller(){
		return hersteller;
	}
	public void setHersteller(String hersteller){
		this.hersteller = hersteller;
	}
	public String getFarbe(){
		return farbe;
	}
	public void setFarbe(String farbe){
		this.farbe = farbe;
	}
	public int getBaujahr(){
		return baujahr;
	}
	public void setBaujahr(int baujahr){
		this.baujahr = baujahr;
	}
	
}
