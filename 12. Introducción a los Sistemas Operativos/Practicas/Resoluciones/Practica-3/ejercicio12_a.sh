#!/bin/bash
#Realizar un script que le solicite al usuario 2 números, los lea de la entrada Standard
#e imprima la multiplicación, suma, resta y cual es el mayor de los números leídos.

function getMayor() {
    if [ $1 -gt $2 ]; then
        echo $1
    elif [ $2 -gt $1 ]; then
        echo $2
    else
        echo "ninguno, son iguales"
    fi
}

echo "Ingrese dos numeros"
read num1 num2
echo "La multiplicacion de los dos numeros ingresados es: $((num1 * num2))"
echo "La suma de los dos numeros ingresados es: $((num1 + num2))"
echo "La resta de los dos numeros ingresados es: $((num1 - num2))"
echo "El numero mas grande es: $(getMayor $num1 $num2)"

exit 0