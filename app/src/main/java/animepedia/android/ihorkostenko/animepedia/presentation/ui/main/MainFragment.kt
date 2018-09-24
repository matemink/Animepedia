package animepedia.android.ihorkostenko.animepedia.presentation.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import animepedia.android.ihorkostenko.animepedia.R
import animepedia.android.ihorkostenko.animepedia.domain.entities.CharactersAndStaff
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.init()
        viewModel.charactersAndStaff.observe(this, Observer<CharactersAndStaff> { charactersAndStaff -> Toast.makeText(context, charactersAndStaff?.request_hash, Toast.LENGTH_LONG).show() })
    }
}


















































































































































