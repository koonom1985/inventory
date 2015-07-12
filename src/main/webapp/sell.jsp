<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<html:html>
<fmt:setBundle basename="message"/>
	<head>
		<meta charset="utf-8">
        <title>Sell Item</title>
        <link rel="stylesheet" href="./jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="./bootstrap.min.css" />
		<script src="./jquery.js"></script>
		<script src="./jquery-ui.js"></script>
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
    	<legend> Item in Inventory </legend>
    	<html:form action="/sell">
    	<table border="0" >
    	<tr>
    		<td><fmt:message key="label.code"/> : </td><td><html:text property="itemIn.code" disabled="true"/></td>
    		<td><fmt:message key="label.name"/> : </td><td><html:text property="itemIn.name" disabled="true"/></td>
    	</tr>
    	<tr>
    		<td><fmt:message key="label.istrans"/> : </td><td><html:checkbox property="itemIn.isTrans" disabled="true"/></td>
    		<td><fmt:message key="label.address"/> : </td><td colspan="3"><html:text property="itemIn.address" size="58%" disabled="true"/></td>
    	</tr>
    	<tr>
    		<td><fmt:message key="label.purchase.price"/> : </td><td><html:text property="itemIn.purcahasPrice" disabled="true"/></td>
    		<td><fmt:message key="label.purchase.time"/> : </td>
    		<td><html:text property="itemIn.purchaseDatetime" disabled="true"/></td>
    		<td><fmt:message key="label.purchase.size"/> : </td><td><html:text property="itemIn.purchaseSize" disabled="true"/></td>
    	</tr>
    	</table>
    	</html:form>
    	</fieldset>
    	</div>
    	
    	<div align="center">
    	<fieldset  style="width: 70%;">
    	<legend> <fmt:message key="title.sell.item"/> </legend>
    	<html:form action="/sell">
    	<table border="0" >
    	<tr>
    		<td><fmt:message key="label.sell.size"/> : </td><td><html:text property="itemSell.sellSiez" value=""/></td>
    		<td><fmt:message key="label.sell.price"/> : </td><td><html:text property="itemSell.sellPrice" value=""/></td>
    	</tr>
    	<tr>
    		<td><fmt:message key="label.sell.time"/> : </td>
    		<td><html:text property="itemSell.sellDatetime" value=""/></td>
    		<td><fmt:message key="label.sell.address"/> : </td><td><html:text property="itemSell.sellAddress" value=""/></td>
    		<td><fmt:message key="label.sell.telephone"/> : </td><td><html:text property="itemSell.sellTelphone" value=""/></td>
    	</tr>
    	<tr>
    		<td>
    			<html:hidden property="forSell" value="true"/>
    			<html:hidden property="itemInId"/>
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
    	
    	<div align="center">
    	<fieldset  style="width: 60%;">
    	<legend> <fmt:message key="title.list.sell.item"/> </legend>
    	<display:table export="true" id="selldata" name="requestScope.slist" requestURI="/sell.do" pagesize="10" cellpadding="5px;">
    	<display:column property="itemIn.itemInId" titleKey="label.code" sortable="false"/>
    	<display:column property="sellSiez" titleKey="label.sell.size" sortable="true"/>
    	<display:column property="sellPrice" titleKey="label.sell.price" sortable="false"/>
    	<display:column property="sellDatetime" titleKey="label.sell.time" sortable="true"/>
    	<display:column property="sellAddress" titleKey="label.sell.address" sortable="true"/>
    	<display:column property="sellTelphone" titleKey="label.sell.telephone" sortable="true"/>
    	<display:column titleKey="label.common.button.update" sortable="false">
    		<html:link action="/updateSell.do" paramName="selldata" paramId="id" paramProperty="itemSellId">
    			<fmt:message key="label.common.button.update"/>
    		</html:link>
    	</display:column>
    	<display:column titleKey="label.common.button.delete" sortable="false">
    		<html:link action="/deleteSell.do" paramName="selldata" paramId="id" paramProperty="itemSellId"
					   onclick="if(confirm('Are you sure?')==false)return false;">
    			<fmt:message key="label.common.button.delete"/>
    		</html:link>
    	</display:column>
    	</display:table>
    	</fieldset>
    	</div>
    </body>
</html:html>