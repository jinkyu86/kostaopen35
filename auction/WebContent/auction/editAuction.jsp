<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>

<%@ page import="kr.or.kosta.auction.auction.Auction" %>
<%@ page import="kr.or.kosta.auction.good.Good" %>

<%
 Auction  auction= 
                 (Auction)request.getAttribute("AUCTION");
 ArrayList<Good> departmentList=
		 (ArrayList)request.getAttribute(
				 "GOOD_LIST");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
</body>	<h1 align="center">경매수정</h1>
	<table align="center">
		<form  action="/auction/AuctionService" 
		     method="post">
		     <input type="hidden" name="method" 
		        value="editAuction"/>
			<tr>
				<td>물품번호</td>
				<td>
				   <input type="text" name="gNum" 
				     value="<%= auction.getGood().getgNum()%> "
				     readOnly="readOnly"/>
				 </td>
			</tr>
		
			<tr>
				<td>시작가</td>
				<td>
					<input type="text"  name="sPrice"
					 value="<%= auction.getsPrice() %>"/>
				</td>
			</tr>
			<tr>
				<td>즉구가</td>
				<td>
					<input type="text"  name="imPrice"
					 value="<%= auction.getImPrice() %>"/>
				</td>
			</tr>
			<tr>
				<td>경매번호</td>
				<td>
					<input type="text"  name="aNum"
					 value="<%= auction.getaNum() %>"/>
				</td>
			</tr>
			<tr>
				<td>경매시작시간</td>
				<td>
					<input type="text"  name="sTime"
					 value="<%= auction.getsTime() %>"/>
				</td>
			</tr>
			<tr>
				<td>경매마감시간</td>
				<td>
					<input type="text"  name="sTime"
					 value="<%= auction.geteTime() %>"/>
				</td>
			</tr>
			<tr>
				<td>판매여부</td>
				<td>
					<input type="text"  name="sold"
					 value="<%= auction.isSold() %>"/>
				</td>
			</tr>
			<tr>
				<td>현재가격</td>
				<td>
					<input type="text"  name="cuPrice"
					 value="<%= auction.getCuPrice() %>"/>
				</td>
			</tr>
		</form>
	</table>
			<tr>
			<td>
				<input type="submit"  value="경매수정"/>
						</td>
						<td>
							<input type="reset" value="입력취소"/>
						</td>
					</tr>
</html>