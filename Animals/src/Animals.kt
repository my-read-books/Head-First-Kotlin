// To use a class as a superclass, it must be declared as abstract . Everything you
//want to override must also be abstract .

interface Roamable{
    fun roam()
}

abstract class Animal(): Roamable {
    abstract val image: String
    abstract val food: String
    abstract val habitat: String
    var hunger = 10

    abstract fun makeNoise()

    abstract fun eat()

    override fun roam() {
        println("The Animal is roaming")
    }

    fun sleep() {
        println("The Animal is sleeping")
    }
}

//To make a class inherit from another, you add a colon (:) to the class header
//followed by the name of the superclass.

// When inherit must call constructor of superclass () - Animal()

class Hippo : Animal() {

    // if val - use override, but if var - change it value in init: init{hunger = newValue}
    // can override val by var, but not it works one way (can't override var to val)

    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"

    override fun makeNoise() {
        println("Grunt! Grunt!")
    }

    override fun eat() {
        println("The Hippo is eating $food")
    }
}

//If you want to stop a function or property from being overridden further down
//the class hierarchy, you can prefix it with final.

abstract class Canine : Animal() {
    override fun roam() {
        println("The Canine is roaming")
    }
}

class Wolf : Canine() {
    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"

    override fun makeNoise() {
        println("Hooooowl!")
    }

    override fun eat() {
        println("The Wolf is eating $food")
    }
}

class Vehicles: Roamable{
    override fun roam() {
        println("The Vehicles is roaming")
    }

}

class Vet {
    fun giveShoot(animal: Animal) {
        // Do same medical
        animal.makeNoise()
    }
}

fun main(args: Array<String>) {
    val animals = arrayOf(Hippo(), Wolf())
    for (animal in animals) {
        animal.roam()
        animal.eat()
    }

    val vet = Vet()
    val wolf = Wolf()
    val hippo = Hippo()
    vet.giveShoot(wolf)
    vet.giveShoot(hippo)

    val roamables = arrayOf(Hippo(), Wolf(), Vehicles())
    for (item in roamables){
       item.roam()
        if (item is Animal){
            item.eat()
        }
    }
}