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
<body background="/auction/gphoto/mina2.jpg">

<script type="text/javascript">
	<c:if test="${ERROR!=null}">
		alert("${ERROR}");
	</c:if>
</script>

<ui>
	<li>
		<c:choose>
			<c:when test="${sessionScope.MEMBER==null}">
				<p align="right">
					<a href="/auction/MemberService?method=loginForm">
					<img src="/auction/menu/login.jpg"/>
					</a></br>
					<a href="/auction/MemberService?method=addMemberForm">
					<img src="/auction/menu/join.jpg"/>
					</a>
				</p>
			</c:when>
		<c:otherwise>
		<p align="right">
			${sessionScope.MEMBER.name }�� �ȳ�<br/>
			<a href="/auction/MemberService?method=logout">
				<img src="/auction/menu/logout.jpg"/>
			</a></br>
			<a href="/auction/MemberService?method=viewMember">
				<img src="/auction/menu/memberInfo.jpg"/>
			</a>
		</p>
		</c:otherwise>
		</c:choose>
	</li>
	<li>
		<p align="center">
			<c:if test="${sessionScope.MEMBER.userid=='admin'}">
				<a href="/auction/GoodService?method=viewGoodList">
					<img src="/auction/menu/viewGoodList.jpg"/>
				</a>
				<a href="/auction/MemberService?method=viewMemberList">
					<img src="/auction/menu/viewMemberList.jpg"/>
				</a>
			</c:if>
				<a href="/auction/BoardService?method=viewBoardList">
					<img src="/auction/menu/viewBoardList.jpg"/>
				</a>
		</p>
	</li>
</ui>

	<table  align="center"  border="1" bgcolor="pink">
	<tr>
		<th colspan="5"><h3>�������� ��ǰ����Ʈ</h3></th>
	</tr>
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
	<br/><br/>
	
	<table  align="center"  border="1" bgcolor="pink">
	<tr>
		<th colspan="5"><h3>������ ��ǰ����Ʈ</h3></th>
	</tr>
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
</body>
</html>