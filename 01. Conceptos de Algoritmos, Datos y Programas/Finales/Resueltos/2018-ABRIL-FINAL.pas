program abril2018;
type
    subCode = 100..200;
    venta = record
        codeVenta: integer;
        codeProd: subCode;
        cantVend: integer;
    end;
    lista = ^nodo;
    nodo = record
        dato: venta;
        sig: lista;
    end;
    vecPrecios = array [subCode] of real;
procedure leerV(var v: venta);
begin
    readln(v.codeVenta)
    if(v.codeVenta<>-1) then
        begin
            readln(v.codeProd);
            readln(v.cantVend);
        end;
end;
procedure insertar(var l: lista; v: venta);
var
    ant, act, aux: lista;
begin
    new(aux); aux^.sig:= nil; aux^.dato:= v;
    if(l=nil) then l:= aux
    else
    begin
        ant:= l;
        act:= l;
        while(act <> nil) and (act^.dato.codeProd < aux^.dato.codeProd) do
            begin
                ant:= act;
                act:= act^.sig;
            end;
        if(act = l) then
            begin
                aux^.sig:= l; l:= aux;
            end
        else
            begin
                ant^.sig:= aux;
                aux^.sig:= act;
            end;
    end;
end;
procedure generarLista(var l : lista);
var
    v: venta;
begin
    leerV(v);
    while(v.codeVenta <> -1) do
        begin
            insertar(l, v);
            leerV(v);
        end;
end;
procedure procesarLista(l: lista, v: vecPrecios);
var
    prodActual: integer;
    monto: real;
begin
    while(l<>nil) do
        begin
            prodActual:= l^.dato.codeProd;
            monto:= 0;
            while(l<>nil) and (prodActual = l^.dato.codeProd) do
                begin
                    monto:= monto + (l^.dato.cantVend * v[l^.dato.prodActual]);
                    l:= l^.sig;
                end;
            writeln('Para el producto ', prodActual, ' se recaudo: ', monto);
        end;
end;
var
    l: lista;
    v: vecPrecios;
begin
    generarLista(l);
    cargarVector(v);
    procesarLista(l, v);
end.