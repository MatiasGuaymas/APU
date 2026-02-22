#!/bin/bash
#Implemente un script que agregue a un arreglo todos los archivos del directorio /home cuya
#terminación sea .doc. Adicionalmente, implemente las siguientes funciones que le permitan
#acceder a la estructura creada:
#verArchivo <nombre_de_archivo>: Imprime el archivo en pantalla si el mismo se
#encuentra en el arreglo. Caso contrario imprime el mensaje de error “Archivo no encontrado” y devuelve como valor de retorno 5
#cantidadArchivos: Imprime la cantidad de archivos del /home con terminación .doc
#borrarArchivo <nombre_de_archivo>: Consulta al usuario si quiere eliminar el archivo lógicamente. 
#Si el usuario responde Si, elimina el elemento solo del arreglo. Si el
#usuario responde No, elimina el archivo del arreglo y también del FileSystem. Debe
#validar que el archivo exista en el arreglo. En caso de no existir, imprime el mensaje
#de error “Archivo no encontrado” y devuelve como valor de retorno 10

archivos=()

cargarArchivos() {
  arch=$(find . -type f -name "*.doc" 2>/dev/null)
  for i in $arch; do
    archivos+=($i)
  done
  echo "Cargados ${#archivos[@]} archivos "
}

verArchivo() {
  if [ $# -eq 0 ]; then
    echo "No hay elementos cargados"
    return 1
  fi

  for archivo in "${archivos[@]}"; do
    nombre=$(basename "$archivo")
    if [ "$nombre" == "$1" ]; then
      echo $(cat $1)
      return 0
    fi
  done

  echo "Archivo no encontrado"
  return 5
}

cantidadArchivos() {
  echo "${#archivos[@]}"
}

borrarArchivo(){
  #Valido que este el archivo : 
  local pos=0
  for i in ${archivos[*]}
  do
    if [ $1 == $i ]
    then
      echo "Si  quire eliminar el archivo logicamente responda : si "
      read respuesta
      case $respuesta in
      si)
        #Eliminamos el archivo del arreglo
        unset archivos[$pos] 
        echo "Se elimino el archivo"
      ;;
      no) 
        #Eliminamos el archivo original
        unset archivos[$pos]
        ruta=$(find $HOME -name "$1" )
        rm "$ruta"
        echo "Eliminación del archivo correctamente"
      ;;
      *)
        echo "El valor ingreasado es incorrecto"
        return 1
      ;;
      esac
      return 0
    fi
    ((pos++))
  done
  echo "El archivo no existe"
  return 10
  
}

cargarArchivos
verArchivo
verArchivo ejemplo2.doc
borrarArchivo ejemplo2.doc





