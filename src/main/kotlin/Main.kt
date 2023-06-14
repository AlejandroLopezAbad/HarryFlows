import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import models.Secretos
import models.TipoSecreto

fun main():Unit = runBlocking{

    val harry :HarryProductor=HarryProductor()

    val harryflow = harry.producirSecretos()
   // println(harryflow.toList())




    launch{
        val ron:Consumidor=Consumidor("ron",TipoSecreto.PICO, harryflow )

        ron.consumirSecretos()



    }
    launch {
        val hermione:Consumidor=Consumidor("piba",TipoSecreto.MAR,harryflow)
        hermione.consumirSecretos()
    }

    launch {
        val teco:Consumidor=Consumidor("TECOBOOSTED",TipoSecreto.VALLE,harryflow)
        teco.consumirSecretos()
    }










}