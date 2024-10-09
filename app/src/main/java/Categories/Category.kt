package Categories

import android.os.Parcelable
import com.mohamed.news_app.R
import kotlinx.parcelize.Parcelize


@Parcelize
data class Category(

    val id: String,
    val title: String,
    val imgId:Int,
    val BachgroundColor: Long

):Parcelable{
    companion object{
        fun getCategory():List<Category>{
            return listOf(
                Category(
                    id = "business",
                    title = "business",
                    imgId = R.drawable.img_bussines,
                    BachgroundColor =0xFFCF7E48
                ),
                Category(
                    id = "general",
                    title = "general",
                    imgId = R.drawable.img_politics,
                    BachgroundColor = 0xFF003E90
                ),
                        Category(
                    id = "entertainment",
                    title = "entertainment",
                    imgId = R.drawable.img_environment,
                    BachgroundColor =0xFF4882CF
                ),
                Category(
                    id = "health",
                    title = "health",
                    imgId = R.drawable.img_health,
                    BachgroundColor = 0xFFED1E79
                ),
                Category(
                    id = "science",
                    title = "science",
                    imgId = R.drawable.img_science,
                    BachgroundColor =0xFFF2D352
                ),

                Category(
                    id = "sports",
                    title = "sports",
                    imgId = R.drawable.img_sports,
                    BachgroundColor = 0xFFC91C22
                )
            )
        }
    }
}
//    companion object{
//        fun getProducts():List<Categories>
//        {
//            return listOf(
//                Categories(
//
//
//                ),
//                Categories(
//
//                ),
//                Categories(
//
//                ),
//                Categories(
//
//                ),
//                Categories(
//
//                )
//
//            )
//        }
//    }


