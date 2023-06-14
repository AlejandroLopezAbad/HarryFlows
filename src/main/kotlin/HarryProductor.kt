import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import models.Secretos
import models.TipoSecreto
import java.util.concurrent.atomic.AtomicInteger

class HarryProductor() {

   suspend fun producirSecretos()=flow(){
        var i :Int= 0
        while (i<20){


            val secreto=Secretos(i, TipoSecreto.values()[(0..2).random()])


            i++

            emit(secreto)
        }
        //Todo preguntar porque genera mas de 20

    }




}