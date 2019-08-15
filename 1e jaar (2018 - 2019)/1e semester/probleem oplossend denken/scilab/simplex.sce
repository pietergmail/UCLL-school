M = [1, 1, 1, 0, 0, 0, 18;
     2, 1, 0, 1, 0, 0, 32;
     1, 3, 0, 0, 1, 0, 36;
     -16, -14, 0, 0, 0, 1, 0
    ]
    
A = [1, -1, 2;
     6,  2, 3;
     3, -2, 4]
    
B = [0, 7, 8, 0, 0;
     0, 0, 1, 0, 0;
     1, 5, 9, 0, 0;
     2, 3, 7, 1, 3;
     4, 1, 6, 0, 1]
    
//simplexmethode standaard vorm
function N = pivoteer(M,prij,pkol)
  N = M
  pivot = M(prij,pkol)
  N(prij,:) = M(prij,:)/pivot
  for i = 1:size(M,'r')
     if i~=prij then //// sla over
         N(i,:) = M(i,:) - M(i,pkol) * N(prij,:)
     end
  end
endfunction

//Methode van Laplace
function d = detlaplace(M)
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
         d = d + M(1,i) * (-1)^(1+i) * detlaplace( schrap(M,1,i) )    
      end
   end
endfunction

function N = schrap (M,r,k)
  //Schrapfunctie, hoort bij Laplace
    N  = M
    N(r,:) = [ ]
    N(:,k) = [ ]  
endfunction 
