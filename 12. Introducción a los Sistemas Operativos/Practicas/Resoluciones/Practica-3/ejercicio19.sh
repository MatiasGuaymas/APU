#!/bin/bash
#Escribir un Programa de “Menu de Comandos Amigable con el Usuario” llamado menu, el
#cual, al ser invocado, mostrará un menú con la selección para cada uno de los scripts creados
#en esta práctica. Las instrucciones de como proceder deben mostrarse junto con el menú.
#El menú deberá iniciarse y permanecer activo hasta que se seleccione Salir. Por ejemplo:
#MENU DE COMANDOS
#03. Ejercicio 3
#12. Evaluar Expresiones
#13. Probar estructuras de control
#...
#Ingrese la opción a ejecutar: 03

if [ $# -ne 0 ] ; then
	echo "Este script no requiere de parámetros"
	exit 1
fi

select action in $(ls | grep ".sh") Salir ; do
	case $action in
		"Salir")
			echo "Saliendo del menú"
			exit 0 ;;
		*) bash $action ;;
	esac
done

