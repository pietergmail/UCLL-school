<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <nav>
        <ul>
            <li id=${param.page == "index"?'actual':''}><a href="Controller?command=home">Home</a></li>
            <c:if test="${person.role == 'Admin'}">
            <li id=${param.page == "personenOverview"?'actual':''} ><a href="Controller?command=overview">Overview</a></li>
            </c:if>
            <li id=${param.page == "signup"?'actual':''}><a href="Controller?command=signUp">Sign up</a></li>
            <c:if test="${person.role == 'Admin'}">
            <li id=${param.page == "activiteiten"?'actual':''}><a href="Controller?command=activiteiten">Activiteiten</a></li>
            </c:if>
            <li id=${param.page == "productenOverview"?'actual':''}><a href="Controller?command=producten">Producten</a></li>
            <c:if test="${person.role == 'Admin'}">
            <li id=${param.page == "addProduct"?'actual':''}><a href="Controller?command=addProducten">add Product</a></li>
            </c:if>
            <c:if test="${person.role!=null}">
            <li id=${param.page == "cart"?'actual':''}><a href="Controller?command=cart">My Cart</a></li>
            </c:if>
        </ul>
    </nav>

