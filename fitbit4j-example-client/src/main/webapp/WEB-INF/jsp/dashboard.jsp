<%@page pageEncoding="UTF-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" uri="http://fitbit.com/api/layout" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="../../ui/css/common/Chart.js"></script>
<script>
    var userName=[];
    var userSteps=[];
    var userAverageSteps=[];
    var income=[];
</script>


<layout:shell>
    <%--@elvariable id="unitSystem" type="com.fitbit.api.common.model.units.UnitSystem"--%>
    <%--@elvariable id="userInfo" type="com.fitbit.api.common.model.user.UserInfo"--%>

    <c:if test="${isAuthorized}">
        <h2>Dashboard</h2>
        <div class="parag left">
        <table class="blue" id="userData">
            <%--@elvariable id="Friends" type="com.fitbit.api.common.model.leaderboard.Friends"--%>
            <c:forEach items="${Friends.friendList}" var="friend">
                <tr>
                    <td>${friend.userInfo.displayName}</td>
                    <td>${friend.summary.steps.getSteps().toString()}</td>
                    <td>${friend.average.steps.steps}</td>
                    <td>${friend.lastUpdateTime}</td>
                </tr>

            </c:forEach>

        </table>

    </c:if>



    <canvas id="buyers" width="600" height="400"></canvas>
    <!-- pie chart canvas element -->
    <canvas id="countries" width="600" height="400"></canvas>
    <!-- bar chart canvas element -->
    <canvas id="income" width="600" height="400"></canvas>

    <script type="text/javascript">

        function getIncome(userStep) {
            if(userStep>56000){
                return 0;
            }
            else {
                return Math.round(((56000-userStep)/1000));
            }
        }

        var table = document.getElementById("userData");
        for (var i = 0, row; row = table.rows[i]; i++) {
            userName[i]=row.cells[0].innerHTML
            userSteps[i]=row.cells[1].innerHTML
            userAverageSteps[i]=row.cells[2].innerHTML
            income[i] = getIncome(userSteps[i]);
        }

        var arrayLength = userAverageSteps.length;
        for (var i = 0; i < arrayLength; i++) {
            userAverageSteps[i]=userAverageSteps[i]*7;
        }


        // line chart data
        console.log(userName);
        console.log(userSteps);
        var buyerData = {
            labels : userName,
            datasets : [
                {
                    fillColor : "rgba(172,194,132,0.4)",
                    strokeColor : "#ACC26D",
                    pointColor : "#fff",
                    pointStrokeColor : "#9DB86D",
                    data : userSteps
                }
            ]
        }
        // get line chart canvas
        var buyers = document.getElementById('buyers').getContext('2d');
        // draw line chart
        new Chart(buyers).Line(buyerData);
        // bar chart data
        var barData = {
            labels : userName,
            datasets : [
                {
                    label:"$$$$$",
                    scaleLabel:"$$$$",
                    fillColor : "#48A497",
                    strokeColor : "#48A4D1",
                    data : income
                }
            ]
        }
        // get bar chart canvas
        var income = document.getElementById("income").getContext("2d");
        // draw bar chart
        new Chart(income).Bar(barData);


    </script>

</layout:shell>