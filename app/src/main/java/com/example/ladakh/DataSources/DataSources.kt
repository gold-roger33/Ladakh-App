package com.example.ladakh.DataSources

import com.example.ladakh.R
import com.example.ladakh.model.DetialedScreenData
import com.example.ladakh.model.ExtendedScreenDatas
import com.example.ladakh.model.HomeScreenDatas

object DataSources {

    val HomeScreenItems = listOf(
        HomeScreenDatas(
            id = 1,
            name = "Places To Visit",
            ImageId = R.drawable.places_to_visit
        ),
        HomeScreenDatas(
            id = 2,
            name = "Top Restaurants",
            ImageId = R.drawable.restuarants_to_vist
        ),
        HomeScreenDatas(
            id = 3,
            name = "Adventure Activities",
            ImageId = R.drawable.adventure_activities
        ),
        HomeScreenDatas(
            id = 4,
            name = "Best Time To Visit",
            ImageId = R.drawable.best_time_to_visit
        ),
        HomeScreenDatas(
            id = 5,
                name = "Cultural Experiences",
            ImageId = R.drawable.cultural_experiences
        )
    )
    val  extendedScreenItem: Map<Int,List<ExtendedScreenDatas>> = mapOf(
        1 to listOf(
            ExtendedScreenDatas(
                id = 1,
                name = "Pangong Lake",
                ImageId = R.drawable.pangong_lake
            ),
            ExtendedScreenDatas(
                id = 2,
                name = "Nubra Valley",
                ImageId = R.drawable.nubra_valley
            ),
            ExtendedScreenDatas(
                id = 3,
                name = "Diskit Monastery",
                ImageId = R.drawable.diskit_monastery
            ),
            ExtendedScreenDatas(
                id = 4,
                name = "Tso Kar",
                ImageId = R.drawable.tso_kar
            ),
            ExtendedScreenDatas(
                id = 5,
                name = "Leh Palace",
                ImageId = R.drawable.leh_palace
            ),
            ExtendedScreenDatas(
                id = 6,
                name = "Magnetic Hills",
                ImageId = R.drawable.magnetic_hill
            )
        ),

        2 to listOf(
            ExtendedScreenDatas(
            id = 1,
            name = "cafe cloud",
            ImageId = R.drawable.cafe_cloud
            ),
            ExtendedScreenDatas(
                id = 2,
                name = "lamayuru restaurant",
                ImageId = R.drawable.lamayuru_restaurant
            ),
            ExtendedScreenDatas(
                id = 3,
                name = "bon appetit",
                ImageId = R.drawable.bon_appetit_webp
            ),
            ExtendedScreenDatas(
                id = 4,
                name = "Chopsticks Noodle Bar",
                ImageId = R.drawable.chopsticks_noodle_bar
            ),
            ExtendedScreenDatas(
                id = 5,
                name = "Tibetan kitchen",
                ImageId = R.drawable.tibetan_kitchen
            ),
            ExtendedScreenDatas(
                id = 6,
                name = "dylans-toasted-and-roasted",
                ImageId = R.drawable.dylans_toasted_and_roasted
            ),
        ),
        3 to listOf(
            ExtendedScreenDatas(
                id = 1,
                name = "Camel Safari",
                ImageId = R.drawable.ladakh_s_camel_safari
            ),
            ExtendedScreenDatas(
                id = 2,
                name = "Mountain biking",
                ImageId = R.drawable.mountain_biking
            ),
            ExtendedScreenDatas(
                id = 3,
                name = "River Rafting",
                ImageId = R.drawable.river_rafting_ladakh
            ),
            ExtendedScreenDatas(
                id = 4,
                name = "Trekking",
                ImageId = R.drawable.trekking
            )
        ),
        5 to listOf(
            ExtendedScreenDatas(
                id = 2,
                name = "Hemis Festival",
                ImageId = R.drawable.hemis_festival
            ),
            ExtendedScreenDatas(
                id = 2,
                name = "Losar Festival",
                ImageId = R.drawable.losar_festival
            ),
            ExtendedScreenDatas(
                id = 3,
                name = "sindhu darhsan",
                ImageId = R.drawable.sindhu_darhsan
            ),
            ExtendedScreenDatas(
                id = 4,
                name = "Thangka paintings",
                ImageId = R.drawable.thangka_paintings
            ),
        )
    )



