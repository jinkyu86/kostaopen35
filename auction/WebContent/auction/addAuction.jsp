<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addAuction</title>

<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
	 $('#my_form').validate({
		rules:{
			sPrice:{
				required:true,
				minlength:1
			},
			cuPrice:{
				required:true,
				minlength:1
			},
			imPrice:{
				required:true,
				minlength:1,
				digits:true
			},
			sTime:{
				required:true,
				date:true
			},
			eTime:{
				required:true,
				date:true
			},
			sold:{
				required:true,
				minlength:1,
				max:1,
				min:0
			}
		},
		messages:{
			sPrice:{
				required:"���۰��� �Է��ϼ���."
			},
			cuPrice:{
				required:"���簡�� �Է��ϼ���."
			},
			imPrice:{
				required:"�ﱸ���� �Է��ϼ���.",
					digits:"������ �Է��ϼ���."
			},
			sTime:{
				required:"'YYYY/MM/DD'���Ŀ� �°� �Է��ϼ���.",
				date:"'YYYY/MM/DD'���Ŀ� �°� �Է��ϼ���."
			},
			eTime:{
				required:"'YYYY/MM/DD'���Ŀ� �°� �Է��ϼ���.",
				date:"'YYYY/MM/DD'���Ŀ� �°� �Է��ϼ���."
			},
			sold:{
				required:"0 �Ǵ� 1�� �Է��ϼ���",
				max:"0 �Ǵ� 1�� �Է��ϼ��� (1 = sold, 0 = sale)",
				min:"0 �Ǵ� 1�� �Է��ϼ��� (1 = sold, 0 = sale)"
			}
		}
 	});
		$("#addAuction").click(function (event){
				var result=confirm("��ǰ ����� �Ͻðڽ��ϱ�?");
			
				if(result==false){
					event.preventDefault();
				}
			});
 });
</script>
</head>
<body>
	<h1 align="center">��ŵ��</h1>
	<form action="/auction/addAuction.action" method="post" id="my_form">
		<table>
		<tr>
		<td>��ǰ��ȣ</td>
		<td><input type ="text" name="gnum" value="${GOOD.gNum}"
				 readOnly="readOnly" /></td>
		</tr>
		<tr>
		<td>��ǰ��</td>
		<td><input type="text" name="gname" value="${GOOD.gName}" /></td>
		</tr>
		<tr>
		<td>�󼼼���</td>
		<td><textarea name="detail" >${GOOD.detail}</textarea></td>
		</tr>
		<tr>
		<td>�̹���</td>
		<td><img name="img" src="/auction/gphoto/${GOOD.img }" height="100" width="100"></td>
		</tr>
		
		<tr>
		<td>���۰�</td>
		<td><input type ="text" name="sprice" value="10" readOnly="readOnly"></td>
		</tr>
		
		<tr>
		<td>���簡��</td>
		<td><input type ="text" name="cuprice" value="10" readOnly="readOnly"></td>
		</tr>
		
		<tr>
		<td>�ﱸ��</td>
		<td><input type ="text" name="imprice"></td>
		</tr>
			
		<tr>
		<td>��Ž��۽ð�</td>
		<td><input type ="text" name="stime"></td>
		</tr>
		
		<tr>
		<td>��Ÿ����ð�</td>
		<td><input type ="text" name="etime"></td>
		</tr>
		
		<tr>
		<td>�Ǹſ���</td>
		<td><input type ="text" name="sold"></td>
		</tr>
		
		
		<tr>
			<td><input type="submit" value="��ŵ��" id="addAuction"/></td>
			<td><input type="reset" value="���"/></td>
		</tr>
	</table>
  
</form>
</body>
</html>