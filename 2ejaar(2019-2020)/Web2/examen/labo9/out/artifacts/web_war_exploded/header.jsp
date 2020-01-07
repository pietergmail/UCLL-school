<header>
    <h1>
        <span>Web shop</span>
    </h1>
    <nav>
        <ul>
            <li ${param.page eq 'Home'?'id="actual"':""}>
                <a href="Controller">Home</a></li>
            <li ${param.page eq 'Product Overview'?'id="actual"':''}>
                <a href="Controller?command=overview">Overview</a>
            </li>
            <li id="cart"><a href="Controller?command=cart">Shopping Cart</a></li>
        </ul>
    </nav>
    <h2>${param.page}</h2>
</header>