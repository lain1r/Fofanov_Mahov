package org.example

import sun.security.util.Password
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import kotlin.jvm.Throws

data class User(
    val name: String,
    val email: String,
    val age: Int,
    val password: String,
    val number: String

)

fun validateUserInput(name: String, email: String, age: Int): Boolean {
    val isNameValid = name.matches(Regex("[a-zA-Zа-яА-Я]+")) && name.length >= 2
    val isEmailValid = email.contains('@') &&
            email.substringAfter('@').contains('.') &&
            email.substringAfter('@').length >= 3
    val isAgeValid = age in 18..99
    return isNameValid && isEmailValid && isAgeValid
}

fun validatePassword(pass: String) : Boolean{
    val lengthPassTrue = if (pass.length >= 8) true else false
    val hasDigit = if (pass.any { it.isDigit() }) true else false
    val hasUpper = if (pass.any { it.isUpperCase() }) true else false
    val hasSpecial = if (pass.contains(Regex("[!@#$%^&*(),.?\":{}|<>]"))) true else false
    return lengthPassTrue && hasDigit && hasUpper && hasSpecial
}

fun validateNumber(num: String): String {
    val digitNum = num.filter {it.isDigit() && !it.isWhitespace() && !it.isLetter()}
    if (digitNum.length == 11) return "+7 (${digitNum.substring(1,4)}) ${digitNum.substring(4,7)}-${digitNum.substring(7,9)}-${digitNum.substring(9,11)}"
    else return "не вверный формат телефона"
}

fun formatUsers(users: List<User>): List<String> {
    return users
        .filter { it.age > 30 }
        .sortedBy { it.name }
        .map { "${it.name} (${it.email})" }
}

fun daysUntilBirthday(birthdayStr: String): Long {
    val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    val birthday = LocalDate.parse(birthdayStr, formatter)
    val today = LocalDate.now()

    var nextBirthday = birthday.withYear(today.year)
    if (nextBirthday.isBefore(today) || nextBirthday.isEqual(today)) {
        nextBirthday = nextBirthday.plusYears(1)
    }

    return ChronoUnit.DAYS.between(today, nextBirthday)
}

fun filterEven(l: List<Int>) {
    l.filter { it % 2 == 0 }
}

fun sumDigits(n: Int) {
    n.toString().sumOf { it.digitToInt() }
}

fun generatePass(len: Int): String {
    val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*"
    return (1..len).map { chars.random() }.joinToString("")
}

fun findDuplicates(l: List<Int>)  {
    l.groupBy { it }.filter { it.value.size > 1 }.keys.toList()
}

fun reverseString(s: String) {
    s.reversed()
}

fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (i in 2..Math.sqrt(n.toDouble()).toInt()) if (n % i == 0) return false
    return true
}

fun convertTemp(v: Double, toF: Boolean) {
    if (toF) v * 1.8 + 32 else (v - 32) / 1.8
}

fun main() {
    val user1 = User("Иван", "ivan@mail.com", 25, "Sds4dw12!", "1")
    println("Пользователь 1 валиден: ${validateUserInput(user1.name, user1.email, user1.age)}")
    val users = listOf(
        user1,
        User("Анна", "anna@yandex.ru", 35, "Sdsdw112", "1"),
        User("Борис", "boris@gmail.com", 28, "Sdsd3w12", "1"),
        User("Сергей", "sergey@mail.ru", 42, "Sds6dw12", "1")
    )
    formatUsers(users).forEach { println(it) }

    println("Дней до 15.12.1990: ${daysUntilBirthday("15.12.1990")}\n")

    for (b in users) println(validatePassword(b.password))

    println(validateNumber("+7 911 0074685"))

    println(filterEven(listOf(1, 2, 3, 4, 5)))

    println(sumDigits(1234))

    println(generatePass(10))

    println(findDuplicates(listOf(1, 2, 2, 3, 4, 4)))

    println(reverseString("Android"))

    println(isPrime(13))

        println(convertTemp(36.6, true))


}

