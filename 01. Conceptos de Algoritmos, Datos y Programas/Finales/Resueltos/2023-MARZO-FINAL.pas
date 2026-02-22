program marzo2023Final;
type
    factura = record
        numero: integer;
        codigo: integer;
        monto: real;
    end;
    vecFacturas = array [1..2000] of factura;
var
    vEnero, vFebrero: vecFacturas;
    dimLogEnero, dimLogFebrero: integer;
procedure cargarV(var v: vecFacturas; var diml: integer); //SE DISPONE
procedure buscarPos(v: vecFacturas; diml: integer; var posEncontrado: integer; var ok: boolean);
var
    pos: integer;
begin
    pos:= 1;
    while((pos <= diml) and (v[pos].codigo < 444))
        pos:= pos + 1;
    if((pos > diml) or (v[pos.codigo] <> 444)) then 
        begin
            ok:= false;
            posEncontrado:= 0;
        end
    else 
        begin
            ok:= true;
            posEncontrado:= pos;
        end;
end;
function contarCant(pos: integer; diml: integer; v: vecFacturas): integer;
var
    cant: integer;
begin
    cant: 0;
    while((pos <= diml) and (v[pos].codigo = 444)) do
        begin
            pos:= pos+1;
            cant:= cant+1;
        end;
    contarCant:= cant;
end;
procedure hacerCorrimientos(var vE: vecFacturas; vF: vecFacturas; diml: integer; pos1, pos2: integer; cant: integer);
var
    i, j: integer;
begin
    for i:= diml downto pos1 do
        vE[i+cant] := vE[i];
    for j:= pos1 to diml do
        begin
            vE[j] := vF[pos2];
            pos2:= pos2+1;
        end;
end;
procedure incorporarFacturas(v1: vecFacturas; diml1: integer; var v2: vecFacturas; var diml2: integer);
var
    pos1, pos2, cantPasar, i, j: integer;
    ok, ok2: boolean;
var
    buscarPos(v1, diml1, pos1, ok);
    if (ok) then
        cantPasar:= contarCant(pos1, diml1, v1); //En pos + cant se donde termina la factura con codigo mas grande que 444 o el vector
    if((2000 - diml2) > (cantPasar)) 
        then
            buscarPos(v2, diml2, pos2, ok2);
            if(ok2)
                hacerCorrimientos(v2, v1, diml2, pos2, pos1, cantPasar);
            else
                for i:= (diml2+1) to (diml2 + cantPasar) do
                    begin
                        v2[i]:= v1[pos1];
                        pos1:= pos1+1;
                    end;
            diml2:= diml2 + cantPasar;
begin
    dimLogEnero:= 0;
    dimLogFebrero:= 0;
    cargarV(vEnero, dimLogEnero);
    cargarV(vFebrero, dimLogFebrero)
    incorporarFacturas(vFebrero, dimLogFebrero, vEnero, dimLogFebrero);
end;