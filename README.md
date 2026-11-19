## OrdenacionListas

---

## 📖 Descripción

Proyecto de la asignatura **PMDM 2026/27** (Programación Multimedia y Dispositivos Móviles).
Se implementan **cinco algoritmos de ordenación** en Kotlin **sin usar** `sort()`, `sorted()`, `sortBy()` ni equivalentes, y se comparan sus tiempos de ejecución con `System.nanoTime()`.

Todos los algoritmos ordenan **exactamente los mismos datos** (semilla fija) y trabajan sobre una **copia** de la lista original, para no alterar los datos de los demás.

## 🎲 Datos de entrada

Generados en `GenerarDatos.kt`:

| Lista | Tipo | Contenido |
|---|---|---|
| 🚗 `vehiculos` | `MutableList<String>` | 45 nombres de vehículos distintos, desordenados |
| 🔟 `numeros` | `MutableList<Int>` | 100 enteros únicos entre 1 y 10000, desordenados |



## 📁 Estructura del proyecto

```
UD01_Act_OrdenacionListas/
├── 📄 pom.xml
├── 📂 src/main/kotlin/
│   ├── GenerarDatos.kt
│   ├── 01_QuickSort.kt
│   ├── 02_PancakeSort.kt
│   ├── 03_MergeSort.kt
│   ├── 04_AlgoritmoLibre.kt
│   └── 05_AlgoritmoLibre.kt
├── 📝 UD01_OrdenacionListas_NombreApellido.pdf
└── 📘 README.md
```

