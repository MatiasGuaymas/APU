program 2015parcial;
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
procedure procesarLista(l: lista; v: vecPrecios; var nomMin: string);
var
    prodActual: nProd;
    nomActual: string;
    cantProductos: integer;
    min, monto: real;
begin
    min:= 99999;
    while(l<>nil) do begin
        monto:= 0;
        cantProductos:= 0;
        prodActual:= l^.dato.num;
        nomActual:= l^.dato.nomActual;
        while(l<>nil) and (prodActual = l^.dato.num) do 
            begin
                cantProductos:= cantProductos + l^.dato.cantV;
                l:= l^.sig;
            end;
        monto:= cantProductos * v[prodActual];
        if(monto < min) then
            begin
                nomMin:= nomActual;
                min:= monto;
            end;
    end;
end;
var 
    v: vecPrecios;
    l: lista;
    nomMin: string;
begin
    l:= nil;
    cargarLista(l); //SE DISPONE
    cargarVector(v); //SE DISPONE
    nomMin = '';
    procesarLista(l, v, nomMin);
    if nomMin <> '' then writeln('El nombre de producto con el cual el comercio obtuvo mas ganancias es: ', nomMin)
    else writeln('Nadie compro productos');
end.