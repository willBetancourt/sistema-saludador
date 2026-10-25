# Sistema Saludador

Prototipo de escritorio desarrollado en **Java 21 y JavaFX** para el laboratorio. El sistema solicita nombre, edad y hora en formato AM/PM, valida los datos y muestra un saludo personalizado que menciona el nombre y la edad.

## Requisitos
- JDK 21 o superior.
- Apache Maven 3.9 o superior.
- Conexión a internet la primera vez para que Maven descargue JavaFX y sus dependencias.

## Ejecutar el prototipo
1. Instala un JDK 21 y Maven.
2. Abre esta carpeta en Cursor IDE (o en otro editor compatible con Java).
3. Abre la terminal integrada en la carpeta del proyecto.
4. Ejecuta:

   ```bash
   mvn clean javafx:run
   ```

Maven descarga las dependencias declaradas en `pom.xml` y abre la ventana de la aplicación.

## Cómo usarlo
1. Escribe el nombre.
2. Escribe la edad como número entero.
3. Escribe la hora, por ejemplo `8:30`, y selecciona `AM` o `PM`.
4. Pulsa **Saludar**.
5. El sistema muestra un saludo personalizado. Si faltan datos o el formato no es válido, presenta un mensaje de error.

## Estructura del repositorio
```text
sistema-saludador/
├── pom.xml
├── README.md
├── prompts/
│   └── prompts.txt
├── docs/
│   └── reflexion.md
└── src/main/java/co/edu/laboratorio/saludador/
    └── SistemaSaludador.java
```

## Caso de uso principal
- **Actor:** Estudiante.
- **Caso de uso:** Solicitar saludo.
- **Flujo básico:** el estudiante abre el sistema; ingresa nombre, edad y hora AM/PM; solicita el saludo; el sistema valida la información y presenta el saludo con el nombre y la edad.

## Publicar en GitHub
Crea un repositorio vacío en GitHub llamado `sistema-saludador`. Luego, desde la terminal de esta carpeta, ejecuta (reemplaza `TU-USUARIO` por tu usuario real):

```bash
git init
git add .
git commit -m "Crear prototipo Sistema Saludador"
git branch -M main
git remote add origin https://github.com/TU-USUARIO/sistema-saludador.git
git push -u origin main
```

Cuando termines, copia el enlace real del repositorio y publícalo en el espacio de entrega del laboratorio. El enlace anterior es una plantilla, no un repositorio ya publicado.

## Referencia técnica
La configuración de JavaFX con Maven sigue la guía oficial de OpenJFX: https://openjfx.io/openjfx-docs/
