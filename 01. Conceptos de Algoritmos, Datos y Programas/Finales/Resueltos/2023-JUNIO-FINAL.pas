program junio2023Final;
type
    ventas = record
        codigo: integer;
        dni: integer;
        fecha: string;
        cant: integer;
        precio: real;
    end;
    lista = ^nodo;
    nodo = record
        dato: ventas;
        sig: lista;
    end;
    comprador = record
        dni: integer;
        cantTotal: integer;
        montoTotal: real;
    end;
    lista2 = ^nodo;
    nodo = record
        dato: comprador;
        sig: lista2;
    end;
procedure cargarLista(var l: lista); // SE DISPONE
procedure agregarAdelante(var l: lista2; c: comprador);
var
    aux: lista2;
begin
    new(aux); aux^.sig:= nil; aux^.dato:= c;
    if(l = nil) then l:= aux
    else 
        begin
            aux^.sig:= l;
            l:= aux;
        end;
end;
procedure procesarLista(l: lista; var l2: lista);
var
    montoTot: real;
    cantC, dniActual: integer;
    c: comprador;
begin
    while(l<>nil) do
        begin
            dniActual:= l^.dato.dni;
            cantC:= 0;
            montoTot:= 0;
            while(l<>nil) and (dniActual = l^.dato.dni) do
                begin
                    cantC:= cantC + 1;
                    montoTot:= montoTot + (l^.dato.cant * l^.dato.precio);
                    l:= l^.sig;
                end;
            c.dni:= dniActual;
            c.cantTotal:= cantC;
            c.montoTotal:= montoTot;
            agregarAdelante(l2, c);
        end;
end;
var
    l: lista; 
    l2: lista2;
begin
    l:= nil;
    l2: nil;
    cargarLista(l);
    procesarLista(l, l2);
end;