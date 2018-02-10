<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/fragment/taglib-includes.jspf"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<jsp:include page="../common/common.jsp" />
</head>
<body>
  <jsp:include page="../common/header.jsp" />
  <form:form modelAttribute="form" action="${pageContext.request.contextPath}/login" method="post" class="form-horizontal">
    <div class="container">
      <!-- コンテンツエリア -->
      <div class="container">
        <div class="container-main">

        <B>${dispTitle }</B>
        <br>



        </div>
      </div>
    </div>
  </form:form>
  <jsp:include page="../common/footer.jsp" />
</body>
</html>