#!/bin/bash
#Realice un script que mueva todos los programas del directorio actual (archivos ejecutables)
#hacia el subdirectorio “bin” del directorio HOME del usuario actualmente logueado. El script
#debe imprimir en pantalla los nombres de los que mueve, e indicar cuántos ha movido, o
#que no ha movido ninguno. Si el directorio “bin” no existe,deberá ser creado

destino="${HOME}/bin"
cont=0

if [ ! -d "$destino" ]; then
  echo "Creando directorio"
  mkdir -p "$destino"
fi

for i in *; do
  if [[ -f "$i" && -x "$i" ]]; then
    echo "Moviendo $i"
    mv "$i" "${destino}/"
    ((cont++))
  fi
done

echo "Se han movido $cont archivos"
