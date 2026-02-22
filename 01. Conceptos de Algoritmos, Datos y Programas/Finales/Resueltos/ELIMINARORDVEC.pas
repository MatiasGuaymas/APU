{Eliminar de un vector elementos ordenado los elementos con codigo 5
[1] [2] [3] [4] [4] [5] [5] [6] [7] [8] [9] [10] [] [] []

[1] [2] [3] [4] [4] [5] [5] [5] [5] [7] [8] [9] [] [] []

[1] [2] [3] [4] [4] [4] [4] [4] [4] [4] [8] [9] [] [] []

mientras la pos sea menor a la dimension logica y el codigo en el que estoy 
parado es menor a 5 avanzo
si sali y pos es mas grande que diml o el codigo en el que estoy parado es 
distinto de 5 no lo encontre
si lo encontre devuelvo un ok y la posicion donde lo encontre
cuento la cantidad, mientras esa posicion mas chica que la dimension logica
y el codigo donde estoy parado es igual a 5 sumo 1 pos y 1 cant
voy desde pos a diml - cant y en pos guardo v[pos] = v[pos+cant]

posicion 6 
cantidad 2 
diml 12

voy desde 6 a 10 = se ejecuta 5 veces
en la 6 guardo lo que hay en la 8
en la 7 guardo lo que hay en la 9
en la 8 guardo lo que hay en la 10
en la 9 guardo lo que hay en la 11 
en la 10 guardo lo que hay en la 12
diml - cantidad = 10}
program eliminar;
procedure eliminarEficienteVecOrd(var v: vector; var diml: integer; valor: integer);
var
    pos,cant, i: integer;
begin
    pos:= 1;
    cant:= 0;
    while(pos <= diml) and (v[pos].dni < 5) do
        pos:= pos + 1;
    if(pos > diml) or (v[pos].dni <> 5) then
        begin
            ok:= false;
            posEncontrada:= 0;
        end
    else
        begin
            ok:= true;
            posEncontrada:= pos;
        end;
    if (ok) then
        begin
            while(pos <= diml) and (v[pos].code = valor) do begin
                cant:= cant+1;
                pos:= pos+1;
            end;
        end;
        for i:= pos to (diml - cant) do
            v[i] = v[i+cant];
end;