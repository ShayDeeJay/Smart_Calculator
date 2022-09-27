class Calculator {
    private val inputCalculation = readln().split(" ")
    private val inputCleaned = mutableListOf<String>()


    fun otherOptions(): Boolean {
        when{
            inputCalculation[0] == "/exit" -> {
                println("Bye!")
                return true
            }
            inputCalculation[0] == "/help" -> println("The program calculates the with both addition and subtraction.")
        }
        return false
    }

    fun inputCleaner() {
        for (a in inputCalculation) {
            when{
                a.isEmpty() ->{
                    continue
                }
                a.contains("--") -> {
                    when{
                        a.length % 2 == 0 -> inputCleaned.add("+")
                        else -> inputCleaned.add("-")
                    }
                }
                a.contains("+") -> {
                    if (a.length > 1) {
                        inputCleaned.add("+")
                    } else inputCleaned.add(a)
                }
                else -> inputCleaned.add(a)
            }
        }
    }

    fun mainCalculation(): Boolean{
        if(otherOptions()) {
            return true
        }
        inputCleaner()
        try{
            var total = inputCleaned[0].toInt()
            for (all in inputCleaned.indices) {
                if(inputCleaned[all] == "+") {
                    total += inputCleaned[all + 1].toInt()
                }
                if(inputCleaned[all] ==  "-") {
                    total -= inputCleaned[all + 1].toInt()
                }
            }
            println(total)
        } catch (_: NumberFormatException){

        } catch (_: IndexOutOfBoundsException) {

        }
        return false
    }
}

fun main() {

    while (true) {
        if (Calculator().mainCalculation()) {
            break
        }
    }
}
