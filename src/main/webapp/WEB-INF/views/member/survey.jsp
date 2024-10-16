<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문</title>
</head>
<body>
	<jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>
	<section class="page-section" id="contact" style="margin-top: 150px">
	<div class="container mt-5">
        <h2>고객 취향 정보 입력</h2>
        <form id="preferenceForm">
            <div class="form-group">
                <label for="leisure">이름</label>
                <input name="mem_nm" type="text">
            </div>
            <c:forEach items="${qList}" var="question">
	            <div class="form-group">
	                <label for="${question.qCategory}">${question.qContent}</label>
	                <!-- 선호하는 여가 활동 -->
	                <select name="${question.qCategory}" id="${question.qCategory}">
	                <c:forEach items="${question.options}" var="option">
	                    <option value="${option.oId }">${option.oContent }</option>
	                </c:forEach>
	                </select>
	            </div>
	         </c:forEach>
            <button type="submit" class="btn btn-primary">유사 고객 찾기</button>
        </form>
        <h3 class="mt-5">추천된 유사 고객:</h3>
        <ul id="similarCustomersList" class="list-group"></ul>
    </div>
    </section>
	<script>

		$(document).ready(function(){
			$("#preferenceForm").on("submit", function(e){
                e.preventDefault();
                $.ajax({
                      type: "POST"
                     ,url:"http://localhost:5000/get_similar"
                     ,data: $(this).serialize()
                     ,success: function(res){
                        console.log(res);
                        $("#similarCustomersList").empty();
                        res.forEach(function(member){
                          $("#similarCustomersList").append('<li>'+member.mem_nm+'</li>')
                        });

                     },error:function(e){
                        console.log(e);
                     }
                });
           });
		});
	
	</script>
	<jsp:include page="/WEB-INF/inc/footer.jsp"></jsp:include>
</body>
</html>