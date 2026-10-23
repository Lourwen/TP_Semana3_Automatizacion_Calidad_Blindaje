# TP Semana 2 - Testing Práctico y Contratos

Proyecto de pruebas unitarias en Java que trabaja con el patrón AAA, los dobles de prueba Stub y Mock, y la cobertura de ramas.

## Tecnologías

- Java
- Gradle
- JUnit 5
- Mockito

## Estructura
```
TP_Semana2_Testing/
├── README.md
├── informe.md
├── build.gradle.kts
├── settings.gradle.kts
└── src/
├── main/java/tp/
│   ├── CalculadoraPrecios.java
│   ├── ProcesadorPagos.java
│   └── ValidadorDescuentos.java
└── test/java/tp/
├── CalculadoraPreciosTest.java
├── ProcesadorPagosTest.java
└── ValidadorDescuentosTest.java

- `CalculadoraPrecios`: cálculo de precios con descuentos.
- `ProcesadorPagos`: simulación de una pasarela de pagos.
- `ValidadorDescuentos`: validación de precios y descuentos.
- `src/test`: pruebas unitarias de las tres clases.
```
## Ejecutar las pruebas

Desde la terminal, ubicada en la carpeta principal del proyecto, ejecutar:

```bash
gradlew test
```

En Windows también se puede ejecutar:

```bat
gradlew.bat test
```

El informe de las actividades se encuentra en `informe.md`.
Prueba de ejecucion del hook.
