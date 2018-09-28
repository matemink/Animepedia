package android.ihorkostenko.animepedia.presentation.ui.fragments

import android.ihorkostenko.animepedia.domain.entities.Characters
import android.ihorkostenko.animepedia.presentation.ui.adapters.CharactersRecyclerViewAdapter
import android.ihorkostenko.animepedia.presentation.ui.viewmodels.CharactersViewModel
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

class CharactersFragment : Fragment() {
    companion object {
        fun newInstance() = CharactersFragment()
    }

    private val charactersViewModel: CharactersViewModel by viewModel()
    private val charactersRecyclerViewAdapter = CharactersRecyclerViewAdapter(ArrayList())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_characters_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycleView.adapter = charactersRecyclerViewAdapter
        charactersViewModel.init()
        charactersViewModel.characters.observe(this, Observer<Characters> { characters ->
            if (view is RecyclerView) {
                activity?.progressBar?.visibility = View.GONE
                characters?.characters?.let { charactersRecyclerViewAdapter.newValue(it) }
            }
        })
    }
}


















































































































































