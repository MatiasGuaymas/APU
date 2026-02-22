#Escribir un script de Bash que reciba un nombre de usuario como parámetro. Si el usuario ingresado como parámetro NO es un usuario del sistema 
#el script debe finalizar con el código de error 1. En caso contrario, debe verificar cada 30 segundos si el usuario está logueado. 
#Al detectar que está logueado debe registrar en un archivo llamado access-<NOMBRE DE USUARIO>.log el nombre del usuario 
#junto con la fecha en que se lo detectó. NO debe borrar el contenido previo de este archivo y este archivo debe escribirlo 
#en una ubicación apropiada del file system. Al detectar 30 veces que el usuario está logueado el script debe finalizar 
#retornando el código de error que indica que el proceso es exitoso.

#!/bin/bash

if [ $# -ne 1 ]; then
    echo "Debe pasar como parametro un nombre de usuario"
    exit 2
fi

usuario_valido=$(cat /etc/passwd | cut -d: -f1 | grep $1 | wc -l)
if [ $usuario_valido -eq 0 ]; then
  echo "Usuario invalido"
  exit 1
fi

log_file="/var/log/access-$1.log"
contador=0

while [ $contador -lt 30 ]; do
    if who | grep -w "$1"; then
        echo "$(date): $1 ha iniciado sesión." >> "$log_file"
        ((contador++))
    fi
    sleep 30
done

echo "Salio todo bien $contador"
exit 0