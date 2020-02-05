<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<!-- jquery引入 -->
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript">
 $(function(){
	 $("#form2").attr('style','display:none');
	 //显示列表的方法
	
	 showAll();
 });
 /*************显示列表************************/
  var page=1;
  var rows=5;
  var maxpage=1;
  function showAll(){
	  //使用Ajax获取后台op=5数据
	  $.getJSON("findPageAll_Ticket.do?page="+page+"&rows="+rows,function(JsonPageBean){
		  page=JsonPageBean.page;
		  rows=JsonPageBean.rows;
		  maxpage=JsonPageBean.maxpage;
		  var tablehead="<table width='640' height='400' bgcolor='#ffcccc' align='center' border='1'>"
		                +"<tr>"
		                +"<td>编号</td>"
		                +"<td>名称</td>"
		                +"<td>时间</td>"
		                +"<td>地址</td>"
		                +"<td>数量</td>"
		                +"<td>价格</td>"
		                +"<td>图片</td>"
		                +"<td>种类</td>"
		                +"<td>操作</td>"
		                +"</tr>"
		  var trs="";
		   for(var i=0;i<JsonPageBean.pagelist.length;i++){
			   var tk=JsonPageBean.pagelist[i];
			  trs+="<tr>"
               +"<td>"+tk.t_id+"</td>"
               +"<td>"+tk.t_name+"</td>"
               +"<td>"+tk.t_date+"</td>"
               +"<td>"+tk.t_address+"</td>"
               +"<td>"+tk.t_num+"</td>"
               +"<td>"+tk.t_price+"</td>"
               +"<td><a href=uppic/"+tk.t_fname+"><img src=uppic/"+tk.t_fname+" width='100' height='100' alt='图片不存在'></a></td>"
               +"<td>"+tk.typess_name+"</td>"
               +"<td><input type='button' id='btdelete' name='btdelete' value='删除' onclick='deleteById("+tk.t_id+")'/><input type='button' id='btedit' name='btedit' value='编辑' onclick='dofindById("+tk.t_id+")'></td>"
               +"</tr>"
		   } 
		   var tableend=tablehead+trs+"</table>";
		   //将值设置到div
		   $("#mytable").html(tableend);
		   //给分页组件赋值
		   $("#rows").val(rows);
		   $("#page").val(page);
		   $("#pagetable").html(page+"/"+maxpage);
		   //
		   if(page==1&&maxpage==1){//总一页(全隐藏)
			   $("#btup").attr('disabled',true);
			   $("#btfirst").attr('disabled',true);
			   $("#btnext").attr('disabled',true);
			   $("#btlast").attr('disabled',true); 
		   }
		   if(page==1){//第一页（隐藏前两个）
			   $("#btup").attr('disabled',true);
			   $("#btfirst").attr('disabled',true);
		   }
		   if(page==1&&maxpage>1){//第一页（释放后两个）
			   $("#btnext").attr('disabled',false);
			   $("#btlast").attr('disabled',false); 
		   }
		   if(page>1&&page<maxpage){//中间页（全释放）
			   $("#btup").attr('disabled',false);
			   $("#btfirst").attr('disabled',false);
			   $("#btnext").attr('disabled',false);
			   $("#btlast").attr('disabled',false); 
		   }
		   if(page==maxpage&&page>1){//最后一页（隐藏后两个，释放前两个）
			   $("#btnext").attr('disabled',true);
			   $("#btlast").attr('disabled',true); 
			   $("#btup").attr('disabled',false);
			   $("#btfirst").attr('disabled',false);
		   }
	  });
  }
 /*************显示列表end*********************/
 /*************分页组件*********************/
   $(function(){
	   $("#btfirst").click(function(){
		   page=1;
		 
		   showAll();
	   });
	   $("#btup").click(function(){
		   page=page-1;
		   if(page<1){
			   page=1;
		   }
		   showAll();
	   });
	   $("#btnext").click(function(){
		   page=page+1;
		   if(page>maxpage){
			   page=maxpage;
		   }
		   
		   showAll();
	   });
	   $("#btlast").click(function(){
			  page=maxpage;
		      showAll();
	   });
	   //更改每页记录数
	   $("#btchaneRows").click(function(){
			var rowsval=$("#rows").val();
			if(isNaN(rowsval)){
				alert("请输入正确数字");
				$("#rows").val(rows);
				return;
			}
		   rows=rowsval;
		      showAll();
	   });
	   //更改页数
	   $("#btchanePage").click(function(){
			var pageval=$("#page").val();
			if(isNaN(pageval)){
				alert("请输入正确数字");
				$("#page").val(page);
				return;
			}
		   page=pageval;
		      showAll();
	   });
   });
 /*************分页组件end******************/
 /*************删除******************/
 function deleteById(t_id){
	 if(window.confirm('是否删除编号为'+t_id+'的数据')){
		 $.get('delById_Ticket.do?t_id='+t_id,function(code){
			 if(code=='1'){
				 alert("删除成功");
				 showAll();
			 }else{
				 alert("删除失败"); 
			 }
		 });
	 };
 }
 /*************删除end***************/
  /*************查询单个******************/
 function dofindById(t_id){
	 alert("33333333");
	 $.getJSON('findById_Ticket.do?t_id='+t_id,function(oldtk){
		 //给表单赋值
		 $("#t_id").val(oldtk.t_id);
		 $("#t_date").val(oldtk.t_date);
		 $("#t_name").val(oldtk.t_name);
		 $("#t_address").val(oldtk.t_address);
		 $("#t_num").val(oldtk.t_num);
		 $("#t_price").val(oldtk.t_price);
		 //处理图片
		 $("#aa").attr('href','uppic/'+oldtk.t_fname);
		 $("#imgg").attr('src','uppic/'+oldtk.t_fname);
		 //处理种类下拉列表
		 typesstest(oldtk.type_id);
	 });
 }
 //处理种类下拉列表
 function typesstest(typess_id){
	 $.getJSON("doint_Ticket.do",function(litp){
		 alert(litp.length);
		for(var i=0;i<litp.length;i++){
			var tp=litp[i];
			$("#type_id").append("<option value="+tp.typess_id+">"+tp.typess_name+"</option>");
		}
		$("#type_id").val(typess_id);
		 $("#form2").attr('style','display:block');
	 });
 }
 /*************查询单个end***************/
 /*************修改******************/
 $(function(){
	 $("#btupdate").click(function(){
		 var t_id=$("#t_id").val();
		 var t_name=$("#t_name").val();
		 var t_date=$("#t_date").val();
		 var t_address=$("#t_address").val();
		 var t_num=$("#t_num").val();
		 var t_price=$("#t_price").val();
		 var type_id=$("#type_id").val();
		 var t_fname=$("#imgg")[0].src;
		 var jsondate={
				 't_id':t_id,
				 't_name':t_name,
				 't_date':t_date,
				 't_address':t_address,
				 't_num':t_num,
				 't_price':t_price,
				 'type_id':type_id,
				 't_fname':t_fname	 
		 }
		 $.get('Update_Ticket.do',jsondate,function(code){
			 if(code=='1'){
				 alert("修改成功");
				 $("#form2").attr('style','display:none');
				 showAll();
			 }else{
				 alert("修改失败"); 
			 }
		 });
		 
	 });
 });
 /*************修改end***************/
