trait Transporte {
    def costo(distancia: Double): Double
}

class Taxi extends Transporte {
    def costo(distancia: Double): Double = 15 + distancia * 3
}

class Autobus extends Transporte {
    def costo(distancia: Double): Double = if distancia > 9.2 then 3.5 else 3
}

def calcularViaje(transporte: Transporte, distancia: Double): Double = {
    transporte.costo(distancia)
}

def validarPositivo(numero: Int): Int = {
    
    if numero >= 0 then
    numero //Int
  else
    throw new IllegalArgumentException("El número debe ser positivo") //Nothing
}
  

object ejerciciosPolimorfismo{
    def main (args: Array[String]): Unit = {
        println(calcularViaje(new Taxi, 5.6))
        println(calcularViaje(new Autobus, 10))

        println(validarPositivo(-1))
    }
}