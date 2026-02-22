program abril2023Final;
type
    factura = record
        numero: integer;
        codigo: integer;
        sucursal: integer;
        monto: real;
    end;
    vecFacturas = array [1..2000] of factura;
procedure cargarVector(var v: vecFacturas; var diml: integer); //SE DISPONE
procedure calcularMaximos(cant: integer; code: integer; var max: integer; var codeMax: integer);
begin
    if(cant > max) then
        begin
            max:= cant;
            codeMax:= code;
        end;
end;
procedure procesarVector(v: vecFacturas; diml: integer; var codeMax: integer);
var
    codeActual, cantSucursales, max: integer;
    pos: integer;
begin
    pos:= 1;
    max:= -1;
    while(pos <= diml) do
        begin
            codeActual:= v[pos].codigo;
            cantSucursales:= 0;
            while(pos <= diml) and (codeActual = v[pos].codigo) do
                begin
                    cantSucursales:= cantSucursales + 1;
                    pos:= pos + 1;
                end;
            calcularMaximos(cantSucursales, codeActual, max, codeMax);
        end;
end;
var
    v: vecFacturas;
    codeMax, diml: integer;
begin
    diml:= 0;
    cargarVector(v, diml);
    procesarVector(v, diml, codeMax);
    writeln(codeMax);
end;