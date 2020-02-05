<%@ page contentType="text/html; charset=utf-8" language="java" import="java.util.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>票务信息录入</title>

<!-- jquery引入 -->
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
 $(function(){
	 alert("jquery启动");
	 
	 //给种类下拉列表赋初始值
	 $.getJSON("doint_Ticket.do",function(lsca){
		 alert(lsca.length);
		for(var i=0;i<lsca.length;i++){
			var tp=lsca[i];
			$("#type_id").append("<option value="+tp.typess_id+">"+tp.typess_name+"</option>");
		}
	 });
 });
</script>
</head>
<body>
<form action="save_Ticket.do" method="post" enctype="multipart/form-data" name="form1" id="form1">
  <table width="550" border="1" align="center" cellpadding="1" cellspacing="0">
    <tr>
      <td colspan="3" align="center" bgcolor="#FFcccc">票务信息添加</td>
    </tr>
    <tr>
      <td width="66">名称</td>
      <td width="330">
      <input type="text" name="t_name" id="t_name" /></td>
      <td width="140" rowspan="6"><img src="uppic/default.jpg" width="138" height="142" /></td>
    </tr>
    <tr>
      <td>时间</td>
      <td><input type="date" value="1990-01-01" name="t_date" id="t_date" /></td>
    </tr>
    <tr>
      <td>地址</td>
      <td><input type="text" name="t_address" id="t_address" /></td>
    </tr>
    <tr>
      <td>数量</td>
      <td><input type="text" name="t_num" id="t_num" /></td>
    </tr>
    <tr>
      <td>价格</td>
      <td><input type="text" name="t_price" id="t_price" /></td>
    </tr>
    <tr>
      <td>选择照片</td>
      <td>
      <input type="file" name="pic" id="pic" /></td>
    </tr>
    <tr>
      <td>种类</td>
      <td>
        <select name="type_id" id="type_id">
      	</select>
      
      </td>
    </tr>
    <tr>
      <td colspan="3" align="center" bgcolor="#FFFF33"><input type="submit" name="button" id="button" value="提交" />
      <input type="reset" name="button2" id="button2" value="重置" /></td>
    </tr>
  </table>
  <p align="center"><a href="ticketlistupdate.jsp">票务列表</a></p>
  <p>&nbsp;</p>
</form>
</body>
</html>