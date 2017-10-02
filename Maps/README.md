Maps
-

Este proyecto contiene un ejemplo simple de una aplicación en Android que incluye los siguientes componentes:

* MainActivity: ventana principal de la app. Muestra:
  * Un mensaje con la posición actual del usuario y/o solicita los permisos necesarios en tiempo de ejecución (dependiendo de la versión de Android en la cual se encuentre). Se utiliza el concepto de [Strings con formato](https://developer.android.com/guide/topics/resources/string-resource.html#FormattingAndStyling).
  * Un botón para abrir un mapa (en otro Activity).
* MapsActivity: Muestra un mapa centrado en la sede aulas de la UNPSJB de Trelew, Chubut, Argentina con un mensaje personalizado que puede verse al hacer click sobre el marker en pantalla.

Importante: Todos los mensajes pueden y debieran modificarse accediendo al archivo `strings.xml` ubicado en la carpeta `res->values`.

#### Screenshots

![](https://i.imgur.com/drh5Fx2.png) 
![](https://i.imgur.com/pgg6Sp4.png)

