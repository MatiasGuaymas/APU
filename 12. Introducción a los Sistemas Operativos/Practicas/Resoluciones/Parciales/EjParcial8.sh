#Realice un script de Bash que agregue a un arreglo los nombres de los archivos del directorio /var/log que tengan el texto "access" en su nombre. 
#Luego presente un menú al usuario con las siguientes funciones sobre ese arreglo
#cantidad: Imprime la cantidad de archivos del directorio /var/log que tengan el texto "access" en su nombre 
#listar: Imprime los nombres de todos los archivos del directorio /var/log que tengan el texto "access" en su nombre 
#eliminar: Solicita al usuario un indice del arreglo y un carácter que puede ser "l" (lógico) o "f"(fisico)". 
#Si el segundo parámetro es "l", solo borra la entrada en el arreglo, si es "f" borra la entrada en el arreglo y el archivo del FileSystem.
#fin: Termina el script con el código de error que indica que el proceso es exitoso
#cantidad, listar y eliminar deben ser implementadas en funciones individuales

#!/bin/bash

archivos=()
for arc in /var/log/*access*; do
    if [ -e "$arc" ]; then
        archivos+=("$(basename "$arc")")
    fi
done

cantidad() {
    echo "${#archivos[*]}"
}

listar() {
    for arc in "${archivos[*]}"; do
        echo $arc
    done
}

eliminar() {
    if [ $# -ne 2 ]; then
        echo "Cantidad de parametros invalida"
        return 1
    fi

    if [[ $1 -ge 0 && $1 -lt "${#archivos[*]}" ]]; then
        if [[ $2 == "l" || $2 == "f" ]]; then
            if [[ $2 == "f" ]]; then
                rm -f "/var/log/{archivos[$1]}"
            fi
            unset archivos[$1]
            archivos=("${archivos[*]}")
        else
            echo "Segundo parametro invalido"
        fi
    else
        echo "Posicion invalida"
    fi 
}

select option in cantidad listar eliminar fin; do
    case $option in 
        "cantidad") cantidad
        ;;
        "listar") listar
        ;;
        "eliminar") read posicion parametro
        eliminar $posicion $parametro
        ;;
        "fin") exit 0
        ;;
    esac
done
