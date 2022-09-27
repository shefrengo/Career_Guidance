package com.career.guidance.activity.BusinesHumanitiesEtc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.career.guidance.AppBaseActivity;
import com.career.guidance.R;
import com.career.guidance.activity.STEM.scienceAndMathematicsPrograms;
import com.career.guidance.activity.displayProgramInfoActivity;
import com.career.guidance.base.BaseRecyclerAdapter;
import com.career.guidance.databinding.ItemProgramsBinding;
import com.career.guidance.model.FacultyData;
import com.career.guidance.utils.extensions.AppExtensionsKt;

import java.util.ArrayList;

public class BusinessPrograms  extends AppBaseActivity {
    private final BaseRecyclerAdapter<FacultyData, ItemProgramsBinding> adapter = getAdapter();

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_stem_sub_category);

        setContentView(R.layout.activity_select_stem_sub_category);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Science And Math ");
        ;
        setToolbar(toolbar);
        RecyclerView recyclerView = findViewById(R.id.facultyRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        AppExtensionsKt.rvItemAnimation(recyclerView);
        adapter.addItems(ProgramsList());
        context = BusinessPrograms.this;


    }

    private ArrayList<FacultyData> ProgramsList() {
        ArrayList<FacultyData> programsList = new ArrayList<>();

        programsList.add(new FacultyData(getString(R.string.ACCOUNTANCY), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.ACCOUNTANCYHtml)));
        programsList.add(new FacultyData(getString(R.string.PURCHASINGANDSUPPLY), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.PURCHASINGANDSUPPLYHtml)));
        programsList.add(new FacultyData(getString(R.string.HUMANRESOURCEMANAGEMENT), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.HUMANRESOURCEMANAGEMENTHtml)));
        programsList.add(new FacultyData(getString(R.string.BANKINGANDFINANCE), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.BANKINGANDFINANCEHtml)));
        programsList.add(new FacultyData(getString(R.string.PUBLICPROCUREMENT), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.PUBLICPROCUREMENTHtml)));
        programsList.add(new FacultyData(getString(R.string.PRODUCTIONANDOPERATIONSMANAGEMENT), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.PRODUCTIONANDOPERATIONSMANAGEMENTHtml)));
        programsList.add(new FacultyData(getString(R.string.TRANSPORTANDLOGISTICSMANAGEMENT), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.TRANSPORTANDLOGISTICSMANAGEMENTHtml)));
        programsList.add(new FacultyData(getString(R.string.MARKETING), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.MARKETINGHtml)));
        programsList.add(new FacultyData(getString(R.string.BUSINESSADMINISTRATIONANDMANAGEMENT), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.BUSINESSADMINISTRATIONANDMANAGEMENTHtml)));
        programsList.add(new FacultyData(getString(R.string.BUSINESSOPERATIONSSUPPORTANDASSISTANTSERVICES), getString(R.string.additional_info)
                , "https://i.im.ge/2022/09/25/1mbUtp.ligthGreyimage.jpg", getString(R.string.BUSINESSOPERATIONSSUPPORTANDASSISTANTSERVICESHtml)));
        return programsList;
    }

    private BaseRecyclerAdapter<FacultyData, ItemProgramsBinding> getAdapter() {

        return new BaseRecyclerAdapter<FacultyData, ItemProgramsBinding>() {
            @Override
            public int getLayoutResId() {
                return R.layout.item_programs;
            }

            @Override
            public void onBindData(FacultyData model, int position, ItemProgramsBinding dataBinding) {

                dataBinding.tvFacultyName.setText(model.getFacultyName());
                dataBinding.tvProductRate.setText(model.getFacultyInfo());

                AppExtensionsKt.loadImageFromUri(dataBinding.ivFaculty, model.getFacultyImage());
            }

            @Override
            public void onItemClick(@NonNull View view, FacultyData model, int position, ItemProgramsBinding dataBinding) {

                opendisplayProgramInfoActivity(model);

            }

            @Override
            public void onItemLongClick(@NonNull View view, FacultyData model, int position) {

            }
        };
    }

    public void opendisplayProgramInfoActivity(FacultyData model) {


        SharedPreferences sharedPreferences = context.getSharedPreferences("MySharedPref", MODE_PRIVATE);
// Creating an Editor object to edit(write to the file)
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
// Storing the key and its value as the data fetched from edittext
        myEdit.putString("selectedProgram", model.getFacultyName());
        myEdit.putString("nameOfHtmlFile", model.getPage());
        myEdit.commit();
        Intent intent = new Intent(BusinessPrograms.this, displayProgramInfoActivity.class);
        context.startActivity(intent);
    }


}