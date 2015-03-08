<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<html:html>
<fmt:setBundle basename="message"/>
	<head>
		<meta charset="utf-8">
        <title>Update ItemIn</title>
        <link rel="stylesheet" href="./jquery-ui.css">
		<script src="./jquery.js"></script>
		<script src="./jquery-ui.js"></script>
		<script>
		$(function() {$("input[name='itemIn.purchaseDatetime']").datepicker();});
		var hasprompt = '<%= pageContext.getRequest().getAttribute("prompt.message") %>' ;
		if (hasprompt != null && hasprompt != 'null') {
			alert(hasprompt);			
		}
		</script>
    </head>
    <body>
    	<div align="center">
    	<fieldset  style="width: 60%;">
    	<legend> <fmt:message key="title.update.item"/> </legend>
    	<html:form action="/update">
    	<table border="0" >
    	<tr>
    		<td><fmt:message key="label.code"/> : </td><td><html:text property="itemIn.code"/></td>
    		<td><fmt:message key="label.name"/> : </td><td><html:text property="itemIn.name"/></td>
    	</tr>
    	<tr>
    		<td><fmt:message key="label.istrans"/> : </td><td><html:checkbox property="itemIn.isTrans"/></td>
    		<td><fmt:message key="label.address"/> : </td><td colspan="3"><html:text property="itemIn.address" size="58%"/></td>
    	</tr>
    	<tr>
    		<td><fmt:message key="label.purchase.price"/> : </td><td><html:text property="itemIn.purcahasPrice"/></td>
    		<td><fmt:message key="label.purchase.time"/> : </td>
    		<td><html:text property="itemIn.purchaseDatetime"/></td>
    		<td><fmt:message key="label.purchase.size"/> : </td><td><html:text property="itemIn.purchaseSize"/></td>
    	</tr>
    	<tr>
    		<td>
    			<html:hidden property="forUpdate" value="true"/>
    			<html:hidden property="itemIn.itemInId"/>
    			<html:submit>
    			<fmt:message key="label.common.button.update" />
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