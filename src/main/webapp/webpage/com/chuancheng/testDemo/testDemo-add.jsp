<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>testDemo_add</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="testDemoController.do?doAdd" >
		<input id="id" name="id" type="hidden" value="${testDemoPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="jNo" name="jNo" type="text" style="width: 150px" class="inputxt"  datatype="d"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">编号</label>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户名:
						</label>
					</td>
					<td class="value">
					
					     	 <input id="jName" name="jName" type="text" style="width: 150px" class="inputxt" datatype="*"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户名</label>
						</td>
				</tr>
				<!-- <td class="value"> -->
				<tr>
					<td align="right">
						<label class="Validform_label">
							存储时间:
						</label>
					</td>
					<td class="value">
							   <input id="jSaveDate" name="jSaveDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()" 
					      						/>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">存储时间</label>
						</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							修改时间:
						</label>
					</td>
					<td class="value">
							   <input id="jUpdateDate" name="jUpdateDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()" 
					      						/>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">修改时间</label>
						</td>
				</tr>
				
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							农业名称:
						</label>
					</td>
					<td class="value">
					
					     	 <input id="jAgriTypeName" value="" name="jAgriTypeName" type="text" style="width: 150px" class="inputxt" datatype="*"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">农业名称</label>
						</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							分类级别:
						</label>
					</td>
					<td class="value">
					
					     	 <input id="jTypeId" value="" name="jTypeId" type="text" style="width: 150px" class="inputxt" datatype="d"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">分类级别</label>
						</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							父类id:
						</label>
					</td>
					<td class="value">
					
					     	 <input id="jParentId" value="" name="jParentId" type="text" style="width: 150px" class="inputxt" datatype="d"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">父类id</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
