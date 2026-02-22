#!/bin/bash
#Modificar el script creado en el inciso anterior para que los números sean recibidos
#como parámetros. El script debe controlar que los dos parámetros sean enviados

function getMayor() {
    if [ $1 -gt $2 ]; then
        echo $1
    elif [ $2 -gt $1 ]; then
        echo $2
    else
        echo "ninguno, son iguales"
    fi
}

if [[ $# -ne 2 ]]; then
    echo "Se deben pasar dos números como parámetro"
    exit 1
fi

echo "La multiplicacion de los dos numeros ingresados es: $(($1 * $2))"
echo "La suma de los dos numeros ingresados es: $(($1 + $2))"
echo "La resta de los dos numeros ingresados es: $(($1 - $2))"
echo "El numero mas grande es: $(getMayor $@)"

exit 0