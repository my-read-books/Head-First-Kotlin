class Song(val title: String, artist: String) {

    init {
        println("Song class has been created")
    }

    val artist = artist
//custom getter
    val fullString: String
        get() = "$title $artist"
//custom setter
    var duration: Int = 1
        set(value) {
            if (value > 0) field = value
        }


    init {
        println("Can use few init blocks")
    }
    // can initialized var later by use lateinit

    /*You can only use lateinit with properties defined using var, and you
can’t use it with any of the following types: Byte, Short, Int, Long,
Double, Float, Char or Boolean. This is down to how these types are
treated when the code runs in the JVM. This means that properties of any of
these types must be initialized when the property is defined, or in an
initializer block. */

    lateinit var size: String

    fun play() {
        size = "in play"
        println("Playing the song $title by $artist")
    }

    fun stop() {
        size = "in stop"
        println("Stopped playing $title")
    }
}

fun main() {
    val songOne = Song("The mesopotamians", "They Might be Giants")
    val songTwo = Song("Going underground", "The Jam")
    val songTree = Song("Make Me Smile", "Steve Harley")

    songTwo.play()
    songTwo.stop()
    songTree.play()
    println(songTwo.size)
    println("Test getter: ${songTwo.fullString}")
    println("Test setter: ${songTwo.duration}")
    songTwo.duration += 10
    println("Test setter: ${songTwo.duration}")
}