# api-store

Esta es mi solucion tecnologica para una api-rest que tiene como proposito el manejo de los productos de una tienda en relacion con un carro de compras,
implementando tambien un proceso de registro y login para los usuarios. 

## Como se abordo el problema 🦁

Lo primero que hice fue dividir el desarrollo en 3 fases principales:

  -> Implementacion del registro y el login de usuarios. tarea-1
  
  -> Creacion del servicio Rest junto con la logico de negocio. tarea-2
  
  -> Implementacion de las pruebas unitarias y de integracion.  tarea-3
  

Teniendo en cuenta esto y viendo que el sistema puede tener una modularidad decidi usar la arquitectura de capas, me parecio importante que estamos
hablando de una tiendo online asi que es probable que necesite escalabilidad a futuro.

Habiendo seleccionado la arquitectura decidi utilizar facade como patron principal de diseño, ya durante el desarrollo utilice algunos adicionales como 
el singleton para manejar el encriptamiento de la clave de los usuarios,builder, bridge.

TECNOLOGIAS:
Elegi el lenguaje de programacion en el cual tengo mayor conocimiento (java 1.8), utilice el framework de spring boot, para el manejo de datos elegi MySql.

TAREA 1 : Empece por el registro y login ya que para mi era la parte mas tediosa, implemente los formularios a partir de los templates de bootstrap, 
          configure la libreria de seguridad de spring para este flujo y por ultimo se sincronizo esto con la BDD.
          
          
TAREA 2 : En esta parte pense en hacer un modelo de datos con una tabla para los productos y otra para el carro de compras pero deseche la idea porque la
          logica de negocia quedaba algo sucia y las relaciones entre la tablas no eran claras asi que utilice unos campos en producto para validar si 
          el producto estaba en stoc y en el carro, la logica se explica en detalle dentro de la documentacion del codigo.
          
          
TAREA 3 : Ya que la app estaba funcional solo faltaba importar junit y escribir las pruebas para la logica de la tarea 2.



## Comenzando 🚀

Aunque se pueden usar otras herramientas para ejecutar el proyecto recomiendo utilizar las mismas con las que fue desarrollado para evitar temas de compatibilidad.

- Descargamos nuestro codigo fuente desde https://github.com/jerestrepod/api-store
- Desde spring-tool importamos el proyecto desde la ubicacion que que descargamos el fuente



### Pre-requisitos 📋

*jdk 1.8

*spring-tool 4.4.9 o superior

*admin de base de datos mySQL


## Ejecutando las pruebas Unitarias⚙️

Las prubas unitarias se deben ejecutar antes de iniciar el proyecto.
Para ello simplemente vamos a la clase com.co.store.BusinessUnitTest que se encuentra dentro del paquete de pruebas src/test/java,
damos clic derecho en la clase y Run as -> JUnit test. de esta manera se ejecutaran las pruebas unitarias.

NOTA: cada una de las funcionalidades que se esta probando esta documentada dentro del codigo.

## Ejecutando las pruebas Integracion⚙️

Las prubas de integracion se deben ejecutar despues de iniciar el proyecto.
Para ello simplemente vamos a la clase com.co.store.ApiStoreApplicationTests que se encuentra dentro del paquete de pruebas src/test/java,
damos clic derecho en la clase y Run as -> JUnit test. de esta manera se ejecutaran las pruebas de integracion.

NOTA: cada una de las funcionalidades que se esta probando esta documentada dentro del codigo.

## Persistencia 📦

Para que el rest despliegue correctamente es necesario configurar la conexion local a la BDD la cual se encuenta en src/main/resources/templates/aplication.yml
y configurar los valores de url, username y password del datasource.

Adicional se debe crear la base de datos que para nuestro caso se llama store de la siguiente manera.

```
 CREATE DATABASE store;
```
   
A partir de esto ya podemos desplegar el api y generara automaticamente todos los mapeos de las entidades en la base de datos store.

Una vez que tengamos nuestras entidades mapeadas podemos insertar los productos que deseemos a continuacion unos ejemplos:

```
INSERT INTO store.products (brand, in_shopping_car, price, product_name, stock)
VALUES ("samsung", 0, "700usd", "cellphone", 2);

INSERT INTO store.products (brand, in_shopping_car, price, product_name, stock)
VALUES ("debird", 0, "300usd", "deckbox", 10);

INSERT INTO store.products (brand, in_shopping_car, price, product_name, stock)
VALUES ("fender", 0, "3000usd", "bass", 1);

INSERT INTO store.products (brand, in_shopping_car, price, product_name, stock)
VALUES ("rolex", 0, "8000usd", "clock", 1);

INSERT INTO store.products (brand, in_shopping_car, price, product_name, stock)
VALUES ("addidas", 0, "100usd", "basic tennis", 100);
```

## Despliegue y flujo inicial📦

Ya teniendo las configuraciones basicas de nuestro proyecto procedemos simplemete a correrlo dando clic derecho en el proyecto Run as -> Spring Boot app.

Ahora que tenemos corriendo la api, vamos a un navegador e ingresamos a la raiz del proyecto http://localhost:8080/, alli nos apareceran 2 botones una para 
hacer un registro de usuarios nuevos y otro para hacer login. al pasar el login nos redirecciona al index y cuando estemos alli ya podremos utilizar los metodos
de nuestra api que podremos probar con las colecciones de POSTMAN que encontraras mas adelante. El flujo termina con un logout el cual cierra sesion y te redirije
al login.

## Construido con 🛠️


* [Spring](https://spring.io/tools) - El framework web usado
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [WorkBench](https://www.mysql.com/products/workbench/) - Usado para administrar BDD


## Colecciones POSTMAN 📖

https://www.postman.com/jerestrepod/workspace/test-api-store

En esta coleccion publica se encuentran los metodos expuestos por el api, tener en cuenta que hay que tener corriedo el api localmente para poderlos consumir,
adicional el metodo addProduct y removeProduct tienen al final de sus url un productId de prueba el cual se debe cambiar segun sea el caso.

Para el metodo updateProduct el body tambien viene como un ejemplo pero los datos se deben cambiar segun sea el caso.

## Versionado 📌

Uso [git](https://git-scm.com/) para el versionado. Para todas las versiones disponibles, mira los [tags en este repositorio](https://github.com/jerestrepod/api-store).

## Autores ✒️


* **Ing Jhonatan Esteban Restrepo Duque** - 


