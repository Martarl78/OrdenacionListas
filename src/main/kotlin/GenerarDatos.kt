import kotlin.random.Random

/**
 * Parte 1 - Generación de datos.
 * Genera DOS listas con semilla fija, de modo que todos los algoritmos
 * trabajen siempre con exactamente los mismos datos:
 *   - numeros: lista de enteros aleatorios (1..100, puede haber repetidos).
 *   - nombres: lista de nombres propios SIN tildes (para que el orden A-Z sea correcto).
 */
object GenerarDatos {

    private const val SEMILLA = 2026
    const val TAMANO = 20

    private val NOMBRES_BASE = listOf(
        "Ana", "Luis", "Marta", "Pablo", "Lucia", "Carlos", "Elena", "Javier",
        "Sara", "Diego", "Laura", "Andres", "Irene", "Miguel", "Paula", "Sergio",
        "Carmen", "Alvaro", "Rocio", "Hugo", "Nuria", "Adrian", "Clara", "Ruben"
    )

    /** Lista de enteros aleatorios reproducible. */
    val numeros: List<Int> by lazy {
        val azar = Random(SEMILLA)
        List(TAMANO) { azar.nextInt(1, 101) }
    }

    /** Lista de nombres en orden aleatorio reproducible (sin repetidos). */
    val nombres: List<String> by lazy {
        NOMBRES_BASE.shuffled(Random(SEMILLA)).take(TAMANO)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("=== DATOS GENERADOS ===")
        println("Números ($TAMANO): $numeros")
        println("Nombres ($TAMANO): $nombres")
    }
}