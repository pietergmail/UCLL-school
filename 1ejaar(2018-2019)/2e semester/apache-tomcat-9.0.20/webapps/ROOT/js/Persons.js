window.onload = getPersons;


src="/path/to/jquery.js"

let addNewPersonRequest = new XMLHttpRequest();
let deletePersonRequest = new XMLHttpRequest();
let getPersonsRequest = new XMLHttpRequest();
let logInRequest = new XMLHttpRequest();

/*old XMLHttpRequest implementation*/
function getPersons(){
    getPersonsRequest.open("GET","/Controller?command=getpersons", true);
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

            mostfrequent(persons);

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

/*function getPersons(){
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

            mostfrequent(persons);

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
    let passwordtext = document.getElementById("password").value;

    let information =
        "fname=" + encodeURIComponent(fnametext) +
        "&lname=" + encodeURIComponent(lnametext) +
        "&email=" + encodeURIComponent(emailtext) +
        "&GSM=" + encodeURIComponent(GSMtext) +
        "&date=" + encodeURIComponent(datetext) +
        "&room=" + encodeURIComponent(roomtext) +
        "&password=" + encodeURIComponent(passwordtext) +
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

function LoginPerson(){
    let emailtext = document.getElementById("Loginemail").value;
    let passwordtext = document.getElementById("Loginpassword").value;

    let information =
        "email=" + encodeURIComponent(emailtext) +
        "&password=" + encodeURIComponent(passwordtext) +
        "&command=LogIn";
    logInRequest.open("POST", "/Controller", true);
    logInRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
    logInRequest.send(information);
}

function mostfrequent(persons){
    let mf1 = 0; //default maximum frequency
    let mf2 = 0;
    let mf3 = 0;
    let m = 1;  //counter
    let item1; //to store item with maximum frequency
    let item2; //to store item with second highest frequency
    let item3; //to store item with third highest frequency


    for (let i=0; i<persons.length; i++)    //select element (current element)
    {
        for (let j=i; j<persons.length; j++)   //loop through next elements in array to compare calculate frequency of current element
        {
            if (persons[i]["room"] === persons[j]["room"])    //see if element occurs again in the array
                m++;   //increment counter if it does
            if (mf1<m)   //compare current items frequency with maximum frequency
            {

                item3 = item2;//rollback the old items
                mf3 = mf2;
                item2 = item1;
                mf2 = mf1

                mf1=m;      //if m>mf store m in mf for upcoming elements
                item1 = persons[i]["room"];   // store the current element.
            }else if (mf2<m && persons[i]["room"] !== item1){
                item3 = item2;
                mf2 = mf3;

                mf2 = m
                item2 = persons[i]["room"];
            }else if(mf3<m && persons[i]["room"] !== item2 && persons[i]["room"] !== item3){
                mf3 = m
                item3 = persons[i]["room"];
            }
        }
        m=1;   // make counter  for next element.
    }

    let a = "<p>" + item1 + "<p>" +
        "<p>" + item2 + "<p>" +
        "<p>" + item3 + "<p>";
    console.log(item1, item2, item3);
    $('#most_common').html(a);
}
