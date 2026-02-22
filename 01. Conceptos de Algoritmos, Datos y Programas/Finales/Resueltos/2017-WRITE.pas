program uno;
var
    a, b, c: integer;
procedure prueba(var a: integer; var b: integer; c: integer);
    var b: integer;
begin
    b:= a - 11;
    c:= b + 10;
    a:= a + c + 5;
    writeln('Hola1 ', a, ' ', b, ' ', c);
end;
begin
    a:= 3;
    b:= 10;
    writeln('Hola2 ' , a, ' ', b, ' ', c);
    prueba(b,c,a);
    writeln('Hola3 ', a, ' ', b, ' ', c);
end.