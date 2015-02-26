<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html:html>
<fmt:setBundle basename="message"/>
	<head>
        <title>List product in inventory</title>
    </head>
    <body>
    	<div align="center">
    	<fieldset  style="width: 60%;">
    	<legend> <fmt:message key="title.add.item"/> </legend>
    	<html:form action="/add">
    	<table border="0" >
    	<tr>
    		<td><fmt:message key="label.code"/> : </td><td><html:text property="itemIn.code" value=""/></td>
    		<td><fmt:message key="label.name"/> : </td><td><html:text property="itemIn.name" value=""/></td>
    	</tr>
    	<tr>
    		<td><fmt:message key="label.istrans"/> : </td><td><html:checkbox property="itemIn.isTrans" value="true"/></td>
    		<td><fmt:message key="label.address"/> : </td><td colspan="3"><html:text property="itemIn.address" value="" size="58%"/></td>
    	</tr>
    	<tr>
    		<td><fmt:message key="label.purchase.price"/> : </td><td><html:text property="itemIn.purcahasPrice" value=""/></td>
    		<td><fmt:message key="label.purchase.time"/> : </td>
    		<td><html:text property="itemIn.purchaseDatetime" value=""/></td>
    		<td><fmt:message key="label.purchase.size"/> : </td><td><html:text property="itemIn.purchaseSize" value=""/></td>
    	</tr>
    	<tr>
    		<td>
    			<html:submit>
    			<fmt:message key="label.common.button.add" />
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
    	
    	<div style="margin: 20px;"></div>
    	
    	<div align="center">
    	<fieldset  style="width: 60%;">
    	<legend> List Item </legend>
    	<display:table export="true" id="itemdata" name="requestScope.rlist" requestURI="/list.do" pagesize="10" cellpadding="5px;">
    	<display:column property="code" titleKey="label.code" sortable="true"/>
    	<display:column property="name" titleKey="label.name" sortable="true"/>
    	<display:column property="isTrans" titleKey="label.istrans" sortable="false"/>
    	<display:column property="purcahasPrice" titleKey="label.purchase.price" sortable="true"/>
    	<display:column property="purchaseDatetime" titleKey="label.purchase.time" sortable="true"/>
    	<display:column property="purchaseSize" titleKey="label.purchase.size" sortable="true"/>
    	<display:column property="address" titleKey="label.address" sortable="false"/>
    	<display:column property="telephone" titleKey="label.telephone" sortable="true"/>
    	<display:column titleKey="label.common.button.update.or.delete" sortable="false">
    		<html:button property="">
    			<fmt:message key="label.common.button.update"/>
    		</html:button>
    		<html:link action="/delete.do" paramName="itemInId" property="itemInId" paramProperty="itemInId">
    			<fmt:message key="label.common.button.delete"/>
    		</html:link>
    	</display:column>
    	</display:table>
    	</fieldset>
    	</div>
    </body>
</html:html>