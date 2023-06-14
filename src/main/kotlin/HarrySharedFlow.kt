import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import models.Personajes
import models.Secretos
import models.TipoSecreto

private const val MAX_SECRETOS = 50


class HarrySharedFlow(val personaje:Personajes) {
    //Vamos a usar un SharedFlow, este se puede configurar y
    // para ver que funciona igual que el STATEFlow lo vamos a configurar
    // de esa manera, ya que un StateFlow es un SharedFlow con ciertas especificaciones
    val _cofre: MutableSharedFlow<Secretos> = MutableSharedFlow(replay=5, onBufferOverflow = BufferOverflow.DROP_OLDEST )
    val cofre: SharedFlow<Secretos> = _cofre.asSharedFlow()

    init {
        println("\uD83E\uDDD9 ${personaje.name} ha llegado!")
        println("\uD83E\uDDD9 ${personaje.name} -> Estoy guardando secretos en \uD83C\uDF81...")
    }

    suspend fun emitirSecretos() {
        repeat(MAX_SECRETOS) { i ->
            delay((300..700).random().toLong())
            _cofre.tryEmit(
                Secretos(
                    id = (i + 1),
                    tipoSecreto = TipoSecreto.values().random()
                )
            )
        }
        println("\uD83E\uDDD9 ${personaje.name} -> He terminado de crear secretos \uD83C\uDF81...")
    }








}