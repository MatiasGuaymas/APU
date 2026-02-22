#Realice un script que reciba como parámetros: un path a un directorio y una de las siguientes opciones "-d" o "-f" 
#Si el segundo parámetro es "-f" debe informar por la salida estándar la cantidad de archivos del directorio pasado como primer parámetro 
#y causar la terminación del script.
#Si el segundo parámetro es "-d" debe informar por la salida estándar de directorios del directorio pasado como primer parámetro.
#Si el primer parámetro es un directorio invalido o el segundo parámetro no es "-d" o "-f" el script debe terminar con error.

#!/bin/bash

if [ $# -ne 2 ]; then
    echo "Cantidad de parametros invalida"
    exit 1
fi

if [[ ! -d "$1" || (($2 != "-d" && $2 != "-f")) ]]; then
    echo "Cometiste un error"
    exit 2
fi

if [[ $2 == "-f" ]]; then
    echo $(ls -1 "$1" | wc -l)
else
    for dir in "$1"/*/; do
        if [ -d "$dir" ]; then
            echo "$(basename "$dir")"  # Muestra solo el nombre del directorio
        fi
    done
fi

exit 0
