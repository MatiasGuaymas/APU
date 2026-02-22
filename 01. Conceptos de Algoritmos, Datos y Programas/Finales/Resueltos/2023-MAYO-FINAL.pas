program mayo2023Final;
type
    factura = record
        numero: integer;
        codigo: integer;
        monto: real;
        pago: string;
    end;
    lista = ^nodo;
    nodo = record
        dato: factura;
        sig: lista;
    end
procedure cargarLista(var l: lista); //SE DISPONE
procedure agregarAdelante(var l: lista; f: factura);
var
    aux: lista;
begin
    new(aux); aux^.sig:= nil; aux^.dato:= f;
    if(l = nil) then l:= aux
    else 
        begin
            aux^.sig:= l;
            l:= aux;
        end;
end;
procedure generarNuevaLista(l: lista; var l2: lista);
var
    act, ant: lista;
begin
    act:= l;
    while(actual<>nil) do
        begin
            if(act^.dato.pago <> 'Efectivo') then
                begin
                    ant:= act;
                    act:= act^.sig;
                end
            else
                begin
                    if(act = l) then
                        agregarAdelante(l2, l^.dato);
                        l:= l^.sig;
                        act:= l;
                    else 
                        agregarAdelante(l2, act^.dato);
                        ant^.sig:= act^.sig;
                    dispose(act);
                    act:= ant;
                end;
        end;
end;
var
    l, l2: lista;
begin
    l:= nil;
    cargarLista(l);
    generarNuevaLista(l, l2);
end.