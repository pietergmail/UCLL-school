document.getElementById("home").addEventListener("click", homehandler, false);
document.getElementById("visitor").addEventListener("click", visitorhandler, false);


function homehandler(event) {
    let doc = event.target;
    if (doc.innerHTML.includes("+"))
        alterPoints("home", 1);
    else if (doc.innerHTML.includes("-"))
        alterPoints("home", -1);
}

function visitorhandler(event){
    let doc = event.target;
    if (doc.innerHTML.includes("+"))
        alterPoints("visitor", 1);
    else if (doc.innerHTML.includes("-"))
        alterPoints("visitor", -1);
}

function alterPoints(team, point){
    let points = document.getElementById(team + "Total");
    let oldPoints = points.innerHTML;
    points.innerHTML = ((oldPoints - 0) + point - 0);
}

function showInput(){
    setDisplay("h2", "none");
    setDisplay("change", "block");
    document.getElementById("input").placeholder = document.getElementById("h2").innerText;
    document.getElementById("input").focus();
}

function setDisplay(elementId, style){
    document.getElementById(elementId).style.display = style;
}

function updateVisitor(){
    document.getElementById("h2").innerText = document.getElementById("input").value;
    setDisplay("h2", "block");
    setDisplay("change", "none");
}

