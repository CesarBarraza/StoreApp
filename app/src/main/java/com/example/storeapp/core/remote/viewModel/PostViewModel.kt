package com.example.storeapp.core.remote.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeapp.core.entities.Post
import com.example.storeapp.core.remote.ResultState
import com.example.storeapp.core.remote.repositories.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postRepository: PostRepository,
    application: Application
) : AndroidViewModel(application) {

    private val _postsState = MutableStateFlow<ResultState<List<Post>>>(ResultState.Loading)
    val postsState: StateFlow<ResultState<List<Post>>> = _postsState

    private val _postState = MutableStateFlow<ResultState<Post>>(ResultState.Loading)
    val postState: StateFlow<ResultState<Post>> = _postState.asStateFlow()

    fun getListPost() {
        viewModelScope.launch {
            _postsState.value = ResultState.Loading
            try {
                val post = postRepository.getPosts()
                _postsState.value = ResultState.Success(post)
            } catch (e: Exception) {
                _postsState.value = ResultState.Error("Error")
            }
        }
    }

    fun getPostById(id: Int) {
        viewModelScope.launch {
            _postState.value = ResultState.Loading
            try {
                val post = postRepository.getPostById(id)
                _postState.value = ResultState.Success(post)
            } catch (e: Exception) {
                _postState.value = ResultState.Error("Error al cargar el post")
            }
        }
    }
}