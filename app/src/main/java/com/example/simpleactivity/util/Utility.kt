package com.example.simpleactivity.util

import java.util.*

const val app: String = "simple-activity"

fun String.printStack(message: String)
        = "${Calendar.getInstance().time} [ ${Thread.currentThread().name} ] $this ${Throwable().stackTrace[1].className}#${Throwable().stackTrace[1].methodName} $message"