<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style media="screen">
* {
	margin: 0;
	padding: 0;
}

header {
	padding: 1em 0;
	text-align: center;
	background-color: #69c;
	color: #fff;
	font-size: 300%;
}

header span {
	font-size: 50%;
	margin-left: 1em;
	color: #eee;
}

footer {
	position: absolute;
	bottom: 0;
	padding: 2em 0;
	text-align: center;
	background-color: #69c;
	color: #fff;
	width: 100%;
	clear: both;
}

.content {
	width: 75%;
	overflow: auto;
	float: right;
	min-height: 300px;
}

.nav {
	float: left;
	background-color: #eee;
	width: 25%;
	position: fixed;
	height: 100%;
	overflow: auto;
}

ul {
	list-style-type: none;
	margin-top: 1em;
}

li a {
	display: block;
	color: #000;
	padding: 8px 0 8px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #69c;
	color: white;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 2m auto;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #cfc;
}
</style>
<title>人力资源管理</title>
</head>

<body>
	<header>
		人力资源管理<span>员工信息列表</span>
	</header>
	<div class="nav">
		<ul>
			<li><a href="new.jsp">添加员工</a></li>
			<li><a href="#">部门信息</a></li>
			<li><a href="#">其他</a></li>
			<li><a href="staffController_list">主页</a></li>
		</ul>
	</div>
	<div class="content">
		<table>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>职位</th>
				<th>电话</th>
				<th>电子邮件</th>
				<th>编辑</th>
				<th>删除</th>
			</tr>
			<c:forEach var="staff" items="${requestScope.staffs }">
				<tr>
					<td>${ staff.id}</td>
					<td>${ staff.name}</td>
					<td>${ staff.job}</td>
					<td>${ staff.phone}</td>
					<td>${ staff.email}</td>
					<td>
						<form action="staffController_findById" method="post">
							<input type="hidden" name="id" value="${ staff.id}"> <input
								type="submit" value="编辑">
						</form>
					</td>
					<td>
						<form action="staffController_remove" method="post">
							<input type="hidden" name="id" value="${ staff.id}"> <input
								type="submit" value="删除">
						</form>
					</td>
				</tr>
			</c:forEach>

		</table>

	</div>
	<footer>Copyright (c) 2016 牛耳教育 All Rights Reserved.</footer>
</body>
</html>
