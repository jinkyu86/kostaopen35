<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.or.kosta.auction.auction.Auction"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>��Ÿ���Ʈ</title>
</head>
<body>

<script type="text/javascript">
	<c:if test="${ERROR!=null}">
		alert("${ERROR}");
	</c:if>
</script>

<c:choose>
	<c:when test="${sessionScope.LOGIN_MEMBER==null}">
		<p align="right">
			<a href="/auction/MemberService?method=loginForm">
			�α���
			</a>
		</p>
	</c:when>
	<c:otherwise>
		<p align="right">
			${sessionScope.LOGIN_MEMBER.name }�� �ȳ�<br/>
			<a href="/auction/MemberService?method=logout">
			�α׾ƿ�
			</a><br/>
			<a href="/auction/MemberService?method=viewMember">
			ȸ����������
			</a>
		</p>
	</c:otherwise>
</c:choose>
	<h3 align="center">�������� ��ǰ����Ʈ</h3>
	<table  align="center"  border="1">
	<th>����</th><th>��ǰ��</th><th>����</th><th>�����ð�</th><th>�󼼺���</th>
	<c:forEach var="auction" items="${AUCTION_LIST}">
	<form action="/auction/AuctionService" method="post">
	<input type="hidden" name="method" value="viewAuction"/>
	<input type="hidden" name="aNum" value="${auction.aNum }"/>
	<tr>
		<td align="center"><img src="/auction/gphoto/${auction.good.img}" width="130" height="130"></td>
		<td align="center">${auction.good.gName}</td>
		<td align="center">
			<h4>��ñ��Ű� : ${auction.imPrice }<br/></h4>
			${auction.cuPrice }
		</td>
		<td align="center">${auction.eTime }</td>
		<td align="center"><input type="submit" value="�����ϱ�"></td>
	</tr>
	</form>
	</c:forEach>
	</table>
	<p align="center">
	${PAGE_LINK_TAG}
	<br/><br/>
	
	<h3 align="center">������ ��ǰ����Ʈ</h3>
	<table  align="center"  border="1">
	<th>����</th><th>��ǰ��</th><th>����</th><th>�����ð�</th><th>�󼼺���</th>
	<c:forEach var="sold" items="${SOLD_LIST}">
	<form action="/auction/AuctionService" method="post">
	<input type="hidden" name="method" value="viewAuction"/>
	<input type="hidden" name="aNum" value="${sold.aNum }"/>
	<tr>
		<td align="center"><img src="/auction/gphoto/${sold.good.img}" width="130" height="130"></td>
		<td align="center">${sold.good.gName}</td>
		<td align="center">${sold.cuPrice }</td>
		<td align="center">${sold.eTime }</td>
		<td align="center"><input type="submit" value="�󼼺���"></td>
	</tr>
	</form>
	</c:forEach>
	</table>
<c:if test="${sessionScope.LOGIN_MEMBER.userid=='admin'}">
	<p align="center">
		<a href="/auction/AuctionService?method=addAuctionForm">����߰�</a>
		<a href="/auction/AuctionService?method=editAuctionForm">��ż���</a>	
	</p>
</c:if>
	<p align="center">
		<a href="/auction/Boardervice?method=viewBoardList">�Խ��Ǻ���</a>
	</p>
		
</body>
</html>