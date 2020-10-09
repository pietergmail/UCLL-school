let searchPersonRequest = new XMLHttpRequest();

function searchPersons(){
    let Datetext = document.getElementById("Date").value;
    let Roomtext = document.getElementById("Room").value;
    let information =
        "room=" + encodeURIComponent(Roomtext) +
        "&date=" + encodeURIComponent(Datetext);

    searchPersonRequest.open("POST", "/Controller", true);
    searchPersonRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded' )
    searchPersonRequest.send(information)
}