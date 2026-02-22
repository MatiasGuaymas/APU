program junio2019Final;
type
    venta = record 
        codeV: integer;
        codeP: integer;
        cant: integer;
    end;

    lista = ^nodo;
    nodo = record
        dato: venta;
        sig: lista;
    end;
procedure leerVenta(var v: venta);
begin
    writeln('Ingrese el codigo de venta');
    readln(v.codeV);
    if(v.codeV <> 9999) then
        begin
            writeln('Ingrese el codigo de producto');
            readln(v.codeP);
            writeln('Ingrese la cantidad vendida');
            readln(v.cant);
        end;
end;
procedure insertar(var l: lista; v: venta);
var
    aux, ant, act: lista;
begin
    new(aux); aux^.sig:= nil; aux^.dato:= v;
    if (l = nil) then l:= aux
    else
        begin
            ant:= l;
            act:= l;
            while(act <> nil) and (act^.dato.codeP < aux^.dato.codeP) do
                begin
                    ant:= act;
                    act:= act^.sig;
                end;
            if(act = l) then 
                begin
                    aux^.sig:= l;
                    l:= aux;
                end
            else
                begin
                    ant^.sig:= aux; 
                    aux^.sig:= act;
                end;
        end;
end;
procedure generarLista(var l: lista);
var
    v: venta;
begin
    leerVenta(v);
    while(v.codeV <> 9999) do
        begin
            insertar(l, v);
            leerVenta(v);
        end;
end;
procedure procesarLista(l : lista; code: integer; var cant: integer);
begin
    while(l <> nil) and (l^.dato.codeP < code) do
        l:= l^.sig;
    while(l<>nil) and (l^.dato.codeP = code) do 
        begin
            cant:= cant + l^.dato.cant;
            l:= l^.sig;
        end;
end;
var
    l: lista;
    code, cant: integer;
begin
    l:= nil;
    generarLista(l);
    writeln('Ingrese un codigo de producto');
    readln(code);
    cant:= 0;
    procesarLista(l, code, cant);
    writeln('La cantidad total del producto ', code, ' es: ', cant);
end.