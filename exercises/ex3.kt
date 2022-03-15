enum class Habitat{
    LAND, WATER, AMPHIBIOUS;
    fun livesIn(pet:Pet):Boolean{
        return (this == pet.habitat)
    }
}


class Pet(val name:String, val habitat:Habitat){
    fun liveOnLand():Boolean{
        return this.habitat.equals(Habitat.LAND)
    }
    fun liveInWater():Boolean{
        return this.habitat.equals(Habitat.WATER)
    }
    fun areAmphibious():Boolean{
        return this.habitat.equals(Habitat.AMPHIBIOUS)
    }
}


fun main() {
    
   var pets:List<Pet> = listOf<Pet>(Pet("turtle", Habitat.AMPHIBIOUS), Pet("lion", Habitat.LAND))
   
   pets += Pet("crocodile", Habitat.AMPHIBIOUS)
   pets += Pet("fish", Habitat.WATER)
   
   println(pets.filter{it.liveOnLand()})
   println(pets.filter{it.liveInWater()})
   println(pets.filter{it.areAmphibious()})
   println(pets.partition{it.areAmphibious()})
   println(Habitat.LAND.livesIn(Pet("rabbit", Habitat.LAND)))
   
}
