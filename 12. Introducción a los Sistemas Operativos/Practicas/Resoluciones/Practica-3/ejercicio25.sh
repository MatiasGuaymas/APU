#!/bin/bash
#Realice un script que agregue en un arreglo todos los nombres de los usuarios del sistema pertenecientes al grupo “users”.
#Adicionalmente el script puede recibir como parametro:
#“-b n”: Retorna el elemento de la posición n del arreglo si el mismo existe. Caso contrario, un mensaje de error.
#“-l”: Devuelve la longitud del arreglo
#“-i”: Imprime todos los elementos del arreglo en pantalla

usuarios=()

#Funciones
function addUsers {
  # Para probar uso el grupo 'audio'
  users=$(cat /etc/group | grep audio | cut -d: -f4 | tr ',' '\n')
  for i in "${users[*]}"; do
    usuarios+=($i)
  done
}

function retornarN {
  if [[ $1 -ge 0 && $1 -lt ${#users[*]} ]]; then
    echo "${usuarios[$1]}" 
  else
    echo "El índice $1 está fuera del rango del array"
  fi
}

function retornarLongitud {
  echo "${#usuarios[*]}"
}

function imprimirUsuarios {
  for i in "${usuarios[*]}"; do
    echo $i
  done
}

#Main
addUsers

case $1 in
  "-b")
      retornarN $2
    ;;
  "-l")
      retornarLongitud
    ;;
  "-i")
      imprimirUsuarios
    ;;
  *)
    echo "Ja joder"
    ;;
esac
