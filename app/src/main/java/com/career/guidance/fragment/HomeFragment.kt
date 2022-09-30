package com.career.guidance.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.career.guidance.R
import com.career.guidance.activity.build_environment.SelectProgramActivity
import com.career.guidance.activity.BusinesHumanitiesEtc.BusinessAndHumanitiesSubCategories
import com.career.guidance.activity.LoansAndUniversities.LoansAndUnivertiesActivity
import com.career.guidance.activity.MedicineHealthEtc.MedicineHealthAndVetProgramsActivity
import com.career.guidance.activity.STEM.SelectStemSubCategoryActivity
import com.career.guidance.base.BaseRecyclerAdapter
import com.career.guidance.databinding.LayoutBinding
import com.career.guidance.model.FacultyData
import com.career.guidance.utils.extensions.launchActivity
import com.career.guidance.utils.extensions.loadImageFromUri
import com.career.guidance.utils.extensions.rvItemAnimation
class HomeFragment : Fragment() {

    private var facultyRecyclerView : RecyclerView? = null;
    private val adapter = getAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        facultyRecyclerView = view.findViewById(R.id.facultyRecyclerView)
        setHasOptionsMenu(true)
        facultyRecyclerView!!.layoutManager = LinearLayoutManager(activity)
        facultyRecyclerView!!.setHasFixedSize(true)
        facultyRecyclerView!!.adapter = adapter;
        facultyRecyclerView!!.rvItemAnimation()
        adapter.addItems(facultyData())
        return view;
    }

    private fun facultyData() : ArrayList<FacultyData>{
        val facultyList = ArrayList<FacultyData>()
        facultyList.add(
            FacultyData(
                getString(R.string.MedicineHealthEtcFaculty),
                getString(R.string.medicine_additional_info),
                "https://i.im.ge/2022/09/29/1xARi9.SeekPng-com-thermometer-png-246169.png",
                getString(R.string.medicine_sub)
            )
        )
        facultyList.add(
            FacultyData(
                getString(R.string.STEM_faculty),
                getString(R.string.STEM_faculty_info),
                "https://i.im.ge/2022/09/22/1LeLQ1.stem-programs-icon.png",
                getString(R.string.stem_sub)
            )
        )
        facultyList.add(
            FacultyData(
                getString(R.string.AgricultureBuiltEnvironmentalEtcFaculty),

                getString(R.string.built_environment_faculty_additional_info),

                "https://i.im.ge/2022/09/29/1xEhkW.SeekPng-com-ramas-png-393140.png",
                getString(R.string.agriculture_sub)
            )
        )

        facultyList.add(
            FacultyData(
                getString(R.string.BusinessHumanitiesEtcFaculty),
                getString(R.string.business_additional_info),
               "https://i.im.ge/2022/09/29/1x3bJ8.SeekPng-com-woman-png-64680.png",
                getString(R.string.business_sub)
            )
        )
        facultyList.add(
            FacultyData(
                getString(R.string.LoansAndUniversities),
                getString(R.string.loans_additional_info),
               "https://i.im.ge/2022/09/29/1x38PM.SeekPng-com-graduation-hat-png-46121.png",
                getString(R.string.LoansAndUniversities)
            )
        )
        return  facultyList
    }


    private fun getAdapter(): BaseRecyclerAdapter<FacultyData, LayoutBinding> {

        return object : BaseRecyclerAdapter<FacultyData, LayoutBinding>() {
            override val layoutResId: Int = R.layout.layout

            override fun onBindData(model: FacultyData, position: Int, dataBinding: LayoutBinding) {
                dataBinding.tvFacultyName.text = model.facultyName
                dataBinding.ivFaculty.loadImageFromUri(model.facultyImage);
            }

            override fun onItemClick(
                view: View,
                model: FacultyData,
                position: Int,
                dataBinding: LayoutBinding
            ) {
                when (model.page) {

                    getString(R.string.medicine_sub) -> {
                        activity?.launchActivity<MedicineHealthAndVetProgramsActivity>()
                    }
                    getString(R.string.business_sub) -> {
                        activity?.launchActivity<BusinessAndHumanitiesSubCategories>()
                    }

                    getString(R.string.agriculture_sub) -> {
                        activity?.launchActivity<SelectProgramActivity>()
                    }
                    getString(R.string.stem_sub) -> {
                        activity?.launchActivity<SelectStemSubCategoryActivity>()
                    }
                    getString(R.string.LoansAndUniversities) -> {
                        activity?.launchActivity<LoansAndUnivertiesActivity>()
                    }
                }
            }

            override fun onItemLongClick(view: View, model: FacultyData, position: Int) {
                //implement long click
            }

        }

    }

}