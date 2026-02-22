program finalJulio2017;
type
    lista = ^nodo;
    nodo = record
        dato: integer;
        sig: lista;
    end;

    infoNum = record
        cant: integer;
        num: integer;
    end;

    lista2 = ^nodoNum;
    nodoNum = record
        dato: infoNum;
        sig: lista2;
    end;
procedure cargarLista(var l: lista); //SE DISPONE
procedure agregarAdelante(var l2: lista2; n: infoNum);
var
    aux: lista2;
begin
    new(aux); aux^.sig:= nil; aux^.dato:= n;
    if(l2 = nil) then l2:= aux
    else
        begin
            aux^.sig:= l; l:= aux;
        end;
end;
procedure procesarLista(l: lista; var l2: lista);
var
    regNum: infoNum;
    cantRep, numActual: integer; 
begin
    l2:= nil;
    while(l<>nil) do
        begin
            numActual:= l^.dato;
            cantRep:= 0
            while(l<>nil) and (numActual = l^.dato) do
                begin
                    cantRep:= cantRep + 1;
                    l:= l^.sig;
                end;
            regNum.cant:= cantRep;
            regNum.num:= numActual;
            agregarAdelante(l2,regNum);
        end;
end;
var
    l: lista;
    l2: lista2;
begin
    l:= nil;
    cargarLista(l); //SE DISPONE
    procesarLista(l, l2);
end;