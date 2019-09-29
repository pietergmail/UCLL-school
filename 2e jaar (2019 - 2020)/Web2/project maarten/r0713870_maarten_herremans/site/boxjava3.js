$(document).ready(function(){

    $("#bat").click(function(){
        $("#boxklein30").addClass("boxklein0");
        $("#uitleg30").addClass("uitleg0");    
        $("#boxklein20").addClass("boxklein0");
        $("#uitleg20").addClass("uitleg0"); 
        $("#boxklein40").addClass("vid0");
        $("#uitleg40").addClass("uitleg0"); 
        
        $("#boxklein0").removeClass();
        $("#uitleg0").removeClass();   
        $("#boxklein0").addClass("boxklein");
        $("#uitleg0").addClass("uitleg");         
        
        $("#long").removeClass(); 
        $("#cine").removeClass(); 
        $("#bat2").removeClass();
        $("#bat").addClass("bord1");  
    });


    $("#bat2").click(function(){
        $("#boxklein0").addClass("boxklein0");
        $("#uitleg0").addClass("uitleg0");    
        $("#boxklein30").addClass("boxklein0");
        $("#uitleg30").addClass("uitleg0"); 
        $("#boxklein40").addClass("vid0");
        $("#uitleg40").addClass("uitleg0"); 

        $("#boxklein20").removeClass();
        $("#uitleg20").removeClass();   
        $("#boxklein20").addClass("boxklein");
        $("#uitleg20").addClass("uitleg");   
        
        $("#bat").removeClass();
        $("#long").removeClass();
        $("#cine").removeClass(); 
        $("#bat2").addClass("bord1");  
    });

    $("#cine").click(function(){
        $("#boxklein0").addClass("boxklein0");
        $("#uitleg0").addClass("uitleg0"); 
        $("#boxklein20").addClass("boxklein0");
        $("#uitleg20").addClass("uitleg0");  
        $("#boxklein40").addClass("vid0");
        $("#uitleg40").addClass("uitleg0"); 

        $("#boxklein30").removeClass();
        $("#uitleg30").removeClass();  
        $("#boxklein30").addClass("boxklein");
        $("#uitleg30").addClass("uitleg");         
        
        $("#long").removeClass();
        $("#bat").removeClass();
        $("#bat2").removeClass();
        $("#cine").addClass("bord1");  
    });

    $("#long").click(function(){
        $("#boxklein0").addClass("boxklein0");
        $("#uitleg0").addClass("uitleg0"); 
        $("#boxklein30").addClass("boxklein0");
        $("#uitleg30").addClass("uitleg0");  
        $("#boxklein20").addClass("boxklein0");
        $("#uitleg20").addClass("uitleg0");  

        $("#boxklein40").removeClass();
        $("#uitleg40").removeClass();   
        $("#boxklein40").addClass("vid");
        $("#uitleg40").addClass("uitleg");         
        
        $("#bat2").removeClass(); 
        $("#cine").removeClass(); 
        $("#bat").removeClass();
        $("#long").addClass("bord1");  

    });
});