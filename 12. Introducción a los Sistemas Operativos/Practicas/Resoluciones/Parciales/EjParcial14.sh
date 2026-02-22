#Realice un script que agregue a un arreglo todos los archivos (archivos regulares, no subdirectorios) de un directorio que recibe 
#como primer parámetro, y que en función de los parámetros restantes que se le envíen realice las siguientes operaciones:
# -a Agrega al arreglo los archivos regulares del directorio cuya ruta_a_otro_directorio ruta es ruta_a_otro_directorio.
# -d un_patron [-f] Elimina del arreglo todos los archivos cuyo nombre coincide con el patrón un_patron. 
#El parámetro -f es opcional, y si está presente deberá borrar el archivo del filesystem también.
#Las operaciones deberán ser implementadas utilizando funciones y deberán recibir como parámetro cualquier valor que sea necesario para su funcionamiento.
#En todos los casos, deberá realizar las validaciones pertinentes de los parámetros recibidos, y deberá imprimir el contenido del arreglo 
#al terminar el script. Puede asumir que el orden de los parámetros no variará del indicado en cada caso.
#Por ejemplo, asumiendo que el script se llama mi_script.sh:
#./mi_script.sh /etc -a /var/log
#Agregará en el arreglo los archivos del directorio /etc y a continuación los del directorio /var/log, 
#y finalmente imprimirá a salida estándar el contenido final del arreglo.
#./mi_script.sh /var/log -d .gz
#Agregará en el arreglo los archivos del directorio /var/log, borrará (solo del arreglo) aquellos que contengan el patrón .gz, 
#e imprimirá a salida estándar el contenido final del arreglo. 
#./mi_script.sh /var/log -d .gz -f
#Agregará en el arreglo los archivos del directorio /var/log, borrará (del arreglo y del filesystem) aquellos que contengan el patrón .gz, 
#e imprimirá a salida estándar el contenido final del arreglo.

#!/bin/bash

# Validar que se haya proporcionado al menos 1 directorio y al menos 1 operación
if [ $# -lt 1 ]; then
    echo "Uso: $0 <directorio> [-a <directorio_adicional>] [-d <patron> [-f]]"
    exit 1
fi

# Obtener el directorio original y crear un arreglo
dirOriginal="$1"
arreglo=($(find "$dirOriginal" -maxdepth 1 -type f))

# Función para agregar archivos de otro directorio al arreglo
agregarDesdeDirectorio() {
    if [ $# -ne 1 ]; then
        echo "Falta un parámetro para -a"
        return 1
    fi

    if [[ ! -d "$1" ]]; then
        echo "Esto no es un directorio válido: $1"
        return 2
    fi

    # Agregar archivos regulares del nuevo directorio al arreglo
    archivosNuevos=($(find "$1" -maxdepth 1 -type f))
    arreglo+=("${archivosNuevos[@]}")
}

# Función para eliminar archivos del arreglo y, opcionalmente, del sistema de archivos
eliminarConPatron() {
    if [[ "$1" != "-d" ]]; then
        echo "El primer parámetro debe ser -d"
        return 1
    fi

    local patron="$2"
    local eliminarDelFS=false

    if [[ "$3" == "-f" ]]; then
        eliminarDelFS=true
    fi

    # Crear un arreglo temporal para almacenar los archivos que se mantienen
    local arregloTemporal=()

    # Recorrer el arreglo original
    for archivo in "${arreglo[@]}"; do
        if [[ "$archivo" == *"$patron"* ]]; then
            if $eliminarDelFS; then
                rm "$archivo" 2>/dev/null
                if [[ $? -eq 0 ]]; then
                    echo "Eliminado del sistema de archivos: $archivo"
                else
                    echo "Error al eliminar: $archivo"
                fi
            fi
        else
            arregloTemporal+=("$archivo")  # Mantener el archivo
        fi
    done

    # Actualizar el arreglo original
    arreglo=("${arregloTemporal[@]}")
}

# Procesar los parámetros
shift  # Desplazar para manejar los parámetros restantes

while [ $# -gt 0 ]; do
    case "$1" in
        -a)
            shift
            agregarDesdeDirectorio "$1"
            ;;
        -d)
            shift
            eliminarConPatron "$1" "$2" "$3"
            shift 2
            ;;
        *)
            echo "Opción no válida: $1"
            exit 1
            ;;
    esac
    shift  # Desplazar al siguiente parámetro
done

# Imprimir el contenido final del arreglo
echo "Contenido final del arreglo:"
for archivo in "${arreglo[@]}"; do
    echo "$archivo"
done

