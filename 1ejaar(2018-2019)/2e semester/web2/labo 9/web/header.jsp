<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>
<header>
    <h1><span>Web shop</span></h1>
    <nav>
        <ul>
            <li ${param.page == 'index'? 'id="actual"':""} ><a href="Controller">Home</a></li>
            <li ${param.page == 'overview'? 'id="actual"':""}><a href="Controller?command=overview">Overview</a></li>
            <li ${param.page == 'add'? 'id="actual"':""}><a href="Controller?command=add">Add Product</a></li>
        </ul>
    </nav>


</header>