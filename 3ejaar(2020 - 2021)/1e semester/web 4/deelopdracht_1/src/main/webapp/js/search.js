let searchPersonRequest = new XMLHttpRequest();
let getPersonsRequest = new XMLHttpRequest();

function searchPersons(){
    let Datetext = document.getElementById("Date").value;
    let Roomtext = document.getElementById("Room").value;
    let information =
        "room=" + encodeURIComponent(Roomtext) +
        "&date=" + encodeURIComponent(Datetext) +
        "&command=search";

    searchPersonRequest.open("POST", "/Controller");
    searchPersonRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded' );
    searchPersonRequest.onreadystatechange = showPersons;
    searchPersonRequest.send(information)
}

function showPersons(){
    if (searchPersonRequest.readyState === 4) {
        if (searchPersonRequest.status === 200) {
            let persons = JSON.parse(searchPersonRequest.responseText);
            document.getElementById("tbody").innerHTML = "";
            for (let i = 0; i < persons.length; i++) {
                let a = "<tr>" +
                    "<td>" + persons[i]["firstName"] + "</td>" +
                    "<td>" + persons[i]["lastname"] + "</td>" +
                    "<td>" + persons[i]["date"] + "</td>" +
                    "<td>" + persons[i]["room"] + "</td>" +
                    "<td>" + persons[i]["email"] + "</td>" +
                    "<td>" + persons[i]["gsm"] + "</td>" +
                    "</tr>";
                document.getElementById("tbody").innerHTML += a;
            }
        }
    }
}
