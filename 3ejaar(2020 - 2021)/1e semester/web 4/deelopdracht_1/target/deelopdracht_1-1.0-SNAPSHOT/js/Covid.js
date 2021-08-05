let webSocket;
let results = document.getElementsByClassName("table")

load = openSocket();

function openSocket(){
    webSocket = new WebSocket("ws://localhost:8080/echo");

    webSocket.onopen = function (event){

    };

    webSocket.onmessage = function(event){
        writeResponse(event.data);
    }

    webSocket.onclose = function(event){

    }

}

function send(){
    let Nametext = document.getElementById("name").value;
    let Datetext = document.getElementById("date").value;
    let a = Nametext + " " + Datetext;

    webSocket.send(a);
}

function closeSocket(){
    webSocket.close();
}

function writeResponse(text){
    let a = "<tr>" +
        "<td>" + text + "</td>"
    "</tr>";

    document.getElementById("tbody").innerHTML += a;

}