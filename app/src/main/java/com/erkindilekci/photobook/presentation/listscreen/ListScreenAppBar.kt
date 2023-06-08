package com.erkindilekci.photobook.presentation.listscreen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erkindilekci.photobook.presentation.ui.theme.topAppBarBackgroundColor
import com.erkindilekci.photobook.presentation.ui.theme.topAppBarContentColor

@Composable
fun ListScreenAppBar(
    onSearchClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colorScheme.topAppBarBackgroundColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(Modifier.fillMaxSize()) {
            Text(
                text = "Images",
                color = MaterialTheme.colorScheme.topAppBarContentColor,
                modifier = Modifier.align(Alignment.Center),
                fontWeight = FontWeight.SemiBold,
                fontSize = 23.sp
            )

            IconButton(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .align(Alignment.CenterEnd),
                onClick = onSearchClicked
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = MaterialTheme.colorScheme.topAppBarContentColor
                )
            }
        }
    }
}

@Preview
@Composable
fun ListScreenAppBarPrev() {
    ListScreenAppBar(onSearchClicked = {})
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ListScreenAppBarDarkPrev() {
    ListScreenAppBar(onSearchClicked = {})
}
