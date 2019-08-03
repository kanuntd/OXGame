var table = arrayOf(
    arrayOf(' ','1','2','3'),
    arrayOf('1','-','-','-'),
    arrayOf('2','-','-','-'),
    arrayOf('3','-','-','-')
)

var player = 'X'

fun printWelcome(){
    println("Welcome to OX Game")
    println("----------------------------------------")
}

fun printTable(){
    for(row in table){
        for(col in row){
            print("$col ")
        }
        println()
    }
    println("----------------------------------------")
}

fun swicthPlayer(){
    if(player == 'X'){
        player = 'O'
    }else if(player == 'O'){
        player = 'X'
    }
}


fun printInput(){
    while (true){
        try {
            println("$player turn")
            print("Please input Row Col: ")
            val input = readLine()
            val strSplit : List<String>? = input?.split(" ")
            if(strSplit?.size !=2 ){
                println("Error: Must input 2 numbers (Ex: 1 1)")
            }else{
                val row = strSplit?.get(0)?.toInt()
                val col = strSplit?.get(1)?.toInt()
                //println("${strSplit?.get(0)}  ${strSplit?.get(1)}")
                if(table[row!!][col!!] != '-'){
                    println("Error: Must input unique number")
                }else{
                    table[row!!][col!!] = player
                    printTable()
                    ///println(checkWin(row, col))
                    val result = checkWin(row,col)
                    if(result == ""){
                        swicthPlayer()
                        continue
                    }else{
                        println("$player $result")
                        break
                    }



                }
            }


        }catch (t:Throwable){
            println("Error: Must input Row 1-3 and Col 1-3")
        }
    }

}
fun checkWin(row : Int,col:Int) : String  {
    var text = "Win!"

    //แนวตั้ง
    for(x in 1..3){
        if(table[x][col]!= table[row][col]){
            text = ""
            break
        }
    }
    //แนวนอน
    if(text == ""){
        text = "Win!"
        for(y in 1..3) {
            if (table[row][y] != table[row][col]) {
                text = ""
                break
            }
        }
    }

    if(text==""){
        if(row==1 && col == 1 || row==1&&col ==3||row==3 && col==1 ||
                row==3&& col==3 || row==2&& col == 2){
            //แนวเฉียง
            if(table[1][1]== player && table[2][2] == player && table[3][3] == player ||
                table[1][3] == player && table[2][2] == player&& table[3][1] == player){
                text = "Win!"
            }else {
                text = "Draw!"
                for (r in table) {
                    for (c in r) {
                        if (c == '-') {
                            text = ""
                        }
                    }
                }
            }
        }else{
            text = "Draw!"
            for (r in table) {
                for (c in r) {
                    if (c == '-') {
                        text = ""
                    }
                }
            }
        }
    }


    return text






}


fun main() {
    printWelcome()
    printTable()
    printInput()

}