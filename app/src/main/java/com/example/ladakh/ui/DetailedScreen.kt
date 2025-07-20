package com.example.ladakh.ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.ArrowBackIosNew
import androidx.compose.material.icons.sharp.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ladakh.DataSources.DataSources
import com.example.ladakh.model.DetialedScreenData



@Composable
fun DetailedScreen(
    modifier: Modifier,
    detailedScreenData: DetialedScreenData
){
    Box (
        modifier = Modifier
            .fillMaxSize()
    ){

    ScreenImage(
        image = detailedScreenData.ImageId,
        modifier = Modifier
            .fillMaxHeight(0.75f)
    )

        BackButton(
            modifier = Modifier
                .padding(24.dp)

        )
        Descriptions(
            title = detailedScreenData.name,
            location = detailedScreenData.location,
            description = detailedScreenData.detials,
            modifier = Modifier
        )

    }
}

@Composable
fun ScreenImage(
    image: Int,
    modifier: Modifier
){
    Image(
        painter =  painterResource( image),
        contentDescription = "DetailedScreen Image",
        contentScale = ContentScale.FillHeight,
        modifier = modifier
    )

}

@Composable
fun BackButton(
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = {},
        modifier = modifier
            .size(40.dp)
            .background(Color.White, CircleShape)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
        Icon(
                    imageVector = Icons.Sharp.ArrowBackIosNew,
                    contentDescription = "Arrow right",
                     modifier = Modifier
                         .size(22.dp)
                )
    }
    }
}

@Composable
fun Descriptions(
    title:String,
    location: String,
    description: String,
    modifier: Modifier
) {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val startHeight = screenHeight * 0.5f

    Box(modifier = Modifier.fillMaxSize()) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = startHeight)
                .fillMaxHeight(),
            color = Color.White,
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
            tonalElevation = 4.dp
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                item {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(
                        modifier.size(16.dp)
                    )
                    Row {
                        Icon(
                            imageVector = Icons.Sharp.LocationOn,
                            contentDescription = ""
                        )
                        Text(
                            text = location,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                   Spacer(
                        modifier.size(8.dp)
                    )

                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun DetailedScreenPreview() {
    DetailedScreen(
        modifier = Modifier,
        detailedScreenData = DataSources.DetialedScreenItems[1]!!.first()
    )
}