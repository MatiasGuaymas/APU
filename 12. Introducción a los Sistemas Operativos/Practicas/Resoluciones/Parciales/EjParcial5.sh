#Realice un script que verifique cada 3 minutos si existe el archivo /var/log/any-service/error.log. 
#Si el archivo existe y dentro de el hay al menos una linea con el texto "FATAL ERROR:" debemos: comprimir y empaquetar el contenido del directorio
#/var/log/usr-service, guardarlo en un directorio que es pasado como parámetro al script y además causar la terminación del script apropiadamente. 
#Cuando el script termina debemos informar por la salida estandard la cantidad de lineas del archivo que contenian el texto "FATAL ERROR".

#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Cantidad invalida de parametros"
    exit 1
fi

if [ ! -d "$1" ]; then
    echo "El parametro pasado no es un directorio"
    exit 2
fi

directorio_destino="$1"
archivo_log="/var/log/any-service/error.log"
directorio_usr_service="/var/log/usr-service"

while true; do
    if [ -f "$archivo_log" ]; then
        errores=$(grep -c "FATAL ERROR:" "$archivo_log")
        if [ $errores -gt 0 ]; then
            archivo_tar="$directorio_destino/usr-service-$(date +%Y%m%d-%H%M%S).tar.gz"
            tar -czf "$archivo_tar" "$directorio_usr_service"
            exit 0
        fi
    fi
    sleep 3m
done

