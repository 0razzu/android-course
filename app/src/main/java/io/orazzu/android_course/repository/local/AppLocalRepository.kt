package io.orazzu.android_course.repository.local

import io.orazzu.android_course.model.app.AppCategory
import io.orazzu.android_course.model.app.AppDetails
import io.orazzu.android_course.repository.AppRepository

class AppLocalRepository : AppRepository {
    override fun getApps(): List<AppDetails> = listOf(
        AppDetails(
            id = "2q34rf",
            name = "Сбербанк Онлайн — с Салютом",
            developer = "Сбер",
            category = AppCategory.FINANCE,
            ageRating = 14,
            iconUrl = "https://cdn-app.sberdevices.ru/asset/sites_240:q80/aHR0cHM6Ly9jZG4uc2JlcmRldmljZXMucnUvc3RhdGljL3NlcnZpY2VzL3RhcmdldC81ZDliOWFlNy0zMDVmLTRkNzgtOWY0NS01ZTZiOTU5N2JlOTAvZTNhZjU5NjQtOTNjMi00ODdhLWE4ODItNGU0NTY2MWI5ZmI5LnBuZw==",
            screenshotUrlList = listOf(
                "https://static.rustore.ru/imgproxy/YAyMfd1C5Y4ADB-81F4yT0rqc7hoSOkMOyTXTyXkG60/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/2/19/e2/apk/462271/content/SCREENSHOT/af9920e4-eb9a-45d7-9224-ada17e9fad94.png@webp",
                "https://static.rustore.ru/imgproxy/ueOMCvH3fqGWDCmSF009YQq_6JMq7UMhSWbAcOEwZBA/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/2/19/e8/apk/462271/content/SCREENSHOT/fd8a50aa-7485-4d53-abb4-753098690a0a.png@webp",
                "https://static.rustore.ru/imgproxy/PQYAfC-o3rQRJIZ-yLHT-e326EgH0k7eKAP9KcMV6vI/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/2/19/f9/apk/462271/content/SCREENSHOT/29ad8437-5651-40fa-9f06-a4ec77b7da71.png@webp",
                "https://static.rustore.ru/imgproxy/0Ah_0lEHsExVLrIoZ4aNxke42571sz8zUX7cMRB9auE/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/2/19/8a/apk/462271/content/SCREENSHOT/cf3fb659-7731-424e-b1ed-f0bdfeacf6d0.png@webp",
                "https://static.rustore.ru/imgproxy/eh5B9KBNqM7yH8ZN_eFD7_ikRosRDAIQXMAYBb2pfb4/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/2/19/aa/apk/462271/content/SCREENSHOT/0b18de10-2815-4f8e-9964-dae711b82898.png@webp"
            ),
            shortDescription = "Больше чем банк",
            longDescription = """
                СберБанк Онлайн — ваш надёжный помощник в ежедневных делах. Все финансовые и нефинансовые возможности доступны в одном приложении: от быстрых платежей и удобных переводов до сервисов для жизни, покупок и путешествий.
                На главном экране собраны самые нужные финансовые инструменты. Баланс карты, переводы, история операций, информация о бонусах Спасибо и расходы за месяц — все действия доступны в несколько кликов.
                В Накоплениях удобно управлять долгосрочными сбережениями: вкладами, счетами, инвестиционными продуктами. Сервисы аналитики помогут с оценкой доходности портфеля за месяц, квартал или год. А если хочется за конкретное время накопить на мечту — можно установить цель.
                В разделе «Для жизни» собрана вся нефинансовая экосистема Сбера и партнёров: выгодные покупки, развлечения, путешествия, здоровье и подборки для вдохновения — что посмотреть, куда сходить. А ещё каждую неделю здесь можно поймать самые выгодные предложения.
                В Платежах легко пополнить баланс телефона или оплатить интернет. Здесь же собраны сервисы для дома и авто: быстрая оплата ЖКУ и штрафов, информация по ипотеке и автокредиту, помощь с ремонтом, заправка за бонусы Спасибо и многое другое.
                В разделе «Кредиты» есть всё, что поможет стать на шаг ближе к цели: управление действующими кредитами, предстоящие платежи, возможности для получения дополнительных денег от банка и проверка кредитной истории.
                С помощью поиска легко найти любой сервис, а если запрос сложный, можно обратиться к ИИ-помощнику GigaChat. Он ответит на вопросы о финансах, даст советы по планированию или структурирует сложную информацию.
                А ещё интерфейс приложения можно легко настроить под свои задачи: поменять местами разделы, скрыть неактуальное или добавить то, чем важно управлять сейчас. Изменить СберБанк Онлайн под настроение тоже возможно: достаточно выбрать фон приложения, тему и установить аватар.
            """.trimIndent()
        ),
        AppDetails(
            id = "24rа2f",
            name = "Яндекс.Браузер — с Алисой",
            developer = "Яндекс",
            category = AppCategory.UTILITIES,
            ageRating = 0,
            iconUrl = "https://play-lh.googleusercontent.com/CNo_xqkAu1TPcO6Y02JAVIE1-1IoF6VlEnUgIv7MPby4H52Jn54Iu_-tg69Z91n0QVxDyZCwijRV2AFZwizf_Q=s96",
            screenshotUrlList = listOf(),
            shortDescription = "Быстрый и безопасный браузер",
            longDescription = """
                Яндекс Браузер — быстрый и безопасный браузер с Алисой AI и выгодными покупками.
                Нейросети в Яндекс Браузере
                Алиса AI умеет решать повседневные задачи: подскажет погоду, посоветует, где поесть или купить продуктов. Она всегда рядом — поможет с вашей задачей и подскажет нужное в поисковой строке. А ещё бесплатно сгенерирует любую картинку, которую вы попросите.
                Начать чат с Алисой AI можно на любой странице в интернете. История всех чатов сохраняется на главной странице и доступна с любого устройства, где есть Браузер.
                Алиса AI в Поиске отвечает быстро, понятно и со ссылками на источники. А Умная камера поможет найти по фото что угодно в интернете.
                Встроенный редактор с Алисой AI пишет, редактирует и переводит тексты. А ещё кратко пересказывает видео, статьи и документы. Даже очень большие.
                Браузер переводит иностранные видео с восьми языков: английского, испанского, французского, немецкого, итальянского, китайского, корейского и японского. Мгновенный перевод видео в реальном времени больше не мечта, а реальность!
                И не только нейросети
                Вкладки и группы можно добавлять в облако — и они появятся везде, где вы залогинены в Браузере. Просто выберите, какие группы и веб-страницы нужны вам на всех устройствах.
                Технология активной защиты Нейропротект предупреждает пользователей об опасных сайтах и страницах с платными мобильными подписками — таким образом поисковая система обеспечивает безопасность пользователей.
                Автоматический определитель номера подскажет, кто звонит, даже если номера нет в контактах вашего телефона, а также поможет блокировать незнакомые номера. Яндекс Браузер найдёт название организации в Справочнике или сообщит цель звонка, основываясь на отзывах пользователей.
                Режим «Инкогнито» помогает обойтись без лишних следов. В этом режиме приватный браузер не сохраняет пароли, данные для автозаполнения, поисковые запросы и адреса посещённых страниц.
                Внешний вид новых вкладок можно менять по настроению. Вы можете использовать предустановленные фоны или собственные картинки, сохранённые на устройстве.
                Умная строка ищет и открывает веб-сайты по названиям, а не адресам (например, «Ведомости» или «Википедия»), даёт моментальные ответы на простые вопросы («курс доллара») и легко переводит иностранные слова на русский язык.
                Онлайн-покупки в Яндекс Браузере
                Стоимость покупок до 100 000 ₽ можно делить на несколько равных платежей — с помощью Сплита, встроенного в Браузер. Находите товары с помощью функции «Поиск по фото» и совершайте покупки без переплат и сложных условий.
                Промокоды под рукой
                Открываете сайт магазина через поисковик и нажимаете «% Промокоды» рядом с адресной строкой — появятся промокоды, доступные для этого сайта.
                Кешбэк рублями за онлайн-покупки
                Если опция доступна, появится кнопка «Кешбэк» рядом с адресной строкой. Нажмите её, добавьте товары в корзину и оформите заказ.
                Яндекс Браузер — это идеальный выбор для тех, кто ищет простой, безопасный и быстрый интернет-браузер на русском языке для Android.
                Если у вас есть предложения или пожелания по функциональности и работе браузера, напишите нам прямо из приложения (Настройки → Обратная связь) или со страницы поддержки: https://yandex.ru/support/browser-mobile-iphone/feedback/feedback.xml.
                Загружая программу, Вы принимаете условия Лицензионного соглашения https://yandex.ru/legal/browser_agreement/
            """.trimIndent(),
        ),
        AppDetails(
            id = "klj349",
            name = "Почта Mail.ru",
            developer = "VK",
            category = AppCategory.UTILITIES,
            ageRating = 0,
            iconUrl = "https://play-lh.googleusercontent.com/Q6AOumT71kEeuc_E359gdspTzWGjWP3jzmNBMRbI7drhRHCtEwYD7VLw88l0QotoboC6CrgFuXg8pr4CtASG3g",
            screenshotUrlList = listOf(),
            shortDescription = "Почтовый клиент для любых ящиков",
            longDescription = """
                Mail — теперь больше, чем просто почтовый клиент. Mail — это набор сервисов для продуктивной работы и жизни. Для вас в одном приложении: быстрая Почта с нейросетью, удобный Календарь, Заметки, Облако для фото, Документы, Покупки, Новости.
                Добавьте в почту аккаунты из других почтовых клиентов: Яндекс.Почта, Microsoft Outlook, Gmail от Google, Hotmail, Rambler, Yahoo — и переключайтесь между ними в один клик.
                Краткий пересказ длинного письма. Поручите нейросети в приложении Mail прочитать все длинные электронные письма и кратко пересказать вам контекст, чтобы не терять время.
                Выгодные даты для отпуска в Календаре. Календарь подскажет, в какой месяц лучше уйти в отпуск и какие дни лучше в него включить — выберите вкладку «Год» и введите свою зарплату.
                Управляйте уведомлениями о новых электронных письмах. Настройте только нужные пуши и сообщения в приложении Mail: выберите нужные папки и удобное время.
                Аккаунты всех почтовых клиентов в одном приложении. Соберите все письма из почты в одном приложении — читайте входящие письма, которые приходят вам в Microsoft Outlook, Yahoo, Gmail от Google, Яндекс.Почта, Hotmail, Rambler и Zimbra в один клик.
                Только нужные сервисы в приложении Mail. Быстрая Почта с нейросетью, полезный Календарь — напомнит о встречах и планах, рассчитает отпуск, Облако для хранения фото, документов и сканов, Заметки, Новости.
                Порядок в рассылках. Рассылки с обновлениями приложений, новостями сервисов и предложениями магазинов собраны на одной странице — отпишитесь от ненужных и оставьте актуальные.
                Переводы на другие языки. Добавили удобный переводчик электронной почты. Пригодится, если читаете иностранную рассылку или отправляете бизнес-почту за границу. Просто откройте рассылку или напишите текст и выберите язык — перевод отобразится мгновенно.
                Группировка писем по темам и адресам. Электронная почта собирает в цепочку все электронные письма, а ещё, автоматически сортирует по папкам рассылки, новости, уведомления от соцсетей и письма себе.
                Планер для ваших дел. Встречи по работе, напоминания о важных датах, чек-листы, звонки. Ссылка на звонок — в один клик, когда добавляете встречу в рабочий календарь.
                Облако — безопасное место для документов и фото. Облако Mail сохранит файлы из писем, найдёт сканы документов. Загрузите все фото и видео в Облако, чтобы освободить память смартфона.
                Тёмный фон в приложении Mail для комфортной работы. Выберите яркую заставку для Облака для работы днем, а ночью используйте темный интерфейс для просмотра файлов в Почте.
                Контакты из адресной книги и почтовых клиентов в вашем приложении. Выбирайте, кому отправить письмо — приложение Mail предложит контакты из адресной книги и всех аккаунтов в вашей почте.
                Быстрые действия с письмом. Разбирайте письма в приложении и в браузере: отметьте новое электронное письмо как важное, переместите в новую папку, удалите или оставьте непрочитанным. Добавьте в приложение Mail аккаунты других почтовых клиентов: Rambler, Gmail от Google, Яндекс.Почта, Microsoft Outlook, Hotmail, Yahoo.
                Удобный офлайн-режим для чтения электронных писем. Приложение сохранит письма в памяти смартфона, чтобы вы смогли прочитать их без доступа к сети — в самолёте или за городом.
                ПИШИТЕ НАМ
                Мы это любим. Расскажите, как вам приложение Mail. Воспользуйтесь разделом «Написать разработчику» или напишите письмо на адрес mailapps@corp.mail.ru.
                ЕЩЁ ПАРА СТРОК
                Mail — надёжный почтовый клиент и приложение со всеми сервисами для работы. Приложение совместимо с версиями Android 7.0 и старше. Подходит для работы с почтовыми ящиками Mail, Яндекс.Почта, Rambler, Gmail от Google, Yahoo, Hotmail, Microsoft Outlook и других сервисов, поддерживающих протоколы IMAP, POP и SMTP.
            """.trimIndent()
        ),
        AppDetails(
            id = "274rgw",
            name = "Яндекс.Навигатор",
            developer = "Яндекс",
            category = AppCategory.MAPS,
            ageRating = 0,
            iconUrl = "https://play-lh.googleusercontent.com/aROhxD1HNPLqW1ZiQzCxhDmx700j2g1VGZ0DPDualQxATkCkUEOWWCxxq0BSnZ3fynEe",
            screenshotUrlList = listOf(),
            shortDescription = "Парковки и заправки — по пути",
            longDescription = null,
        ),
        AppDetails(
            id = "34ie9c",
            name = "Мой МТС",
            developer = "МТС",
            category = AppCategory.UTILITIES,
            ageRating = 0,
            iconUrl = "https://play-lh.googleusercontent.com/oO7fsxw5F8fItT4fScnFG9JSCghkoIbOibyx8WpHN8QReoeFKHNlIfLTvDO6BD7OSw",
            screenshotUrlList = listOf(),
            shortDescription = "Мой МТС — центр экосистемы МТС",
            longDescription = null,
        ),
        AppDetails(
            id = "tyft6u",
            name = "Яндекс — с Алисой",
            developer = "Яндекс",
            category = AppCategory.UTILITIES,
            ageRating = 0,
            iconUrl = "https://play-lh.googleusercontent.com/K1yQPVuQDv3x87tPgQGPsnqdoDVWssiLb7P2sjyr2_rjjJHOKgfIaqa6LgwFaqq6lp_DOy4ACCWvn_fJwWKjpQ",
            screenshotUrlList = listOf(
                "https://play-lh.googleusercontent.com/aFGoAHQBrLMcQfQe2WObrcpSnvzn9FmWrlpCsr6h7RUvo_4QIRL0Nj5snXRq6CAJM1CROgZlgLHctue8Aq--11c=w526-h296",
                "https://play-lh.googleusercontent.com/I2fTLHgxsv8oPF8CJ5lQy_0h4t-GagHzcQkz6PjLodLaH8c6xs2yCjDRQ3F_U1YsJQds=w526-h296",
                "https://play-lh.googleusercontent.com/x9ZTJjiNO_0eCxGB2WGPZaih2roAq2cgbypgxVC98dDw4dYsEL-5NGIaUIQ5xGDb=w526-h296",
                "https://play-lh.googleusercontent.com/oYeRngHdJadBKS2FNnpMenfcp-4bMX_bzdvWzHRUpiNbSk-njgcPU5N1hF01ut6phA=w526-h296",
                "https://play-lh.googleusercontent.com/brdOkv4zZHQK0wKq0zsfZ23uTvTzAiTW_z2S3bmM1YI2XKyP6P19he0afnqnCTccpw=w526-h296",
                "https://play-lh.googleusercontent.com/bHZ79ySvRHSa3Wifzaj5hptqXqDMWwIEzqRfBhZNNgv9_RXxgd64uF5G6z7Xa7m4SQ=w526-h296",
                "https://play-lh.googleusercontent.com/_uEvPAOMDG4k8bt8eBKGb7qsJu85q0iwmEfZqf9TNiujGxwOHMITvuZ-OoRTW5hfytE=w526-h296",
                "https://play-lh.googleusercontent.com/ULbwdXWcAhiKywuBbdXUm7Ka8eJjDGu-AhXETp68OS1ZCeeRRuhwtk4ZyKCwKHLYRWE=w526-h296",
                "https://play-lh.googleusercontent.com/vUwA0d--5NtpFV9je7BdsPJbBbNAXwtCXm8zlp9KEn4siy16FW3jaTFiVCMucv0cTDW_SuF28nxEBKHmjVeIz8I=w526-h296",
                "https://play-lh.googleusercontent.com/ynDGFPbjFbRA8byIvyndOkP9bds_IyFWQc08nIVy8sf0Fsrm7Rk0G9k2hxN6sfiqrLQ=w526-h296",
                "https://play-lh.googleusercontent.com/Tz2WjG7t-FdXB9apktfpNd89FJllZ_F4CJ-Ifv9SNYMLN1IjW-mxZktoGWtlTl8dqhA=w526-h296",
                "https://play-lh.googleusercontent.com/K3QsNW6NJDcHiQGGMKB1LjKRq0scdQ9a7Su8kBDAJvgPRBUp5HBt65QUYW5fr1sMmks=w526-h296",
                "https://play-lh.googleusercontent.com/_Vu9Dg9oeQt21nM3MlWYyT2LDouHvjeZlLKjhgVFsU25kgt8g3dKZcpyMbg1l2dKcSo=w526-h296",
                "https://play-lh.googleusercontent.com/TRGgTZWVebeRV6P1yM-pqYk8rXzpUN7Ohv8uN7YwdoybrrbzLEjF-20cvtMYiCXHXQ=w526-h296",
                "https://play-lh.googleusercontent.com/M1iyqanNDNYLOEAW1YDT6CYhC6vW7OO74nJkRdL5bHyK_hUBYtv3hPadqfm4s0n6uw=w526-h296",
                "https://play-lh.googleusercontent.com/yHc7-BP9WsUbwpqY6FA93QSV4d-U6fC-pYXKQNDduMn1qQ7YhQ0Qjsi9eTh8hCrMUg=w526-h296",
                "https://play-lh.googleusercontent.com/8mMyCMcOCAEcG1ELHLrMqVcqFCaigGYq-ZCC9Z5-DRcWuazlhB8wCQx4pqeDDmQMbzTsk3aKM_T0qKx1Vj9EJ_A=w526-h296",
                "https://play-lh.googleusercontent.com/b2iEkIekfddAQME1d69-cTWFjP_xE9sbpCCNVV_hvYNxWEA9KVeZsNWgOjsVh2mX1g=w526-h296",
                "https://play-lh.googleusercontent.com/H0WZFrI2RR7968Qe3rpdr0K94p7QUcs_dyiXDeru5BTB0ixjT5-c4eaJHGnw-an-cA=w526-h296",
                "https://play-lh.googleusercontent.com/t_mxRc_NIL25Rx-Zf42R3q5tsl2nteRAXuS7ZAxRM7kX90XWyN_xP9A1uagJeOfJVavH=w526-h296",
                "https://play-lh.googleusercontent.com/OCTgwaL2knrfNatoHK4itFSAzG-cb7ax4N5WAj2klwG01QWnDqyw8plekvq_DGqZhjc-=w526-h296",
                "https://play-lh.googleusercontent.com/5i5JpwDAZKNJTgI_XijIr4C7C2MNE33vU380x8YqjnFngZfmLeIRilRKHPAxAEizKDM=w526-h296",
                "https://play-lh.googleusercontent.com/A7ctk7OWD3u-uhPs9hxkHfMYJE7PXJshMY8hDlTQ8VoYtRZDj6Wvc0kHylyEypbsLPg=w526-h296",
                "https://play-lh.googleusercontent.com/5I0F0P8b3sUW5Qox2xVn9Wyk46g2YbeAFwa2-cJrfSJD03Iv4N1xXQIgc0KT71kO8yo=w526-h296",
            ),
            shortDescription = "Яндекс — поиск всегда под рукой",
            longDescription = """
                Ищите в Яндексе так, как вам удобно: текстом, голосом, или по картинке. Также приложение подскажет, кто звонит с незнакомого номера, поможет выбрать выгодный вклад и разобраться в сложных вопросах.
                Новая Алиса AI
                Даёт подробные ответы
                Задайте вопрос в чате — Алиса AI изучит источники и даст структурированный ответ. Она понимает, когда лучше ответить кратко, а когда — с пошаговой инструкцией, таблицей или видео. А если в ответе нужно указать организации, то Алиса AI добавит карточки из карт — с фото, рейтингом и деталями работы.
                Помогает учиться
                Задайте вопрос по предмету или сфотографируйте задание — Алиса AI объяснит решение. Просто покажите задачу по геометрии, и она поймёт условия по изображению. Или дайте задание по русскому — например, проверить знаки препинания — даже в рукописном тексте.
                Находит места
                Алиса понимает локальный контекст — что где находится и как работает. В рекомендациях по организациям она показывает карточки с фото, адресом, временем работы, рейтингом и контактами.
                Умная камера. Наведите предмет и посмотрите, что будет. Умная камера распознаёт предметы, рассказывает о них и советует, где купить; переводит надписи, открывает QR-коды и даже заменяет собой сканер.
                В Поиске Алиса теперь предлагает более структурированные ответы с картинками и видео. А также создаст для вас изображение или текст. Если вы только определяетесь с покупкой, то Алиса покажет товары, которые рекомендуют в обзорах и подскажет, на какие параметры обратить внимание при выборе.
                Бесплатный автоматический определитель номера. Включите АОН в меню настроек или попросите: «Алиса, включи определитель номера». Он покажет, кто звонит, даже если номера нет в контактах. База данных из более 5 миллионов организаций и отзывы пользователей сэкономят время и защитят от нежелательных разговоров.
                Поиск по категориям («Финансы», «Товары», «Квартиры», «Медицина») создан для выбора предложений от разных организаций и продавцов. С удобными фильтрами можно выбрать выгодный вклад, нужный товар, квартиру или найти врача с хорошими отзывами. И не придется изучать разные сайты — Поиск покажет предложения из разных источников.
                Погода с точностью до района. Подробный почасовой прогноз на текущий день с динамической картой осадков, ветров, температуры и давления. И ежедневный — на неделю вперёд с детальной информацией о скорости ветра, атмосферном давлении и уровне влажности. А ещё — специальные режимы с полезной погодной информацией для рыбаков, садоводов и не только.
                Загружая программу, Вы принимаете условия Лицензионного соглашения https://yandex.ru/legal/yaalice_mobile_agreement/ru/
            """.trimIndent(),
        ),
        AppDetails(
            id = "13er23",
            name = "Some App",
            developer = "Some Bank",
            category = AppCategory.FINANCE,
            ageRating = 17,
            iconUrl = "https://yavuzceliker.github.io/sample-images/image-7.jpg",
            screenshotUrlList = listOf(),
            shortDescription = "Just some",
            longDescription = null,
        ),
        AppDetails(
            id = "43fr",
            name = "One More App",
            developer = "Someone",
            category = AppCategory.EDUCATION,
            ageRating = 0,
            iconUrl = "https://yavuzceliker.github.io/sample-images/image-410.jpg",
            screenshotUrlList = listOf(),
            shortDescription = "Just another",
            longDescription = null,
        ),
        AppDetails(
            id = "eg8u4a",
            name = "An App With a Crazy Long Name–Who in the World Ever Comes up With Such Blankets?",
            developer = "Some Studio That Names Its Apps Like They’re Emo Songs–and Even Names Itself That Way",
            category = AppCategory.ENTERTAINMENT,
            ageRating = 17,
            iconUrl = "https://yavuzceliker.github.io/sample-images/image-910.jpg",
            screenshotUrlList = listOf(),
            shortDescription = "Our descriptions are also long as hell btw. Y’all never read them anyways tho.",
            longDescription = null,
        ),
    )
}
