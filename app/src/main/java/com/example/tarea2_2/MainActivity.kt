package com.example.tarea2_2

    import android.app.AlertDialog
    import android.app.NotificationChannel
    import android.app.NotificationManager
    import android.content.Context
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import androidx.core.app.NotificationCompat
    import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    private fun createNotificationChannel() {
            val name = "canalPrincipal"
            val descriptionText = "descripcion"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("c1", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
    }
    //builders de notificaciones y funciones
    var notificacionAbrirApp = NotificationCompat.Builder(this, "c1")
        .setContentTitle("Aplicacion Iniciada")
        .setContentText("Disfrute")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setSmallIcon(R.drawable.ic_launcher_background)

    fun mensajeDetencion(){
        val mensaje=AlertDialog.Builder(this)
        mensaje.setTitle("App Detenida")
        mensaje.setMessage("La App ha sido detenida, vuelva pronto")
        mensaje.show()
    }

    var notificacionCerrarApp = NotificationCompat.Builder(this, "c1")
        .setContentTitle("Cierre Completo")
        .setContentText("Gracias por usar la aplicación")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setSmallIcon(R.drawable.ic_launcher_background)


    //overrides
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()
    }
    override fun onResume() {
        super.onResume()
    }

    override fun onRestart() {
        super.onRestart()
    }
    override fun onStart() {
        super.onStart()
        with(NotificationManagerCompat.from(this)) {
            notify(1, notificacionAbrirApp.build()) }
        }

    override fun onStop() {
        super.onStop()
        mensajeDetencion()
    }

    override fun onPause() {
        super.onPause()

    }

    override fun onDestroy() {
        super.onDestroy()
        with(NotificationManagerCompat.from(this)) {
            notify(1, notificacionCerrarApp.build())
        }
    }
    }
