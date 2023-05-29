package com.redevrx.ui.screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage


@Composable
fun ShopScreen(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { ShopAppBar()},
        bottomBar = { BottomBar()}
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
        ) {
            /**
             * search box
             */
            SearchBox()
            /**
             * popular product title
             */
            Spacer(modifier = Modifier.height(32.dp))
            PopularProductTitle()
            /**
             * product list
             */
            Spacer(modifier = Modifier.height(16.dp))
           LazyRow(content = {
               items(produtcs){ data ->
                   ProductCard(data)
               }
           })
            Spacer(modifier = Modifier.height(32.dp))
            /**
             * category title
             */
            CategoryTitle()
            Spacer(modifier = Modifier.height(16.dp))
            /**
             * list clip product
             */
            LazyRow(content = {
                items(produtcClip){ data ->
                    ClipProduct(data = data)
                }
            })
            Spacer(modifier = Modifier.height(32.dp))
            /**
             * recent view title
             */
            RecentViewBox()
            /**
             * list product
             */
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(content = {
                items(produtcs){data ->
                    Row(
                        modifier = Modifier.padding(vertical = 8.dp)
                    ) {
                        ProductCard(data)
                        ProductCard(data)
                    }
                }
            })
        }
    }
}


@Composable
fun BottomBar(){
    Card(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 18.dp,
                shape = RoundedCornerShape(12.dp),
                spotColor = Color.White,
                ambientColor = Color.Black
            ),
    colors = CardDefaults.cardColors(containerColor = Color.White)){
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            Alignment.CenterVertically
        ) {
            Icon(Icons.Rounded.Home, contentDescription = null, tint = Color.Blue.copy(.56f))
            Icon(Icons.Rounded.Star, contentDescription = null, tint = Color.Gray)
            Icon(Icons.Rounded.Search, contentDescription = null, tint = Color.Gray)
            Icon(Icons.Rounded.Settings, contentDescription = null, tint = Color.Gray)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopAppBar(){
   TopAppBar(
       modifier = Modifier,
       title = {
           Column() {
               Text(text = "Select best products",
               style = MaterialTheme.typography.titleMedium.copy(color = Color.Gray,
               fontWeight = FontWeight.W500))
               Text(text = "For your work!",
               style = MaterialTheme.typography.titleLarge)
           }
       },
       actions = {
           Card(
               modifier = Modifier,
               shape = CircleShape
           ) {
               Icon(Icons.Rounded.Person,
                   contentDescription = null,
                   modifier = Modifier.padding(4.dp)
               )
           }
       }
   )
}


@Composable
fun SearchBox(){
    val txtSearch = remember { mutableStateOf("Search ...") }
    Card(
        modifier = Modifier
            .height(45.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 18.dp,
                shape = RoundedCornerShape(12.dp),
                spotColor = Color.White,
                ambientColor = Color.Black
            ),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(modifier = Modifier
            .fillMaxSize()) {
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth(.86f)
                    .align(Alignment.CenterStart)
                    .padding(start = 8.dp),
                value = txtSearch.value ,
                singleLine = true,
                onValueChange = {txtSearch.value = it})
            
            Card(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 8.dp),
                shape = CircleShape,
                colors = CardDefaults.cardColors(containerColor = Color.Blue.copy(alpha = .56f))
            ) {
                Icon(Icons.Rounded.Search,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}

@Composable
fun PopularProductTitle(){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Popular Products :",
        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
        Icon(Icons.Rounded.MoreVert, contentDescription = null)
    }
}

val produtcs: List<Map<String,String>> = listOf(
    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "M2 Air 2023"),
    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "M2 Pro 2023"),
    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "M2 Air 2023"),
    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "M2 Pro 2023"),
    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "M2 Air 2023"),
    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "M2 Pro 2023")
)
@Composable
fun ProductCard(data:Map<String,String>){
    Card(
        modifier = Modifier
            .height(200.dp)
            .width(160.dp)
            .shadow(
                elevation = 22.dp,
                shape = RoundedCornerShape(12.dp),
                spotColor = Color.White,
                ambientColor = Color.Black
            )
            .padding(horizontal = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
        ) {
            Text(text = "Apple",
                modifier = Modifier
                    .padding(bottom = 10.dp),
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
            )
            SubcomposeAsyncImage(
                model = data.keys.first(),
                loading = {
                    CircularProgressIndicator()
                },
                contentScale = ContentScale.Fit,
                contentDescription = null
            )
            data[data.keys.first()]?.let {
                Text(text = it,
                    modifier = Modifier
                        .padding(top = 10.dp),
                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
            Text(text = "Macbook",
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)
            )
            Text(text = "$ 18992.89",
                modifier = Modifier
                    .padding(top = 10.dp),
                style = MaterialTheme.typography.labelLarge.copy
                    (color = Color.Blue.copy(.56f),
                    fontWeight = FontWeight.Bold)
            )
        }
    }
}

@Composable
fun CategoryTitle(){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Categories :",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
        Text(text = "See all",
            style = MaterialTheme.typography.titleMedium.copy(color = Color.Gray,fontWeight = FontWeight.W500))
    }
}

