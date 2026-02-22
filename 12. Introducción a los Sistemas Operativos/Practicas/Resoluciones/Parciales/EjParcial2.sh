#Realice un script que agregue todos los nombres de usuario del sistema a un arreglo e implemente las siguientes funciones: 
#- existe <parametro1>: Imprime el índice dentro del arreglo donde está el usuario <parametro1>, sólo si este existe en el arreglo. 
#Adicionalmente, debe retornar 0 si el usuario existe en el arreglo ó 1 en caso contrario.
#-eliminar_usuario <parametro1>: Si el usuario pasado como parámetro existe en el arreglo, lo elimina del mismo. 
#Caso contrario retorna código de error 2.
#- usuarios_con_patrón <parametro1>: Recorre el arreglo e imprime en pantalla los nombres de los usuarios en cuyos caracteres aparece 
#el patrón <parametro1>.
#- cantidad: Imprime la cantidad total de usuarios en el arreglo.
#- usuarios: Imprime todos los nombres de los usuarios que están en el arreglo.
#Luego de definir las funciones, deberá proveer un breve cuerpo del script que los utilice, a modo de ejemplo.

usuarios=($(cut -d: -f1 /etc/passwd))

existe() {
    local usuario=$1
    for i in "${!usuarios[@]}"; do
        if [[ "${usuarios[$i]}" == "$usuario" ]]; then
            echo "El usuario '$usuario' se encuentra en el índice: $i"
            return 0
        fi
    done
    return 1
}

eliminar_usuario() {
    local usuario=$1
    if existe "$usuario"; then
        unset 'usuarios[$i]'
        echo "Usuario '$usuario' eliminado del arreglo."
    else
        echo "Error: Usuario '$usuario' no encontrado en el arreglo."
        return 2
    fi
}

usuarios_con_patron() {
    local patron=$1
    echo "Usuarios que contienen el patrón '$patron':"
    for usuario in "${usuarios[@]}"; do
        if [[ "$usuario" == *"$patron"* ]]; then
            echo "$usuario"
        fi
    done
}

cantidad() {
    echo "${#usuarios[*]}"
}

usuarios() {
    echo "${usuarios[*]}"
}

echo "### Lista inicial de usuarios ###"
usuarios

echo
existe "root"
echo

eliminar_usuario "root"
echo

usuarios_con_patron "mati"
echo

cantidad
echo

usuarios

