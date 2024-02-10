package com.criticalay.khabar.ui.composables

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Newspaper
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.criticalay.khabar.R
import com.criticalay.khabar.data.Article
import com.criticalay.khabar.data.Source

@Composable
fun KhabarItem(modifier: Modifier = Modifier, article: Article, onItemClick:()->Unit) {
    val context = LocalContext.current
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth().clickable {
                onItemClick()
            }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(0.6f)
            ) {
                Text(
                    text = article.title,
                    fontWeight = FontWeight.Medium,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End,
            ) {
                article.urlToImage?.let {
                    Image(
                        modifier = Modifier.clip(RoundedCornerShape(16.dp)),
                        url = it
                    )
                }

                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomEnd) {
                    IconButton(onClick = {
                        val intent = Intent(Intent.ACTION_SEND)
                        intent.type = "text/plain"
                        intent.putExtra(Intent.EXTRA_TEXT, article.url)
                        val shareIntent = Intent.createChooser(intent,
                            context.getString(R.string.share_via))
                        context.startActivity(shareIntent)
                    }) {
                        Icon(
                        imageVector = Icons.Rounded.Share,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 8.dp)
                    )
                    }
                }
            }
        }
    }

    Divider(modifier = Modifier.padding(4.dp))
}

@Composable
fun Image(modifier: Modifier = Modifier, url: String?) {
    if (url==null){
        Image(imageVector = Icons.Rounded.Newspaper, contentDescription =null )
    }else{
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url).crossfade(true).build(),
            modifier = modifier,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }

}
