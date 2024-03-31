package com.nextu.nextu_android_advanced.ui.extension

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner


@Composable
fun OnStartEffect(lifecycleOwner: LifecycleOwner, action: () -> Unit) {
    /**
     * On va utiliser un disposable effect pour pouvoir controler un abonnement au lifecycle
     * lifecycleOwner.lifecycle.addObserver(observer) nous permet de souscrire au évènements avec l'observer
     * mais il faut détruire ce lien lorsque la vue est relachée, ce qui est fait avec le lifecycleOwner.lifecycle.removeObserver(observer) dans le   onDispose {}
     * On risquerait sinon un memory leak
     */
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { source, event ->
            if (event == Lifecycle.Event.ON_START) {
                action.invoke()
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
}