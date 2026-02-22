program mayo2018Final;
type
    lista = ^nodo;
    nodo = record
        dato: string;
        sig: lista;
    end;
procedure agregarAdelante(var l: lista; nom: string);
var
    aux: lista;
begin
    new(aux);aux^.sig:= nil; aux^.dato:= nom;
    if(l = nil) then l:= aux
    else
        begin
            aux^.sig:= l;
            l:= aux;
        end;
end;
procedure generarLista(var l: lista);
var
    nombre: string;
begin
    readln(nombre);
    while(nombre <> 'ZZZ') do
        begin
            agregarAdelante(l, nombre);
            readln(nombre);
        end;
end;
procedure eliminarOcurrencias(var l: lista; nom: string);
var
    act, ant: lista;
begin
    act:= l;
    while(act <> nil) do
        begin
            if(act^.dato <> nom) then
                begin
                    ant:= act;
                    act:= act^.sig;
                end
            else
                begin
                    if(act = l) then
                        act:= act^.sig
                    else
                        ant^.sig:= act^.sig;
                    dispose(actual);
                    act:= ant;
                end;
        end;
end;
var
    l: lista;
    nomEliminar: string;
begin
    generarLista(l);
    readln(nomEliminar);
    eliminarOcurrencias(l, nomEliminar);
end.