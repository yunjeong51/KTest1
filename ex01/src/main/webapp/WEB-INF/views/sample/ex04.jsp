<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Model이라는 데이터 전달자로 전달한 게 아니고 자바빈즈로 수집된 데이터
자동으로 전달되는 거 확인합니다. <br>
샘플 DTO는 자바빈즈로 수집되었기 때문에 자동전달 값 확인: ${sampleDTO }
page는 int값이니까 전달 안된다. |값확인: ${page }
</body>
</html>