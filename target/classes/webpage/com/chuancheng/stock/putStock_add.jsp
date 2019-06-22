<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>testDemo_add</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="stockBillController.do?puStock_doAdd" >
		<input id="id" name="id" type="hidden" value="${putStockPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="billNo" name="billNo" type="text" style="width: 150px" class="inputxt"  />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">编号</label>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							农产品分类:
						</label>
					</td>
					<td class="value">
					
					     	 <input id="productTyppe" value="" name="productType" type="text" style="width: 150px" class="inputxt" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">农产品分类</label>
						</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							农产品:
						</label>
					</td>
					<td class="value">
					
					     	 <input id="productName" name="productName" type="text" style="width: 150px" class="inputxt" datatype="*"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">农产品</label>
						</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							重量:
						</label>
					</td>
					<td class="value">
					
					     	 <input id="weight" value="0" name="weight" type="text" style="width: 150px" class="inputxt" datatype="d"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">重量</label>
						</td>
				</tr>
				
				
				<!-- <td class="value"> -->
				<!-- <tr>
					<td align="right">
						<label class="Validform_label">
							存储时间:
						</label>
					</td>
					<td class="value">
							   <input id="createTime" name="createTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()" 
					      						/>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">存储时间</label>
						</td>
				</tr> -->
				
				
				
				

			</table>
		</t:formvalid>
 </body>
