# Conversor de Divisas

## Descripción
El **Conversor de Divisas** es una aplicación desarrollada en Java que permite a los usuarios convertir valores entre diferentes monedas internacionales en tiempo real, utilizando una API externa para obtener tasas de cambio actualizadas. El programa ofrece una interfaz de línea de comandos donde el usuario puede seleccionar la moneda de origen y la moneda de destino, ingresar un monto, y recibir el resultado de la conversión.

Además, la aplicación guarda los resultados de las conversiones en un archivo JSON, facilitando el almacenamiento y la revisión posterior de las conversiones realizadas.

## Funcionalidades
- Convertir entre varias monedas internacionales como:
  - Dólar estadounidense (USD)
  - Peso argentino (ARS)
  - Real brasileño (BRL)
  - Peso colombiano (COP)
- Conexión a una API externa para obtener tasas de cambio en tiempo real.
- Guardar los resultados de las conversiones en archivos JSON.
- Menú interactivo para que el usuario elija la conversión deseada.
- Gestión de errores al manejar entradas no válidas o al procesar la consulta a la API.

## Estructura del Proyecto
El proyecto está compuesto por las siguientes clases:
1. **Principal**: Contiene la lógica principal del programa, presentando el menú y ejecutando las conversiones basadas en la selección del usuario.
2. **ConsultaApi**: Maneja las consultas a la API externa, obtiene las tasas de cambio y devuelve el resultado de la conversión.
3. **GeneradorJson**: Genera y guarda archivos JSON con los resultados de las conversiones.
4. **Moneda**: Clase que representa el formato de datos recibido de la API, y almacena los detalles de la conversión.

## Menú Principal
El menú principal del programa permite al usuario seleccionar la conversión de monedas que desea realizar. A continuación, se presenta una simulación del menú:

Sea Bienvenido/a al conversor de monedas =)

- Dólar =>> Peso argentino
- Peso argentino =>> Dólar
- Dólar =>> Real brasileño
- Real brasileño =>> Dólar
- Dólar =>> Peso colombiano
- Peso colombiano =>> Dólar
- Salir

## Ejemplos de Archivo JSON y API

### Ejemplo de archivo JSON generado por el programa:
Cuando se convierte 100 dólares estadounidenses a pesos argentinos, el archivo generado se verá así:

- json
- {
  - "base_code": "USD",
  - "target_code": "ARS",
  - "conversion_rate": 98.55,
  - "conversion_result": 9855.00
- }

### Ejemplo de URL de la API utilizada:
La API utilizada para realizar las conversiones de monedas es la siguiente:
https://v6.exchangerate-api.com/v6/tu-clave-api/pair/USD/ARS/100

En este ejemplo, estamos solicitando la conversión de 100 dólares estadounidenses (USD) a pesos argentinos (ARS).

### Autor
Este proyecto fue desarrollado por Edwin Alexander Forero Cruz como parte de su especialización de desarrollo se software (back end), aplicando la interacción con APIs y la escritura de archivos JSON. basados en los conociminetos dados por ORACLE + ALURA. 
