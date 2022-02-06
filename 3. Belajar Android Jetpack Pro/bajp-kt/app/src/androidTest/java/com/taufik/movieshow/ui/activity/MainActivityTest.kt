package com.taufik.movieshow.ui.activity

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.google.android.material.tabs.TabLayout
import com.taufik.movieshow.R
import com.taufik.movieshow.utils.DataDummy
import com.taufik.movieshow.utils.EspressoIdlingResource
import org.hamcrest.core.AllOf.allOf
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    private val dummyMovies = DataDummy.generateMovieNowPlaying()
    private val dummyTvShows = DataDummy.generateTvShowsAiringToday()

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.nav_movie)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.rvMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.nav_movie)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.imgMovieBackdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.imgMoviePoster)).check(matches(isDisplayed()))
        onView(withId(R.id.tvMovieTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvMovieTitle)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.tvMovieReleaseDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvMovieReleaseDate)).check(matches(withText(dummyMovies[0].releaseDate)))
        onView(withId(R.id.tvMovieOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.tvMovieOverview)).check(matches(withText(dummyMovies[0].overview)))
        onView(withId(R.id.tvMovieRating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvMovieRating)).check(matches(withText(dummyMovies[0].rating.toString())))
        onView(withId(R.id.tvMovieLanguage)).check(matches(isDisplayed()))
        onView(withId(R.id.tvMovieLanguage)).check(matches(withText(dummyMovies[0].language)))
        onView(withId(R.id.tvMovieReadMore)).perform(click())
        onView(withId(R.id.rvTopMovieShow)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShows() {
        onView(withId(R.id.nav_tv_show)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.rvTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size)
        )
    }

    @Test
    fun loadDetailTvShows() {
        onView(withId(R.id.nav_tv_show)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size))
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.imgTvShowBackdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.imgTvShowPoster)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTvShowTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTvShowTitle)).check(matches(withText(dummyTvShows[0].title)))
        onView(withId(R.id.tvTvShowReleaseDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTvShowReleaseDate)).check(matches(withText(dummyTvShows[0].firstAirDate)))
        onView(withId(R.id.tvTvShowOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTvShowOverview)).check(matches(withText(dummyTvShows[0].overview)))
        onView(withId(R.id.tvTvShowRating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTvShowRating)).check(matches(withText(dummyTvShows[0].rating.toString())))
        onView(withId(R.id.tvTvShowLanguage)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTvShowLanguage)).check(matches(withText(dummyTvShows[0].language)))
        onView(withId(R.id.tvTvShowLanguage)).perform(click())
        onView(withId(R.id.tvTvShowReadMore)).perform(click())
        onView(withId(R.id.rvTopMovieShow)).check(matches(isDisplayed()))
    }

    @Test
    fun loadFavoriteMovies() {
        onView(withId(R.id.nav_favorite)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.tabLayoutFavorite)).perform(selectTabAtPosition(0))
        onView(withId(R.id.rvFavoriteMovie)).check(matches(isDisplayed()))
        onView(withId(R.id.rvFavoriteMovie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailFavoriteMovies() {
        onView(withId(R.id.nav_movie)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.rvMovie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.nav_favorite)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.tabLayoutFavorite)).perform(selectTabAtPosition(0))
        onView(withId(R.id.rvFavoriteMovie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.imgMovieBackdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.imgMoviePoster)).check(matches(isDisplayed()))
        onView(withId(R.id.tvMovieTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvMovieTitle)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.tvMovieReleaseDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvMovieReleaseDate)).check(matches(withText(dummyMovies[0].releaseDate)))
        onView(withId(R.id.tvMovieOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.tvMovieOverview)).check(matches(withText(dummyMovies[0].overview)))
        onView(withId(R.id.tvMovieRating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvMovieRating)).check(matches(withText(dummyMovies[0].rating.toString())))
        onView(withId(R.id.tvMovieLanguage)).check(matches(isDisplayed()))
        onView(withId(R.id.tvMovieLanguage)).check(matches(withText(dummyMovies[0].language)))
        onView(withId(R.id.tvMovieReadMore)).perform(click())
        onView(withId(R.id.rvTopMovieShow)).check(matches(isDisplayed()))
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(pressBack())
    }

    @Test
    fun loadFavoriteTvShows() {
        onView(withId(R.id.nav_favorite)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.tabLayoutFavorite)).perform(selectTabAtPosition(1))
        onView(withId(R.id.tabLayoutFavorite)).perform(swipeRight())
        onView(withId(R.id.rvFavoriteTvShow)).check(matches(isDisplayed()))
        onView(withId(R.id.rvFavoriteTvShow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShows.size))
    }

    @Test
    fun loadDetailFavoriteTvShows() {
        onView(withId(R.id.nav_tv_show)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.rvTvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.nav_favorite)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.tabLayoutFavorite)).perform(selectTabAtPosition(1))
        onView(withId(R.id.tabLayoutFavorite)).perform(swipeLeft())
        onView(withId(R.id.rvFavoriteTvShow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.imgTvShowBackdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.imgTvShowPoster)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTvShowTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTvShowTitle)).check(matches(withText(dummyTvShows[0].title)))
        onView(withId(R.id.tvTvShowReleaseDate)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTvShowReleaseDate)).check(matches(withText(dummyTvShows[0].firstAirDate)))
        onView(withId(R.id.tvTvShowOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTvShowOverview)).check(matches(withText(dummyTvShows[0].overview)))
        onView(withId(R.id.tvTvShowRating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTvShowRating)).check(matches(withText(dummyTvShows[0].rating.toString())))
        onView(withId(R.id.tvTvShowLanguage)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTvShowLanguage)).check(matches(withText(dummyTvShows[0].language)))
        onView(withId(R.id.tvTvShowLanguage)).perform(click())
        onView(withId(R.id.tvTvShowReadMore)).perform(click())
        onView(withId(R.id.rvTopMovieShow)).check(matches(isDisplayed()))
        onView(withId(R.id.action_favorite)).perform(click())
        onView(isRoot()).perform(pressBack())
    }

    private fun selectTabAtPosition(tabIndex: Int): ViewAction {
        return object : ViewAction {
            override fun getDescription() = "with tab at index $tabIndex"

            override fun getConstraints() = allOf(isDisplayed(), isAssignableFrom(TabLayout::class.java))

            override fun perform(uiController: UiController, view: View) {
                val tabLayout = view as TabLayout
                val tabAtIndex: TabLayout.Tab = tabLayout.getTabAt(tabIndex)
                    ?: throw PerformException.Builder()
                        .withCause(Throwable("No tab at index $tabIndex"))
                        .build()

                tabAtIndex.select()
            }
        }
    }
}