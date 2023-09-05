package challenges.activity2

fun String.encodeToEmail() = this // unimplemented yet
fun String.encodeToSms() = this // unimplemented yet
fun String.encodeToMorseCode() = this // unimplemented yet
fun String.encodeToBeep() = this // unimplemented yet

interface MessageService {
    fun send(message: String)
}

class EmailMessageService: MessageService {
    override fun send(message: String) {
        println(message.encodeToEmail())
        println("Message sent via email!")
    }
}

class SmsMessageService: MessageService {
    override fun send(message: String) {
        println(message.encodeToSms())
        println("Message sent via SMS!")
    }
}

class BeeperPlugMessageService: MessageService {
    override fun send(message: String) {
        println(message.encodeToMorseCode().encodeToBeep())
        println("Receiver's beeper has vibrated the message.")
    }
}

class MessageSender(val messageService: MessageService) {
    var message = ""

    fun send() = messageService.send(message)
}