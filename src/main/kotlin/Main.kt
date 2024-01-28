import kotlin.random.Random

fun main() {
    val robots = listOf(
        Robot("R2D2") { 0 },
        Robot("DAW1A") { Random.nextInt(2) * 180 },
        Robot("DAW1B") { if (Random.nextBoolean()) 90 else 270 },
        Robot("DAM1") { Random.nextInt(4) * 90 }
    )

    print("Ingrese el número de movimientos: ")
    val numMovimientos = readLine()?.toIntOrNull() ?: 0

    val movimientos = Array(numMovimientos) {
        (1..Random.nextInt(20)).map { Random.nextInt(-20, 21) }.toIntArray()
    }

    for (robot in robots) {
        println("\nMovimientos para ${robot.nombre}:")

        val movimientosRobot = mutableListOf<Int>()
        for (movimiento in movimientos) {
            movimientosRobot.addAll(movimiento.toList())
        }

        robot.mover(movimientosRobot.toIntArray())
        robot.mostrarPosicion()
    }

}