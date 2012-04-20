<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��� ����</title>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script>
 $(document).ready(function(){
	 $('#my_form').validate({
		rules:{
			sPrice:{
				required:true,
				minlength:1,
				digits:true
			},
			cuPrice:{
				required:true,
				minlength:1,
				digits:true
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
				required:"���۰��� �Է��ϼ���.",
				digits:"������ �Է��ϼ���."
			},
			cuPrice:{
				required:"���簡�� �Է��ϼ���.",
				digits:"������ �Է��ϼ���."
			},
			imPrice:{
				required:"�ﱸ���� �Է��ϼ���.",
				digits:"������ �Է��ϼ���."
			},
			sTime:{
				required:"'YYYY/MM/DD HH:mm:ss'���Ŀ� �°� �Է��ϼ���.",
				date:"'YYYY/MM/DD HH:mm:ss'���Ŀ� �°� �Է��ϼ���."
			},
			eTime:{
				required:"'YYYY/MM/DD HH:mm:ss'���Ŀ� �°� �Է��ϼ���.",
				date:"'YYYY/MM/DD HH:mm:ss'���Ŀ� �°� �Է��ϼ���."
			},
			sold:{
				required:"0 �Ǵ� 1�� �Է��ϼ���",
				max:"0 �Ǵ� 1�� �Է��ϼ���",
				min:"0 �Ǵ� 1�� �Է��ϼ���"
			}
		}
 	});
		$("#editAuction").click(function (event){
				var result=confirm("��������� ���� �Ͻðڽ��ϱ�?");
			
				if(result==false){
					event.preventDefault();
				}
			});
 });
</script>
</head>
<body>
<h1 align="center">��ż���</h1>
<form action="/auction/editAuction.action" method="post" id="my_form">
		<table align="center">
		<tr>
			<td>��ǰ��ȣ</td>
			<td><input type="text" name="gNum"
				value="${AUCTION.good.gNum}"
				 readOnly="readOnly" /></td>
		</tr>

		<tr>
			<td>���۰�</td>
			<td><input type="text" name="sPrice"
				value="${AUCTION.sPrice}" /></td>
		</tr>
		<tr>
			<td>�ﱸ��</td>
			<td><input type="text" name="imPrice"
				value="${AUCTION.imPrice}" /></td>
		</tr>
		<tr>
			<td>��Ź�ȣ</td>
			<td><input type="text" name="aNum"
				value="${AUCTION.aNum}"
				readOnly="readOnly" /></td>
		</tr>
		<tr>
			<td>��Ž��۽ð�</td>
			<td><input type="text" name="sTime"
				value="${AUCTION.sTime}" /></td>
		</tr>
		<tr>
			<td>��Ÿ����ð�</td>
			<td><input type="text" name="eTime"
				value="${AUCTION.eTime}" /></td>
		</tr>
		<tr>
			<td>�Ǹſ���</td>
			<td><input type="text" name="sold"
				value="${AUCTION.sold}" /></td>
		</tr>
		<tr>
			<td>���簡��</td>
			<td><input type="text" name="cuPrice"
				value="${AUCTION.cuPrice}" /></td>
		</tr>
		<tr>
			<td>����������</td>
			<td><input type="text" name="userid" value="${AUCTION.userid }" readOnly="readOnly"/></td>
		<tr>
			<td><input type="submit" value="��ż���" id="editAuction"/></td>
			<td><input type="reset" value="�Է����" /></td>
		</tr>
	</table>
</form>

</body>
</html>