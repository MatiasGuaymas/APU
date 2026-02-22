#Escriba un script que reciba una cantidad desconocida de parámetros al momento de su invocación (debe validar que al menos se reciba uno). 
#Cada parámetro representa la ruta absoluta de un archivo o directorio en el sistema. El script deberá iterar por todos los parámetros recibidos, y 
#-Si el parámetro es un archivo existente en el File System deberá comprimirlo dejando el archivo comprimido en lugar del original. 
#-Si el parámetro es un directorio existente en el File System:
#   -Si tiene permiso de Lectura deberá empaquetarlo y comprimirlo
#   -Si tiene permiso de escritura deberá eliminarlo junto con todo su contenido
#-Si el parámetro no es un elemento del File System (no existe), deberá contarlo e indicar la cantidad total al finalizar el script.

if [ $# -eq 0 ]; then
    echo "Ingrese al menos un parametro"
    exit 1
fi

inexistentes=0

for elem in "$@"; do
    if [ -e "$elem" ]; then
        if [ -f "$elem" ]; then
            tar -czf "$elem.tar.gz" -C "$(dirname "$elem")" "$(basename "$elem")" && rm "$elem"
        elif [ -d "$elem" ]; then
            if [ -r "$elem" ]; then
                tar -czf "$param.tar.gz" -C "$(dirname "$param")" "$(basename "$param")"
            fi
            if [ -w "$elem" ]; then
                rm -rf "$elem"
            fi
        fi
    else
        ((inexistentes++))
    fi
done

echo "Cantidad inexistentes $inexistentes"

exit 0
        

