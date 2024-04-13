import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.nextu.nextu_android_advanced.R
import com.nextu.nextu_android_advanced.model.Product
import com.nextu.nextu_android_advanced.model.Rating
import com.nextu.nextu_android_advanced.ui.theme.NextU_android_advancedTheme
import com.nextu.nextu_android_advanced.ui.theme.Typography

@Composable
fun ProductCard(
    product: Product,
    navToProductDetail: (productId: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navToProductDetail(product.id.toString())
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = "Image of the product ${product.title}",
                placeholder = painterResource(id = R.drawable.ic_coffee),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("${product.price} €", fontWeight = FontWeight.Bold)
                Text(product.title, style = Typography.labelSmall.copy(fontSize = 14.sp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    NextU_android_advancedTheme {
        ProductCard(
            Product(
                category = "Coffee",
                description = "A rich blend of premium coffee beans sourced from Colombia and Ethiopia, roasted to perfection.",
                id = 123456,
                image = "https://tinyurl.com/vtymn7w5",
                price = 9.99,
                rating = Rating(count = 256, rate = 4.5),
                title = "Premium Blend Coffee"
            ),
            {}
        )
    }
}
