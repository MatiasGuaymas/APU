
---

### Entrevista Formateada - Sistema "Alquiler Express"  
**Entrevistado:** María  
**Fecha:** 28 de marzo de 2025  
**Hora:** 16:00 p. m.  
**Lugar:** Facultad de Informática UNLP  
**Tema:** Detalles específicos del sistema "Alquiler Express"  
**Objetivo:** Obtener información concreta sobre las funcionalidades, requisitos y operativa del sistema  
**Duración total estimada:** 35 minutos  

---

### 1. Presentación  
"Buenas tardes, María. Muchas gracias por volver a reunirse con nosotros. Soy Francisco, y me acompañan nuevamente mis compañeros de GLA Software. En esta ocasión tanto Francisco como Matheo serán los encargados de documentar la entrevista. En nuestra primera entrevista, obtuvimos una visión general de su negocio y sus necesidades. Hoy nos gustaría enfocarnos en los detalles del sistema que estamos diseñando para 'Alquiler Express'. Queremos asegurarnos de que cubra todas sus expectativas y sea una herramienta útil tanto para usted como para su equipo y clientes. ¿Está lista para comenzar?"

---

### 2. Preguntas para la Segunda Entrevista

#### 1. Funcionalidades básicas del sistema y operativa  
1. **Proceso de alquiler:** ¿Puede detallar paso a paso cómo le gustaría que funcione el proceso de alquiler desde la búsqueda hasta el pago?  
   - Los clientes buscan una propiedad en las redes sociales. Luego, se acercan a una sucursal y muestran interés por la propiedad. El empleado verifica la disponibilidad en los días solicitados por el cliente (ingreso a las 3:00 p. m., salida a las 10:00 a. m., aunque puede haber excepciones). Si está disponible, se discute el precio. Una vez acordado, el cliente realiza el pago total por el medio que desee (presencial o remoto). La propiedad queda reservada a nombre del cliente, quien debe acercarse el día de inicio a la sucursal más cercana (hay una por localidad con propiedades) para retirar la llave. Se registra la entrega de la llave (hora, día, etc.) en el sistema. Al finalizar, el cliente devuelve la llave en la sucursal (puede haber excepciones, como quedarse unas horas más). El empleado registra la devolución. La propiedad no queda disponible inmediatamente tras la devolución; primero, se limpia y se devuelve a condiciones óptimas, y luego se actualiza su disponibilidad en el sistema.

2. **Sistema de reservas:** ¿Cómo imagina el proceso de reserva paso a paso? ¿Es inmediato o requiere aprobación?  
   - El proceso debe ser presencial, pero también se permite pagar desde casa. El empleado carga los datos en el sistema. La reserva es inmediata: si el cliente paga y es mayor de edad, la propiedad queda reservada automáticamente sin necesidad de aprobación adicional.

3. **Tiempo mínimo de alquileres:** ¿Existe un tiempo mínimo para alquilar una propiedad? ¿Varía según el tipo (vivienda o local)?  
   - El tiempo mínimo depende de cada propiedad y se define de forma individual. No hay una regla general; varía según la propiedad específica.

4. **Política de cancelación:** ¿Cuáles son las reglas específicas para cancelar una reserva? ¿Hay penalizaciones o reembolsos? ¿Quién las configura?  
   - Cada propiedad tiene su propia política de cancelación, y esa es la que se aplica y se muestra al cliente. No se especificaron detalles adicionales sobre penalizaciones o reembolsos; se respeta la política individual de cada propiedad.

5. **Disponibilidad de propiedades:** ¿Cómo se mostrará la disponibilidad (calendario, lista)? ¿Actualización manual o automática?  
   - Inicialmente, se muestra la disponibilidad según las fechas ingresadas por el cliente (si la propiedad está libre en ese rango). No se especificó si será calendario o lista, pero la actualización parece ser manual tras la limpieza y devolución a condiciones óptimas.

6. **Inicio de sesión:** ¿Cómo imagina el inicio de sesión para clientes, empleados y gerentes? ¿Todos ven lo mismo al entrar o cada rol tiene una vista diferente? ¿Los empleados y gerentes usarán correos específicos para acceder (ej. un correo de la empresa)?  
   - Cada empleado y gerente inicia sesión con su propio correo (no se especificó si debe ser corporativo). Los roles tienen vistas diferentes: los empleados registran entregas y devoluciones de llaves, reservas y pagos, pero no pueden ver estadísticas, datos de otros empleados ni cargar propiedades. Los gerentes tienen acceso a todo, incluyendo cargar propiedades, gestionar empleados y estadísticas.

#### 2. Propiedades y datos mostrados  
7. **Datos a mostrar para el cliente (alquiler de vivienda):** ¿Qué información específica debe ver el cliente sobre una vivienda (ej. metros cuadrados, servicios incluidos, etc.)?  
   - El cliente debe ver: localidad, dirección, cantidad de habitaciones, baños, categoría, política de cancelación, precio por día y fotos.

