program junio2017;
type
    subN= 0..100;
    subN2= 1..100;
    vecContador = array [subN2] of subN;
procedure inicializarVector(var v: vecContador);
var
    i: subN2;
begin
    for i:= 1 to 100 do 
        v[i]:= 0;
end;
procedure procesarNumeros(var v: vecContador);
var
    num: subN;
begin
    readln(num);
    while(num <> 0) do
        begin
            v[num] := v[num] + 1;
            readln(num);
        end;
end;
procedure informar(v: vecContador);
var
    i: subN2;
begin
    for i:= 1 to 100 do
        writeln(i, ' = ', v[i]);
end;
var
    v: vecContador;
begin
    inicializarVector(v);
    procesarNumeros(v);
    informar(v);
end.