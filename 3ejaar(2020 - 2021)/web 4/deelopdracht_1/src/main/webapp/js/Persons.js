window.onload = getPersons;

let getNewPersonRequest = new XMLHttpRequest();
let addNewPersonRequest = new XMLHttpRequest();

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
            setInterval(getPersons, 10000)
        }
    }
}

function addPerson(){
    let fnametext = document.getElementById("fname").value;
    let lnametext = document.getElementById("lname").value;
    let emailtext = document.getElementById("email").value;
    let GSMtext = document.getElementById("GSM").value;
    let datetext = document.getElementById("date").value;
    let roomtext = document.getElementById("room").value;

    let information =
        "fname=" + encodeURIComponent(fnametext) +
        "&lname=" + encodeURIComponent(lnametext) +
        "&email=" + encodeURIComponent(emailtext) +
        "&GSM=" + encodeURIComponent(GSMtext) +
        "&date=" + encodeURIComponent(datetext) +
        "&room=" + encodeURIComponent(roomtext);

    addNewPersonRequest.open("POST", "/Controller", true);
    addNewPersonRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded' )
    addNewPersonRequest.send(information);
    console.log("button works.");
}