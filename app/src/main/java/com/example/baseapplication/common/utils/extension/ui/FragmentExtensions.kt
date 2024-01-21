package com.example.baseapplication.common.utils.extension.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.baseapplication.feature.main.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun Fragment.setActivityWithResultListener(
    listenerKey: String,
    onListenerBundle: (String, Bundle) -> Unit,
) {
    val lifecycleEventObserver = LifecycleEventObserver { _, event ->
        if (event == Lifecycle.Event.ON_CREATE) {
            requireActivity().supportFragmentManager.setFragmentResultListener(
                listenerKey,
                requireActivity()
            ) { key: String, bundle: Bundle ->
                onListenerBundle.invoke(key, bundle)
            }
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            requireActivity().supportFragmentManager.clearFragmentResultListener(listenerKey)
        }
    }
    lifecycle.addObserver(lifecycleEventObserver)
}

fun Fragment.setActivityResult(
    listenerKey: String,
    resultBundle: Bundle,
) {
    this.requireActivity().supportFragmentManager.setFragmentResult(listenerKey, resultBundle)
}

inline fun <reified T : Fragment> FragmentManager.findFragmentByTag(): T? {
    return findFragmentByTag(T::class.java.name) as T?
}

fun Fragment.changeBottomMenuVisible(isVisible: Boolean = true) {
   (activity as? MainActivity)?.setBottomMenuVisible(isVisible)
}

inline fun Fragment.launchRepeatWithViewLifecycle(
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline block: suspend CoroutineScope.() -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.lifecycle.repeatOnLifecycle(minActiveState) {
            block()
        }
    }
}