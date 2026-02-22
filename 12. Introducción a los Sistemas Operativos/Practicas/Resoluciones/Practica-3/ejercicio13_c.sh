#!/bin/bash
#Crear un script que reciba como parámetro el nombre de un archivo e informe si el
#mismo existe o no, y en caso afirmativo indique si es un directorio o un archivo. En
#caso de que no exista el archivo/directorio cree un directorio con el nombre recibido
#como parámetro.

if [ $# -ne 1 ]; then 
    echo "Se necesita de un nombre de archivo"
    exit 1
fi

if [ -e "$1" ]; then
    if [ -f  "$1" ]; then
        echo "Es un archivo"
    elif [ -d "$1" ]; then
        echo "Es un directorio"
    else
        echo "No es ni directorio ni archivo"
    fi
else
    mkdir "$1" 
fi

exit 0


