$(document).ready(function() {
	$('#addRow').click(
		function() {
			var new_row_count = parseInt($('#row_count').val()) + 1;
			$('#sqlTable tr:last').after("<tr><td>Data Type</td><td> <input type=\"text\" required=\"required\" name=\"dataType" + new_row_count + "\" id=\"dataType" + new_row_count + "\"></td><td>Name</td><td><input type=\"text\" required=\"required\" name=\"name" + new_row_count + "\" id=\"name" + new_row_count + "\"><br></td></tr>");
			$('#row_count').val(new_row_count);
		});
}); 