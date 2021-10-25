# api-store

Esta es mi solución tecnológica para una api-rest, que tiene como propósito el manejo de los productos de una tienda en relación con un carro de compras, implementando también, un proceso de registro y login para los usuarios. 

## Cómo se abordó el problema 🦁

Lo primero que hice fue dividir el desarrollo en 3 fases principales:

  -> Implementación del registro y el login de usuarios. Tarea-1
  
  -> Creación del servicio Rest, junto con la lógica de negocio. Tarea-2
  
  -> Implementación de las pruebas unitarias y de integración.  Tarea-3
  

Teniendo en cuenta lo anterior, decidí usar una arquitectura de capas, porque el sistema puede tener una modularidad, y ya que estamos manejando una tienda online, me pareció importante tener en cuenta la escalabilidad y el crecimiento a futuro.

Habiendo seleccionado la arquitectura, decidí utilizar Facade como patrón principal de diseño, y durante el desarrollo utilicé algunos patrones adicionales como Singleton, para manejar el encriptamiento de la clave de los usuarios. 




Tarea 1 : Inicié por el registro y login, ya que para mí, era la parte mas tediosa, implementando los formularios a partir de los templates de Bootstrap, e hice la configuración           de las librerias de Spring-security para este flujo. Por último, se sincronizó con la BDD.
          
          
Tarea 2 : Se crearon unos campos en la entidad de producto para la implementación de la lógica de negocio, teniendo en cuenta la relación del producto con el carro de compras,             esta la lógica se explica en detalle dentro de la documentación del código.
          
          
Tarea 3 : Finalmente, se escribieron las pruebas para validar la lógica desarrolada en la Tarea 2.



## Comenzando 🚀

Nota: Aunque se pueden usar otras herramientas para ejecutar el proyecto, recomiendo utilizar las mismas con las que fue desarrollado para evitar problemas de compatibilidad.

- Descargamos nuestro código fuente desde https://github.com/jerestrepod/api-store
- Importamos en Spring-tool el proyecto desde la ubicación en la que descargamos el fuente

### Pre-requisitos 📋

*jdk 1.8

*spring-tool 4.4.9 o superior

*admin de base de datos mySQL

*maven repository


## Ejecutando las pruebas unitarias⚙️

Las pruebas unitarias se deben ejecutar antes de iniciar el proyecto.
Para ello, simplemente vamos a la clase com.co.store.BusinessUnitTest, que se encuentra dentro del paquete de pruebas src/test/java, 
damos clic derecho en la clase y luego clic en Run as -> JUnit test. De esta manera, se ejecutaran las pruebas unitarias.

NOTA: Cada una de las funcionalidades que se estan probando se encuentran documentadas dentro del código.

## Ejecutando las pruebas de integración⚙️

Las pruebas de integración se deben ejecutar después de iniciar el proyecto, así que se debe terminar primero la configuración completa antes de poderlar ejecutar.
Para ello, simplemente vamos a la clase com.co.store.ApiStoreApplicationTests, que se encuentra dentro del paquete de pruebas src/test/java,
damos clic derecho en la clase y luego clic en Run as -> JUnit test. De esta manera se ejecutaran las pruebas de integración.

NOTA: Cada una de las funcionalidades que se estan probando se encuentran documentadas dentro del código.

## Persistencia 📦

Para que el api-rest despliegue correctamente, es necesario configurar la conexión local a la BDD, que se encuenta en src/main/resources/templates/aplication.yml,
y configurar los valores del url, username y password en el datasource.

Adicionalmente, se debe crear la base de datos, que en nuestro caso se llama store, como se muestra a continuación:

```
 CREATE DATABASE store;
```
   
Habiendo hecho esto, podemos desplegar el api y este generará automáticamente todos los mapeos de las entidades en la base de datos.

Una vez que tengamos nuestras entidades mapeadas, podemos insertar los productos que se necesiten. A continuación unos ejemplos:

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

Teniendo las configuraciones básicas de nuestro proyecto, procedemos a correrlo dando clic derecho en el proyecto y luego clic en Run as -> Spring Boot app.

Ahora que tenemos corriendo la api, vamos a un navegador e ingresamos a la raíz del proyecto http://localhost:8080/, allí nos aparecerán 2 botones, uno para 
hacer un registro de usuarios nuevos, y otro para hacer login. Al pasar el login nos redirecciona al index y cuando estemos allí, podremos utilizar los métodos
de nuestra api. Estos se pueden probar con las colecciones de POSTMAN, que se encuentran mas adelante. El flujo termina con un logout, que cierra sesión y redirije
al login.

## Construido con 🛠️


* [Spring](https://spring.io/tools) - El framework web usado
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [WorkBench](https://www.mysql.com/products/workbench/) - Utilizado para administrar BDD
* [Java 8](https://www.oracle.com/co/java/technologies/javase/javase8-archive-downloads.html) - version java


## Colecciones POSTMAN 📖

En esta colección pública se encuentran las consultas a los métodos expuestos por el api:

https://www.postman.com/jerestrepod/workspace/test-api-store

Se debe correr el api localmente para poder consumir los métodos, adicionalmente, el método addProduct y removeProduct tienen al final de sus url un productId de prueba, 
que se debe cambiar según sea el caso.

Con respecto al método updateProduct, el body viene también como un ejemplo, pero los datos se deben cambiar según sea el caso ( Se pueden tomar de la respuesta de allProducts) 

## Versionado 📌

Se utilizó [git](https://git-scm.com/) para el versionado. Para todas las versiones disponibles, mira los [tags en este repositorio](https://github.com/jerestrepod/api-store).

## Autores ✒️


* **Ing Jhonatan Esteban Restrepo Duque** - 


