package me.johnyoat.hellocast.ui.foryou

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialFadeThrough
import me.johnyoat.hellocast.data.podcastdata.PodcastCuratedList
import me.johnyoat.hellocast.databinding.ForYouFragmentBinding

class ForYouFragment : Fragment() {

    private var _binding: ForYouFragmentBinding? = null

    private val binding get() = _binding!!
    private val viewModel: ForYouViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough ()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ForYouFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.curatedList.observe(viewLifecycleOwner) { curatedList ->
                for (cl: PodcastCuratedList in curatedList) {
                    println(cl.title)
                }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}