# Semana 2: Testing Práctico y Contratos

Alumna: Rosa Lourdes, Paco Laura
## Introducción

En este trabajo práctico se aplican conceptos de testing mediante pruebas unitarias en Java. Se trabaja con el patrón AAA, los dobles de prueba Stub y Mock, y la cobertura de ramas.

El proyecto utiliza Gradle, JUnit 5 y Mockito.

## Actividad 1: Patrón AAA

Se implementaron pruebas unitarias para la clase `CalculadoraPrecios`, que calcula el precio final de un producto según el descuento aplicado.

Las pruebas siguen el patrón AAA:

- **Arrange:** se preparan los datos y los objetos necesarios.
- **Act:** se ejecuta el método que se quiere probar.
- **Assert:** se compara el resultado obtenido con el esperado.

Se realizaron tres pruebas: con un descuento del 20 %, sin descuento y con un descuento del 100 %. De esta manera, se verifica el cálculo en diferentes situaciones.

## Actividad 2: Stub y Mock

Se trabajó con la clase `ProcesadorPagos` y la interfaz `PasarelaPagos`, que representa una pasarela externa de pagos.

Se implementaron dos pruebas:

- **Stub:** devuelve una respuesta preparada, en este caso, `"APROBADO"`. Permite comprobar cómo responde el procesador ante ese resultado.
- **Mock:** permite configurar una respuesta y verificar que se haya llamado al método `cobrar()` con el monto esperado.

La diferencia principal es que el Stub proporciona una respuesta para la prueba, mientras que el Mock también permite verificar las interacciones con el objeto simulado.

## Actividad 3: Statement Coverage y Branch Coverage

Se trabajó con la clase `ValidadorDescuentos`, que verifica que el precio sea mayor que cero y que el descuento se encuentre entre 0 % y 100 %, inclusive.

**Statement Coverage** mide qué proporción de las instrucciones del código se ejecuta durante las pruebas.

**Branch Coverage** verifica si se recorren las distintas alternativas de las condiciones, tanto verdaderas como falsas.

Se diseñaron los siguientes casos de prueba:

| Caso | Precio | Descuento | Resultado esperado |
|---|---:|---:|---|
| Valores válidos | 1000 | 20 % | Válido |
| Precio igual a cero | 0 | 20 % | Inválido |
| Descuento negativo | 1000 | -5 % | Inválido |
| Descuento mayor al 100 % | 1000 | 120 % | Inválido |

Estos cuatro casos permiten recorrer las ramas verdaderas y falsas de las tres condiciones del método `esValido()`. Por el diseño de los casos, se cubren todas las ramas de ese método. No se utilizó una herramienta externa para medir el porcentaje de cobertura.

## Conclusión

El trabajo permitió aplicar pruebas unitarias y comprobar distintos escenarios de funcionamiento. También permitió diferenciar el uso de Stub y Mock, y comprender por qué es necesario probar las distintas alternativas de las condiciones para lograr la cobertura de ramas.