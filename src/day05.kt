import kotlin.math.abs

//  --- Day 5: Hydrothermal Venture ---

data class LineSegment(var x1 : Int, var y1 : Int, val x2 : Int, val y2 : Int)

fun part1(input: List<LineSegment>): Int {
    val max = maxOf(input.maxOf { it.x1 },input.maxOf { it.x2 },input.maxOf { it.y1 },input.maxOf { it.y2 })+1
    val diagram = MutableList(max){MutableList(max){0} }
    val horizontal = input.filter { it.y1 == it.y2 }
    val vertical = input.filter { it.x1 == it.x2 }

        for (i in vertical) if (i.y1 < i.y2){
            for (g in i.y1..i.y2){
                if (diagram[g][i.x1] > 0) diagram[g][i.x1] = 2 else diagram[g][i.x1] = 1
            }
            } else {
                for (g in i.y1 downTo i.y2){
                if (diagram[g][i.x1] > 0) diagram[g][i.x1] = 2 else diagram[g][i.x1] = 1
            }
        }

        for (i in horizontal) if (i.x1 < i.x2){
            for (g in i.x1..i.x2){
                if (diagram[i.y1][g] > 0) diagram[i.y1][g] = 2 else diagram[i.y1][g] = 1
            }
            } else {
                for (g in i.x1 downTo i.x2){
                if (diagram[i.y1][g] > 0) diagram[i.y1][g] = 2 else diagram[i.y1][g] = 1
            }
        }

    var dangerousAreas = 0
    for (i in diagram){
        for (g in i) if (g == 2)  dangerousAreas++
    }
    return dangerousAreas
}

fun part2(input: List<LineSegment>){
    val max = maxOf(input.maxOf { it.x1 },input.maxOf { it.x2 },input.maxOf { it.y1 },input.maxOf { it.y2 })+1
    val diagram = MutableList(max){MutableList(max){0} }
    val horizontal = input.filter { it.y1 == it.y2 }
    val vertical = input.filter { it.x1 == it.x2 }
    val diagonal = input.filter { abs(it.x1 - it.x2) == abs(it.y1 - it.y2)}
    println(diagonal)
    for (i in diagonal){
        if (i == LineSegment(x1=6, y1=4, x2=2, y2=0)){
            while (true){
            diagram[i.y1][i.x1] = 99
            if (i.x1 == i.x2 && i.y1 == i.y2)break
            i.x1 = i.x1 - 1
            i.y1 = i.y1- 1
        }
        }
        if (i == LineSegment(x1=0, y1=0, x2=8, y2=8)){
            while (true){
            diagram[i.y1][i.x1] = 99
            if (i.x1 == i.x2 && i.y1 == i.y2)break
            i.x1 = i.x1 + 1
            i.y1 = i.y1 + 1
        }
        }

    }

        /*for (i in vertical) if (i.y1 < i.y2){
            for (g in i.y1..i.y2){
                if (diagram[g][i.x1] > 0) diagram[g][i.x1] = 2 else diagram[g][i.x1] = 1
            }
            } else {
                for (g in i.y1 downTo i.y2){
                if (diagram[g][i.x1] > 0) diagram[g][i.x1] = 2 else diagram[g][i.x1] = 1
            }
        }

        for (i in horizontal) if (i.x1 < i.x2){
            for (g in i.x1..i.x2){
                if (diagram[i.y1][g] > 0) diagram[i.y1][g] = 2 else diagram[i.y1][g] = 1
            }
            } else {
                for (g in i.x1 downTo i.x2){
                if (diagram[i.y1][g] > 0) diagram[i.y1][g] = 2 else diagram[i.y1][g] = 1
            }
        }
*/
    var dangerousAreas = 0
    for (i in diagram){
        println(i)
        for (g in i) if (g == 2)  dangerousAreas++
    }
    println(dangerousAreas)
}

fun main() {
    val input = readInput("day05").map { val (x1,y1,x2,y2) = it.split(","," -> ",",")
        LineSegment(x1.toInt(),y1.toInt(),x2.toInt(),y2.toInt()) }
    println(part1(input)) //5167
    println(part2(input)) //17604
}


