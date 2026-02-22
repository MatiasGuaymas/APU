#!/bin/bash
#Realice un script que simule el comportamiento de una estructura de PILA e implemente
#las siguientes funciones aplicables sobre una estructura global definida en el script:
#push: Recibe un parámetro y lo agrega en la pila 
#pop: Saca un elemento de la pila
#length: Devuelve la longitud de la pila 
#print: Imprime todos elementos de la pila

pila=()

pop(){
  if [ "${#pila[*]}" -ne 0 ]; then
    unset pila[-1]
  else
    echo "No se puede eliminar, la pila está vacía"
    return 1
  fi
}

push(){
  pila+=($1)
}

length(){
  echo "${#pila[*]}"
}

print(){
  for elemento in "${pila[*]}"; do
    echo $elemento
  done
}

select opcion in pop push length print salir; do
  case $REPLY in
    1)
      pop
      ;;
    2)
      read -p "Ingrese el valor a añadir: " valor
      push $valor
      ;;
    3)
      length
      ;;
    4)
      print
      ;;
    5)
      exit 0
      ;;
    *)
      echo Invalido
      ;;

  esac
done
