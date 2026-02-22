#!/bin/bash
#Renombrando Archivos: haga un script que renombre solo archivos de un directorio pasado
#como parametro agregandole una CADENA, contemplando las opciones:
#“-a CADENA”: renombra el fichero concatenando CADENA al final del nombre del
#archivo
#“-b CADENA”: renombra el fichero concantenado CADENA al principio del nombre
#del archivo
#Ejemplo:
#Si tengo los siguientes archivos: /tmp/a /tmp/b
#Al ejecutar: ./renombra /tmp/ -a EJ
#Obtendré como resultado: /tmp/aEJ /tmp/bEJ
#Y si ejecuto: ./renombra /tmp/ -b EJ
#El resultado será: /tmp/EJa /tmp/EJb

if [ "$#" ne 3 ]; then
    echo "Cantidad de parametros invalida"
    exit 1
fi

if [[ ! -d $3 ]]; then
    echo "$3 no es un directorio"
    exit 2
fi

cd $3
if [ $1 = "-a" ]; then
    for i in $(ls)
    do
        mv $i $i$2
    done
elif [ $1 = "-b" ]; then
    for i in $(ls)
    do
        mv $i $2$i
    done
else
    echo "Operacion incorrecta"
fi

exit 0
