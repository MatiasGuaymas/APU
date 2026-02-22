#!/bin/bash
#Realice un script que implemente a través de la utilización de funciones las operaciones
#básicas sobre arreglos:
#inicializar: Crea un arreglo llamado array vacío
#agregar_elem <parametro1>: Agrega al final del arreglo el parámetro recibido
#eliminar_elem <parametro1>: Elimina del arreglo el elemento que se encuentra en la
#posición recibida como parámetro. Debe validar que se reciba una posición válida
#longitud: Imprime la longitud del arreglo en pantalla
#imprimir: Imprime todos los elementos del arreglo en pantalla
#inicializar_Con_Valores <parametro1><parametro2>: Crea un arreglo con longitud
#<parametro1>y en todas las posiciones asigna el valor <parametro2>

function inicializar 
{
    arreglo=()
    echo "Arreglo inicializado"
}

function agregar_elem
{
    if [ $# -ne 1 ]; then
        echo "Ingrese un parametro";
        return 1
    fi

    arreglo=(${arreglo[*]} $1)
    echo "Elemento $1 agregado al arreglo"
}

function eliminar_elem
{
    if [ $# -ne 1 ]; then
        echo "Ingrese un parametro";
        return 1
    fi

    if [ $1 -ge ${#arreglo[*]} ]; then
        echo "Posicion invalida"
        return 2
    fi

    unset arreglo[$1]

    arreglo=(${arreglo[*]})

    echo "Elemento $1 fue eliminado"
}

function longitud
{
    echo ${#arreglo[*]}
}

function imprimir
{
    echo ${arreglo[*]}
}

function inicializar_Con_Valores
{
    if [ $# -ne 2 ]; then
        echo "Cantidad de parametros incorrecta"
        return 1
    fi

    inicializar
    for((i=0; i < $1; i++)) do
        agregar_elem $2
    done

    echo "Arreglo inicializado con $1 veces el valor $2"
}

echo "Seleccione una opcion"

select action in inicializar agregar_elem eliminar_elem longitud imprimir inicializar_Con_Valores terminar; do
case $action in
    "inicializar")
        inicializar
    ;;
    "agregar_elem")
        echo "Ingresa un elemento"
        read elemento
        agregar_elem $elemento
    ;;
    "eliminar_elem")
        echo "Ingrese una posicion a borrar"
        read posicion
        eliminar_elem $posicion
    ;;
    "longitud")
        echo "El arreglo tiene $(longitud) elementos"
    ;;
    "imprimir")
        echo "Arreglo: $(imprimir)"
    ;;
    "inicializar_Con_Valores") 
        echo "Ingrese cantidad"
        read cantidad
        echo "Ingrese valor"
        read valor
        inicializar_Con_Valores $cantidad $valor
    ;;
    "terminar")
        echo "Fin"
        exit 0
    ;;
esac
done

