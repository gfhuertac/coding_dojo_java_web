<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Checkerboard assignment</title>
	<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<%!
		int getOrDefaultInteger(HttpServletRequest request, String parameter, int defaultValue) {
			int value = defaultValue;
			String parameterValue = request.getParameter(parameter);
			if (parameterValue != null) {
				value = Integer.parseInt(parameterValue);
			}
			return value;
		}
	%>

	<%
		int width = getOrDefaultInteger(request, "width", 10);
		int height = getOrDefaultInteger(request, "height", 10);
	%>
	
	<h1><%= String.format("Checkerboard: %dw x %dh", width, height) %> </h1>

	<div class="checkerboard">
	<%
		for(int i=0; i<height; ++i) {
	%>
		<div class="checkerrow"><!--
	<%
			for(int j=0; j<width; ++j) {
				String kls = "main";
				if ((i+j)%2 == 1) {
					kls = "alt";
				}
	%>
		--><div class="checkerbox <%= kls %>">&nbsp;</div><!--
	<%
			}
	%>
		--></div>
	<%
		}
	%>
	</div>

</body>
</html>