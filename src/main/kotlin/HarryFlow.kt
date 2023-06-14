import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import models.Personajes
import models.Secretos
import models.TipoSecreto

private const val MAX_SECRETOS = 50


class HarryFlow(val personaje: Personajes) {


    init {
        println("\uD83E\uDDD9 ${personaje.name} ha llegado!")
        println("\uD83E\uDDD9 ${personaje.name} -> Estoy guardando secretos en \uD83C\uDF81...")

    }


    suspend fun emitirSecretos(): Flow<Secretos> = flow { //El flow es con minisucla Recordar
        repeat(MAX_SECRETOS) { i ->
            delay((300..700).random().toLong())
            emit(
                Secretos(
                    id = (i + 1),
                    tipoSecreto = TipoSecreto.values().random()
                )
            )

        }
        println("\uD83E\uDDD9 ${personaje.name} -> He terminado de crear secretos \uD83C\uDF81...")
    }
}