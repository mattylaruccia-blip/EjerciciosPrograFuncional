import parte_1.producto

//Ejercicio1 1
case class Producto_case(nombre: String, precio: Double, stock: Int)

def clasificarProducto(producto: Producto_case): String = {
    producto match
        case Producto_case(_, _, 0) =>
            "Sin stock"
        case Producto_case(_, precio, _) 
            if precio >= 1000 => 
                "Producto premium"
        case Producto_case(nombre, precio, stock) => 
            "Producto estandart"
}

//Ejercicio 2
def posicion(punto: (Int, Int)): String = {
    punto match
        case (0, 0) =>
            "Origen"

        case (0, y) =>
            s"Eje Y: $y"

        case (x, 0) =>
            s"Eje X: $x"

        case (x, y) =>
            s"Punto ($x, $y)"
}

//Ejercicio 3
case class Estudiante(nombre: String, nota: Double) 

def resultado(estudiante: Estudiante): String = {
    estudiante match
        case Estudiante(nombre, nota)
        if nota>=90 =>
            "EXCELENT"
        case Estudiante(nombre, nota) 
        if nota >= 70 =>
            "Aprobado"
        case Estudiante(nombre, nota) 
        if nota >= 51 =>
            "Regular"
        case Estudiante(nombre, nota) =>
            "Reprobado"   
    
}

//Ejercicio 4
case class Inventario(producto: String, cantidad: Int)
def agregar(inventario: Inventario, cantidad: Int): Inventario = {
    inventario.copy(cantidad = inventario.cantidad + cantidad)
}

//Ejercicio 5
case class DireccionCliente(ciudad: String, pais: String)
case class Cliente(nombre: String, direccion: DireccionCliente)
def ubicacion(cliente: Cliente): String = {
    cliente match
        case Cliente(nombre, direccion)
        if direccion.pais.equals("Bolivia") =>
            "Cliente boliviano"
        case Cliente(nombre, direccion) => 
            "Cliente extranjero"
    
}


object ejerciciosCase_Match {
    def main (args: Array[String]): Unit = {
        //Ejercicio 1
        val producto1 = Producto_case("Billetera", 200, 3)
        val producto2 = Producto_case("Reloj", 1800, 1)
        val producto3 = Producto_case("Perfume", 1000, 0)
        println(clasificarProducto(producto1))
        println(clasificarProducto(producto2))
        println(clasificarProducto(producto3))
        println()

        //Ejercicio 2
        println(posicion(0, 0))
        println(posicion(3, 0))
        println(posicion(0, 2))
        println(posicion(12, 3))
        println()

        //Ejercicio 3
        println(resultado(Estudiante("Pablo", 100)))
        println(resultado(Estudiante("Lana", 80)))
        println(resultado(Estudiante("Videl", 58)))
        println(resultado(Estudiante("Fernando", 34)))
        println()

        //Ejercicio 4
        val inventario = Inventario("Tablets", 10)
        println(inventario)
        val inventario1 = agregar(inventario, 5)
        println(inventario1)
        println()

        //Ejercicio 5
        val direccion_LaPaz = DireccionCliente("La Paz","Bolivia")
        val cliente1 = Cliente("Sandro", direccion_LaPaz)

        val direccion_WashingtonDC = DireccionCliente("Washington DC","USA")
        val cliente2 = Cliente("Willy", direccion_WashingtonDC)
        println(ubicacion(cliente1))
        println(ubicacion(cliente2))

    }
}