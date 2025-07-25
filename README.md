# Conversor-Moneda

# Conversor de Monedas en Java 

Este es un pequeño proyecto en Java que hice como práctica para trabajar con **HTTP**, **APIs REST** y **parsing de JSON con Gson**.

El programa permite convertir entre distintas monedas usando datos en tiempo real obtenidos de la API de [Exchangerate API](https://www.exchangerate-api.com/).

---

## 🚀 ¿Qué hace?

- Muestra un menú en consola para elegir qué tipo de conversión querés hacer (ej: USD a ARS).
- Pide el monto a convertir.
- Se conecta a una API externa para obtener la tasa de cambio actual.
- Muestra el resultado convertido.

---

## 🧪 Tecnologías usadas

- Java 17
- `HttpClient` (para hacer solicitudes HTTP)
- `HttpRequest`
- `Gson` (para deserializar la respuesta JSON)
- API: [Exchangerate API](https://www.exchangerate-api.com/)
