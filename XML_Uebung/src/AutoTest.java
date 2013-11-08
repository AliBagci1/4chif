import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



public class AutoTest {
	
	private static final String AutoGeschaeft_XML ="./autogeschaeft-jaxb.xml";
	
	public static void main(String[] args) throws JAXBException, IOException {
		ArrayList<Auto> autolist = new ArrayList<Auto>(); 
		// TODO Auto-generated method stub
		
		Auto auto1 = new Auto();
		auto1.setMarke("BMW X6");
		auto1.setHersteller("BMW");
		auto1.setFarbe("Schwarz");
		auto1.setBaujahr(2012);
	    autolist.add(auto1);
		
	    Auto auto2 = new Auto();
		auto2.setMarke("Audi s5");
		auto2.setHersteller("Audi");
		auto2.setFarbe("Weis");
		auto2.setBaujahr(2013);
	    autolist.add(auto2);
	    
	    AutoGeschaeft autogeschaeft = new AutoGeschaeft();
	    autogeschaeft.setName("JonnyCars");
	    autogeschaeft.setOrt("Wien");
	    autogeschaeft.setAutolist(autolist);
	    
	    JAXBContext con = JAXBContext.newInstance(AutoGeschaeft.class);
	    Marshaller m = con.createMarshaller();
	    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	    
	    m.marshal(autogeschaeft, System.out);
	    
	    m.marshal(autogeschaeft, new File(AutoGeschaeft_XML));
	    
	    System.out.println();
	    System.out.println("Ausgang aus unserer XML-Datei: ");
	    Unmarshaller um = con.createUnmarshaller();
	    AutoGeschaeft autogeschaeft2 = (AutoGeschaeft) um.unmarshal(new FileReader(AutoGeschaeft_XML));
	    ArrayList<Auto> autolist1 = autogeschaeft2.getAutoList();
	    for(Auto auto : autolist1){
	    	System.out.println("Auto: "+ auto.getMarke()+" von "+auto.getHersteller()+" Baujahr: "+auto.getBaujahr());
	    }
	    

	}

}
