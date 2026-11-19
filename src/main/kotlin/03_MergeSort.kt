/**
 * 03 - MergeSort (divide y vencerás con fusión de mitades ordenadas).
 * Complejidad: O(n log n) siempre. Estable. Memoria auxiliar O(n).
 */
object MergeSortApp {

    fun <T : Comparable<T>> mergeSort(lista: MutableList<T>) {
        if (lista.size < 2) return
        val auxiliar = lista.toMutableList()       // buffer reutilizado en todas las fusiones
        mergeSort(lista, auxiliar, 0, lista.size - 1)
    }

    private fun <T : Comparable<T>> mergeSort(
        lista: MutableList<T>, auxiliar: MutableList<T>, izq: Int, der: Int
    ) {
        if (izq >= der) return                      // caso base: 0 o 1 elementos
        val medio = izq + (der - izq) / 2
        mergeSort(lista, auxiliar, izq, medio)      // ordena la mitad izquierda
        mergeSort(lista, auxiliar, medio + 1, der)  // ordena la mitad derecha
        fusionar(lista, auxiliar, izq, medio, der)  // combina ambas mitades
    }

    private fun <T : Comparable<T>> fusionar(
        lista: MutableList<T>, auxiliar: MutableList<T>, izq: Int, medio: Int, der: Int
    ) {
        for (k in izq..der) auxiliar[k] = lista[k]  // copia del tramo a fusionar

        var i = izq            // cursor de la mitad izquierda
        var j = medio + 1      // cursor de la mitad derecha
        var k = izq            // posición de escritura
        while (i <= medio && j <= der) {
            if (auxiliar[i] <= auxiliar[j]) {       // <= mantiene la estabilidad
                lista[k] = auxiliar[i]; i++
            } else {
                lista[k] = auxiliar[j]; j++
            }
            k++
        }
        while (i <= medio) { lista[k] = auxiliar[i]; i++; k++ }   // restos de la izquierda
        while (j <= der)   { lista[k] = auxiliar[j]; j++; k++ }   // restos de la derecha
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("=== MERGESORT ===")
        ejecutar("Lista de números", GenerarDatos.numeros)
        ejecutar("Lista de nombres", GenerarDatos.nombres)
    }

    /** Pasos 1-6 del enunciado: copia, mostrar, ordenar, mostrar y medir tiempo. */
    private fun <T : Comparable<T>> ejecutar(titulo: String, original: List<T>) {
        val copia = original.toMutableList()          // 6. trabajamos sobre una copia
        println("\n--- $titulo ---")
        println("Original: $original")                // 2. lista original

        val inicio = System.nanoTime()
        mergeSort(copia)                              // 3. ordenar
        val fin = System.nanoTime()

        println("Ordenada: $copia")                   // 4. lista ordenada
        val ns = fin - inicio
        println("Tiempo: $ns ns (${"%.6f".format(ns / 1_000_000.0)} ms)")  // 5. tiempo
    }
}