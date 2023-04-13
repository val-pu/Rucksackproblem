import java.util.LinkedList
import java.util.Scanner

var maxWeight: Int = 0
lateinit var calculatedWeights: Array<IntArray>
lateinit var itemWeights: IntArray
lateinit var itemValues: IntArray

fun main(args: Array<String>) {
    getInput()

    calculatedWeights = Array(itemWeights.size) { _ -> IntArray(maxWeight) { _ -> 0 } }

}


fun getInput() {
    val stdIn = Scanner(System.`in`)

    val getCommaSeperatedInput = { prompt: String ->
        print(prompt)
        val result = stdIn.next().split(",").stream().mapToInt(Integer::parseInt).toArray()
        println()
        result
    }

    itemWeights = getCommaSeperatedInput("Please enter the weight of the items (w1,w2,...): ")
    itemValues = getCommaSeperatedInput("Please enter the value of your items (v1,v2,...): ")

    print("Please enter the max weight one can carry: ")
    maxWeight = stdIn.nextInt()
}

fun doAlgorithmForCell(currentItemID: Int, currentMaxWeight: Int) {
    val currentItemWeight = itemWeights[currentItemID]

    calculatedWeights[currentItemID][currentMaxWeight] += if (currentItemWeight <= currentMaxWeight) currentItemWeight else 0

    calculatedWeights[currentItemID][currentMaxWeight] += findMaxValue(
        currentItemID,
        currentMaxWeight - calculatedWeights[currentItemID][currentMaxWeight]
    )
}

fun findMaxValue(currentItemId: Int, maxWeight: Int): Int {
    var resultWeight = 0

    repeat(currentItemId - 1) { i ->
        val currentRow = calculatedWeights[i]

        repeat(maxWeight) { currentWeight ->
            if (resultWeight < currentWeight)
                resultWeight = currentWeight
        }

    }
    return maxWeight
}
