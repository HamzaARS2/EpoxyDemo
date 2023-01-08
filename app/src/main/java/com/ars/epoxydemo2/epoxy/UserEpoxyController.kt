package com.ars.epoxydemo2.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.ars.epoxydemo2.R
import com.ars.epoxydemo2.User
import com.ars.epoxydemo2.databinding.HeaderItemBinding
import com.ars.epoxydemo2.databinding.RatingItemBinding
import com.ars.epoxydemo2.databinding.UserItemBinding
import com.ars.epoxydemo2.epoxy.helper.ViewBindingKotlinModel

class UserEpoxyController(): TypedEpoxyController<List<User>>() {
    override fun buildModels(data: List<User>?) {
       if (data == null || data.isEmpty()) {
           return
       }

        HeaderModel(R.drawable.image)
            .id("header_1")
            .addTo(this)

        RatingModel()
            .id("rating_1")
            .addTo(this)

        data.forEach {user ->
            UserModel(user)
                .id(user.id)
                .addTo(this)
        }
    }
}



data class UserModel(
    val user: User
): ViewBindingKotlinModel<UserItemBinding>(R.layout.user_item) {
    override fun UserItemBinding.bind() {
        userNameTv.text = user.name
        userImage.setImageResource(user.image)
    }
}
data class HeaderModel(val imageRes: Int) : ViewBindingKotlinModel<HeaderItemBinding>(R.layout.header_item) {
    override fun HeaderItemBinding.bind() {
        imageView.setImageResource(imageRes)
    }

}
 class RatingModel: ViewBindingKotlinModel<RatingItemBinding>(R.layout.rating_item) {
    override fun RatingItemBinding.bind() {

    }

}