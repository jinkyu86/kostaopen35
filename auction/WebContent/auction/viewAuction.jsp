<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�������</title>
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
<c:choose>
	<c:when test="${sessionScope.MEMBER==null}">
		<p align="right">
			<a href="/auction/MemberService?method=loginForm">
			�α���
			</a>
		</p>
	</c:when>
	<c:otherwise>
		<p align="right">
			${sessionScope.MEMBER.name }��<br/>
			<a href="/auction/MemberService?method=logout">
			�α׾ƿ�
			</a>
		</p>
	</c:otherwise>
</c:choose>
	<table  align="center"  border="1">
	<form action="/auction/BidService" method="post">
	<input type="hidden" name="method" value="addBid"/>
	<input type="hidden" name="aNum" value="${AUCTION.aNum }"/>
		<tr>
		<td align="center">��ǰ����</td><td align="center">��ǰ��</td><td align="center">��ñ��Ű���</td>
		<td align="center">��������</td><td align="center">��Ž��۽ð�</td>
		<td align="center">��Ÿ����ð�</td><c:if test="${AUCTION.sold=='0'}"><td>�����ϱ�</td></c:if>
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
	<c:if test="${AUCTION.sold=='0'}">
	<p align="center">
		 <p align="center">
		 <a href="/auction/BidService?method=buy&aNum=${AUCTION.aNum }" id="buy">��ñ����ϱ�</a>
	</p>
	</c:if>
	 
<c:if test="${sessionScope.MEMBER.userid=='admin'}">
	 <p align="center">
		 <p align="center">
		 <a href="/auction/AuctionService?method=editAuctionForm&aNum=${AUCTION.aNum}">������� ����</a>
	</p>
	<p align="center">
		 <a href="/auction/AuctionService?method=removeAuction&aNum=${AUCTION.aNum}" id="deleteauction">��� ����</a>
	 </p>
</c:if>

	<p align="center">
		 <p align="center">
		 <a href="/auction/AuctionService?method=viewAuctionList">��Ÿ�� ����</a>
	</p>
	
<table border="1" align="center">
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
</body>
</html>