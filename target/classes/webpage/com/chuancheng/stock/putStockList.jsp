<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="putStockList"  pageSize="10" checkbox="true" pagination="true" fitColumns="false" 
         queryMode="group" title="库存入库管理" actionUrl="stockBillController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="id"  field="id" hidden="false" width="150"></t:dgCol>  
   <t:dgCol title="编号"  field="billNo" hidden="false" width="150"></t:dgCol>
   <t:dgCol title="农产品分类"  field="productType" hidden="false" width="150" query="true" ></t:dgCol>
   <t:dgCol title="农产品名称"  field="productName" hidden="false" width="150" query="true" ></t:dgCol>
   <t:dgCol title="重量"  field="weight" width="150"></t:dgCol>
   <t:dgCol title="入库人工号"  field="createBy" width="150"></t:dgCol>
   <t:dgCol title="入库人"  field="createName" width="150"></t:dgCol>
   <t:dgCol title="状态"  field="status" width="150"></t:dgCol>
   <t:dgCol title="存储时间"  field="createTime" formatter="yyyy-MM-dd" width="150"></t:dgCol>
   
   <t:dgToolBar title="入库登记" icon="icon-add" url="stockBillController.do?putStock_goAdd" funname="add" width="770" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="stockBillController.do?putStock_goUpdate" funname="update" width="770"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="stockBillController.do?putStock_doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="预出库"  icon="icon-edit" url="stockBillController.do?putStock_doBatchUpdate" funname="putStock_doBatchUpdate"></t:dgToolBar>
  <t:dgToolBar operationCode="print" title="打印" icon="icon-print" url="jeecgListDemoController.do?print" funname="detail" width="610" height="330"></t:dgToolBar>
  <t:dgToolBar  title="加载百度" icon="icon-print" url="#" funname="testReloadPage"></t:dgToolBar>
  </t:datagrid>     
  
	
 </div> 
</div>
 <script type="text/javascript">
 function putStock_doBatchUpdate(title,url,id){
	 var rowData = $('#'+id).datagrid('getSelections');
	 if (rowData == undefined || rowData.length <=0 ) {
	 tip('请选择编辑项目');
	 return;
	 }
	 alert(rowData);
	 alert(rowData.length);
	 url += '&id='+rowData.id;
	 
	 $.dialog({
	 content: "url:"+url,
	 lock : true,
	 title:"JS增强编辑",
	 opacity : 0.3,
	 width:300,
	 height:200,
	 cache:false,
	  ok: function(){
	 iframe = this.iframe.contentWindow;
	  iframe.goForm();
	 return false;
	 },
	  cancelVal: '关闭',
	  cancel: true /*为true等价于function(){}*/
	 });
	 
	 
	 
	 
	 $(function(){
			//设置一个全局变量来控制弹出框关闭
			var bClose=false;
			//弹出框的属性设置
			$("#myDlg").dialog({
				modal: true,
				closable: true,
				closed: true,
				buttons: '#myDlg-buttons',
				onBeforeClose:function(){//关闭弹出框之前动作-弹出提示
			            	if (!bClose) {  
			                    $.messager.confirm("提醒", "确定关闭该窗口?",function (r) {  
			    					if (r) {  
			    						bClose = true;//标记可以退出  
			    						$("#myDlg").dialog("close");  
			                         }  
			                 	});  
			    			}
			            	return bClose;  //通过全局变量来控制是否关闭窗口  
			   	}
			});
			//弹出框打开
			$('#myDlg-openBtn').click(function(){
				//先设置为false;
				bClose=false;
				$('#myDlg').dialog("open");
			});
			
			//点击保存,假定保存成功
			$('#myDlg-saveBtn').click(function(){
				$.messager.alert("提示信息","操作成功!","info");
				//这里在后面加true,将会绕过onBeforeClose事件,弹出框直接关闭
				$('#myDlg').dialog("close",true);
			});
			
			//点击关闭
			$('#myDlg-closeBtn').click(function(){
				$('#myDlg').dialog("close");
			});
			
		})

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

 }
 
 function statusFmt(value, row, index){  
		if (value != null && value != '') 
			return '<span style="color:green;font-size: 16px;">✔</span>';
		return '<span style="color:red;font-size: 16px;">x</span>';
	} 

	//列表字段颜色 demo,逻辑判断函数 
	function fmtype(val,row,index){
	    //可添加更多CSS样式
	    var s1 = 'background-color:#f89406;color:#FFF;';
	    var s2 = 'background-color:#3a87ad;color:#FFF;';
	    var s3 = 'background-color:#21B9BB;';
	    if (val =='1') {
	        return s1
	    }
	    if (val =='0') {
	        return s2
	    }
	    return s3
	}
function testReloadPage(){
		document.location = "http://www.baidu.com"; 
	}
	function szqm(id) {
		createwindow('审核入职', 'jeecgListDemoController.do?goCheck&id=' + id,420,280);
	}
	function addNewPage(id){
		addOneTab("TAB方式添加", "jeecgListDemoController.do?addTab&type=table&id="+id);
	}
	
function addWithbtn(title,addurl,gname,width,height){
	//createdetailwindow("添加", addurl,770);
	openwindow("添加",addurl,gname,770,500);
	
}

//单元格的格式化函数  value：字段的值 row：行的记录数据 index：行的索引
function formatAgeFun(age,row,index){
	var str="原："+age+",现 ："+(Number(age)+20);
	return str;
}


//打开tab页面
function addbytab(){
	addOneTab("添加表单", "jeecgListDemoController.do?addWithbtn");
}

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'jeecgListDemoController.do?upload', "jeecgDemoList");
}

//导出
function ExportXls() {
	JeecgExcelExport("jeecgListDemoController.do?exportXls","jeecgDemoList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("jeecgListDemoController.do?exportXlsByT","jeecgDemoList");
}
function createwindow_form(title, addurl,width,height) {
	//width = width?width:700;
	//height = height?height:400;
	//if(width=="100%" || height=="100%"){
	//	width = window.top.document.body.offsetWidth;
	//	height =window.top.document.body.offsetHeight-100;
	//}
	width = window.top.document.body.offsetWidth;
	height = window.top.document.body.offsetHeight-100;
	if(typeof(windowapi) == 'undefined'){
		$.dialog({
			content: 'url:'+addurl,
			lock : true,
			zIndex: getzIndex(),
			width:width,
			height:height,
			title:title,
			opacity : 0.3,
			cache:false,
		    cancelVal: '',
		    cancel: true /*为true等价于function(){}*/
		});
	}else{
		W.$.dialog({
			content: 'url:'+addurl,
			lock : true,
			width:width,
			zIndex:getzIndex(),
			height:height,
			parent:windowapi,
			title:title,
			opacity : 0.3,
			cache:false,
		    cancelVal: '',
		    cancel: true /*为true等价于function(){}*/
		});
	}
}

 </script>