package com.example.fragmentlambda
import com.example.fragmentlambda.Usuario


import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import java.net.PasswordAuthentication

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var clickBtnEnviarMensaje: (Usuario) -> Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        val btnEnviarMensaje = view.findViewById<Button>(R.id.btnEnviarMensaje)
        val edtMensaje = view.findViewById<EditText>(R.id.edtMensaje)
        val edtApellidos = view.findViewById<EditText>(R.id.edtApellidos)
        val edtTelefono = view.findViewById<EditText>(R.id.edtTelefono)
        val edtCorreo = view.findViewById<EditText>(R.id.edtCorreo)
        val edtUsuario = view.findViewById<EditText>(R.id.edtUsuario)
        val edtPassword = view.findViewById<EditText>(R.id.edtPassword)

        //cuando se presione el botón, se llamará a la función lambda
        btnEnviarMensaje.setOnClickListener {
            val usuario = Usuario(
                mensaje = edtMensaje.text.toString(),
                apellidos = edtApellidos.text.toString(),
                telefono = edtTelefono.text.toString(),
                correo = edtCorreo.text.toString(),
                usuario = edtUsuario.text.toString(),
                password = edtPassword.text.toString()
            )
            clickBtnEnviarMensaje(usuario)
        }
        return view
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    companion object {
        @JvmStatic
        //se recibe la función lambda y se referencia con la nueva variable
        fun newInstance(clickBtnEnviarMensaje: (Usuario) -> Unit): BlankFragment {
            val blankFragment = BlankFragment()
            blankFragment.clickBtnEnviarMensaje= clickBtnEnviarMensaje
            return blankFragment
        }
        /*fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }*/
    }
}