8. **Datos a mostrar para el cliente (alquiler de local):** ¿Y para un local comercial? ¿Qué datos son prioritarios (ej. ubicación, tamaño, permisos)?  
   - Es igual que para viviendas, salvo que cambia la categoría (se asume que se adapta al tipo de local).

9. **Google Maps:** ¿Quiere integrar mapas para mostrar la ubicación exacta de las propiedades? ¿Qué nivel de detalle necesita?  
   - Sí, se deben mostrar mapas con la ubicación de la propiedad, y se podría incluir la foto, nombre y precio.

10. **Cargado de fotos:** ¿Cuántas fotos máximo por propiedad le gustaría permitir? ¿Hay requisitos de tamaño o formato?  
    - Todas las propiedades deben tener al menos una foto. No se especificó un máximo ni requisitos de tamaño o formato.

11. **Gestión de propiedades:** ¿Quién carga las propiedades al sistema y las actualiza? ¿Solo el gerente o también los empleados?  
    - Solo el gerente carga y actualiza las propiedades en el sistema.

#### 3. Precios y pagos  
12. **Precios por día:** ¿Los precios serán fijos o dinámicos (según demanda o temporada)? ¿Quién los ajusta?  
    - Los precios son dinámicos y los ajusta el gerente según sea necesario. Por ahora, no hay interés en descuentos.

13. **Tarifas por temporada:** ¿Habrá precios diferenciados por temporada alta/baja? ¿Cómo se definirán?  
    - Sí, habrá precios diferenciados por temporada alta y baja. No se especificó cómo se definirán, pero se asume que lo decide el gerente.

14. **Descuentos:** ¿Quiere ofrecer descuentos o promociones? ¿Quién los configura y cómo se aplican?  
    - Por ahora, no le interesa incluir descuentos ni promociones.

15. **Depósitos:** ¿Habrá un sistema de depósitos o garantías? ¿Cómo se registran y devuelven?  
    - No se mencionó nada sobre depósitos o garantías.

16. **Pago online:** ¿Qué métodos de pago online desea integrar (MercadoPago, PayPal, etc.)? ¿Habrá comisiones visibles para el cliente?  
    - Solo se aceptan tarjeta, transferencia bancaria y efectivo presencial. No se mencionaron comisiones visibles.

17. **Plataformas de pago:** ¿Con qué plataformas específicas quiere integrar el sistema (MercadoPago, PayPal, transferencia bancaria)?  
    - Solo transferencia bancaria para pagos online.

18. **Pago presencial:** ¿Cómo se registrarán los pagos en efectivo o presenciales en el sistema?  
    - El empleado es responsable de cargar los pagos en efectivo en el sistema.

19. **Facturas del pago:** ¿Necesita que el sistema genere facturas automáticas? ¿Qué datos deben incluir?  
    - Sí, el sistema debe generar un comprobante automático con los datos de la persona (nombre, apellido), monto y fecha.

#### 4. Roles y gestión interna  
20. **Diferencia entre gerente y empleado:** ¿Cuáles son las funciones y permisos específicos de cada rol en el sistema? ¿Podrías detallarnos un poco más sobre la diferencia en las tareas de un empleado y un gerente?  
    - **Empleado:** Registra entregas y devoluciones de llaves, reservas, pagos en efectivo y datos de clientes nuevos. 
    - **Gerente:** Puede hacer todo lo que hace un empleado, además de cargar y eliminar propiedades, dar de alta y baja a empleados y gerentes, y acceder a estadísticas. Un gerente puede gestionar a otro gerente (todos son empleados también).

21. **Funciones administrativas:** ¿Qué herramientas específicas necesita el gerente para gestionar el negocio desde el sistema?  
    - No se detallaron herramientas específicas, pero se infiere que necesita gestionar propiedades, empleados, gerentes y estadísticas.

23. **Sucursales:** ¿El sistema debe manejar múltiples sucursales? ¿Cada una tendrá sus propias propiedades y estadísticas?  
    - Sí, el sistema debe manejar múltiples sucursales (una por localidad con propiedades). No se especificó si cada una tendrá estadísticas propias.

#### 5. Clientes y datos  
24. **Datos del cliente:** ¿Qué información se guardará de los clientes al realizar un alquiler (nombre, DNI, teléfono, etc.)?  
    - Nombre, apellido, DNI, correo electrónico y teléfono.

25. **Historial de alquiler:** ¿Qué detalles del historial de un cliente deben guardarse y mostrarse?  
    - Nombre, apellido, DNI e historial de alquileres previos.

26. **Reseñas y calificaciones:** ¿Quiere que los clientes puedan dejar reseñas y calificaciones? ¿Serán públicas o internas?  
    - Sí, los clientes pueden dejar reseñas y un puntaje de 1 a 5. Son públicas.

