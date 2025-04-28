import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.time.LocalTime

class ClockViewModel : ViewModel() {
    private val _currentTime = MutableStateFlow(LocalTime.now().toString())
    private val _gyroRotation = MutableStateFlow(0f)
    private val _isNightMode = MutableStateFlow(false)

    val uiState: StateFlow<ClockUiState> = combine(
        _currentTime,
        _gyroRotation,
        _isNightMode
    ) { time, rotation, isNightMode ->
        ClockUiState(
            time = time,
            triangleRotation = rotation,
            isNightMode = isNightMode,
            triangleColor = calculateTriangleColor(time)
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = ClockUiState()
    )

    init {
        viewModelScope.launch {
            while (true) {
                _currentTime.value = LocalTime.now().toString()
                delay(1000)
            }
        }
    }

    fun updateGyroData(value: Float) {
        _gyroRotation.value += value * 5f
    }

    fun toggleNightMode() {
        _isNightMode.value = !_isNightMode.value
    }

    private fun calculateTriangleColor(time: String): Color {
        val hour = LocalTime.parse(time).hour
        return when {
            hour == 12 -> Color.White
            hour == 0 -> Color.Black
            hour == 9 -> Color.White
            hour == 15 -> Color.Black
            else -> uiState.value.triangleColor // Garde la dernière couleur connue
        }
    }
}

data class ClockUiState(
    val time: String = "",
    val triangleRotation: Float = 0f,
    val isNightMode: Boolean = false,
    val triangleColor: Color = Color.White
)