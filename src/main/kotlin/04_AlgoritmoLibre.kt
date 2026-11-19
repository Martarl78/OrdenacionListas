/**
 * 04 - Algoritmo libre 1: HeapSort (ordenación con montículo máximo).
 * Complejidad: O(n log n) siempre. In situ (sin memoria extra). No es estable.
 */
object HeapSortApp {

    fun <T : Comparable<T>> heapSort(lista: MutableList<T>) {
        val n = lista.size

        // Fase 1: construir el montículo máximo (de la última rama hacia la raíz).
        for (i in n / 2 - 1 downTo 0) {
            hundir(lista, n, i)
        }
        // Fase 2: extraer el máximo repetidamente y llevarlo al final.
        for (fin in n - 1 downTo 1) {
            intercambiar(lista, 0, fin)
            hundir(lista, fin, 0)                   // el montículo ahora tiene 'fin' elementos
        }
    }

    /** Restablece la propiedad de montículo máximo bajando el nodo 'raiz'. */
    private fun <T : Comparable<T>> hundir(lista: MutableList<T>, tam: Int, raiz: Int) {
        var padre = raiz
        while (true) {
            val hijoIzq = 2 * padre + 1
            val hijoDer = hijoIzq + 1
            var mayor = padre
            if (hijoIzq < tam && lista[hijoIzq] > lista[mayor]) mayor = hijoIzq
            if (hijoDer < tam && lista[hijoDer] > lista[mayor]) mayor = hijoDer
            if (mayor == padre) return              // el nodo ya cumple la propiedad
            intercambiar(lista, padre, mayor)
            padre = mayor
        }
    }

    private fun <T> intercambiar(lista: MutableList<T>, i: Int, j: Int) {
        val temporal = lista[i]
        lista[i] = lista[j]
        lista[j] = temporal
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("=== HEAPSORT ===")
        ejecutar("Lista de números", GenerarDatos.numeros)
        ejecutar("Lista de nombres", GenerarDatos.nombres)
    }

    /** Pasos 1-6 del enunciado: copia, mostrar, ordenar, mostrar y medir tiempo. */
    private fun <T : Comparable<T>> ejecutar(titulo: String, original: List<T>) {
        val copia = original.toMutableList()          // 6. trabajamos sobre una copia
        println("\n--- $titulo ---")
        println("Original: $original")                // 2. lista original

        val inicio = System.nanoTime()
        heapSort(copia)                               // 3. ordenar
        val fin = System.nanoTime()

        println("Ordenada: $copia")                   // 4. lista ordenada
        val ns = fin - inicio
        println("Tiempo: $ns ns (${"%.6f".format(ns / 1_000_000.0)} ms)")  // 5. tiempo
    }
}