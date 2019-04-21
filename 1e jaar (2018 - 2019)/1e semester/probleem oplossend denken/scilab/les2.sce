a=10
b=99
c=a*b

function res = gemid(a,b)
    res=(a+b)/2
endfunction

//oef: schrijf functie oef1 due kwadraad van x  berekend als x negatief is en de vierkantswortel van x als het een positief getal is
function res = oef1(a)
    if a < 0 then
        res=aa
    else
        res=sqrt(a)
    end
endfunction

//for lussen
//maakt fucntie gemiddelde die rek.gem van
//alle elementen van de vector V berekend
V=[-2,4,6.8,-12,99]
function r=gemiddeldeVector(a)
    aantal=length(a)
    som=0 
    for i=1:aantal
        som = som + a(i)
    end
    r=som/aantal
endfunction

// grootste element van vector
function gr = grootste(B)
    gr = B(1)
    for i = 2: length(B)
        if B (i) > gr then
            gr = B(i)
            end
    end
endfunction
// is even
function b = iseven(x)
    b=modulo(x,2)==0
endfunction

function r= aantaleven(V)
    aantal = 0
    for i = 1: length(V)
        if iseven(V(i)) then
            aantal = aantal + 1
        end
    end
    r=aantal
endfunction
M1 = [3,-2,5:1,0,6]
M2 = [2 -4 24
      8  0  7 
      -5 12 3
      0  6 -5]

//oef: schrijf function die rekenkundig gemiddelde van alle elementen matrix M berekent
function gem = Matrixgem(M)
    arij=size(M,"r")
    akol=size(M,"c")
    som=0
    for i=1:arij
        for j=1:akol
            som=som + M(i, j)
            printf("i: %d en j: %d\n", i, j)
       end
    end
    gem= som/(arij*akol)
endfunction
M3 = [3 -2  5
      8  9 -6
      -2 0  7]
function N = matrixmaal(A,B)
   [arij akolA] = size(A)
   [arijB akolB] = size(B)
   if arij ~= akolB then
       error("foutieve ingave")
   end
   for i=1:arij
       som = 0
       for j=1:akolB
           for k=1:akolB
            som = som + A(i,k)*B(k,j)
           end
           N(i,j)=som    
       end
   end
endfunction


p = [1  2  1
     1  1  3]
plot2d(p)
clf()
X=p(1,:)
Y=p(2,:)
plot2d(X,Y,rect=venster)

function teken(punten, kleur)
    X=punten(1,:)
    Y=punten(1,:)
    plot2d(X,Y,rect=venster, style=kleur)
    a=gca();
    a.y_location="origin";
    a.x_location="origin";
endfunction

T2 = [-1 0
      0  1]
      
P1 = T1*P

