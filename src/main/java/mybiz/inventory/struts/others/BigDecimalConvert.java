package mybiz.inventory.struts.others;

import java.math.BigDecimal;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;

public class BigDecimalConvert implements Converter {

	public Object convert(Class type, Object value) {
		if(value == null){  
            return (null);  
        }
		
		BigDecimal bigDecimalObj = null;  
        if(value instanceof String){
        	if (value == null || StringUtils.isBlank((String) value)) {
        		value = BigDecimal.ZERO;
        	} else if (StringUtils.isNotBlank((String)value) && StringUtils.isNumeric((String)value)) {
        		bigDecimalObj = new BigDecimal((String)value);
        	}
        }
		return bigDecimalObj;
	}

}
