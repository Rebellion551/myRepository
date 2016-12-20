<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

form {
	margin: 2em 4em;
}

form div {
	margin-bottom: 1em;
}

label {
	display: inline-block;
	width: 6em;
	text-align: right;
	margin-right: 2em;
}

input, select {
	font-size: 150%;
}

input[type=submit] {
	padding: 0 4em;
	margin-left: 6em;
}

form span {
	font-size: 80%;
	color: red;
	margin-left: 1em;
}
</style>
<title></title>
</head>

<body>
	<header>
		人力资源管理<span>编辑员工信息</span>
	</header>
	<div class="nav">
		<ul>
			<li><a href="index.jsp">员工信息</a></li>
			<li><a href="#">部门信息</a></li>
			<li><a href="#">其他</a></li>
			<li><a href="staffController_list">主页</a></li>
		</ul>
	</div>
	<div class="content">

		<form action="staffController_save" method="post">
			<div>
				<label>编号</label> <input name="id" value="${staff.id }"
					readonly="readonly"><span>只读</span>
			</div>
			<div>
				<label>姓名</label> <input name="name" value="${staff.name }"
					readonly="readonly"><span>只读</span>
			</div>
			<div>
				<label>职位</label> <select name="job">
					<option value="${staff.job }" selected="selected">${staff.job }</option>
					<option value="产品">产品</option>
					<option value="研发">研发</option>
					<option value="运营">运营</option>
					<option value="测试">测试</option>
				</select>
			</div>
			<div>
				<label>电子邮件</label> <input name="email" value="${staff.email }">
			</div>
			<div>
				<label>手机号</label> <input name="phone" value="${staff.phone }">
			</div>
			<div>
				<input type="submit" value="更新">
			</div>
		</form>

	</div>
	<footer>Copyright (c) 2016 牛耳教育 All Rights Reserved.</footer>
</body>
</html>
