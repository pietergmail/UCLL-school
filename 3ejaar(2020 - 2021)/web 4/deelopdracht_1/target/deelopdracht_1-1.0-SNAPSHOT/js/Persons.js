window.onload = getPersons;

let getNewPersonRequest = new XMLHttpRequest();

function getPersons(){
    getNewPersonRequest.open("GET", "/Controller", true);

    getNewPersonRequest.onreadystatechange = showPersons;

    getNewPersonRequest.send();
}

function showPersons (){
    if (getNewPersonRequest.readyState == 4){
        if (getNewPersonRequest.status == 200){
            let persons = JSON.parse(getNewPersonRequest.responseText);

            console.log(persons);
            setInterval(getPersons, 10000)
        }
    }
}