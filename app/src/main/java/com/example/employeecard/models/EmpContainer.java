package com.example.employeecard.models;

        import com.example.employeecard.R;
        import com.ramotion.expandingcollection.ECCardData;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class EmpContainer {
    private List<ECCardData> dataset;

    public EmpContainer() {
        dataset = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            CardData card = new CardData(R.drawable.employee_img, "Popova Natalya","Visual Design Experience on strong UI/UX.Working knowledge" +
                    " of PhotoshopSketch","Front End Developer  " + (i+1));
            card.setListItems(mEmpDetailList());
            dataset.add(card);
        }
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
