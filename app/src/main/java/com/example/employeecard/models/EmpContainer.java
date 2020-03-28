package com.example.employeecard.models;



        import androidx.core.util.Pair;

        import com.example.employeecard.R;
        import com.ramotion.expandingcollection.ECCardData;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class EmpContainer {
    private List<ECCardData> dataset;

    public EmpContainer() {
        dataset = new ArrayList<>();
        List<Pair<Integer,String>> skillsAndroid = new ArrayList<>();
        skillsAndroid.add(new Pair<>(8,"UI/UX"));
        skillsAndroid.add(new Pair<>(5,"Android Core"));
        skillsAndroid.add(new Pair<>(5,"Presentation"));
        List<Pair<Integer,String>> skillsIos = new ArrayList<>();
        skillsIos.add(new Pair<>(8,"UI/UX"));
        skillsIos.add(new Pair<>(5,"IOS Core"));
        skillsIos.add(new Pair<>(5,"Presentation"));
        CardData card1 = new CardData(R.drawable.emp_man_img,R.color.android,R.drawable.card_background_android, "Patrick Johannes","Rank 3 Android Developer",skillsAndroid);
        card1.setListItems(mEmpDetailList());
        dataset.add(card1);
        CardData card2 = new CardData(R.drawable.emp_woman_img,R.color.ios,R.drawable.card_backround_ios, "Veronika Zhangalova ","Rank 5 IOS Developer",skillsIos);
        card2.setListItems(mEmpDetailList());
        dataset.add(card2);
        CardData card3 = new CardData(R.drawable.emp_man_img,R.color.front,R.drawable.card_background_front, "Samuel George Claflin","Rank 4 Front End Developer",skillsAndroid);
        card3.setListItems(mEmpDetailList());
        dataset.add(card3);
        CardData card4 = new CardData(R.drawable.emp_woman_img,R.color.back,R.drawable.card_background_back, "Farida Agzamova","Rank 5 Back End Developer",skillsAndroid);
        card4.setListItems(mEmpDetailList());
        dataset.add(card4);
    }

    public List<ECCardData> getDataset() {
        return dataset;
    }

    private List<EmpDetail> mEmpDetailList() {
        return new ArrayList<>(Arrays.asList(
                new EmpDetail(R.drawable.employee_img, "Popova Natalya Aleksandrovna","At work for: 1 year 3 months","Front End Developer",
                        "Visual Design Experience on strong UI/UX.Working knowledge" +
                                " of PhotoshopSketch.Familiarity with browser testing and debugging\n" +
                                "In-depth understanding of the entire web development process (design, development and deployment)\n" +
                                "Understanding of layout aesthetics;","HTML/CSS","Javascript","jQuery","PostgreSql",5,5,4)
        ));
    }
}
