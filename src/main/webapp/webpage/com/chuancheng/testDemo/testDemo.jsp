<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="testDemoList"  pageSize="10" checkbox="true" pagination="true" fitColumns="false" title="自定义列表查询条件" actionUrl="testDemoController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="id"  field="id" hidden="false" width="150"></t:dgCol>  
   <t:dgCol title="编号"  field="jNo" hidden="false" width="150"></t:dgCol>
   <t:dgCol title="用户名"  field="jName" hidden="false" width="150"></t:dgCol>
   <t:dgCol title="存储时间"  field="jSaveDate" formatter="yyyy-MM-dd" width="150"></t:dgCol>
   <t:dgCol title="修改时间"  field="jUpdateDate" formatter="yyyy-MM-dd" width="150"></t:dgCol>
   <t:dgCol title="农业名称"  field="jAgriTypeName" width="150"></t:dgCol>
   <t:dgCol title="分类级别"  field="jTypeId" width="150"></t:dgCol>
   <t:dgCol title="父类id"  field="jParentId" width="150"></t:dgCol>
  </t:datagrid>     
  
	  <div id="testDemoListtb" style="padding: 3px; height: 25px">
		  	 <div style="float: left;">
				  <a href="#" id="add" class="easyui-linkbutton" plain="true" icon="icon-add" onclick="add('录入','testDemoController.do?goAdd','testDemoList')">用户录入</a> 
				  <a href="#" class="easyui-linkbutton" plain="true" icon="icon-edit" onclick="update('编辑','testDemoController.do?goUpdate','testDemoList')">用户编辑</a>
			  </div>
	  		   <div align="right" class="searchColums">
	  			  用户名：<input class="inuptxt ac_input" type="text" name="jName">
	  			   农业名称：<input class="inuptxt ac_input" type="text" name="jAgriTypeName">
	  		<!-- 	 年龄：<input class="easyui-validatebox"  type="text" name="age"> -->
	  			 <a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="testDemoListsearch();">查询</a>
				 <a href="#" class="easyui-linkbutton" iconCls="icon-reload" onclick="searchReset('testDemoList')">重置</a>
	  		 </div> 
  	  </div>
 </div> 
</div>
 <script type="text/javascript">
 function testReloadPage(){
		document.location = "http://www.baidu.com"; 
	}
	function szqm(id) {
		createwindow('审核', 'testDemoController.do?doCheck&id=' + id);
	}
 	function addNewPage(id){
		addOneTab("TAB方式添加", testDemoController.do?addTab&type=table&id="+id);
	} 
	
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#testDemoListtb").find("input[name='birthday_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#testDemoListtb").find("input[name='birthday_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#testDemoListtb").find("input[name='createDate_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#testDemoListtb").find("input[name='createDate_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#testDemoListtb").find("input[name='updateDate_begin']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#testDemoListtb").find("input[name='updateDate_end']").attr("class","Wdate").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
   
 
/* //导入
function ImportXls() {
	openuploadwin('Excel导入', 'jeecgListDemoController.do?upload', "jeecgMysearchList");
}

//导出
function ExportXls() {
	JeecgExcelExport("jeecgListDemoController.do?exportXls","jeecgDemoList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("jeecgListDemoController.do?exportXlsByT","jeecgDemoList");
} */

 </script>