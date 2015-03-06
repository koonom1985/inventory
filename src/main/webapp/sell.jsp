<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<html:html>
<fmt:setBundle basename="message"/>
	<head>
		<meta charset="utf-8">
        <title>Sell Item</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css">
		<script src="//code.jquery.com/jquery-1.10.2.js"></script>
		<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
		<script>
		$(function() {$("input[name='itemSell.sellDatetime']").datepicker();});
		var hasprompt = '<%= pageContext.getRequest().getAttribute("prompt.message") %>' ;
		if (hasprompt != null && hasprompt != 'null') {
			alert(hasprompt);			
		}
		</script>
    </head>
    <body>
    	<div align="center">
    	<fieldset  style="width: 60%;">
    	<legend> <fmt:message key="title.sell.item"/> </legend>
    	<html:form action="/sell">
    	<table border="0" >
    	<tr>
    		<td><fmt:message key="label.sell.size"/> : </td><td><html:text property="itemSell.sellSiez"/></td>
    		<td><fmt:message key="label.sell.price"/> : </td><td><html:text property="itemSell.sellPrice"/></td>
    	</tr>
    	<tr>
    		<td><fmt:message key="label.sell.time"/> : </td>
    		<td><html:text property="itemSell.sellDatetime"/></td>
    		<td><fmt:message key="label.sell.address"/> : </td><td><html:text property="itemSell.sellAddress"/></td>
    	</tr>
    	<tr>
    		<td><fmt:message key="label.sell.telephone"/> : </td><td><html:text property="itemSell.sellTelphone"/></td>
    	</tr>
    	<tr>
    		<td>
    			<html:hidden property="forSell" value="true"/>
    			<html:hidden property="itemSell.itemSellId"/>
    			<html:submit>
    			<fmt:message key="label.common.button.add.sell" />
    			</html:submit>
    		</td>
    		<td>
    			<html:cancel>
    			<fmt:message key="label.common.button.cancel" />
    			</html:cancel>
    		</td>
    	</tr>
    	</table>
    	</html:form>
    	</fieldset>
    	</div>
    </body>
</html:html>