package com.erkindilekci.photobook.presentation.util

import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.erkindilekci.photobook.R
import com.erkindilekci.photobook.model.Image
import com.erkindilekci.photobook.model.Urls
import com.erkindilekci.photobook.model.User
import com.erkindilekci.photobook.model.UserLinks
import com.erkindilekci.photobook.presentation.ui.theme.HeartRed
import com.erkindilekci.photobook.presentation.ui.theme.cardColor
import com.erkindilekci.photobook.presentation.ui.theme.cardContentColor

@Composable
fun ImageCard(image: Image) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.cardColor,
            contentColor = MaterialTheme.colorScheme.cardContentColor
        )
    ) {
        Column(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .clickable {
                    val browserIntent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://unsplash.com/@${image.user.username}")
                    )
                    startActivity(context, browserIntent, null)
                }
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(8.5f),
                model = ImageRequest.Builder(context)
                    .data(image.urls.regular)
                    .crossfade(1000)
                    .build(),
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                error = painterResource(id = R.drawable.ic_placeholder),
                placeholder = painterResource(id = R.drawable.ic_placeholder)
            )

            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
                    .weight(1.5f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.weight(77f),
                    text = buildAnnotatedString {
                        append("Photo by ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                            append(image.user.username)
                        }
                        append(" on Unsplash")
                    },
                    fontSize = 18.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                LikeCounter(
                    modifier = Modifier.weight(23f),
                    painter = painterResource(id = R.drawable.ic_heart),
                    likes = "${image.likes}"
                )
            }
        }
    }
}

@Composable
fun LikeCounter(
    modifier: Modifier = Modifier,
    painter: Painter,
    likes: String
) {
    Row(
        modifier = modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Icon(
            painter = painter,
            contentDescription = "Heart Icon",
            tint = HeartRed
        )

        Divider(modifier = Modifier.width(6.dp))

        Text(
            text = likes,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun ImagePreview() {
    ImageCard(
        image = Image(
            id = "1",
            urls = Urls(regular = ""),
            likes = 100,
            user = User(username = "Erkin", userLinks = UserLinks(html = ""))
        )
    )
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ImageDarkPreview() {
    ImageCard(
        image = Image(
            id = "1",
            urls = Urls(regular = ""),
            likes = 100,
            user = User(username = "Erkin", userLinks = UserLinks(html = ""))
        )
    )
}
