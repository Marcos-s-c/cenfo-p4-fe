package ScholarshipCard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.proyecto4.grantly.R


@Composable
fun ScholarshipCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            // **Header con Logo y Datos de la Universidad**
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Logo de la Universidad
                Image(
                    painter = painterResource(id = R.drawable.product_image), // Agrega tu logo en drawable
                    contentDescription = "Logo Universidad",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Nombre y tiempo de publicación
                Column {
                    Text(
                        text = "Universidad Cenfotec",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Somos lo que sabemos | Hace 7 horas",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                }
            }

            Column {
                Image(
                    painter = painterResource(id = R.drawable.product_image),
                    contentDescription = "Imagen de beca",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Beca de excelencia 100%",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Requisitos: Notas secundarias con promedio de 90+")
                    Text(text = "Área de estudio: Ing. Software.")
                    Text(text = "Nivel académico: Bachillerato.")
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Button(
                            onClick = { /* Acción de Aplicar */ },
                            colors = ButtonDefaults.buttonColors(Color(0xFF673AB7)) // Morado
                        ) {
                            Text(text = "Aplicar", color = Color.White)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        TextButton(onClick = { /* Acción de Ver Detalles */ }) {
                            Text(text = "Ver detalles...")
                        }
                    }
                }
            }
        }
    }
}

