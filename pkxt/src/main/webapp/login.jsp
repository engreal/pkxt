<%@ page language="java" import="com.dao.DB" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page language="java" import="com.orm.TAdmin, java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>

<body>
<script type="text/javascript">

    function tiao() {
        <c:if test="${sessionScope.userType==0}">
        window.location.href = "<%=path %>/admin/index.jsp";
        </c:if>
        <c:if test="${sessionScope.userType==1}">
        window.location.href = "<%=path %>/ayuangong/index.jsp";
        </c:if>
    }

    setTimeout(tiao, 10)
</script>
<br> <br> <br> <br> <br> <br> <br> <br> <br>
<center><img src="<%=path %>/img/loading.gif">页面跳转中</center>
<%
    //    if (session.getAttribute("userType") == null) {
//        loginService login = new loginService();
//        login.login("admin", "admin", 0);
//    }
    String sql = "select * from t_admin where username=? and userpw=?";
    Object[] params = {"admin", "admin"};
    DB db = new DB();
    try (Connection connection = db.getCon()) {
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setObject(1, params[0]);
            ps.setObject(2, params[1]);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    TAdmin admin = new TAdmin();
                    admin.setUserId(rs.getInt("userid"));
                    admin.setUserName(rs.getString("username"));
                    admin.setUserPw(rs.getString("userpw"));
                    session.setAttribute("userType", 0);
                    session.setAttribute("admin", admin);
                }
            }
        }
    }
    request.getRequestDispatcher("/admin/index.jsp").forward(request,response);
%>
</body>
</html>
