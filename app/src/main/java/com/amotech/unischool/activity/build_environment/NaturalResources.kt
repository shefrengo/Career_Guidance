package com.amotech.unischool.activity.build_environment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amotech.unischool.AppBaseActivity
import com.amotech.unischool.R
import com.amotech.unischool.activity.displayProgramInfoActivity
import com.amotech.unischool.base.BaseRecyclerAdapter
import com.amotech.unischool.databinding.ItemProgramsBinding
import com.amotech.unischool.model.FacultyData

import com.amotech.unischool.utils.extensions.loadImageFromUri
import com.amotech.unischool.utils.extensions.rvItemAnimation

class NaturalResources : AppBaseActivity() {
    private val adapter = getAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_stem_sub_category)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Natural Resources Programs"

        setToolbar(toolbar)
        val recyclerView = findViewById<RecyclerView>(R.id.facultyRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        recyclerView.rvItemAnimation()
        adapter.addItems(programsList())
    }

    private fun programsList(): ArrayList<FacultyData> {
        val programsList = ArrayList<FacultyData>()
        programsList.add(
            FacultyData(
                getString(R.string.built_fishing_and_fisheries),
                getString(R.string.fishing_additional_info),
                "https://i.im.ge/2022/09/30/1cS80F.fisheries.jpg",
                getString(R.string.FishingandFisheriesSciencesandManagement)
            )
        )


        programsList.add(
            FacultyData(
                getString(R.string.built_forestry),
                getString(R.string.forestry_additional_info),
                "https://i.im.ge/2022/09/30/1cSKDX.forestry.jpg",
                getString(R.string.FORESTRY)
            )
        )


        programsList.add(
            FacultyData(
                getString(R.string.built_natural_resources_conservation),
                getString(R.string.natural_resources_conservation_additional_info),
                "https://i.im.ge/2022/09/30/1cSpVD.environmental-conservation.jpg",
                getString(R.string.NATURAlRESOURCESCONSERVATIONANDRESEARCH)
            )
        )

        programsList.add(
            FacultyData(
                getString(R.string.built_nature_resources_management),
                getString(R.string.nature_resources_managemen_additional_info),
                "https://i.im.ge/2022/09/30/1cSBep.natural-resource-management.jpg",
                getString(R.string.NATURALRESOURCESMANAGEMENTANDPOLICY)
            )
        )


        programsList.add(
            FacultyData(
                getString(R.string.built_widlife),
                getString(R.string.wildlife_additional_info),
                "https://i.im.ge/2022/09/30/1cqTLK.wildlife-science.jpg",
                getString(R.string.WILDLIFEANDWILDLANDSSCIENCEMANAGEMENT)
            )
        )



        return programsList
    }

    private fun getAdapter(): BaseRecyclerAdapter<FacultyData, ItemProgramsBinding> {
        return object : BaseRecyclerAdapter<FacultyData, ItemProgramsBinding>() {
            override val layoutResId: Int
                get() = R.layout.item_programs

            override
            fun onBindData(model: FacultyData, position: Int, dataBinding: ItemProgramsBinding) {
                dataBinding.tvFacultyName.text = model.facultyName
                dataBinding.tvProductRate.text = model.facultyInfo
                dataBinding.ivFaculty.loadImageFromUri(model.facultyImage)
            }

            override
            fun onItemClick(
                view: View,
                model: FacultyData,
                position: Int,
                dataBinding: ItemProgramsBinding
            ) {
                opendisplayProgramInfoActivity(model)
            }

            override
            fun onItemLongClick(view: View, model: FacultyData, position: Int) {
            }
        }
    }

    fun opendisplayProgramInfoActivity(model: FacultyData) {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("MySharedPref", MODE_PRIVATE)
        // Creating an Editor object to edit(write to the file)
        val myEdit = sharedPreferences.edit()
        // Storing the key and its value as the data fetched from edittext
        myEdit.putString("selectedProgram", model.facultyName)
        myEdit.putString("nameOfHtmlFile", model.page)
        myEdit.apply()
        val intent = Intent(this, displayProgramInfoActivity::class.java)
        startActivity(intent)
    }
}