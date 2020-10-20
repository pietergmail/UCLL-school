var webSocket;
var result = document.getElementById("tbody");

load = openSocket();

function openSocket(){
    webSocket = new WebSocket("ws://localhost:8080");

    webSocket.onopen = function (event){
    }
}