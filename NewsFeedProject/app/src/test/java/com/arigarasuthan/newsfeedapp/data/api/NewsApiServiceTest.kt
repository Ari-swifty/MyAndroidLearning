package com.arigarasuthan.newsfeedapp.data.api

import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApiServiceTest {
    private lateinit var service: NewsApiService
    private lateinit var server:MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }

    private fun enqueueMockResponse(fileName:String) {
        val inputStream = javaClass.classLoader.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadlines_sentRequest_receivedExpected() {
        runBlocking {
            enqueueMockResponse("newsResponse.json")
            val response = service.getTopHeadlines("us",1).body()
            val request = server.takeRequest()
            Truth.assertThat(response).isNotNull()
            Truth.assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=065c2cbb55824fec8117035a5237c3e9")
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctPageSize() {
        runBlocking {
            enqueueMockResponse("newsResponse.json")
            val response = service.getTopHeadlines("us",1).body()
            val articleList = response?.articles
            Truth.assertThat(articleList?.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctContent() {
        runBlocking {
            enqueueMockResponse("newsResponse.json")
            val response = service.getTopHeadlines("us",1).body()
            val articleList = response?.articles
            val article = articleList?.get(0)
            Truth.assertThat(article?.author).isEqualTo("Holly Ellyatt")
            Truth.assertThat(article?.url).isEqualTo("https://www.cnbc.com/2023/05/10/putins-one-tank-military-parade-was-an-embarrassment-for-russia.html")
            Truth.assertThat(article?.publishedAt).isEqualTo("2023-05-10T09:10:38Z")

        }
    }


    @After
    fun tearDown() {
        server.shutdown()
    }
}