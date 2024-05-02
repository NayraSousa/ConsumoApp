package consumo.viagem.app

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import consumo.viagem.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button) {
            calculate()
        }
    }

    private fun isValid(): Boolean {
        return (binding.editTitle1.text.toString() != "" &&
                binding.editTitle2.text.toString() != "" &&
                binding.editAutonomy.text.toString() != "")
    }

    private fun calculate() {
        if (isValid()) {
            val distance = binding.editTitle1.text.toString().toFloat()
            val price = binding.editTitle2.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()
            if (autonomy == 0f) {
                Toast.makeText(this, R.string.division_byZero, Toast.LENGTH_SHORT).show()
            }
            else {
                val totalValue = (price * distance) / autonomy
                binding.total.text = "R$ ${"%.2f".format(totalValue)}"
            }
        } else {
            Toast.makeText(this, R.string.erros, Toast.LENGTH_SHORT).show()
        }

    }
}

