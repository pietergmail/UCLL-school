window.onload = getPersons;

let getNewPersonRequest = new XMLHttpRequest();
let addNewPersonRequest = new XMLHttpRequest();

function getPersons(){
    //let information = "command=getpersons";
    //console.log("this is data so javascript works i hope")
    fetch("/Controller?command=getpersons")
        .then(resp => resp.json())
        .then(function (data){
            let persons = data;
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
            setInterval(getPersons, 10000)
        })
    /*getNewPersonRequest.open("GET", "/Controller" + "?" + "command=getpersons", true);
    getNewPersonRequest.onreadystatechange = showPersons;
    getNewPersonRequest.send();*/
}

function showPersons (data){
    //console.log("does it reach the person request?")

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
        "&room=" + encodeURIComponent(roomtext) +
        "&command=addperson";

    fetch

    addNewPersonRequest.open("POST", "/Controller", true);
    addNewPersonRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded' )
    addNewPersonRequest.send(information);
}