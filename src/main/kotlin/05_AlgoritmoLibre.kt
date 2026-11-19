/**
 * 05 - Algoritmo libre 2: ShellSort (inserción con saltos decrecientes).
 * Complejidad: depende de la secuencia de saltos (con n/2, n/4... es O(n^2) en el
 * peor caso, pero en la práctica mucho mejor). In situ. No es estable.
 */
object ShellSortApp {

    fun <T : Comparable<T>> shellSort(lista: MutableList<T>) {
        var salto = lista.size / 2
        while (salto > 0) {
            // Ordenación por inserción de los elementos separados 'salto' posiciones.
            for (i in salto until lista.size) {
                val actual = lista[i]
                var j = i
                while (j >= salto && lista[j - salto] > actual) {
                    lista[j] = lista[j - salto]     // desplaza el elemento mayor hacia delante
                    j -= salto
                }
                lista[j] = actual
            }
            salto /= 2                              // reducimos el salto; el último es 1
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("=== SHELLSORT ===")
        ejecutar("Lista de números", GenerarDatos.numeros)
        ejecutar("Lista de nombres", GenerarDatos.nombres)
    }

    /** Pasos 1-6 del enunciado: copia, mostrar, ordenar, mostrar y medir tiempo. */
    private fun <T : Comparable<T>> ejecutar(titulo: String, original: List<T>) {
        val copia = original.toMutableList()          // 6. trabajamos sobre una copia
        println("\n--- $titulo ---")
        println("Original: $original")                // 2. lista original

        val inicio = System.nanoTime()
        shellSort(copia)                              // 3. ordenar
        val fin = System.nanoTime()

        println("Ordenada: $copia")                   // 4. lista ordenada
        val ns = fin - inicio
        println("Tiempo: $ns ns (${"%.6f".format(ns / 1_000_000.0)} ms)")  // 5. tiempo
    }
}