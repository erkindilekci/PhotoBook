package com.erkindilekci.photobook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.erkindilekci.photobook.presentation.ui.theme.PhotoBookTheme
import com.erkindilekci.photobook.util.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoBookTheme {
                Navigation()
            }
        }
    }
}
