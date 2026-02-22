#!/bin/bash
#Realizar un script que reciba como parámetro una extensión y haga un reporte con 2
#columnas, el nombre de usuario y la cantidad de archivos que posee con esa extensión. Se
#debe guardar el resultado en un archivo llamado reporte.txt

if [ "$#" -ne 1 ]; then
    echo "No se ingreso la cantidad correcta de parametros"
    exit 1
fi

echo > reporte.txt

for linea in $(cat /etc/passwd | cut -d: -f 1,6); do
    user=$(echo $linea | cut -d: -f1)
    home=$(echo $linea | cut -d: -f2)

    if [ -d $home ]; then
        echo $user $(find $home -name "*.$1" | wc -l) >> reporte.txt
    fi
done