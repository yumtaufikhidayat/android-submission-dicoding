package com.yumtaufikhidayat.gitser.data

object UserData {

    private val profileImage = arrayOf(
        "https://avatars.githubusercontent.com/u/1?v=4",
        "https://avatars.githubusercontent.com/u/2?v=4",
        "https://avatars.githubusercontent.com/u/3?v=4",
        "https://avatars.githubusercontent.com/u/4?v=4",
        "https://avatars.githubusercontent.com/u/5?v=4",
        "https://avatars.githubusercontent.com/u/6?v=4",
        "https://avatars.githubusercontent.com/u/7?v=4",
        "https://avatars.githubusercontent.com/u/17?v=4",
        "https://avatars.githubusercontent.com/u/18?v=4",
        "https://avatars.githubusercontent.com/u/19?v=4"
    )

    private val username = arrayOf(
        "mojombo",
        "defunkt",
        "pjhyett",
        "wycats",
        "ezmobius",
        "ivey",
        "evanphx",
        "vanpelt",
        "wayneeseguin",
        "brynary"
    )

    private val profileName = arrayOf(
        "Tom Preston Werner",
        "Chris Wanstrath",
        "PJ Hyett",
        "Yehuda Katz",
        "Ezra Zygmuntowicz",
        "Michael D. Ivey",
        "Evan Phoenix",
        "Chris Van Pelt",
        "Wayne E. Seguin",
        "Bryan Helmkamp"
    )

    private val following = arrayOf(
        11,
        210,
        30,
        5,
        13,
        2,
        7,
        15,
        17,
        27
    )

    private val followers = arrayOf(
        22824,
        21367,
        8223,
        9891,
        521,
        128,
        1433,
        151,
        715,
        645
    )

    private val repositories = arrayOf(
        63,
        107,
        8,
        249,
        22,
        88,
        168,
        57,
        98,
        165
    )

    private val location = arrayOf(
        "San Fransisco",
        "",
        "San Fransisco",
        "Portlan, OR",
        "In the NW",
        "Tuscumbia, AL",
        "Los Angeles, CA",
        "San Fransisco",
        "Buffalo, NY",
        "New York City"
    )

    private val office = arrayOf(
        "@chatterbugapp, @redwoodjs, @preston-werner",
        "",
        "Github, Inc.",
        "@tildeio",
        "Stuffstr PBC",
        "@RiotGames",
        "@hashicorp",
        "crowdflower.com",
        "http://starkandwayne.com",
        "Code Climate"
    )

    val listUserData: ArrayList<User>
        get() {
            val list = arrayListOf<User>()
            for (position in username.indices) {
                val user = User()
                user.profileImage = profileImage[position]
                user.username = username[position]
                user.profileName = profileName[position]
                user.following = following[position]
                user.followers = followers[position]
                user.repositories = repositories[position]
                user.location = location[position]
                user.office = office[position]
                list.add(user)
            }

            return list
        }
}