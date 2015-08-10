QueProponenMDQ!
===================

**QueProponenMDQ** es una app para sistemas operativos Android 4.0 o superior que recoge la lista de precandidatos a intendente para la ciudad de Mar del Plata para las elecciones 2015

**Como conseguirla**
-------------
[![](https://developer.android.com/images/brand/es-419_generic_rgb_wo_60.png)](https://play.google.com/store/apps/details?id=com.coffeeandcookies.queproponenmdq)

**Como replicar**
-------------

 - Hace un fork del repositorio, descarga el repositorio o clonarlo
 - Modificar el `Android Manifiest.xml` para cambiar el nombre de la app, el logo, el nombre del paquete y la versión de la app (las nuevas apps empiezan en 1.0).
 - Recolectar: a) nombres de los candidatos b) imágenes (100*100 px) c) partidos que pertenecen d) link a sus propuestas.
 - Las imagenes van dentro de la carpeta `drawable-hdpi`
 - Volcar datos en `array.xml` Hay un arreglo para cada atributo. Tener precaución que cada arreglo tenga la misma cantidad de elementos. Las imágenes van cargadas sin la extensión. El arreglo `paso` indica si el candidato supero la instancia de PASO. `0` es para aquellos pre-candidatos que no superaron el piso establecido por ley, mientras que el valor `1` es para los que competiran en octubre. 
 - Probar.
 - Generar APK.
 - Subir app

**Agradecimientos**
-------------

> - [Partido de la Red](partidodelared.org) por generar [QueProponen](queproponen.com.ar)
> - Lucia Fernanda Martin por la carga de propuestas.
> - Equipo tecnico del PdR MDQ liderado por Gonzalo Benoffi que desarollo la app.

**Contacto**
-------------

[Facebook](https://www.facebook.com/PartidodelaRedMDQ)
[Twitter](https://twitter.com/pdr_mardelplata/)
[Mail](mailto:hola@partidodelaredmdq.org)
