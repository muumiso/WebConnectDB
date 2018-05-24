<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="kaiinnNo" class="java.lang.String" scope="request" />
<jsp:useBean id="kaiinnName" class="java.lang.String" scope="request" />
<jsp:useBean id="registDate" class="java.lang.String" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
検索結果 <br>
ID : <%=kaiinnNo %> <br>
名前：<%=kaiinnName %> <br>
登録日：<%=registDate %>

</body>
</html>