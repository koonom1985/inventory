<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
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
    	<html:form action="/sellmutiple">
    	<logic:iterate id="sellid" name="sellids">  
		    <html:hidden property="sellids" value="${sellid}"/>
		</logic:iterate>
    	<div align="center">
    	<fieldset style="width: 80%;">
    	<legend> Sell All Items - general sell information </legend>
    		<table>
   			<tr>
		   	<td>sell address:</td><td><input type="text" name="selladdress"/></td>
		   	<td>&nbsp;</td>
		   	<td>sell telphone:</td><td><input type="text" name="sellTelphone"/></td>
		   	</tr>
		   	<tr><td align="right" colspan="5">
		   	<html:submit>
    		<fmt:message key="label.common.button.sell" />
    		</html:submit>
    		<html:cancel>
   			<fmt:message key="label.common.button.cancel" />
   			</html:cancel>
   			</td></tr>
   			</table>
   		</fieldset>
    	</div>
    	<c:forEach var="itemIn" items="${itemInViews}" varStatus="idx">
    	<div align="center">
    	<fieldset style="width: 70%;">
    	<legend> <c:out value="${itemIn.name }" /> </legend>
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
    	<tr>
    		<c:set var="indexstr">${itemIn.itemInId}</c:set>
    		<td>sell size:</td><td><html:text property="itemInSellSizesMap(${itemIn.itemInId})" value="${itemInSellSizesMap[indexstr][0] }"/></td>
    		<td>sell price:</td><td><html:text property="itemInSellPricesMap(${itemIn.itemInId})" value="${itemInSellPricesMap[indexstr][0] }"/></td>
    	</tr>
    	<tr>
    		<td>
    		<html:link action="/sell.do" paramName="itemIn" paramId="id" paramProperty="itemInId">
			check sell items
			</html:link>
    		</td>
    	</tr>
   		<c:forEach var="sellsize" items="${itemInSellSizesMap[indexstr] }" varStatus="sellsizeidx" >
   		<c:if test="${sellsizeidx.index > 0}">
   		<tr>
   		<td>sold size(<c:out value="${sellsizeidx.index}" />) : </td><td><c:out value="${sellsize }" /></td>
   		<td>sold price(<c:out value="${sellsizeidx.index}" />) : </td><td><c:out value="${itemInSellPricesMap[indexstr][sellsizeidx.index] }" /></td>
   		</tr>
   		</c:if>
   		</c:forEach>
    	<tr>
    		<td>Total sold size:</td><td><c:out value="${itemInSoldSizesMap[itemIn.itemInId]}"/></td>
    	</tr>
    	</table>
    	</fieldset>
    	</div>
    	</c:forEach>
    	</html:form>
    </body>
</html:html>