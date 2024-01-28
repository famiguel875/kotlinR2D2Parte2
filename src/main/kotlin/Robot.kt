class Robot(val nombre: String, val direccionInicial: () -> Int) {
    var posX: Int = 0
    var posY: Int = 0
    var dir: Int = direccionInicial()

    fun mover(movimientos: IntArray) {
        for (valor in movimientos) {
            when (this.dir) {
                0 -> this.posY += valor
                1 -> this.posX += valor
                2 -> this.posY -= valor
                3 -> this.posX -= valor
            }

            if (this.dir < 3) this.dir += 1 else this.dir = 0
        }
    }

    fun mostrarPosicion() {
        println("$nombre está en ($posX, $posY) ${obtenerDireccion()}")
    }

    fun obtenerDireccion(): String {
        return when (this.dir) {
            0 -> "PositiveY"
            1 -> "PositiveX"
            2 -> "NegativeY"
            3 -> "NegativeX"
            else -> throw IllegalArgumentException("Dirección no válida: $dir")
        }
    }
}