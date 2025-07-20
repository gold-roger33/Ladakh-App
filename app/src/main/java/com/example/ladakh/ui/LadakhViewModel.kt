import androidx.lifecycle.ViewModel
import com.example.ladakh.DataSources.DataSources
import com.example.ladakh.model.DetialedScreenData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LadakhViewModel : ViewModel() {
    private val _currentCategory = MutableStateFlow<Int?>(null)
    val currentCategory: StateFlow<Int?> = _currentCategory.asStateFlow()

    private val _selectedItem = MutableStateFlow<Pair<Int, Int>?>(null)
    val selectedItem: StateFlow<Pair<Int, Int>?> = _selectedItem.asStateFlow()

    fun setCategory(categoryId: Int) {
        _currentCategory.value = categoryId
        // Auto-select first item in the category
        _selectedItem.value = Pair(categoryId, 1)
    }

    fun selectItem(categoryId: Int, itemId: Int) {
        _selectedItem.value = Pair(categoryId, itemId)
    }

    fun getDetailedItem(categoryId: Int, itemId: Int): DetialedScreenData? {
        return DataSources.DetialedScreenItems[categoryId]?.getOrNull(itemId - 1)
    }

    fun clearSelection() {
        _currentCategory.value = null
        _selectedItem.value = null
    }
}