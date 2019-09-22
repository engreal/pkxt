<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
		
        <script language="javascript">
           function kechengAll(stu_id)
           {
                var url="<%=path %>/kecheng?type=kechengAll&stu_id="+stu_id;
                var pop=new Popup({ contentType:1,isReloadOnClose:false,width:500,height:300});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","课程选择");
	            pop.build();
	            pop.show();
           }
           
           function kechengByStu(stu_id)
           {
                var url="<%=path %>/kecheng?type=kechengByStu&stu_id="+stu_id;
                var pop=new Popup({ contentType:1,isReloadOnClose:false,width:500,height:300});
	            pop.setContent("contentUrl",url);
	            pop.setContent("title","选课管理");
	            pop.build();
	            pop.show();
           }
           
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="9" background="<%=path %>/img/tbg.gif">&nbsp;学生选课管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="11%">学号</td>
					<td width="11%">姓名</td>
					<td width="11%">性别</td>
					<td width="11%">年龄</td>
					<td width="11%">班级</td>
					<td width="12%">入学年份</td>
					<td width="11%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.stuList}" var="stu">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${stu.xuehao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${stu.name1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${stu.sex}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${stu.age}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${stu.banji_name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${stu.ruxueshijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" style="color: red" onclick="kechengByStu(${stu.id})" class="pn-loperator">查看选课</a>
						&nbsp;&nbsp;&nbsp;
						<a href="#" style="color: red" onclick="kechengAll(${stu.id})" class="pn-loperator">选课添加</a>
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
