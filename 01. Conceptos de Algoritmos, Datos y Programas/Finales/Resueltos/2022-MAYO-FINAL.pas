program mayo2022Final;
type    
    subSec = 1..10;
    producto = record
        codigo: integer;
        sector: subSec;
        descripcion: string;
        stock: integer;
        precio: real;
    end;
    lista = ^nodo;
    nodo = record
        dato: producto;
        sig: lista;
    end;
    vecSec = array [subSec] of integer;
procedure cargarLista(var l: lista); //SE DISPONE
procedure inicializarVector(var v: vecSec);
var
    i: subSec;
begin
    for i:= 1 to 10 do v[i] := 0;
end;
procedure procesarLista(l: lista; var v: vecSec);
begin
    while(l<>nil) do
        begin
            v[l^.dato.sector] := v[l^.dato.sector] + l^.dato.stock;
            l:= l^.sig;
        end;
end;
procedure procesarVector(v: vecSec; var secMax1, secMax2: subSec);
var
    i: subSec;
    max1, max2: integer;
begin
    max1:= -1;
    max2:= -2;
    for i:= 1 to 10 do
        begin
            if(v[i] > max1) then
                begin
                    max2:= max1;
                    max1:= v[i];
                    secMax2:= secMax1;
                    secMax1:= i;
                end
            else if (v[i] > max2) then
                begin
                    max2:= v[i];
                    secMax2:= i;
                end;
        end;
end;
var
    l: lista;
    v: vecSec;
begin
    l:= nil;
    cargarLista(l);
    inicializarVector(v);
    procesarLista(l, v);
    procesarVector(v, secMax1, secMax2);
    writeln(secMax1, secMax2);
end.