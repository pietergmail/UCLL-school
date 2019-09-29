
var slideIndex = 0;
window.onload = showSlides();

function  showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 4000); 
}

$(document).ready(function(){
  setInterval("speaker()", 600);
});

function speaker(){
  setTimeout("speaker1()", 100);
}
function speaker1(){
$("#waf1").addClass("animate");
$("#waf2").addClass("animate");
$("#waf3").addClass("animate");
$("#waf4").addClass("animate");
setTimeout("speaker0()", 300);
}
function speaker0(){
 $("#waf1").removeClass("animate"); 
 $("#waf2").removeClass("animate");
 $("#waf3").removeClass("animate"); 
 $("#waf4").removeClass("animate");
 $("#waf1").addClass("animate2"); 
 $("#waf2").addClass("animate2");
 $("#waf3").addClass("animate2"); 
 $("#waf4").addClass("animate2");
}
