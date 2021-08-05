window.onload = getPersons;

let addNewPersonRequest = new XMLHttpRequest();
let deletePersonRequest = new XMLHttpRequest();
let getPersonsRequest = new XMLHttpRequest();


/*old version fo getPersons()*/
function getPersons(){
    getPersonsRequest.open("GET","/Controller?command=getpersons");
    getPersonsRequest.onreadystatechange = showPersons;
    getPersonsRequest.send();
}

function showPersons(){
    if (getPersonsRequest.readyState === 4){
        if (getPersonsRequest.status === 200){
            let persons = JSON.parse(getPersonsRequest.responseText);
            let length;
            document.getElementById("tbody").innerHTML = "";
            document.getElementById("count").innerHTML = "";

            document.getElementById("count").innerHTML = "Count: " + persons.length;

            if(persons.length <= 20){
                length = persons.length;
            }else{
                length = 20;
            }
            document.getElementById("tbody").innerHTML = "";
            for (let i = 0; i < length; i++) {
                let a = "<tr>" +
                    "<td>" + persons[i]["firstName"] + "</td>" +
                    "<td>" + persons[i]["lastname"] + "</td>" +
                    "<td>" + persons[i]["date"] + "</td>" +
                    "<td>" + persons[i]["room"] + "</td>" +
                    "<td>" + persons[i]["email"] + "</td>" +
                    "<td>" + persons[i]["gsm"] + "</td>" +
                    "<td><a onclick='deleteperson(this.id)' href='#' id='"+persons[i]["firstName"]+"'>delete</a></td>" +
                    "</tr>";
                document.getElementById("tbody").innerHTML += a;
            }
        }
    }
    setInterval(getPersons, 10000)
}




/*fetch version of getPersons, should work identically
function getPersons(){
    fetch("/Controller?command=getpersons")
        .then(resp => resp.json())
        .then(function (data){
            let persons = data;
            let length;
            console.log(persons)
            document.getElementById("tbody").innerHTML = "";
            document.getElementById("count").innerHTML = "";

            document.getElementById("count").innerHTML = "Count: " + persons.length;

            if(persons.length <= 20){
                length = persons.length;
            }else{
                length = 20;
            }

            for(let i = 0; i < length; i++){
                let a = "<tr>" +
                    "<td>"+persons[i]["firstName"]+"</td>" +
                    "<td>"+persons[i]["lastname"]+"</td>" +
                    "<td>"+persons[i]["date"]+"</td>" +
                    "<td>"+persons[i]["room"]+"</td>" +
                    "<td>"+persons[i]["email"]+"</td>" +
                    "<td>"+persons[i]["gsm"]+"</td>" +
                    "<td><a onclick='deleteperson(this.id)' href='#' id='"+persons[i]["firstName"]+"'>delete</a></td>" +
                    "</tr>";
                document.getElementById("tbody").innerHTML += a;
            }
            setInterval(getPersons, 10000)
        })
}*/

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

    addNewPersonRequest.open("POST", "/Controller", true);
    addNewPersonRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded' )
    addNewPersonRequest.send(information);

}

function deleteperson(id) {
    console.log(id)
    let information =
        "id=" + id +
        "&command=delete";

    deletePersonRequest.open("POST", "/Controller", true);
    deletePersonRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    deletePersonRequest.send(information);
}
