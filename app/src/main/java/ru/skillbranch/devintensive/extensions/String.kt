package ru.skillbranch.devintensive.extensions

fun String.truncate (count :Int = 16):String {

    var result = this.trim()

    if (count == result.length || count >= result.length)
    {
        return result
    }
    result = result.substring(0, count)

    if (result.last()==' ')
     {
        result = result.dropLast(1)
     }
     result +="..."

    return result
}

fun String.stripHtml ():String {
    var result = Regex("""<.*?>|&amp;|&lt;|&gt;|&quot;|&#.\d?;""").replace(this, "")
//    var result = Regex("""<.*?>|&.*?;|&#.\d?;""").replace(this, "")

    result = Regex("""\s+""").replace(result," ")

    return result

}