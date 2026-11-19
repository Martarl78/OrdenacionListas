/**
 * 01 - QuickSort (divide y vencerás, esquema de partición de Lomuto).
 * Complejidad: O(n log n) en promedio, O(n^2) en el peor caso. No es estable.
 */
object QuickSortApp {

    fun <T : Comparable<T>> quickSort(lista: MutableList<T>) {
        quickSort(lista, 0, lista.size - 1)
    }

    private fun <T : Comparable<T>> quickSort(lista: MutableList<T>, bajo: Int, alto: Int) {
        if (bajo < alto) {
            val posPivote = particionar(lista, bajo, alto)
            quickSort(lista, bajo, posPivote - 1)   // parte izquierda
            quickSort(lista, posPivote + 1, alto)   // parte derecha
        }
    }

    /** Coloca el pivote (último elemento) en su posición final y devuelve esa posición. */
    private fun <T : Comparable<T>> particionar(lista: MutableList<T>, bajo: Int, alto: Int): Int {
        val pivote = lista[alto]
        var i = bajo - 1                       // frontera de los elementos <= pivote
        for (j in bajo until alto) {
            if (lista[j] <= pivote) {
                i++
                intercambiar(lista, i, j)
            }
        }
        intercambiar(lista, i + 1, alto)       // el pivote ocupa su sitio definitivo
        return i + 1
    }

    private fun <T> intercambiar(lista: MutableList<T>, i: Int, j: Int) {
        val temporal = lista[i]
        lista[i] = lista[j]
        lista[j] = temporal
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("=== QUICKSORT ===")
        ejecutar("Lista de números", GenerarDatos.numeros)
        ejecutar("Lista de nombres", GenerarDatos.nombres)
    }

    /** Pasos 1-6 del enunciado: copia, mostrar, ordenar, mostrar y medir tiempo. */
    private fun <T : Comparable<T>> ejecutar(titulo: String, original: List<T>) {
        val copia = original.toMutableList()          // 6. trabajamos sobre una copia
        println("\n--- $titulo ---")
        println("Original: $original")                // 2. lista original

        val inicio = System.nanoTime()
        quickSort(copia)                              // 3. ordenar
        val fin = System.nanoTime()

        println("Ordenada: $copia")                   // 4. lista ordenada
        val ns = fin - inicio
        println("Tiempo: $ns ns (${"%.6f".format(ns / 1_000_000.0)} ms)")  // 5. tiempo
    }
}