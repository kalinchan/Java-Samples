<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update table</title>
<style type="text/css">
.submitbttn {
	display: block;
	width: 100%;
	border: none;
	background-color: #4CAF50;
	color: white;
	padding: 14px 28px;
	font-size: 16px;
	cursor: pointer;
	text-align: center;
	bottom: 5%;
	position: absolute;
}
.updateTable {
	top: 500px;
	position: absolute;
	left: 50%;
	margin-right: -50%;
	transform: translate(-50%, -50%);
}
</style>
</head>
<body>
	<!-- Get table name  what column they want to update and where -->
	<form action="Update" method="post">
		<table class="updateTable">
			<tr>
				<td>Table Name</td>
				<td><input type="text" name="tableName" required></td>
			</tr>
			<tr>
				<td>Column Name</td>
				<td><input type="text" name="columnName" required></td>
				<td>New Value</td>
				<td><input type="text" name="newValue" required></td>
			</tr>
		</table>
		<input type="submit" class="submitbttn" value="Submit">
	</form>
</body>
</html>