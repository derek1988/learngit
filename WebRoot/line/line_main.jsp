<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ page import="java.text.*" %>
<%@ page import ="manager.*"%>
<%@ page import ="model.*" %>



  <!-- 获取数据集 -->
  <%
  	int pageNo=1;
  	int pageSize=5;
  	String pageNoString = request.getParameter("pageNo");
	if (pageNoString != null) {
		pageNo = Integer.parseInt(pageNoString);
	}
  	PageModel pageM=LineManager.findAllLine(pageNo,pageSize);
  	pageM.setPageNo(pageNo);
  	pageM.setPageSize(pageSize);
  	pageM.setTotalPages();
  
   %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'line_main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript"">  
    	function topPage(){ 
			window.self.location = "line_main.jsp?pageNo=<%=pageM.getTopPageNo()%>";
    	}   
		function prePage(){
		
			window.self.location = "line_main.jsp?pageNo=<%=pageM.getPrePageNo()%>";
    	}   
		function nextPage(){
		
			window.self.location = "line_main.jsp?pageNo=<%=pageM.getNextPageNo()%>";
    	}   
		function lastPage(){
		
			window.self.location = "line_main.jsp?pageNo=<%=pageM.getLastPageNo()%>";
    	}    
	</script>
  </head>
  


  <body>
   <h1 align="center"> 分页演示</h1>
   <br>
   <br>
   <br>
   <table width="90%" border="1" align="center" cellspacing="0" cellpadding="0">
	  	<tr bgcolor="gray">
	  		<th>
	  			<input type="checkbox" name="selectFlag" >
	  		</th>
	    	<th>ID</th>
	    	<th>线路ID</th>
	    <!--  	<th>线路名称</th> -->
	    	<th>城市ID</th>
	    	<th>乡镇ID</th>
	    	<th>计量点ID</th>
	    	<th>日期</th>
	    	<th>输入电量</th>
	    	<th>输出电量</th>
	    	<th>线损率</th>
	    	   	
	  	</tr>
	  	<%
	  		List lineList=pageM.getList();
	  		for(int i=0;i<lineList.size();i++){
	  			Line line=(Line)lineList.get(i);
	  	 %>
	  	<tr>
	  		<td>
	  			<input type="checkbox" name="selectFlag" value=<%=line.getId() %>>
	  		</td>
	    	<td><%=line.getId() %></td>
	    	<td><%=line.getLine_id() %></td>
	    <!-- 	<td><%=line.getLine_name() %></td>   -->
	    	<td><%=line.getCity_no() %></td>
	    	<td><%=line.getCounty_no() %></td>
	    	<td><%=line.getMp_id() %></td>
	    	<td><%=new SimpleDateFormat("YYYY/MM/dd HH:mm:ss").format(line.getDate_dt()) %></td>
	    	<td><%=line.getDay_in_e() %></td>
	    	<td><%=line.getDay_out_e() %></td>
	    	<td><%=line.getLine_loss() %></td>
	  	</tr>
	  	
	  	<%
	  		}
	  	 %>
	</table>
    <table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
   		<tr>
   			<td>
   				<div align="left">
   					<font >&nbsp;共 &nbsp;<%=pageM.getTotalPages() %>&nbsp;页	</font>&nbsp;&nbsp;&nbsp;&nbsp;
   					<font >&nbsp;当前第</font>
   					<font color="#FF0000"><%=pageM.getPageNo() %></font>
   					<font >页</font>
   				</div>
   			</td>
   			
   			
   			<td>
   				<div align="right">
   					<input name="btnTopPage" type="button" 
   					value="|&lt;&lt;" onClick="topPage()" title="首页">
   					
   					<input name="btnPrePage" type="button" 
   					value="&lt;" onClick="prePage()" title="前一页">
   					
   					<input name="btnNextPage" type="button"
   					value="&gt;" onClick="nextPage()" title="下一页">
   					
   					<input name="btnLastPage" type="button"
   					value="&gt;&gt;|" onClick="lastPage()" title="末页">
   				</div>
   			</td>
   		</tr>
    </table>
   
  </body>
</html>
