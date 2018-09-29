package android.ihorkostenko.animepedia

import android.ihorkostenko.animepedia.data.datasource.AnimeApiDataSource
import android.ihorkostenko.animepedia.di.apiDataSource
import android.ihorkostenko.animepedia.di.apiDataSourceModule
import android.ihorkostenko.animepedia.di.mainModule
import android.ihorkostenko.animepedia.di.okHttpClient
import android.ihorkostenko.animepedia.domain.Repository
import android.ihorkostenko.animepedia.domain.entities.Characters
import android.ihorkostenko.animepedia.presentation.ui.viewmodels.*
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import org.junit.*
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.standalone.get
import org.koin.standalone.inject
import org.koin.test.KoinTest
import org.koin.test.checkModules
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.concurrent.TimeUnit

class KoinTests : KoinTest {

    private val charactersViewModel: CharactersViewModel by inject()
    private val repository: Repository by inject()

    @Mock
    lateinit var uiData: Observer<Characters>

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun before() {
        startKoin(listOf(apiDataSourceModule, mainModule))
        MockitoAnnotations.initMocks(this)
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun `check module`() {
        checkModules((listOf(apiDataSourceModule, mainModule)))
    }


    @Test
    fun `should inject my components`() {
        Assert.assertNotNull(get<Repository>())

        Assert.assertNotNull(get<CharactersViewModel>())
        Assert.assertNotNull(get<EpisodesViewModel>())
        Assert.assertNotNull(get<NewsViewModel>())
        Assert.assertNotNull(get<PicturesViewModel>())
        Assert.assertNotNull(get<VideosViewModel>())

        Assert.assertNotNull(okHttpClient())
        Assert.assertNotNull(apiDataSource<AnimeApiDataSource>(get()))
    }

    @Test
    fun testGotDetail() {
        //Setup data
        val characters = repository.getCharacters()

        //Observe
        charactersViewModel.init()
        charactersViewModel.characters.observeForever(uiData)

        TimeUnit.SECONDS.sleep(3)

        val character = characters.value

        Assert.assertNotNull(charactersViewModel.characters)

        Mockito.verify(uiData).onChanged(character)
    }
}
