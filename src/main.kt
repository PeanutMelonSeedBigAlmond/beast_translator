val dict = "嗷呜啊~".toCharArray()
fun main() {
    val beastString = toBeast("两只老虎爱跳舞，小兔子乖乖拔萝卜")
    println(beastString)
    val rawString = fromBeast(beastString)
    println(rawString)
}

fun toBeast(rawString: String): String {
    val array = rawString.toCharArray()
    val unicodeStr = StringBuffer()
    array.forEach {
        val hex = String.format("%04x", it.toInt())
        unicodeStr.append(hex)
    }
    val unicodeStrArray = unicodeStr.toString().toCharArray()
    val outputStr = StringBuffer()
    unicodeStrArray.forEachIndexed { i, ch ->
        val unicodeHexCharValue = Integer.valueOf(ch.toString(), 16)
        var k = unicodeHexCharValue + (i % 0x10)
        if (k >= 0x10) {
            k -= 0x10
        }
        outputStr.append(dict[k / 4]).append(dict[k % 4])
    }
    return "~呜嗷${outputStr}啊"
}

fun fromBeast(decoratedBeastStr: String): String {
    val beastStr = decoratedBeastStr.substring(3 until decoratedBeastStr.length)
    val unicodeHexStr = StringBuffer()
    for (i in 0..beastStr.length - 2 step 2) {
        var pos1 = dict.indexOf(beastStr[i])
        if (pos1 == -1) {
            pos1 = 3
        }

        var pos2 = dict.indexOf(beastStr[i + 1])
        if (pos2 == -1) {
            pos2 = 3
        }

        val k = pos1 * 4 + pos2
        var unicodeHexCharValue = k - ((i / 2) % 0x10)
        if (unicodeHexCharValue < 0) {
            unicodeHexCharValue += 0x10
        }
        unicodeHexStr.append(unicodeHexCharValue.toString(16))
    }
    val rawString = StringBuffer()
    for (start in unicodeHexStr.indices step 4) {
        val end = start + 4
        val charHexStr = unicodeHexStr.substring(start, end)
        val charStr = Integer.valueOf(charHexStr, 16).toChar()
        rawString.append(charStr)
    }
    return rawString.toString()
}