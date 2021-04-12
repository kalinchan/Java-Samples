<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script defer type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script defer type="text/javascript"
	src="${pageContext.request.contextPath}/AddRow.js">
	
</script>
<style type="text/css">
.submitButton {
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

.tableDiv {
	top: 500px;
	position: absolute;
	left: 50%;
	margin-right: -50%;
	transform: translate(-50%, -50%);
}
</style>
<meta charset="UTF-8">
<title>Create</title>
</head>
<body>
	<form action="Create" method="post">
		<div class="tableDiv">
			<table id="sqlTable">
				<tr>
					<td>Table Name</td>
					<td><input type="text" name="tableName" id="tableName"
						required="required"></td>
				</tr>
				<tr>
					<td>Data Type</td>
					<td><input type="text" name="dataType1" id="dataType1"
						required="required"></td>
					<td>Name</td>
					<td><input type="text" name="name1" id="name1"
						required="required"></td>
				</tr>
			</table>
			<input type="button" id="addRow" value="Add Row"> <input
				type="hidden" value="1" id="row_count">
		</div>
		<br> <input class="submitButton" type="submit" value="Submit"><br>
	</form>
</body>
</html>