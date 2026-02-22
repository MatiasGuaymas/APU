program febrero2020Final;
type
    subPub = 1..12;
    publicacion = record
        titulo: string;
        nombre: string;
        dni: integer;
        tipo: subPub;
    end;
    lista = ^nodo;
    nodo = record
        dato: publicacion;
        sig: lista;
    end;
    vecTipos = array [subPub] of integer;
procedure leerP(var p: publicacion);
begin
    writeln('Ingrese un DNI');
    readln(p.dni);
    if(p.dni<>0) then
        begin
            writeln('Ingrese un titulo de publicacion');
            readln(p.titulo);
            writeln('Ingrese un nombre de autor');
            readln(p.nombre);
            writeln('Ingrese el tipo de publicacion');
            readln(p.tipo);
        end;
end;
procedure insertar(var l: lista; p: publicacion);
var
    ant, act, aux: lista;
begin
    new(aux); aux^.sig:= nil; aux^.dato:= p;
    if(l = nil) then l:= aux
    else
        begin
            ant:= l;
            act:= l;
            while(act <> nil) and (act^.dato.dni < aux^.dato.dni) do
                begin
                    ant:= act;
                    act:= act^.sig;
                end;
            if(l = act) then
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
procedure generarLista(var l:lista);
var
    p: publicacion;
begin
    leerP(p);
    while(p.dni<>0) do
        begin
            insertar(l, p);
            leerP(p);
        end;
end;
procedure inicializarVector(var v: vecTipos);
var
    i: subPub;
begin
    for i:= 1 to 12 do v[i] := 0;
end;
procedure procesarLista(l: lista; var v: vecTipos);
var
    cant, dniActual: integer;
    nomActual: string;
begin
    while(l<>nil) do
        begin
            nomActual:= l^.dato.nombre;
            dniActual:= l^.dato.dni;
            cant:= 0;
            while(l <> nil) and (dniActual = l^.dato.dni) do
                begin
                    v[l^.dato.tipo] := v[l^.dato.tipo] + 1;
                    cant:= cant + 1;
                    l:= l^.sig;
                end;
            writeln('Para ', nomActual, ' su cantidad de publicaciones presentadas es igual a: ', cant);
        end;
end;
procedure procesarVector(v: vecTipos; var tipoMax: subPub);
var
    i: subPub;
    max: integer;
begin
    max:= -1;
    for i:= 1 to 12 do 
        begin
            writeln(i, ' ', v[i]);
            if(v[i] > max) then
                tipoMax:= i;
                max:= v[i];
        end;
end;
var
    l: lista;
    v: vecTipos;
    tipoMax: subPub;
begin
    l:= nil;
    generarLista(l);
    inicializarVector(v);
    procesarLista(l, v);
    procesarVector(v, tipoMax);
    writeln('El tipo de publicacion con mayor cantidad de publicaciones es: ', tipoMax);
end.