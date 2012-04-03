<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원 조회</title>
<script>
	function removemember(){
		var ret;
		ret=confirm("정말 탈퇴하시겠습니까?");
		return ret;
	}
</script>
</head>
<body>
	<h1 align="center">회원 조회</h1>
<table border="1" align="center">
	  <tr>
	  <td>아이디</td><td>${MEMBER.userid}</td>
	  </tr>
	  <tr>
	  <td>비밀번호</td><td>${MEMBER.pw}</td>
	  </tr>
	  <tr>
	  <td>메일</td><td>${MEMBER.email}</td>
	  </tr>
	  <tr>
	  <td>이름</td><td>${MEMBER.name}</td>
	  </tr>
	  <tr>
	  <td>코인</td><td>${MEMBER.coin}</td>
	  </tr>
	  <tr>
	  <td>E머니</td><td>${MEMBER.emoney}</td>
	  </tr>
</table>
<br/><br/><br/>
<table border="1" align="center">
	<tr>
		<th>물품사진</th>
		<th>물품명</th>
		<th>입찰시간</th>
		<th>입찰가격</th>
	</tr>
	
	<c:forEach var="bid" items="${BID_LIST}">	
	<tr>
		<td><img src="/auction/gphoto/${bid.auction.good.img }" height="100" width="100"></td>
		<td align="center">
			<a href="/auction/AuctionService?method=viewAuction&aNum=${bid.auction.aNum }">
				${bid.auction.good.gName }
			</a>
		</td>
		<td align="center">${bid.bidTime }</td>
		<td align="center">${bid.bidPrice }</td>
	</tr>
	</c:forEach>
</table>	
	  <p align="center">
	    <a href="/auction/MemberService?method=editMemberForm&userid=${MEMBER.userid}">
	    회원수정
	    </a>
	  </p>
	  <p align="center">
	    <a href="/auction/MemberService?method=removeMember&userid=${MEMBER.userid}" onclick="removemember()">
	   회원탈퇴
	    </a>
	   </p> 
	  
	<p align="center">
	   <a href="/auction/AuctionService?method=viewAuctionList">경매목록보기</a> 
	</p>
</body>
</html>