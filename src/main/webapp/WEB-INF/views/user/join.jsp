<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>M.O.I.M</title>
<link rel="stylesheet" href="/resource/css/style.css?${millis }" />
</head>
<body>
	<div class="root">
		<c:url value="/user/join-task" var="joinTo" />
		<form action="${joinTo }" method="post" class="join-form">
			<h2>가입을 시작합니다</h2>
			<p>
				회원가입하시면 <br /> 다양한 서비스를 이용하실 수 있습니다.
			</p>
			<div style="margin: 0.2em">
				<h4 style="text-align: left; margin: 0.1em">* 사용할 아이디</h4>
				<input type="text" placeholder="아이디" name="id" />
			</div>
			<div style="margin: 0.2em">
				<h4 style="text-align: left; margin: 0.1em">* 사용할 비밀번호</h4>
				<input type="password" placeholder="비밀번호" name="pass" />
			</div>
			<div style="margin: 0.2em">
				<h4 style="text-align: left; margin: 0.1em">* 사용할 대표 닉네임</h4>
				<input type="text" placeholder="대표 닉네임" name="name" />
			</div>
			<div style="margin: 0.2em">
				<h4 style="text-align: left; margin: 0.1em">* 사용할 아바타</h4>
				<div style="display: flex; gap: 20px">
					<c:forEach items="${avatars }" var="one" varStatus="status">
						<div style="display: flex; flex-direction: column;">
							<label for="${status.count }"> <img src="${one.url }"
								style="width: 96px" />
							</label> <input type="radio" value="${one.id }" name="avatar"
								id="${status.count }" />
						</div>
					</c:forEach>
				</div>
			</div>
			<h3>* 모든 정보는 필수 기입 정보 입니다.</h3>
			<div>
				<button type="submit" class="join-btn">다음</button>
			</div>

		</form>
	</div>
</body>
</html>