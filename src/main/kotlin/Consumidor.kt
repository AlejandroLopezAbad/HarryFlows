import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import models.Secretos
import models.TipoSecreto

class Consumidor(val name:String, val tipo:TipoSecreto,val flow: Flow<Secretos>) {

    suspend fun consumirSecretos(){
        flow.filter { tipo==it.tipoSecreto }.collect(){
            delay(1500L)

            println("EL consumidor $name consume los secretos de tipo $tipo  y los printea "+it)

        }
    }






}