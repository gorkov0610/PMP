package pmp.zadaca1

import android.content.Context
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import pmp.zadaca1.ui.theme.Zadaca1Theme
import java.io.File

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
    val context = LocalContext.current
    val translations = remember {loadTranslations(context)}

    LazyColumn(
        modifier = modifier
    ) {
        val filteredList = translations.toList().filter { (key, value) ->
            key.contains(searchQuery, ignoreCase = true) || value.contains(searchQuery, ignoreCase = true)
        }
        item {
            Box(
                modifier = Modifier.statusBarsPadding()
            ) {
                Text(
                    text = "Thesaurus",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
        item {
            TextField(
                value = searchQuery,
                placeholder = { Text("Search a word") },
                onValueChange = {
                    searchQuery = it
                },
                shape = RoundedCornerShape(50),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                modifier = Modifier.fillMaxSize()
            )
        }
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = tagQuery,
                    placeholder = { Text("Enter a new word") },
                    onValueChange = { tagQuery = it },
                    shape = RoundedCornerShape(50),
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .weight(4f)
                        .height(56.dp)
                )
                Button(
                    {
                        val pair = tagQuery.split(' ')
                        val key = pair[0]
                        val value = pair[1]
                        translations[key] = value
                        saveContent(context, translations)
                        tagQuery = ""
                    },
                    modifier = Modifier
                        .weight(2f)
                        .height(56.dp)
                ) {
                    Text("Save")
                }
            }
        }
        items(filteredList){ record ->
            Row(
                modifier = Modifier.background(MaterialTheme.colorScheme.tertiaryContainer),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.inversePrimary
                    ),
                    modifier = Modifier.weight(2f),
                    shape = RoundedCornerShape(35)

                ) {
                    val word = record.first + " - " + record.second
                    Text(
                        text = word,
                        maxLines = 1,
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.surfaceTint
                    )
                ) {
                    Text("Edit", maxLines = 1)
                }
            }
        }


    }
}

fun loadTranslations(context: Context) : SnapshotStateMap<String, String>{
    val map = mutableStateMapOf<String, String>()
    val fileName = "nov_recnik.txt"
    val novRecnik = File(context.filesDir, fileName)
    val inputStream = if(novRecnik.exists()){
        context.openFileInput(fileName)
    }else{
        context.resources.openRawResource(R.raw.recnik)
    }

    inputStream.bufferedReader().use { reader ->
        reader.forEachLine { line ->
            val pair = line.split(' ')
            map[pair[0]] = pair[1]
        }
    }
    return map
}
fun saveContent(context: Context, map: MutableMap<String, String>){
    val content = map.entries.joinToString("\n") { "${it.key} ${it.value}" }
    context.openFileOutput("nov_recnik.txt", Context.MODE_PRIVATE).use {
        it.write(content.toByteArray())
    }
}