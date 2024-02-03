<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css">
    <script src="<%=request.getContextPath() %>/jquery/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">

    function loadinit()
    {
		var message = '${msg}'; 
		if(message != "")
		{
			alert(message);
		}
		
		var secureview = '${captchausing}';
		if(secureview == "y")
		{
            $(".captchaimg").css("display", "block");	
            $(".captchatxt").css("display", "block");	
            $(".captchamargin1").css("height", "10px");	
            $(".captchamargin2").css("display", "block");	
		}
    }
    
	$(function(){
        //로그인버튼 클릭
		$('#loginbtn').click( function() 
        {
			//ST 길이 유효성체크
			var inValue1=document.getElementById("userid").value;
            var inValue2=document.getElementById("userpw").value;
            
        	if(inValue1.length <= 0 ) {
                $("#userid").css("border-color","red");
                alert("아이디를 입력해주세요.");
        		return;
            }
        	else
       		{
                $("#userid").css("border-color","initial");
       		}
        	
        	if(inValue2.length <= 0 ) {
                $("#userpw").css("border-color","red")
                alert("비밀번호를 입력해주세요.");
        		return;
            }
        	else
       		{
                $("#userpw").css("border-color","initial");
       		}
        	
        	if(inValue1.length >= 17){
        		inValue1 = inValue1.substr(0,15);
        		document.getElementById("userid").value = inValue1;
        	}
        	
        	if(inValue2.length >= 20){
        		inValue2 = inValue2.substr(0,18);
        		document.getElementById("userpw").value = inValue2;
        	}
			//ED 길이 유효성체크
			
			//제출
   		    $('form#loginForm').submit();
        });
	});
    </script>
</head>
<body onload="loadinit()">
    <div class="login">
        <div class="login_left">
            <img src="<%=request.getContextPath() %>/images/lefimg.jpg" class="img1">
        </div>
        <div class="login_right">
            <form name="loginForm" id="loginForm" class="loginForm" action="loginsubmit.do" method="post">  
            <div><span style="color:green;">AAA 회사</span></div>
            <div style="height: 20px;"></div>
            <div>아이디</div><input type="text" id="userid" name="userid" placeholder="아이디" autocomplete="off"/>
            <div>비밀번호</div><input type="password" id="userpw" name="userpw" placeholder="비밀번호" autocomplete="off"/>
            <div class="captchamargin1"></div>
	        <img src="/Egov_WEB/captcha.do" class="captchaimg" alt="캡차 이미지" title="클릭시 새로고침"/>
	        <input type="text" id="captcha" class="captchatxt" name="captcha" placeholder="위에있는 글자를 입력해주세요" autocomplete="off"/>
            <div class="captchamargin2"></div>
            <input type="button" value="로그인" id="loginbtn">
            <div style="height: 20px;"></div>
            <div style="font-size:11pt;"><a href="" class="login_right_a">아이디찾기</a>/<a href="" class="login_right_a">비밀번호찾기</a>&nbsp;&nbsp;<a href="<%=request.getContextPath() %>/usercondition.do" class="login_right_a">회원가입</a></div>
        	</form>
        </div>
    </div>
</body>
</html>