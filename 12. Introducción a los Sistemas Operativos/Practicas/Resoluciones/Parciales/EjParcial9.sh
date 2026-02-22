#Escriba un script de Bash que imprima en pantalla la cantidad de archivos del directorio /var/log/$SERVICE que contienen un patrón 
#de texto que el usuario pasa como parámetro, $SERVICE es una variable de entorno, si la misma no posee ningún valor debe tomar 
#el valor por defecto "local_service". El script debe finalizar retomando el valor que indica que el proceso se ejecutó correctamente.

#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Se necesita un parametro"
    exit 1
fi

SERVICE=${SERVICE:-local_service}

count=$(grep -l "$1" /var/log/"$SERVICE"/* 2>/dev/null | wc -l)

echo "Cantidad de archivos que contienen el patrón '$1': $count"

exit 0