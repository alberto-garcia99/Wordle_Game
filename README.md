# Wordle Game 🟩🟨⬜

Implementación del juego **Wordle** en Java para consola. El jugador tiene 6 intentos para adivinar una palabra secreta de 5 letras, con pistas visuales mediante colores.

## Cómo se juega

- Introduce una palabra de **5 letras** en cada turno
- El juego te indica con colores el resultado de cada letra:
  - 🟩 **Verde** → letra correcta en la posición correcta
  - 🟨 **Amarillo** → letra en la palabra pero en posición incorrecta
  - ⬜ **Blanco** → letra no está en la palabra
- Tienes **6 intentos** para adivinar la palabra secreta

## Estructura del proyecto

```
Juego_Wordle/
├── src/
│   ├── Main.java               # Punto de entrada
│   ├── WordleGame.java         # Lógica principal del juego
│   ├── WordleFeedBack.java     # Sistema de colores y pistas
│   └── WordleFileManager.java  # Lectura/escritura de archivos
├── palabras.txt                # Diccionario de palabras del juego
└── palabras-almacenadas.txt    # Historial de palabras usadas
```

## Requisitos

- Java 8 o superior
- Terminal con soporte de colores ANSI (PowerShell, Git Bash, Linux/macOS)

## Ejecución

1. Clona el repositorio:
   ```bash
   git clone https://github.com/alberto-garcia99/Wordle_Game.git
   ```
2. Abre el proyecto en IntelliJ IDEA
3. Ejecuta `Main.java`

> También puedes compilar y ejecutar desde terminal:
> ```bash
> javac src/*.java -d out/
> java -cp out Main
> ```

## Autor

**Alberto García Castaño**
