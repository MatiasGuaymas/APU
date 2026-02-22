#Se desea implementar un reproductor multimedia en bash para archivos de audio y video, que debe funcionar de la siguiente
#El script recibe como parámetros un flag que indica el tipo de los contenidos a reproducir (-m o -v, para música o video respectivamente), 
#y una lista de rutas a los archivos que se quieren reproducir.
#Primero se deberá validar que se indique el tipo de los archivos (por simplicidad serán o bien todos de audio, o bien todos de video, 
#pero no mezclados), y que se reciba al menos un archivo a reproducir (el número de archivos a reproducir es desconocido de antemano).
#Luego se comenzará la reproducción de los archivos en el orden en que se los recibió, validando antes de reproducir cada archivo si éste existe 
#en el file system. En caso de no existir, se debe guardar el error en el archivo /var/log/reproductor.error consignando la fecha del error y 
#la ruta al archivo que no existe. Si el archivo sí existe, se lo debe reproducir con el comando vlc, pasándole como parámetros la ruta al archivo 
#y el tipo de reproducción (-m ó -v). Por ejemplo: vlc mitema.mp3 -m ó vlc mivideo.mp4 -v

#!/bin/bash

logFile="/var/log/reproductor.error"

registrarFallo() {
    echo "$(date '+%Y-%m-%d %H:%M:%S') - $1" >> $"logFile"
}

if [ $# -ne 2 ]; then
    echo "No se pasaron la cantidad minima de parametros"
    exit 1
fi

tipo=$1
shift

if [[ "$tipo" != "-m" && "$tipo" != "-v" ]]; then
    echo "Se debe indicar -m o -v"
    exit 2
fi


for arc in "$@"; do 
    if [ ! -f "$arc" ]; then
        registrarFallo $1
    else
        vlc "$arc" "$tipo" 
    fi
done
