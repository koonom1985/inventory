<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<html:html>
	<head>
        <title>List product in inventory</title>
    </head>
    <body>
    	<div align="center">
    	<fieldset  style="width: 60%;">
    	<legend> Add Item </legend>
    	<html:form action="/add">
    	<table border="0" >
    	<tr>
    		<td>Code : </td><td><html:text property="itemIn.code" value=""/></td>
    		<td>Name : </td><td><html:text property="itemIn.name" value=""/></td>
    	</tr>
    	<tr>
    		<td>Transact : </td><td><html:checkbox property="itemIn.isTrans" value="true"/></td>
    		<td>Address : </td><td colspan="3"><html:text property="itemIn.address" value="" size="70"/></td>
    	</tr>
    	<tr>
    		<td>Purchase Price : </td><td><html:text property="itemIn.purcahasPrice" value=""/></td>
    		<td>Purchase Time : </td>
    		<td><html:text property="itemIn.purchaseDatetime" value=""/></td>
    		<td>Purchase Size : </td><td><html:text property="itemIn.purchaseSize" value=""/></td>
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
    	
    	<div style="margin: 20px;"></div>
    	
    	<div align="center">
    	<fieldset  style="width: 60%;">
    	<legend> List Item </legend>
    	<display:table export="true" id="itemdata" name="requestScope.rlist" requestURI="/list.do" pagesize="10" cellpadding="5px;">
    	<display:column property="code" title="Code" sortable="true"/>
    	<display:column property="name" title="Name" sortable="true"/>
    	<display:column property="isTrans" title="Is Transfered" sortable="false"/>
    	<display:column property="purcahasPrice" title="Purchase Price" sortable="true"/>
    	<display:column property="purchaseDatetime" title="Purchase Date" sortable="true"/>
    	<display:column property="purchaseSize" title="Purchase Size" sortable="true"/>
    	<display:column property="address" title="Address" sortable="false"/>
    	<display:column property="telephone" title="Telephone" sortable="true"/>
    	<display:column title="Update/Delete" sortable="false">
    		<html:button property="" value="Update" />
    		<html:link action="/delete.do" paramName="itemInId" property="itemInId" paramProperty="itemInId">Delete</html:link>
    	</display:column>
    	</display:table>
    	</fieldset>
    	</div>
    </body>
</html:html>