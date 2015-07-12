<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html:html>
<fmt:setBundle basename="message"/>
	<head>
		<meta charset="utf-8">
		<style type="text/css">
        	.cascading-dropdown-loading {
        		cursor: wait;
        		background: url('ajax-loader.gif') 85% center no-repeat transparent;
        	}
		</style>
        <title>List product in inventory</title>
        <link rel="stylesheet" href="./jquery-ui.css">
        <link rel="stylesheet" type="text/css" href="./bootstrap.min.css" />
		<script src="./jquery.js"></script>
		<script src="./jquery-ui.js"></script>
		<script type="text/javascript" src="./knockout-min.js"></script>
		<script src="./jquery.mockjax.js"></script>
		<script src="./joint.js"></script>
		<script src="./modelType.js"></script>
		<script src="./waterPump.js"></script>
		<script src="./accessory.js"></script>
		<script src="./filterCartridge.js"></script>
		<script src="./ajax-mocks.js"></script>
		<script src="./jquery.cascadingdropdown.js"></script>
		<script type="text/javascript">
		$(function() {$("input[name='itemIn.purchaseDatetime']").datepicker();});
		function onSell() {
			$("input[id=issell]:checked").each(function(){
				alert(this.value);
			});
		};
		$(function() {
		$('#componentsfinder').cascadingDropdown({
			selectBoxes: [
				{
					selector: '.step1',
					source: [{ label: '滤芯', value: '滤芯' },{ label: '水泵', value: '水泵' },{ label: '机型', value: '机型' },{ label: '接头', value: '接头' },{ label: '配件', value: '配件' }]
				},
				{
					selector: '.step2',
					requires: ['.step1'],
					source: function(request, response) {
						$.getJSON('/api/brands', request, function(data) {
							var selectOnlyOption = data.length <= 1;
							response($.map(data, function(item, index) {
								return {
									label: item,
									value: item,
									selected: selectOnlyOption
								};
							}));
						});
					}
				},
				{
					selector: '.step3',
					requires: ['.step1', '.step2'],
					source: function(request, response) {
						$.getJSON('/api/names', request, function(data) {
							response($.map(data, function(item, index) {
								return {
									label: item,
									value: item,
									selected: index == 0
								};
							}));
						});
					},
					onChange: function(event, value, requiredValues, requirementsMet) {
                        var type = $("#step1").val();
                        var brand = $("#step2").val();
						$("#iteminname").val(type+"-"+brand+"-"+value);
					}
				}
			]
		});
	});
	function onSell() {
		//alert("do on sell...");
		//var sellMutipleForm = document.getElementByName('sellMutipleForm');
		//alert('sellMutipleForm:'+sellMutipleForm);
	}
	</script>
    </head>
    <body>
    <h2><%=System.getProperty("path.separator")%></h2>
    	<div align="center">
    	<fieldset  style="width: 80%;">
    	<legend> <fmt:message key="title.add.item"/> </legend>
    	<html:form action="/add">
    	<table border="0" >
    	<tr id="componentsfinder" class="componentsfinder">
    		<td><fmt:message key="label.name"/> : </td>
    		<td colspan="8">
		    	<select class="step1" id="step1" name="type">
		    		<option value="">Type</option>
		   		</select>
	   			<select class="step2" id="step2" name="brand">
	   				<option value="">Brand</option>
		   		</select>
	   			<select class="step3" id="step3" name="name">
	   				<option value="">Name</option>
		   		</select>
		   		<html:text property="itemIn.name" styleId="iteminname" value=""/>
		   	</td>
    	</tr>
    	<tr>
    		<td><fmt:message key="label.istrans"/> : </td>
    		<td><html:checkbox property="itemIn.isTrans" value="true"/></td>
    		<td><fmt:message key="label.address"/> : </td>
    		<td colspan="3"><html:text property="itemIn.address" value="" size="60%"/></td>
    	</tr>
    	<tr>
    		<td><fmt:message key="label.purchase.price"/> : </td>
    		<td><html:text property="itemIn.purcahasPrice" value=""/></td>
    		<td><fmt:message key="label.purchase.time"/> : </td>
    		<td><html:text property="itemIn.purchaseDatetime" value=""/></td>
    		<td><fmt:message key="label.purchase.size"/> : </td>
    		<td><html:text property="itemIn.purchaseSize" value=""/></td>
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
    	<html:form action="/sellmutiple">
    	<fieldset  style="width: 60%;">
    	<legend> <fmt:message key="title.list.item"/> </legend>
    	<display:table export="true" id="itemdata" name="requestScope.rlist" requestURI="/list.do" pagesize="10" cellpadding="5px;">
    	<display:column titleKey="label.code" sortable="false">
    		<input type="checkbox" name="sellids" id="issell" value="<c:out value='${itemdata.itemInId }' />"/>
    	</display:column>
    	<display:column property="name" titleKey="label.name" sortable="true"/>
    	<display:column titleKey="label.istrans" sortable="false">
    		<html:checkbox name="itemdata" property="isTrans" disabled="true"/>
    	</display:column>
    	<display:column property="purcahasPrice" titleKey="label.purchase.price" sortable="true"/>
    	<display:column property="purchaseDatetime" titleKey="label.purchase.time" sortable="true"/>
    	<display:column property="purchaseSize" titleKey="label.purchase.size" sortable="true"/>
    	<display:column property="address" titleKey="label.address" sortable="false"/>
    	<display:column property="telephone" titleKey="label.telephone" sortable="true"/>
    	<display:column titleKey="label.common.button.update" sortable="false">
    		<html:link action="/update.do" paramName="itemdata" paramId="id" paramProperty="itemInId">
    			<fmt:message key="label.common.button.update"/>
    		</html:link>
    	</display:column>
    	<display:column titleKey="label.common.button.delete" sortable="false">
    		<html:link action="/delete.do" paramName="itemdata"
					   paramId="id" paramProperty="itemInId"
					   onclick="if(confirm('Are you sure?')==false)return false;">
    			<fmt:message key="label.common.button.delete"/>
    		</html:link>
    	</display:column>
    	<display:column titleKey="label.common.button.sell" sortable="false">
			<html:link action="/sell.do" paramName="itemdata" paramId="id" paramProperty="itemInId">
			<fmt:message key="label.common.button.sell"/>
			</html:link>
		</display:column>
    	</display:table>
    	</fieldset>
	    	<div>
	    		<button onclick="onSell();"><fmt:message key="label.common.button.sell"/></button>
	    	</div>
	    	</html:form>
    	</div>
    </body>
</html:html>