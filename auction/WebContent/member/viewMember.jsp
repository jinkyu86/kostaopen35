<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ�� ��ȸ</title>
<script>
	function removemember(){
		var ret;
		ret=confirm("���� Ż���Ͻðڽ��ϱ�?");
		return ret;
	}
</script>
</head>
<body>
	<h1 align="center">ȸ�� ��ȸ</h1>
<table border="1" align="center">
	  <tr>
	  <td>���̵�</td><td>${MEMBER.userid}</td>
	  </tr>
	  <tr>
	  <td>��й�ȣ</td><td>${MEMBER.pw}</td>
	  </tr>
	  <tr>
	  <td>����</td><td>${MEMBER.email}</td>
	  </tr>
	  <tr>
	  <td>�̸�</td><td>${MEMBER.name}</td>
	  </tr>
	  <tr>
	  <td>����</td><td>${MEMBER.coin}</td>
	  </tr>
	  <tr>
	  <td>E�Ӵ�</td><td>${MEMBER.emoney}</td>
	  </tr>
</table>
<br/><br/><br/>
<table border="1" align="center">
	<tr>
		<th>��ǰ����</th>
		<th>��ǰ��</th>
		<th>�����ð�</th>
		<th>��������</th>
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
	    ȸ������
	    </a>
	  </p>
	  <p align="center">
	    <a href="/auction/MemberService?method=removeMember&userid=${MEMBER.userid}" onclick="removemember()">
	   ȸ��Ż��
	    </a>
	   </p> 
	  
	<p align="center">
	   <a href="/auction/AuctionService?method=viewAuctionList">��Ÿ�Ϻ���</a> 
	</p>
</body>
</html>