<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html >
<html lang="en">
<head >
<script type="text/javascript">
var mobileKeyWords =
	new Array("iPhone", "iPod", "IEMobile", "Mobile", "lgtelecom", "PPC", "BlackBerry", "SCH-", "SPH-", "LG-", "CANU", "IM-" ,"EV-","Nokia")
  for (var word in mobileKeyWords){
    if (navigator.userAgent.match(mobileKeyWords[word]) != null){
      parent.window.location.href="/gomobile/mobile.jsp";
      break;
    }
  }
   
</script>
</head>
<body>
	<h1>go.jsp입니다.</h1>
</body>
</html>