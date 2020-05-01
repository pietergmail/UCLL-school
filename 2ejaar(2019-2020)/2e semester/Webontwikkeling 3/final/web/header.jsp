<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <nav>
        <ul>
            <li id=${param.page == "index"?'actual':''}><a href="Controller?command=home">Home</a></li>
            <li id=${param.page == "personenOverview"?'actual':''} ><a href="Controller?command=overview">Overview</a></li>
            <li id=${param.page == "signup"?'actual':''}><a href="Controller?command=signUp">Sign up</a></li>
            <li id=${param.page == "activiteiten"?'actual':''}><a href="Controller?command=activiteiten">Activiteiten</a></li>
            <li id=${param.page == "productenOverview"?'actual':''}><a href="Controller?command=producten">Producten</a></li>
            <li id=${param.page == "addProduct"?'actual':''}><a href="Controller?command=addProducten">add Product</a></li>
            <li id=${param.page == "cart"?'actual':''}><a href="Controller?command=cart">My Cart</a></li>
        </ul>
    </nav>
