package com.redevrx.jacketshop.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage

@Preview(showBackground = true)
@Composable
fun JacketScreen(){
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { JacketAppBar() },
        bottomBar = {BottomNavigationBar()},
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = {},
                contentColor = Color.White
            ) {
                Icon(imageVector = Icons.Filled.Call, contentDescription = "Add icon")
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
            /**
             * content
             */
            SearchBox()
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(content = {
                itemsIndexed(productCate){ i,it ->
                    ProductClip(i == 0,it)
                }
            })
            /**
             * new Arrivals
             */
            Spacer(modifier = Modifier.height(16.dp))
            ArrivalTitle()
            Spacer(modifier = Modifier.height(8.dp))
            LazyVerticalGrid(columns = GridCells.Fixed(count = 2), content = {
                items(10){
                    ArrivalCard()
                }
            })
        }
    }
}

@Composable
fun BottomNavigationBar() {
    BottomAppBar(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
        containerColor = Color.Red
    ) {

    }
}

@Composable
fun JacketAppBar(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Default.Menu,
        contentDescription = null)
        Text("ISSACS",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
        Box(
            modifier = Modifier
                .height(50.dp)
        ) {
            Icon(Icons.Rounded.ShoppingCart,contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center))
            Card(
                modifier = Modifier
                    .size(16.dp)
                    .align(Alignment.TopEnd)
                    .padding(end = 1.dp),
                shape = CircleShape,
                colors = CardDefaults.cardColors(containerColor = Color.Red.copy(.56f))
            ) {
                Text("3",
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelSmall.copy(color = Color.White)
                )
            }
        }
    }
}

@Composable
fun SearchBox(){
    val txtSearch = remember { mutableStateOf("Search Product") }

    Card(
        modifier = Modifier
            .height(45.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .shadow(
                elevation = 22.dp,
                shape = RoundedCornerShape(16.dp),
                ambientColor = Color.Blue,
                spotColor = Color.White
            ),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
     Row(
         modifier = Modifier
             .fillMaxSize(),
         verticalAlignment = Alignment.CenterVertically
     ) {
         Icon(Icons.Default.Search, contentDescription = null,
             modifier = Modifier
                 .padding(start = 8.dp))
         BasicTextField(value = txtSearch.value, onValueChange = {txtSearch.value = it},
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(start = 2.dp, end = 8.dp),
         )
     }
    }
}

val productCate = listOf(
    mapOf("https://www.pngall.com/wp-content/uploads/4/Leather-Jacket-PNG-Pic.png" to "" +
        "Jacket"),
    mapOf("https://www.pngall.com/wp-content/uploads/4/Leather-Jacket-PNG-Pic.png" to "" +
            "Jacket"),
    mapOf("https://www.pngall.com/wp-content/uploads/4/Leather-Jacket-PNG-Pic.png" to "" +
            "Jacket"),
    mapOf("https://www.pngall.com/wp-content/uploads/4/Leather-Jacket-PNG-Pic.png" to "" +
            "Jacket"),
    mapOf("https://www.pngall.com/wp-content/uploads/4/Leather-Jacket-PNG-Pic.png" to "" +
            "Jacket"),
    mapOf("https://www.pngall.com/wp-content/uploads/4/Leather-Jacket-PNG-Pic.png" to "" +
            "Jacket"))
@Composable
fun ProductClip(isSelect: Boolean,data:Map<String,String>){
    Column(
        modifier = Modifier.padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = if (isSelect) 12.dp else 0.dp),
            modifier = Modifier
                .size(50.dp)
                .padding()
                .padding(4.dp),
            shape = CircleShape,
            colors = CardDefaults
                .cardColors(containerColor = if (isSelect) Color.White else Color.Transparent),
            border = if (isSelect) null else BorderStroke(width = 1.dp, color = Color.Gray.copy(.43f))
        ) {
            SubcomposeAsyncImage(
                model = data.keys.first(),
                loading = {
                    CircularProgressIndicator()
                },
                modifier = Modifier
                    .padding(4.dp)
                    .aspectRatio((4 / 3).toFloat()),
                contentDescription = null
            )
        }
        data[data.keys.first()]?.let {
            Text(text = it, style = MaterialTheme.typography.labelMedium.copy(color = Color.Gray))
        }
    }
}

@Composable
fun ArrivalTitle() {
   Row(
       modifier = Modifier
           .padding(horizontal = 16.dp)
           .fillMaxWidth(),
       horizontalArrangement = Arrangement.SpaceBetween,
       Alignment.CenterVertically
   ) {
       Text(text = "New Arrivals",
       style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold))
       Icon(Icons.Rounded.ArrowForward, contentDescription = null)
   }
}

@Composable
fun ArrivalCard() {
  Column(
      Modifier.padding(8.dp)
  ) {
     Box {
         Card(
             modifier = Modifier
                 .height(140.dp)
                 .width(140.dp)
                 .shadow(
                     elevation = 22.dp,
                     shape = RoundedCornerShape(16.dp),
                     ambientColor = Color.Blue,
                     spotColor = Color.White
                 ),
             colors = CardDefaults
                 .cardColors(containerColor = Color.Gray.copy(.5f)),
         ) {
             SubcomposeAsyncImage(
                 model = "https://www.eventfabrics.com/assets/images/gear/ReykjavikJacket-Zajoweb.png",
                 loading = {
                     CircularProgressIndicator()
                 },
                 contentDescription = null,
                 contentScale = ContentScale.Fit,
                 modifier = Modifier
                     .height(140.dp)
             )
         }

         Card(
             modifier = Modifier
                 .align(Alignment.TopEnd)
                 .padding(top = 8.dp, end = 8.dp)
                 .size(30.dp)
                 .shadow(
                     elevation = 22.dp,
                     shape = CircleShape,
                     ambientColor = Color.Blue,
                     spotColor = Color.White
                 ),
             shape = CircleShape,
             colors = CardDefaults
                 .cardColors(containerColor = Color.White),
         ) {
            Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
                Icon(Icons.Default.Favorite,
                    contentDescription = null,
                    tint = Color.Red.copy(.45f),
                    modifier = Modifier.padding(4.dp)
                )
            }
         }
     }
      Spacer(modifier = Modifier.height(4.dp))
      Text(text = "PITTI Block-Jacket",
      style = MaterialTheme.typography.titleMedium
      )
      Spacer(modifier = Modifier.height(2.dp))
      Text(text = "$112.89",
          style = MaterialTheme.typography.titleMedium
      )
  }
}

























