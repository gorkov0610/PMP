package pmp.zadaca1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import pmp.zadaca1.ui.theme.Zadaca1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Zadaca1Theme {
                Scaffold(
                    bottomBar = {
                        Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        ){
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(56.dp)
                            ) {
                                Text("Clear Tags")
                            }
                        }
                    }
                ) {
                    innerPadding -> Screen(modifier = Modifier.padding(innerPadding))
                }

            }
        }
    }
}

@Composable
fun Screen(modifier : Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf("") }
    var tagQuery by remember {mutableStateOf("")}

    LazyVerticalGrid(
        columns = GridCells.Fixed(6),
        modifier = modifier
    ) {
        item(span = {GridItemSpan(6)}){
            Box(
                modifier = Modifier.
                statusBarsPadding()
            ){
                Text(
                    text = "Favorite X Searches",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
        item(span = { GridItemSpan(6) }) {
            TextField(
                value = searchQuery,
                placeholder = {Text("Enter X search query here")},
                onValueChange = {searchQuery = it},
                shape = RoundedCornerShape(50),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                modifier = Modifier.fillMaxSize()
            )
        }
        item(span = {GridItemSpan(6)}){
            Row(
                modifier = Modifier.
                fillMaxWidth().padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                TextField(
                    value = tagQuery,
                    placeholder = { Text("Tag your query") },
                    onValueChange = { tagQuery = it },
                    shape = RoundedCornerShape(50),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier.weight(4f).height(56.dp)
                )
                Button({}, modifier = Modifier
                    .weight(2f)
                    .height(56.dp)
                ) {
                    Text("Save")
                }
            }
        }
        item(span = {GridItemSpan(6)}){
            Row(
                modifier = Modifier.
                background(MaterialTheme.colorScheme.tertiaryContainer),
                horizontalArrangement = Arrangement.Center
            ){
                Text("Tagged searches",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    )
            }
        }
        item(span = {GridItemSpan(6)}){
            Row(
                modifier = Modifier.
                background(MaterialTheme.colorScheme.tertiaryContainer),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.inversePrimary
                    ),
                    modifier = Modifier.weight(2f)
                ) {
                    Text("Android FP")
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.surfaceTint
                    )
                ) {
                    Text("Edit")
                }
            }
        }

        item(span = {GridItemSpan(6)}){
            Row(
                modifier = Modifier.
                background(MaterialTheme.colorScheme.tertiaryContainer),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.inversePrimary
                    ),
                    modifier = Modifier.weight(2f)
                ) {
                    Text("Deitel")
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.surfaceTint
                    )
                ) {
                    Text("Edit")
                }
            }
        }
        item(span = {GridItemSpan(6)}){
            Row(
                modifier = Modifier.
                background(MaterialTheme.colorScheme.tertiaryContainer),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.inversePrimary
                    ),
                    modifier = Modifier.weight(2f)
                ) {
                    Text("Google")
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.surfaceTint
                    )
                ) {
                    Text("Edit")
                }
            }
        }
        item(span = {GridItemSpan(6)}){
            Row(
                modifier = Modifier.
                background(MaterialTheme.colorScheme.tertiaryContainer),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.inversePrimary
                    ),
                    modifier = Modifier.weight(2f)
                ) {
                    Text("iPhoneFP")
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.surfaceTint
                    )
                ) {
                    Text("Edit")
                }
            }
        }
        item(span = {GridItemSpan(6)}){
            Row(
                modifier = Modifier.
                background(MaterialTheme.colorScheme.tertiaryContainer),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.inversePrimary,
                        //contentColor = Color.Black
                    ),
                    modifier = Modifier.weight(2f)
                ) {
                    Text("JavaFP")
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.surfaceTint
                    )
                ) {
                    Text("Edit")
                }
            }
        }
        item(span = {GridItemSpan(6)}){
            Row(
                modifier = Modifier.
                background(MaterialTheme.colorScheme.tertiaryContainer),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.inversePrimary
                    ),
                    modifier = Modifier.weight(2f)
                ) {
                    Text("JavaHTP")
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.surfaceTint
                    )
                ) {
                    Text("Edit")
                }
            }
        }


    }
}