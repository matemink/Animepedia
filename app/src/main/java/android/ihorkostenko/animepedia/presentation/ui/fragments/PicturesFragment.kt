package android.ihorkostenko.animepedia.presentation.ui.fragments

import android.ihorkostenko.animepedia.domain.entities.Pictures
import android.ihorkostenko.animepedia.presentation.ui.adapters.PicturesRecyclerViewAdapter
import android.ihorkostenko.animepedia.presentation.ui.viewmodels.PicturesViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import animepedia.android.ihorkostenko.animepedia.R
import kotlinx.android.synthetic.main.fragment_characters_list.*
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class PicturesFragment : Fragment() {
    companion object {
        fun newInstance() = PicturesFragment()
    }

    private val picturesViewModel: PicturesViewModel by viewModel()
    private val picturesRecyclerViewAdapter = PicturesRecyclerViewAdapter(ArrayList())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_pictures_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = picturesRecyclerViewAdapter
        picturesViewModel.init()
        picturesViewModel.pictures.observe(this, Observer<Pictures> { pictures ->
            if (view is RecyclerView) {
                activity?.progressBar?.visibility = View.GONE
                pictures?.pictures?.let { picturesRecyclerViewAdapter.newValue(it) }
            }
        })
    }
}


















































































































































