<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	</section>
	<footer></footer>

	<c:if test="${not empty script}" >
		<script type="text/javascript" src="<c:url value='/assets/js/${script}.js' />"></script>
	</c:if>

</body>
</html>