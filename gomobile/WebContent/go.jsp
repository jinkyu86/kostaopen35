<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html >
<html lang="en">
<head >

var mobileKeyWords =
	new Array("iPhone", "iPod", "IEMobile", "Mobile", "lgtelecom", "PPC", "BlackBerry", "SCH-", "SPH-", "LG-", "CANU", "IM-" ,"EV-","Nokia")
  for (var word in mobileKeyWords){
    if (navigator.userAgent.match(mobileKeyWords[word]) != null){
      parent.window.location.href="모바일페이지 URL";
      break;
    }

  }
</script>
</head>
<body>

</body>
</html>