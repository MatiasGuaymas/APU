program febrero2daFecha;
type
    productosV = record
        codigo: integer;
        cantidad: integer;
    end;
    listaVentas = ^nodo;
    nodo = record
        dato: productosV;
        sig: listaVentas;
    end;
    ventas = record
        numero: integer;
        monto: real;
        lista: listaVentas;
    end;
    vecVentas = array [1..500] of ventas;
procedure cargarVector(var v: vecVentas; var diml: integer); //SE DISPONE
function contarP(l: lista): integer;
var
    cant: integer;
begin
    cant:= 0
    while(l<>nil) do
        begin
            cant:= cant+1;
            l:= l^.sig;
        end;
    contarP:= cant;
end;
procedure eliminarLista(var l: lista, cantNodos: integer);
var
    act: lista;
begin
    for i:= 1 to cantNodos do
        begin
            act:= l;
            l:= l^.sig;
            dispose(act);
        end;
end;
procedure procesarVector(var v: vecVentas; var diml: integer);
var
    i: integer;
    contador: integer;
begin
    contador:= 0;
    for i:= 1 to diml do
        begin
            cantNodos:= contarP(v[i].l);
            if(cantNodos = 5) then
                contador:= contador + 1
            else
                if(contador > 0) then 
                    begin
                        eliminarLista(v[i-contador].l, cantNodos);
                        v[i-contador] := v[i];
                    end;
        end;
    diml:= diml - contador;
end;
var
    v: vecVentas;
    diml: integer;
begin
    diml:= 0;
    cargarVector(v, diml); 
    procesarVector(v, diml);
end;