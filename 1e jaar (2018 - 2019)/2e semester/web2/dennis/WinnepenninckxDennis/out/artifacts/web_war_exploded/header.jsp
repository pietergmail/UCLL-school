<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <h1>
        <img src="images/bikesBanner.png" alt="banner My Bikes">
    </h1>

    <nav class="nav">
        <ul>
            <li ${param.page == 'index'? 'id="actual"':""} ><a href="Servlet?command=home">Home</a></li>
            <li ${param.page == 'overview'? 'id="actual"':""} ><a href="Servlet?command=overview">Overview</a></li>
            <li ${param.page == 'add'? 'id="actual"':""} ><a href="Servlet?command=add">add</a></li>
            <c:if test="${brief== 'Nieuwsbrief'}" >
                <c:choose>
                    <c:when test="${param.page == 'brief'}" >
                        <li id="actual"><a href="Servlet?command=niewsbrief">niewsbrief</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="Servlet?command=niewsbrief">niewsbrief</a></li>
                    </c:otherwise>
                </c:choose>
            </c:if>
        </ul>
    </nav>
</header>