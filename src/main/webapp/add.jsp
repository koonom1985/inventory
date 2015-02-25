<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<html>
	<head>
        <title>Add Item</title>
    </head>
    <body>
    	<div align="center">
    	<fieldset  style="width: 60%;">
    	<legend> Add & Search Item </legend>
    	<html:form action="/add">
    	<table border="0" >
    	<tr>
    		<td>Code : </td><td><html:text property="itemIn.code" value=""/></td>
    		<td>Name : </td><td><html:text property="itemIn.name" value=""/></td>
    	</tr>
    	<tr>
    		<td>Address : </td><td><html:text property="itemIn.address" value=""/></td>
    		<td>Transact : </td><td><html:checkbox property="itemIn.isTrans" value="true"/></td>
    	</tr>
    	<tr>
    		<td>Purchase Size : </td><td><html:text property="itemIn.purchaseSize" value=""/></td>
    		<td>Purchase Time : </td>
    		<fmt:parseDate value="2015-02-16" type="DATE" pattern="yyyy-MM-dd" var="formatedDate"/> 
    		<c:out value="${formatedDate }"/>
    		<td><html:text property="itemIn.purchaseDatetime" value=""/></td>
    		<td>Purchase Price : </td><td><html:text property="itemIn.purcahasPrice" value=""/></td>
    	</tr>
    	<tr>
    		<td>
    		<html:submit value="Add"/>
    		<html:cancel/>
    		</td>
    	</tr>
    	</table>
    	</html:form>
    	</fieldset>
    	</div>
    </body>
</html>