window.onload = getPersonsRoom;

let RoomCountRequest = new XMLHttpRequest();

function getPersonsRoom() {
    RoomCountRequest.open("GET", "/Controller?command=getpersons", true);
    RoomCountRequest.send();
    if (RoomCountRequest.readyState === 4) {
        if (RoomCountRequest.status === 200) {
            let persons = JSON.parse(RoomCountRequest.responseText);
            console.log(persons)
            document.getElementById("count_rooms").innerHTML = "";

            let CE102 = 0;
            let CE103 = 0;
            let CE104 = 0;
            let Ct = 0;
            for (let i=0; i<persons.length; i++){
                if(persons[i]["room"] === "E102"){
                    CE102 += 1;
                }
                if(persons[i]["room"] === "E103"){
                    CE103 += 1;
                }
                if(persons[i]["room"] === "E104"){
                    CE104 += 1;
                }
                if(persons[i]["room"] === "t"){
                    Ct += 1;
                }
            }

            let a = "<p> E102: " + CE102 + "</p>" +
                "<p> E103: " + CE103 + "</p>" +
                "<p> E104: " + CE104 + "</p>" +
                "<p> t: " + Ct + "</p>";
            document.getElementById("count_rooms").innerHTML = a;
        }
        setInterval(getPersonsRoom, 1000)
    }
}
