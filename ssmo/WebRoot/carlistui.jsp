<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>SSMO Demo</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/resources/easyui/themes/icon.css" />
<script
	src="${pageContext.request.contextPath }/resources/easyui/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/easyui/jquery.easyui.min.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>
	<h1>SpringMVC - Spring - Mybatis - Oracle</h1>
	<div style="margin: 10px 30px">
	  <div id="searchCarForm" style="padding: 10px">
	    <!-- 新增 / 修改 / 删除 -->
	    <div style="margin-bottom: 10px">
	      <a href="#" class="easyui-linkbutton" 
	        iconCls="icon-add" plain="true"
          onclick="car_obj.showEdit('add')">新增</a>
        <a href="#" class="easyui-linkbutton" 
          iconCls="icon-edit" plain="true"
          onclick="car_obj.showEdit('edit')">修改</a>
        <a href="#" class="easyui-linkbutton" 
          iconCls="icon-remove" plain="true"
          onclick="car_obj.remove()">删除</a>
	    </div>
	    <div id="editCar"></div>
	    
	    <div style="padding: 0 0 0 6px">
	      <input class="easyui-textbox" id="name" size="6">
	      <input class="easyui-datebox" id="beginDate" size="10">
	      <input class="easyui-datebox" id="endDate" size="10">
	      <a href="#" class="easyui-linkbutton" iconCls="icon-search"
	        onclick="car_obj.search()">查询</a>
	    </div>
	  </div>

		<div style="margin-top: 10px">
			<table id="carDataGrid">

			</table>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			car_obj = {
			  search : function(){
				  $("#carDataGrid").datagrid("load",{
					  name : $.trim($("#name").val()),
					  beginDate : $("#beginDate").datebox('getValue'),
					  endDate : $("#endDate").datebox('getValue')
				  });
			  },
			  showEdit : function(state){
				  var url = "";
				  var info = "";
				  if(state == 'add'){
					  url = "careditui.jsp";
					  info = "新增销售汽车";
				  }else{
					  info = "修改销售汽车";
					  var rows = $("#carDataGrid").datagrid('getSelections');
					  // alert(rows.length);
					  if(rows.length == 1) {
						  url = "carui_findById?id="+rows[0].id;
					  }else{
						  $.messager.alert('警告','必需只选中一行.','warning');
						  return;
					  }
				  }
				  
				  $("#editCar").window({
					  title : info,
					  width : 600,
					  height : 550,
					  modal : true,
			      minimizable : false,
					  href : url,
					  onClose : function(){
						  $("#carDataGrid").datagrid('reload');
					  }
				  });
			  },
			  remove : function(){
				  var rows = $("#carDataGrid").datagrid('getSelections');
				  if(rows.length > 0){
					  $.messager.confirm('消息','确认真的要删除所选的数据吗?',function(flag){
						  if(flag){
							  var ids = [];
							  for(var i=0;i<rows.length;i++){
								  // 1 2 3 4 => [1 2 3 4]
								  ids.push(rows[i].id);
							  }
							  $.ajax({
								  type : 'post',
								  url : 'carui_remove',
								  // [1 2 3 4] => 1, 2, 3, 4
								  data : {ids : ids.join(",")},
								  beforeSend : function(){
									  $("#carDataGrid").datagrid('loading');
								  },
								  success : function(data){
									  if(data){
										  $("#carDataGrid").datagrid('loaded');
										  $("#carDataGrid").datagrid('load');
										  $("#carDataGrid").datagrid('unselectAll');
										  $.messager.show({
							          title : '提示',
							          msg : '删除销售汽车 '+data + ' 成功',
							        });
									  }
								  }
							  });
						  }
					  });
				  }else{
					  $.messager.alert('警告','必需选中要删除的数据.','warning');
				  }
			  }
			}
	
			$("#carDataGrid").datagrid({
				url : "carui_list",
        title : '销售汽车列表',
        fitColumns : true, 
        striped : true,    
        rownumbers : true, 
        columns:[[{ 
          field : 'id',  // field 名必需与json中的名一致
          title : '编号',
          width : 50,
          checkbox : true,
          sortable : true
        }, {
          field : 'name',
          title : '车名',
          width : 100,
          sortable : true,
        }, {
          field : 'saleDate',
          title : '销售日期',
          width : 200,
          sortable : true,
        }, {
          field : 'price',
          title : '价格',
          width : 100,
          sortable : true,
        }]], 
        toolbar : "#searchCarForm",
        pagination : true, 
        pageSize : 5,
        pageList : [5, 10, 15, 20, 50 ],
        sortName : "id", 
        sortOrder : "asc",
			});
		});
	</script>
</body>
</html>







