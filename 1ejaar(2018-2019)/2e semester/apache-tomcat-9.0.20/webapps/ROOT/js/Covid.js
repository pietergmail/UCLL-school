let webSocket;

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
    let a = Nametext + "." + Datetext;//merges the 2 items to make a single object

    webSocket.send(a);
}

function closeSocket(){
    webSocket.close();
}

function writeResponse(text) {
    let array = text.split(".");//used to split the 2 items
    let a = "<tr>" +
        "<td>" + array[0] + "</td>" +
        "<td>" + array[1] + "</td>" +
        "</tr>";

    document.getElementById("tbody").innerHTML += a;

}