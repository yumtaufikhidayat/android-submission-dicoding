package com.taufik.movieshow.utils

import com.taufik.movieshow.data.source.local.entity.*
import com.taufik.movieshow.data.source.remote.response.MovieResponse
import com.taufik.movieshow.data.source.remote.response.OtherMoviesResponse
import com.taufik.movieshow.data.source.remote.response.OtherTvShowsResponse
import com.taufik.movieshow.data.source.remote.response.TvShowResponse

object DataDummy {

    fun generateRemoteMovieNowPlaying(): List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()
        movies.add(
            MovieResponse(
                imageBackdrop= "/vpdBOYTWgjrh90JN1Yc1YnCPFkD.jpg",
                id="399566",
                language= "en",
                overview= "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                imagePoster= "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                releaseDate= "2021-03-24",
                title= "Godzilla vs. Kong",
                rating= 8.4,
                homePage=  "https://www.godzillavskong.net"
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/hJuDvwzS0SPlsE6MNFOpznQltDZ.jpg",
                id="527774",
                language= "en",
                overview= "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                imagePoster= "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                releaseDate= "2021-03-03",
                title= "Raya and the Last Dragon",
                rating= 8.3,
                homePage= "https://movies.disney.com/raya-and-the-last-dragon"
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/fev8UFNFFYsD5q7AcYS8LyTzqwl.jpg",
                id="587807",
                language= "en",
                overview= "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
                imagePoster= "/6KErczPBROQty7QoIsaa6wJYXZi.jpg",
                releaseDate= "2021-02-11",
                title= "Tom & Jerry",
                rating= 7.4,
                homePage= "https://www.tomandjerrymovie.com"
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/z8TvnEVRenMSTemxYZwLGqFofgF.jpg",
                id="458576",
                language= "en",
                overview= "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                imagePoster= "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                releaseDate= "2020-12-03",
                title= "Monster Hunter",
                rating= 7.1,
                homePage= "https://www.monsterhunter.movie"
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/uQtqiAu2bBlokqjlURVLEha6zoi.jpg",
                id="544401",
                language= "en",
                overview= "Cherry drifts from college dropout to army medic in Iraq - anchored only by his true love, Emily. But after returning from the war with PTSD, his life spirals into drugs and crime as he struggles to find his place in the world.",
                imagePoster= "/pwDvkDyaHEU9V7cApQhbcSJMG1w.jpg",
                releaseDate= "2021-02-26",
                title= "Cherry",
                rating= 7.6,
                homePage= "https://tv.apple.com/movie/umc.cmc.40gvwq6hnbilmnxuutvmejx4r"
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/cjaOSjsjV6cl3uXdJqimktT880L.jpg",
                id="529203",
                language= "en",
                overview= "Searching for a safer habitat, the prehistoric Crood family discovers an idyllic, walled-in paradise that meets all of its needs. Unfortunately, they must also learn to live with the Bettermans -- a family that's a couple of steps above the Croods on the evolutionary ladder. As tensions between the new neighbors start to rise, a new threat soon propels both clans on an epic adventure that forces them to embrace their differences, draw strength from one another, and survive together.",
                imagePoster= "/tbVZ3Sq88dZaCANlUcewQuHQOaE.jpg",
                releaseDate= "2020-11-25",
                title= "The Croods: A New Age",
                rating= 7.5,
                homePage= "https://www.dreamworks.com/movies/the-croods-2"
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/zDq2pwPyt4xwSFHKUoNN2LohDWj.jpg",
                id="632357",
                language= "en",
                overview= "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                imagePoster= "/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
                releaseDate= "2021-03-31",
                title= "The Unholy",
                rating= 6.1,
                homePage= "https://www.sonypictures.com/movies/theunholy"
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/5NxjLfs7Bi07bfZCRl9CCnUw7AA.jpg",
                id="412656",
                language= "en",
                overview= "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
                imagePoster= "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
                releaseDate= "2021-02-24",
                title= "Chaos Walking",
                rating= 7.6,
                homePage= "https://chaoswalking.movie"
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/vfuzELmhBjBTswXj2Vqxnu5ge4g.jpg",
                id="602269",
                language= "en",
                overview= "Deputy Sheriff Joe \"Deke\" Deacon joins forces with Sgt. Jim Baxter to search for a serial killer who's terrorizing Los Angeles. As they track the culprit, Baxter is unaware that the investigation is dredging up echoes of Deke's past, uncovering disturbing secrets that could threaten more than his case.",
                imagePoster= "/c7VlGCCgM9GZivKSzBgzuOVxQn7.jpg",
                releaseDate= "2021-01-28",
                title= "The Little Things",
                rating= 6.4,
                homePage= "https://www.thelittlethingsmovie.com"
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                id="560144",
                language= "en",
                overview= "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                imagePoster= "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                releaseDate= "2020-10-25",
                title= "Skylines",
                rating= 5.9,
                homePage= ""
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/9Is9OrQUnKczCfsLSbsbx8YSmES.jpg",
                id="797394",
                language= "ru",
                overview= "The Secret Magic Control Agency sends its two best agents, Hansel and Gretel, to fight against the witch of the Gingerbread House.",
                imagePoster= "/4ZSzEDVdxWVMVO4oZDvoodQOEfr.jpg",
                releaseDate= "2021-03-18",
                title= "Secret Magic Control Agency",
                rating= 7.3,
                homePage= "https://www.netflix.com/title/81267965"
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/u5WUCO6irZoq27qbYYrtLUrCGDV.jpg",
                id="630586",
                language= "en",
                overview= "Jen and a group of friends set out to hike the Appalachian Trail. Despite warnings to stick to the trail, the hikers stray off course—and cross into land inhabited by The Foundation, a hidden community of mountain dwellers who use deadly means to protect their way of life.",
                imagePoster= "/4U1SBHmwHkNA0eHZ2n1CuiC1K1g.jpg",
                releaseDate= "2021-01-26",
                title= "Wrong Turn",
                rating= 6.2,
                homePage= ""
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/nz8xWrTKZzA5A7FgxaM4kfAoO1W.jpg",
                id="651571",
                language= "en",
                overview= "A hardened mechanic must stay awake and maintain an interstellar ark fleeing the dying planet Earth with a few thousand lucky souls on board... the last of humanity. Unfortunately, humans are not the only passengers. A shapeshifting alien creature has taken residence, its only goal is to kill as many people as possible. The crew must think quickly to stop this menace before it destroys mankind.",
                imagePoster= "/13B6onhL6FzSN2KaNeQeMML05pS.jpg",
                releaseDate= "2020-12-17",
                title= "Breach",
                rating= 4.6,
                homePage= "https://crediblepapers.com/writing-services/"
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "",
                id="684369",
                language= "es",
                overview= "A fugitive film director in exile, called H, returns to the industrial city of which he fled in the past, in a time and place unknown. Gloria, the working woman who loved and left behind lives subjected to routine. But H, unable to adapt, convince her to run away together to a place that no one remembers the outside of civilization.",
                imagePoster= "/6Bp5EyQCunRumsswNyw9FzWM5Ji.jpg",
                releaseDate= "2019-11-05",
                title= "West",
                rating= 3.5,
                homePage= "http://www.occidente-film.com/"
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/a9zFUuxzChmAlIybVge9IZt1hH0.jpg",
                id="578908",
                language= "en",
                overview= "Two pals embark on a road trip full of funny pranks that pull real people into mayhem.",
                imagePoster= "/A1Gy5HX3DKGaNW1Ay30NTIVJqJ6.jpg",
                releaseDate= "2021-03-26",
                title= "Bad Trip",
                rating= 6.0,
                homePage= "https://badtripthemovie.com/"
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/nq4LRhGrCZ8ucxMaLMPa3uZV6ku.jpg",
                id="709629",
                language= "es",
                overview= "In order to advance her career in the dynamic world of publicity in Mexico City, Raquel tries to reunite with her high school friend Cecy who has become the queen of social media. But unlike followers, friendships do not come instantly.",
                imagePoster= "/jpdWHOu6EJbYnLXLCA52h82nLEz.jpg",
                releaseDate= "2021-03-12",
                title= "War of Likes",
                rating= 7.9,
                homePage= ""
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/vQJ3yBdF91tzd73G8seL5bOxfvG.jpg",
                id="599281",
                language= "en",
                overview= "A teenage girl living with schizophrenia begins to suspect her neighbor has kidnapped a child. Her parents try desperately to help her live a normal life, without exposing their own tragic secrets, and the only person who believes her is Caleb – a boy she isn’t even sure exists.",
                imagePoster= "/b2shaNA4F8zNIwoRYr33lPTiFfl.jpg",
                releaseDate= "2021-02-12",
                title= "Fear of Rain",
                rating= 7.3,
                homePage= "https://cimalek.net/"
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/las0P4Dua54XrZ73VQmGUaH1z0U.jpg",
                id="movieId",
                language= "ja",
                overview= "In the aftermath of the Fourth Impact, stranded without their Evangelions, Shinji, Asuka, and Rei search for refuge in the desolate red remains of Tokyo-3. But the danger to the world is far from over. A new impact is looming on the horizon—one that will prove to be the true end of Evangelion.",
                imagePoster= "/AoevYJSVtg15hntg8SYwWm2k3hP.jpg",
                releaseDate= "2021-03-08",
                title= "Evangelion: 3.0+1.0 Thrice Upon a Time",
                rating= 6.5,
                homePage= "https://www.evangelion.co.jp/final.html"
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/sNKnz0ZU8u55yCFreZUSOIBMSuY.jpg",
                id="638597",
                language= "en",
                overview= "A mom and dad who usually say no decide to say yes to their kids' wildest requests — with a few ground rules — on a whirlwind day of fun and adventure.",
                imagePoster= "/rejrD9ovTHJbfmpLM0mbEliEPV6.jpg",
                releaseDate= "2021-03-12",
                title= "Yes Day",
                rating= 7.0,
                homePage= "https://www.netflix.com/title/81011712"
            )
        )
        movies.add(
            MovieResponse(
                imageBackdrop= "/7TxeZVg2evMG42p0uSbMJpWNQ8A.jpg",
                id="520946",
                language= "en",
                overview= "Freddy Lupin, heir to a proud family line of werewolves, is in for a shock when on his 14th birthday his first 'warfing' goes awry, turning him into a ferocious poodle. The pack elders give Freddy until the next moonrise to prove he has the heart of a wolf, or risk being cast out forever. With the help of an unlikely ally in a streetwise stray named Batty, Freddy must prove he's 100% Wolf.",
                imagePoster= "/2VrvxK4yxNCU6KVgo5TADJeBEQu.jpg",
                releaseDate= "2020-06-26",
                title= "100% Wolf",
                rating= 5.7,
                homePage= "https://www.screenaustralia.gov.au/the-screen-guide/t/100--wolf-2019/34581"
            )
        )
        