    val DetialedScreenItems: Map<Int,List<DetialedScreenData>> = mapOf(
        1 to listOf(
            DetialedScreenData(
                name = "Pangong Lake",
                ImageId = R.drawable.pangong_lake,
                location = "Ladakh",
                detials = "Pangong Lake, located in the high-altitude region of Ladakh at an elevation of about 4,350 meters (14,270 feet), " +
                        "is a breathtakingly beautiful, crystal-clear lake that stretches over 134 kilometers, with a portion extending into China. " +
                        "Surrounded by rugged mountains and dramatic landscapes, the lake is known for its ever-changing shades of blue, shifting from deep navy to turquoise, " +
                        "depending on the time of day and weather, making it a photographer’s paradise and a must-visit destination for nature lovers. Accessible via a scenic drive from Leh, " +
                        "Pangong Lake offers a serene escape from city life and is especially popular for camping, stargazing, and witnessing the raw, untouched beauty of the Himalayas. " +
                        "The lake’s pristine waters are brackish and sustain a unique ecosystem that thrives in harsh conditions. Visitors often marvel at the peaceful silence, " +
                        "broken only by gentle breezes and occasional migratory birds. The surrounding landscape is dotted with small nomadic settlements and vibrant wildflowers during the summer months. " +
                        "Pangong Lake has also gained fame as a popular shooting location for Bollywood films such as 3 Idiots, Jab Tak Hai Jaan, and Dil Se, which has further increased its allure among tourists. " +
                        "Despite the cold temperatures, the tranquil ambiance and panoramic views make it an unforgettable experience. Traveling here requires permits due to its proximity to the sensitive Indo-China border, " +
                        "adding to the adventure and exclusivity of the visit. Whether visiting in summer when the lake is fully thawed or during winter when the surface freezes over creating a surreal icy expanse, Pangong Lake remains " +
                        "a mesmerizing destination that captures the hearts of all who journey to its shores.\n"
        ),
            DetialedScreenData(
                name = "Nubra Valley",
                ImageId = R.drawable.nubra_valley,
                location = "Ladakh",
                detials = "Nubra Valley, often described as a cold desert, is located to the northeast of Leh and is one of the most spectacular destinations in Ladakh. " +
                        "The valley is famed for its contrasting landscapes — from lush green oases and flowing rivers to vast sand dunes and barren mountains. " +
                        "One of the highlights of Nubra is the opportunity to ride the iconic double-humped Bactrian camels across the sweeping sand dunes of Hunder. " +
                        "Nubra also boasts rich cultural heritage with ancient monasteries like Diskit and Samstanling, where the echoes of Buddhist chants fill the air. " +
                        "The valley’s remoteness and stunning vistas offer travelers a unique chance to experience untouched Himalayan wilderness and engage with the warm hospitality of local communities. " +
                        "Accessible via the Khardung La pass — one of the highest motorable roads in the world — the journey to Nubra Valley itself is an adventure filled with breathtaking views and thrilling twists and turns. " +
                        "Nubra Valley’s serene environment and breathtaking natural beauty make it a haven for trekkers, photographers, and anyone seeking a peaceful retreat in the mountains."
            ),
            DetialedScreenData(
                name = "Diskit Monastery",
                ImageId = R.drawable.diskit_monastery,
                location = "Ladakh",
                detials = "Diskit Monastery, founded in the 14th century, is the oldest and largest Buddhist monastery in Nubra Valley and serves as a spiritual center for the local population. " +
                        "Perched high on a hill overlooking the valley, the monastery offers stunning panoramic views of the surrounding landscape and the Shyok River below. " +
                        "The monastery is renowned for its impressive 32-meter tall statue of Maitreya Buddha, which was built to promote peace and protect the valley from conflict. " +
                        "Inside the monastery, visitors can explore ancient murals, sacred artifacts, and prayer halls that reflect centuries of Tibetan Buddhist traditions. " +
                        "Monks residing here follow a peaceful monastic routine, and the monastery also hosts vibrant festivals filled with traditional music, masked dances, and rituals. " +
                        "Diskit Monastery is not only a place of worship but also a cultural landmark that offers a deep insight into the spiritual life and customs of Ladakh’s people."
        ),
            DetialedScreenData(
                name = "Tso Kar",
                ImageId = R.drawable.tso_kar,
                location = "Ladakh",
                detials = "Tso Kar, known as the White Lake, is a high-altitude salt lake situated south of the more famous Pangong Lake and forms part of a unique wetland ecosystem. " +
                        "At an elevation of around 4,530 meters, the lake is surrounded by rugged mountains and salt-encrusted plains that sparkle under the bright Himalayan sun. " +
                        "During the summer months, Tso Kar becomes a crucial breeding ground for several species of migratory birds, including the graceful black-necked cranes and vibrant flamingos. " +
                        "The lake’s salty shores are dotted with salt deposits that glisten in the sunlight, creating a surreal and mesmerizing landscape unlike any other. " +
                        "Tso Kar is also a protected Ramsar site, emphasizing its ecological importance and the need for conservation. " +
                        "Visitors to this remote lake can experience a profound sense of tranquility and solitude, often accompanied only by the calls of birds and the gentle breeze sweeping across the plains. " +
                        "The journey to Tso Kar is an adventure in itself, with rugged terrain and pristine natural beauty that captivates nature lovers and photographers alike."
                ),
            DetialedScreenData(
                name = "Leh Palace",
                ImageId = R.drawable.leh_palace,
                location = "Ladakh",
                detials = "Leh Palace, built in the 17th century by King Sengge Namgyal, is an architectural marvel that towers over the town of Leh, offering visitors spectacular views of the surrounding Himalayan peaks. " +
                        "Designed in the style of the Potala Palace in Lhasa, Tibet, this nine-story structure was once the royal residence of Ladakh’s kings. " +
                        "Though partially in ruins today, the palace’s walls still retain murals and artifacts that tell stories of the region’s rich history and culture. " +
                        "Inside, a museum exhibits royal costumes, jewelry, ancient manuscripts, and religious objects that provide a glimpse into Ladakh’s regal past. " +
                        "Leh Palace is a popular spot for photography enthusiasts who come to capture the stunning contrast of the palace against the rugged mountainous backdrop. " +
                        "Visitors can climb its terraces to enjoy sweeping views of Leh town and the Indus River valley, making it both a cultural and scenic highlight of any trip to Ladakh."
        ),
            DetialedScreenData(
                name = "Magnetic Hills",
                ImageId = R.drawable.magnetic_hill,
                location = "Ladakh",
                detials = "Magnetic Hills, located on the Leh-Kargil highway, is famous worldwide for the optical illusion that makes vehicles appear to roll uphill against gravity. " +
                        "This natural phenomenon has intrigued scientists and tourists alike, turning the site into a quirky and popular roadside attraction. " +
                        "Surrounded by majestic Himalayan mountains, the magnetic hill area offers breathtaking views that add to the overall experience. " +
                        "Many visitors stop here to test the gravity-defying illusion themselves, creating fun memories and photo opportunities. " +
                        "Nearby, the serene Gurudwara Pathar Sahib, built in memory of Guru Nanak, provides a spiritual complement to the whimsical magnetic hill experience. " +
                        "The unique combination of natural wonder, cultural heritage, and stunning scenery makes Magnetic Hills a must-see destination for travelers exploring Ladakh."
            )
        ),

        2 to listOf(
            DetialedScreenData(
                name = "Cafe Cloud",
                ImageId = R.drawable.cafe_cloud,
                location = "Leh, Ladakh",
                detials = "A cozy café with panoramic views of Leh valley. Known for its freshly brewed coffee, pastries, and relaxed vibe. It’s a favorite spot for travelers to unwind after sightseeing."
            ),
            DetialedScreenData(
                name = "Lamayuru Restaurant",
                ImageId = R.drawable.lamayuru_restaurant,
                location = "Leh, Ladakh",
                detials = "Traditional Ladakhi cuisine served in a homely setting. Try the thukpa, momos, and butter tea with warm hospitality and cultural decor."
            ),
            DetialedScreenData(
                name = "Bon Appetit",
                ImageId = R.drawable.bon_appetit_webp,
                location = "Leh, Ladakh",
                detials = "Popular multi-cuisine restaurant offering Italian, Indian, and continental dishes. Known for its wood‑fired pizzas, pastas, and scenic rooftop seating."
            ),
            DetialedScreenData(
                name = "Chopsticks Noodle Bar",
                ImageId = R.drawable.chopsticks_noodle_bar,
                location = "Leh, Ladakh",
                detials = "Casual noodle bar specializing in Tibetan and Chinese dishes. Great for authentic dumplings, thukpa, and spicy stir‑fries after a day of trekking."
            ),
            DetialedScreenData(
                name = "Tibetan Kitchen",
                ImageId = R.drawable.tibetan_kitchen,
                location = "Leh, Ladakh",
                detials = "A small, family‑run joint focusing on Tibetan specialties like momos, tingmo, and hearty stews—perfect for a cozy meal in colder weather."
            ),
            DetialedScreenData(
                name = "Dylans Toasted and Roasted",
                ImageId = R.drawable.dylans_toasted_and_roasted,
                location = "Leh, Ladakh",
                detials = "Specialty café known for freshly baked bread, sandwiches, pastries, and roasted coffee. A great breakfast/brunch spot with a modern vibe."
            )
        ),

        3 to listOf(
            DetialedScreenData(
                name = "Camel Safari",
                ImageId = R.drawable.ladakh_s_camel_safari,
                location = "Hunder, Nubra Valley",
                detials = "Ride the iconic double‑humped Bactrian camels across the sandy dunes of Hunder. A unique desert‑like experience amidst Himalayan valleys."
            ),
            DetialedScreenData(
                name = "Mountain Biking",
                ImageId = R.drawable.mountain_biking,
                location = "Around Leh",
                detials = "Guided or self‑guided biking on rugged trails through valleys, monasteries, and passes. Offers a thrilling way to explore the region at your own pace."
            ),
            DetialedScreenData(
                name = "River Rafting",
                ImageId = R.drawable.river_rafting_ladakh,
                location = "Zanskar River",
                detials = "Exciting rafting trips ranging from mild to wild along the Zanskar River—great for adrenaline junkies wanting to experience Ladakh’s rivers."
            ),
            DetialedScreenData(
                name = "Trekking",
                ImageId = R.drawable.trekking,
                location = "Multiple Routes, Ladakh",
                detials = "Popular treks include Chadar (frozen river trek), Markha Valley, and Stok Kangri base camp. Experience varied terrain, high passes, and remote villages."
            )
        ),
        5 to listOf(
            DetialedScreenData(
                name = "Hemis Festival",
                ImageId = R.drawable.hemis_festival,
                location = "Hemis Monastery, Leh",
                detials = "One of the most vibrant Buddhist festivals held every June. Features traditional mask dances (Cham), music, and colorful processions celebrating Guru Padmasambhava."
            ),
            DetialedScreenData(
                name = "Losar Festival",
                ImageId = R.drawable.losar_festival,
                location = "Ladakh",
                detials = "Tibetan New Year (February/March) celebrated with prayers, family gatherings, traditional feasts, and cultural performances. A time of renewal and community bonding."
            ),
            DetialedScreenData(
                name = "Sindhu Darshan",
                ImageId = R.drawable.sindhu_darhsan,
                location = "Indus River, Leh",
                detials = "Held annually in June to honor the Sindhu (Indus) River. Features cultural programs, river‑side rituals, and positive vibes celebrating Ladakhi heritage."
            ),
            DetialedScreenData(
                name = "Thangka Paintings",
                ImageId = R.drawable.thangka_paintings,
                location = "Monasteries around Leh",
                detials = "A traditional art form of detailed chakra and deity paintings on canvas. Visit workshops and learn about the spiritual symbolism and techniques behind Thangka art."
            )
        )
    )
}