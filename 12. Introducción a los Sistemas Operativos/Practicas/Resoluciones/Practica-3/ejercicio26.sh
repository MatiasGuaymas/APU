#!/bin/bash
# Escriba un script que reciba una cantidad desconocida de parámetros al momento
# de su invocación (debe validar que al menos se reciba uno). Cada parámetro 
# representa la ruta absoluta de un archivo o directorio en el sistema.
# El script deberá iterar por todos los parámetros recibidos, y solo para 
# aquellos parámetros que se encuentren en posiciones impares (el primero, el
# tercero, el quinto, etc.), verificar si el archivo o directorio existen en el
# sistema, imprimiendo en pantalla qué tipo de objeto es (archivo o directorio).
# Además, deberá informar la cantidad de archivos o directorios inexistentes en
# el sistema.

if [ $# -eq 0 ]; then
  echo "Se debe recibir al menos un parámetro"
  exit 1
fi

inexistentes=0 
iteracion=0

for ruta in "$@"; do
  ((iteracion++))
  if (( iteracion % 2 == 0 )); then
    continue
  fi

  if [ -e "$ruta" ]; then
    if [ -d "$ruta" ]; then 
      echo "\"$ruta\" es un directorio"
    elif [ -f "$ruta" ]; then
      echo "\"$ruta\" es un archivo"
    fi
  else
    echo "\"$ruta\" no existe"
    ((inexistentes++))
  fi
done

echo "Cantidad de archivos o directorios inexistentes: $inexistentes"
