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
        <title>Sell All Items</title>
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
    	<h3 align="center"> Sell All Items </h3>
    	<c:forEach var="itemIn" items="${itemIns}">
    	<div align="center">
    	<fieldset  style="width: 70%;">
    	<legend> <c:out value="${itemIn.name }" /> </legend>
    	<html:form action="/sellmutiple">
    	<table border="0" >
    	<tr>
    		<td><fmt:message key="label.code"/> : </td><td><html:text property="itemIn.code" value="${itemIn.code }" disabled="true"/></td>
    	</tr>
    	<tr>
    		<td><fmt:message key="label.istrans"/> : </td><td><html:checkbox property="itemIn.isTrans" value="${itemIn.isTrans }" disabled="true"/></td>
    		<td><fmt:message key="label.address"/> : </td><td colspan="3"><html:text property="itemIn.address" size="58%" value="${itemIn.address }" disabled="true"/></td>
    	</tr>
    	<tr>
    		<td><fmt:message key="label.purchase.price"/> : </td><td><html:text property="itemIn.purcahasPrice" value="${itemIn.purcahasPrice }" disabled="true"/></td>
    		<td><fmt:message key="label.purchase.time"/> : </td>
    		<td><html:text property="itemIn.purchaseDatetime" value="${itemIn.purchaseDatetime }" disabled="true"/></td>
    		<td><fmt:message key="label.purchase.size"/> : </td><td><html:text property="itemIn.purchaseSize" value="${itemIn.purchaseSize }" disabled="true"/></td>
    	</tr>
    	</table>
    	</html:form>
    	</fieldset>
    	</div>
    	</c:forEach>
    </body>
</html:html>