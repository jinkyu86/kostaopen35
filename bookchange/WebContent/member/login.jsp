<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�α���</title>
<script src="http//code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>


<script>
$(document).ready(function(){
	$('#my_form').validate({
		rules:{
			email:"required email",
				
			pw:{
				required:true,
				minlength:3
				}
			},

		messages:{
			email:{
				required:'�̸����� �Է����ּ���',
			},
			pw:{
				required:"��й�ȣ�� �Է����ּ���",
				minlength:"3���̻� �Է����ּ���"
			}
			}
		
		});
	});	
	</script>
</head>
<body>
  <h4 align="center">�α���</h4>
  <table align="center">
  
  	<form id="my_form" action="/bookchange/MemberService" method="post">
  	<input type="hidden"name="method"value="login">
	
  	    <tr>
  		<td align="center">���̵�</td>
  		<td><input type="text" name="email"/></td>
  		</tr>
  		<tr>
  		<td>��й�ȣ</td>
  		<td><input type="password" name="pw"/></td>
  		</tr>
  		<td align="center"><input type="submit" value="�α���"/></td>
  		<td align="center"><input type="reset" value="���"/></td>
  		
  	</form>	  
  </table>	
  <table align="center">
  	<tr>
		<td align="center">
		<a href="/bookchange/BoardService?method=viewBoardList">�Խù�����</a>
		</td>
	</tr>
  <tr>
  	<td>
	<a href="/bookchange/member/addmember.jsp">
  	 ȸ������</a> 
  	</td>
  	   	
   	<td><p align="center">
	${PAGE_LINK_TAG}
	</p>
   	</td>
   	
   	<td>
   	<a href="/bookchange/MemberService?method=viewMemberList">
 	ȸ����������
  	</a>
  	</td>
  </tr>	
	</table>
</body>
</html>