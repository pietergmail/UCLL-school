<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookies - Show a Quote</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="container">
    <header>
        <h1>Show a Quote - Home</h1>
        <nav>
            <ul>
                <li><a href="Controller?command=home">Home</a></li>
                <li><a href="Controller?command=more">Read More</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <p>Lorizzle ipsizzle dolor sit pizzle, boofron adipiscing elit. Nullizzle sapien velizzle, aliquet volutpizzle,
            suscipit gizzle, pimpin' vizzle, arcu. Check it out egizzle tortor. Yippiyo erizzle. Shiznit izzle check it
            out dapibus crackalackin tempizzle you son of a bizzle. Maurizzle pellentesque nibh et my shizz. Vestibulum
            izzle tortizzle. We gonna chung you son of a bizzle izzle nisi. In owned black platea dictumst. Donec
            rizzle. Away dope shizzlin dizzle, pretium cool, mattis shizzle my nizzle crocodizzle, eleifend vitae, nunc.
            Go to hizzle suscipizzle. Daahng dawg semper velit sizzle bling bling.</p>

        <form>
            <p>Do you want to see a quote?</p>
            <p>

                <input type="radio" value="yes" name="quote" id="quoteYes">
                <label for="quoteYes">Yes</label>
                <input type="radio" value="no" name="quote" id="quoteNo">
                <label for="quoteNo">No</label>
            </p>
            <p><input type="submit" value="Send" id="submit"></p>
        </form>
       
        <blockquote cite="Jim Hightower">
            Even a dead fish can go with the flow.
        </blockquote>
        
    </main>
</div>

</body>
</html>