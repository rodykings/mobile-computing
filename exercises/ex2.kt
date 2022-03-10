fun createCountainer():Pair<(number:Int)->Unit, ()->Int?>{
    var container:Int? = null;
    
    fun add(number:Int){
        container = number
    } 
    
    fun remove():Int?{
        var content = container
        container = null
        return content
    }
    
    return Pair(::add, ::remove)
}


fun main() {
    val (add, remove) = createCountainer() //deconstruct a Pair
    
    add(3)
    println(remove())
    println(remove())
    
}
