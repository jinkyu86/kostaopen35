<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ�� ��ȸ</title>
<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<script type="text/javascript">
 <c:if test="${SUCCESS!=null}">
 alert("${SUCCESS}");
</c:if>
</script>
</head>
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script>
	$(document).ready(function(){
		
		$("#removeMemberLink").click(function (event){
			var result=confirm("ȸ��Ż���Ͻðڽ��ϱ�?");
		
			if(result==false){
				event.preventDefault();
			}
		});
	});
</script>
</head>
<body>

	<ul>
		<header>
		<p>
			<font color="black" style="font-size: 27px">��Ż���Ʈ</font>
		</p>

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
	<p align="center"><h1 align="center">ȸ�� ��ȸ</h1>
	<table border="1" align="center">
	  <tr>
	  <td>���̵�</td>
			<td>${MEMBER.userid}</td>
	  </tr>
	  <tr>
	  <td>��й�ȣ</td>
			<td>${MEMBER.pw}</td>
	  </tr>
	  <tr>
	  <td>����</td>
			<td>${MEMBER.email}</td>
	  </tr>
	  <tr>
	  <td>�̸�</td>
			<td>${MEMBER.name}</td>
	  </tr>
	  <tr>
	  <td>����</td>
			<td>${MEMBER.coin}</td>
	  </tr>
	  <tr>
	  <td>E�Ӵ�</td>
			<td>${MEMBER.emoney}</td>
	  </tr>
</table>
<br />
	<br />
	<br />
<h3 align="center">�������� ��ǰ����Ʈ</h3>
<table border="1" align="center">
	<tr>
		<th>��ǰ����</th>
		<th>��ǰ��</th>
		<th>�����ð�</th>
		<th>��������</th>
	</tr>
	
	<c:forEach var="bid" items="${BID_LIST}">	
	<tr>
		<td><img src="/auction/gphoto/${bid.auction.good.img }"
					height="100" width="100"></td>
		<td align="center">
			<a href="/auction/viewAuction.action?aNum=${bid.auction.aNum }">
				${bid.auction.good.gName }
			</a>
		</td>
		<td align="center">${bid.bidTime }</td>
		<td align="center">${bid.bidPrice }</td>
	</tr>
	</c:forEach>
</table>	
<h3 align="center">������ ��ǰ����Ʈ</h3>
<table border="1" align="center">
	<tr>
		<th>��ǰ����</th>
		<th>��ǰ��</th>
		<th>�����ð�</th>
		<th>��������</th>
	</tr>
	
	<c:forEach var="sold" items="${SOLD_LIST}">	
	<tr>
		<td><img src="/auction/gphoto/${sold.good.img }" height="100"
					width="100"></td>
		<td align="center">
			<a href="/auction/viewAuction.action?aNum=${sold.aNum }">
				${sold.good.gName }
			</a>
		</td>
		<td align="center">${sold.eTime }</td>
		<td align="center">${sold.cuPrice }</td>
	</tr>
	</c:forEach>
</table>
	  <p align="center">
	    <a href="/auction/moneyBack.action?userid=${MEMBER.userid}">
	    ������ ���� emoney�� �����ޱ�
	    </a>
	  </p>
	  <p align="center">
	    <a href="/auction/editMemberForm.action?userid=${MEMBER.userid}">
	    ȸ������
	    </a>
	  </p>
	  <p align="center">
	 
	    <a id="removeMemberLink"
			href="/auction/removeMember.action?userid=${MEMBER.userid}">
           ȸ��Ż��
		</a>
	   </p> 
	  
	<p align="center">
	   <a href="/auction/viewAuctionList.action">��Ÿ�Ϻ���</a> 
	</p>
</p>
	
	</section>			
</body>
</html>