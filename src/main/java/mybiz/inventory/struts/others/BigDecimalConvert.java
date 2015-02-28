package mybiz.inventory.struts.others;

import java.math.BigDecimal;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class BigDecimalConvert implements Converter {
	private static final Logger logger = Logger.getLogger(BigDecimalConvert.class);
	public Object convert(Class type, Object value) {
		logger.info("convert value::"+value);
		if(value == null){  
            return (null);  
        }
		
		BigDecimal bigDecimalObj = null;  
        if(value instanceof String){
        	logger.info("value instanceof String");
        	if (value == null || StringUtils.isBlank((String) value)) {
        		bigDecimalObj = BigDecimal.ZERO;
        	} else if (StringUtils.isNotBlank((String)value)) {
        		try{
        			bigDecimalObj = new BigDecimal((String)value);
        		} catch (NumberFormatException e) {
        			logger.error(e.getMessage());
        		}
        	} else {
        		logger.info("looks like invalid value::"+value);
        	}
        }
        logger.info("return value::"+bigDecimalObj);
		return bigDecimalObj;
	}

}
