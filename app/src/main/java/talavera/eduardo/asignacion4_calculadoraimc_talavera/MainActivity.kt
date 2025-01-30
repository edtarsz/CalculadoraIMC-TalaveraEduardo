package talavera.eduardo.asignacion4_calculadoraimc_talavera

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import talavera.eduardo.asignacion4_calculadoraimc_talavera.ui.theme.Asignacion4_CalculadoraIMC_TalaveraTheme

class MainActivity : ComponentActivity() {

    // Hecho por Eduardo Talavera Ramos 245244
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val estatura: TextView = findViewById(R.id.etEstatura)
        val peso: TextView = findViewById(R.id.etPeso)
        val textIMC: TextView = findViewById(R.id.imc)
        val categoria: TextView = findViewById(R.id.categoria)
        val calcular: Button = findViewById(R.id.btnCalcular)

        // evento button
        calcular.setOnClickListener{
            val imc = calcular(peso.text.toString().toDouble(), estatura.text.toString().toDouble())
            textIMC.visibility = View.VISIBLE
            categoria.visibility = View.VISIBLE
            textIMC.text = "Tu índice de masa corporal es: %.2f".format(imc)
            val resultadoCategoria = category(imc)
            categoria.text = resultadoCategoria

            val colorBackground = ContextCompat.getColor(this, color(resultadoCategoria))
            categoria.setBackgroundColor(colorBackground)
        }
    }

    fun calcular(peso: Double, estatura: Double): Double{
        return peso/ Math.pow(estatura, 2.0)
    }

    fun category(imc: Double): String {
        return when {
            imc < 18.5 -> "Bajo Peso"
            imc in 18.5..24.9 -> "Normal"
            imc in 25.0..29.9 -> "Sobrepeso"
            imc in 30.0..34.9 -> "Obesidad grado 1"
            imc in 35.0..39.9 -> "Obesidad grado 2"
            else -> "Obesidad grado 3"
        }
    }

    fun color(categoria: String): Int {
        return when (categoria){
            "Bajo Peso" -> R.color.colorGreenish
            "Normal" -> R.color.colorGreen
            "Sobrepeso" -> R.color.colorYellow
            "Obesidad grado 1" -> R.color.colorOrange
            "Obesidad grado 2" -> R.color.colorRed
            else -> R.color.colorRed
        }
    }
}

