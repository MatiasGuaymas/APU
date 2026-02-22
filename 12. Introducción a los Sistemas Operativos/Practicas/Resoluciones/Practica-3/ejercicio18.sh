#!/bin/bash
#Crear un script que verifique cada 10 segundos si un usuario se ha loqueado en el sistema (el nombre del usuario será pasado por parámetro). 
#Cuando el usuario finalmente se loguee, el programa deberá mostrar el mensaje ”Usuario XXX logueado en el sistema” y salir.

if [ $# -ne 1 ]; then
  echo Debe pasar el nombre del usuario que desea chequear como parámetro
  exit 1
fi

usuario_valido=`cat /etc/passwd | cut -d: -f1 | grep -w $1 | wc -l`
if [ $usuario_valido -eq 0 ]; then
  echo "usuario invalido"
  exit 82
fi

while true; do
  entro=`who | cut -d' ' -f 1 | grep $1 | wc -l`
  if [ $entro -gt 0 ]; then
    echo "El usuario $1 ha ingresado"
    exit 0 # o break
  fi
  sleep 10
done