#### 6. Notificaciones y comunicación  
27. **Notificaciones:** ¿Qué eventos deben generar notificaciones (reservas, cancelaciones)? ¿Por WhatsApp, email o en el sistema?  
    - Notificaciones por reservas cercanas y si se efectivizó una cancelación. Se envían por correo electrónico.

28. **Recordatorios:** ¿Qué tipo de recordatorios necesita (pago pendiente, fin de alquiler)? ¿A clientes o empleados?  
    - Recordatorios a clientes sobre reservas cercanas y cancelaciones (mismos eventos que las notificaciones).

29. **Medios de comunicación:** ¿Qué canales prefiere para que los clientes se contacten con soporte (email, WhatsApp, teléfono)?  
    - Correo electrónico o un número de WhatsApp.

30. **Soporte al cliente:** ¿Habrá un chat en el sistema o un apartado de preguntas frecuentes?  
    - No habrá chat en el sistema. Sí habrá un apartado de preguntas frecuentes.

#### 7. Estadísticas y reportes  
31. **Estadísticas deseadas:** ¿Qué aspectos del negocio le gustaría analizar con estadísticas (ej: ingresos, ocupación, rendimiento por propiedad)?  
    - Usuarios nuevos registrados (cantidad entre fechas), alquileres realizados (entre fechas) y dinero ingresado semanalmente. Solo visibles para gerentes.

32. **Nivel de detalle:** ¿Qué tan detalladas quiere que sean estas estadísticas (ej. por día, mes, sucursal, tipo de propiedad)?  
    - No se especificó el nivel de detalle, pero se mencionaron periodos entre fechas y semanalmente.

33. **Vista de estadísticas:** ¿Tanto los empleados como gerentes pueden ver las mismas o solo un grupo en particular?  
    - Solo los gerentes pueden ver las estadísticas.

#### 8. Diseño y experiencia de usuario  
34. **Diseño general:** ¿Tiene alguna preferencia inicial sobre cómo le gustaría que se vea el sistema (colores, estilo)?  
    - En la landing page, la localidad y la fecha de ingreso deben ser más accesibles. No mostrar el mínimo de días en la vista previa. Mostrar la calificación promedio de estrellas. Incluir un apartado de preguntas y respuestas de usuarios, un área de notificaciones y una sección con la historia de la empresa. Tipografía deseada: Montserrat. Colores: gris elegante.

35. **Gama de colores:** (Mostrando paleta) ¿Qué combinación de colores prefiere para la interfaz?  
    - Paleta de gris elegante.

36. **Diseño minimalista:** ¿Prefiere un diseño simple y limpio o algo más detallado y visual?  
    - Algo similar al prototipo mostrado (no se especificó más).

37. **Apartado de información:** ¿Qué contenido debe incluir la sección "Acerca de" (historia, valores, contacto)?  
    - Un poco de la historia y los valores de la empresa. No se detallaron datos específicos, pero la funcionalidad es de interés.

### 9. Seguridad y manejo de errores  
38. **Seguridad:** ¿Qué medidas de seguridad espera (contraseñas, verificación de clientes, backups)?  
    - Los gerentes deben ingresar un código aleatorio nuevo, generado y enviado a su correo electrónico.

#### 10. Personalización y cierre  
40. **Funcionalidad adicional:** ¿Hay alguna función que no mencionamos y que le gustaría incluir en el sistema?  
    - El empleado registra usuarios nuevos, carga nuevos empleados y modifica datos de propiedades. El gerente tiene un apartado para dar de alta y baja a empleados y gerentes.

41. **Casos excepcionales:** Cuando ocurran situaciones excepcionales, como una propiedad duplicada, ¿prefiere que el sistema muestre mensajes especiales para que usted decida o que nosotros definamos una respuesta automática?  
    - Nosotros (el equipo de desarrollo) definimos la respuesta automática.

42. **Elementos de diseño:** ¿Cuenta con un logo que le gustaría que integremos en el sistema? ¿Prefiere alguna tipografía específica (mostrándole ejemplos como Arial, Times New Roman, Roboto, etc.)?  
    - Tipografía: Montserrat (ya mencionada). El logo de la empresa será enviado por interno.

43. **Resolución de conflictos:** En casos como reservas conflictivas (ej. dos clientes reservan la misma propiedad al mismo tiempo), ¿cómo le gustaría que el sistema lo notifique o resuelva?  
    - Nosotros (el equipo de desarrollo) definimos la respuesta automática.

---

### 3. Cierre  
"María, muchísimas gracias por tu tiempo y por toda la información que nos brindaste hoy. Con esto, tenemos una idea mucho más clara de cómo diseñar 'Alquiler Express' para que sea una herramienta útil y eficiente para tu negocio. Vamos a trabajar en una propuesta concreta basada en lo que nos contaste y, si te parece bien, nos gustaría coordinar una tercera reunión para presentarte un avance. ¿Hay algo más que quieras agregar antes de cerrar esta entrevista?"

---