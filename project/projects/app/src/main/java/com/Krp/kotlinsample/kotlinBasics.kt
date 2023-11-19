package com.Krp.kotlinsample

class MyClass{

    companion object{
        @JvmStatic
        fun main(args: Array<String>){
            println("Hello World!")


            val alist = listOf("Narayan","Hari",1,"Krishna","Ram")
            print(alist)

            val mlist = mutableListOf<Any>("Narayan","Hari","Krishna","Ram")
            mlist.add("chaturbhuj")
            println(mlist)
        }
    }
}