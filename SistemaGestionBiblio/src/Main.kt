data class Libro(val titulo: String, val autor: String, val publicacion: Int)

data class Revista(val titulo: String, val issue: Int, val publicacion: Int)

data class DVD(val titulo: String, val director: String, val publicacion: Int)

sealed class Usuario(){

    class Estudiante(val id: String, val nombre: String, val carrera: String): Usuario()
    class Profesor(val id: String, val nombre: String, val departamento: String): Usuario()
    class Visitante(val id: String, val nombre: String): Usuario()

}

fun pedirPrestamo(usuario: Usuario, libro: Libro): String{

    return when(usuario){
        //De StackOverflow: 'is' is type checking. But Kotlin has smart cast which means you can use a like Person after type check. Ejemplo: if(a is Person) { a is now treated as Person}. De esta manera hace el check de tipo y al serlo puedo aplicarle las propiedades intrínsecas de la clase.

        is Usuario.Estudiante -> "Bienvenido, ${usuario.nombre}. Ha pedido el préstamo de ${libro.titulo} de ${libro.autor}. Tiene 2 semanas para devolverlo o será sancionado. Disfrútelo."
        is Usuario.Profesor -> "Bienvenido, ${usuario.nombre}, ID: ${usuario.id}. Ha pedido el préstamo de ${libro.titulo} de ${libro.autor}. Tiene 5 semanas para devolverlo o será sancionado. Disfrútelo."
        is Usuario.Visitante -> "Los visitantes no tienen permitido el acceso al sistema de préstamos. Se le ha identificado como ${usuario.nombre} y ha intentado robar ${libro.titulo} de ${libro.autor}. Se procederá a llamar a seguridad."

    }
}




fun main() {

    val libro1 = Libro("Crónica de una muerte anunciada", "Gabriel García Márquez", 1981)
    val libro2 = Libro("Ciudad de cristal", "Paul Auster", 1985)
    val libro3 = Libro("La marca en la pared", "Virginia Woolf", 1917)

    val revista1 = Revista("Shueisha Weekly Shonen Jump", 332, 1229)

    val dvd1 = DVD("Malditos bastardos", "Quentin Tarantino", 2009)

    val estudiante = Usuario.Estudiante("11235", "Mario", "Filología Hispánica")
    val profesor = Usuario.Profesor("456", "Rafael", "Narrativa Inglesa")
    val visitante = Usuario.Visitante("11291028", "Mario Tamayo")

    println(pedirPrestamo(estudiante, libro1))
    println(pedirPrestamo(profesor, libro2))
    println(pedirPrestamo(visitante, libro3))
}