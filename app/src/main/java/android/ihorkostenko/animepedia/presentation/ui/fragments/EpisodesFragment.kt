package android.ihorkostenko.animepedia.presentation.ui.fragments

import android.content.Intent
import android.ihorkostenko.animepedia.domain.entities.Article
import android.ihorkostenko.animepedia.domain.entities.Episode
import android.ihorkostenko.animepedia.domain.entities.Episodes
import android.ihorkostenko.animepedia.presentation.ui.adapters.EpisodesRecyclerViewAdapter
import android.ihorkostenko.animepedia.presentation.ui.adapters.NewsRecyclerViewAdapter
import android.ihorkostenko.animepedia.presentation.ui.viewmodels.EpisodesViewModel
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import animepedia.android.ihorkostenko.animepedia.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_characters_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class EpisodesFragment : Fragment() {
    companion object {
        fun newInstance() = EpisodesFragment()
    }

    private val episodesViewModel: EpisodesViewModel by viewModel()
    private val episodesRecyclerViewAdapter = EpisodesRecyclerViewAdapter(ArrayList())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listener = object : EpisodesRecyclerViewAdapter.OnItemClickListener {
            override fun onClick(item: Episode) {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse(item.video_url)
                startActivity(openURL)
            }
        }
        episodesRecyclerViewAdapter.setOnItemClickListener(listener)

        recyclerView.adapter = episodesRecyclerViewAdapter
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, LinearLayout.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

        episodesViewModel.init()
        episodesViewModel.episodes.observe(this, Observer<Episodes> { episodes ->
            if (view is RecyclerView) {
                activity?.progressBar?.visibility = View.GONE
                episodes?.episodes?.let { episodesRecyclerViewAdapter.newValue(it) }
            }
        })
    }
}


















































































































































