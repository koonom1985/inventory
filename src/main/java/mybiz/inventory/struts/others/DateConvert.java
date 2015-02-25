package mybiz.inventory.struts.others;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class DateConvert implements Converter {
	private final static String pattern = "yyyy-MM-dd";
	public Object convert(Class type, Object value) {
		if(value == null){  
            return (null);  
        }
          
        Date dateObj = null;  
        if(value instanceof String){  
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
            try{  
                dateObj = sdf.parse((String)value);  
            }catch(ParseException pe){  
                return (null);  
            }  
        }
          
        return dateObj;
	}

}
