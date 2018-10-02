package android.ihorkostenko.animepedia.presentation.ui.fragments

import android.content.Intent
import android.ihorkostenko.animepedia.domain.entities.VideoEpisode
import android.ihorkostenko.animepedia.domain.entities.Videos
import android.ihorkostenko.animepedia.presentation.ui.adapters.VideosRecyclerViewAdapter
import android.ihorkostenko.animepedia.presentation.ui.viewmodels.VideosViewModel
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

class VideosFragment : Fragment() {
    companion object {
        fun newInstance() = VideosFragment()
    }

    private val videosViewModel: VideosViewModel by viewModel()
    private val videosRecyclerViewAdapter = VideosRecyclerViewAdapter(ArrayList())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_videos_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listener = object : VideosRecyclerViewAdapter.OnItemClickListener {
            override fun onClick(item: VideoEpisode) {
                val openURL = Intent(Intent.ACTION_VIEW)
                openURL.data = Uri.parse(item.url)
                startActivity(openURL)
            }
        }
        videosRecyclerViewAdapter.setOnItemClickListener(listener)
        recyclerView.adapter = videosRecyclerViewAdapter

        videosViewModel.init()
        videosViewModel.videos.observe(this, Observer<Videos> { videos ->
            if (view is RecyclerView) {
                activity?.progressBar?.visibility = View.GONE
                videos?.episodes?.let { videosRecyclerViewAdapter.newValue(it) }
            }
        })
    }
}


















































































































































