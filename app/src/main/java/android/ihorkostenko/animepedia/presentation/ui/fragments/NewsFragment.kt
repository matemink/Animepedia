package android.ihorkostenko.animepedia.presentation.ui.fragments

import android.content.Intent
import android.ihorkostenko.animepedia.domain.entities.Article
import android.ihorkostenko.animepedia.domain.entities.News
import android.ihorkostenko.animepedia.presentation.ui.adapters.NewsRecyclerViewAdapter
import android.ihorkostenko.animepedia.presentation.ui.viewmodels.NewsViewModel
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import animepedia.android.ihorkostenko.animepedia.R
import kotlinx.android.synthetic.main.fragment_characters_list.*
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.recyclerview.widget.DividerItemDecoration



class NewsFragment : Fragment() {
    companion object {
        fun newInstance() = NewsFragment()
    }

    private val newsViewModel: NewsViewModel by viewModel()
    private val newsRecyclerViewAdapter = NewsRecyclerViewAdapter(ArrayList())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listener = object : NewsRecyclerViewAdapter.OnItemClickListener {
            override fun onClick(item: Article) {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse(item.url)
                startActivity(openURL)
            }
        }
        newsRecyclerViewAdapter.setOnItemClickListener(listener)

        recyclerView.adapter = newsRecyclerViewAdapter
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context,  LinearLayout.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

        newsViewModel.init()
        newsViewModel.news.observe(this, Observer<News> { news ->
            if (view is RecyclerView) {
                activity?.progressBar?.visibility = View.GONE
                news?.articles?.let { newsRecyclerViewAdapter.newValue(it) }
            }
        })
    }
}


















































































































































