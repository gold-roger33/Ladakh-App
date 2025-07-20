    package com.example.ladakh.ui.theme

    import LadakhViewModel
    import android.annotation.SuppressLint
    import androidx.compose.animation.AnimatedVisibility
    import androidx.compose.foundation.Image
    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.fillMaxHeight
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.foundation.lazy.items
    import androidx.compose.foundation.shape.CircleShape
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.material3.Card
    import androidx.compose.material3.CardDefaults
    import androidx.compose.material3.CenterAlignedTopAppBar
    import androidx.compose.material3.ExperimentalMaterial3Api
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Text
    import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.collectAsState
    import androidx.compose.runtime.getValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.focus.focusModifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.unit.dp
    import androidx.lifecycle.viewmodel.compose.viewModel
    import androidx.navigation.NavHostController
    import androidx.navigation.compose.NavHost
    import androidx.navigation.compose.composable
    import androidx.navigation.compose.currentBackStackEntryAsState
    import androidx.navigation.compose.rememberNavController
    import com.example.ladakh.DataSources.DataSources
    import com.example.ladakh.R
    import com.example.ladakh.model.HomeScreenDatas
    import com.example.ladakh.ui.DetailedScreen
    import com.example.ladakh.ui.ExtendedScreen

    const val Tag = "HomeScreen"

    enum class LadakhScreen(val route: String){
        HOME("home"),
        EXTENDED("extended/{categoryId}"),
        DETIALED("detailed/{categoryId}/{itemId}");

        fun withArgs(vararg args: Any): String {
            return when (this){
                EXTENDED -> route.replace("{categoryId}", args[0].toString())
                DETIALED -> route
                    .replace("{categoryId}", args[0].toString())
                    .replace("{itemId}",args[1].toString())
                else -> route
            }
        }
    }




    @SuppressLint("StateFlowValueCalledInComposition")
    @Composable
    fun LadakhApp(
        windowSize: WindowWidthSizeClass,
        navController: NavHostController = rememberNavController(),
        ladakhViewModel: LadakhViewModel = viewModel()
    ) {
        val isTablet = windowSize >= WindowWidthSizeClass.Medium
        val categoryId by ladakhViewModel.currentCategory.collectAsState()
        val selectedItem by ladakhViewModel.selectedItem.collectAsState()



        Scaffold(
            topBar = { 
                TopAppBar()
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            if (isTablet) {
                // Tablet layout - canonical pattern
                if (categoryId == null) {
                    // Show home screen when no category selected
                    HomeScreenUi(
                        modifier = Modifier.padding(innerPadding),
                        homescreenitems = DataSources.HomeScreenItems,
                        onCardClicked = { clickedCategoryId ->
                            ladakhViewModel.setCategory(clickedCategoryId)
                        }
                    )
                } else {
                    // Show split view when category is selected
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        // ExtendedScreen - 40%
                        Box(modifier = Modifier.weight(4f)) {
                            ExtendedScreen(
                                modifier = Modifier,
                                extendedScreenDatas = DataSources.extendedScreenItem[categoryId] ?: emptyList(),
                                onCardCliked = { itemId ->
                                    ladakhViewModel.selectItem(categoryId!!, itemId)
                                }
                            )
                        }

                        // DetailedScreen - 60%
                        Box(modifier = Modifier.weight(6f)) {
                            selectedItem?.let { (catId, itemId) ->
                                ladakhViewModel.getDetailedItem(catId, itemId)?.let { detailData ->
                                    DetailedScreen(
                                        modifier = Modifier,
                                        detailedScreenData = detailData)
                                }
                            }
                        }
                    }
                }
            } else {
                // Phone layout - navigation pattern
                PhoneNavHost(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController,
                    ladakhViewModel = ladakhViewModel
                )
            }
        }
    }

    @Composable
    fun PhoneNavHost(
        modifier: Modifier,
        navController: NavHostController,
        ladakhViewModel: LadakhViewModel
    ) {
        NavHost(
            navController = navController,
            startDestination = LadakhScreen.HOME.route,
            modifier = modifier
        ) {
            composable(route = LadakhScreen.HOME.route) {
                HomeScreenUi(
                    homescreenitems = DataSources.HomeScreenItems,
                    onCardClicked = { categoryId ->
                        ladakhViewModel.setCategory(categoryId)
                        navController.navigate(LadakhScreen.EXTENDED.withArgs(categoryId))
                    }
                )
            }
            composable(route = LadakhScreen.EXTENDED.route) { backStackEntry ->
                val id = backStackEntry.arguments?.getString("categoryId")?.toIntOrNull() ?: return@composable
                val items = DataSources.extendedScreenItem[id] ?: emptyList()

                ExtendedScreen(
                    modifier = modifier,
                    extendedScreenDatas = items,
                    onCardCliked = { itemId ->
                        navController.navigate(LadakhScreen.DETIALED.withArgs(id, itemId))
                    }
                )
            }
            composable(route = LadakhScreen.DETIALED.route) { backStackEntry ->
                val categoryId = backStackEntry.arguments?.getString("categoryId")?.toIntOrNull() ?: return@composable
                val itemId = backStackEntry.arguments?.getString("itemId")?.toIntOrNull() ?: return@composable

                val detailData = ladakhViewModel.getDetailedItem(categoryId, itemId)
                detailData?.let {
                    DetailedScreen(
                        modifier = modifier,
                        detailedScreenData = it)
                }
            }
        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopAppBar(){
        CenterAlignedTopAppBar(
            title = {
                Column {
                    Text(
                        "Good Morning",
                        color = Color.Black
                    )
                    Text("Ladakh !",
                        color = Color.Black
                    )
                }
            },
            actions = {
                Image(
                    painter = painterResource( R.drawable.tso_kar),
                    contentDescription = "Circular Avatar",
                    modifier = Modifier.
                    size(40.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.FillBounds
                )
            },
        )
    }

    @Composable
    fun HomeScreenUi(
        modifier: Modifier =  Modifier,
        onCardClicked: (Int) -> Unit,
        homescreenitems : List<HomeScreenDatas>
        ){
        Box(
            modifier = modifier

        ) {
            HomeScreenImage()
            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ){
                items(
                    homescreenitems, key ={HomeScreenDatas -> HomeScreenDatas.id}) { homescreen ->

                    HomeScreenCards(
                        cardDetials = homescreen,
                        modifier = Modifier,
                        onClicked = { onCardClicked(it.id)}
                    )
                }
            }
        }
    }

    @Composable
    fun HomeScreenCards(
        cardDetials:HomeScreenDatas,
        onClicked: (HomeScreenDatas)-> Unit,
        modifier: Modifier
    ){

        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            shape = RoundedCornerShape(60f),
            colors = CardDefaults.cardColors(
                containerColor = Color.White.copy(alpha = 0.5f)
            ),
            modifier = Modifier
                .padding(16.dp)
                .size(width = 400.dp, height = 130.dp)
                .clickable { onClicked(cardDetials) }

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(
                    text = cardDetials.name,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 20.dp)
                )

                Image(
                    painter = painterResource(cardDetials.ImageId),
                    contentDescription = "Card Image",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(width = 150.dp, height = 100.dp)
                        .clip(RoundedCornerShape(9f)),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }



    @Composable
    fun HomeScreenImage(
        modifier: Modifier =  Modifier
            .fillMaxSize()
    ){
        Column (modifier = Modifier.fillMaxHeight()) {
            Image(
                painter = painterResource(R.drawable.background_image1),
                contentDescription = "HomeScreen Background Image",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .fillMaxSize()
                //   .blur(1.5.dp)
            )
        }
    }
