<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>
<head>
<title>SSH_EMP_easyui</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
<script src="easyui/jquery.min.js"></script>
<script src="easyui/jquery.easyui.min.js"></script>
<script src="easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<h2>SSH_EMP_easyui</h2>

	<div style="margin:10px,opx,0px,20px ">
		<div id="serachEmpForm" style="padding:10px">
			<div id="editEmp"></div>
		</div>
		<!-- step 1:产品列表 -->
		<div style="margin-top:10px">
			<table id="empDataGrid"></table>
		</div>
	</div>

	<script>
		// step 2: 查询 ------------------------------------------
		$("#empDataGrid").datagrid({
			url : 'empAction_list',
			title : '员工信息表',
			fitColumns : true, //自动伸缩，展开
			striped : true, //斑马线效果
			rownumbers : true, //显示行号
			columns : [ [
				{
					field : 'id',
					title : '编号',
					checkbox : true,
					align : 'center'
				},
				{
					field : 'empno',
					title : '员工编号',
					width:  80,
					sortable:true,
					align : 'center'
				},
				{
					field : 'ename',
					title : '员工姓名',
					width:  80,
					sortable:true,
					align : 'center'
				},
				{
					field : 'job',
					title : '员工职位',
					width:  80,
					sortable:true,
					align : 'center'
				},
				{
					field : 'mgr',
					title : '员工经理',
					width:  80,
					sortable:true,
					align : 'center'
				},
				{
					field : 'comm',
					title : '员工佣金',
					width:  80,
					sortable:true,
					align : 'center'
				},
				{
					field : 'hiredate',
					title : '入职日期',
					width:  80,
					sortable:true,
					align : 'center'
				},
				{
					field : 'dname',
					title : '部门名称',
					width:  80,
					sortable:true,
					align : 'center'
				},
			] ],
			toolbar:'serachEmpForm',
			pagination:true,//分页工具栏
			pageSize:10,//初始页大小
			pageList:[5,10,20,50],// 设置每页条数的列表
			sortName:'deptno',
			sortOrder:'desc'
		})
		//结束查询----------------------------------------------------------
	</script>

</body>
</html>
