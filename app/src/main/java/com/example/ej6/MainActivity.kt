package com.example.ej6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ej6.ui.theme.EJ6Theme


data class Pelicula(@DrawableRes val imagen: Int = 0,
                        val titulo: String,
                        val director: String,
                        val anio: Int,
                        val duracion: Int,)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EJ6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Ej6()
                }
            }
        }
    }
}

@Composable
fun Tarjeta(pelicula:Pelicula){
    Card(//colors = CardDefaults.cardColors(containerColor = Color(R.color.purple_200)),
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(modifier = Modifier.padding(20.dp)) {
            Image(painter = painterResource(pelicula.imagen), contentDescription = "Imagen",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .padding(8.dp)
                    .size(125.dp))

            Column(modifier = Modifier.weight(1f),
                Arrangement.Center) {
                Text(
                    text = pelicula.titulo,
                    color = Color.Black,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "Director: "+pelicula.director,
                    color = Color.Black,
                    fontSize = 15.sp
                )
                Text(
                    text = "Año: "+pelicula.anio.toString(),
                    color = Color.Black,
                    fontSize = 15.sp
                )

                Text(
                    text = "Duracion: "+pelicula.duracion.toString(),
                    color = Color.Black,
                    fontSize = 15.sp
                )
            }

        }
    }
}

object Peliculas {

    val ListaPeliculas = listOf(
        Pelicula(
            imagen = R.drawable.transformers_dark_of_the_moon,
            titulo = "Transformers: El lado oscuro de la Luna",
            director = "Michael Bay",
            anio = 2011,
            duracion = 157
        ),
        Pelicula(
            imagen = R.drawable.john_wick_chapter_two,
            titulo = "John Wick: Pacto de sangre",
            director = "Chad Stahelski",
            anio = 2017,
            duracion = 122
        ),
        Pelicula(
            imagen = R.drawable.the_hunger_games,
            titulo = "Los juegos del hambre",
            director = "Gary Ross",
            anio = 2012,
            duracion = 143
        ),
        Pelicula(
            imagen = R.drawable.divergent,
            titulo = "Divergente",
            director = "Neil Burger",
            anio = 2014,
            duracion = 140
        ),
        Pelicula(
            imagen = R.drawable.pacific_rim,
            titulo = "Pacific Rim",
            director = "Guillermo del Toro",
            anio = 2013,
            duracion = 131
        ),
        Pelicula(
            imagen = R.drawable.dune,
            titulo = "Dune",
            director = "Denis Villeneuve",
            anio = 2021,
            duracion = 155
        ),
        Pelicula(
            imagen = R.drawable.the_dark_knight,
            titulo = "El caballero oscuro",
            director = "Christopher Nolan",
            anio = 2008,
            duracion = 152
        ),
        Pelicula(
            imagen = R.drawable.avengers_age_of_ultron_the_avengers_2,
            titulo = "Vengadores: La era de Ultrón",
            director = "Joss Whedon",
            anio = 2015,
            duracion = 141
        ),
        Pelicula(
            imagen = R.drawable.avatar,
            titulo = "Avatar",
            director = "James Cameron",
            anio = 2009,
            duracion = 161
        ),
        Pelicula(
            imagen = R.drawable.i_am_legend,
            titulo = "Soy leyenda",
            director = "Francis Lawrence",
            anio = 2007,
            duracion = 100
        ),
    )
}

@Preview
@Composable
fun Ej6(){
    val peliculas = remember { Peliculas.ListaPeliculas }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            peliculas
        ) {
            Tarjeta(pelicula = it)
        }
    }
}
