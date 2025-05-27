package com.example.storeapp.core.remote.viewModel

import android.app.Application
import androidx.compose.runtime.*
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeapp.core.entities.User
import com.example.storeapp.core.remote.ResultState
import com.example.storeapp.core.remote.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository,
    application: Application
) : AndroidViewModel(application) {
    var showBottomSheet by mutableStateOf(false)
    private val _selectedUser = MutableStateFlow<User?>(null)
    val selectedUser: StateFlow<User?> = _selectedUser

    private val _usersState = MutableStateFlow<ResultState<List<User>>>(ResultState.Loading)
    val usersState: StateFlow<ResultState<List<User>>> = _usersState

    fun setSelectedUser(user: User) {
        _selectedUser.value = user
    }

    fun getUsers() {
        viewModelScope.launch {
            try {
                val response = userRepository.getUsers()
                _usersState.value = ResultState.Success(response)
            } catch (e: IOException) {
                _usersState.value = ResultState.Error("Error de conexión")
            } catch (e: Exception) {
                _usersState.value = ResultState.Error("Otros errores inesperados")
            }
        }
    }
}