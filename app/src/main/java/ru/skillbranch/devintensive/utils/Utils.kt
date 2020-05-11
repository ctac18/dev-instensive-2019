package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?) : Pair<String?, String?> { // not null
        val parts: List<String>? = fullName?.trim()?.split(" ")

        var firstName = parts?.getOrNull(0)?.trim()?.let { if(it.isEmpty()) null else it }//?:"#Null first name#"

        var lastName = parts?.getOrNull(1)?.trim()?.let{ if(it.isEmpty()) null else it }//?:"#Null last name#"

        return firstName to lastName
    }

    fun transliteration(payload: String,divider:String = " "): String {
        val russianLetter = arrayOf("А","Б","В","Г","Д","Е","Ё", "Ж", "З","И","Й","К","Л","М","Н","О","П","Р","С",
            "Т","У","Ф","Х","Ч", "Ц","Ш", "Щ", "Э","Ю", "Я", "Ы","Ъ", "Ь", "а","б","в","г","д","е","ё",
            "ж", "з","и","й","к","л","м","н","о","п","р","с","т","у","ф","х","ч", "ц","ш", "щ", "э","ю",
            "я", "ы","ъ","ь")
        val englishLetter = arrayOf("A","B","V","G","D","E","E","Zh","Z","I","I","K","L","M","N","O","P","R","S",
            "T","U","F","H","Ch","C","Sh","'Sh'","E","Yu","Ya","I","", "", "a","b","v","g","d","e",
            "e","zh","z","i","i","k","l","m","n","o","p","r","s","t","u","f","h","ch","c","sh","sh",
            "e","yu","ya","i","","")

        var newString:String = ""
        var found = false

        for (i in 0 until payload.length) {
            found = false
            for(j in 0 until englishLetter.size){

                if (payload[i].toString() == russianLetter[j])
                {
                    newString += englishLetter[j]
                    found = true
                }
            }
            if (payload[i].toString()==" ") newString+=divider
             else if(!found) newString+=payload[i]
        }

        return newString
    }

    fun toInitials(firstName: String?, lastName: String?): String? {

        var fName = firstName?.trim()
        var lName = lastName?.trim()

       var result = if(fName.isNullOrBlank() && lName.isNullOrBlank()) null else
           "${fName?.get(0)?.toUpperCase()?:""}${lName?.get(0)?.toUpperCase()?:""}"

        return result
    }
}