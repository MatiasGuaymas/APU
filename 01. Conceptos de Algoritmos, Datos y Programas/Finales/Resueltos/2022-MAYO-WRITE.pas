program prueba;
var c: integer;
procedure calcular(a: integer; var b: integer);
var
    i: integer;
begin
    b:= 30;
    a:= a * 2;
    c:= c - b;
    writeln('CALCULAR: ', 'a= ', a, ' b= ', b, ' c= ', c);
end;
var
    a,b: integer;
begin
    b:= 20;
    c:= 30;
    writeln('PRIMERO: ', 'a= ', a, ' b= ', b, ' c= ', c);
    calcular(b,a);
    writeln('SEGUNDO: ', 'a= ', a, ' b= ', b, ' c= ', c);
end.