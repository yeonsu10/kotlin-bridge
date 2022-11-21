package bridge

import jdk.swing.interop.DispatcherWrapper

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(result: MutableList<List<String>>) {
        printFirstUpDown(result, UP)
        printFirstUpDown(result, DOWN)
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult() {}

    private fun printUpDown(result: MutableList<List<String>>, direction: String){
        for (index: Int in 1 until result.size) {
            if (result[index][0] == direction) {
                print("| " + result[index][1] + " ")
            } else {
                print("|   ")
            }
        }
    }

    private fun printFirstUpDown(result: MutableList<List<String>>, direction: String){
        print(OPEN)
        if (result[0][0] == direction) {
            print(" " + result[0][1] + " ")
        } else {
            print("   ")
        }
        if(result.size>1){
            printUpDown(result, direction)
        }
        println(CLOSE)
    }
}
