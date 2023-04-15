# appbancamovil
Challenge Interbank: Desarrollo de App Banca Móvil

En este documento se irá detallando el proceso de construcción de la aplicación:

--------------------------CONSIDERACIONES PARA LEVANTAR EL PROYECTO--------------------------

ELECCIÓN DE VERSIONES
La elección de las diversas versiones de las dependencias fueron hechas con la finalidad principal de que trabajen en compatibilidad entre sí,
priorizando versiones estables de cada una de las dependencias para su uso.

LEVANTAMIENTO DEL PROYECTO
Para la recreación de los servicios, se ha hecho uso del software "Mockoon", el cual permite realizar el diseño de mock REST APIs de manera local.
En enlace de descarga es el siguiente: https://mockoon.com/

Una vez descargado y abierto Mockoon, se debe cargar el siguiente ambiente: "bancamovil.json", que contiene los 4 servicios a usar.
Para abrir este ambiente, se debe acceder al menú File, y luego Open Enviroment, cargando el archivo "bancamovil.json".
El ambiente se puede descargar de esta ruta: https://drive.google.com/file/d/1S3r_0faSy1_gGCBjMzlqby--MEpONc2S/view?usp=sharing
Luego de cargar el ambiente, se da click en el Botón Play Verde "Start Server" y con ello ya está funcionando de manera local.

Adicional a ello, se debe obtener la ip pública de la PC en donde se levanta el proyecto. Para ello se puede abrir el CMD, colocar ipconfig, y copiar
la Dirección IPv4 (ejemplo. 192.168.1.10).
Esta ip pública debe ser colocada reemplazando a la ip actual, en la línea 23 de la clase NetworkModule:
.baseUrl("http://192.168.1.8:3001/")  ---->  .baseUrl("http://192.168.1.10:3001/")

Con ello, ya se puede levantar el proyecto de manera local y probar las funcionalidades.

USUARIO DE LOGIN:
El usuario único con el que el login funciona actualmente es:
DNI: 71006457
PASS: 123456

Se pueden agregar más usuarios desde Mockoon y el servicio iniciarSesion(), pero tiene sus limitaciones debido a que no se tiene como referencia una BD.

----------------------------------------------*----------------------------------------------

-----------------------------FLUJO DE IMPLEMENTACIÓN DEL PROYECTO----------------------------

1. Generación de la estructura de carpetas del patrón MVVM:
    Se ha hecho elección de este patrón de diseño, debido a que es un patrón que es muy versátil para hacer una separación de lo que respecta
    a la capa de Datos con la capa de Presentación. Esto nos ayuda a tener un orden bastante claro del formato del proyecto.

2. Generación de las vistas de la aplicación:
    Se continúa con el diseño de las vistas y la navegabilidad en la aplicación. Con ello se puede comprobar que el flujo es el correcto
    de manera visual y se puede realizar la implementación de la data.

3. Implementación de los servicios y de estructura MVVM y Clean Architecture: 
    Para la implementación de los servicios, se ha considerado crear un mock local (con las indicaciones en LEVANTAMIENTO DEL PROYECTO) haciendo uso de REST APIs
    con la finalidad de hacer uso de Retrofit en la aplicación. Se hace uso de ApiClients, Services, Providers para la obtención de datos de los servicios,
    y se hace uso de Repositories, UserCases y ViewModels para llevar la información a las vistas.

4. Inyección de dependencias:
    Para evitar la necesidad de crear instancias de los componentes, se hace uso de la inyección de dependencias, en este caso de DaggerHilt, el cual fue implementado
    a nivel de toda la aplicación (Activities, Fragments, ViewModels, Repositories, Apis, etc.)

5. Implementación de funcionalidades:
   Se realizó la implementación de las funcionalidades complementarias para la aplicación: Cerrar sesión luego de 2 minutos de estar logueado, Refrescar Lista de Productos,
   Colocar Pantalla de carga mientras consulta Movimientos, Copiar al portapapeles el número de cuenta.


----------------------------------------------*----------------------------------------------

--------------------------------CONSIDERACIONES DE APLICACIÓN--------------------------------

Hay algunas consideraciones en las cuales se puede mejorar. Por ejemplo, para el cierre de sesión luego de tiempo determinado o inactividad, lo recomendable es tener un servicio
asociado a un token único, y que al vencimiento del token se determine el cierre de sesión. Esto se daría en una situación más real.

Para las respuestas de los servicios se optó por el mapeo exitoso de los Response respectivos. En un desarrollo real se debe mapear las respuestas no exitosas, para tener control del
reporte y control de errores en la aplicación.

También se pudo tomar como alternativa en consideración para la navegación general el uso de GraphNavigation con safeNavigate, pero se optó por el replaceFragment para la navegación debido 
al tiempo de implementación de la aplicación, con la intención de poder coberturar las funcionalidades en su totalidad.

Se añadió un elemento de retroceso para las pantallas de Productos y Consultas, para agilizar la funcionalidad de retroceso y asemejarse más a una aplicación real.

Se buscó separar la línea de programación (ApiClients, Services, Providers, Repositories, UserCases y ViewModels) en archivos de acuerdo a la funcionalidad, con la intención de mostrar
de una mejor manera los flujos y los casos de uso dados en la aplicación, de tal forma de que se mantenga la organización y el entendimiento de la aplicación.


----------------------------------------------*----------------------------------------------

