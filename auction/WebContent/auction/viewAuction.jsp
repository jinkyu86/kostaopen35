<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�������</title>
<link rel="stylesheet" href="styles.css" type="text/css" media="screen" />
<link rel="stylesheet" type="text/css" href="print.css" media="print" />
<script src="http://code.jquery.com/jquery-1.7.js"></script>
<script>
	function bid(){
		var ret;
		ret=confirm("���� �����Ͻðڽ��ϱ�?");
		return ret;
	}
	$(document).ready(function(){
		
		$("#buy").click(function (event){
			var result=confirm("�ش� ��ǰ�� ��ñ��� �Ͻðڽ��ϱ�?");
		
			if(result==false){
				event.preventDefault();
			}
		});
		$("#delete").click(function (event){
			var result=confirm("�ش� ��ǰ�� ���� �Ͻðڽ��ϱ�?");
		
			if(result==false){
				event.preventDefault();
			}
		});
	});
</script>
</head>
<body>
<script type="text/javascript">
<c:if test="${ERROR!=null}">
	alert("${ERROR}");
</c:if>
</script>
<body>

	<ul>
		<header>
			<h1>��Ż���Ʈ</h1>

			<ui>
			<li><c:choose>
					<c:when test="${sessionScope.MEMBER==null}">
						<p align="right">
							<a href="/auction/loginForm.action"> <font color=black>�α���</font>
							</a>
							<br/>
							 <a href="/auction/addMemberForm.action"> <font color=black>ȸ������</font>
							</a>
						</p>
					</c:when>
					<c:otherwise>
						<p align="right">
							${sessionScope.MEMBER.name }�� �ȳ�
							<br/> 
							<a href="/auction/logout.action"> 
							<font color=black>�α� �ƿ�</font>
							</a>
							<br/>
							<a href="/auction/viewMember.action"> 
							<font color=black>ȸ�� ����</font>
							</a>
						</p>
					</c:otherwise>
				</c:choose></li>
			</ui>
		</header>
	</ul>
	<nav>
		<!-- top nav -->
		<div class="menu">
			<ul>
				<li><a href="/auction/home.jsp">Ȩ</a></li>
				<li><a href="/auction/viewAuctionList.action"> <font
						color=white>��� ����</font>
				</a>
				
					
						<c:if test="${sessionScope.MEMBER.userid=='admin'}">
							<li><a href="/auction/viewGoodList.action"> <font color=white>��ǰ
									���� ��� ����</font>
							</a></li>
							<li><a href="/auction/viewMemberList.action"> <font color=white>ȸ��
									��� ����</font>
							</a></li>
						</c:if>
						<li><a href="/auction/viewBoardList.action"> <font color=white>�Խù�
								��� ����</font>
						</a></li>
					
				
			</ul>
		</div>
	</nav>
	<!-- end of top nav -->
	
	<section id="content">
		<p align="center">
			<table  align="center"  border="1">
	<form action="/auction/addBid.action" method="post">
	<input type="hidden" name="aNum" value="${AUCTION.aNum }"/>
		<tr>
			<th colspan="7"><h1>���� ��ǰ</h1></th>
		</tr>
		<tr>
		<td align="center">��ǰ����</td><td align="center">��ǰ��</td><td align="center">��ñ��Ű���</td>
		<td align="center">��������</td><td align="center">��Ž��۽ð�</td>
		<td align="center">��Ÿ����ð�</td>
		<c:if test="${AUCTION.sold=='0'}"><td>�����ϱ�</td></c:if>
		</tr>
		<tr>
			<td align="center"><img src="/auction/gphoto/${AUCTION.good.img}" width="130" height="130"></td>
			<td align="center">${AUCTION.good.gName}</td>
			<td align="center">${AUCTION.imPrice}</td>
			<td align="center">${AUCTION.cuPrice }</td>
			<td align="center">${AUCTION.sTime}</td>
			<td align="center">${AUCTION.eTime }</td>
			<c:if test="${AUCTION.sold=='0'}">
				<td align="center"><input type="submit" value="�����ϱ�" onclick="return bid()"></td>
			</c:if>
		</tr>
	</form>
	</table>
<ui>
	<li>
		<p align="center">
			<c:if test="${AUCTION.sold=='0'}">
				<a href="/auction/buy.action?anum=${AUCTION.aNum }" id="buy">
					<img src="/auction/menu/immediately.jpg"></a>
			</c:if>
			<c:if test="${sessionScope.MEMBER.userid=='admin'}">
				 <a href="/auction/editAuctionForm.action?anum=${AUCTION.aNum}">
				 	<img src="/auction/menu/editAuction.jpg"></a>
				 <a href="/auction/removeAuction.action?anum=${AUCTION.aNum}">
				 	<img src="/auction/menu/deleteAuction.jpg"></a>
			</c:if>
			<a href="/auction/viewAuctionList.action">
				<img src="/auction/menu/viewAuctionList.jpg"></a>
		</p>
	</li>
</ui>
<p align="center">
<table border="1" align="center">
	<tr>
		<th colspan="2"><h4>�������� ����</h4></th>
	</tr>
	<tr>
		<th>���̵�</th>
		<th>��������</th>
	</tr>
	<c:forEach var="bid" items="${BID_LIST}">	
		<tr>
			<td align="center">${bid.member.userid }</td>
			<td align="center">${bid.bidPrice }</td>
		</tr>
	</c:forEach>
</table>
	</p>
	</section>			
</body>
</html>
