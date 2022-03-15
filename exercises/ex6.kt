class Robot(var x:Int, var y:Int, val fieldSize:Int){
    
    fun goLeft(k:Int){
       if(x-k >= 0) x-=k else x=fieldSize-k
    }
    fun goRight(k:Int){
       if(x+k <= fieldSize-1) x+=k else x=k-1
    }
    fun goUp(k:Int){
       if(y-k >= 0) y-=k else y=fieldSize-k
    }
    fun goDown(k:Int){
       if(y+k <= fieldSize-1) y+=k else y=k-1
    }
    fun getLocation():String{
        return this.x.toString()+","+this.y.toString()
    }
    override fun toString():String{
        return "Robot(x="+this.x+", y="+this.y+")"
    }
}

fun main(){
    var robot:Robot = Robot(0, 0, 10)
    robot.goLeft(1)
    robot.goRight(1)
    robot.goUp(1)
    robot.goDown(1)
    robot.goRight(2)
    robot.goDown(4)
    println(robot.getLocation())
    println(robot)
}