</script>

</head>
<body>
<p align="center">票务信息列表</p>
<hr/>
<div id="mytable"></div>
<!-- 分页 -->
<form action="" id="form1" name="form1">
<table width="640" align="center" border="1" bgcolor="#FFCCCC" cellspacing="0">
<tr align="center">
  <td>
   <input type="button" name="btfirst" id="btfirst" value="首页">  
  </td>
  <td>
   <input type="button" name="btup" id="btup" value="上一页">
  </td>
  <td>
   <input type="button" name="btnext" id="btnext" value="下一页">
  </td>
  <td>
   <input type="button" name="btlast" id="btlast" value="尾页">
  </td>
  <td>跳转
 <input type="text" name="page" size="2" id="page"> 
  页
  <input type="button" name="btchanePage" id="btchanePage" value="确定">
  </td>
  <td>每页 
 <input type="text" name="rows" size="2"  id="rows"> 
 记录
  <input type="button" name="btchaneRows" id="btchaneRows" value="确定"> 
  </td>
  <td>
  <div id="pagetable"></div>
  </td>
</tr>
</table>
</form>
<hr/>
<!-- 修改页面 -->
<form id="form2" name="form2">
<table width="500" height="400" align="center" border="1">
  <tr bgcolor="#ffcccc" align="center">
  <td colspan="3">票务信息修改</td>
  </tr>
  <tr>
  <td width="100">名称</td>
  <td width="200">
  <input type="text" name="t_name" id="t_name">
  </td>
  <td rowspan="4">
  <a id="aa" href="">
  <img id="imgg" alt="图片不存在" src="" width="200" height="220">
  </a>
  </td>
  </tr>
  <tr>
  <td>时间</td>
  <td>
   <input type="date" name="t_date" id="t_date">
  </td>
  </tr>
  <tr>
  <td>地点</td>
  <td>
  <input type="text" name="t_address" id="t_address">
  </td>
  </tr>
  <tr>
  <td>数量</td>
  <td>
  <input type="text" name="t_num" id="t_num">
  </td>
  </tr>
  <tr>
  <td>价格</td>
  <td>
  <input type="text" name="t_price" id="t_price">
  </td>
  </tr>
  <tr>
  <td>种类</td>
  <td>
  <select name="type_id" id="type_id">
  </select>
  </td>
  </tr>
  <tr>
      <td>选择照片</td>
      <td>
        <input type="file" name="pic" id="pic" /></td>
  </tr>
  <tr bgcolor="#ffcccc"  align="center">
  <td colspan="3">
  <input type="hidden" name="tid" id="tid">
  <input type="hidden" name="op" id="op" value="2">
  <input type="button" id="btupdate" value="提交">
  <input type="reset" value="重置">
  </td>
  </tr>
</table>
</form>
<p align="center"><a href="ticketadd.jsp">返回添加</a></p>
</body>
</html>