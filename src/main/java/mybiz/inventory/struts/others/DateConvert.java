package mybiz.inventory.struts.others;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.beanutils.Converter;
import org.apache.log4j.Logger;

public class DateConvert implements Converter {
	private static final Logger logger = Logger.getLogger(DateConvert.class);
	private static Set<String> patterns = new HashSet<String>();
	static {
		DateConvert.patterns.add("yyyy-MM-dd");
		DateConvert.patterns.add("MM/dd/yyyy");
	}
	public Object convert(Class type, Object value) {
		logger.info("convert value::"+value);
		if(value == null){  
            return (null);  
        }
          
        Date dateObj = null;  
        if(value instanceof String){
        	logger.info("value instanceof String");
        	SimpleDateFormat sdf = new SimpleDateFormat();
        	Iterator it = patterns.iterator();
        	while (it.hasNext()) {
        		String pattern = (String) it.next();
        		sdf.applyPattern(pattern);
        		try{  
                    dateObj = sdf.parse((String)value);  
                    break;
                }catch(ParseException pe){
                }
        	}
        }
        logger.info("return value::"+dateObj);
        return dateObj;
	}

}
