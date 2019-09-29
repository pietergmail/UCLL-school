
onload = function(){
var slider = document.getElementById("myRange");
var output = document.getElementById("prijs");
output.innerHTML = slider.value;

slider.oninput = function() {
  output.innerHTML = this.value;
}
}

function validateForm() {
  var x =  document.getElementById("voornaam").value;
  if (x == "") {
    document.getElementById("fout").style.visibility='visible'
    return false;
  }
  var x1 = document.getElementById("achternaam").value;
  if (x1 == "") {
    document.getElementById("fout").style.visibility='visible'
    return false;
  }
  var x2 = document.getElementById("hoogte").value;
  if (x2 == "") {
    document.getElementById("fout").style.visibility='visible'
    return false;
  }
  var x3 = document.getElementById("diepte").value;
  if (x3 == "") {
    document.getElementById("fout").style.visibility='visible'
    return false;
  }
  var x4 = document.getElementById("breedtes").value;
  if (x4 == "") {
    document.getElementById("fout").style.visibility='visible'
    return false;
  }

}




