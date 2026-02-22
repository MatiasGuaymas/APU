#!/bin/bash
#Dada la siguiente declaración al comienzo de un script: num=(10 3 5 7 9 3 5 4) (la cantidad
#de elementos del arreglo puede variar). Implemente la función productoria dentro de este
#script, cuya tarea sea multiplicar todos los números del arreglo

numeros=(10 3 5 7 9 3 5 4) 

productoria () {
    local resultado=1
    for num in ${numeros[*]}; do
        resultado=$((resultado*num))
    done
    echo $resultado
}

productoria