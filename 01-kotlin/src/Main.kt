import java.util.*
import java.util.function.Consumer

fun main(args: Array<String>) {
    print("Hola")
    // Ejemplo java:
    // Int edad = 31;
    // Mutables
    var edadProfesor = 31   // No especificamos el tipo de dato
    // ; No es necesario
    // Duck Typing
    // var edadCachorro; X -> necesitamos el tipo de datos
    var edadCachorro: Int
    edadCachorro = 3
    edadProfesor = 32
    edadCachorro = 4
    // Inmutables
    val numeroCuenta = 123456 // NO SE PUEDEN REASIGNAR
    // numeroCuenta = 123

    // Tipos variables
    val nombreProfesor: String = "Vicente Adrian"
    val sueldo: Double = 12.20
    val apellidosProfesor: Char = 'a'
    val fechaNacimiento = Date() // new Date()

    if (sueldo == 12.20) {

    } else {

    }

    when (sueldo) {
        12.20 -> println("Sueldo normal")
        -12.20 -> println("Sueldo negativo")
        else -> println("No se reconoce el sueldo")
    }

    val esSueldoMayorAlEstablecido = if (sueldo == 12.20) true else false
    // EXPRESION ? X : Y
    // calcularSueldo(1000.00, 14.00)
    calcularSueldo(1000.00, 14.00)
    calcularSueldo(
            tasa = 16.00,
            sueldo = 800.00
    ) // Named Parameters
    calcularSueldo(700.00)
    calcularSueldo(sueldo = 650.00)

    val arregloConstante: Array<Int> = arrayOf(1, 2, 3)
    val arregloCumpleanos: ArrayList<Int> = arrayListOf(30, 31, 22, 23, 20)
    print(arregloCumpleanos)
    arregloCumpleanos.add(24)
    print(arregloCumpleanos)
    // arregloCumpleanos.remove(30)
    arregloCumpleanos.remove(30)
    print(arregloCumpleanos)


    arregloCumpleanos
            .forEach { valorIteracion: Int ->
                println("Valor iteracion: " + valorIteracion)
            }
    arregloCumpleanos
            .forEach(
                    { valorIteracion: Int ->
                        println("Valor iteracion: " + valorIteracion)
                    }
            )

    // Operadores -> TODOS LOS LENGUAJES
    // ForEach no devuelve nada -> Unit
    arregloCumpleanos
            .forEach { iteracion: Int ->
                println("Valor de la iteracion " + iteracion)
                println("Valor con -1 = ${iteracion * -1} ")
            }

    val respuestaArregloForEach = arregloCumpleanos
            .forEachIndexed { index: Int, iteracion: Int ->
                println("Valor de la iteracion " + iteracion)
            }
    println(respuestaArregloForEach) // Void Unit

    // MAP -> Muta el arreglo (Cambia el arreglo)
    // 1) Enviemos el nuevo valor de la iteracion
    // 2) Nos devuelve es un NUEVO ARREGLO con los valores modificados
    val respuestaMap = arregloCumpleanos
            .map { iterador: Int ->
                iterador * -1
            }
    val respuestaMapDos = arregloCumpleanos
            .map { iterador: Int ->
                val nuevoValor = iterador * -1
                val otroValor = nuevoValor * 2
                return@map Date()
            }
    println(respuestaMap)
    println(respuestaMapDos)
    println(arregloCumpleanos)

    // Filter -> FILTRAR EL ARREGLO
    // 1) Devolver una expresion (TRUE o FALSE)
    // 2) Nuevo arreglo que cumpla esa expresion
    val respuestaFilter = arregloCumpleanos
            .filter { iteracion: Int ->
                val esMayorA23 = iteracion > 23
                return@filter esMayorA23
            }
    arregloCumpleanos.filter { it > 23 }
    println(respuestaFilter)
    println(arregloCumpleanos)

    // Any -> OR (Some)
    // All -> AND (Every)
    // AND -> TRUE, Todo lo demas falso
    // OR -> TODO es falso, lo demas era verdadero
    // 1) Devolver una expresion (TRUE o FALSE)
    // 2) Devuelve un Booleano
    // (30, 31, 22, 23, 20)
    val respuestaAny = arregloCumpleanos
            .any { iterador: Int ->
                return@any iterador < 25
            }
    println(respuestaAny)

    val respuestaAll = arregloCumpleanos
            .all { iterador: Int ->
                return@all iterador > 18
            }
    println(respuestaAll)


    // Reduce
    // 1) Devuelve el acumulado
    // 2) En que valor empieza
    // Devuelve un numero
    // (30, 31, 22, 23, 20)
    // ("a", "b", "c", "d")
    // "abcd"
    val respuestaReduce = arregloCumpleanos // Acumulador 0
            .reduce({ acumulador, iteracion ->
                return@reduce acumulador + iteracion
            })
    println(respuestaReduce)

    val respuestaFold = arregloCumpleanos
            .fold(
                    100,
                    { acumulador, iteracion ->
                        return@fold acumulador - iteracion
                    }
            )
    // arregloCumpleanos.reduceRigth
    // arregloCumpleanos.foldRight
    println(respuestaFold)
    // forEach -> nada
    // map -> Arreglo
    // filter -> Arreglo
    // all -> Booleano
    // any -> Booleano
    // reduce -> Valor
    // fold -> Valor

    // Reducir el daño en 20%
    // 18 <
    // (30, 31, 22, 23, 20)
    val vidaActual = arregloCumpleanos
            .map { it * 0.8 } // (24, 24.8, 17.7, 18.4, 16)
            .filter { it > 18 } // (24, 24.8, 18.4)
            .fold(100.00, { acc, d -> acc - d })
            .also { println(it) }

}

fun calcularSueldo(
        sueldo: Double, // Requeridos!
        tasa: Double = 12.00, // Tiene valor defecto
        calculoEspecial: Int? = null // Pueden ser nulos
): Double {
    if (calculoEspecial != null) {
        return sueldo * tasa * calculoEspecial
    } else {
        return sueldo * tasa
    }
}


fun imprimirMensaje() { // Unit = Void
    println("")
}


// Clases Abstractas

abstract class NumerosJava {  // val nuevosNumeros = Numeros(1,2)
    protected val numeroUno: Int
    private val numeroDos: Int

    constructor(uno: Int, dos: Int) {
        numeroUno = uno
        numeroDos = dos
    }
}

abstract class Numeros( // val nuevosNumeros = Numeros(1,2)
        protected val numeroUno: Int,
        protected val numeroDos: Int
) {
}

class Suma(
        uno: Int,
        dos: Int
) : Numeros(uno, dos) {
    fun sumar():Int{
        // this.uno
        return this.numeroUno + this.numeroDos
    }
}

class SumaDos(
        public var uno: Int,
        public var dos: Int
) : Numeros(uno, dos) {
    fun sumar():Int{
        this.uno
        this.dos
        return this.numeroUno + this.numeroDos
    }
}






