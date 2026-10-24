# Informe de Calidad en Verde
## TP Semana 3: Automatización de Calidad y Blindaje

### Contexto

Este trabajo utiliza como base el proyecto de testing desarrollado en la Semana 2. En esta etapa se incorporaron controles automáticos de calidad, se generó un reporte de cobertura y se revisaron el código fuente y las dependencias.

### 1. Configuración del Pre-commit Hook

Se configuró un hook local en `.git/hooks/pre-commit` para ejecutar los controles de calidad en el siguiente orden:

1. **Formatter:** Spotless, mediante `spotlessApply`.
2. **Linter:** Checkstyle, mediante `checkstyleMain` y `checkstyleTest`.
3. **Pruebas unitarias:** JUnit, mediante `test`.

El script verifica el resultado de cada etapa. Si un control falla, muestra un mensaje de error y finaliza con código de salida `1`, bloqueando el commit y evitando que se ejecuten las etapas posteriores.

Se comprobó el funcionamiento del hook mediante una ejecución exitosa y una prueba en la que se introdujo temporalmente una importación con comodín (`import java.util.*;`). Checkstyle detectó el incumplimiento de `AvoidStarImport`, mostró el mensaje `ERROR: fallo Checkstyle.` y bloqueó el commit. Luego se retiró la modificación de prueba y los controles volvieron a ejecutarse correctamente.

El hook ayuda a mantener la calidad de los cambios antes de incorporarlos al historial. Además, se configuró en GitHub una regla de protección para la rama master, que requiere integrar cambios mediante un Pull Request.

### 2. Auditoría estática

Se revisaron las clases `CalculadoraPrecios`, `ProcesadorPagos` y `ValidadorDescuentos`.

No se identificaron duplicaciones evidentes en las clases revisadas. En `ValidadorDescuentos` se observó una estructura de tres condiciones anidadas que puede simplificarse mediante operadores lógicos, facilitando la lectura y el mantenimiento.

El reporte de JaCoCo registró una complejidad ciclomática total de 9 para las tres clases analizadas. Este valor corresponde al conjunto y no representa una medición individual de cada clase.

También se revisó el árbol de dependencias de Gradle. Se identificaron versiones posteriores publicadas para algunas bibliotecas utilizadas, entre ellas JUnit y Mockito, así como dependencias transitivas. Esto no demuestra por sí solo que las versiones actuales tengan vulnerabilidades.

Como estrategia de mejora, se propone simplificar las condiciones de `ValidadorDescuentos`, revisar periódicamente las versiones y los avisos de seguridad de las dependencias, y realizar actualizaciones controladas verificando la compatibilidad y ejecutando nuevamente las pruebas.

### 3. Reporte analítico de cobertura

Se ejecutaron las pruebas unitarias y se generó un reporte de cobertura con JaCoCo.

Los resultados obtenidos fueron:

| Métrica | Resultado |
|---|---:|
| Instrucciones cubiertas | 41 de 41 (100 %) |
| Ramas cubiertas | 6 de 6 (100 %) |
| Líneas cubiertas | 12 de 12 (100 %) |
| Métodos cubiertos | 6 de 6 (100 %) |
| Clases cubiertas | 3 de 3 (100 %) |
| Complejidad ciclomática total | 9 |

El reporte indica que todas las instrucciones, líneas y ramas contabilizadas fueron ejecutadas por las pruebas. Sin embargo, una cobertura del 100 % no garantiza por sí sola la ausencia de errores; los resultados deben interpretarse junto con los casos de prueba y la revisión del código.

Ubicación del reporte HTML generado localmente: `build/reports/jacoco/test/html/index.html`.

### 4. Trazabilidad de la integración

- **Repositorio:** https://github.com/Lourwen/TP_Semana3_Automatizacion_Calidad_Blindaje
- **Issue:** #1 — TP Semana 3: Automatización de Calidad y Blindaje.

- Pull Request: #2, abierto desde feature/semana3-calidad hacia master.

- Issue asociado: #1. La descripción del Pull Request incluye la referencia Closes #1.

### 5. Evidencias de ejecución

Se verificó una ejecución exitosa del pre-commit, con los controles de Spotless, Checkstyle y JUnit completados correctamente. También se comprobó que un incumplimiento de Checkstyle interrumpe el proceso y bloquea el commit.

El reporte de JaCoCo constituye la evidencia de cobertura. La salida de Gradle `dependencies --configuration testRuntimeClasspath` constituye la evidencia del inventario de dependencias revisado.

### 6. Conclusión

La entrega incluye las evidencias de ejecución del hook, el reporte de cobertura y el diagnóstico estático. La trazabilidad se documenta mediante el Pull Request #2 asociado al Issue #1, y se configuró una regla de protección para la rama principal master.
