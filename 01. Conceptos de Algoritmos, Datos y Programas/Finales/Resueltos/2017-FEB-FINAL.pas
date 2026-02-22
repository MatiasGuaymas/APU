program 2017Final;
type
    subInm = 1..4;
    inmueble = record
        codigo: integer;
        tipo: subInm;
        due: integer;
        inq: integer;
        precio: real;
    end;
    lista = ^nodo;
    nodo = record
        dato: inmueble;
        sig: lista;
    end;
procedure leerI(var i: inmueble);
begin
    readln(i.codigo);
    if(i.codigo <> 999) then
        begin
            readln(i.tipo);
            readln(i.due);
            readln(i.inq);
            readln(i.precio);
        end;
end;
procedure insertar(var l: lista; i: informe);
var
    act, ant, aux: lista;
begin
    new(aux); aux^.sig:= nil; aux^.dato:= i;
    if(l = nil) then l:= aux
    else
        begin
            ant:= l; act:= l;
            while(act<>nil) and (act^.dato.due < aux^.dato.due) do
                begin
                    ant:= act;
                    act:= act^.sig;
                end;
        end;
    if(act = l) then
        begin
           aux^.sig:= l; l:= aux;
        end;
    else
        begin
            ant^.sig:= aux; aux^.sig:= act;
        end;
end;
procedure cargarLista(var l: lista);
var
    i: inmueble;
begin
    leerI(i);
    while (i.codigo <> 999) do
        begin
            insertar(l,i);
            leerI(i);
        end;
end;
procedure procesarLista(l: lista; var precioProm: real);
var
    cantInm, cantDepto, dniActual: integer;
    precioP: real;
begin
    precioP:= 0;
    cantDepto:= 0;
    while(l <> nil) do
        begin
            cantInm:= 0
            dniActual:= l^.dato.due;
            while(l <> nil) and (dniActual = l^.dato.due) do
                begin
                    if(l^.dato.precio > 5000) then
                        cantInm:= cantInm + 1;
                    if(l^.dato.tipo = 2) then
                        begin
                            cantDepto:= cantDepto + 1;
                            precioP:= precioP + l^.dato.precio;
                        end;
                    l:= l^.sig;
                end;
            writeln('Para el duenio con DNI: ', dniActual, ' la cantidad de inmuebles que tuvo alquilados es/son: ', cantInm);
        end;
    precioProm:= precioP / cantDepto;
var
    l: lista;
    precioProm: real;
begin
    precioProm:= 0;
    l:= nil;
    cargarLista(l);
    procesarLista(l, precioProm);
    writeln('El precio de alquiler promedio de aquellos inmuebles tipo demartamento es: ', precioProm);
end.