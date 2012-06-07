<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>addAuction</title>

<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<c:if test="${SUCCESS!=null}">
 alert("${SUCCESS}");
</c:if>
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#my_form').validate({
			rules : {
				sPrice : {
					required : true,
					minlength : 1
				},
				cuPrice : {
					required : true,
					minlength : 1
				},
				imPrice : {
					required : true,
					minlength : 1,
					digits : true
				},
				sTime : {
					required : true,
					date : true
				},
				eTime : {
					required : true,
					date : true
				},
				sold : {
					required : true,
					minlength : 1,
					max : 1,
					min : 0
				}
			},
			messages : {
				sPrice : {
					required : "���۰��� �Է��ϼ���."
				},
				cuPrice : {
					required : "���簡�� �Է��ϼ���."
				},
				imPrice : {
					required : "�ﱸ���� �Է��ϼ���.",
					digits : "������ �Է��ϼ���."
				},
				sTime : {
					required : "'YYYY/MM/DD'���Ŀ� �°� �Է��ϼ���.",
					date : "'YYYY/MM/DD'���Ŀ� �°� �Է��ϼ���."
				},
				eTime : {
					required : "'YYYY/MM/DD'���Ŀ� �°� �Է��ϼ���.",
					date : "'YYYY/MM/DD'���Ŀ� �°� �Է��ϼ���."
				},
				sold : {
					required : "0 �Ǵ� 1�� �Է��ϼ���",
					max : "0 �Ǵ� 1�� �Է��ϼ��� (1 = sold, 0 = sale)",
					min : "0 �Ǵ� 1�� �Է��ϼ��� (1 = sold, 0 = sale)"
				}
			}
		});
		$("#addAuction").click(function(event) {
			var result = confirm("��ǰ ����� �Ͻðڽ��ϱ�?");

			if (result == false) {
				event.preventDefault();
			}
		});
	});
</script>
</head>
<body>

	<ul>
		<header>
		<h1>��Ż���Ʈ</h1>

		<ui>
		<li><c:choose>
				<c:when test="${sessionScope.MEMBER==null}">
					<p align="right">
						<a href="/auction/loginForm.action"> <font color=black>�α���</font>
						</a> <br /> <a href="/auction/addMemberForm.action"> <font
							color=black>ȸ������</font>
						</a>
					</p>
				</c:when>
				<c:otherwise>
					<p align="right">
						${sessionScope.MEMBER.name }�� �ȳ� <br /> <a
							href="/auction/logout.action"> <font color=black>�α� �ƿ�</font>
						</a> <br /> <a href="/auction/viewMember.action"> <font
							color=black>ȸ�� ����</font>
						</a>
					</p>
				</c:otherwise>
			</c:choose></li>
		</ui> </header>
	</ul>
	<nav> <!-- top nav -->
	<div class="menu">
		<ul>
			<li><a href="/auction/home.jsp">Ȩ</a></li>
			<li><a href="/auction/viewAuctionList.action"> <font
					color=white>��� ����</font>
			</a> <c:if test="${sessionScope.MEMBER.userid=='admin'}">
					<li><a href="/auction/viewGoodList.action"> <font
							color=white>��ǰ ���� ��� ����</font>
					</a></li>
					<li><a href="/auction/viewMemberList.action"> <font
							color=white>ȸ�� ��� ����</font>
					</a></li>
				</c:if>
			<li><a href="/auction/viewBoardList.action"> <font
					color=white>�Խù� ��� ����</font>
			</a></li>


		</ul>
	</div>
	</nav>
	<!-- end of top nav -->

	<section id="content">
	<p align="center"><h1 align="center">��ŵ��</h1>
	<form action="/auction/addAuction.action" method="post" id="my_form">
		<table>
			<tr>
		<td>��ǰ��ȣ</td>
		<td><input type="text" name="gnum" value="${GOOD.gNum}"
					readOnly="readOnly" /></td>
		</tr>
		<tr>
		<td>��ǰ��</td>
		<td><input type="text" name="gname" value="${GOOD.gName}" /></td>
		</tr>
		<tr>
		<td>�󼼼���</td>
		<td><textarea name="detail">${GOOD.detail}</textarea></td>
		</tr>
		<tr>
		<td>�̹���</td>
		<td><img name="img" src="/auction/gphoto/${GOOD.img }"
					height="100" width="100"></td>
		</tr>
		
		<tr>
		<td>���۰�</td>
		<td><input type="text" name="sprice" value="10"
					readOnly="readOnly"></td>
		</tr>
		
		<tr>
		<td>���簡��</td>
		<td><input type="text" name="cuprice" value="10"
					readOnly="readOnly"></td>
		</tr>
		
		<tr>
		<td>�ﱸ��</td>
		<td><input type="text" name="imprice"></td>
		</tr>
			
		<tr>
		<td>��Ž��۽ð�</td>
		<td><input type="text" name="stime"></td>
		</tr>
		
		<tr>
		<td>��Ÿ����ð�</td>
		<td><input type="text" name="etime"></td>
		</tr>
		
		<tr>
		<td>�Ǹſ���</td>
		<td><input type="text" name="sold"></td>
		</tr>
		
		
		<tr>
			<td><input type="submit" value="��ŵ��" id="addAuction" /></td>
			<td><input type="reset" value="���" /></td>
		</tr>
	</table>
  
</form>
</p>
	
	</section>			
</body>
</html>
	