val produtcClip: List<Map<String,String>> = listOf(
    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "Macbook"),
    mapOf("https://dtaconline.dtac.co.th/pub/media/catalog/product/cache/e96373d1c57081d0b326a3dfa1f55e67/p/a/packshot-iphone14-pro-max-deep-purple_2_1.png" to "iPhone"),
    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "Macbook"),
    mapOf("https://dtaconline.dtac.co.th/pub/media/catalog/product/cache/e96373d1c57081d0b326a3dfa1f55e67/p/a/packshot-iphone14-pro-max-deep-purple_2_1.png" to "iPhone"),
    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "Macbook"),
    mapOf("https://dtaconline.dtac.co.th/pub/media/catalog/product/cache/e96373d1c57081d0b326a3dfa1f55e67/p/a/packshot-iphone14-pro-max-deep-purple_2_1.png" to "iPhone"),
)
@Composable
fun ClipProduct(data: Map<String, String>){
    Card(
        modifier = Modifier
            .height(45.dp)
            .width(120.dp)
            .shadow(
                elevation = 18.dp,
                shape = RoundedCornerShape(12.dp),
                spotColor = Color.White,
                ambientColor = Color.Black
            )
            .padding(horizontal = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            horizontalArrangement = Arrangement.Start,
            Alignment.CenterVertically
        ) {
            SubcomposeAsyncImage(
                model = data.keys.first(),
                modifier = Modifier
                    .aspectRatio((4/3).toFloat()),
                loading = {
                    CircularProgressIndicator()
                },
                contentDescription = null
            )
            data[data.keys.first()]?.let { Text(text = it,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold)) }
        }
    }
}

@Composable
fun RecentViewBox(){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Recent Viewed :",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
        Icon(Icons.Rounded.MoreVert, contentDescription = null)
    }
}

