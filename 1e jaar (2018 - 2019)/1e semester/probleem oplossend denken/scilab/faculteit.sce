//korte intro

function f = faculteit(getal)
    if getal==0 then
        f = 1
    else
        f = getal*faculteit(getal -1)
    end
endfunction


A = [1  2
     3  4]


//hulpfunctie: rij en kol schrappen
function N = schrap(M,rij,kol)
    N = M
    N(rij,:)=[]
    N(:,kol)=[]
endfunction

function d = detlaplace(M)
    [arij akol] = size(M)
    if arij ~= akol then
        error("matrix niet vierkant")
    end
    //matrix is dus vierkant
    if arij == 1 then
        d = M(1,1)
    else
        //recursiestap
        d = 0 //lopende som intialiseren    
        for j = 1:akol
           d = d + (-1)^(1+j)*M(1, j)*detlaplace(schrap(M,1,j))
        end 
    end
endfunction

function tijd = testdetlaplace(M)
    tic();  //druk de stopwatch in
    dummy = detlaplace(M);
    tijd = toc();
endfunction
