program 2015parcial; //Pero con lista desordenada
const 
    PROD = 300;
type
    nProd = 1..PROD;
    venta = record
        num: nProd;
        cantV: integer;
        nombre: string;
    end;
    vecPrecios = array [nProd] of real; //SE DISPONE
    lista = ^nodo;                      //SE DISPONE
    nodo = record
        dato: venta;
        sig: lista;
    end;
procedure cargarLista(var l: lista);    //SE DISPONE
procedure cargarVector(var v: vecPrecios); //SE DISPONE
procedure inicializarV(var v2: vecPrecios);
var
    i: nProd;
begin
    for i:= 1 to PROD do 
        v2[i]:= 0;
end;
procedure procesarLista(l: lista; v, v2: vecPrecios; var nomMin: string);
var
    prodActual: nProd;
    nomActual: string;
    cantProductos: integer;
    min, monto: real;
begin
    min:= 99999;
    while(l<>nil) do begin
        v2[l^.dato.num] := v2[l^.dato.num] + l^.dato.cantV * v[l^.dato.num];
        //CONSULTAR COMO SIGO A PARTIR DE ACA, COMO GUARDO EL NOMBRE MAX?
        l:= l^.sig;
    end;
end;
var 
    v, v2: vecPrecios;
    l: lista;
    nomMin: string;
begin
    l:= nil;
    cargarLista(l); //SE DISPONE
    cargarVector(v); //SE DISPONE
    inicializarV(v2);
    nomMin = '';
    procesarLista(l, v, v2, nomMin);
    if nomMin <> '' then writeln('El nombre de producto con el cual el comercio obtuvo mas ganancias es: ', nomMin)
    else writeln('Nadie compro productos');
end.