//@Composable
//fun ShopScreen(){
//    Scaffold(
//        modifier = Modifier.fillMaxSize(),
//        topBar = { ShopAppBar() },
//        bottomBar = { BottomNavigationBar()},
//        containerColor = Color.White) { contentPadding ->
//        Column(modifier = Modifier
//            .fillMaxSize()
//            .padding(contentPadding),
//            horizontalAlignment = Alignment.CenterHorizontally) {
//            /**
//             * content
//             */
//            SearchBox()
//            /**
//             * filter box
//             */
//            Spacer(modifier = Modifier.height(32.dp))
//            FilterBox()
//            /**
//             * card product
//             */
//            Spacer(modifier = Modifier.height(32.dp))
//            LazyRow(modifier = Modifier){
//               items(produtcs){
//                   ProductCard(it)
//               }
//           }
//            Spacer(modifier = Modifier.height(32.dp))
//            /**
//             * category and see more
//             */
//            CategoryAndSeeMoreBox()
//            /**
//             * list clip card
//             */
//            Spacer(modifier = Modifier.height(16.dp))
//            LazyRow(content = {
//                items(produtcClip){
//                    ProductClipCard(it)
//                }
//            })
//            Spacer(modifier = Modifier.height(32.dp))
//            /**
//             *
//             */
//            LazyColumn(content = {
//                items(produtcs){
//                    Row(modifier = Modifier.padding(vertical = 6.dp)) {
//                        ProductCard(it)
//                        Spacer(modifier = Modifier.width(6.dp))
//                        ProductCard(it)
//                    }
//                }
//            })
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ShopAppBar(){
//    TopAppBar(
//        modifier = Modifier,
//        title = { Text(
//            modifier = Modifier,
//            text = "For your work!",
//            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold))},
//        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
//        actions = {
//           Card(
//               modifier= Modifier
//                   .shadow(
//                       elevation = 6.dp,
//                       shape = RoundedCornerShape(20.dp),
//                       spotColor = Color.Gray.copy(alpha = .23f)
//                   ),
//               shape = CircleShape,
//               colors = CardDefaults.cardColors(containerColor = Color.White)) {
//               Icon(Icons.Rounded.Person,
//                   contentDescription = "User Icon",
//                   modifier = Modifier.padding(4.dp))
//           }
//    })
//}
//
//@Composable
//fun BottomNavigationBar(){
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(50.dp)
//            .shadow(
//                elevation = 18.dp,
//                spotColor = Color.Gray.copy(.23f),
//                ambientColor = Color.Black,
//                shape = RoundedCornerShape(12.dp)
//            ),
//        colors = CardDefaults.cardColors(containerColor = Color.White)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = 16.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Icon(Icons.Rounded.Home, contentDescription =null, tint = Color.Blue.copy(.56f))
//            Icon(Icons.Rounded.Star , contentDescription =null, tint = Color.Gray)
//            Icon(Icons.Rounded.Star, contentDescription =null, tint = Color.Gray)
//            Icon(Icons.Rounded.Settings, contentDescription =null, tint = Color.Gray)
//        }
//    }
//}
//
//@Composable
//fun SearchBox(){
//    val txtSearch = remember { mutableStateOf("Search") }
//
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 16.dp)
//            .height(45.dp)
//            .shadow(
//                elevation = 18.dp,
//                spotColor = Color.Gray.copy(.23f),
//                ambientColor = Color.Black,
//                shape = RoundedCornerShape(12.dp)
//            ),
//        colors = CardDefaults.cardColors(containerColor = Color.White)) {
//        Box(modifier = Modifier.fillMaxSize()) {
//            BasicTextField(
//                modifier = Modifier
//                    .align(Alignment.CenterStart)
//                    .fillMaxWidth()
//                    .padding(start = 8.dp, end = 24.dp),
//                value = txtSearch.value,
//                singleLine = true,
//                onValueChange = {txtSearch.value = it})
//
//            Card(
//                modifier =
//                Modifier
//                    .padding(end = 8.dp)
//                    .align(alignment = Alignment.CenterEnd),
//            shape = CircleShape,
//            colors = CardDefaults.cardColors(containerColor = Color.Blue.copy(alpha = .56f))) {
//                Icon(Icons.Rounded.Search,
//                    contentDescription = "",
//                    tint = Color.White,
//                    modifier = Modifier.padding(all = 4.dp))
//            }
//        }
//    }
//}
//
//@Composable
//fun FilterBox(){
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 16.dp),
//        horizontalArrangement = Arrangement.SpaceBetween) {
//        Text(text = "Popular Products:", style = MaterialTheme.typography.titleMedium)
//        Icon(Icons.Default.MoreVert, contentDescription = "")
//    }
//}
//
//val produtcs: List<Map<String,String>> = listOf(
//    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "M2 Air 2023"),
//    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "M2 Pro 2023"),
//    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "M2 Air 2023"),
//    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "M2 Pro 2023"),
//    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "M2 Air 2023"),
//    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "M2 Pro 2023")
//)
//@Composable
//fun ProductCard(data:Map<String,String>){
//    Card(
//        modifier = Modifier
//            .height(186.dp)
//            .width(164.dp)
//            .padding(horizontal = 10.dp)
//            .shadow(
//                elevation = 18.dp,
//                spotColor = Color.Gray.copy(.23f),
//                ambientColor = Color.Black,
//                shape = RoundedCornerShape(12.dp)
//            ),
//        colors = CardDefaults.cardColors(containerColor = Color.White),
//        shape = RoundedCornerShape(16.dp),
//
//    ) {
//        Column(modifier = Modifier
//            .padding(8.dp)) {
//            Text(
//                modifier = Modifier
//                    .padding(bottom = 8.dp),
//                text = "Apple",
//                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.ExtraBold)
//            )
//            SubcomposeAsyncImage(
//                model = data.keys.first(),
//                loading = {
//                    CircularProgressIndicator()
//                },
//                contentScale = ContentScale.Fit,
//                contentDescription = null
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            data[data.keys.first()]?.let {
//                Text(text = it,
//                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.ExtraBold))
//            }
//            Text(text = "Macbook",
//                style = MaterialTheme.typography.labelMedium.copy(
//                    fontWeight = FontWeight.W600,
//                    color = Color.Gray.copy(alpha = .34f)))
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(text = "$ 2000.98",
//                style = MaterialTheme.typography.labelLarge.copy(
//                    fontWeight = FontWeight.ExtraBold,
//                    color = Color.Blue.copy(.56f)))
//        }
//    }
//}
//
//@Composable
//fun CategoryAndSeeMoreBox(){
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 16.dp),
//        horizontalArrangement = Arrangement.SpaceBetween) {
//        Text(text = "Categories:", style = MaterialTheme.typography.titleMedium)
//        Text(text = "See all", style = MaterialTheme.typography.titleSmall.copy(color = Color.Gray, fontWeight = FontWeight.W500))
//    }
//}
//
//
//val produtcClip: List<Map<String,String>> = listOf(
//    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "Macbook"),
//    mapOf("https://dtaconline.dtac.co.th/pub/media/catalog/product/cache/e96373d1c57081d0b326a3dfa1f55e67/p/a/packshot-iphone14-pro-max-deep-purple_2_1.png" to "iPhone"),
//    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "Macbook"),
//    mapOf("https://dtaconline.dtac.co.th/pub/media/catalog/product/cache/e96373d1c57081d0b326a3dfa1f55e67/p/a/packshot-iphone14-pro-max-deep-purple_2_1.png" to "iPhone"),
//    mapOf("https://149426355.v2.pressablecdn.com/wp-content/uploads/2022/06/m2air-hero-6c.png" to "Macbook"),
//    mapOf("https://dtaconline.dtac.co.th/pub/media/catalog/product/cache/e96373d1c57081d0b326a3dfa1f55e67/p/a/packshot-iphone14-pro-max-deep-purple_2_1.png" to "iPhone"),
//)
//@Composable
//fun ProductClipCard(data: Map<String, String>){
//    Card(
//        modifier = Modifier
//            .height(45.dp)
//            .width(120.dp)
//            .padding(horizontal = 4.dp)
//            .shadow(
//                elevation = 18.dp,
//                spotColor = Color.Gray.copy(.23f),
//                ambientColor = Color.Black,
//                shape = RoundedCornerShape(12.dp)
//            ),
//        colors = CardDefaults.cardColors(containerColor = Color.White),
//        shape = RoundedCornerShape(16.dp)) {
//        Row(
//            modifier = Modifier.padding(2.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            Alignment.CenterVertically) {
//            SubcomposeAsyncImage(
//                model = data.keys.first(),
//                loading = {
//                    CircularProgressIndicator()
//                },
//                contentScale = ContentScale.Fit,
//                contentDescription = null,
//                modifier = Modifier.aspectRatio((3/2).toFloat())
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            data[data.keys.first()]?.let {
//                Text(text = it,
//                    style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.ExtraBold))
//            }
//        }
//    }
//}