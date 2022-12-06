import dof.aoc.util.AoCReader

class Day6 {

    private var data: String = AoCReader.readFileAsText("code.txt")

    fun findPackage(size: Int): Int {
            val start = data
                .windowed(size)
                .indexOfFirst {
                    it.toSet().size == size
                }
            return start + size  // We want the index of the item *after* the window
        }
}
    fun main() {
        val day = Day6()
        println(day.findPackage(4))
        println(day.findPackage(14))
    }