       return movies
    }
    
    fun generateRemoteTvShowsAiringToday(): List<TvShowResponse>{
        val tvShows = ArrayList<TvShowResponse>()
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg",
                firstAirDate = "2005-03-27",
                id = "1416",
                title = "Grey's Anatomy",
                language = "en",
                overview = "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                imagePoster = "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                rating = 8.2,
                homePage = "http://abc.go.com/shows/greys-anatomy"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/fRYwdeNjMqC30EhofPx5PlDpdun.jpg",
                firstAirDate = "2018-10-25",
                id = "79460",
                title = "Legacies",
                language = "en",
                overview = "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.",
                imagePoster = "/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg",
                rating = 8.6,
                homePage = "http://www.cwtv.com/shows/legacies"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/qPO43E0tnw9Gjh9EzkNmc3AKlE3.jpg",
                firstAirDate = "2018-03-22",
                id="76773",
                title = "Station 19",
                language = "en",
                overview = "A group of heroic firefighters at Seattle Fire Station 19—from captain to newest recruit—risk their lives and hearts both in the line of duty and off the clock. These brave men and women are like family, literally and figuratively, and together they put their own lives in jeopardy as first responders to save the lives of others.",
                imagePoster = "/lcuCED5Ky2uM5VE6wILOwt5FEb0.jpg",
                rating = 8.2,
                homePage = "http://abc.go.com/shows/station-19"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/W5geO8tq68ng4TsXyZ81phcPiz.jpg",
                firstAirDate = "2012-10-10",
                id="44006",
                title = "Chicago Fire",
                language = "en",
                overview = "An edge-of-your-seat view into the lives of everyday heroes committed to one of America's noblest professions. For the firefighters, rescue squad and paramedics of Chicago Firehouse 51, no occupation is more stressful or dangerous, yet so rewarding and exhilarating. These courageous men and women are among the elite who forge headfirst into danger when everyone else is running the other way and whose actions make the difference between life and death.",
                imagePoster = "/6AccYL0eb7uzHn98IKaNjvJbyuA.jpg",
                rating = 8.4,
                homePage = "http://www.nbc.com/chicago-fire"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/s2IXx944vnZUtAxC2nPydOfqakh.jpg",
                firstAirDate = "2021-01-21",
                id="99121",
                title = "Walker",
                language = "en",
                overview = "Reboot of the 1993 series focusing on Walker as he returns from years undercover. A widower and father of two, he begins fighting crime with a new partner, who is one of the only female Rangers in history.",
                imagePoster = "/y4VHQbbY1UcAjHN7UTGu0MGyVl2.jpg",
                rating = 6.9,
                homePage = "https://www.cwtv.com/shows/walker"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/cD9PxbrdWYgL7MUpD9eOYuiSe2P.jpg",
                firstAirDate = "1999-09-20",
                id="2734",
                title = "Law & Order: Special Victims Unit",
                language = "en",
                overview = "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
                imagePoster = "/jDCgWVlejIo8sQYxw3Yf1cVQUIL.jpg",
                rating = 7.8,
                homePage = "http://www.nbc.com/law-and-order-special-victims-unit"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/f9eLOgAiN8x7nFXbedYxb3KCKxR.jpg",
                firstAirDate = "2014-01-08",
                id="58841",
                title = "Chicago P.D.",
                language = "en",
                overview = "A riveting police drama about the men and women of the Chicago Police Department's District 21 who put it all on the line to serve and protect their community. District 21 is made up of two distinctly different groups: the uniformed cops who patrol the beat and go head-to-head with the city's street crimes and the Intelligence Unit that combats the city's major offenses - organized crime, drug trafficking, high profile murders and beyond.",
                imagePoster = "/OlPR1kctwXzSUJQkZINDDhNlHV.jpg",
                rating = 8.4,
                homePage = "http://www.nbc.com/chicago-pd"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/xVt9ADgKoJMzQ7eVXiFYMbXU85E.jpg",
                firstAirDate = "2020-04-28",
                id="102966",
                title = "100 días para enamorarnos",
                language = "es",
                overview = "Two couples who struggle to be near each other decide to give another chance for each other, 100 days for them to fall back in love.",
                imagePoster = "/r13t1ohRQAlZpsjxgTKY7ypkWPc.jpg",
                rating = 7.7,
                homePage = "https://www.telemundo.com/series-y-novelas/100-dias-para-enamorarnos"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/nlDBlCtorM7nx130wYnfR5ZmyLX.jpg",
                firstAirDate = "2017-09-25",
                id="71728",
                title = "Young Sheldon",
                language = "en",
                overview = "The early life of child genius Sheldon Cooper, later seen in The Big Bang Theory.",
                imagePoster = "/aESxB2HblKlDzma39xVefa20pbW.jpg",
                rating = 8.0,
                homePage = "http://www.cbs.com/shows/young-sheldon/"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/iCBMJZFsdXALgpS121qu4CAe2Sa.jpg",
                firstAirDate = "2017-09-27",
                id="71789",
                title = "SEAL Team",
                language = "en",
                overview = "The lives of the elite Navy Seals as they train, plan and execute the most dangerous, high-stakes missions our country can ask.",
                imagePoster = "/uTSLeQTeHevt4fplegmQ6bOnE0Z.jpg",
                rating = 7.8,
                homePage = "http://www.cbs.com/shows/seal-team/"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/gJSqr2prvTegFbL0cEWK9Qti3Vs.jpg",
                firstAirDate = "2017-11-02",
                id="71790",
                title = "S.W.A.T.",
                language = "en",
                overview = "A locally born and bred S.W.A.T. lieutenant is torn between loyalty to the streets and duty to his fellow officers when he's tasked to run a highly-trained unit that's the last stop for solving crimes in Los Angeles.",
                imagePoster = "/ushSkKB8aeLsyyW2c7S7CCmEmRA.jpg",
                rating = 7.7,
                homePage = "http://www.cbs.com/shows/swat/"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/hBYvHCcZX4dyvXeM0NTBh5uJIk3.jpg",
                firstAirDate = "2019-01-08",
                id="80006",
                title = "Good Trouble",
                language = "en",
                overview = "After moving to The Coterie in Downtown Los Angeles, Callie and Mariana Foster realize that living on their own is not all that it’s cracked up to be.",
                imagePoster = "/b9OwPQZr4dVv7K8SrUbAYJ35uLg.jpg",
                rating = 7.9,
                homePage = "https://freeform.go.com/shows/good-trouble"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/sHjNS2lYyEjwjjQXTZmdyMJ29bI.jpg",
                firstAirDate = "2015-11-17",
                id="62650",
                title = "Chicago Med",
                language = "en",
                overview = "An emotional thrill ride through the day-to-day chaos of the city's most explosive hospital and the courageous team of doctors who hold it together. They will tackle unique new cases inspired by topical events, forging fiery relationships in the pulse-pounding pandemonium of the emergency room.",
                imagePoster = "/8mFhW6fJlapqq3cmQjxcG5h4KFa.jpg",
                rating = 8.2,
                homePage = "http://www.nbc.com/chicago-med"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/ibAYMuyRodgOYTeHGQqh6WCh5JU.jpg",
                firstAirDate = "2021-04-01",
                id="104699",
                title = "Shaman King",
                language = "ja",
                overview = "The Shaman King is the one who can contact the king of spirits and reshape the world. Every 500 years, shamans, who can commune between the worlds of the living and dead, compete in the Shaman Fight to become the next Shaman King.\n\nAmong those aiming for the top is a young shaman named Yoh Asakura.",
                imagePoster = "/rFFsdLlwyclyM83ALobrfMhr28A.jpg",
                rating = 8.3,
                homePage = "https://shamanking-project.com/"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/owvL8PxjIvU4X83mJ4Z7aYMVBmw.jpg",
                firstAirDate = "2021-04-07",
                id="95631",
                title = "Super Cub",
                language = "ja",
                overview = "Koguma is a high school girl in Yamanashi. She has no parents, friends, or hobbies, and her daily life is empty. One day, Koguma gets a used Honda Super Cub motorcycle. This is her first time going to school on a motorcycle. Running out of gas and hitting detours become a small source of adventure in Koguma's life. She is satisfied with this strange transformation, but her classmate Reiko ends up talking to her about how she also goes to school by motorcycle. One Super Cub begins to open up a lonely girl's world, introducing her to a new everyday life and friendship.",
                imagePoster = "/h36KQWhJEZuVptk0WBuSVXhuiD8.jpg",
                rating = 0.0,
                homePage = "https://supercub-anime.com"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/zd3BxI5qC8U2Feg83H4tLkwLcfg.jpg",
                firstAirDate = "2018-10-04",
                id="82822",
                title = "Zombie Land Saga",
                language = "ja",
                overview = "A typical morning. The usual music. Their normal lives. The peace these seven girls experience will suddenly be destroyed. By the living dead... zombies. A reality that they never wanted a part of, an amazing and terrifying zombie world. They all share one wish: \"We want to live.\" These girls will struggle through this saga, in order to achieve a miracle.",
                imagePoster = "/c62Myh7wxmAUabqmCje8u9mbVIO.jpg",
                rating = 8.4,
                homePage = "https://www.zombielandsaga.com/"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/cvFnG5roIAopSFkHvVnPMHWO01s.jpg",
                firstAirDate = "2021-04-07",
                id="114198",
                title = "Full Dive: This Ultimate Next-Gen Full Dive RPG is Even Shittier than Real Life!",
                language = "ja",
                overview = "In an unexpected turn of events, dull high school student Hiro Yuuki obtains the full dive role-playing game Kiwame Quest. Created by the best of technology, the game claims to take \"reality to its extremes,\" from stunning graphics, NPCs' behavior, to the scent of vegetation, and even the sensation of wind brushing against the skin—everything was the result of an ultimate workmanship.\n\nExcept, the game is a little too realistic and messy to clear. Kiwame Quest features over ten quadrillion flags and reflects the players' real-life physical abilities in the game. Being hit in the game also hurts in real life and slash wounds take days to heal.\n\nThe only reward here is the sense of accomplishment. Conquer the most stressful game in history that can't be played casually!",
                imagePoster = "/6pRbPIGuBAZDjblqhDl6U4CUQxI.jpg",
                rating = 0.0,
                homePage = "https://fulldive-rpg.com"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/3ib0uov9Qq9JtTIEGL39irTa3vZ.jpg",
                firstAirDate = "2018-09-24",
                id="79696",
                title = "Manifest",
                language = "en",
                overview = "After landing from a turbulent but routine flight, the crew and passengers of Montego Air Flight 828 discover five years have passed in what seemed like a few hours. As their new realities become clear, a deeper mystery unfolds and some of the returned passengers soon realize they may be meant for something greater than they ever thought possible.",
                imagePoster = "/1xeiUxShzNn8TNdMqy3Hvo9o2R.jpg",
                rating = 7.7,
                homePage = "https://www.nbc.com/manifest"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/q79U95wgkocoECitZPfRDhZXBNz.jpg",
                firstAirDate = "2007-10-14",
                id="14814",
                title = "Keeping Up with the Kardashians",
                language = "en",
                overview = "A peek inside the exploits and privileged private lives of the blended Kardashian-Jenner family, including sisters Kim, Kourtney and Khloé.",
                imagePoster = "/nddXOC8wYpIDv7giLzjjqIg8WDA.jpg",
                rating = 5.0,
                homePage = "http://www.eonline.com/shows/kardashians"
            )
        )
        tvShows.add(
            TvShowResponse(
                imageBackdrop = "/2Ib8kvWa9gGhJrAfGlhIvbmtbWn.jpg",
                firstAirDate = "2010-11-08",
                id="32415",
                title = "Conan",
                language = "en",
                overview = "A late night television talk show hosted by Conan O'Brien.",
                imagePoster = "/e0QI3XHKO0n70U3mxBdHf8uoxie.jpg",
                rating = 7.3,
                homePage = "http://www.teamcoco.com"
            )
        )

        return tvShows
    }

    fun generateMovieNowPlaying(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                imageBackdrop= "/vpdBOYTWgjrh90JN1Yc1YnCPFkD.jpg",
                language= "en",
                overview= "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                imagePoster= "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                releaseDate= "2021-03-24",
                title= "Godzilla vs. Kong",
                rating= 8.4,
                homePage=  "https://www.godzillavskong.net",
                movieId="399566",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/hJuDvwzS0SPlsE6MNFOpznQltDZ.jpg",
                movieId= "527774",
                language= "en",
                overview= "Long ago, in the fantasy world of Kumandra, humans and dragons lived together in harmony. But when an evil force threatened the land, the dragons sacrificed themselves to save humanity. Now, 500 years later, that same evil has returned and it’s up to a lone warrior, Raya, to track down the legendary last dragon to restore the fractured land and its divided people.",
                imagePoster= "/lPsD10PP4rgUGiGR4CCXA6iY0QQ.jpg",
                releaseDate= "2021-03-03",
                title= "Raya and the Last Dragon",
                rating= 8.3,
                homePage= "https://movies.disney.com/raya-and-the-last-dragon",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/fev8UFNFFYsD5q7AcYS8LyTzqwl.jpg",
                movieId= "587807",
                language= "en",
                overview= "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
                imagePoster= "/6KErczPBROQty7QoIsaa6wJYXZi.jpg",
                releaseDate= "2021-02-11",
                title= "Tom & Jerry",
                rating= 7.4,
                homePage= "https://www.tomandjerrymovie.com",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/z8TvnEVRenMSTemxYZwLGqFofgF.jpg",
                movieId="458576",
                language= "en",
                overview= "A portal transports Cpt. Artemis and an elite unit of soldiers to a strange world where powerful monsters rule with deadly ferocity. Faced with relentless danger, the team encounters a mysterious hunter who may be their only hope to find a way home.",
                imagePoster= "/1UCOF11QCw8kcqvce8LKOO6pimh.jpg",
                releaseDate= "2020-12-03",
                title= "Monster Hunter",
                rating= 7.1,
                homePage= "https://www.monsterhunter.movie",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/uQtqiAu2bBlokqjlURVLEha6zoi.jpg",
                movieId="544401",
                language= "en",
                overview= "Cherry drifts from college dropout to army medic in Iraq - anchored only by his true love, Emily. But after returning from the war with PTSD, his life spirals into drugs and crime as he struggles to find his place in the world.",
                imagePoster= "/pwDvkDyaHEU9V7cApQhbcSJMG1w.jpg",
                releaseDate= "2021-02-26",
                title= "Cherry",
                rating= 7.6,
                homePage= "https://tv.apple.com/movie/umc.cmc.40gvwq6hnbilmnxuutvmejx4r",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/cjaOSjsjV6cl3uXdJqimktT880L.jpg",
                movieId="529203",
                language= "en",
                overview= "Searching for a safer habitat, the prehistoric Crood family discovers an idyllic, walled-in paradise that meets all of its needs. Unfortunately, they must also learn to live with the Bettermans -- a family that's a couple of steps above the Croods on the evolutionary ladder. As tensions between the new neighbors start to rise, a new threat soon propels both clans on an epic adventure that forces them to embrace their differences, draw strength from one another, and survive together.",
                imagePoster= "/tbVZ3Sq88dZaCANlUcewQuHQOaE.jpg",
                releaseDate= "2020-11-25",
                title= "The Croods: A New Age",
                rating= 7.5,
                homePage= "https://www.dreamworks.com/movies/the-croods-2",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/zDq2pwPyt4xwSFHKUoNN2LohDWj.jpg",
                movieId="632357",
                language= "en",
                overview= "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister.",
                imagePoster= "/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
                releaseDate= "2021-03-31",
                title= "The Unholy",
                rating= 6.1,
                homePage= "https://www.sonypictures.com/movies/theunholy",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/5NxjLfs7Bi07bfZCRl9CCnUw7AA.jpg",
                movieId="412656",
                language= "en",
                overview= "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
                imagePoster= "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
                releaseDate= "2021-02-24",
                title= "Chaos Walking",
                rating= 7.6,
                homePage= "https://chaoswalking.movie",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/vfuzELmhBjBTswXj2Vqxnu5ge4g.jpg",
                movieId="602269",
                language= "en",
                overview= "Deputy Sheriff Joe \"Deke\" Deacon joins forces with Sgt. Jim Baxter to search for a serial killer who's terrorizing Los Angeles. As they track the culprit, Baxter is unaware that the investigation is dredging up echoes of Deke's past, uncovering disturbing secrets that could threaten more than his case.",
                imagePoster= "/c7VlGCCgM9GZivKSzBgzuOVxQn7.jpg",
                releaseDate= "2021-01-28",
                title= "The Little Things",
                rating= 6.4,
                homePage= "https://www.thelittlethingsmovie.com",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/3ombg55JQiIpoPnXYb2oYdr6DtP.jpg",
                movieId="560144",
                language= "en",
                overview= "When a virus threatens to turn the now earth-dwelling friendly alien hybrids against humans, Captain Rose Corley must lead a team of elite mercenaries on a mission to the alien world in order to save what's left of humanity.",
                imagePoster= "/2W4ZvACURDyhiNnSIaFPHfNbny3.jpg",
                releaseDate= "2020-10-25",
                title= "Skylines",
                rating= 5.9,
                homePage= "",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/9Is9OrQUnKczCfsLSbsbx8YSmES.jpg",
                movieId="797394",
                language= "ru",
                overview= "The Secret Magic Control Agency sends its two best agents, Hansel and Gretel, to fight against the witch of the Gingerbread House.",
                imagePoster= "/4ZSzEDVdxWVMVO4oZDvoodQOEfr.jpg",
                releaseDate= "2021-03-18",
                title= "Secret Magic Control Agency",
                rating= 7.3,
                homePage= "https://www.netflix.com/title/81267965",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/u5WUCO6irZoq27qbYYrtLUrCGDV.jpg",
                movieId="630586",
                language= "en",
                overview= "Jen and a group of friends set out to hike the Appalachian Trail. Despite warnings to stick to the trail, the hikers stray off course—and cross into land inhabited by The Foundation, a hidden community of mountain dwellers who use deadly means to protect their way of life.",
                imagePoster= "/4U1SBHmwHkNA0eHZ2n1CuiC1K1g.jpg",
                releaseDate= "2021-01-26",
                title= "Wrong Turn",
                rating= 6.2,
                homePage= "",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/nz8xWrTKZzA5A7FgxaM4kfAoO1W.jpg",
                movieId="651571",
                language= "en",
                overview= "A hardened mechanic must stay awake and maintain an interstellar ark fleeing the dying planet Earth with a few thousand lucky souls on board... the last of humanity. Unfortunately, humans are not the only passengers. A shapeshifting alien creature has taken residence, its only goal is to kill as many people as possible. The crew must think quickly to stop this menace before it destroys mankind.",
                imagePoster= "/13B6onhL6FzSN2KaNeQeMML05pS.jpg",
                releaseDate= "2020-12-17",
                title= "Breach",
                rating= 4.6,
                homePage= "https://crediblepapers.com/writing-services/",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "",
                movieId="684369",
                language= "es",
                overview= "A fugitive film director in exile, called H, returns to the industrial city of which he fled in the past, in a time and place unknown. Gloria, the working woman who loved and left behind lives subjected to routine. But H, unable to adapt, convince her to run away together to a place that no one remembers the outside of civilization.",
                imagePoster= "/6Bp5EyQCunRumsswNyw9FzWM5Ji.jpg",
                releaseDate= "2019-11-05",
                title= "West",
                rating= 3.5,
                homePage= "http://www.occidente-film.com/",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/a9zFUuxzChmAlIybVge9IZt1hH0.jpg",
                movieId="578908",
                language= "en",
                overview= "Two pals embark on a road trip full of funny pranks that pull real people into mayhem.",
                imagePoster= "/A1Gy5HX3DKGaNW1Ay30NTIVJqJ6.jpg",
                releaseDate= "2021-03-26",
                title= "Bad Trip",
                rating= 6.0,
                homePage= "https://badtripthemovie.com/",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/nq4LRhGrCZ8ucxMaLMPa3uZV6ku.jpg",
                movieId="709629",
                language= "es",
                overview= "In order to advance her career in the dynamic world of publicity in Mexico City, Raquel tries to reunite with her high school friend Cecy who has become the queen of social media. But unlike followers, friendships do not come instantly.",
                imagePoster= "/jpdWHOu6EJbYnLXLCA52h82nLEz.jpg",
                releaseDate= "2021-03-12",
                title= "War of Likes",
                rating= 7.9,
                homePage= "",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/vQJ3yBdF91tzd73G8seL5bOxfvG.jpg",
                movieId="599281",
                language= "en",
                overview= "A teenage girl living with schizophrenia begins to suspect her neighbor has kidnapped a child. Her parents try desperately to help her live a normal life, without exposing their own tragic secrets, and the only person who believes her is Caleb – a boy she isn’t even sure exists.",
                imagePoster= "/b2shaNA4F8zNIwoRYr33lPTiFfl.jpg",
                releaseDate= "2021-02-12",
                title= "Fear of Rain",
                rating= 7.3,
                homePage= "https://cimalek.net/",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/las0P4Dua54XrZ73VQmGUaH1z0U.jpg",
                movieId="movieId",
                language= "ja",
                overview= "In the aftermath of the Fourth Impact, stranded without their Evangelions, Shinji, Asuka, and Rei search for refuge in the desolate red remains of Tokyo-3. But the danger to the world is far from over. A new impact is looming on the horizon—one that will prove to be the true end of Evangelion.",
                imagePoster= "/AoevYJSVtg15hntg8SYwWm2k3hP.jpg",
                releaseDate= "2021-03-08",
                title= "Evangelion: 3.0+1.0 Thrice Upon a Time",
                rating= 6.5,
                homePage= "https://www.evangelion.co.jp/final.html",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/sNKnz0ZU8u55yCFreZUSOIBMSuY.jpg",
                movieId="638597",
                language= "en",
                overview= "A mom and dad who usually say no decide to say yes to their kids' wildest requests — with a few ground rules — on a whirlwind day of fun and adventure.",
                imagePoster= "/rejrD9ovTHJbfmpLM0mbEliEPV6.jpg",
                releaseDate= "2021-03-12",
                title= "Yes Day",
                rating= 7.0,
                homePage= "https://www.netflix.com/title/81011712",
                favorited = false
            )
        )
        movies.add(
            MovieEntity(
                imageBackdrop= "/7TxeZVg2evMG42p0uSbMJpWNQ8A.jpg",
                movieId="520946",
                language= "en",
                overview= "Freddy Lupin, heir to a proud family line of werewolves, is in for a shock when on his 14th birthday his first 'warfing' goes awry, turning him into a ferocious poodle. The pack elders give Freddy until the next moonrise to prove he has the heart of a wolf, or risk being cast out forever. With the help of an unlikely ally in a streetwise stray named Batty, Freddy must prove he's 100% Wolf.",
                imagePoster= "/2VrvxK4yxNCU6KVgo5TADJeBEQu.jpg",
                releaseDate= "2020-06-26",
                title= "100% Wolf",
                rating= 5.7,
                homePage= "https://www.screenaustralia.gov.au/the-screen-guide/t/100--wolf-2019/34581",
                favorited = false
            )
        )

        return movies
    }

    fun generateTvShowsAiringToday(): List<TvShowEntity>{
        val tvShows = ArrayList<TvShowEntity>()
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/edmk8xjGBsYVIf4QtLY9WMaMcXZ.jpg",
                firstAirDate = "2005-03-27",
                title = "Grey's Anatomy",
                language = "en",
                overview = "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                imagePoster = "/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                rating = 8.2,
                homePage = "http://abc.go.com/shows/greys-anatomy",
                tvShowId = "1416",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/fRYwdeNjMqC30EhofPx5PlDpdun.jpg",
                firstAirDate = "2018-10-25",
                title = "Legacies",
                language = "en",
                overview = "In a place where young witches, vampires, and werewolves are nurtured to be their best selves in spite of their worst impulses, Klaus Mikaelson’s daughter, 17-year-old Hope Mikaelson, Alaric Saltzman’s twins, Lizzie and Josie Saltzman, among others, come of age into heroes and villains at The Salvatore School for the Young and Gifted.",
                imagePoster = "/qTZIgXrBKURBK1KrsT7fe3qwtl9.jpg",
                rating = 8.6,
                homePage = "http://www.cwtv.com/shows/legacies",
                tvShowId = "79460",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/qPO43E0tnw9Gjh9EzkNmc3AKlE3.jpg",
                firstAirDate = "2018-03-22",
                title = "Station 19",
                language = "en",
                overview = "A group of heroic firefighters at Seattle Fire Station 19—from captain to newest recruit—risk their lives and hearts both in the line of duty and off the clock. These brave men and women are like family, literally and figuratively, and together they put their own lives in jeopardy as first responders to save the lives of others.",
                imagePoster = "/lcuCED5Ky2uM5VE6wILOwt5FEb0.jpg",
                rating = 8.2,
                homePage = "http://abc.go.com/shows/station-19",
                tvShowId = "76773",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/W5geO8tq68ng4TsXyZ81phcPiz.jpg",
                firstAirDate = "2012-10-10",
                title = "Chicago Fire",
                language = "en",
                overview = "An edge-of-your-seat view into the lives of everyday heroes committed to one of America's noblest professions. For the firefighters, rescue squad and paramedics of Chicago Firehouse 51, no occupation is more stressful or dangerous, yet so rewarding and exhilarating. These courageous men and women are among the elite who forge headfirst into danger when everyone else is running the other way and whose actions make the difference between life and death.",
                imagePoster = "/6AccYL0eb7uzHn98IKaNjvJbyuA.jpg",
                rating = 8.4,
                homePage = "http://www.nbc.com/chicago-fire",
                tvShowId = "44006",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/s2IXx944vnZUtAxC2nPydOfqakh.jpg",
                firstAirDate = "2021-01-21",
                title = "Walker",
                language = "en",
                overview = "Reboot of the 1993 series focusing on Walker as he returns from years undercover. A widower and father of two, he begins fighting crime with a new partner, who is one of the only female Rangers in history.",
                imagePoster = "/y4VHQbbY1UcAjHN7UTGu0MGyVl2.jpg",
                rating = 6.9,
                homePage = "https://www.cwtv.com/shows/walker",
                tvShowId = "99121",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/cD9PxbrdWYgL7MUpD9eOYuiSe2P.jpg",
                firstAirDate = "1999-09-20",
                title = "Law & Order: Special Victims Unit",
                language = "en",
                overview = "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
                imagePoster = "/jDCgWVlejIo8sQYxw3Yf1cVQUIL.jpg",
                rating = 7.8,
                homePage = "http://www.nbc.com/law-and-order-special-victims-unit",
                tvShowId = "2734",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/f9eLOgAiN8x7nFXbedYxb3KCKxR.jpg",
                firstAirDate = "2014-01-08",
                title = "Chicago P.D.",
                language = "en",
                overview = "A riveting police drama about the men and women of the Chicago Police Department's District 21 who put it all on the line to serve and protect their community. District 21 is made up of two distinctly different groups: the uniformed cops who patrol the beat and go head-to-head with the city's street crimes and the Intelligence Unit that combats the city's major offenses - organized crime, drug trafficking, high profile murders and beyond.",
                imagePoster = "/OlPR1kctwXzSUJQkZINDDhNlHV.jpg",
                rating = 8.4,
                homePage = "http://www.nbc.com/chicago-pd",
                tvShowId = "58841",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/xVt9ADgKoJMzQ7eVXiFYMbXU85E.jpg",
                firstAirDate = "2020-04-28",
                title = "100 días para enamorarnos",
                language = "es",
                overview = "Two couples who struggle to be near each other decide to give another chance for each other, 100 days for them to fall back in love.",
                imagePoster = "/r13t1ohRQAlZpsjxgTKY7ypkWPc.jpg",
                rating = 7.7,
                homePage = "https://www.telemundo.com/series-y-novelas/100-dias-para-enamorarnos",
                tvShowId = "102966",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/nlDBlCtorM7nx130wYnfR5ZmyLX.jpg",
                firstAirDate = "2017-09-25",
                title = "Young Sheldon",
                language = "en",
                overview = "The early life of child genius Sheldon Cooper, later seen in The Big Bang Theory.",
                imagePoster = "/aESxB2HblKlDzma39xVefa20pbW.jpg",
                rating = 8.0,
                homePage = "http://www.cbs.com/shows/young-sheldon/",
                tvShowId = "71728",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/iCBMJZFsdXALgpS121qu4CAe2Sa.jpg",
                firstAirDate = "2017-09-27",
                title = "SEAL Team",
                language = "en",
                overview = "The lives of the elite Navy Seals as they train, plan and execute the most dangerous, high-stakes missions our country can ask.",
                imagePoster = "/uTSLeQTeHevt4fplegmQ6bOnE0Z.jpg",
                rating = 7.8,
                homePage = "http://www.cbs.com/shows/seal-team/",
                tvShowId = "71789",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/gJSqr2prvTegFbL0cEWK9Qti3Vs.jpg",
                firstAirDate = "2017-11-02",
                title = "S.W.A.T.",
                language = "en",
                overview = "A locally born and bred S.W.A.T. lieutenant is torn between loyalty to the streets and duty to his fellow officers when he's tasked to run a highly-trained unit that's the last stop for solving crimes in Los Angeles.",
                imagePoster = "/ushSkKB8aeLsyyW2c7S7CCmEmRA.jpg",
                rating = 7.7,
                homePage = "http://www.cbs.com/shows/swat/",
                tvShowId = "71790",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/hBYvHCcZX4dyvXeM0NTBh5uJIk3.jpg",
                firstAirDate = "2019-01-08",
                title = "Good Trouble",
                language = "en",
                overview = "After moving to The Coterie in Downtown Los Angeles, Callie and Mariana Foster realize that living on their own is not all that it’s cracked up to be.",
                imagePoster = "/b9OwPQZr4dVv7K8SrUbAYJ35uLg.jpg",
                rating = 7.9,
                homePage = "https://freeform.go.com/shows/good-trouble",
                tvShowId = "80006",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/sHjNS2lYyEjwjjQXTZmdyMJ29bI.jpg",
                firstAirDate = "2015-11-17",
                title = "Chicago Med",
                language = "en",
                overview = "An emotional thrill ride through the day-to-day chaos of the city's most explosive hospital and the courageous team of doctors who hold it together. They will tackle unique new cases inspired by topical events, forging fiery relationships in the pulse-pounding pandemonium of the emergency room.",
                imagePoster = "/8mFhW6fJlapqq3cmQjxcG5h4KFa.jpg",
                rating = 8.2,
                homePage = "http://www.nbc.com/chicago-med",
                tvShowId = "62650",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/ibAYMuyRodgOYTeHGQqh6WCh5JU.jpg",
                firstAirDate = "2021-04-01",
                title = "Shaman King",
                language = "ja",
                overview = "The Shaman King is the one who can contact the king of spirits and reshape the world. Every 500 years, shamans, who can commune between the worlds of the living and dead, compete in the Shaman Fight to become the next Shaman King.\n\nAmong those aiming for the top is a young shaman named Yoh Asakura.",
                imagePoster = "/rFFsdLlwyclyM83ALobrfMhr28A.jpg",
                rating = 8.3,
                homePage = "https://shamanking-project.com/",
                tvShowId = "104699",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/owvL8PxjIvU4X83mJ4Z7aYMVBmw.jpg",
                firstAirDate = "2021-04-07",
                title = "Super Cub",
                language = "ja",
                overview = "Koguma is a high school girl in Yamanashi. She has no parents, friends, or hobbies, and her daily life is empty. One day, Koguma gets a used Honda Super Cub motorcycle. This is her first time going to school on a motorcycle. Running out of gas and hitting detours become a small source of adventure in Koguma's life. She is satisfied with this strange transformation, but her classmate Reiko ends up talking to her about how she also goes to school by motorcycle. One Super Cub begins to open up a lonely girl's world, introducing her to a new everyday life and friendship.",
                imagePoster = "/h36KQWhJEZuVptk0WBuSVXhuiD8.jpg",
                rating = 0.0,
                homePage = "https://supercub-anime.com",
                tvShowId = "95631",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/zd3BxI5qC8U2Feg83H4tLkwLcfg.jpg",
                firstAirDate = "2018-10-04",
                title = "Zombie Land Saga",
                language = "ja",
                overview = "A typical morning. The usual music. Their normal lives. The peace these seven girls experience will suddenly be destroyed. By the living dead... zombies. A reality that they never wanted a part of, an amazing and terrifying zombie world. They all share one wish: \"We want to live.\" These girls will struggle through this saga, in order to achieve a miracle.",
                imagePoster = "/c62Myh7wxmAUabqmCje8u9mbVIO.jpg",
                rating = 8.4,
                homePage = "https://www.zombielandsaga.com/",
                tvShowId = "82822",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/cvFnG5roIAopSFkHvVnPMHWO01s.jpg",
                firstAirDate = "2021-04-07",
                title = "Full Dive: This Ultimate Next-Gen Full Dive RPG is Even Shittier than Real Life!",
                language = "ja",
                overview = "In an unexpected turn of events, dull high school student Hiro Yuuki obtains the full dive role-playing game Kiwame Quest. Created by the best of technology, the game claims to take \"reality to its extremes,\" from stunning graphics, NPCs' behavior, to the scent of vegetation, and even the sensation of wind brushing against the skin—everything was the result of an ultimate workmanship.\n\nExcept, the game is a little too realistic and messy to clear. Kiwame Quest features over ten quadrillion flags and reflects the players' real-life physical abilities in the game. Being hit in the game also hurts in real life and slash wounds take days to heal.\n\nThe only reward here is the sense of accomplishment. Conquer the most stressful game in history that can't be played casually!",
                imagePoster = "/6pRbPIGuBAZDjblqhDl6U4CUQxI.jpg",
                rating = 0.0,
                homePage = "https://fulldive-rpg.com",
                tvShowId = "114198",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/3ib0uov9Qq9JtTIEGL39irTa3vZ.jpg",
                firstAirDate = "2018-09-24",
                title = "Manifest",
                language = "en",
                overview = "After landing from a turbulent but routine flight, the crew and passengers of Montego Air Flight 828 discover five years have passed in what seemed like a few hours. As their new realities become clear, a deeper mystery unfolds and some of the returned passengers soon realize they may be meant for something greater than they ever thought possible.",
                imagePoster = "/1xeiUxShzNn8TNdMqy3Hvo9o2R.jpg",
                rating = 7.7,
                homePage = "https://www.nbc.com/manifest",
                tvShowId = "79696",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/q79U95wgkocoECitZPfRDhZXBNz.jpg",
                firstAirDate = "2007-10-14",
                title = "Keeping Up with the Kardashians",
                language = "en",
                overview = "A peek inside the exploits and privileged private lives of the blended Kardashian-Jenner family, including sisters Kim, Kourtney and Khloé.",
                imagePoster = "/nddXOC8wYpIDv7giLzjjqIg8WDA.jpg",
                rating = 5.0,
                homePage = "http://www.eonline.com/shows/kardashians",
                tvShowId = "14814",
                favorited = false
            )
        )
        tvShows.add(
            TvShowEntity(
                imageBackdrop = "/2Ib8kvWa9gGhJrAfGlhIvbmtbWn.jpg",
                firstAirDate = "2010-11-08",
                title = "Conan",
                language = "en",
                overview = "A late night television talk show hosted by Conan O'Brien.",
                imagePoster = "/e0QI3XHKO0n70U3mxBdHf8uoxie.jpg",
                rating = 7.3,
                homePage = "http://www.teamcoco.com",
                tvShowId = "32415",
                favorited = false
            )
        )

        return tvShows
    }

    fun generateRemoteMovieOtherMovies(movieId: String): List<OtherMoviesResponse> {
        val otherMovies = ArrayList<OtherMoviesResponse>()
        otherMovies.add(
            OtherMoviesResponse(
                detailMovieId = "{$movieId}m1",
                movieId = movieId,
                title = "Venom: Let There Be Carnage",
                imagePoster = "/lNyLSOKMMeUPr1RsL4KcRuIXwHt.jpg",
                year = "2021",
                rating = 7.2,
                position = 0
            )
        )

        otherMovies.add(
            OtherMoviesResponse(
                detailMovieId = "{$movieId}m2",
                movieId = movieId,
                title = "Free Guy",
                imagePoster = "/xmbU4JTUm8rsdtn7Y3Fcm30GpeT.jpg",
                year = "2021",
                rating = 7.8,
                position = 1
            )
        )

        otherMovies.add(
            OtherMoviesResponse(
                detailMovieId = "{$movieId}m3",
                movieId = movieId,
                title = "Solitary",
                imagePoster = "/ApwmbrMlsuOay5rXQA4Kbz7qJAl.jpg",
                year = "2021",
                rating = 6.6,
                position = 2
            )
        )

        otherMovies.add(
            OtherMoviesResponse(
                detailMovieId = "{$movieId}m4",
                movieId = movieId,
                title = "A Man Called Ove",
                imagePoster = "/pXqnqw4V1Rly2HEacfl07d5DcUE.jpg",
                year = "2016",
                rating = 5.6,
                position = 3
            )
        )

        otherMovies.add(
            OtherMoviesResponse(
                detailMovieId = "{$movieId}m5",
                movieId = movieId,
                title = "Lights Out",
                imagePoster = "/rxXA5vwJElXQ8BgrB0pocUcuqFA.jpg",
                year = "2016",
                rating = 6.1,
                position = 4
            )
        )
        
        return otherMovies
    }

    fun generateDummyMovieOtherMovies(movieId: String): List<OtherMoviesEntity> {
        val otherMovies = ArrayList<OtherMoviesEntity>()
        otherMovies.add(
            OtherMoviesEntity(
                detailMovieId = "{$movieId}m1",
                movieId = movieId,
                title = "Venom: Let There Be Carnage",
                imagePoster = "/lNyLSOKMMeUPr1RsL4KcRuIXwHt.jpg",
                year = "2021",
                rating = 7.2,
                position = 0)
        )

        otherMovies.add(
            OtherMoviesEntity(
                detailMovieId = "{$movieId}m2",
                movieId = movieId,
                title = "Free Guy",
                imagePoster = "/xmbU4JTUm8rsdtn7Y3Fcm30GpeT.jpg",
                year = "2021",
                rating = 7.8,
                position = 1
            )
        )

        otherMovies.add(
            OtherMoviesEntity(
                detailMovieId = "{$movieId}m3",
                movieId = movieId,
                title = "Solitary",
                imagePoster = "/ApwmbrMlsuOay5rXQA4Kbz7qJAl.jpg",
                year = "2021",
                rating = 6.6,
                position = 2
            )
        )

        otherMovies.add(
            OtherMoviesEntity(
                detailMovieId = "{$movieId}m4",
                movieId = movieId,
                title = "A Man Called Ove",
                imagePoster = "/pXqnqw4V1Rly2HEacfl07d5DcUE.jpg",
                year = "2016",
                rating = 5.6,
                position = 3
            )
        )

        otherMovies.add(
            OtherMoviesEntity(
                detailMovieId = "{$movieId}m5",
                movieId = movieId,
                title = "Lights Out",
                imagePoster = "/rxXA5vwJElXQ8BgrB0pocUcuqFA.jpg",
                year = "2016",
                rating = 6.1,
                position = 4
            )
        )

        return otherMovies
    }

    fun generateRemoteTvShowOtherTvShows(tvShowId: String): List<OtherTvShowsResponse> {
        val otherTvShows = ArrayList<OtherTvShowsResponse>()
        otherTvShows.add(
            OtherTvShowsResponse(
                detailTvShowId = "{$tvShowId}m1",
                tvShowId = tvShowId,
                title = "Venom: Let There Be Carnage",
                imagePoster = "/lNyLSOKMMeUPr1RsL4KcRuIXwHt.jpg",
                year = "2021",
                rating = 7.2,
                position = 0)
        )

        otherTvShows.add(
            OtherTvShowsResponse(
                detailTvShowId = "{$tvShowId}m2",
                tvShowId = tvShowId,
                title = "Free Guy",
                imagePoster = "/xmbU4JTUm8rsdtn7Y3Fcm30GpeT.jpg",
                year = "2021",
                rating = 7.8,
                position = 1
            )
        )

        otherTvShows.add(
            OtherTvShowsResponse(
                detailTvShowId = "{$tvShowId}m3",
                tvShowId = tvShowId,
                title = "Solitary",
                imagePoster = "/ApwmbrMlsuOay5rXQA4Kbz7qJAl.jpg",
                year = "2021",
                rating = 6.6,
                position = 2
            )
        )

        otherTvShows.add(
            OtherTvShowsResponse(
                detailTvShowId = "{$tvShowId}m4",
                tvShowId = tvShowId,
                title = "A Man Called Ove",
                imagePoster = "/pXqnqw4V1Rly2HEacfl07d5DcUE.jpg",
                year = "2016",
                rating = 5.6,
                position = 3
            )
        )

        otherTvShows.add(
            OtherTvShowsResponse(
                detailTvShowId = "{$tvShowId}m5",
                tvShowId = tvShowId,
                title = "Lights Out",
                imagePoster = "/rxXA5vwJElXQ8BgrB0pocUcuqFA.jpg",
                year = "2016",
                rating = 6.1,
                position = 4
            )
        )

        return otherTvShows
    }

    fun generateDummyTvShowOtherTvShows(tvShowId: String): List<OtherTvShowsEntity> {
        val otherTvShows = ArrayList<OtherTvShowsEntity>()
        otherTvShows.add(
            OtherTvShowsEntity(
                detailTvShowsId = "{$tvShowId}m1",
                tvShowId = tvShowId,
                title = "Venom: Let There Be Carnage",
                imagePoster = "/lNyLSOKMMeUPr1RsL4KcRuIXwHt.jpg",
                year = "2021",
                rating = 7.2,
                position = 0)
        )

        otherTvShows.add(
            OtherTvShowsEntity(
                detailTvShowsId = "{$tvShowId}m2",
                tvShowId = tvShowId,
                title = "Free Guy",
                imagePoster = "/xmbU4JTUm8rsdtn7Y3Fcm30GpeT.jpg",
                year = "2021",
                rating = 7.8,
                position = 1
            )
        )

        otherTvShows.add(
            OtherTvShowsEntity(
                detailTvShowsId = "{$tvShowId}m3",
                tvShowId = tvShowId,
                title = "Solitary",
                imagePoster = "/ApwmbrMlsuOay5rXQA4Kbz7qJAl.jpg",
                year = "2021",
                rating = 6.6,
                position = 2
            )
        )

        otherTvShows.add(
            OtherTvShowsEntity(
                detailTvShowsId = "{$tvShowId}m4",
                tvShowId = tvShowId,
                title = "A Man Called Ove",
                imagePoster = "/pXqnqw4V1Rly2HEacfl07d5DcUE.jpg",
                year = "2016",
                rating = 5.6,
                position = 3
            )
        )

        otherTvShows.add(
            OtherTvShowsEntity(
                detailTvShowsId = "{$tvShowId}m5",
                tvShowId = tvShowId,
                title = "Lights Out",
                imagePoster = "/rxXA5vwJElXQ8BgrB0pocUcuqFA.jpg",
                year = "2016",
                rating = 6.1,
                position = 4
            )
        )

        return otherTvShows
    }

    fun generateDummyMovieWithOtherMovies(
        movie: MovieEntity,
        isFavorite: Boolean
    ): MovieWithOtherMovies {
        movie.favorited = isFavorite
        return MovieWithOtherMovies(movie, generateDummyMovieOtherMovies(movie.movieId))
    }

    fun generateDummyTvShowWithOtherTvShows(
        tvShow: TvShowEntity,
        isFavorite: Boolean
    ): TvShowWithOtherTvShows {
        tvShow.favorited = isFavorite
        return TvShowWithOtherTvShows(tvShow, generateDummyTvShowOtherTvShows(tvShow.tvShowId))
    }
}