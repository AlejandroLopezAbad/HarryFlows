package models

data class Secretos( val id:Int, val tipoSecreto:TipoSecreto) {


}


enum class TipoSecreto(val tipo:String){
    PICO("pico"),
    VALLE("valle"),
    MAR("mar"),
    NONE("none")


}