/**
 * 02 - Pancake Sort (ordenación por volteos de prefijo).
 * Única operación permitida: voltear los primeros k elementos.
 * Complejidad: O(n^2). A lo sumo 2(n-1) volteos.
 */
object PancakeSortApp {

    fun <T : Comparable<T>> pancakeSort(lista: MutableList<T>) {
        var tamActual = lista.size
        while (tamActual > 1) {
            val posMax = indiceDelMaximo(lista, tamActual)
            if (posMax != tamActual - 1) {          // si ya está al final, no hay nada que hacer
                if (posMax != 0) {
                    voltear(lista, posMax)           // 1) el máximo pasa a la posición 0
                }
                voltear(lista, tamActual - 1)        // 2) el máximo pasa al final de la zona activa
            }
            tamActual--                              // la zona ordenada crece por la derecha
        }
    }

    /** Índice del mayor elemento entre las posiciones 0 .. n-1. */
    private fun <T : Comparable<T>> indiceDelMaximo(lista: List<T>, n: Int): Int {
        var posMax = 0
        for (i in 1 until n) {
            if (lista[i] > lista[posMax]) posMax = i
        }
        return posMax
    }

    /** Invierte el prefijo lista[0..hasta]. */
    private fun <T> voltear(lista: MutableList<T>, hasta: Int) {
        var i = 0
        var j = hasta
        while (i < j) {
            val temporal = lista[i]
            lista[i] = lista[j]
            lista[j] = temporal
            i++
            j--
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("=== PANCAKE SORT ===")
        ejecutar("Lista de números", GenerarDatos.numeros)
        ejecutar("Lista de nombres", GenerarDatos.nombres)
    }

    /** Pasos 1-6 del enunciado: copia, mostrar, ordenar, mostrar y medir tiempo. */
    private fun <T : Comparable<T>> ejecutar(titulo: String, original: List<T>) {
        val copia = original.toMutableList()          // 6. trabajamos sobre una copia
        println("\n--- $titulo ---")
        println("Original: $original")                // 2. lista original

        val inicio = System.nanoTime()
        pancakeSort(copia)                            // 3. ordenar
        val fin = System.nanoTime()

        println("Ordenada: $copia")                   // 4. lista ordenada
        val ns = fin - inicio
        println("Tiempo: $ns ns (${"%.6f".format(ns / 1_000_000.0)} ms)")  // 5. tiempo
    }
}