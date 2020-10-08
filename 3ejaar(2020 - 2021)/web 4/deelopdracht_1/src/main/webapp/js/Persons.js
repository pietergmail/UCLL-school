window.onload = getPersons;

let getNewPersonRequest = new XMLHttpRequest();

function getPersons(){
    //console.log("this is data so javascript works i hope")
    getNewPersonRequest.open("GET", "/Controller", true);

    getNewPersonRequest.onreadystatechange = showPersons;

    getNewPersonRequest.send();
}

function showPersons (){
    //console.log("does it reach the person request?")
    if (getNewPersonRequest.readyState === 4){
        if (getNewPersonRequest.status === 200){
            //console.log("it does")

            let persons = JSON.parse(getNewPersonRequest.responseText);
            console.log(persons)
            document.getElementById("tbody").innerHTML = "";
            for(let i = 0; i < persons.length; i++){
                let a = "<tr>" +
                    "<td>"+persons[i]["firstName"]+"</td>" +
                    "<td>"+persons[i]["lastname"]+"</td>" +
                    "<td>"+persons[i]["date"]+"</td>" +
                    "<td>"+persons[i]["room"]+"</td>" +
                    "<td>"+persons[i]["email"]+"</td>" +
                    "<td>"+persons[i]["gsm"]+"</td>" +
                    "</tr>";
                document.getElementById("tbody").innerHTML += a;
            }
            console.log(persons);
            setInterval(getPersons, 10000)
        }else{
            //console.log("status error: " + getNewPersonRequest.status)
        }
    }else{
        //console.log("ready error: " + getNewPersonRequest.readyState)
    }
}