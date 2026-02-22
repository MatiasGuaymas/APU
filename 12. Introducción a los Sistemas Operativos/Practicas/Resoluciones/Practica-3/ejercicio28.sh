#!/bin/bash
#Realice un script que reciba como parámetro el nombre de un directorio. Deberá validar que
#el mismo exista y de no existir causar la terminación del script con código de error 4. Si el
#directorio existe deberá contar por separado la cantidad de archivos que en él se encuentran
#para los cuales el usuario que ejecuta el script tiene permiso de lectura y escritura, e informar
#dichos valores en pantalla. En caso de encontrar subdirectorios, no deberán procesarse, y
#tampoco deberán ser tenidos en cuenta para la suma a informar.

if [ $# -ne 1 ]; then
    echo "Pasar como minimo un parametro"
    exit 1
fi

if [ ! -d "$directorio" ]; then
    echo "El directorio no existe"
    exit 4
fi

cantidad=0

for a in "$1"/*; do
    if [ -f "$a" ]; then
        if [ -r "$a" ] && [ -w "$a" ]; then
            ((cantidad++))
        fi
    fi
done

echo "Cantidad de archivos con permiso de lectura y escritura: $cantidad"