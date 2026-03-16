package io.orazzu.android_course.presentation.preview_data

import io.orazzu.android_course.domain.AppCategory
import io.orazzu.android_course.domain.app.App

fun getApps(): List<App> = listOf(
    App(
        id = "2q34rf",
        name = "Сбербанк Онлайн — с Салютом",
        category = AppCategory.FINANCE,
        ageRating = 14,
        iconUrl = "https://cdn-app.sberdevices.ru/asset/sites_240:q80/aHR0cHM6Ly9jZG4uc2JlcmRldmljZXMucnUvc3RhdGljL3NlcnZpY2VzL3RhcmdldC81ZDliOWFlNy0zMDVmLTRkNzgtOWY0NS01ZTZiOTU5N2JlOTAvZTNhZjU5NjQtOTNjMi00ODdhLWE4ODItNGU0NTY2MWI5ZmI5LnBuZw==",
        shortDescription = "Больше чем банк",
    ),
    App(
        id = "24rа2f",
        name = "Яндекс.Браузер — с Алисой",
        category = AppCategory.UTILITIES,
        ageRating = 0,
        iconUrl = "https://play-lh.googleusercontent.com/CNo_xqkAu1TPcO6Y02JAVIE1-1IoF6VlEnUgIv7MPby4H52Jn54Iu_-tg69Z91n0QVxDyZCwijRV2AFZwizf_Q=s96",
        shortDescription = "Быстрый и безопасный браузер",
    ),
    App(
        id = "klj349",
        name = "Почта Mail.ru",
        category = AppCategory.UTILITIES,
        ageRating = 0,
        iconUrl = "https://play-lh.googleusercontent.com/Q6AOumT71kEeuc_E359gdspTzWGjWP3jzmNBMRbI7drhRHCtEwYD7VLw88l0QotoboC6CrgFuXg8pr4CtASG3g",
        shortDescription = "Почтовый клиент для любых ящиков",
    ),
    App(
        id = "274rgw",
        name = "Яндекс.Навигатор",
        category = AppCategory.MAPS,
        ageRating = 0,
        iconUrl = "https://play-lh.googleusercontent.com/aROhxD1HNPLqW1ZiQzCxhDmx700j2g1VGZ0DPDualQxATkCkUEOWWCxxq0BSnZ3fynEe",
        shortDescription = "Парковки и заправки — по пути",
    ),
    App(
        id = "34ie9c",
        name = "Мой МТС",
        category = AppCategory.UTILITIES,
        ageRating = 0,
        iconUrl = "https://play-lh.googleusercontent.com/oO7fsxw5F8fItT4fScnFG9JSCghkoIbOibyx8WpHN8QReoeFKHNlIfLTvDO6BD7OSw",
        shortDescription = "Мой МТС — центр экосистемы МТС",
    ),
    App(
        id = "tyft6u",
        name = "Яндекс — с Алисой",
        category = AppCategory.UTILITIES,
        ageRating = 0,
        iconUrl = "https://play-lh.googleusercontent.com/K1yQPVuQDv3x87tPgQGPsnqdoDVWssiLb7P2sjyr2_rjjJHOKgfIaqa6LgwFaqq6lp_DOy4ACCWvn_fJwWKjpQ",
        shortDescription = "Яндекс — поиск всегда под рукой",
    ),
    App(
        id = "13er23",
        name = "Some App",
        category = AppCategory.FINANCE,
        ageRating = 17,
        iconUrl = "https://yavuzceliker.github.io/sample-images/image-7.jpg",
        shortDescription = "Just some",
    ),
    App(
        id = "43fr",
        name = "One More App",
        category = AppCategory.EDUCATION,
        ageRating = 0,
        iconUrl = "https://yavuzceliker.github.io/sample-images/image-410.jpg",
        shortDescription = "Just another",
    ),
    App(
        id = "eg8u4a",
        name = "An App With a Crazy Long Name–Who in the World Ever Comes up With Such Blankets?",
        category = AppCategory.ENTERTAINMENT,
        ageRating = 17,
        iconUrl = "https://yavuzceliker.github.io/sample-images/image-910.jpg",
        shortDescription = "Our descriptions are also long as hell btw. Y’all never read them anyways tho.",
    ),
)
