program febrero1ra2023;
type
    clientes = record
        dni: integer;
        fecha: string;
        monto: real;
    end;
    lista = ^nodo;
    nodo = record
        dato: clientes;
        sig: lista;
    end;
    cli = record
        dni: integer;
        cant: integer;
        montoTotal: real;
    lista2 = ^nodoClientes;
    nodoClientes = record
        dato: cli;
        sig: lista2;
    end;
procedure cargarLista(var l: lista); //SE DISPONE
function cumple(cant: integer): boolean;
begin
    cumple:= cant > 5;
end;
procedure agregarAdelante(var l: lista2; c: cli);
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
procedure procesarLista(l: lista; var l2: lista2);
var
    cantCompras, dniActual: integer;
    montoTot: real;
    c: cli;
begin
    while(l<>nil) do begin
        dniActual:= l^.dato.dni;
        cantCompras:= 0;
        montoTot:= 0;
        while(l<>nil) and (l^.dato.dni = dniActual) do
            begin
                cantCompras:= cantCompras+1;
                montoTot:= montoTot + l^.dato.monto;
                l:= l^.sig;
            end;
        if(cumple(cantCompras)) then
            begin
                c.dni:= dniActual;
                c.cant:= cantCompras;
                c.montoTotal:= montoTot;
                agregarAdelante(l2, c);
            end;
    end;
end;
var
    l: lista;
    l2: lista2;
begin
    l:= nil;
    l2:= nil;
    cargarLista(l);
    procesarLista(l, l2);
end;