#Realice un script que implemente a través de la utilización de arreglos las siguientes funciones:
#insert elemento: La función insert recibe 1 parámetro (debe validar que así sea). Agrega al final del arreglo el elemento recibido como parámetro.
#rellenar n: Esta función itera n veces solicitando al usuario que ingrese un patrón de texto y lo agrega al final del arreglo. #
#Debe validar que se reciba 1 parámetro
#select elemento: La función select recibe 1 parámetro (debe validar que así sea):
#Si el parámetro es *, entonces imprimirá todos los elementos del arreglo
#Si al parámetro es distinto a *, deberá verificar si en el arreglo existe un elemento que sea igual al parámetro. 
#Si existe deberá imprimirlo en pantalla, caso contrario imprimirá "Elemento no encontrado"
#delete elemento: La función delete recibe 1 parámetro (debe validar que así sea):
#Si el parámetro es *, entonces eliminará todos los elementos del arreglo
#Si al parámetro es distinto a *, deberá verificar si en el arreglo existe un elemento que sea igual al parámetro. Si existe deberá eliminarlo, 
#caso contrario imprimirá "Elemento no encontrado"
#Además de las funciones debe proveer un ejemplo de uso de las funciones codificadas.

#!/bin/bash

arreglo=()

verificar() {
    if [ $# -ne 1 ]; then
        echo "Cantidad de parámetros inválida"
        return 1
    fi
}

insert() {
    verificar "$@" || return
    arreglo+=("$1")
}

rellenar() {
    verificar "$@" || return
    for ((i=0; i<"$1"; i++)); do
        read cadena
        insert "$cadena"
    done
}

select_elemento() {
    verificar "$@" || return
    if [[ "$1" == "*" ]]; then
        echo "${arreglo[*]}"
    else
        for elemento in "${arreglo[@]}"; do
            if [[ "$elemento" == "$1" ]]; then
                echo "Existe el elemento $1"
                return 0
            fi
        done
        echo "No existe el elemento"
    fi
}

delete() {
    verificar "$@" || return
    if [[ "$1" == "*" ]]; then
        arreglo=()
    else
        for ((i=0; i<${#arreglo[@]}; i++)); do
            if [[ "${arreglo[i]}" == "$1" ]]; then
                unset arreglo[i]
                arreglo=("${arreglo[@]}")
                return 0
            fi
        done
        echo "No existe el elemento"
    fi
}

insert 4
insert 5
rellenar 2
select_elemento "*"
select_elemento 1
delete "*"
select_elemento "*"

