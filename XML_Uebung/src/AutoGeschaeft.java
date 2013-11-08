import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
public class AutoGeschaeft {
	private ArrayList<Auto> autolist;
	private String name;
	private String ort;
	
	public void setAutolist(ArrayList<Auto> autolist){
		this.autolist = autolist;
	}
	
	public ArrayList<Auto> getAutoList(){
		return autolist;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name= name;
	}
	public String getOrt(){
		return ort;
	}
	
	public void setOrt(String ort){
		this.ort = ort;
	}

}
