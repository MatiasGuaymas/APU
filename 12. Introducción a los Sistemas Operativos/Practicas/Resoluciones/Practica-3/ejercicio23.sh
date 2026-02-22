#!/bin/bash
#Implemente un script que recorra un arreglo compuesto por números e imprima en pantalla
#sólo los números pares y que cuente sólo los números impares y los informe en pantalla al
#finalizar el recorrido.

vector=(10 3 5 7 9 3 5 4) 

analizarVector () {
    local cantImpares=0
    for num in ${vector[*]}; do
        if ((num % 2 == 0 )); then
            echo "NumPar: $num"
        else
            ((cantImpares++))
        fi
    done
    echo "CantImpares: $cantImpares"
}

analizarVector
