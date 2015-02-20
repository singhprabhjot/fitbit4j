<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" uri="http://fitbit.com/api/layout" %>
<layout:shell>
    <%--@elvariable id="unitSystem" type="com.fitbit.api.common.model.units.UnitSystem"--%>
    <%--@elvariable id="userInfo" type="com.fitbit.api.common.model.user.UserInfo"--%>

    <c:if test="${isAuthorized}">
        <h2>Dashboard</h2>
        <div class="parag left">
        <table class="blue">
            <%--@elvariable id="Friends" type="com.fitbit.api.common.model.leaderboard.Friends"--%>
            <c:forEach items="${Friends.friendList}" var="friend">
                <tr>
                    <td>${friend.userInfo.displayName}</td>
                    <td>${friend.summary.steps.getSteps().toString()}</td>
                </tr>

            </c:forEach>

        </table>

    </c:if>
</layout:shell>