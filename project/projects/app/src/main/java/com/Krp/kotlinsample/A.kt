package com.Krp.kotlinsample


fun main(){
    val audi = Audi(7777)
}

open class Car(chassisNo: Int){
    // Basic Entities of car
    var manufactureNo = 101010
    init {
        println("ChasisNo is: "+ chassisNo)
    }

    fun pressBreaks() : String{
        println("Car has been Stopped")
        return "Break pressed"
    }

    fun pressAccleration(speed:Int): String{
        println("car accelerated with " + speed + "Km/hr speed")
        return "car accelerated"
    }

    fun ChangeGear(gearNo:Int): String{
        println("Gear shifted to " + gearNo)
        return "gear shifted"
    }
}

class Audi(chassisNo: Int): Car(chassisNo){

    //var chasisNo = 10000

    init {
        println("Aud Created " + super.manufactureNo)
        println("step1: " + super.ChangeGear(1))
        println("step2: " + super.pressAccleration(10))
        println("step3: " + super.ChangeGear(2))
        println("step4: " + super.pressBreaks())
    }

}