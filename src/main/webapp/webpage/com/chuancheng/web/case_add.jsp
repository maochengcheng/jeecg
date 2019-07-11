<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>testDemo_add</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="webCc3Controller.do?case_doAdd" >
		<input id="id" name="id" type="true" value="${casePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
			
				<tr>
					<td align="right">
						<label class="Validform_label">
							标题:
						</label>
					</td>
					<td class="value">
					
					     	 <input id="title" name="title" type="text" style="width: 150px" class="inputxt" datatype="*"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">标题</label>
						</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							状态:
						</label>
					</td>
					<td class="value">
					
					     	 <input id="status" value="" name="status" type="text" style="width: 150px" class="inputxt" datatype="*"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">状态</label>
						</td>
				</tr>

           

                 <tr>
					<td align="right">
						<label class="Validform_label">
							新闻内容:
						</label>
					</td>
					<td class="value">
								<script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.config.js"></script>
								<script type="text/javascript"  charset="utf-8" src="plug-in/ueditor/ueditor.all.min.js"></script>
						    	<textarea name="content" id="content" style="width: 450px;height:300px"></textarea>
							    <script type="text/javascript">
							        var editor = UE.getEditor('content');
							    </script>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">新闻内容</label>
						</td>
				</tr>


			</table>
		</t:formvalid>
 </body>
