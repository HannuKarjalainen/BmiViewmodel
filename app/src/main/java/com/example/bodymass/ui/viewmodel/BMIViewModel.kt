import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class BmiViewModel : ViewModel() {
    var height by mutableStateOf("")
    var weight by mutableStateOf("")
    var bmi by mutableStateOf("0.00")
    var bmiCategory by mutableStateOf("")

    fun calculateBmi() {
        val heightValue = height.replace(',', '.').toDoubleOrNull() ?: 0.0
        val weightValue = weight.replace(',', '.').toDoubleOrNull() ?: 0.0

        if (heightValue > 0 && weightValue > 0) {
            val calculatedBmi = weightValue / (heightValue * heightValue)
            bmi = String.format("%.2f", calculatedBmi)
            bmiCategory = when {
                calculatedBmi < 18.5 -> "Underweight"
                calculatedBmi in 18.5..24.9 -> "Normal weight"
                calculatedBmi in 25.0..29.9 -> "Overweight"
                else -> "Obese"
            }
        } else {
            bmi = "0.00"
            bmiCategory = "Please enter valid height and weight."
        }
    }
}
