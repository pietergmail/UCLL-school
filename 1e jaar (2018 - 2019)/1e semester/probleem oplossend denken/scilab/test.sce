function y=testwhile(x)
    y=1;
    disp(y);
    while y<x
        y=y+1;
        disp(y);
    end
endfunction

function y=testfor(x)
    for y=1:x
        disp(y);
    end
endfunction

function y=verwerk(x)
    if modulo(x, 2) == 0
        if x==2
                y=1
            elseif x == 4
                y=2
            else
                y=0
        end
    
        elseif modulo(x, 3) == 0
            y = 0
        else
            y = -1
    end
endfunction

function V=facvector(x)
    if x<0; then
        disp("faculteit van negatief getal bestaat niet: de input is "+string(x))
    else
        V=zeros(1, x);
        V(1)=1;
        for i=2:x
            V(i)=V(i-1)*i;
        end
    end
endfunction

function y=maximum(V)
    y=V(1);
    for i=2: length(V)
        if V(i)>y
            y=V(i)
        end
    end
endfunction

function W=cijfers(V)
    W=[];
    for i = 1:length(V)
        if (V(i)<0)|(V(i)>9)
            disp('input mag enkel cijfers tussen 0 en 9 bevatten')
        end
    end
   
    for i=0:9
        for j=1:length(V)
            if V(j)==i
                W=[W, i]
                break
            end
        end
    end
endfunction

function [minim, maxim]=extrema(V)
    maxim=V(1)
    minim=V(1)
    for i=1 : length(V)
        if V(i)>maxim
            maxim=V(i);
        end
        if V(i)<minim
            minim=V(i)
        end
    end
endfunction

function G=euro(x)
    E=[500, 200, 100, 50, 20, 10, 5, 2, 1, 0, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01];
    G=zeros(size(E))
    for i=1 : length(E)
        G(i)=floor(x/E(i));
        x=x-G(i)*E(i);
        if G(i) ~= 0
           disp([E(i), G(i)]) 
        end
    end
    
endfunction
