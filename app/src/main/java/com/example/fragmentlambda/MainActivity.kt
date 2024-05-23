package com.example.fragmentlambda
import com.example.fragmentlambda.Usuario


import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    private lateinit var txtMensaje:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val blankFragment=BlankFragment.newInstance(response)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.frameLayout,blankFragment)

        }
    }

    /*val response:(String)-> Unit = {mensaje ->

        txtMensaje.text=mensaje

    }*/
    val response: (Usuario) -> Unit = { usuario ->
        val mensaje = usuario.mensaje
        val apellidos = usuario.apellidos
        val telefono = usuario.telefono
        val correo = usuario.correo
        val usuarioName = usuario.usuario
        val password = usuario.password

        // Concatenar todos los datos en una sola cadena
        val datosUsuario = "Mensaje: $mensaje\n" +
                "Apellidos: $apellidos\n" +
                "Teléfono: $telefono\n" +
                "Correo: $correo\n" +
                "Usuario: $usuarioName\n" +
                "Contraseña: $password"

        // Mostrar todos los datos en el TextView
        txtMensaje.text = datosUsuario

    }
}