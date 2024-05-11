package com.selimcinar.korotounies

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Light Weigthness
        /*
        GlobalScope.launch {
            repeat(10000){  //10000 kez çalıştır kodu
                launch {
                    println("android")
                }
            }
        }*/

        //Scope kapsam
        //Global Scope : global kapsam , runBlocking: önce işlem sonra runblocking , CoroutineScope: bu gerçek hayatta kullanılır.

        //Run Blocking
        /*
        println("Run blocking Start") //önce bu
        runBlocking {
            launch {
                delay(5000)
                println("run blocking") //sonra bu çalışır
            }
        }
        println("run blocking end") //en son bu çalışır
*/

        /*
        //Global Scope  : bütün uygulamada çalışır thread seçemezsin
    println("global scope start") // önce bu
        GlobalScope.launch {
            delay(5000)
            println("global scope end") // en son bu kod çalışır
        }
        println("global scope middle") // sonra bu
*/


        /*
        // İç içe Coroutine

        //CoroutineScope : istenen threada çalışır
        println("coroutine scope start") //önce bu
        CoroutineScope(Dispatchers.Default).launch {
            delay(5000)
            println("coroutine scope middle") //en son bu kod
        }
        println("coroutine scope end") // sonra bu
*/

        //dispatchers
        //Dispatchers.Default -> Cpu Intensive işlemci işlemleri
        //Dispatchers.IO -> Input / Output , Networking ağ işlemleri
        //Dispatchers.Main -> UI  , kullanıcı arayüzü.
        //Dispatchers.Unconfined -> Inherited dispatcher , işleme göre ayar.

        runBlocking {
            launch(Dispatchers.Main)
            {
                println("Main Thread : ${Thread.currentThread().name}")
            }
            launch(Dispatchers.IO) {
                println("IO Thread: ${Thread.currentThread().name}")
            }

            launch(Dispatchers.Default) {
                println("Default Thread: ${Thread.currentThread().name}")
            }
            launch(Dispatchers.Unconfined)
            {
                println("Unconfined Thread : ${Thread.currentThread().name}")
            }

        }





    }
}