<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
.deleteTable {
	top: 500px;
	position: absolute;
	left: 50%;
	margin-right: -50%;
	transform: translate(-50%, -50%);
}
</style>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>
<form action="Delete" method="post" onsubmit="return confirm('Are you sure you want to submit? This will delete the table');">
		<table class="deleteTable">
			<tr>
				<td>Table Name</td>
				<td><input type="text" name="tableName" required></td>
			</tr>
		</table>
		<input type="submit" class="submitbttn" value="Submit">
	</form>
</body>
</html>