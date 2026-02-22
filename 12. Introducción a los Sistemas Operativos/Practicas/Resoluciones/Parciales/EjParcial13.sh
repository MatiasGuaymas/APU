#Realice un script que agregue todos los nombres de usuario del sistema a un arreglo e implemente las siguientes funciones:
#- existe <parametro1>: Devuelve 0 si el usuario existe en el arreglo, 1 en caso contrario
#- eliminar_usuario <parametro1>: Si el usuario pasado como parámetro existe en el arreglo lo elimina del mismo. 
#Caso contrario devuelve código de error 2
#- usuarios_con_patron <parametro1>: Recorre el arreglo e imprime en pantalla los nombres de los usuarios en cuyos caracteres 
#aparece el patrón pasado como parámetro
#- cantidad: Imprime la cantidad total de usuarios en el arreglo
#- usuarios: Imprime todos los nombres de los usuarios que están en el arreglo

arreglo=($(cat /etc/passwd | cut -d: -f1))

existe() {
    for usuario in "${arreglo[@]}"; do
        if [[ "$usuario" == "$1" ]]; then
            return 0
        fi
    done
    return 1
}

eliminar_usuario() {
    for ((i=0; i<${#arreglo[@]}; i++)); do
        if [[ "${arreglo[i]}" == "$1" ]]; then
            unset arreglo[i]
            arreglo=("${arreglo[@]}")
            return 0
        fi
    done
    return 2
}

usuarios_con_patron() {
    for usuario in "${arreglo[@]}"; do
        if [[ $usuario == *"$1"* ]]; then
            echo $user
        fi
    done
}

cantidad() {
    echo ${#arreglo[*]}
}

usuarios() {
    echo ${arreglo[*]}
}

usuarios
cantidad
if existe mati; then
    echo "Existe usuario"
fi
eliminar_usuario mati
usuarios
cantidad
usuarios_con_patron ma



