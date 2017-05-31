package Properties;

import java.io.IOException;
import java.util.Properties;

public class Lenguage extends Properties{
    
       
    public Lenguage(String lenguage){
    	
       	switch(lenguage){
	    	case "spanish":
                    getProperties("spanish.properties");
                    break;
	    	case "english":
                    getProperties("english.properties");
                    break;
            default:
                    getProperties("spanish.properties");
	   	}

    }

    private void getProperties(String lenguage) {
        try {
            this.load( getClass().getResourceAsStream(lenguage) );
        } catch (IOException ex) {
        
        }
   }
	
}
