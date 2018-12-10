<%
session.removeAttribute("hasLogined");
response.sendRedirect("login.jsp");
%>