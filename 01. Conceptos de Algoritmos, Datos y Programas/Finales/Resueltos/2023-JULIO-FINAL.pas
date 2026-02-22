program mayo2023Final;
type
    factura = record
        numero: integer;
        cliente: integer;
        sucursal: integer;
        monto: real;
    end;
    lista = ^nodo;
    nodo = record
        dato: factura;
        sig: lista;
    end;
procedure cargarLista(var l: lista); //SE DISPONE
procedure evaluarMin(monto: real; code: integer; var min: real; var codeMin: integer);
begin
    if(monto < min) then
        begin
            min:= monto;
            codeMin:= code;
        end;
end;
procedure evaluarMax(cant, code: integer; var max, codeMax: integer);
begin
    if(cant > max) then
        begin
            max:= cant;
            codeMax:= code;
        end;
end;
procedure procesarLista(l: lista; var codeMin, codeMax: integer);
var
    min, max, codeActual, cant: integer;
    recaudacion: real;
begin
    min:= 99999;
    max:= -1;
    while(l<>nil) do
        begin
            codeActual:= l^.dato.sucursal;
            cant:= 0;
            recaudacion:=0;
            while(l<>nil) and (l^.dato.sucursal = codeActual) do
                begin
                    cant:= cant+1;
                    recaudacion:= recaudacion + l^.dato.monto;
                    l:= l^.sig;
                end;
            evaluarMin(recaudacion, codeActual, min, codeMin);
            evaluarMax(cant, codeActual, max, codeMax);
        end;
end;
var
    l: lista;
    codeMin, codeMax: integer;
begin
    cargarLista(l);
    procesarLista(l, codeMin, codeMax);
    writeln(codeMin, codeMax);
end.

        