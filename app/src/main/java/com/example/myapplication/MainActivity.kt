package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.AppContainer
import com.example.myapplication.screens.AllScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val appContainer = (application as DianDianShopApplication).appContainer

        setContent {
            MyApp(appContainer)
        }
    }
}

@Composable
fun MyApp(
    appContainer: AppContainer
) {
    MaterialTheme(
        colors = lightColors(
            background = Color.White,
            onBackground = Color.White,
            surface = Color.DarkGray,
            onSurface = Color.LightGray,
        )
    ) {

        // 全部的页面
        val allScreen: List<AllScreen> = AllScreen.values().toList()

        // 当前显示的页面
        var currentScreen by rememberSaveable {
            mutableStateOf(AllScreen.HomeScreen)
        }
        Surface {
            Scaffold(
                bottomBar = {
                    BottomNavigationBar(
                        allScreen = allScreen,
                        currentScreen = currentScreen,
                        onSelect = {
                            currentScreen = it
                        }
                    )
                }
            ) {

                Box(modifier = Modifier.padding(it)) {
                    currentScreen.Content(currentChange = { screen ->
                        currentScreen = AllScreen.valueOf(screen)
                    })
                }
            }
        }
    }
}

// 底部导航栏
@Composable
fun BottomNavigationBar(
    allScreen: List<AllScreen>,
    currentScreen: AllScreen,
    onSelect: (AllScreen) -> Unit
) {

    BottomNavigation {
        allScreen.map {
            BottomNavigationItem(selected = it == currentScreen, onClick = {
                onSelect(it)
            }, icon = { Icon(imageVector = it.icon, contentDescription = it.name) }, label = {
                Text(text = it.name)
            })
        }
    }
}


@Composable
fun Greeting(name: String) {
    Box(Modifier.padding(15.dp)) {
        Text(text = "Hello $name!")
    }
}




@Composable
fun MyScreenContent(users: List<String> = listOf("梁典典", "黄典典")) {
    Column {
        for (name in users) {
            Greeting(name = name)
            Divider(color = Color.Black)
        }
    }
}


@Preview(showBackground = true, name = "测试", showSystemUi = false)
@Composable
fun DefaultPreview() {
}