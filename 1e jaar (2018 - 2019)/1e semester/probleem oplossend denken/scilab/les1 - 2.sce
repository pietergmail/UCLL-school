
A = [1  2
     3  4]

function d = etlaplace(M)
  //berekent determinant van de Matrix M met methode van Laplace
  //foutmelding indien niet vierkant
  [arij,akol] = size(M)
  if arij ~= akol then //nakijken of het een vierkant is
    error ("Matrix is niet vierkant")
  end
    
  if arij == 1 then //basisgeval
    d = M(1)
  else //recursiestap
    d = 0
    for i =1:arij
      d = d + M(1,i) * (-1)^(1+i) * etlaplace( chrap(M,1,i) )    
      end
   end
endfunction
    
function N = chrap (M,r,k)
  //Schrapfunctie, hoort bij Laplace
    N  = M
    N(r,:) = [ ]
    N(:,k) = [ ]  
endfunction
