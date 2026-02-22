#Escribir un script que reciba como primer parámetro un directorio, luego uno o más nombres de archivos (no sabemos cuántos). 
#Debemos validar que el directorio indicado exista y que sea un directorio. Luego por cada nombre de archivo ingresado debemos
#validar que el mismo exista, y en caso de existir, si es un archivo, informar si poseemos permiso de ejecución sobre el mismo 
#y si es un directorio, informar si poseemos permiso de escritura sobre el mismo.

#!/bin/bash

if [ $# -lt 2 ]; then
    echo "Cantidad invalida de parametros"
    exit 1
fi

if [[ ! -e "$1" || ! -d "$1" ]]; then
    echo "No existe el directorio"
    exit 2
fi

shift 

for archivo in "$@"; do
    if [ ! -e "$archivo" ]; then
        echo "El archivo o directorio '$archivo' no existe."
    elif [ -f "$archivo" ]; then
        if [ -x "$archivo" ]; then
            echo "El archivo '$archivo' existe y tiene permisos de ejecución."
        else
            echo "El archivo '$archivo' existe pero NO tiene permisos de ejecución."
        fi
    elif [ -d "$archivo" ]; then
        if [ -w "$archivo" ]; then
            echo "El directorio '$archivo' existe y tiene permisos de escritura."
        else
            echo "El directorio '$archivo' existe pero NO tiene permisos de escritura."
        fi
    fi
done

