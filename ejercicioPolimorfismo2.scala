//Parte ejercicio 1
class Cajita[A](val contenido: A){
    def obtener: A = contenido

    def combinar[B](otro: B): (A, B) = (contenido, otro)
}

//Parte ejercicio 2
def seleccionarPrimero[A](primero: A, segundo: A): A = primero

//Parte ejercicio 3
def transformar[A, B](valor: A, funcion: A => B): B = {
    funcion(valor)
}

//Ejercicio 4
abstract class Vehiculo(val marca: String)

class Automovil(marca: String)extends Vehiculo(marca)

class Moto(marca: String)extends Vehiculo(marca)

class RegistroVehiculo[A <: Vehiculo](val vehiculo: A)

//Parte ejercicio 5
class Contenedor[+A](val valor: A)

//Parte ejercicio 6
trait Procesador[-A] {
  def procesar(valor: A): String
}
class ProcesadorVehiculos extends Procesador[Vehiculo]{
    def procesar(valor: Vehiculo): String = s"$valor.marca"
}

//Parte del ejercicio 7
trait Productores[+A] {
    def producir: A
}
trait Consumidores[-A] {

  def consumir(valor: A): String
}

class ProductoresAutosSuzuki extends Productores[Automovil]{
    def producir: Automovil = new Automovil("Suzuki")
}

class ConsumidorVehiculos extends Consumidores[Vehiculo] {
    def consumir(valor: Vehiculo): String = s"Consumiendo $valor.marca"
}

//Parte del ejercicio 8
class Resultado[A](val valor: A, val exitoso: Boolean, val mensaje: String)

object ejerciciosPolimorfismo2{
    
    def main (args: Array[String]): Unit = {

        //Ejercicio 1
        val cajon1: Cajita[Int] = new Cajita(34)
        val cajon2: Cajita[String] = new Cajita("Wazaa")
        val cajon3: Cajita[Boolean] = new Cajita(true)

        println(cajon1.obtener)
        println(cajon2.obtener)
        println(cajon3.obtener)
        println(cajon1.combinar(cajon3.obtener))

        //Ejercicio 2
        println(seleccionarPrimero(34, 89))
        println(seleccionarPrimero("Shazam", false))

        //Ejercicio 3
        println(transformar(34, (a: Int) => s"$a + 15"))
        println(transformar("Look Up", (a: String) => a.length()))

        //Ejercicio 5
        val contenedorAuto: Contenedor[Automovil] = new Contenedor(new Automovil("Fiat"))
        val contenedorVehiculo: Contenedor[Vehiculo] = contenedorAuto

        //Ejercicio 6
        val procesadorAutos: Procesador[Automovil] = new ProcesadorVehiculos
        println(procesadorAutos.procesar(new Automovil("Audi")))

        //Ejercicio 7
        val miniProductorSuzuki: ProductoresAutosSuzuki = new ProductoresAutosSuzuki
        val autito: Automovil = miniProductorSuzuki.producir

        val miniConsumidor: ConsumidorVehiculos = new ConsumidorVehiculos
        println(miniConsumidor.consumir(autito))

        //Ejercicio 8
        val resultadoInt: Resultado[Int] = new Resultado[Int](2026, true, "Operación exitosa")

        // 2. Creación de la instancia para String[cite: 1]
        val resultadoString: Resultado[String] = new Resultado[String]("Programación Funcional", true, "Datos encontrados")

        // 3. Creación de la instancia para Persona[cite: 1]
        val motocicleta =  new Moto("Yamaha")
        val resultadoMoto: Resultado[Moto] = new Resultado[Moto](motocicleta, true, "moto autenticada")

        // Verificación de los valores
        println(s"Resultado Int: ${resultadoInt.valor}, Mensaje: ${resultadoInt.mensaje}")
        println(s"Resultado String: ${resultadoString.valor}, Mensaje: ${resultadoString.mensaje}")
        println(s"Resultado Persona: ${resultadoMoto.valor.marca}")
    }
}