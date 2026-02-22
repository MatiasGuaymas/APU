#!/bin/bash
#Escribir un script que al ejecutarse imprima en pantalla los nombres de los archivos que se encuentran en el directorio actual, 
#intercambiando minúsculas por mayúsculas, además de eliminar la letra a (mayúscula o minúscula). Ejemplo, directorio actual:
#IsO
#pepE
#Maria
#Si ejecuto: ./ejercicio17
#Obtendré como resultado:
#iSo
#PEPe
#mRI

echo "Antes del cambio $(ls)"
echo "Despues del cambio : "
for i in $( ls )
do
  echo $( echo $i | tr -d 'aA' | tr 'b-zB-Z' 'B-Zb-z')
done

exit 0