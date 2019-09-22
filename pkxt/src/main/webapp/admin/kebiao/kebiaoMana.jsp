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
		<script type='text/javascript' src='<%=path %>/dwr/interface/loginService.js'></script>
		<script type='text/javascript' src='<%=path %>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=path %>/dwr/util.js'></script>
        <script language="javascript">
           function kebiaoDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/kebiao?type=kebiaoDel&id="+id;
               }
           }
           
           function kebiaoAdd()
           {
                 var url="<%=path %>/admin/kebiao/kebiaoAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
           function p()
           {
              window.print();
           }
           
           
           var i=0;
           function banjiAll()
           {
               if(i==0)
               {
                   document.getElementById("indicator").style.display="block";
                   loginService.banjiAll(callback);
                   i=1;
               }
               
           }
           function callback(data)
           {
               document.getElementById("indicator").style.display="none";
               DWRUtil.addOptions("banji_id",data,"id","name");
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<form action="<%=path %>/kebiao?type=kebiaoSearch" name="formd" method="post">
			<table width='98%'  border='0' style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td align="left" width="60">
			          课表查询:
			    </td>
			    <td align="left" width="80">
			        <table border="0">
				           <tr> 
				               <td>  
				                  <select name="banji_id" id="banji_id" onclick="banjiAll()">
						              <option value="0">请选择班级</option>
						          </select>
				               </td>
				               <td>
				                  <img id="indicator" src="<%=path %>/img/loading.gif" style="display:none"/>
				               </td>
				           </tr>
				    </table>
			    </td>
			    <td align="left" width="60">
			          <input type="submit" value="查询"/>
			    </td>
			    <td align="left">
			    </td>
			  </tr>
		    </table>
			</form>
			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="12%">时间</td>
					<td width="12%">星期几</td>
					<td width="12%">第几节课</td>
					<td width="12%">班级</td>
					<td width="12%">课程</td>
					<td width="12%">老师</td>
					<td width="12%">教室</td>
					<td width="12%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.kebiaoList}" var="kebiao">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${kebiao.shijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kebiao.xingqi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kebiao.dijijieke}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kebiao.banji_name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kebiao.kecheng_name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kebiao.tea_name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${kebiao.jiaoshi_name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<input type="button" value="删除" onclick="kebiaoDel(${kebiao.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="kebiaoAdd()" />
			      <input type="button" value="打印" style="width: 80px;" onclick="p()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
