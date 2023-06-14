import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import models.Personajes
import models.Secretos
import models.TipoSecreto

private const val MAX_SECRETOS = 50

class HarryStateFlow(val personaje: Personajes) {


    private val _cofre: MutableStateFlow<Secretos> = MutableStateFlow(Secretos(0, TipoSecreto.NONE))
    val cofre: StateFlow<Secretos> = _cofre.asStateFlow()

    init {
        println("\uD83E\uDDD9 ${personaje.name} ha llegado!")
        println("\uD83E\uDDD9 ${personaje.name} -> Estoy guardando secretos en \uD83C\uDF81...")
    }

    suspend fun emitirSecretos() {
        repeat(MAX_SECRETOS) { i ->
            delay((300..700).random().toLong())
            _cofre.value = Secretos(
                id = (i + 1),
                tipoSecreto = TipoSecreto.values().random()
            )
        }
        println("\uD83E\uDDD9 ${personaje.name} -> He terminado de crear secretos \uD83C\uDF81...")
    }
}